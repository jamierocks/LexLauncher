package malgm.minecraft.versioninstaller.reader;

import javax.xml.parsers.*;

import malgm.minecraft.launcher.Minecraft;

import org.w3c.dom.*;

public class MVIDocumentReader {
	
	// test url - https://dl.dropboxusercontent.com/s/b7cnf5m08fh2g7q/test.xml
	
	private String name = null;
	private String version = null;
	private String mcversion = null;
	private String customJar = null;
	private String filename = null;
	
	private Minecraft mc;
	
	public MVIDocumentReader(Minecraft mc) {
		this.mc = mc;
	}
	
	public void readDoc(String url) {
		try {
			  DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			  DocumentBuilder b = f.newDocumentBuilder();
			  Document doc = b.parse(url);
			  
			  Element ele = doc.getDocumentElement();
			  
			  name = getTextValue(name, ele, "name");
			  version = getTextValue(version, ele, "version");
			  mcversion = getTextValue(mcversion, ele, "mcversion");
			  customJar = getTextValue(customJar, ele, "customJar");
			  filename = getTextValue(filename, ele, "filename");
			} catch (Exception e) {}
	}
	
	public String getName() {
		return name;
	}
	public String getVersion() {
		return version;
	}
	public String getMCVersion() {
		return mcversion;
	}
	public String getFilename() {
		return filename;
	}
	public String getJar() {
		if(!(customJar == "")) {
			return mc.getJarDownload(mcversion);
		}
		return customJar;
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
