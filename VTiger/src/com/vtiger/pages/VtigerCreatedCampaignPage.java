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

public class VtigerCreatedCampaignPage {
	public WebDriver driver;
	@FindBy(xpath = "(//td[@class = 'dvtCellLabel'])[1]/../td[2]/span")
	private WebElement campInfo;

	public VtigerCreatedCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampInfo() {
		return campInfo;
	}
}
