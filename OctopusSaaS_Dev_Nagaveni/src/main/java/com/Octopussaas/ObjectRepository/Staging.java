package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Staging {
	 WebDriver driver;

	public Staging(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy (xpath = "//h6[contains (text(),'Add New')]")
	private WebElement addnew;
	@FindBy (xpath = "//li[contains (text(),'Generator')]")
	private WebElement generator;
	@FindBy (xpath = "//input[@placeholder='Enter generator name']")
	private WebElement generatorName;
	@FindBy (xpath = "//input[@placeholder='Enter internal account number']")
	private WebElement accountNumber;
	@FindBy (xpath = "//button[contains (text(),'Add new generator')]")
	private WebElement addnewGenerator;
	@FindBy (xpath = "//input[@id='serviceAddress-street']")
	private WebElement street;
	@FindBy (xpath = "//input[@id='serviceAddress-email']")
	private WebElement serviceEmail;
	@FindBy (xpath = "//input[@id='serviceAddress-phone']")
	private WebElement servicephone;
	@FindBy (xpath = "//button[normalize-space()='Copy to Billing Information']")
	private WebElement copyButton;
	@FindBy (xpath = "//div[@role='checkbox' and .//span[normalize-space()='Contracted']]")
	private WebElement contractedCheckbox;
	
	
	public WebElement getContractedCheckbox() {
		return contractedCheckbox;
	}

	public WebElement getCopyButton() {
		return copyButton;
	}

	public WebElement getServicephone() {
		return servicephone;
	}

	public WebElement getServiceEmail() {
		return serviceEmail;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getAddnewGenerator() {
		return addnewGenerator;
	}

	public WebElement getAddnew() {
		return addnew;
	}
	
	public WebElement getGenerator() {
		return generator;
	}
	
	public WebElement getGeneratorName() {
		return generatorName;
	}
	
	public WebElement getAccountNumber() {
		return accountNumber;
	}


	
	public void Contracted() throws InterruptedException
	{
		 contractedCheckbox.click();
		 WebElement modal = driver.findElement(By.xpath("//div[@class='modal-box']"));
		 modal.isDisplayed();
		 Thread.sleep(200);
		 WebElement button = driver.findElement(By.xpath("//button[contains (text(),'Yes')]"));
		 button.click();
		 Thread.sleep(2000);
		 Assert.assertTrue( contractedCheckbox.isSelected(),"Contracted checkbox is not selected");
		 
		 
	}
}
