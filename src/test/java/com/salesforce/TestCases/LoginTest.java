package com.salesforce.TestCases;


import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.GenericLib.CommonLib;
import com.GenericLib.Constants;
import com.GenericLib.Driver;
import com.GenericLib.ExcelLib;
import com.GenericLib.ReportDemo;
import com.GenericLib.commonFunctions;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.DisplayOrder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.GridType;
//import com.relevantcodes.extentreports.LogStatus;
import com.salesforce.BusinessLib.BusinessLib;
import com.salesforce.Pages.EmailCampaignPage;
import com.salesforce.Pages.HomePage;
import com.salesforce.Pages.LoginPage;
import com.salesforce.Pages.RegularCampaign;
import com.sun.corba.se.impl.orbutil.closure.Constant;


public class LoginTest 
{
	WebDriver driver;
	BusinessLib bLib;
	CommonLib cLib;
	ExtentReports extent;
	@BeforeClass
	public void prepare_reports()
	{
		extent=ExtentReports.get(LoginTest.class);
		extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_OLDEST_TO_LATEST,GridType.STANDARD);
	    extent.config().displayTestHeaders(true);
	    extent.config().documentTitle("Salesforce report");
        extent.config().reportHeadline("Test Execution Report for Salesforce");
        extent.startTest("This Test to check the login and create Campaign..");
        extent.config().displayCallerClass(false);
	}

	
	@Test(dataProvider="readData")
	public void loginTest(String section,String campaign,String fromName,String fromMail,String template,String subject,String content) throws InterruptedException
	{
		extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_OLDEST_TO_LATEST,GridType.STANDARD);
		String url=Constants.url;
		cLib.openApp(url);
		LoginPage lPage=PageFactory.initElements(driver, LoginPage.class);
		HomePage hPage=lPage.login();
		EmailCampaignPage ePage=hPage.clickOnEmail(section);
		RegularCampaign rPage=ePage.createRegularCampaigns();
		boolean state=rPage.createAndMailCampaign(campaign, fromName, fromMail, template,subject,content);
		if(state=false)
		{
		  extent.log(LogStatus.FAIL, "", "test failed an email not sent" + "");
		  Assert.fail();
		}
		else
		{
			System.out.println("completed successfully....");
			extent.attachScreenshot(ReportDemo.createScreenshot(driver),"This is to attach screenshot for test");
			extent.log(LogStatus.PASS,"the testcase is completed");
            extent.config().useExtentFooter(false);
            extent.endTest();
		}
     System.out.println("done....");
	}
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=Driver.getWebDriver();
	  //System.out.println(this.driver);
	  //bLib=new BusinessLib(driver);
	  cLib=new CommonLib();
  }

  @AfterMethod
  public void afterMethod() 
  {
	 driver.close();
	 driver.quit();
  }
  @DataProvider(name="readData")
  public Object[][] readData() throws Exception
  {
	String path="C:\\Users\\mkarthik\\Downloads\\SalesForceId\\SalesForceId\\src\\test\\resources\\com\\salesforce\\testData\\SalesForce.xlsx";
	String sheet="Sheet1";
	ExcelLib eLib=new ExcelLib(path);
	int row=eLib.getRowCount(path, sheet);
	int col=eLib.getColCount(path, sheet);
	Object[][]obj=new Object[row][col];
	for(int i=1;i<=row;i++)
	{
		String section=eLib.getExcelData(path, sheet, i, 0);
		String campaignName=eLib.getExcelData(path, sheet, i, 1);
		String fromname=eLib.getExcelData(path, sheet, i, 2);
		String frommail=eLib.getExcelData(path, sheet, i, 3);
		String template=eLib.getExcelData(path, sheet, i, 4);
		String subject=eLib.getExcelData(path, sheet, i, 5);
		String content=eLib.getExcelData(path, sheet, i, 6);
		
		obj[i-1][0]=section;
		obj[i-1][1]=campaignName;
		obj[i-1][2]=fromname;
	    obj[i-1][3]=frommail;
	    obj[i-1][4]=template;
	    obj[i-1][5]=subject;
	    obj[i-1][6]=content;
	}
	return obj;
  }
}
