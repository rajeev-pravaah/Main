package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@type='email']")
	private WebElement EmailAdressTextField;
	@FindBy(xpath = "//input[@type=\"password\"]" )
	private WebElement PasswordTextField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement LoginBtn;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getEmailAdressTextField() {
		return EmailAdressTextField;
	}
	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public void LoginToApp(String Username,String password)
	{
		EmailAdressTextField.sendKeys(Username);
		PasswordTextField.sendKeys(password);
		LoginBtn.click();
	}
	
}
