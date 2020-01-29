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

import com.vtiger.generic.WebDriverUtils;

public class VtigerCreateCampaignPage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils();
	@FindBy(name = "campaignname")
	private WebElement campName;
	@FindBy(xpath = "(//input[@accesskey='S'])[1]")
	private WebElement saveBtn;
	@FindBy(xpath = "//img[@src = 'themes/softed/images/select.gif']")
	private WebElement productBtn;
	@FindBy(tagName = "textarea")
	private WebElement Description;
	public VtigerCreateCampaignPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebDriverUtils getWebLib() {
		return webLib;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getDescription() {
		return Description;
	}
	public WebElement getCampName() {
		return campName;
	}
	public WebElement getProductBtn() {
		return productBtn;
	}
	/**
	 * 
	 * @param campName1
	 * @param productName1
	 * @return
	 * @throws InterruptedException
	 */
	public VtigerCreatedCampaignPage navigateToCreatedCampaign(String campName1, String productName1) throws InterruptedException {
		campName.sendKeys(campName1);
		productBtn.click();
		webLib.switchToChildwindow(driver);
		VtigerProductPopUpPage productPopUp = new VtigerProductPopUpPage(driver);
		productPopUp.navigateToCreateCampaign(productName1);
		saveBtn.click();
		return new VtigerCreatedCampaignPage(driver);
	}
	/**
	 * 
	 * @param campName1
	 * @return
	 */
	public VtigerCreatedCampaignPage navigateToCreatedCampaign(String campName1)  {
		campName.sendKeys(campName1);
		saveBtn.click();
		return new VtigerCreatedCampaignPage(driver);
	}
	/**
	 * 
	 * @param campName1
	 * @param Description1
	 * @return
	 */
	public VtigerCreatedCampaignPage navigateToCreatedCampaignWithDescription(String campName1, String Description1 )  {
		campName.sendKeys(campName1);
		Description.sendKeys(Description1);
		saveBtn.click();
		return new VtigerCreatedCampaignPage(driver);
	}
}
