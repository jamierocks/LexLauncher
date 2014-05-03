package malgm.minecraft.launcher;

public class Data {
	
	private final int mmlbuild = 1028;
	private final String mmlname = "lexLauncher";
	
	private final String discoverPage = "http://lexware.github.io/discover.html";
	private final String newsPage = "http://lexware.github.io/news.html";
	
	private final String backupDiscoverPage = "res/offlinepages/discover.html";
	private final String backupNewsPage = "res/offlinepages/news.html";
	
	public int getMMLBuild() {
		// gets the current build of lexLauncher (malgms minecraft launcher shortly)
		return mmlbuild;
	}
	
	public String getMMLName() {
		// name of lexLauncher (malgms minecraft launcher shortly)
		return mmlname;
	}
	
	public String getDiscoverPage() {
		// discover page url
		return discoverPage;
	}
	
	public String getNewsPage() {
		// news page url
		return newsPage;
	}

	public String getBackupDiscoverPage() {
		// backup / offline discover page
		return backupDiscoverPage;
	}
	
	public String getBackupNewsPage() {
		// backup / offline discover page
		return backupNewsPage;
	}

}
