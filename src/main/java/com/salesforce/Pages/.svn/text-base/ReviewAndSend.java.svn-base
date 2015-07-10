package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.GenericLib.CommonLib;

public class ReviewAndSend extends CommonLib
{
	@FindBy(xpath="//*[@id='saveAndSend']")	
	private WebElement sendButton;

	public boolean sendMail()
	{
		boolean sendStatus=false;
		sendButton.click();
		WebElement sendText=waitForElementByXpath("//span[text()='Sending...']");
		if(sendText!=null)
		{
			sendStatus=true;
		}
	  return sendStatus;	
	}
}

