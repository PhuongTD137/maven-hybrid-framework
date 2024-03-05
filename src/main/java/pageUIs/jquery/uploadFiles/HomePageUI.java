package pageUIs.jquery.uploadFiles;

public class HomePageUI {
	public static final String FILE_NAME_LOADED = "xpath=//table//p[@class='name' and text()='%s']";
	public static final String FILE_NAME_UPLOADED_LINK = "xpath=//table//a[text()='%s']";
	public static final String START_BUTTON_TOTAL = "xpath=//table//button[contains(@class,'start')]";
	public static final String START_BUTTON_INDEX = "xpath=//table//button[contains(@class,'start')][%s]";
	public static final String FILE_NAME_UPLOADED_IMAGE = "xpath=//table//img[contains(@src,'%s')]";
}
