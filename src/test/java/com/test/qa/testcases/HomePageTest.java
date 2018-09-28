package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.HomePage;
import com.test.qa.pages.LoginPage;
import com.test.qa.pages.NewMessagePage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	NewMessagePage newMessagePage;
	
	
	public HomePageTest(){
		//super class constructor will call
		super();
	}
	
	@BeforeMethod
	public void setup() {
		//call initialization() from TestBase class
		initialization();
		newMessagePage = new NewMessagePage();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String homePageTitle = homepage.validateHomePageTitle();
		Assert.assertEquals("Gmail",homePageTitle,"Home Page title not matched");
	}
	
	@Test(priority=2)
	public void VerifyComposeLinkTest() {
		newMessagePage = homepage.compose();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
