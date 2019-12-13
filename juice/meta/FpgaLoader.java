package juice.meta;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import juice.core.*;

public class FpgaLoader extends MetaObject{
	
	private MetaObjectManager metaobjectmanager;
	private byte[] stream ;
//	private String stream;
	
	public FpgaLoader() {
		}
	@Override
	public void setup() {
		
		metaobjectmanager = this.getmetaobjectmanager();
		getstream();
		outputstream();
		
		}
	
	public void getstream() {
		stream = metaobjectmanager.loadstream();
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
