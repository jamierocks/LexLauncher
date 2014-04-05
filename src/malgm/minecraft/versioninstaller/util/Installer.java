package malgm.minecraft.versioninstaller.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import malgm.minecraft.versioninstaller.settings.SettingsFile;

public class Installer {
	
	SettingsFile settings = new SettingsFile();
	
	@SuppressWarnings("resource")
	public void downloadJar(String directory, String downloadFile, String fileName) throws IOException {
		URL website = new URL(downloadFile);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory + fileName + "/" + fileName + ".jar");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
	
	@SuppressWarnings("resource")
	public void downloadJson(String directory, String downloadFile, String fileName) throws IOException {
		URL website = new URL(downloadFile);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(directory + fileName + "/" + fileName + ".json");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
	
	public String getDirectory() {
		if(settings.getSettingsValue(settings.getDefaultConfigFile(), "mcDirectory").equals("Default Minecraft Directory")) {
			return Utils.getMinecraftDirectory().toString();
		} else {
			return settings.getSettingsValue(settings.getDefaultConfigFile(), "customDirectory");
		}
	}

}
