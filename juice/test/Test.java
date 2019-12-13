package test3.juice.test;

import test3.juice.core.JuiceKernel;
import test3.juice.core.MetaObjectManager;
import test3.juice.core.Role;

public class Test {

	public static void main(String[] args) {
		new Test().testMetaObjMgr();

	}
	private void testMetaObjMgr() {
		JuiceKernel kernel = new JuiceKernel();
		MetaObjectManager metaObjMgr= kernel.createmetaobjectmanager();
		Role role = new Role();
		role.role = "Fpgaload ";
		
		metaObjMgr.loadmetaobject(role,"test3.juice.meta.FpgaLoader");
		
	//	System.out.println("1111");
	}
}
