package com.test.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.HomePage;
import com.test.qa.pages.LoginPage;
import com.test.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	String sheetName = "login";
	
	public LoginPageTest(){
		//super class constructor will call
		super();
	}
	
	@BeforeMethod
	public void setup() {
		//call initialization() from TestBase class
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Gmail");
	}
	
/*	@Test(priority=2)
	public void loginTest(){
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}*/
	
	@Test(priority=2, dataProvider="getLoginTestData")
	public void loginTest(String username, String password){
		homepage = loginPage.login(username, password);
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
