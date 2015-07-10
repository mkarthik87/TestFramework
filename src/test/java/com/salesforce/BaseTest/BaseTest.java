package com.salesforce.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.GenericLib.CommonLib;
import com.GenericLib.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.salesforce.BusinessLib.BusinessLib;

public class BaseTest 
{
  ExtentReports extent;
  WebDriver driver;
  BusinessLib bLib;
  CommonLib cLib;
}
