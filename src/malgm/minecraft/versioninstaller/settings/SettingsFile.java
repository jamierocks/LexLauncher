package malgm.minecraft.versioninstaller.settings;

public class SettingsFile extends malgm.mvi.api.SettingsFile {
	
	private String userhome = System.getProperty("user.home");
	
	public SettingsFile(String directory) {
		super(directory);
	}
	
	@Override
	public void writeDefaults(String dir, String filename) {
		this.writeToSettingsFile(dir, filename, "mcDirectory", "Default Minecraft Directory");
	}

	@Override
	public String getDefaultFileName() {
		return "config.properties";
	}
	
	@Override
	public String getDefaultDirectory() {
		return userhome + super.getDefaultDirectory();
	}

}
