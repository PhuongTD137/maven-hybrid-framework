package pageObjects.sauceDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceDemo.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSortFilter(String filterName) {
		waitForElementClickable(driver, ProductPageUI.SORT_FILTER);
		selectItemInDefaultDropdown(driver, ProductPageUI.SORT_FILTER, filterName);
	}

	public boolean isProductSortedByNameInAscending() {
		List<WebElement> productListByName = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		ArrayList<String> productUINameList = new ArrayList<String>();

		for (WebElement productByName : productListByName) {
			productUINameList.add(productByName.getText());
		}

		ArrayList<String> newProductUINameList = new ArrayList<String>();
		for (String productUIName : productUINameList) {
			newProductUINameList.add(productUIName);
		}

		Collections.sort(newProductUINameList);

		return newProductUINameList.equals(productUINameList);
	}

	public boolean isProductSortedByNameInDescending() {
		List<WebElement> productListByName = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
		ArrayList<String> productUINameList = new ArrayList<String>();

		for (WebElement productByName : productListByName) {
			productUINameList.add(productByName.getText());
		}

		ArrayList<String> newProductUINameList = new ArrayList<String>();
		for (String productUIName : productUINameList) {
			newProductUINameList.add(productUIName);
		}

		Collections.sort(newProductUINameList);
		Collections.reverse(newProductUINameList);

		return newProductUINameList.equals(productUINameList);
	}

	public boolean isProductSortedByPriceInAscending() {
		List<WebElement> productListByPrice = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		ArrayList<Float> productUIPriceList = new ArrayList<Float>();

		for (WebElement productByPrice : productListByPrice) {
			productUIPriceList.add(Float.parseFloat(productByPrice.getText().replace("$", "")));
		}

		ArrayList<Float> newProductUIPriceList = new ArrayList<Float>();
		for (Float productUIPrice : productUIPriceList) {
			newProductUIPriceList.add(productUIPrice);
		}

		Collections.sort(newProductUIPriceList);

		return newProductUIPriceList.equals(productUIPriceList);
	}

	public boolean isProductSortedByPriceInDescending() {
		List<WebElement> productListByPrice = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);
		ArrayList<Float> productUIPriceList = new ArrayList<Float>();

		for (WebElement productByPrice : productListByPrice) {
			productUIPriceList.add(Float.parseFloat(productByPrice.getText().replace("$", "")));
		}

		ArrayList<Float> newProductUIPriceList = new ArrayList<Float>();
		for (Float productUIPrice : productUIPriceList) {
			newProductUIPriceList.add(productUIPrice);
		}

		Collections.sort(newProductUIPriceList);
		Collections.reverse(newProductUIPriceList);

		return newProductUIPriceList.equals(productUIPriceList);
	}
}
