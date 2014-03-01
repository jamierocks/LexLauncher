package malgm.minecraft.versioninstaller.reader;

public class MinecraftForgeVersionGetter {
	
	public String getURL(String version) {
		return "http://files.minecraftforge.net/maven/net/minecraftforge/forge/" + version + "/" + version + "-universal.jar";
	}

}
