package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="login-email")
	private WebElement EmailAddress;
	
	@FindBy(id = "login-password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	private WebElement signuplink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailAddress() {
		return EmailAddress;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignuplink() {
		return signuplink;
	}
	
	
	

}
