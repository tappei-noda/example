package test3.juice.meta;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import test3.juice.core.*;

public class FpgaLoader extends MetaObject{
	
	private MetaObjectManager metaobjectmanager;
	private byte[] stream ;
	private String stream2;
	
	public FpgaLoader() {
		}
	@Override
	public void setup() {
		
		metaobjectmanager = this.getmetaobjectmanager();
		getstream();
		getstream2();
//		outputstream();
		outputstream2();
		
		}
	
	public void getstream() {
		stream = metaobjectmanager.loadstream();
			}
	public void getstream2(){
		stream2 = metaobjectmanager.loadstream2();
		System.out.println(stream2);	
}
	public void outputstream2(){
		int x = jnatest.INSTANCE.add(stream);
		System.out.println(x);
		
}
	
	
	public void outputstream() {
			try {
			BufferedOutputStream file = new BufferedOutputStream
			(new FileOutputStream
			("/workspace/vitis_example/Vitis-Tutorials/docs/mixing-c-rtl-kernels/reference-files/run5/krnl_sadd.sw_emu.xilinx_u200_xdma_201830_5.xclbin"));
		    file.write(stream);
		    file.flush();
		    file.close();
		    System.out.println(stream);
	}catch(IOException e){
		e.printStackTrace();
		
		}
		
	}

}
