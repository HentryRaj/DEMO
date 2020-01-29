package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.pages.VtigerHomePage;
import com.vtiger.pages.VtigerLoginPage;

public class BaseClass {
	public FileLib fileLib = new FileLib();
	public WebDriverUtils webLib = new WebDriverUtils();
	public WebDriver driver;
	//@Parameters("browser")
	@BeforeClass(groups = {"RegressionTesting" , "SmokeTesting" }) 
	public void configBC() throws IOException {
//launch the browser
		String BROWSER = fileLib.getDataFromProperties("browser");
		if(BROWSER.equals("chrome"))
		 driver = new ChromeDriver();
		else if(BROWSER.equals("firefox"))
		driver = new FirefoxDriver();
	}
	@BeforeMethod(groups = {"RegressionTesting" , "SmokeTesting" }) 
	public void configBM() throws IOException {
		String	USERNAME=	fileLib.getDataFromProperties("username");
		String PASSWORD= fileLib.getDataFromProperties("password");
		String URL= fileLib.getDataFromProperties("url");
		driver.manage().window().maximize();
		webLib.woitForElementToLoad(driver);
		driver.get(URL);
		VtigerLoginPage lp =new VtigerLoginPage( driver);
		lp.loginToApp();
	}
	@AfterMethod(groups = {"RegressionTesting" , "SmokeTesting" })
	public void configAM() {
		VtigerHomePage  hp = new VtigerHomePage(driver);
		hp.logoutFromApp();
	}

	@AfterTest(groups = {"RegressionTesting" , "SmokeTesting" })
	public void configAT() {
	driver.close();
	}
}

