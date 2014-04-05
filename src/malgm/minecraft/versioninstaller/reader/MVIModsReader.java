package malgm.minecraft.versioninstaller.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MVIModsReader {
	
	private JSONParser parser = new JSONParser();
	
	private String[] array = null;
	
	@SuppressWarnings("unchecked")
	public void readDoc(String url) throws FileNotFoundException, IOException, ParseException {
		
		Object obj = parser.parse(new FileReader(url));
		
		JSONObject jsonObject = (JSONObject) obj;
		
		// loop array
		JSONArray msg = (JSONArray) jsonObject.get("mods");
		Iterator<String> iterator = msg.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			array[i] = (iterator.next());
			i++;
		}
		
	}
	
	public String[] getArray() {
		return array;
	}

}
