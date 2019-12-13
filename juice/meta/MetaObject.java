package test3.juice.meta;

import test3.juice.core.*;

public class MetaObject {
	
	private MetaObjectManager metaobjectmanager = null;
	private Role role = null;
	
	
	public MetaObject() {
		
	}

	public void setup(Role role, MetaObjectManager metaobjectmanager){
		
		this.metaobjectmanager = metaobjectmanager;
		this.role = role;
		setup();
		
			}
	
	protected void setup() {
		
	}
	
	public MetaObjectManager getmetaobjectmanager() {
		
		return metaobjectmanager;
	}
}
