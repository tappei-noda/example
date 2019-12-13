package juice.test;

import juice.core.JuiceKernel;
import juice.core.MetaObjectManager;
import juice.core.Role;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Test().testMetaObjMgr();

	}
	private void testMetaObjMgr() {
		JuiceKernel kernel = new JuiceKernel();
		MetaObjectManager metaObjMgr= kernel.createmetaobjectmanager();
		Role role = new Role();
		role.role = "Fpgaload ";
		
		metaObjMgr.loadmetaobject(role,"juice.meta.FpgaLoader");
		
	//	System.out.println("1111");
	}
}
