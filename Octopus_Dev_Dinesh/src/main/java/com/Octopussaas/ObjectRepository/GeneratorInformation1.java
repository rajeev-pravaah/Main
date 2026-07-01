package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratorInformation1 {
	WebDriver driver;

	public GeneratorInformation1(WebDriver driver)
	{
		this.driver = driver;
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
	@FindBy (xpath = "//button[@id='tag-add-button']")
	private WebElement addtagButton;
	@FindBy (xpath = "//button[contains (text(),'Apply')]")
	private WebElement applyButton;
	@FindBy (xpath = "//span[normalize-space()='Manufacturing']/parent::*//button[@title='Remove tag']")
	private WebElement manufacturingtagCancel;
	@FindBy (xpath = "//span[normalize-space()='Summary']/parent::*//button[@title='Remove tag']")
	private WebElement summaryCancel;
	@FindBy (xpath = "//span[normalize-space()='Medical Waste']/parent::*//button[@title='Remove tag']")
	private WebElement medicalwasteCancel;
	@FindBy (xpath = "//span[normalize-space()='Urgent']/parent::*//button[@title='Remove tag']")
	private WebElement urgentCancel;
	@FindBy (xpath = "//span[normalize-space()='Newwwwww']/parent::*//button[@title='Remove tag']")
	private WebElement newCancel;
	@FindBy (xpath = "//span[normalize-space()='Test Tag 63093']/parent::*//button[@title='Remove tag']")
	private WebElement testCancel;
	@FindBy (xpath = "//span[normalize-space()='School']/parent::*//button[@title='Remove tag']")
	private WebElement schoolCancel;
	@FindBy (xpath = "//span[normalize-space()='Less Priority']/parent::*//button[@title='Remove tag']")
	private WebElement lesspriorityCancel;
	@FindBy (xpath = "//span[normalize-space()='Regular tag']/parent::*//button[@title='Remove tag']")
	private WebElement regularTagcancel;
	@FindBy (xpath = "//span[normalize-space()='Hospital']/parent::*//button[@title='Remove tag']")
	private WebElement hospitalCancel;
	@FindBy (xpath = "//span[normalize-space()='Construction']/parent::*//button[@title='Remove tag']")
	private WebElement constructionCancel;
	@FindBy (xpath = "//span[normalize-space()='New Gen']/parent::*//button[@title='Remove tag']")
	private WebElement newgenCancel;
	
	public WebElement getNewgenCancel() {
		return newgenCancel;
	}

	public WebElement getConstructionCancel() {
		return constructionCancel;
	}

	public WebElement getHospitalCancel() {
		return hospitalCancel;
	}

	public WebElement getRegularTagcancel() {
		return regularTagcancel;
	}

	public WebElement getLesspriorityCancel() {
		return lesspriorityCancel;
	}

	public WebElement getSchoolCancel() {
		return schoolCancel;
	}

	public WebElement getTestCancel() {
		return testCancel;
	}

	public WebElement getNewCancel() {
		return newCancel;
	}

	public WebElement getUrgentCancel() {
		return urgentCancel;
	}

	public WebElement getMedicalwasteCancel() {
		return medicalwasteCancel;
	}

	public WebElement getSummaryCancel() {
		return summaryCancel;
	}

	public WebElement getManufacturingtagCancel() {
		return manufacturingtagCancel;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getAddtagButton() {
		return addtagButton;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getAddnewGenerator() {
		return addnewGenerator;
	}

	public WebElement getAccountNumber() {
		return accountNumber;
	}

	public WebElement getGeneratorName() {
		return generatorName;
	}

	public WebElement getGenerator() {
		return generator;
	}

	public WebElement getAddnew() {
		return addnew;
	}
	
	public void Street()
	{
		Actions act = new Actions(driver);
		act.moveToElement(street).click().perform();
		street.sendKeys(Keys.CONTROL + "a");
		street.sendKeys(Keys.DELETE);
		street.sendKeys("1237 2");
	}
	
	public void RemoveAddedtags() throws InterruptedException
	{
		manufacturingtagCancel.click();
		Thread.sleep(200);
		urgentCancel.click();
		Thread.sleep(200);
		summaryCancel.click();
		Thread.sleep(200);
		newCancel.click();
		Thread.sleep(200);
		medicalwasteCancel.click();
		Thread.sleep(200);
		testCancel.click();
		Thread.sleep(200);
		schoolCancel.click();
		Thread.sleep(200);
		lesspriorityCancel.click();
		Thread.sleep(200);
		regularTagcancel.click();
		Thread.sleep(200);
		hospitalCancel.click();
		Thread.sleep(200);
		newgenCancel.click();
		Thread.sleep(200);
		constructionCancel.click();
	}

}
