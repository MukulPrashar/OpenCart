package com.qa.opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	//WebDriver driver;

	
	@Test
	public void loginPageTitleTest() {
		String actTitle= loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test
	public void loginPageURLTest() {
		String actURL= loginPage.getLoginPageUrl();
		Assert.assertTrue(actURL.contains("route=account/login"));
}
	
	
	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLink());
	}
	
	@Test
	public void logoExistTest() {
		Assert.assertTrue(loginPage.isLogoDisplayed());
	}
	
	
	@Test(priority=Integer.MAX_VALUE)
	public void loginTest() {
		
		
		String accPageTitle= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPageTitle, "My Account");
	}
	
	
}
