package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.exceptions.BrowserExceptions;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is used to initialize the driver on the basis of given browsername
	 * @param browserName
	 * @return It returns driver
	 */
	
	public WebDriver intiDriver(Properties prop) {
		
		String browserName=  prop.getProperty("browser");
		
		switch (browserName) {
		case "chrome":
			 driver= new ChromeDriver();
			break;
		case "firefox":
			 driver= new FirefoxDriver();
			break;
		case "edge":
			 driver= new EdgeDriver();
			break;
		case "safari":
			 driver= new SafariDriver();
			break;
		default:
			System.out.println("Please pass the correct browser name :" +browserName);
			throw new BrowserExceptions("BROWSER NOT VALID!!"   +browserName);
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	
	return driver;
	
	}
	
	/*
	 * This method is used to initialize the property from config file
	 */
	
	public Properties initProp() {
		prop= new Properties();
		try {
			FileInputStream ip =new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
