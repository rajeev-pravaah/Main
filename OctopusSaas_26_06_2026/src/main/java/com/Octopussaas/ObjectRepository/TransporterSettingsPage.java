package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransporterSettingsPage {
	WebDriver driver;

	public TransporterSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[text()='Users']")
	private WebElement userslink;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUserslink() {
		return userslink;
	}
}
