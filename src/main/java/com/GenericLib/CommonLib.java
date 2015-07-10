package com.GenericLib;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib
{
	//WebDriver.driver Driver.driver;
	WebDriverWait wait;
	
	public CommonLib()
	{
		//Driver.driver=Driver.driver.Driver.driver;
		wait=new WebDriverWait(Driver.driver,50);
	}
	 public void openApp(String url)
	 {
		 Driver.driver.get(url);
		 Driver.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Driver.driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		 Driver.driver.manage().window().maximize();
	 }
	  
	public WebElement waitForElementByXpath(String xpath)
	{
	  return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public WebElement findElementByXpath(String xpath)
	{
		WebElement element=null;
		try{
		  element=waitForElementByXpath(xpath);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element not found with xpath: "+xpath);
		}
		return element;
	}
	public void waitForPageLoad()
	{
		Driver.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	public static String createScreenshot(WebDriver driver) {
        
        UUID uuid = UUID.randomUUID();
       
     
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
           org.apache.commons.io.FileUtils.copyFile(scrFile, new File(Constants.report_path + Constants.imageLocation + uuid + ".png"));
           System.out.println(Constants.imageLocation  + uuid + ".png");
        } catch (IOException e) {
            System.out.println("Error while generating screenshot:\n" + e.toString());
        }
        return Constants.report_path + Constants.imageLocation + uuid + ".png";
       
    }

}
