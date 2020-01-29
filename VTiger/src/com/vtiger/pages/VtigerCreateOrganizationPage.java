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

public class VtigerCreateOrganizationPage {
	public WebDriverUtils webLib = new WebDriverUtils();
	public WebDriver driver;
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(name="phone")
	private WebElement phoneNo;
	@FindBy(name="email1")
	private WebElement emailId;
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement addMember;
	@FindBy(xpath = "//input[@accesskey ='S']")
	private WebElement saveBtn;
	
	public VtigerCreateOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrganizationName() {
		return orgName;
	}
	public WebElement getPhoneNumber() {
		return phoneNo;
	}
	public WebElement getEmailId() {
		return emailId;
	}
	public WebElement getMember() {
		return addMember;
	}
	public WebElement getSaveButton() {
		return saveBtn;
	}
	/**
	 * 
	 * @param orgName
	 * @param phnNo
	 * @param emailId
	 * @return
	 */
	public VtigerCreatedOrganizationPage createOrgAndNavigateToCreatedOrgPage(String orgName,  String phnNo, String emailId) {
		this.orgName.sendKeys(orgName);
		this.phoneNo.sendKeys(phnNo);
		this.emailId.sendKeys(emailId);
		this.saveBtn.click();
		return new VtigerCreatedOrganizationPage(driver);
	}
	/**
	 * 
	 * @param orgName
	 * @param phnNo
	 * 
	 * @return
	 */
	public VtigerCreatedOrganizationPage createOrgAndNavigateToCreatedOrgPage(String orgName,  String phnNo) {
		this.orgName.sendKeys(orgName);
		this.phoneNo.sendKeys(phnNo);
		this.saveBtn.click();
		return new VtigerCreatedOrganizationPage(driver);
	}
	/**
	 * 
	 * @param orgName
	 * @param phnNo
	 * @param emailId
	 * @return
	 * @throws InterruptedException 
	 */
	   public VtigerCreatedOrganizationPage createOrgAndNavigateToCreatePopUoOrgPage(String orgName,String memberName,  String phnNo, String emailId) throws InterruptedException {
		this.orgName.sendKeys(orgName);
		this.phoneNo.sendKeys(phnNo);
		this.emailId.sendKeys(emailId);
		this.addMember.click();
		webLib.switchToChildwindow(driver);
		VtigerOrganizationPopUpPage orgPopUp = new VtigerOrganizationPopUpPage(driver);
		 orgPopUp.navigateToCreateOrganizationpage(memberName);
		saveBtn.click();
		return new VtigerCreatedOrganizationPage(driver);
	}	
}
