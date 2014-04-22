package malgm.minecraft.versioninstaller.util;

import java.io.*;
import java.net.URL;
import java.nio.channels.*;

import malgm.minecraft.versioninstaller.settings.SettingsFile;

public class Installer {
	
	SettingsFile settings = new SettingsFile(Utils.getLauncherDirectory().toString());
	
	@SuppressWarnings("resource")
	public void downloadFile(String url, String directory, String filename) throws IOException {
		URL website = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory + "/" + filename);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
	
	public String getModpacksDirectory() {
		if(settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "mcDirectory").equals(settings.defaultDir)) {
			return Utils.getLauncherDirectory().toString() + "modpacks/";
		} else {
			return settings.getSettingsValue(settings.getDefaultDirectory(), settings.getDefaultFileName(), "customDirectory")  + "versions/";
		}
	}

}
