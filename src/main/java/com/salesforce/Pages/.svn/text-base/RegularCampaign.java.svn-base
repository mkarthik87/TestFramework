package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class RegularCampaign extends CommonLib
{
	CampaignDetailsPage cPage;
	SubscriptionPage sPage;
	TemplateSelectionPage tPage;
	ReviewAndSend rPage;
	
	public RegularCampaign() {
		cPage=PageFactory.initElements(Driver.driver, CampaignDetailsPage.class);
	}
	
	public boolean createAndMailCampaign(String campaignName, String fromName,String fromMail,String templateName,String subject,String content) throws InterruptedException
	{
		boolean status=false;
		sPage=cPage.createCampaignDetails(campaignName, fromName, fromMail);
		tPage=sPage.selectSubscription();
		rPage=tPage.selectTemplate(templateName, subject,content);
		status=rPage.sendMail();
		return status;
	}
}
