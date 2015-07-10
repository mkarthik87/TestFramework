package com.salesforce.TestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericLib.CommonLib;
import com.GenericLib.Constants;
import com.GenericLib.Driver;
import com.GenericLib.ExcelLib;
import com.GenericLib.LogReport;
import com.GenericLib.ReportDemo;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;
import com.salesforce.BusinessLib.BusinessLib;
import com.salesforce.Pages.ContactsPage;
import com.salesforce.Pages.EditContactPage;
import com.salesforce.Pages.EmailCampaignPage;
import com.salesforce.Pages.HomePage;
import com.salesforce.Pages.LoginPage;
import com.salesforce.Pages.RegularCampaign;
/**
 * 
 * @author mkarthik
 *This test case is to verify the creation of contact
 */
public class CreateContactTest
{
	WebDriver driver;
	BusinessLib bLib;
	CommonLib cLib;
	ExtentReports extent;
	Logger log;
	@BeforeClass
	public void prepare_reports()
	{
		log=LogReport.getLogObj(CreateContactTest.class);
		extent=ExtentReports.get(CreateContactTest.class);
		extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_OLDEST_TO_LATEST,GridType.STANDARD);
	    extent.config().displayTestHeaders(true);
	    extent.config().documentTitle("Salesforce report");
        extent.config().reportHeadline("Test Execution Report for Salesforce");
        extent.startTest("This Test to check the login and create Campaign..");
        extent.config().displayCallerClass(false);
        log.info("Extent reports configured...");
        
	}
	/**
	 * Data is read from excel for creation of contacts
	 * @param fName
	 * @param pMail
	 * @param mPhone
	 * @param lName
	 * @param year
	 * @param month
	 * @param date
	 * @throws InterruptedException
	 */
	@Test(dataProvider="readData1")
	public void createContact(String fName,String pMail,String mPhone,String lName,String year,String month,String date) throws InterruptedException
	{
		log.info("Parametrs passed: "+fName+" "+pMail+" "+mPhone+" "+lName+" "+year+" "+month+" "+date);
		extent.init(Constants.report_path+"ScreenshotReport.html", true,DisplayOrder.BY_OLDEST_TO_LATEST,GridType.STANDARD);
		String url=Constants.url;
		extent.startTest("CreateContactTest", "This test case is to test the contact creation...");
		log.info("Starting tescase execution....");
		boolean status=false;
		cLib.openApp(url);
		LoginPage lPage=PageFactory.initElements(driver, LoginPage.class);
		HomePage hPage=lPage.login();
		log.info("Logged into application...");
		extent.log(LogStatus.INFO, "logged into application...");
		ContactsPage cPage=hPage.clickOnContacts();
		log.info("Clicked on contacts...");
		EditContactPage ePage=cPage.AddContacts();
		log.info("Clicked on add contacts...");
		status=ePage.createContact(fName, pMail, mPhone, lName, year, month, date);
		log.info("Created contact...");
		if(status==true)
		{
			log.info("Creation of contact is successfull...");
			extent.log(LogStatus.PASS, "CreateContact completed..");
			extent.attachScreenshot(ReportDemo.createScreenshot(Driver.driver), "Created contact...");
		}
		else
		{
			log.error("Creation of contact failed...");
			extent.log(LogStatus.FAIL, "CreateContact failed..");
			extent.attachScreenshot(ReportDemo.createScreenshot(Driver.driver), "Created contact...");
		}
		extent.endTest();	
		log.info("Test execution completed...");
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
  /**
   * Data provider for reading data from excel
   * @return
   * @throws Exception
   */
  @DataProvider(name="readData1")
  public Object[][] readData() throws Exception
  {
	String path="C:\\Users\\mkarthik\\Downloads\\SalesForceId\\SalesForceId\\src\\test\\resources\\com\\salesforce\\testData\\SalesForce.xlsx";
	String sheet="Sheet2";
	ExcelLib eLib=new ExcelLib(path);
	int row=eLib.getRowCount(path, sheet);
	int col=eLib.getColCount(path, sheet);
	Object[][]obj=new Object[row][col];
	for(int i=1;i<=row;i++)
	{
		String fName=eLib.getExcelData(path, sheet, i, 0);
		String pMail=eLib.getExcelData(path, sheet, i, 1);
		String mPhone=eLib.getExcelData(path, sheet, i, 2);
		String lName=eLib.getExcelData(path, sheet, i, 3);
		String year=eLib.getExcelData(path, sheet, i, 4);
		String month=eLib.getExcelData(path, sheet, i, 5);
		String date=eLib.getExcelData(path, sheet, i, 6);
		
		
		obj[i-1][0]=fName;
		obj[i-1][1]=pMail;
	    obj[i-1][2]=mPhone;
	    obj[i-1][3]=lName;
	    obj[i-1][4]=year;
	    obj[i-1][5]=month;
	    obj[i-1][6]=date;
	}
	return obj;
  }
}
