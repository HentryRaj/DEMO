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

public class VtigerOrganizationPopUpPage {
	public WebDriver driver;
	public WebDriverUtils webLib = new WebDriverUtils(); 
	@FindBy(name="search_text")
	private WebElement searchOrg;
	@FindBy(name="search_field")
	private WebElement listBoxOrg;
	@FindBy(xpath = "(//table[@class= 'small'])[3]/tbody/tr[2]/td[1]/a")
	private WebElement foundMember;
	@FindBy(xpath = "//option[@value= 'accountname']")
	private WebElement dropDownOption;
	
	public VtigerOrganizationPopUpPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchOrganization() {
		return searchOrg;
	}
	public WebElement getListBoxOrg() {
		return listBoxOrg;
	}
	public WebElement getfoundOrganization() {
		return foundMember;
	}
	public WebElement getDropDownOption() {
		return dropDownOption;
	}
	public VtigerCreateOrganizationPage navigateToCreateOrganizationpage(String memberName) throws InterruptedException {
		webLib.select(listBoxOrg, dropDownOption.getText());
		searchOrg.sendKeys(memberName, Keys.ENTER);
		//webLib.waitForElementToBeClickable(driver, foundMember);
		foundMember.click();
		webLib.alertPopUpForAccept(driver);
		webLib.switchToParentwindow(driver);
		return new VtigerCreateOrganizationPage(driver);
	}
}
