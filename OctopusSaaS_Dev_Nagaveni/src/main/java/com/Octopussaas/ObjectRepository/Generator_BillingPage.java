package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Octopussaass.WebdriverUtility.webDriverutility;

public class Generator_BillingPage {
	WebDriver driver;

	public Generator_BillingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
@FindBy(xpath = "//span[text()='Consumer Price Index Setting']")
private WebElement consumerPriceIndexSettingtext;

public WebDriver getDriver() {
	return driver;
}

@FindBy(xpath = "//span[text()='I confirm these billing settings are correct']/../descendant::div")
private WebElement confirmBillingSettingsCheckbox;
@FindBy(xpath = "//h6[@title='Generator Name']")
private WebElement GenName;
@FindBy(xpath = "//button[text()='Yes, Confirm Billing Settings']")
private WebElement confirmBillingSettingsButton;




public WebElement getConfirmBillingSettingsButton() {
	return confirmBillingSettingsButton;
}
public WebElement getGenName() {
	return GenName;
}
public WebElement getConsumerPriceIndexSettingtext() {
	return consumerPriceIndexSettingtext;
}

public void ConfirmBillingSettingsCheckbox() {
	
	webDriverutility wlib = new webDriverutility();
	wlib.scrollToelement(driver, consumerPriceIndexSettingtext);
	confirmBillingSettingsCheckbox.click();
	confirmBillingSettingsButton.click();
}








}
