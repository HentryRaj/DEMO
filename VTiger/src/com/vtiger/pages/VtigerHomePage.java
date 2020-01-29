package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;
public class VtigerHomePage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils();
	@FindBy(linkText = "Organizations")
	private WebElement orgTab;
	@FindBy(tagName = "title")
	private WebElement title;
	@FindBy(linkText = "Products")
	private WebElement proTab;
	@FindBy(linkText = "More")
	private WebElement moreTab;
	@FindBy(linkText = "Campaigns")
	private WebElement campTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	public VtigerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgtab() {
		return orgTab;
	}
	public WebElement getHomeTitle() {
		return title;
	}
	public WebElement getProductTab() {
		return proTab;
	}
	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getMoreTab() {
		return moreTab;
	}
	public WebElement getCamaignsTab() {
		return campTab;
	}
	
	/**
	 * 
	 * @return
	 */
	public VtigerOrganizationPage navigateToOrganizationPage() {
		orgTab.click();
		return new VtigerOrganizationPage(driver);
	}
	/**
	 * 
	 * @return
	 */
	public VtigerProductPage navigateToProductPage() {
		proTab.click();
		return new VtigerProductPage(driver);
	}
	/**
	 * 
	 * @return
	 */
	public VtigerCampaignPage navigateToCampaignPage() {
		moreTab.click();
		webLib.actionForMoveTo(driver, campTab);
		campTab.click();
		return new VtigerCampaignPage(driver);
	}
	/**
	 * 
	 */
	public void logoutFromApp() {
		admin.click();
		webLib.actionForMoveTo(driver, signOut);
		signOut.click();
	}
}
