package com.vtiger.pages;
/**
 * 
 * @author HenTryRAj
 *
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class VtigerProductPopUpPage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils();
	@FindBy(xpath = "//input[@name = 'search_text']")
	private WebElement searchProduct;
	@FindBy(xpath = "//select[@name = 'search_field']")
	private WebElement productListBox;
	@FindBy(xpath = "//option[@label = 'Product Name']")
	private WebElement productOption;
	@FindBy(xpath = "(//a)[4]")
	//(//table[@class='small'])[3]/tbody/tr[1]/td[1]/*
	private WebElement productName;
	public VtigerProductPopUpPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchProduct() {
		return searchProduct;
	}
	public WebElement getProductListBox() {
		return productListBox;
	}
	public WebElement getProductOption() {
		return productOption;
	}
	public WebElement getProductName() {
		return productName;
	}
	public VtigerCreateCampaignPage navigateToCreateCampaign(String productName1) throws InterruptedException {
		webLib.select(productListBox,productOption.getText());
		searchProduct.sendKeys(productName1, Keys.ENTER);
		Thread.sleep(1000);
		productName.click();
		webLib.switchToParentwindow(driver);
		return new VtigerCreateCampaignPage(driver);
	}
}
