package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//h6[text()='Billing']")
	private WebElement biilingdd;
	@FindBy(xpath = "//h6[contains(text(),'Master Price Books')]")
	private WebElement masterpricebook;
	
	public WebElement getMasterpricebook() {
		return masterpricebook;
	}
	public WebElement getBiilingdd() {
		return biilingdd;
	}

}
