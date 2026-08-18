package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_SideBar {
	WebDriver driver;

	public Navigation_SideBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	@FindBy(xpath = "//h6[text()='Billing']")
	private WebElement Billingdropdown;
	@FindBy(xpath = "//h6[text()='Unapplied Checks']")
	private WebElement UnappliedChecks;
	
	
	
	public WebElement getUnappliedChecks() {
		return UnappliedChecks;
	}
	
	public WebElement getBillingdropdown() {
		return Billingdropdown;
	}
	
	public void MovetoUnappliedchecks()
	{
		Billingdropdown.click();
		UnappliedChecks.click();
		
	}
	
}
