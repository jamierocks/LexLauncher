package malgm.minecraft.launcher;

public class Minecraft {
	
	private String directory = null;
	
	public Minecraft(String directory) {
		// saves directory location to be used latter
		this.directory = directory;
		System.out.println(this.directory);
	}
	
	public void startMinecraft() {
		
	}
	
	public void changeDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getJarDownload(String mcversion) {
		return "http://s3.amazonaws.com/Minecraft.Download/versions/" + mcversion + "/" + mcversion + ".jar";
	}

}
