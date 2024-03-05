package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.EndUserHomePO;
import pageObjects.wordpress.EndUserPostDetailPO;
import pageObjects.wordpress.EndUserSearchPostPO;
import pageObjects.wordpress.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private EndUserHomePO userHomePage;
	private EndUserPostDetailPO userPostDetailPage;
	private EndUserSearchPostPO userSearchPostPage;

	private String userName = "automationtesting";
	private String password = "automationtesting";
	private String postSearchPageUrl;
	private int randomNumber = getRandomNumber();
	private String postTitle = "Live Coding Title " + randomNumber;
	private String postBody = "Live Coding Body " + randomNumber;
	private String authorName = "Automation Admin";
	private String urlAdmin, urlUser;
	private String currentDay = getCurrentDay();
	private String editedPostTitle = "Edited Live Coding Title " + randomNumber;
	private String editedPostBody = "Edited Live Coding Body " + randomNumber;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		driver = getBrowserDriver(browserName, urlAdmin);
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminLoginPage.inputToUserNameTextbox(userName);

		adminLoginPage.inputToPasswordTextbox(password);

		adminDashboardPage = adminLoginPage.clickLogInButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create new post - Step 01: Click 'Post' icon");
		adminPostSearchPage = adminDashboardPage.clickPostIcon();

		log.info("Create new post - Step 02: Get 'Post Search' page Url");
		postSearchPageUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Create new post - Step 03: Click 'Add new' button");
		adminPostAddNewPage = adminPostSearchPage.clickAddNewPostButton();

		log.info("Create new post - Step 04: Input to 'Title' textbox");
		adminPostAddNewPage.inputToTitleTextbox(postTitle);

		log.info("Create new post - Step 05: Input to 'Body' textbox");
		adminPostAddNewPage.inputToBodyTextbox(postBody);

		log.info("Create new post - Step 06: Click 'Pre-publish' button");
		adminPostAddNewPage.clickPrePublishOrUpdateButton();

		log.info("Create new post - Step 07: Click 'Publish' button");
		adminPostAddNewPage.clickPublishButton();

		log.info("Create new post - Step 08: Verify message 'Post published' is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post published."));

	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search post - Step 01: Navigate to 'Post Search' page");
		adminPostSearchPage = adminPostAddNewPage.openPostSearchPage(postSearchPageUrl);

		log.info("Search post - Step 02: Enter to 'Search' textbox with value: " + postTitle);
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search post - Step 03: Click 'Search posts' button");
		adminPostSearchPage.clickSearchPostButton();

		log.info("Search post - Step 04: Verify 'Search' table contains: " + postTitle);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search post - Step 05: Verify 'Search' table contains: " + authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search post - Step 06: Navigate to 'User' site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);

		log.info("Search post - Step 07: Verify Post information displayed at User home page");
		verifyTrue(userHomePage.isPostTitleDisplayed(postTitle));
		verifyTrue(userHomePage.isPostAuthorDisplayed(postTitle, authorName));
		verifyTrue(userHomePage.isPostBodyDisplayed(postTitle, postBody));
		verifyTrue(userHomePage.isPostedDayDisplayed(postTitle, currentDay));

		log.info("Search post - Step 08: Click to 'Post' title");
		userPostDetailPage = userHomePage.clickToPostTitleLink(postTitle);

		log.info("Search post - Step 09: Verify Post information displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostTitleDisplayed(postTitle));
		verifyTrue(userPostDetailPage.isPostAuthorDisplayed(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostBodyDisplayed(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostedDayDisplayed(postTitle, currentDay));

	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit post - Step 01: Navigate to Admin home page");
		adminDashboardPage = userPostDetailPage.openAdminDashboardPage(driver, urlAdmin);

		log.info("Edit post - Step 02: Click 'Post' icon");
		adminPostSearchPage = adminDashboardPage.clickPostIcon();

		log.info("Edit post - Step 03: Get 'Post Search' page Url");
		postSearchPageUrl = adminPostSearchPage.getPageUrl(driver);

		log.info("Edit post - Step 04: Click 'Post' title link with value: " + postTitle);
		adminPostAddNewPage = adminPostSearchPage.clickPostTitleLink("title", postTitle);

		log.info("Edit post - Step 05: Edit 'Post' title with value: " + editedPostTitle);
		adminPostAddNewPage.inputToTitleTextbox(editedPostTitle);

		log.info("Edit post - Step 06: Edit 'Post' body with value: " + editedPostBody);
		adminPostAddNewPage.inputToBodyTextbox(editedPostBody);

		log.info("Edit post - Step 07: Click 'Update' button");
		adminPostAddNewPage.clickPrePublishOrUpdateButton();

		log.info("Edit post - Step 08: Verify 'Post updated' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishedMessageDisplayed("Post updated."));

		log.info("Edit post - Step 09: Navigate to 'Post Search' page");
		adminPostAddNewPage.openPageUrl(driver, postSearchPageUrl);

		log.info("Edit post - Step 10: Enter to 'Search' textbox with value: " + editedPostTitle);
		adminPostSearchPage.enterToSearchTextbox(editedPostTitle);

		log.info("Edit post - Step 11: Click 'Search posts' button");
		adminPostSearchPage.clickSearchPostButton();

		log.info("Edit post - Step 12: Verify 'Search' table contains: " + editedPostTitle);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editedPostTitle));

		log.info("Edit post - Step 13: Navigate to 'User' site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);

		log.info("Edit post - Step 14: Verify Post information displayed at User home page");
		verifyTrue(userHomePage.isPostTitleDisplayed(editedPostTitle));
		verifyTrue(userHomePage.isPostAuthorDisplayed(editedPostTitle, authorName));
		verifyTrue(userHomePage.isPostBodyDisplayed(editedPostTitle, editedPostBody));
		verifyTrue(userHomePage.isPostedDayDisplayed(editedPostTitle, currentDay));

		log.info("Edit post - Step 15: Click to 'Post' title");
		userPostDetailPage = userHomePage.clickToPostTitleLink(editedPostTitle);

		log.info("Edit post - Step 16: Verify Post information displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostTitleDisplayed(editedPostTitle));
		verifyTrue(userPostDetailPage.isPostAuthorDisplayed(editedPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostBodyDisplayed(editedPostTitle, editedPostBody));
		verifyTrue(userPostDetailPage.isPostedDayDisplayed(editedPostTitle, currentDay));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete post - Step 01: Navigate to 'Admin dashboard' page");
		userPostDetailPage.openAdminDashboardPage(driver, this.urlAdmin);

		log.info("Delete post - Step 02: Click 'Post' icon");
		adminPostSearchPage = adminDashboardPage.clickPostIcon();

		log.info("Delete post - Step 03: Enter to 'Search' textbox with value: " + editedPostTitle);
		adminPostSearchPage.enterToSearchTextbox(editedPostTitle);

		log.info("Delete post - Step 04: Click 'Search posts' button");
		adminPostSearchPage.clickSearchPostButton();

		log.info("Delete post - Step 05: Tick to 'Post' wanted to delete");
		adminPostSearchPage.selectPostCheckboxByTitle(editedPostTitle);

		log.info("Delete post - Step 06: Select 'Move to trash' action");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

		log.info("Delete post - Step 07: Click 'Apply' button");
		adminPostSearchPage.clickApplyButton();

		log.info("Delete post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.IsActionMessageDisplayed("1 post moved to the Trash. "));

		log.info("Delete post - Step 09: Enter to 'Search' textbox with value: " + postTitle);
		adminPostSearchPage.enterToSearchTextbox(editedPostTitle);

		log.info("Delete post - Step 10: Click 'Search posts' button");
		adminPostSearchPage.clickSearchPostButton();

		log.info("Delete post - Step 11: Verify 'No posts found' message is displayed");
		verifyTrue(adminPostSearchPage.IsNoPostFoundMessageDisplayed("No posts found."));

		log.info("Delete post - Step 12: Navigate to 'User' site");
		userHomePage = adminPostSearchPage.openUserHomePage(driver, this.urlUser);

		log.info("Delete post - Step 13: Verify post title undisplayed at Home page");
		verifyTrue(userHomePage.isPostTitleUndisplayed(editedPostTitle));

		log.info("Delete post - Step 13: Enter to 'Search' textbox");
		userHomePage.enterToSearchTextbox(editedPostTitle);

		log.info("Delete post - Step 14: Click 'Search' button");
		userSearchPostPage = userHomePage.clickSearchbutton();

		log.info("Delete post - Step 15: Verify 'Nothing found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundTitleMessageDisplayed("Nothing Found"));
		verifyTrue(userSearchPostPage.isNothingFoundDetailMessageDisplayed("Sorry, but nothing matched your search terms. Please try again with some different keywords."));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
