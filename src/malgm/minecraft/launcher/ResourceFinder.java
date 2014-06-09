package malgm.minecraft.launcher;

public class ResourceFinder {

	private String folder = "";

	private final String icon = "icon.png";
	private final String icon_title = "icon_title.png";
	private final String close = "close.png";
	private final String minimize = "minimize.png";
	private final String background = "background.png";
	private final String logo = "logo.png";
	private final String downTriangle = "downTriangle.png";
	private final String upTriangle = "upTriangle.png";
	private final String optionsCog = "optionsCog.png";
	private final String advertisement = "ad.png";
	private final String add = "add_button.png";
	private final String remove = "remove_button.png";
	private final String maximize = "maximize.png";
	private final String shrink = "shrink.png";
	private final String smallLogo = "smallLogo.png";

	public ResourceFinder() {
		changeFolder("res/");
	}

	public ResourceFinder(String folder) {
		changeFolder(folder);
	}

	public String icon() {
		return getResource(icon);
	}

	public String icon_title() {
		return getResource(icon_title);
	}

	public String close() {
		return getResource(close);
	}

	public String minimize() {
		return getResource(minimize);
	}

	public String background() {
		return getResource(background);
	}

	public String logo() {
		return getResource(logo);
	}

	public String downTriangle() {
		return getResource(downTriangle);
	}

	public String upTriangle() {
		return getResource(upTriangle);
	}

	public String optionsCog() {
		return getResource(optionsCog);
	}

	public String advertisment() {
		return getResource(advertisement);
	}

	public String add() {
		return getResource(add);
	}

	public String remove() {
		return getResource(remove);
	}

	public String maximize() {
		return getResource(maximize);
	}

	public String shrink() {
		return getResource(shrink);
	}

	public String smallLogo() {
		return getResource(smallLogo);
	}

	public String getResource(String value) {
		return folder + value;
	}

	public String getFolder() {
		return folder;
	}

	public void changeFolder(String folder) {
		this.folder = folder;
	}

}