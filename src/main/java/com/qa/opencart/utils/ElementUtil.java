package com.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver= driver;
	}
	

	By email= By.id("input-email");
    By password= By.id("input-password");
    
    public WebElement getElement(By locator) {
    	return driver.findElement(email);
    }
    
    public void doSendKeys(By locator, String value) {
    	getElement(locator).sendKeys(value);
    }
    

 

    
    
    
}
