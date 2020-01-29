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

public class VtigerCreatedOrganizationPage {
	public WebDriver driver;
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrgName;
	@FindBy(tagName = "title")
	private WebElement titleName;
	@FindBy(linkText = "Organizations")
	private WebElement orgTab;
	
	public VtigerCreatedOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationName() {
		return OrgName;
	}
	public WebElement getOrganizationDetialTitle() {
		return titleName;
	}
	public WebElement getOrganizationTab() {
		return orgTab;
	}
	
}
