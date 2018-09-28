package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class NewMessagePage extends TestBase {
	@FindBy(xpath = "//div[text()='New Message']")
	WebElement NewMessageLabel;
	
	// Initializing the Page Objects:
	public NewMessagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNewMessageLabel(){
		return NewMessageLabel.isDisplayed();
	}
}
