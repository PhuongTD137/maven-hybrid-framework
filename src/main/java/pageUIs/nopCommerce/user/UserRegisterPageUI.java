package pageUIs.nopCommerce.user;

public class UserRegisterPageUI {
	public static final String FIRST_NAME_TEXTBOX = "id=FirstName";
	public static final String LAST_NAME_TEXTBOX = "id=LastName";
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "id=ConfirmPassword";
	public static final String REGISTER_BUTTON = "id=register-button";
	public static final String FIRST_NAME_ERROR_MESSAGE = "Xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "XPath=//span[@id='LastName-error']";
	public static final String REQUIRED_EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
	public static final String EMAIL_ERROR_MESSAGE = "css=div[class*='message-error'] li";
	public static final String PASSWORD_ERROR_MESSAGE = "id=Password-error";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE = "id=ConfirmPassword-error";
	public static final String SUCCESS_MESSAGE = "Classname=result";
	public static final String CONTINUE_BUTTON = "xpath=//div/a[contains(@class, 'register-continue-button')]";
}
