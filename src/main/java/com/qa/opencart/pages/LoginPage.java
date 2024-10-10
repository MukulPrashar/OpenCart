package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//1. Private By Locators
	
	private By firstname= By.id("input-email");
	private By password= By.id("input-password");
	private By loginBtn= By.xpath("//input[@type='submit']");
	private By forgotpwdLink= By.linkText("Forgotten Password");
	private By logo= By.cssSelector("img.img-responsive");
	
	
	//2. Public Page Const.
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	
		
	}
	
	//3. Public Page Actions/Methods
	
	 public String getLoginPageTitle()
	{
		String title= driver.getTitle();
		System.out.println("Login page title is: " +title);
		return title;
	}
	 
	 
	 public String getLoginPageUrl()
		{
			String url= driver.getCurrentUrl();
			System.out.println("Login page URL is: " +url);
			return url;
		}
	 
	 public boolean isForgotPwdLink() {
		return driver.findElement(forgotpwdLink).isDisplayed();
	 }
	 
	 public String doLogin(String userName, String pwd) {
		 driver.findElement(firstname).sendKeys(userName);
		 driver.findElement(password).sendKeys(pwd);
		 driver.findElement(loginBtn).click();
		 return driver.getTitle();
		 
				 }
	 
	 
	 public boolean isLogoDisplayed() {
		 return driver.findElement(logo).isDisplayed();
	 }
	 
}
