package test3.juice.meta;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface jnatest extends Library{

	jnatest INSTANCE = (jnatest)Native.loadLibrary("/workspace/vitis_example/Vitis-Tutorials/docs/mixing-c-rtl-kernels/reference-files/src/noda/libnative1.so",jnatest.class);

		int add(int x, int y, String file);

	}
