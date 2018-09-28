package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.HomePage;
import com.test.qa.pages.LoginPage;
import com.test.qa.pages.NewMessagePage;

public class NewMessagePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	NewMessagePage newMessagePage;
	
	public NewMessagePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		//call initialization() from TestBase class
		initialization();
		newMessagePage = new NewMessagePage();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newMessagePage = homepage.compose();
	}
	
	@Test(priority=1)
	public void VerifyNewMessagePageTitleTest() {
		Assert.assertTrue(newMessagePage.verifyNewMessageLabel(), "New Message");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
