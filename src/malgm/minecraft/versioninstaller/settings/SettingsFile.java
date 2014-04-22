package malgm.minecraft.versioninstaller.settings;

public class SettingsFile extends malgm.mvi.api.SettingsFile {
	
	public final String defaultDir = "Default Directoty";
	public final String customDir = "Custom Directoty";
	
	public SettingsFile(String directory) {
		super(directory);
	}

	@Override
	public void writeDefaults(String dir, String filename) {
		this.writeToSettingsFile(dir, filename, "mcDirectory", defaultDir);
	}

	@Override
	public String getDefaultFileName() {
		return "config.properties";
	}

}
