package malgm.minecraft.versioninstaller.ui.modslist;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ModsListUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JSONParser parser = new JSONParser();
	
	private String[] modslist = null, urllist = null;
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem help;
	
	public ModsListUI() {
		init();
	}
	
	public void init() {
		setLayout(new FlowLayout());
		
		// init menu bar
		menuBar = new JMenuBar();
		
		// init file on menu bar
		file = new JMenu("File");
		menuBar.add(file);
		
		// init help under file on menu bar
		help = new JMenuItem("Help");
		help.addActionListener(this);
		file.add(help);
		
		ModsListContainer c = new ModsListContainer();
		
		setJMenuBar(menuBar);
		add(c);
	}

	public String[] getModsList(String url) throws ParseException {
		JSONArray results = null;
		JSONObject json = (JSONObject) parser.parse(url);
		
		results = (JSONArray) json.get("mods");

	    for (int i = 0; i < ((CharSequence) results).length(); i++) {
	    	JSONObject childJSONObject = (JSONObject) results.get(i);
	        modslist[i] += childJSONObject.get("name");
	    }
		
		return modslist;
	}
	
	public String[] getURLList(String url) throws ParseException {
		JSONArray results = null;
		JSONObject json = (JSONObject) parser.parse(url);
		
		results = (JSONArray) json.get("mods");

	    for (int i = 0; i < ((CharSequence) results).length(); i++) {
	    	JSONObject childJSONObject = (JSONObject) results.get(i);
	        urllist[i] += childJSONObject.get("url");
	    }
		
		return urllist;
	}
	
	public String[] getFilename(String url) throws ParseException {
		JSONArray results = null;
		JSONObject json = (JSONObject) parser.parse(url);
		
		results = (JSONArray) json.get("mods");

	    for (int i = 0; i < ((CharSequence) results).length(); i++) {
	    	JSONObject childJSONObject = (JSONObject) results.get(i);
	        urllist[i] += childJSONObject.get("filename");
	    }
		
		return urllist;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == this.help) {
			HelpUI helpui = new HelpUI();
			
			helpui.setTitle("Help");
			helpui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			helpui.setSize(200, 300);
			helpui.setResizable(false);
			helpui.setVisible(true);
		}
	}
}
