package com.vtiger.pages;
/**
 * 
 * @author HenTryRAj
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreatedProductPage {
	public WebDriver driver;
	@FindBy(xpath = "(//input[@id='hdtxt_IsAdmin'])[2]/../../td[2]/span" )
	private WebElement productInfo;
	@FindBy(tagName = "title")
	private WebElement productTitle;
	public WebElement getProductInfo() {
		return productInfo;
	}
	public VtigerCreatedProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	public WebElement getProductTitle() {
		return productTitle;
	}
	public VtigerCampaignPage navigateToCampaignPage() {
		VtigerHomePage hp = new VtigerHomePage(driver);
		hp.navigateToCampaignPage();
		return new VtigerCampaignPage(driver);
	}
}
