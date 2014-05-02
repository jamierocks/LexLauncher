package malgm.minecraft.launcher.mc;

public class Minecraft {
	
	private String directory = null;
	
	public Minecraft(String directory) {
		// saves directory location
		this.directory = directory;
	}
	
	public void startMinecraft() {
		
	}
	
	public void changeDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public String getJarDownload(String mcversion) {
		return "http://s3.amazonaws.com/Minecraft.Download/versions/" + mcversion + "/" + mcversion + ".jar";
	}

}
