package malgm.minecraft.launcher.mc;

public class Modpack {
	
	private String name;
	
	public Modpack(String name, String versionsURL) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean hasRecommendedUpdate() {
		return false;
	}

}
