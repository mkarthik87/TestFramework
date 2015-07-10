package com.GenericLib;

import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.sun.media.sound.Toolkit;
/**
 * This class contains methods which are generic in nature
 * @author mkarthik
 *
 */
public class commonFunctions{
	commonFunctions fun;
	public static boolean upload=false;
	public static Thread curThread=null;
	WebDriver driver;
	/**
	 * This function is used to open the application 
	 * @param url
	 * @param expTitle
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 */
	public boolean openApp(String url, WebDriver driver) throws InterruptedException
	{
		boolean open=false;
		try{
			System.out.println(driver);
			driver.get(url);
			//driver.manage().window().maximize();
			fun=new commonFunctions();
			//fun.waitForPageToLoad(driver);
			//String title=null;
			/*title=fun.getCurrentTitle(driver);
			boolean res=title.equals(expTitle);
			if(res==true)
			{
				open=true;
			}*/
			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
			//APPLICATION_LOGS.info("Successfully launched the URL in browser");
		}
		catch(Exception e)
		{
			
		}
			return open;
	}
	/**
	 * this function is used to get the current page title
	 * @param driver
	 * @return
	 */
	public String getCurrentTitle(WebDriver driver)
	{
		String title=null;
		title=driver.getTitle();
		return title;
	}
	/**
	 * this function is used to enter the data to the element as specified by xpath
	 * @param xPaths
	 * @param data
	 * @param driver
	 * @return
	 */
	public boolean eneterDataXpath(String xPaths,String data,WebDriver driver)
	{
		boolean enter;
		fun=new commonFunctions();
		WebElement ele=fun.isElementPresentByXpath(xPaths, driver);
		if(ele==null)
		{
			//Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+xPaths);
			enter=false;
		}
		else
		{
			ele.sendKeys(data);
			enter=true;
		}
		return enter;
	}
	/**
	 * this function is used to enter the data to the element as specified by element
	 * @param ele
	 * @param data
	 * @return
	 */
	public boolean eneterDataToElement(WebElement ele,String data)
	{
		boolean enter = false;
		fun=new commonFunctions();
		try{
			
		if(ele==null)
		{
			enter=false;
		}
		else
		{	
	     ele.sendKeys(data);
	     enter=true;
		}
		}
		catch(Exception e)
		{
		  System.out.println("element not available...");	
		}
		return enter;
	}
	/**
	 * this function is used to enter the data to the element as specified by id
	 * @param id
	 * @param data
	 * @param driver
	 * @return
	 */
	public boolean eneterDataId(String id,String data,WebDriver driver)
	{
		boolean enter;
		fun=new commonFunctions();
		WebElement ele=fun.isElementPresentById(id, driver);
		if(ele==null)
		{
			//Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+id);
			enter=false;
		}
		else
		{
			ele.sendKeys(data);
			enter=true;
		}
		return enter;
	}
	/**
	 * this function is used to enter the data to the element as specified by name
	 * @param name
	 * @param data
	 * @param driver
	 * @return
	 */
	public boolean eneterDataName(String name,String data,WebDriver driver)
	{
		boolean enter;
		fun=new commonFunctions();
		WebElement ele=fun.isElementPresentByName(name, driver);
		if(ele==null)
		{
			//Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+name);
			enter=false;
		}
		else
		{
			ele.sendKeys(data);
			enter=true;
		}
		return enter;
	}
	/**
	 * this function is used to verify if the element is available as specified by xpath
	 * @param xPaths
	 * @param driver
	 * @return
	 */
	public WebElement isElementPresentByXpath(String xPaths,WebDriver driver)
	{
		WebElement ele=null;
		try
		{
	    ele=driver.findElement(By.xpath(xPaths));
		}
		catch(Exception e)
		{
			System.out.println("element not avaialable...");
		}
	    //System.out.println(ele);
		/*if(ele==null)
		{
		   Assert.assertNull(ele,"element not present..");
		   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+xPaths);
		   return ele;
		}
		else
		{
			return ele;
		}*/
		return ele;
	}
	/**
	 * this function is used to verify if the element is available as specified by id
	 * @param id
	 * @param driver
	 * @return
	 */
	public WebElement isElementPresentById(String id,WebDriver driver)
	{
		boolean present;
		WebElement ele=driver.findElement(By.id(id));
		if(ele==null)
		{
		   Assert.assertNull(ele,"element not present..");
		   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+id);
		   return ele;
		}
		else
		{
			return ele;
		}
	}
	/**
	 * this function is to verify if the element is available as specified by name
	 * @param name
	 * @param driver
	 * @return
	 */
	public WebElement isElementPresentByName(String name,WebDriver driver)
	{
		boolean present;
		WebElement ele=driver.findElement(By.xpath(name));
		if(ele==null)
		{
		   Assert.assertNull(ele,"element not present..");
		   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+name);
		   return ele;
		}
		else
		{
			return ele;
		}
	}
	/**
	 * This function is used to wait until the entire page is loaded
	 * @param driver
	 */
    public void waitForPageToLoad(WebDriver driver)
    {
    	driver.manage().timeouts().pageLoadTimeout(7000, TimeUnit.MILLISECONDS);
    }
    /**
     * This function is used to wait until the element is available as specified by xpath
     * @param xPaths
     * @param driver
     * @return
     */
    public WebElement waitForElementTobePresentXpath(String xPaths,WebDriver driver)
    {
    	WebElement ele;
    	WebDriverWait wait=new WebDriverWait(driver, 7000);
        ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPaths)));
		if(ele==null)
		{
			   Assert.assertNotNull(ele,"element not present..");
			   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+xPaths);
			   return ele;
		}
		else
		{
			return ele;
		}
    }
    /**
     * This function is used to wait until the element is available as specified by id
     * @param id
     * @param driver
     * @return
     */
    public WebElement waitForElementTobePresentId(String id,WebDriver driver)
    {
    	WebElement ele;
    	WebDriverWait wait=new WebDriverWait(driver, 3000);
        ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		if(ele==null)
		{
			   Assert.assertNull(ele,"element not present..");
			   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+id);
			   return ele;
		}
		else
		{
			return ele;
		}
    }
    /**
     * this function is used to wait until the element is available as specified by name
     * @param name
     * @return
     */
    public WebElement waitForElementTobePresentName(String name)
    {
    	WebElement ele;
    	WebDriverWait wait=new WebDriverWait(driver, 3000);
        ele=wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		if(ele==null)
		{
			   Assert.assertNull(ele,"element not present..");
			   //Driver.APPLICATION_LOGS.debug("element not present in: "+driver.getTitle()+" "+name);
			   return ele;
		}
		else
		{
			return ele;
		}
    }
    /**
     * to perform click action on an element
     * @param ele
     */
    public void clickOnElement(WebElement ele)
    {
    	try{
    	if(ele==null)
		{
			//Driver.APPLICATION_LOGS.debug("element not present..");
			//enter=false;
		}
		else
		{
			ele.click();
		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("element not present...");
    	}
    }
    /**
     * this function is used to perform click operation on the element as specified by xpath
     * @param xPaths
     * @param driver
     */
    public void clickOnElementXpath(String xPaths,WebDriver driver)
    {
    	fun=new commonFunctions();
    	WebElement ele=fun.isElementPresentByXpath(xPaths, driver);
    	ele.click();
    }
    /**
     * this function is used to perform click operation on the element as specified by id
     * @param id
     * @param driver
     */
    public void clickOnElementId(String id,WebDriver driver)
    {
    	fun=new commonFunctions();
    	WebElement ele=fun.isElementPresentById(id, driver);
    	ele.click();
    }
    /**
     * this function is used to perform mouseover operation on the element
     * @param ele
     * @param driver
     */
    
    public void mouseOverElement(WebElement ele,WebDriver driver)
    {
    	try{
    	if(ele==null)
		{
			//Driver.APPLICATION_LOGS.debug("element not present..");
			//enter=false;
		}
		else
		{
			Actions act=new Actions(driver);
        	act.moveToElement(ele).build().perform();
		}
    	}
 
    	catch(Exception e)
    	{
    		System.out.println("element not present...");
    	}
    	
    }
    /**
     * this function is used to switch to a window which contains the element as specified by xpath
     * @param driver
     * @param xPaths
     * @return
     */
    public WebElement switchToWindowAndFindElement(WebDriver driver,String xPaths)
    {
    	WebElement ele=null;
    	Set<String>setWindows=driver.getWindowHandles();
    	int size=setWindows.size();
    	System.out.println("size: "+size);
    	if(size>1)
    	{
    		Iterator <String>ite=setWindows.iterator();
    		while(ite.hasNext())
    		{
    			String id=ite.next();
    			driver.switchTo().window(id);
    			try
    			{
    			 ele=fun.isElementPresentByXpath(xPaths, driver);
    			}
    			catch(Exception e)
    			{
    				System.out.println("element not available...");
    			}
    			if(ele!=null)
    			{
    				break;
    			}
    		}
    	}
		return ele; 	
    }
    /**
     * this function is used to perform double click operation on the element
     * @param ele
     * @param driver
     */
    public void doubleClickOnElement(WebElement ele,WebDriver driver)
    {
      Actions act=new Actions(driver);
      act.doubleClick(ele).build().perform();
    }
    /**
     * this function is used to switch to the window as specified by the name
     * @param name
     * @param driver
     */
    public void switchToWindow(String name,WebDriver driver)
    {
    	driver.switchTo().window(name);
    }
    /**
     * this function is used to switch to the window as specified by the id
     * @param driver
     * @param ids
     */
    public void switchToWindow(WebDriver driver,String ids)
    {
    	Set<String>setWindows=driver.getWindowHandles();
    	int size=setWindows.size();
    	if(size>1)
    	{
    		Iterator <String>ite=setWindows.iterator();
    		while(ite.hasNext())
    		{
    			String id=ite.next();
    			if(id.equals(ids))
    			{
    			 driver.switchTo().window(id);
    			 break;
    			}
    		}	
    	}
    }
    /**
     * this function is used to take the snap shot and store in location as specified by path
     * @param driver
     * @param path
     * @throws IOException
     */
    public void takeSnapShot(WebDriver driver,String path) throws IOException
    {
    	EventFiringWebDriver event=new EventFiringWebDriver(driver);
    	File imageFile=event.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(imageFile,new File(path));
    }
    /**
     * this function is used to get the text msg on the pop up
     * @param driver
     * @return
     */
    public static String getPopupMessage(WebDriver driver)
    {
    	String message = null;
    	try 
    	{
    	Alert alert = driver.switchTo().alert();
    	message = alert.getText();
    	} 
    	catch (Exception e)
    	{
    	 message = null;
    	}
    	return message;
    }
    /**
     * this function is used to perform the accept action on the alert
     * @param driver
     */
    public static void clickAcceptOnAlert(WebDriver driver) 
    {
    	//String message = null;
    	try
    	{
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	} 
    	catch (Exception e) 
    	{
    	//message = null;
    	}
    }
    /**
     * this function is used to perform the cancel operation on the alert
     * @param driver
     */
    public static void clickCancelOnAlert(WebDriver driver) 
    {
    	//String message = null;
    	try
    	{
    	Alert alert = driver.switchTo().alert();
    	alert.dismiss();
    	} 
    	catch (Exception e) 
    	{
    	//message = null;
    	}
    }
    /**
     * this function is used to high light element 
     * @param driver
     * @param element
     * @throws InterruptedException
     */
    public void highlightElement(WebDriver driver, WebElement element) throws InterruptedException 
    { 
    	for (int i = 0; i < 3; i++) 
    	{
    		JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: green; border: 6px solid green;"); 
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, ""); 
            Thread.sleep(1000);
        } 
    } 
    /**
     * this function is used to select value from the drop down based on value
     * @param driver
     * @param xPaths
     * @param value
     */
    public void selectByValueUsingXpath(WebDriver driver,String xPaths,String value)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(xPaths, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByValue(value);
    }
    /**
     * this function is used to select value from the drop down based on index
     * @param driver
     * @param xPaths
     * @param index
     */
    public void selectByIndexUsingXpath(WebDriver driver,String xPaths,int index)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(xPaths, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByIndex(index);
    }
    /**
     * this function is used to select value from the drop down based on text
     * @param driver
     * @param xPaths
     * @param text
     */
    public void selectByVisbleTextUsingXpath(WebDriver driver,String xPaths,String text)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(xPaths, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByVisibleText(text);
    }
    /**
     *  this function is used to select value from the drop down based on value
     * @param driver
     * @param id
     * @param value
     */
    public void selectByValueUsingId(WebDriver driver,String id,String value)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(id, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByValue(value);
    }
    /**
     *  this function is used to select value from the drop down based on index
     * @param driver
     * @param id
     * @param index
     */
    public void selectByIndexUsingId(WebDriver driver,String id,int index)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(id, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByIndex(index);
    }
    /**
     * this function is used to select value from the drop down based on text
     * @param driver
     * @param id
     * @param text
     */
    public void selectByVisbleTextUsingId(WebDriver driver,String id,String text)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(id, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByVisibleText(text);
    }
    /**
     * this function is used to select value from the drop down based on name
     * @param driver
     * @param name
     * @param value
     */
    public void selectByValueUsingName(WebDriver driver,String name,String value)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(name, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByValue(value);
    }
    /**
     * this function is used to select value from the drop down based on name
     * @param driver
     * @param name
     * @param index
     */
    public void selectByIndexUsingName(WebDriver driver,String name,int index)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(name, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByIndex(index);
    }
    /**
     * this function is used to select value from the drop down based on text
     * @param driver
     * @param name
     * @param text
     */
    public void selectByVisbleTextUsingName(WebDriver driver,String name,String text)
    {
    	fun=new commonFunctions();
    	WebElement dropDown=fun.isElementPresentByXpath(name, driver);
    	Select sel=new Select(dropDown);
    	sel.selectByVisibleText(text);
    }
    /**
     * this function is used to get text from the element as specified by xpath
     * @param driver
     * @param xpath
     * @return
     */
    public String getTextFromElementUsingXpath(WebDriver driver,String xpath)
    {
    	String text=null;
    	fun=new commonFunctions();
    	WebElement ele=fun.isElementPresentByXpath(xpath, driver);
    	text=ele.getText();
		return text;
    }
    /**
     * this function is used to get text from the element as specified by id
     * @param driver
     * @param id
     * @return
     */
    public String getTextFromElementUsingId(WebDriver driver,String id)
    {
    	String text=null;
    	fun=new commonFunctions();
    	WebElement ele=fun.isElementPresentById(id, driver);
    	text=ele.getText();
		return text;
    }
    /**
     * this function is used to get text from the element as specified by name
     * @param driver
     * @param name
     * @return
     */
    public String getTextFromElementName(WebDriver driver,String name)
    {
    	String text=null;
    	fun=new commonFunctions();
    	WebElement ele=fun.isElementPresentByName(name, driver);
    	text=ele.getText();
		return text;
    }
    /**
     * this function is used to get the attribute value of an element
     * @param element
     * @param attribute
     * @return
     */
    public String getAttributeValue(WebElement element,String attribute)
    {
    	String value=null;
    	value=element.getAttribute(attribute);
		return value;    	
    }
    /**
     * this function is used to fail the test case
     */
    public void failTestCase()
    {
        Assert.fail("failing the test case due to unavailability of element");
    }   
    /**
     * this function is used to close the browser
     * @param driver
     */
    public void closeApp(WebDriver driver)
    {
    	driver.close();
    }
    /**
     * this function is used to quit the execution
     * @param driver
     */
    public void quitTest(WebDriver driver)
    {
    	driver.quit();
    }
    /**
     * this function is used to get text from element as specified by xpath
     * @param driver
     * @param xpaths
     * @return
     */
    public String getTextFromAutoComplete(WebDriver driver,String xpaths)
    {
    	String text=null;
    	text=driver.findElement(By.xpath(xpaths)).getText();
    	return text;
    }
    /**
     * this function is used to halt the execution until an element contains specified text 
     * @param driver
     * @param xpaths
     * @param text
     */
    public void waitUntilElementContainsText(WebDriver driver,String xpaths,String text)
    {
    	WebDriverWait wait=new WebDriverWait(driver, 5000);
    	wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpaths), text));
    }    
    /**
     * this function is used to perform drag and drop operation of sliding bar
     * @param driver
     * @param slidingBar
     * @param slider
     * @param x
     * @param y
     * @throws InterruptedException
     */
    public void sliderAndSlidingBar(WebDriver driver,WebElement slidingBar,WebElement slider,int x,int y) throws InterruptedException
    {
    	fun=new commonFunctions();
    	Dimension size=slidingBar.getSize();
		int width=size.width;
	    Actions act=new Actions(driver);
	    fun.highlightElement(driver,slider);
	    act.clickAndHold(slider).build().perform();
	    act.moveByOffset(x,y).build().perform();	
    }
    /**
     * this function is used to perform drag and drop operations
     * @param driver
     * @param srcElement
     * @param targetElement
     */
    public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement targetElement)
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(srcElement, targetElement).build().perform();
    }
    /**
     * this function is used to perform right click operation on a element
     * @param driver
     * @param element
     */
    public void rightClickOnElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element);
    }
    /**
     * this function is used to perform double click operation
     * @param driver
     * @param element
     */
    public void doubleClickOnElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick(element);
    }   
    /**
     * this function is used to perform implicit wait
     * @param driver
     */
    public void implictWait(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    /**
     * this function is used to traverse to previous page
     * @param driver
     */
    public void backToPreviousPage(WebDriver driver)
    {
    	driver.navigate().back();
    }
    /**
     * this function is used to traverse to next page
     * @param driver
     */
    public void forewardPage(WebDriver driver)
    {
    	driver.navigate().forward();
    }
    /**
     * this function is used to referesh the current page
     * @param driver
     */
    public void refresh(WebDriver driver)
    {
    	driver.navigate().refresh();
    }
    /**
     * this function is used to traverse to the specified URL
     * @param driver
     * @param Url
     */
    public void navigateTo(WebDriver driver,String Url)
    {
    	driver.navigate().to(Url);
    }
    /**
     * This function is used to upload a file through Auto-it
     * @param path
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
   /* public boolean uploadFile(String path) throws IOException, InterruptedException
    {
    	System.out.println("in side upload file....");
    	 Thread tupLoad = null;
    	System.out.println("entering upload...");
	  // UploadFile uObjFile=new UploadFile();
	   curThread=Thread.currentThread();
	   try
	   {
		   tupLoad=new Thread(new UploadFile(),"upload");
		   tupLoad.setName("upload");
		   tupLoad.run();
		   try{
			   
			   tupLoad.join();
		   }
		   catch(Exception e)
		   {
			System.out.println("exceptoion occured: "+e);   
		   }
		}
	   catch( Exception e)
	   {
		   System.out.println("exception occured.. "+e);  
		   
	   }	
	   finally
	   {
		   tupLoad.interrupt();
	   }
	   return upload;
    }  */
    public boolean mouseDblClick(WebElement element,WebDriver driver)
	{
    	System.out.println(element);
		boolean result = false;
		try
		{
			String doubleClick = "if(document.createEvent){var evObj = document.createEvent('MouseEvent');evObj.initMouseEvent('dblclick', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('ondblClick');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(doubleClick, element);
			result = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result = false;
		}
		return result;
	}
    public List<WebElement> getListOfElements(WebDriver driver,String xpath)
    {
    	List<WebElement>liWebEle=null;
    	try
    	{
    	liWebEle=driver.findElements(By.xpath(xpath));
    	if(liWebEle.size()>0)
    	{
    	   System.out.println("no of elements: "+liWebEle.size());
    	}
    	else
    	{
    		throw new Exception();
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception: "+e+" webelements not found acctording to xpath: "+xpath);
    	}
    	finally
    	{
		 return liWebEle;
    	}
    }
   /* public boolean Carousel(WebElement clickElement,List<WebElement>dots)
    {
                boolean flag=true;
                fun=new commonFunctions();
                try{
                	   Iterator<WebElement>iteDots=dots.iterator();
                       if(clickElement.getAttribute("class").contains("right"))
                       {
                    	   WebElement elementFirst=iteDots.next();
                    	   String value=elementFirst.getAttribute("class");
                    	   if(value.equals("active"))
                    	   {
                    		   while(iteDots.hasNext())
                    		   {
                    			   clickElement.click();
                    			   WebElement nextElement=iteDots.next();
                            	   String nextValue=elementFirst.getAttribute("class");
                            	   if(!(nextValue.equals("active")))
                            	   {
                            		   flag=false;
                            		   throw new Exception("carousel not working as expected...");
                            	   }
                    		   }
                    	   }
                    	   else
                    	   {
                    		   flag=false;
                    		   throw new Exception("first dot not working as expected...");
                    	   }
                        }
                      
                }
                catch(Exception e)
                {
                     System.out.println("Exception caused...."+e);
                }
          return flag;
    }*/
    public boolean compareImage(String image1,String image2)
    {
      boolean match=false;
      try {

    	   String file1 = image1;
    	   String file2 = image2;

    	   Image pic1= java.awt.Toolkit.getDefaultToolkit().getImage(file1);
    	   Image pic2= java.awt.Toolkit.getDefaultToolkit().getImage(file2);

    	   try {

    	    PixelGrabber grab11 = new PixelGrabber(pic1, 0, 0, -1, -1,
    	      false);
    	    PixelGrabber grab21 = new PixelGrabber(pic2, 0, 0, -1, -1,
    	      false);

    	    int[] array1= null;

    	    if (grab11.grabPixels()) {
    	     int width = grab11.getWidth();
    	     int height = grab11.getHeight();
    	     array1= new int[width * height];
    	     array1= (int[]) grab11.getPixels();
    	    }

    	    int[] array2 = null;

    	    if (grab21.grabPixels()) {
    	     int width = grab21.getWidth();
    	     int height = grab21.getHeight();
    	     array2 = new int[width * height];
    	     array2 = (int[]) grab21.getPixels();
    	    }

    	    System.out.println("Pixels equal: "+ java.util.Arrays.equals(array1, array2));
    	    match=java.util.Arrays.equals(array1, array2 );

    	   } catch (InterruptedException e1) {
    	    e1.printStackTrace();
    	   }
    	  
    	  } catch (Throwable t) {
    	   // report error
    	  }
      return match;	
    }
    public  boolean verifyCss(WebElement element,String attribute,String expValue) 
    {
boolean verify = false;
String value=null;
try
{
    if(element!=null)
    {
                    value=element.getCssValue(attribute);
                    if(value.equals(expValue))
                    {
                                    //            logs the message
                                    System.out.println("value matches");
                                    verify=true;
                    }
                    else
                    {
                                    //fail step
                                    Assert.fail("failing the test case due to unavailability of element");
                    }
    }
    else
    {
                    throw new NullPointerException();
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
return verify;          
    }
   /* public boolean clickOnElement(WebElement clickElement)
{
                    boolean hasClicked=false;
    try
    {
                    if(clickElement==null)
                    {
                                    ////Driver.APPLICATION_LOGS.debug("element not present..");
                                    throw new NullPointerException();
                                    //enter=false;
                    }
                    else
                    {
                                    clickElement.click();
                                    hasClicked=true;
                    }
    }
    catch(Exception e)
    {
                    System.out.println("element not present...");
    }
    return hasClicked;
}*/
    public boolean verifyText(WebElement element,String expValue)
    {
                    boolean textVerify=false;
                    String acttext=null;
                    try
                    {
                                    if(element!=null)
                                    {
                                                    acttext=element.getText();
                                                    Assert.assertEquals(acttext, expValue, "text not matching..");
                                                    if(acttext.equals(expValue))
                                                    {
                                                                    textVerify=true;
                                                    }
                                    }
                                    else
                                    {
                                      throw new NullPointerException();
                                    }
                    }
                    catch(Exception e)
                    {
                                    System.out.println("text not matching...");
                    }
                    return textVerify;
    }
    public boolean switchToWindow(String title)
        {
                       boolean hasSwitched=false;
                       try
                       {
                                       Set<String>setWindows=driver.getWindowHandles();
                                       int size=setWindows.size();
                                       if(size>1)
                                       {
                                                       Iterator <String>ite=setWindows.iterator();
                                                       while(ite.hasNext())
                                                       {
                                                                       String id=ite.next();
                                                                       {
                                                                                       driver.switchTo().window(id);
                                                                                       driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
                                                                                       String actTitle=driver.getTitle();
                                                                                       if(actTitle.equals(title))
                                                                                       {
                                                                                                      hasSwitched=true; 
                                                                                       }
                                                                                       else
                                                                                       {
                                                                                                       throw new Exception("title after switch did not match");
                                                                                       }
                                                                                       break;
                                                                       }
                                                       }           
                                       }
                                       else
                                       {
                                                       throw new Exception("new Window did not open..");
                                       }
                       }
                       catch(Exception e)
                       {
                                       System.out.println("did not switch to new window...");
                       }
                       return hasSwitched;
        }
    public boolean verifyTitle(String title)
    {
                    boolean hasVerified=true;
                    String currTitle=null;
                    try
                    {
                                    currTitle=driver.getTitle();
                                    if(currTitle.equals(title))
                                    { 
                                                    hasVerified=true;
                                    }
                                    else
                                    {
                                                    throw new Exception("title did not match...");
                                    }
                    }
                    catch(Exception e)
                    {
                                    System.out.println("failed due to title mismatch...");
                    }
                    return hasVerified; 
     }
    public boolean hoveOnElement(WebElement ele)
        {
                        boolean hasMoved=false;
                    try
                    {
                                    if(ele==null)
                                    {
                                                  //  //Driver.APPLICATION_LOGS.debug("element not present..");
                                                 //   enter=false;
                                    }
                                    else
                                    {
                                                    Actions act=new Actions(driver);
                                                    act.moveToElement(ele).build().perform();
                                                    hasMoved=true;
                                    }
                    }
            catch(Exception e)
                    {
                                    System.out.println("element not present...");
                    }
                    return hasMoved;
        }
    public boolean verifyTextOfElement(List<WebElement> elements,List<String>expValue)
    {
                    boolean hasMatched=true;
                    try
                    {
                                    if((elements!=null) &&(expValue!=null))
                                    {
                                                    if(elements.size()==expValue.size())
                                                    {
                                                                    /*
                                                                      * logic to identify the list of elements from the given list of string as locators should go here
                                                                      */
                                                                   // List<WebElement>elements=new ArrayList<WebElement>();//assuming that a list of webelements is given
                                                                    Iterator<WebElement>iteWebElement=elements.iterator();
                                                                    Iterator<String>expString=expValue.iterator();
                                                                    while((iteWebElement.hasNext())&&(expString.hasNext()))
                                                                    {
                                                                                    WebElement element=iteWebElement.next();
                                                                                    String actText=element.getText();
                                                                                    String expText=expString.next();
                                                                                    boolean match=actText.equalsIgnoreCase(expText);
                                                                                    if(match==false)
                                                                                    {
                                                                                                    throw new Exception("String did not match: expected: "+expText+" actual: "+actText);
                                                                                    }
                                                                    }
                                                    }
                                                    else
                                                    {
                                                                    throw new Exception("the no of elements and text are not matching...");
                                                    }
                                    }
                                    else
                                    {
                                                    throw new NullPointerException("list reference is null...");
                                    }
                    }
                    catch(Exception e)
                    {
                                    System.out.println(e.getMessage());
                                    hasMatched=false;
                    }
                    return hasMatched;
    }
    private boolean compareText(String expText,String actText)
    {
                    boolean textMatches=false;
                    try{
                                        Assert.assertNotNull(expText, null);
                                        Assert.assertNotNull(actText, null);
                                                    Assert.assertEquals(actText, expText);
                                                    textMatches=true; 
                     }
                    catch(Exception e)
                    {
                                    System.out.println(e.getMessage());
                    }
                    return textMatches;
    }
    public boolean compareUrl(String url)
    {
                    boolean urlMatches=false;
                    try{
                                        String actUrl=driver.getCurrentUrl();
                                                    boolean match=compareText(url,actUrl);
                                                    if(match==true)
                                                    {
                                                                    urlMatches=true;
                                                                    System.out
																			.println(actUrl+" actual url matches with expected url "+url);
                                                    }
                                                    else
                                                    {
                                                                    throw new Exception("url did not match...expected: "+url+" actUrl: "+actUrl);
                                                    }
                    }
                    catch(Exception e)
                    {
                                    System.out.println(e.getMessage());
                    }
                    return urlMatches;
    }
      public void backToPreviousPage() throws InterruptedException
        {
                    driver.navigate().back();
                    Thread.sleep(4000);
        }
public boolean Carousel(WebElement clickElement,List<WebElement>dots)
{
    boolean flag=true;
   // gen=new commonFunctions();
    try{
            Iterator<WebElement>iteDots=dots.iterator();
           if(clickElement.getAttribute("class").contains("right"))
           {
           WebElement elementFirst=iteDots.next();
           String value=elementFirst.getAttribute("class");
           if(value.equals("active"))
           {
                  while(iteDots.hasNext())
                  {
                         clickElement.click();
                         WebElement nextElement=iteDots.next();
                         String nextValue=elementFirst.getAttribute("class");
                         if(!(nextValue.equals("active")))
                         {
                                
                                throw new Exception("carousel not working as expected...");
                         }
                  }
           }
           else
           {
                 
                  throw new Exception("first dot not working as expected...");
           }
            }
          
    }
    catch(Exception e)
    {
    	flag=false;
         System.out.println(e.getMessage());
    }
return flag;
}

}
