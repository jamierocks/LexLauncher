package malgm.minecraft.versioninstaller;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MVIDocumentReader {
	
	private String name = null;
	private String version = null;
	private String jar = null;
	private String json = null;
	
	public void readDoc(String url) {
		try {
			  DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			  DocumentBuilder b = f.newDocumentBuilder();
			  Document doc = b.parse(url);
			  
			  Element ele = doc.getDocumentElement();
			  
			  name = getTextValue(name, ele, "name");
			  version = getTextValue(version, ele, "version");
			  jar = getTextValue(jar, ele, "jar");
			  json = getTextValue(json, ele, "json");
			} catch (Exception e) {}
	}
	
	public String getName() {
		return name;
	}
	public String getVersion() {
		return version;
	}
	public String getJar() {
		return jar;
	}
	public String getJson() {
		return json;
	}
	
	private String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}

}
