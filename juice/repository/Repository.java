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
	private Map<String, byte[]> map;
	
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
		for(MetaModulesInfo metamodule : metamodulesinfo) {
			byte[] bin = read(metamodule.Path);
			map.put(metamodule.Role, bin);
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
	}
	
	

}
