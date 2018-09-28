package com.test.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.test.qa.base.TestBase;
import com.test.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	//page factory - OR
	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextbtn;
	
	//Initialize the page objects 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	//validate title of login page
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		nextbtn.click();
		super.webdriverwait = new WebDriverWait(driver, 10);
		password = webdriverwait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pwd);
		nextbtn.click();
		
		//return HomePage class object
		return new HomePage();
	}
}	

