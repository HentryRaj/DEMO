package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationPage {
	public WebDriver driver; 
	@FindBy(xpath = "//img[@title ='Create Organization...']")
	private WebElement addOrg;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchOrg;
	@FindBy(xpath = "(//select[@name='search_field'])[1]")
	private WebElement listBoxOrg;
	@FindBy(xpath = "(//input[@value =' Search Now '])[1]")
	private WebElement searchBtn;
	public VtigerOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddOrganization() {
		return addOrg;
	}
	public WebElement getSearchOrganization() {
		return searchOrg;
	}
	public WebElement getListOrganization() {
		return listBoxOrg;
	}
	public WebElement getSearchbtn() {
		return searchBtn;
	}
	public VtigerCreateOrganizationPage navigateToCreateOrganizationPage() {
		addOrg.click();
		return new VtigerCreateOrganizationPage(driver);
	}
}
