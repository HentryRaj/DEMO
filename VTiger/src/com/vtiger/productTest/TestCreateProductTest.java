package com.vtiger.productTest;

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

public class TestCreateProductTest extends BaseClass{
	@Test(priority = 0 , groups = "SmokeTesting")
	public void createProduct() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//step 1 ==> get data
		String path = "./TestData/inputData.xlsx";
		String productName = fileLib.read_XL_Data(path, "Product", 1, 1) + webLib.randomNumber() ;
		
		//step 2 ==> navigate to product page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerProductPage productPage = hp.navigateToProductPage();
		//step 3 ==> navigate to create product page
		VtigerCreateProductPage createProduct = productPage.navigateToCreateProduct();
		//step ==> 4 create product and navigate to product info
		VtigerCreatedProductPage createdProduct = createProduct.navigateToCreatedProductPage(productName);
		
		String actualCamp = createdProduct.getProductInfo().getText();
		Assert.assertEquals(actualCamp, productName);
	}
	@Test(priority = 1 , groups = "RegressionTesting")
	public void createProductWith() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		//step 1 ==> get data
		String path = "./TestData/inputData.xlsx";
		String productName = fileLib.read_XL_Data(path, "Product", 1, 1) + webLib.randomNumber() ;
		String description = fileLib.read_XL_Data(path, "Product", 1, 2);
		//step 2 ==> navigate to product page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerProductPage productPage = hp.navigateToProductPage();
		//step 3 ==> navigate to create product page
		VtigerCreateProductPage createProduct = productPage.navigateToCreateProduct();
		//step ==> 4 create product and navigate to product info
		VtigerCreatedProductPage createdProduct = createProduct.navigateToCreatedProductPage(productName,description);
		String actualCamp = createdProduct.getProductInfo().getText();
		Assert.assertEquals(actualCamp, productName);
	}

}
