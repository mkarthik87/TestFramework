package com.salesforce.Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;

public class TemplateSelectionPage extends CommonLib
{
	@FindBy(xpath="//*[@class='templateName']")
	private List<WebElement>lisTemplateName;
	
	@FindBy(id="EmailCampaigns_editView_fieldName_emailsubject")
	private WebElement subject;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement iframe;
	
	@FindBy(xpath="//div[@id='step3Container']/descendant::button[@class='btn btn-success nextStep currentActive']")
	private WebElement nextButton;
	
	@FindBy(xpath="//a[text()='Ok,Thanks']")
	private WebElement thanksButton;
	
	public ReviewAndSend selectTemplate(String templateName,String subject,String content) throws InterruptedException
	{
		ReviewAndSend sendPage=null;
		Iterator<WebElement>iteTemplate=lisTemplateName.iterator();
		while(iteTemplate.hasNext())
		{
			String name=iteTemplate.next().getAttribute("title");
			System.out.println("name: "+name);
			if(name.equals(templateName))
			{
			  WebElement ele=findElementByXpath("//div[@class='templateName' and @title='"+name+"']/..");
			  ele.findElement(By.cssSelector("img.thumbnailImage")).click();
			 // Driver.driver.findElement(By.cssSelector("img.thumbnailImage")).click();
			  waitForPageLoad();
			  waitForElementByXpath("//*[@id='EmailCampaigns_editView_fieldName_emailsubject']").clear();
			  this.subject.sendKeys(subject);
			  Driver.driver.switchTo().frame(iframe);
			  findElementByXpath("//table[@class='borderGrey cke_show_border']/descendant::tr[3]/td").clear();
			  Thread.sleep(5000);
			  findElementByXpath("//table[@class='borderGrey cke_show_border']/descendant::tr[3]/td").sendKeys(content);
			  Thread.sleep(5000);
			  Driver.driver.switchTo().defaultContent();
			  nextButton.click();
			  waitForElementByXpath("//a[text()='Ok,Thanks']");
			  thanksButton.click();
			  Thread.sleep(3000);
			  nextButton.click();
			  sendPage=PageFactory.initElements(Driver.driver, ReviewAndSend.class);
			  break;
			}
			else
			{
				System.out.println("no such template...");
			}
		}
		return sendPage;
	}

}
