package pageUIs.jquery.dataTable;

public class HomePageUI {
	public static final String DYNAMIC_PAGINATION_NUMBER = "xpath=//li[@class='qgrd-pagination-page'][%s]";
	public static final String DYNAMIC_ACTIVE_PAGINATION_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_SEARCH_TEXTBOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String DYNAMIC_ROW = "xpath=//tr[%s]";
	public static final String ROW_EACH_PAGE = "xpath=//tr";
	public static final String DYNAMIC_COLUMN = "xpath=//tr/td[@data-key='%s']";

	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String LOAD_BUTTON = "css=button#load";
	public static final String DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";

	public static final String ICON_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]//button[@title='%s']";
	// public static final String ICON_COLUMN_INDEX = "xpath=//tr/th";
}
