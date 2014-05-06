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
		return getValue(icon);
	}
	
	public String icon_title() {
		return getValue(icon_title);
	}
	
	public String close() {
		return getValue(close);
	}
	
	public String minimize() {
		return getValue(minimize);
	}
	
	public String background() {
		return getValue(background);
	}
	
	public String logo() {
		return getValue(logo);
	}
	
	public String downTriangle() {
		return getValue(downTriangle);
	}
	
	public String upTriangle() {
		return getValue(upTriangle);
	}
	
	public String optionsCog() {
		return getValue(optionsCog);
	}
	
	public String advertisment() {
		return getValue(advertisement);
	}
	
	public String add() {
		return getValue(add);
	}
	
	public String remove() {
		return getValue(remove);
	}
	
	public String maximize() {
		return getValue(maximize);
	}
	
	public String shrink() {
		return getValue(shrink);
	}
	
	public String smallLogo() {
		return getValue(smallLogo);
	}
	
	public String getResource(String value) {
		return getValue(value);
	}
	
	private String getValue(String value) {
		return folder + value;
	}
	
	public String getFolder() {
		return folder;
	}
	
	public void changeFolder(String folder) {
		this.folder = folder;
	}

}