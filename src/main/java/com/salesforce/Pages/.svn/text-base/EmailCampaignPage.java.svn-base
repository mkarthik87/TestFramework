package com.salesforce.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class EmailCampaignPage extends CommonLib 
{
  @FindBy(id="EmailCampaigns_listView_basicAction_Add")
  private WebElement newEmailCampaign;
  
  @FindBy(xpath="//li[@id='EmailCampaigns_listView_basicAction_LBL_REGULAR_CAMPAIGN']/a[text()='Regular Campaign']")
  private WebElement regularCampaign;
  
  public RegularCampaign createRegularCampaigns()
  {
	  newEmailCampaign.click();
	  
	  regularCampaign.click();
	  waitForPageLoad();
	  return PageFactory.initElements(Driver.driver, RegularCampaign.class);
  }
}
