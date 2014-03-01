package malgm.minecraft.versioninstaller;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class HackedClientListReader {
	
	private String resilience = null;
	private String huzuni = null;
	
	public void readDoc() {
		try {
			  DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			  DocumentBuilder b = f.newDocumentBuilder();
			  Document doc = b.parse("https://dl.dropbox.com/s/bkwu6sn84pt66l7/hackedClients.xml");
			  
			  Element ele = doc.getDocumentElement();
			  
			  resilience = getTextValue(resilience, ele, "resilience");
			  huzuni = getTextValue(huzuni, ele, "huzuni");
			} catch (Exception e) {}
	}
	
	public String getResilience() {
		return resilience;
	}
	public String getHuzuni() {
		return huzuni;
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
