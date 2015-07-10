package com.salesforce.Pages;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class ContactsPage 
{
	CommonLib cLib;
	public ContactsPage()
	{
		cLib=new CommonLib();
	}
  @FindBy(id="Contacts_listView_basicAction_LBL_ADD_RECORD")
  private WebElement addContacts;
  
  public EditContactPage AddContacts()
  {
	  addContacts.click();
	  cLib.waitForElementByXpath("//*[@id='Contacts_editView_fieldName_firstname']");
	  return PageFactory.initElements(Driver.driver, EditContactPage.class);
  }
  
}
