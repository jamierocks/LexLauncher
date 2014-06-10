package malgm.minecraft.launcher.settings;

public class SettingsFile extends malgm.minecraft.launcher.api.SettingsFile {

	public final String defaultDir = "Default Directory";
	public final String customDir = "Custom Directory";

	public SettingsFile(String directory) {
		super(directory);
	}

	@Override
	public void writeDefaults(String dir, String filename) {
		this.writeToSettingsFile(dir, filename, "mcDirectory", defaultDir);
		this.writeToSettingsFile(dir, filename, "useSystemProxy", "true");
	}

	@Override
	public String getDefaultFileName() {
		return "config.properties";
	}

}
