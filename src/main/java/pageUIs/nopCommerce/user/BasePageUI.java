package pageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String CUSTOMER_INFOR_LINK = "XPATH=//div[@class='side-2']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "Xpath=//div[@class='side-2']//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPath//div[@class='side-2']//a[text()='My product reviews']";
	public static final String REWARD_POINTS_LINK = "xpath=//div[@class='side-2']//a[text()='Reward points']";
	public static String DYNAMIC_LINK_AT_MY_ACCOUNT_PAGE = "xpath=//div[@class='side-2']//a[text()='%s']";
	public static final String USER_LOGOUT_LINK = "CSS=a.ico-logout";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String AJAX_BUSY_ICON = "ID=ajaxBusy";

	// Pattern Object
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";

}
