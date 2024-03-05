package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//h1/following-sibling::a[text()='Add New Post']";
	public static final String SEARCH_TEXTBOX = "name=s";
	public static final String SEARCH_BUTTON = "id=search-submit";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//tbody/tr/*[%s]//a[text()='%s']";
	public static final String CHECKBOX_BY_POST_TITLE = "xpath=//tbody//a[text()='%s']/ancestor::td/preceding-sibling::th/input";
	public static final String ACTION_DROP_DOWN = "name=action";
	public static final String APPLY_BUTTON = "id=doaction";
	public static final String ACTION_MESSAGE = "xpath=//div[@id='message']/p[text()='%s']";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//tbody/tr/td[text()='%s']";
}
