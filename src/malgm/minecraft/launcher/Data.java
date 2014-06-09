package malgm.minecraft.launcher;

public class Data {

	private static final int mmlbuild = 1029;
	private static final String mmlname = "lexLauncher";

	private final static String discoverPage = "http://lexware.github.io/discover.html";
	private final static String newsPage = "http://lexware.github.io/news.html";

	private final static String website = "http://lexware.github.io/";


	public static int getMMLBuild() {
		// gets the current build of lexLauncher
		return mmlbuild;
	}

	public static String getMMLName() {
		// name of lexLauncher
		return mmlname;
	}

	public static String getDiscoverPage() {
		// discover page url
		return discoverPage;
	}

	public static String getNewsPage() {
		// news page url
		return newsPage;
	}

	public static String getWebsite() {
		// website URL
		return website;
	}

}
