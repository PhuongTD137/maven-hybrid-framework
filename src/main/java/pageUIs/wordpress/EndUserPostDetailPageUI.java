package pageUIs.wordpress;

public class EndUserPostDetailPageUI {
	public static final String POST_TITLE = "xpath=//h1[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//h1[text()='%s']/parent::header//a[text()='%s']";
	public static final String POSTED_DATE_BY_POST_TITLE = "xpath=//h1[text()='%s']/parent::header//a/time[text()='%s']";
	public static final String POST_BODY_BY_POST_TITLE = "xpath=//h1[text()='%s']/parent::header/following-sibling::div//p[text()='%s']";
}
