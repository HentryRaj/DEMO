package com.vtiger.script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.pages.VtigerCampaignPage;
import com.vtiger.pages.VtigerCreateCampaignPage;
import com.vtiger.pages.VtigerCreateProductPage;
import com.vtiger.pages.VtigerCreatedCampaignPage;
import com.vtiger.pages.VtigerCreatedProductPage;
import com.vtiger.pages.VtigerHomePage;
import com.vtiger.pages.VtigerProductPage;

/**
 * 
 * @author HenTryRAj
 *
 */
public class TestCreateCampaignTest extends BaseClass {	
	@Test(priority = 1 , groups = "RegressionTesting")
	public void createCampaignWithProduct() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//step 1 ==> get data
		String path = "./TestData/inputData.xlsx";
		String campName = fileLib.read_XL_Data(path, "Campaign", 1, 1) + webLib.randomNumber();
		String productName = fileLib.read_XL_Data(path, "Campaign", 1, 2);
		
		//step 2 ==> navigate to product page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerProductPage productPage = hp.navigateToProductPage();
		//step 3 ==> navigate to create product page
		VtigerCreateProductPage createProduct = productPage.navigateToCreateProduct();
		//step ==> 4 create product and navigate to product info
		VtigerCreatedProductPage createdProduct = createProduct.navigateToCreatedProductPage(productName);
		//step ==> 5 navigate to  campaign page
		VtigerCampaignPage campPage = createdProduct.navigateToCampaignPage();
		//step ==> 6 navigate to create campaign page
		VtigerCreateCampaignPage createCamp = campPage.navigateToCreateCampaignPage();
		//step ==> 7 create new campaign with created product and navigate to campaign page
		VtigerCreatedCampaignPage createdCamp = createCamp.navigateToCreatedCampaign(campName, productName);
		//step ==> 8 verify
		String actualCamp = createdCamp.getCampInfo().getText();
		Assert.assertEquals(actualCamp, campName);
	}
	@Test(priority = 0, groups = "SmokeTesting")
	public void createCampaign() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//step 1 ==> get data
		String path = "./TestData/inputData.xlsx";
		String campName = fileLib.read_XL_Data(path, "Campaign", 1, 1) + webLib.randomNumber();
		//step 2 ==> navigate to campaign page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerCampaignPage campPage = hp.navigateToCampaignPage();
		//step ==> 3 navigate to create campaign page
		VtigerCreateCampaignPage createCamp = campPage.navigateToCreateCampaignPage();
		//step ==> 4 create new campaign with created product and navigate to campaign page
		VtigerCreatedCampaignPage createdCamp = createCamp.navigateToCreatedCampaign(campName);
		//step ==> 5 verify
		String actualCamp = createdCamp.getCampInfo().getText();
		Assert.assertEquals(actualCamp, campName);
	}
	@Test(priority = 2, groups = "RegressionTesting")
	public void createCampaignWithDescription() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//step 1 ==> get data
		String path = "./TestData/inputData.xlsx";
		String campName = fileLib.read_XL_Data(path, "Campaign", 1, 1) + webLib.randomNumber();
		String Description = fileLib.read_XL_Data(path, "Campaign", 1, 3);
		//step 2 ==> navigate to campaign page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerCampaignPage campPage = hp.navigateToCampaignPage();
		//step ==> 3 navigate to create campaign page
		VtigerCreateCampaignPage createCamp = campPage.navigateToCreateCampaignPage();
		//step ==> 4 create new campaign with created product and navigate to campaign page
		VtigerCreatedCampaignPage createdCamp = createCamp.navigateToCreatedCampaignWithDescription(campName, Description);
		//step ==> 5 verify
		String actualCamp = createdCamp.getCampInfo().getText();
		Assert.assertEquals(actualCamp, campName);
	}	
}