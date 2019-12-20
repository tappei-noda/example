package test3.juice.core;

import test3.juice.repository.*;
import java.util.List;
import java.util.ArrayList;

public class JuiceKernel {
	
	private Repository rep = new Repository();
	private List<MetaObjectManager> list = new ArrayList<>();

	
public MetaObjectManager createmetaobjectmanager() {
	
	MetaObjectManager  metaobjectmanager = new MetaObjectManager(this);
	list.add(metaobjectmanager);
	
	return metaobjectmanager;
	
	}

public byte[] search(String role) {
	return rep.searchrepo(role);
    }
public String search2(String role){
	return rep.searchrepo2(role);
	}
public MetaModulesInfo search3(String role){
	return rep.searchrepo3(role);
	}
}
