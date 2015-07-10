package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Constants;
import com.GenericLib.Driver;

public class LoginPage extends CommonLib{
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='com-form-login-submit']")
	private WebElement loginButton;
	
	public HomePage login()
	{
		username.sendKeys(Constants.username);
		password.sendKeys(Constants.password);
		loginButton.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, HomePage.class);
	}
	
}
