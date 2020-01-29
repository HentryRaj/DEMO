package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerProductPage {
	public WebDriver driver;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchProduct;
	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement productListBox;
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProduct;
	@FindBy(xpath = "(//input[@value =' Search Now '])[1]")
	private WebElement searchBtn;
	public VtigerProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchProduct() {
		return searchProduct;
	}
	public WebElement getProductListBox() {
		return productListBox;
	}
	public WebElement getCreateProduct() {
		return createProduct;
	}
	public WebElement getSearchproductBtn() {
		return searchBtn;
	}
	/**
	 * 
	 * @return
	 */
	public VtigerCreateProductPage navigateToCreateProduct() {
		createProduct.click();
		return new VtigerCreateProductPage(driver);
	}
}
