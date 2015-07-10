package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class SubscriptionPage extends CommonLib
{
	@FindBy(xpath="//div[@class='steps wizardRight']/descendant::*[@id='radio_1']")
	private WebElement selectionGroup;
	
	@FindBy(xpath="//div[@class='steps wizardRight']/descendant::*[@class='btn btn-success nextStep currentActive']")
	private WebElement nextButton;
	
	public TemplateSelectionPage selectSubscription()
	{
		selectionGroup.click();
		nextButton.click();
		waitForPageLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PageFactory.initElements(Driver.driver, TemplateSelectionPage.class);
	}
}
