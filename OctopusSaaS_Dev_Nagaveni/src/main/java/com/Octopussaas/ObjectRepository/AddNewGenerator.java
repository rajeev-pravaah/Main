package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewGenerator {
	WebDriver driver;

	public AddNewGenerator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@placeholder='Enter generator name']")
	private WebElement EnterGeneratorName;
	@FindBy(xpath = "//input[@placeholder='Enter internal account number']")
	private WebElement EnterInternalAccountno;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement AddnewGen;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getEnterGeneratorName() {
		return EnterGeneratorName;
	}
	public WebElement getEnterInternalAccountno() {
		return EnterInternalAccountno;
	}
	public WebElement getAddnewGen() {
		return AddnewGen;
	}
	
	public void NewGeneretor(String GeneretorName,String AccountNo) throws InterruptedException
	{
		EnterGeneratorName.sendKeys(GeneretorName);
		EnterInternalAccountno.sendKeys(AccountNo);
		Thread.sleep(2000);
		AddnewGen.click();
	}
}
