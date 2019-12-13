package test3.juice.core;

import java.nio.ByteBuffer;
import java.util.HashMap;
import test3.juice.meta.*;

public class ConfigManager {
	
//	private HashMap<String,String> map;
	private String role = "add" ;
	private JuiceKernel kernel;
//	private final HashMap<String,byte[]> stream = new HashMap<>();
//	byte[] bytes ;
	//byte[] bytes = ByteBuffer.allocate(4).putInt(1695609641).array();
	

	public ConfigManager(JuiceKernel kernel) {
		this.kernel = kernel;
	//	stream.put("encryption",bytes);
	//	byte[] hara = stream.get("encryption");
	//	System.out.println("hello");
			}
	
	public synchronized MetaObject loadmetaobject(Role role, String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		MetaObject newmetaobject;
		
		System.out.println(role.role  +  "is loaded.");
		newmetaobject = createmetaobject(name);
		
		return newmetaobject;
		
		
	}

	public MetaObject createmetaobject(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Class<? extends MetaObject> clazz = (Class<? extends MetaObject>) Class.forName(name);
		
		MetaObject newmetaobject = clazz.newInstance();
		
		return newmetaobject;
		
	}

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
