#include<iostream>
#include"header.h"
int main(void){
	
	const char* filename = "/workspace/vitis_example/Vitis-Tutorials/docs/mixing-c-rtl-kernels/reference-files/run6/krnl_sadd.sw_emu.xilinx_u200_xdma_201830_2.xclbin";	

	int x = add(5,4,filename,filename2);
	std::cout << x <<std::endl;
	return 0;

}

