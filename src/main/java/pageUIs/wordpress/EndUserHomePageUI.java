package pageUIs.wordpress;

public class EndUserHomePageUI {
	public static final String POST_TITLE = "xpath=//h2/a[text()='%s']";
	public static final String POST_AUTHOR_BY_POST_TITLE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//span/a[text()='%s']";
	public static final String POSTED_DATE_BY_POST_TITLE = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_BY_POST_TITLE = "xpath=//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String SEARCH_TEXTBOX = "css=input.wp-block-search__input";
	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";
}
