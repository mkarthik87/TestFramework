package com.GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver 
{
	public static WebDriver driver;
	
	public static WebDriver getWebDriver()
	{
		if(Constants.browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Constants.browser.equalsIgnoreCase("ie"))
		{
			String ie_driver=System.getProperty("user.dir")+"/src/main/resources/com/drivers/IEDriverServer.exe ";
			System.setProperty("webdriver.ie.driver",ie_driver);
			driver=new InternetExplorerDriver();
		}
		else if(Constants.browser.equalsIgnoreCase("chrome"))
		{
			String chrome_driver=System.getProperty("user.dir")+"/src/main/resources/com/drivers/chromedriver.exe ";
			System.setProperty("webdriver.chrome.driver", chrome_driver);
			driver=new ChromeDriver();		
		}
		return driver;
	}
}
