package malgm.minecraft.versioninstaller.reader;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class ModslistReader {
	private String[] infoURLs = null;
	
	public ModslistReader(String url) throws Exception {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(url);
		  
		NodeList nList = doc.getElementsByTagName("mod");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String infoURL = eElement.getAttribute("url");
				
				infoURLs[temp] = infoURL;
			}
		}
	}
	
	public String[] getInfoURLs() {
		return infoURLs;
	}

}
