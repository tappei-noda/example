package test3.juice.repository;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;



public class Repository {
	
	private List<MetaModulesInfo> metamodulesinfo;
	private MetaModulesInfo metainfo;
	private Map<String, byte[]> map;
	private Map<String,String>  map2;
	private Map<String,MetaModulesInfo> map3;
	
	public Repository(){
		try {
			parseXML();
			test();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	private void parseXML() throws IOException {
		String xml = "/workspace/vitis_example/Vitis-Tutorials/docs/mixing-c-rtl-kernels/reference-files/src/noda/juice/src/test3/JuiceModules.xml";
		try {
			XMLReader reader = null;
			MetaModuleSAXHandler handler = new MetaModuleSAXHandler();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			reader = parser.getXMLReader();
			reader.setContentHandler(handler);	
			reader.parse(xml);
			metamodulesinfo = handler.getList();
			
			} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		}
			}
	
	private void test() throws IOException {
		map = new HashMap<String,byte[]>();
		map2 = new HashMap<String,String>();
		map3 = new HashMap<String,MetaModulesInfo>();
		for(MetaModulesInfo metamodule : metamodulesinfo) {
			metainfo = new MetaModulesInfo();
			byte[] bin = read(metamodule.Path);
			metainfo.Bin = bin;
			metainfo.Library = metamodule.Library;
			map.put(metamodule.Role, bin);
			map2.put(metamodule.Role,metamodule.Path);
			map3.put(metamodule.Role,metainfo);
			metainfo = null;
						}
	//	System.out.println(map.get("execute"));
	}
	
	public byte[] read(String Path) throws IOException{
		    BufferedInputStream file = null;
		try {
			file = new BufferedInputStream(new FileInputStream(Path));
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			int n = file.read(data);
			while(n != -1) {
				out.write(data, 0, n);
				n = file.read(data);
			}
			return out.toByteArray();
				}finally {
					if(file != null) {
						file.close();
					}
				}
  		
		
	}
	public byte[] searchrepo(String role) {
		System.out.println(role);
		return this.map.get(role);
//		return this.map2.get(role);
//		return this.map3.get(role);
	}

	public String searchrepo2(String role){
		System.out.println(role);
		return this.map2.get(role);
}

	public MetaModulesInfo searchrepo3(String role){
		return this.map3.get(role);
}
	
	

}
