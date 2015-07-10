package com.salesforce.Pages;

import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class TopMenuBar extends CommonLib
{
	@FindBy(id="menubar_item_Calendar")
	WebElement calendar;
	
	@FindBy(id="menubar_item_Leads")
	WebElement leads;
	
	@FindBy(id="menubar_item_Accounts")
	WebElement organization;
	
	@FindBy(id="menubar_item_Contacts")
	WebElement contacts;
	
	@FindBy(id="menubar_item_Potentials")
	WebElement opportunity;
	
	@FindBy(id="menubar_item_HelpDesk")
	WebElement tickets;
	
	@FindBy(id="menubar_item_Documents")
	WebElement documents;
	
	@FindBy(id="menubar_item_MailManager")
	WebElement mail;
	
	@FindBy(id="menubar_item_Reports")
	WebElement report;
	
	@FindBy(xpath="//li[@id='moreMenu']/a[@class='dropdown-toggle']")
	WebElement all;
	
	public CalendarPage clickOnCalendar()
	{
		calendar.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, CalendarPage.class);
	}
	
	public LeadsPage clickOnLeads()
	{
		leads.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, LeadsPage.class);
	}
	public OrganizationPage clickOnOrganization()
	{
		organization.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, OrganizationPage.class);
	}
	public ContactsPage clickOnContacts()
	{
		contacts.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, ContactsPage.class);
	}
	public OpportunitiesPage clickOnOpportunities()
	{
		opportunity.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, OpportunitiesPage.class);
	}
	public TicketsPage clickOnTickets()
	{
		tickets.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, TicketsPage.class);
	}
	public DocumentsPage clickOnDocuments()
	{
		documents.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, DocumentsPage.class);
	}
	public MailManagerPage clickOnMailManager()
	{
		mail.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, MailManagerPage.class);
	}
	public ReportsPage clickOnReports()
	{
		report.click();
		waitForPageLoad();
		return PageFactory.initElements(Driver.driver, ReportsPage.class);
	}
	public Object selectSection(String sectionName)
	{
		Object page = null;
		all.click();
		if(sectionName.equals("Email Campaigns"))
		{
		findElementByXpath("//div[@class='menu-item']/*[text()='"+sectionName+"']").click();
		                            page=PageFactory.initElements(Driver.driver, EmailCampaignPage.class);
	    }
		                            
		 else if(sectionName.equals("Quotes"))
          {
          }		  
		  else{
		  System.out.println("invalid section..");
		       }
		}
		return page;
	}
	
	
	
	
	
	
	
	
	
	

}
