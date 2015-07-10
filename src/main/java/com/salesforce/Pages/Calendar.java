package com.salesforce.Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;
/**
 * This class contains methods to handle calendar element
 * @author mkarthik
 *
 */
public class Calendar extends CommonLib
{
	@FindBy(xpath="//*[@class='datepickerMonth']/descendant::span")
	private WebElement current_month;
	
	@FindBy(xpath="//*[@class='datepickerGoNext']/descendant::span")
	private WebElement next_month;
	
	@FindBy(xpath="//*[@class='datepickerGoPrev']/descendant::span")
	private WebElement prev_month;
	
	CommonLib cLib;
	
	public Calendar()
	{
		cLib=new CommonLib();
	}
	
	public void selectDate(String year,String month,String date)
	{
		String curr_month=current_month.getText();
		String dates[]=curr_month.split(",");
		int curr_year=Integer.parseInt(dates[1].trim());
		int exp_year=Integer.parseInt(year);
		if(exp_year==curr_year)
		{
			current_month.click();
			selectMonth(month, dates);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectDate(date);
		}
		else
		{
			current_month.click();
			if(exp_year<curr_year)
			{
				while(exp_year!=curr_year)
				{
					prev_month.click();
					curr_year=Integer.parseInt(Driver.driver.findElement(By.xpath("//*[@class='datepickerViewMonths']/descendant::*[@class='datepickerMonth']/descendant::span")).getText());
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectMonth(month, dates);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectDate(date);
			}
			else
			{
				while(exp_year!=curr_year)
				{
				  next_month.click();
				  curr_year=Integer.parseInt(Driver.driver.findElement(By.xpath("//*[@class='datepickerViewMonths']/descendant::*[@class='datepickerMonth']/descendant::span")).getText());
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectMonth(month, dates);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				selectDate(date);
			}
			
		}
	}

	private void selectDate(String date) {
		List<WebElement>lisDays=Driver.driver.findElements(By.xpath("//*[@class='datepickerDays']/tr/td/a/span"));
		Iterator<WebElement>iteDays=lisDays.iterator();
		while(iteDays.hasNext())
		{
			WebElement days=iteDays.next();
		    String value=days.getText();
		    int actDate=Integer.parseInt(value);
		    int expDate=Integer.parseInt(date);
		    if(actDate==expDate)
		    {
		    	days.click();
		    	break;
		    }
		}
	}
	private void selectMonth(String month, String[] dates) {
			List<WebElement>months=Driver.driver.findElements(By.xpath("//*[@class='datepickerViewMonths']/descendant::*[@class='datepickerMonths']/descendant::span"));
			Iterator<WebElement>itemonth=months.iterator();
			while(itemonth.hasNext())
			{
				WebElement monthElement=itemonth.next();
				String value=monthElement.getText();
				if(month.contains(value))
				{
					monthElement.click();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Driver.driver.findElement(By.xpath("//*[*[contains(text(),'Date of Birth')]]/following-sibling::*/descendant::*[contains(@class,'dateField')]/following-sibling::*/*[@class='icon-calendar']")).click();
					break;
				}
			}
	}
}
