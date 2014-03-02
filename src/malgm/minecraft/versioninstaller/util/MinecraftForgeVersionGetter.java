package malgm.minecraft.versioninstaller.util;

import malgm.minecraft.versioninstaller.settings.MinecraftForge;

public class MinecraftForgeVersionGetter {
	
	private String part1 = null;
	private String part2 = null;
	
	private MinecraftForge forge = new MinecraftForge();
	
	public String getURL(String version) {
			
		part1 = forge.getProperty("mcfpart1");
		part2 = forge.getProperty("mcfpart2");
		
		return part1 + version + "/" + version + part2;
	}

}
