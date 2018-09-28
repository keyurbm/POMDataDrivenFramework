package com.test.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.base.TestBase;

public class HomePage extends TestBase {

	// page factory - OR
	@FindBy(xpath = ".//div[text()='Compose']")
	WebElement composemail;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public NewMessagePage compose() {

		composemail.click();

		// return New Message class object
		return new NewMessagePage();
	}
}
