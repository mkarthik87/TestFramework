package com.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogReport
{
	static Logger log;
	
	public static Logger getLogObj(Class className)
	{
	  log=Logger.getLogger(className);
	  Properties props = new Properties();
	  try {
		props.load(new FileInputStream(Constants.logPath));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  PropertyConfigurator.configure(props);
	  return log;
	}
}
