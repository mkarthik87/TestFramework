package com.salesforce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class EditContactPage
{
  @FindBy(id="Contacts_editView_fieldName_firstname")
  private WebElement firstName;
  
  @FindBy(xpath="//*[*[contains(text(),'Primary Email')]]/following-sibling::*/descendant::*[contains(@id,'email')]")
  private WebElement primary_email;
  
  @FindBy(xpath="//*[*[contains(text(),'Mobile Phone')]]/following-sibling::*/descendant::*[contains(@id,'mobile')]")
  private WebElement mobile_phone;
  
  @FindBy(xpath="//tr[1]/descendant::*[*[span[@class='redColor']]]/following-sibling::*/descendant::input")
  private WebElement lastName;
  
  @FindBy(xpath="//*[h3[contains(text(),'Creating')]]/descendant::button[@type='submit']")
  private WebElement save_button;
  
  @FindBy(xpath="//*[*[contains(text(),'Date of Birth')]]/following-sibling::*/descendant::*[contains(@class,'dateField')]/following-sibling::*/*[@class='icon-calendar']")
  private WebElement cal;
  
  Calendar calendar;
  CommonLib cLib;
  
  public EditContactPage()
  {
	  calendar=PageFactory.initElements(Driver.driver, Calendar.class);
	  cLib=new CommonLib();
  }
  
  public boolean createContact(String fName,String pMail,String mPhone,String lName,String year,String month,String date)
  {
	  boolean create_status=false;
	  firstName.sendKeys(fName);
	  primary_email.sendKeys(pMail);
	  mobile_phone.sendKeys(mPhone);
	  lastName.sendKeys(lName);
	  cal.click();
	  calendar.selectDate(year, month, date);
	  save_button.click();
	  cLib.waitForElementByXpath("//*[*[@class='summaryImg']]/following-sibling::*/descendant::*[@class='lastname']");
	  WebElement element=Driver.driver.findElement(By.xpath("//*[*[@class='summaryImg']]/following-sibling::*/descendant::*[@class='lastname']"));
	  if(element.getText().equals(lName))
	  {
		  create_status=true;
	  }
	  return create_status;
  }
}
