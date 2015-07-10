package com.salesforce.TestCases;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.GenericLib.CommonLib;
import com.GenericLib.Constants;
import com.GenericLib.Driver;
import com.GenericLib.ReportDemo;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest {
	WebDriver driver;
	String title="dummy";
	static ExtentReports extent;
	static CommonLib cLib;
	String acttitle;
	
  @Test
  public void test() throws InterruptedException 
  {
	  //extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_OLDEST_TO_LATEST,GridType.STANDARD);
	  extent.startTest("starting google launch test...");
	  driver.get("http://www.google.com");
	  Thread.sleep(5000);
	  acttitle=driver.getTitle();
	  if(acttitle.equals(title))
	  {
		  extent.attachScreenshot(ReportDemo.createScreenshot(Driver.driver),"This is to attach screenshot for test");
		  extent.log(LogStatus.PASS,"the testcase is completed(logStatus, details)");
          extent.config().useExtentFooter(false);
	  }
	  else
	  {
		  //System.out.println(CommonLib.createScreenshot(Driver.driver));
		  extent.attachScreenshot(ReportDemo.createScreenshot(Driver.driver),"This is to attach screenshot for test");
		 // extent.attachScreenshot(CommonLib.createScreenshot(Driver.driver),"This is to attach screenshot for test");
		  extent.log(LogStatus.FAIL, title, "test failed an email not sentlogStatus, details");
	      org.testng.Assert.fail();
	  }
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=Driver.getWebDriver();
	  cLib=new CommonLib();
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() 
  {
	  extent=ExtentReports.get(NewTest.class);
	  extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_LATEST_TO_OLDEST,GridType.STANDARD);
	  extent.config().displayTestHeaders(true);
	  extent.config().documentTitle("Salesforce report");
      extent.config().reportHeadline("Test Execution Report for Salesforce");
      extent.startTest("This Test to check the login and create Campaign..");
      extent.config().displayCallerClass(false);
  }

  @AfterClass
  public void afterClass() 
  {
	  extent.endTest();  
  }

}
