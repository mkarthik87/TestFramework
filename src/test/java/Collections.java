import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class Collections
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		//driver.setJavascriptEnabled(true);
		driver.get("http://www.javatpoint.com/collections-in-java");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
//		WebDriverWait wait=new WebDriverWait(driver,50);
//	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='menu']/div[1]/descendant::a/span")));
//		
		
		List<WebElement>lis1=driver.findElements(By.xpath("//div[@id='menu']/div[1]/descendant::a/span"));
		List<WebElement>lis2=driver.findElements(By.xpath("//div[@id='menu']/div[3]/descendant::a"));
		
		List<String>lisString=new ArrayList<String>();
		
		System.out.println("**********************************************************************");
		System.out.println("size of lis1: "+lis1.size());
		System.out.println("size of lis2: "+lis2.size());
		System.out.println("**********************************************************************");
		lis1.addAll(lis2);
		System.out.println("***************After adding two list*******************************************************");
		System.out.println(lis1.size());
		System.out.println("**********************************************************************");
		
		Iterator<WebElement>iteLis=lis1.iterator();
		while(iteLis.hasNext())
		{
			String value=iteLis.next().getText();
			lisString.add(value);
		}
		java.util.Collections.sort(lisString);
		System.out.println("sorted string.......");
		int i=0;
		int j=0;
		for (String e : lisString) {
			i=i+1;
			System.out.println(e);
			if(e.contains("Collection Framework"))
			{
				j=i-1;
			}
		}
		lisString.remove(j);
		System.out.println("after removal......");
		for (String e : lisString) {
			
			System.out.println(e);
			if(e.contains("Collection Framework"))
			{
	           
			}
		}
		System.out.println("verify if Collection Framework exists: "+lisString.contains("Collection Framework"));
		lis1.clear();
		System.out.println("size: "+lis1.size());
		driver.close();
	}

}
