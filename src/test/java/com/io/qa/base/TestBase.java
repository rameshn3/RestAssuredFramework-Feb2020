package com.io.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class TestBase {
	public static Properties prop=null;
	public static Logger log=Logger.getLogger("RestaAssuredTesting");
	/**
	 * This method fetches the property value 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String readProperty(String key) throws IOException {
		
		//Create Object for Properties class
		prop=new Properties();
		//create Object for File class
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\io\\qa\\config\\config.properties");
		//create object for FileInputStream
		FileInputStream fis=new FileInputStream(f);
		
		//load the properties
		prop.load(fis);
		
		return prop.getProperty(key); 
	}
}
