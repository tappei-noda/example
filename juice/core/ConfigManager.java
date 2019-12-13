package juice.core;

import java.nio.ByteBuffer;
import java.util.HashMap;
import juice.meta.*;

public class ConfigManager {
	
//	private HashMap<String,String> map;
	private String role = "communicate1" ;
	private JuiceKernel kernel;
//	private final HashMap<String,byte[]> stream = new HashMap<>();
//	byte[] bytes ;
	//byte[] bytes = ByteBuffer.allocate(4).putInt(1695609641).array();
	
	//ビットストリームを他のディレクトリから取ってくることが可能なのであればここは消す
	public ConfigManager(JuiceKernel kernel) {
		this.kernel = kernel;
	//	stream.put("encryption",bytes);
	//	byte[] hara = stream.get("encryption");
	//	System.out.println("hello");
			}
	//メタオブジェクトをロードするメソッド　クリエートメソッドを呼ぶ
	public synchronized MetaObject loadmetaobject(Role role, String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		MetaObject newmetaobject;
		
		System.out.println(role.role  +  "is loaded.");
		newmetaobject = createmetaobject(name);
		
		return newmetaobject;
		
		
	}
	//実際にメタオブジェクトを作る
	public MetaObject createmetaobject(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class<? extends MetaObject> clazz = (Class<? extends MetaObject>) Class.forName(name);
		
		MetaObject newmetaobject = clazz.newInstance();
		
		return newmetaobject;
		
	}
	//fpga回路をロードするメソッドkernelのsearchメソッドの返り値を返す
	public byte[] outstream() {
		return	kernel.search(role);	
	}
	
/*	public byte[] outstream() {
		
		byte[] stream = this.stream.get("encryption");
	//	System.out.println(stream);
		
		return stream;
		
	}
*/
}
