package com.salesforce.Pages;

import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class HomePage 
{
  TopMenuBar menubar;
  CommonLib cLib;
  
  public HomePage() 
  {
	  cLib=new CommonLib();
	menubar=PageFactory.initElements(Driver.driver, TopMenuBar.class);
  }
  public EmailCampaignPage clickOnEmail(String sectionName)
  {
	  Object object=menubar.selectSection(sectionName);
	  EmailCampaignPage emailPage=(EmailCampaignPage)object;
	  return emailPage;
  }
  public ContactsPage clickOnContacts()
  {
	  Object object=menubar.clickOnContacts();
	  ContactsPage contactPage=(ContactsPage)object;
	  cLib.waitForElementByXpath("//*[@class='btn addButton']");
	  return contactPage;
  }
}
