package malgm.minecraft.launcher;

public class Minecraft {
	
	private String directory = null;
	
	public Minecraft(String directory) {
		this.directory = directory;
		System.out.println(this.directory);
	}
	
	public void startMinecraft() {
		
	}
	
	public void changeDirectory(String directory) {
		this.directory = directory;
	}

}
