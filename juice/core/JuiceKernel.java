package juice.core;

import juice.repository.Repository;
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
}