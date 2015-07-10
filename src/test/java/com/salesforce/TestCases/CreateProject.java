package com.salesforce.TestCases;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.Locatable;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.GenericLib.commonFunctions;
import com.gargoylesoftware.htmlunit.javascript.host.KeyboardEvent;
import com.google.common.base.Stopwatch;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class CreateProject {

	commonFunctions cFuncs;
	WebDriver driver;
	int time_between_upload;
	StopWatch watch;
	//ExcelLib eLib;
	
	@BeforeSuite
	public void chec()
	{
		watch=new StopWatch();
		watch.start();
		
	}
	@Test
	public void testCreateFolder() throws Exception 
	{
	   /*Properties prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\cq\\config\\config.properties");
		prop.load(fs);
		int time_between_uploads=Integer.parseInt(prop.getProperty("time_between_uploads"));*/
		String url="http://author-under-armour-stage-aem6sp1.adobecqms.net/projects";
	    String username="pm_brand";
	    String password="UAvendor22";
//	    int child_folders=Integer.parseInt(prop.getProperty("childfolders_count"));
//	    String filePath=prop.getProperty("path_of_file");
//	    String child_foldername=child_folder;
//	    String [] path=filePath.split("/");
		
	    //System.out.println(url);
	    //System.out.println(username+" "+password);
	    
	    System.out.println("functions: "+cFuncs);
	    System.out.println("Webdriver: "+driver);
	    //cFuncs.openApp(url, driver);
	    driver.get(url);
		driver.manage().window().maximize();
		
		cFuncs.waitForElementTobePresentXpath("//input[contains(@name,'username')]", driver);
		cFuncs.eneterDataXpath("//input[contains(@name,'username')]", username, driver);
		cFuncs.eneterDataXpath("//input[contains(@name,'password')]", password, driver);
		cFuncs.clickOnElementXpath("//*[contains(@id,'login-submit') and contains(text(),'Sign In')]", driver);
		Thread.sleep(10000);
		
		cFuncs.clickOnElementXpath("//a[@id='create-pulldown']", driver);
		cFuncs.waitForElementTobePresentXpath("//h4[text()='Marketing Project']", driver);
		cFuncs.clickOnElementXpath("//h4[text()='Marketing Project']", driver);
		cFuncs.clickOnElementXpath("//ol/following-sibling::button[text()='Next']", driver);
		
		cFuncs.waitForElementTobePresentXpath("//select[@name='accountdropdown']", driver);
		cFuncs.selectByIndexUsingXpath(driver, "//select[@name='accountdropdown']", 1);
		cFuncs.selectByIndexUsingXpath(driver, "//select[@name='endusedropdown']", 2);
		cFuncs.selectByIndexUsingXpath(driver, "//select[@name='campaigndropdown']", 3);
		cFuncs.selectByIndexUsingXpath(driver, "//select[@name='creativedropdown']", 2);
		cFuncs.clickOnElementXpath("//span[@id='member-role']/select[@class='coral-Select-select coral-Select-select--native']", driver);
		Thread.sleep(5000);
		//Robot robo=new Robot();
		List<WebElement> lis=driver.findElements(By.xpath("//ul[@id='coral-4']/li"));
		lis.get(5).click();
		WebElement ele=driver.findElement(By.xpath("//span[@id='member-role']/select[@class='coral-Select-select coral-Select-select--native']/*[contains(text(),'Designer')]"));
		cFuncs.mouseOverElement(ele,driver);
		cFuncs.eneterDataXpath("//table[@id='']/descendant::tr/td[2]/div/div/div/input", "Designer_brand", driver);
		cFuncs.waitForElementTobePresentXpath("//ul[@role='group']/descendant::li/descendant::b", driver);
		cFuncs.clickOnElementXpath("//ul[@role='group']/descendant::li/descendant::b", driver);
		cFuncs.clickOnElementXpath("//button[text()='Add']", driver);
		
		cFuncs.clickOnElementXpath("//a[text()='Project Details']", driver);
		Thread.sleep(8000);
		cFuncs.clickOnElementXpath("//*[@name='ua-project-season']", driver);
		cFuncs.clickOnElementXpath("//*[contains(@class,'SelectList') and text()='SS17']", driver);
		//cFuncs.selectByIndexUsingXpath(driver, "//select[@name='ua-project-season']", 2);
		//cFuncs.selectByIndexUsingXpath(driver, "//select[@name='ua-account']", 1);
		cFuncs.clickOnElementXpath("//*[@name='ua-account']", driver);
		cFuncs.clickOnElementXpath("//*[contains(@class,'SelectList') and text()='24 HOUR FITNESS']", driver);
		cFuncs.clickOnElementXpath("html/body/form/div[2]/div/div[2]/div/section[3]/div[1]/div[3]/div/span/button", driver);
		Thread.sleep(8000);
		cFuncs.clickOnElementXpath("html/body/div[1]/div[1]/div[1]/div[2]/table/tbody/tr[4]/td[5]/a", driver);
		cFuncs.clickOnElementXpath("//ol/following-sibling::button[text()='Create']", driver);
		cFuncs.waitForElementTobePresentXpath("html/body/div[3]/div[3]/a[1]", driver).click();
	    
	}
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		
		//System.out.println(Thread.currentThread().getId());
		cFuncs=new commonFunctions();
		//eLib=new ExcelLib();
		Thread.sleep(5000);
	    //System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe"); 
		driver=new FirefoxDriver();
	}
	@AfterClass
	public void breakdown()
	{
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void done()
	{
		watch.stop();
		System.out.println(watch.getTime());
	}
}
