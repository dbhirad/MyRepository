package CoverFoxTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CoverFoxUtility.UtilityTest;
import coverFoxBase.BaseClass;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultsPage;


public class TestClass extends BaseClass {

	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPage;
	CoverFoxAddressDetailsPage addressPage;
	CoverFoxMemberDetailsPage memberDetails;
	CoverFoxResultsPage resultPage;
	String filePath;
	String destForScreenshot;
	
	
	public static Logger logger;
	  @Test
	  public void f() 
	  {
		  logger= Logger.getLogger("My_New_log");
		  PropertyConfigurator.configure("Log4j.properties");
		  logger.info("Hello");
	  }


	@BeforeTest
	public void openBrowser()

	{
		launchBrowser();
		homePage = new CoverFoxHomePage(driver);
		healthPage = new CoverFoxHealthPlanPage(driver);
		addressPage = new CoverFoxAddressDetailsPage(driver);
		memberDetails = new CoverFoxMemberDetailsPage(driver);
		resultPage = new CoverFoxResultsPage(driver);
		filePath = System.getProperty("user.dir")+"\\excelTest.xlsx";
		destForScreenshot = System.getProperty("user.dir")+"\\ScreenShotForMaven\\";
		
	}

	@BeforeClass
	public void preConditions() throws IOException , FileNotFoundException , InterruptedException

	{
		// Home-Page
		Thread.sleep(3000);
		homePage = new CoverFoxHomePage(driver);
		homePage.clickOnGetStarted();
		Reporter.log("Click on get started",true);

		// Health-Plan Page
		Thread.sleep(4000);
		healthPage = new CoverFoxHealthPlanPage(driver);
		healthPage.clickOnNextBtn();
		Reporter.log("Click on next button",true);

		// Member-details Page
		Thread.sleep(2000);
		memberDetails = new CoverFoxMemberDetailsPage(driver);
//		memberDetails.selectAgeDropDown(Utility.readDataFromPeroperties("age"));
		memberDetails.selectAgeDropDown(UtilityTest.getExcelData(filePath, "Sheet4", 1, 0));
		Reporter.log("Select age",true);
		memberDetails.clickOnNextBtn();
		Reporter.log("Click on next button",true);

		Thread.sleep(2000);

		// Address-Details Page
		addressPage = new CoverFoxAddressDetailsPage(driver);
//		addressPage.enterPinCode(Utility.readDataFromPeroperties("pinCode"));
		addressPage.enterPinCode(UtilityTest.getExcelData(filePath, "Sheet4", 1, 1));
		Reporter.log("enter pincode",true);
//		addressPage.enterMobileNumber(Utility.readDataFromPeroperties("mobNo"));
		addressPage.enterMobileNumber(UtilityTest.getExcelData(filePath, "Sheet4", 1, 2));
		Reporter.log("enter mobileNo",true);
		addressPage.clickOnContinueBtn();
		Reporter.log("Click on Continue Btn",true);

		Thread.sleep(2000);
	}
	
	@Test
	public void validateBanners() throws IOException

	{
		// Result-Page
		resultPage = new CoverFoxResultsPage(driver);
		Reporter.log("Validating the no of banners on result page",true);
		Assert.assertEquals(resultPage.getTotalBanners(), resultPage.getTextOnHomePage(),
				"No of Banners and text is not  matching");
		Reporter.log("Taking Screenshot",true);
		UtilityTest.getScreenShotForMaven(driver, destForScreenshot ,"validateBanners");

	}

	@Test
	public void validatePresenceOfSortDropdown() throws IOException {
		//result-page
		resultPage = new CoverFoxResultsPage(driver);
		Reporter.log("Validating the presence of sort dropdown on result page",true);
		Assert.assertTrue(resultPage.sortPlanDropdownIsDisplayed(),
				"Sort Plan Dropdown is not displayed , Tc is failed");
		Reporter.log("Taking Screenshot",true);
		UtilityTest.getScreenShotForMaven(driver, destForScreenshot ,"PresenceOfSortDropDown");
	}

	@AfterClass
	public void closeTheBrowser() throws InterruptedException

	{
		closeBrowser();
	}

}
