package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateProductPage {
	public WebDriver driver;
	@FindBy(name = "productname")
	private WebElement productName;
	@FindBy(xpath = "(//input[@accesskey='S'])[1]")
	private WebElement saveProductBtn;
	public VtigerCreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement  getSaveButton() {
		return saveProductBtn;
	}
	public VtigerCreatedProductPage navigateToCreatedProductPage(String productName1) {
		productName.sendKeys(productName1);
		saveProductBtn.click();
		return new VtigerCreatedProductPage(driver);
	}
}
