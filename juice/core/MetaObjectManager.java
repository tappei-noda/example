package test3.juice.core;

import test3.juice.meta.*;
public class MetaObjectManager {
	private ConfigManager configmanager;
//	private byte[] stream;
	private JuiceKernel kernel;
//	private byte[] stream;
	
	public MetaObjectManager(JuiceKernel kernel) {
		this.kernel = kernel;
		configmanager = new ConfigManager(kernel);
		
	}
	
	public void loadmetaobject(final Role role, final String name) {
		Thread t = new Thread() {
			public void run() {
			try {
				MetaObject newmeta = configmanager.loadmetaobject(role,name);
				newmeta.setup(role,MetaObjectManager.this);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
				e.printStackTrace();
			}
		 }
			
		};
		t.start();
	}
	public byte[] loadstream() {
	//	stream = configmanager.outstream();
		return configmanager.outstream();
		
	}
/*	public byte[] loadstream() {
		 stream = configmanager.outstream();
		return stream;
	}
	*/	
	
}
