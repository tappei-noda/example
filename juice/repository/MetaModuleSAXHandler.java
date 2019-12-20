package test3.juice.repository;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;



public class MetaModuleSAXHandler extends DefaultHandler{
	private	String element ;
	private MetaModulesInfo metainfo ;
	private List<MetaModulesInfo> metamoduleslist = new ArrayList<MetaModulesInfo>();

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		element = qName;
		if(qName.equals("Module")) {
			metainfo = new MetaModulesInfo();
		}
		
	}
	
	public void characters(char[] ch, int offset, int lenght) {
		String text = new String(ch,offset,lenght);
		
		if("PATH".equals(element)) {
			metainfo.Path = text;
		}
		else if("LIBRARY".equals(element)){
			metainfo.Library = text;
		}
		else if("FQCN".equals(element)) {
			metainfo.Fqcn = text;
		}
		else if("ROLE".equals(element)){
			metainfo.Role = text;
		}
		else if("FEATURE".equals(element)) {
			metainfo.Feature = text;
		}
	}
	
	public void endElement(String uri, String locallName, String qName) {
		element = null;
		if(qName.equals("Module")) {
			metamoduleslist.add(metainfo);
			metainfo = null;
		}
	}
	
	public List<MetaModulesInfo> getList() {
		return this.metamoduleslist;
		}
    }
