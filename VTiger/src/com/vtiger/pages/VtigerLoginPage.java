package com.vtiger.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.FileLib;
import com.vtiger.generic.WebDriverUtils;
/**
 * 
 * @author HenTryRAj
 *
 */
public class VtigerLoginPage  {
	public WebDriver driver;
	FileLib fileLib = new FileLib();
	//inilization
	@FindBy(name="user_name")
	private WebElement userName;
	@FindBy(name="user_password")
	private WebElement passWord;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	@FindBy(className = "errorMessage")
	private WebElement errorMsg;
	//declaration
	public VtigerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//getter method
	public WebElement getUserName() {
		return userName;
	}
	public  WebElement getPassword() {
		return	passWord;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}	 
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username , String password) {
		getUserName().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws IOException 
	 */
	public void loginToApp() throws IOException {
		String	USERNAME=	fileLib.getDataFromProperties("username");
		String PASSWORD= fileLib.getDataFromProperties("password");
		getUserName().sendKeys(USERNAME);
		getPassword().sendKeys(PASSWORD);
		getLoginBtn().click();
	}
}
