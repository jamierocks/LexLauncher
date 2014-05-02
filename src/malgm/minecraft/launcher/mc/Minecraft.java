package malgm.minecraft.launcher.mc;

public class Minecraft {
	
	private String directory;
	
	public Minecraft(String directory) {
		// saves directory location
		this.directory = directory;
	}
	
	public void startMinecraft() {
		// code to launch minecraft from the launcher
	}
	
	public void changeDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public String getJarDownload(String mcversion) {
		// gets the url for the jar download of a mc version
		return "http://s3.amazonaws.com/Minecraft.Download/versions/" + mcversion + "/" + mcversion + ".jar";
	}

}
