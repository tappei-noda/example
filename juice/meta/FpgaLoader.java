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
//		getstream();
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
		int x = jnatest.INSTANCE.add(8,9,stream2);
		System.out.println(x);
		
}
	
	
	public void outputstream() {
			try {
			BufferedOutputStream file = new BufferedOutputStream
			(new FileOutputStream
			("/Users/noda/Downloads/jiken2t6/week2/system1/example.bit"));
		    file.write(stream);
		    file.flush();
		    file.close();
		    System.out.println(stream);
	}catch(IOException e){
		e.printStackTrace();
		
		}
		
	}

}
