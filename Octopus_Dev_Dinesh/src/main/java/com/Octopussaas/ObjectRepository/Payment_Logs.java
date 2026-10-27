package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_Logs {


	WebDriver driver;

	public  Payment_Logs (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//h6[text()='Billing']")
	private WebElement Billing;
	
	public WebElement getBilling() {
		return Billing;
	}
}
