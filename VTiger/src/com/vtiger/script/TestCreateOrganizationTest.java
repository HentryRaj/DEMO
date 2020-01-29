package com.vtiger.script;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vtiger.generic.BaseClass;
import com.vtiger.generic.FileLib;
import com.vtiger.pages.VtigerCreateOrganizationPage;
import com.vtiger.pages.VtigerCreatedOrganizationPage;
import com.vtiger.pages.VtigerHomePage;
import com.vtiger.pages.VtigerOrganizationPage;
/**
 * 
 * @author HenTryRAj
 *
 */
public class TestCreateOrganizationTest  extends BaseClass{
	FileLib fileLib = new FileLib();
	@Test(priority = 0 , groups = "SmokeTesting")
	public void createOrganization() throws InterruptedException, IOException {
		//step 1 ==> get Test data
		String path = "./TestData/inputData.xlsx";
		String orgName = fileLib.read_XL_Data(path, "Organization", 1, 1) + webLib.randomNumber();
		String phnNo = fileLib.read_XL_Data(path, "Organization", 1, 3);
		String emailId = fileLib.read_XL_Data(path, "Organization", 1, 4);
		
		//step 2 ===> navigate to Organization page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerOrganizationPage orgPage = hp.navigateToOrganizationPage();
		
		//step3 ==> navigate to create organization page
		VtigerCreateOrganizationPage createOrg = orgPage.navigateToCreateOrganizationPage();
		
		//step4 ==> navigate to organization details page
		VtigerCreatedOrganizationPage createdOrg =createOrg.createOrgAndNavigateToCreatedOrgPage(orgName, phnNo, emailId);
		
		//step5 ==> verify 
		String actualOrganizationName =  createdOrg.getOrganizationName().getText();
		Assert.assertEquals(actualOrganizationName, orgName);
	}
	@Test(priority = 1, groups = "RegressionTesting")
	public void toCreateOrganizationWithMember() throws InterruptedException, IOException {
		//step 1 ==> get Test data
		String path = "./TestData/inputData.xlsx";
		String orgName = fileLib.read_XL_Data(path, "Organization", 1, 1) + webLib.randomNumber();
		String memberName = fileLib.read_XL_Data(path, "Organization", 1, 2);
		String phnNo = fileLib.read_XL_Data(path, "Organization", 1, 3);
		String emailId = fileLib.read_XL_Data(path, "Organization", 1, 4);
		
		//step 2 ===> navigate to Organization page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerOrganizationPage orgPage = hp.navigateToOrganizationPage();
		
		//step3 ==> navigate to create organization page
		VtigerCreateOrganizationPage createOrg = orgPage.navigateToCreateOrganizationPage();
		
		//step4 ==> navigate to organization details page
		VtigerCreatedOrganizationPage createdOrg = createOrg.createOrgAndNavigateToCreatePopUoOrgPage(orgName  , memberName, phnNo,  emailId);
		
		//step5 ==> verify 
		String actualOrganizationName =  createdOrg.getOrganizationName().getText();
		Assert.assertEquals(actualOrganizationName, orgName);
	}
	@Test(priority = 2, groups = "RegressionTesting")
	public void toCreateOrganizationWithPhoneNumber() throws InterruptedException, IOException {
		//step 1 ==> get Test data
		String path = "./TestData/inputData.xlsx";
		String orgName = fileLib.read_XL_Data(path, "Organization", 1, 1) + webLib.randomNumber();
		String phnNo = fileLib.read_XL_Data(path, "Organization", 1, 3);
		
		//step 2 ===> navigate to Organization page
		VtigerHomePage hp = new VtigerHomePage(driver);
		VtigerOrganizationPage orgPage = hp.navigateToOrganizationPage();
		
		//step3 ==> navigate to create organization page
		VtigerCreateOrganizationPage createOrg = orgPage.navigateToCreateOrganizationPage();
		
		//step4 ==> navigate to organization details page
		VtigerCreatedOrganizationPage createdOrg = createOrg.createOrgAndNavigateToCreatedOrgPage(orgName  , phnNo);
		
		//step5 ==> verify 
		String actualOrganizationName =  createdOrg.getOrganizationName().getText();
		Assert.assertEquals(actualOrganizationName, orgName);
	}
}
