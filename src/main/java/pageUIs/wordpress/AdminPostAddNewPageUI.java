package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "xpath=//h1[@aria-label='Add title']";
	public static final String BODY_AREA = "css=p.block-editor-default-block-appender__content";
	public static final String BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PRE_PUBLISH_OR_UPDATE_BUTTON = "css=button[class*='editor-post-publish-button']";
	public static final String PUBLISH_BUTTON = "xpath=//button[contains(@class,'editor-post-publish-button') and not(@aria-expanded='true')]";
	public static final String POST_PUBLISHED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
