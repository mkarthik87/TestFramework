package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.Driver;

public class CampaignDetailsPage 
{
	@FindBy(id="EmailCampaigns_editView_fieldName_campaignname")
	private WebElement campaignName;
	
	@FindBy(id="EmailCampaigns_editView_fieldName_fromname")
	private WebElement fromName;
	
	@FindBy(id="EmailCampaigns_editView_fieldName_fromemail")
	private WebElement fromMail;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement nextButton;
	
	public SubscriptionPage createCampaignDetails(String campainName,String fromName,String fromMail)
	{
		campaignName.sendKeys(campainName);
		this.fromName.sendKeys(fromName);
		this.fromMail.sendKeys(fromMail);
		nextButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PageFactory.initElements(Driver.driver, SubscriptionPage.class);
	}

}
