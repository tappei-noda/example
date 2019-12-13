#######################################################################################
.PHONY: help
help:
	@echo "Makefile Usage:"
	@echo "  make all TARGET=<sw_emu/hw_emu/hw> DEVICE=<FPGA platform>"
	@echo "      Command to generate the design for specified Target and Device."
	@echo ""
	@echo "  make exe "
	@echo "      Command to generate host."
	@echo ""
	@echo "  make xclbin "
	@echo "      Command to generate hardware platform files(xo,xclbin)."
	@echo ""
	@echo "  make clean "
	@echo "      Command to remove the generated files."
	@echo ""
#######################################################################################
TARGET := sw_emu
DEVICE := xilinx_u200_xdma_201830_2
EXECUTABLE := host
XO := krnl_sadd.$(TARGET).$(DEVICE).xo
XCLBIN := krnl_sadd.$(TARGET).$(DEVICE).xclbin
SRCDIR := /workspace/vitis_example/Vitis-Tutorials/docs/mixing-c-rtl-kernels/reference-files/src
LIBRARY := $(SRCDIR)/noda/libnative.so
# Host building global settings
CXXFLAGS := -I$(XILINX_XRT)/include/ -I$(XILINX_VIVADO)/include/ -Wall -O0 -g -std=c++11 -L$(XILINX_XRT)/lib/ -lOpenCL -lpthread -lrt -lstdc++
CXXFLAGS2 := -lOpenCL

# Kernel compiler & linker global settings
CLFLAGS := -t $(TARGET) --config design.cfg
LDCLFLAGS := -t $(TARGET) --config design.cfg

all: $(EXECUTABLE) $(XO) $(XCLBIN) emconfig

exe: $(EXECUTABLE)

lib: $(LIBRARY) $(XO) $(XCLBIN)

xclbin: $(XO) $(XCLBIN)

# Building kernel
$(XO): ../src/kernel_cpp/krnl_sadd.cpp
	v++ $(CLFLAGS) -c -k krnl_sadd -I'$(<D)' -o'$@' '$<'
$(XCLBIN): krnl_sadd.$(TARGET).$(DEVICE).xo
	v++ $(LDCLFLAGS) -l -o'$@' $(+)

# Building Host
#$(EXECUTABLE): ../src/host/main.cpp ../src/host/host_step3.cpp
#	g++ $(CXXFLAGS) -o '$@' ../src/host/main.cpp ../src/host/host_step3.cpp $(CXXFLAGS2)

$(LIBRARY): ../src/host/host_step3.cpp
	g++ -shared -fPIC $(CXXFLAGS) ../src/host/host_step3.cpp -o '$@'

$(EXECUTABLE):
	g++ $(CXXFLAGS) ../src/host/main.cpp $(LIBRARY) -o '$@'

.PHONY: emconfig
emconfig:
	emconfigutil --platform $(DEVICE)

.PHONY: run
run: all
ifeq ($(TARGET),$(filter $(TARGET),sw_emu hw_emu))
	XCL_EMULATION_MODE=$(TARGET) ./$(EXECUTABLE) $(XCLBIN)
else
	./$(EXECUTABLE) $(XCLBIN)
endif

# Cleaning stuff
.PHONY: clean
clean:
	rm -f $(EXECUTABLE) *krnl_sadd.$(TARGET).$(DEVICE).* *.log *.json *.xo
