package com.salesforce.BusinessLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.GenericLib.CommonLib;
import com.salesforce.Pages.LoginPage;
import com.salesforce.Pages.HomePage;

public class BusinessLib 
{
  WebDriver driver;
  CommonLib cLib;
  LoginPage lPage;
  HomePage wPage;
  

 public BusinessLib(WebDriver drivers)
 {
	cLib=new CommonLib();
	lPage=new LoginPage();
	wPage=new HomePage();
 }
 
  
 /* public boolean login(String url,String userName,String password)
  {
	  boolean login_status=false;
	  
	  cLib.openApp(url);
	  cLib.findElementByXpath(wPage.loginButton).click();
	  
	  cLib.findElementByXpath(lPage.username).sendKeys(userName);
	  cLib.findElementByXpath(lPage.password).sendKeys(password);
	  cLib.findElementByXpath(lPage.submit).click();
	  
	  return false;	  
  }*/
  
}
