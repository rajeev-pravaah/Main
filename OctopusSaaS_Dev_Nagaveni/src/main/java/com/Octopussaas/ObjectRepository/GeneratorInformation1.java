package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.aventstack.extentreports.Status;

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
	@FindBy (xpath = "(//button[contains (text(),'Cancel')])[1]")
	private WebElement cancelButton;
	@FindBy (xpath = "//input[@placeholder='Enter Generator Name']")
	private WebElement generatornameField;
	@FindBy (xpath = "//p[contains (text(),'Generator Name is required')]")
	private WebElement generatornameErmsg;
	@FindBy (xpath = "//input[@placeholder='Enter OCTO Number']")
	private WebElement octoNumber;
	@FindBy (xpath = "//input[@placeholder='Enter Internal Account Number']")
	private WebElement internalaccountNumber;
	@FindBy (xpath = "//input[@placeholder='Generator Permit Number']")
	private WebElement generatorpermitNumber;
	@FindBy (xpath = "//input[@placeholder='https://example.com']")
	private WebElement generatorwebsite;
	@FindBy (xpath = "//div[contains (text(),'Please enter a valid URL.')]")
	private WebElement websiteErmsg;
	@FindBy (xpath = "//button[@title='Open link']")
	private WebElement openlink;
	@FindBy (xpath = "//textarea[@id='generator-note']")
	private WebElement generatorNote;
	@FindBy (xpath = "//button[@id='attach-to service location']")
	private WebElement serviceLocation;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'BioTrust Medical Disposal')]")
	private WebElement biotrustLocation;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'(Henry) Premier Med Waste Solution display')]")
	private WebElement henryLocation;
	@FindBy (xpath = "//input[@id='parent-account']")
	private WebElement parentAccount;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'G-101-0624 - Summit Healthcare')]")
	private WebElement healthsummitGenerator;
	@FindBy (xpath = "//p[contains (text(),'Unassign')]")
	private WebElement unassignButton;
	@FindBy (xpath = "//textarea[@name='unassignNote']")
	private WebElement noteunassign;
	@FindBy (xpath = "//button[contains (text(),'Unassign')]")
	private WebElement noteUnassignbutton;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'G-101-0625 - Coastal Dental Group')]")
	private WebElement costalgroupGenerator;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'G-107-7136 - PriceBook Test 2.0')]")
	private WebElement pricebookGenerator;
	@FindBy (xpath = "//button[contains (text(),'Keep This Assigned')]")
	private WebElement keeptheAssigendButton;
	@FindBy (xpath = "(//input[@placeholder='(123) 456-7890'])[1]")
	private WebElement generatormainphone;
	@FindBy (xpath = "//input[@id='undefined-ext']")
	private WebElement extTextfield;
	@FindBy (xpath = "//p[contains (text(),'Phone number must be 10 digits')]")
	private WebElement mainphoneErmsg;
	@FindBy (xpath = "//input[@placeholder='info@example.com']")
	private WebElement generatorEmail;
	@FindBy (xpath = "//p[contains (text(),'Please enter a valid email address')]")
	private WebElement generatoremailErmsg;
	
	
	
	
	public WebElement getGeneratoremailErmsg() {
		return generatoremailErmsg;
	}

	public WebElement getGeneratorEmail() {
		return generatorEmail;
	}

	public WebElement getMainphoneErmsg() {
		return mainphoneErmsg;
	}

	public WebElement getExtTextfield() {
		return extTextfield;
	}

	public WebElement getGeneratormainphone() {
		return generatormainphone;
	}

	public WebElement getKeeptheAssigendButton() {
		return keeptheAssigendButton;
	}

	public WebElement getPricebookGenerator() {
		return pricebookGenerator;
	}

	public WebElement getCostalgroupGenerator() {
		return costalgroupGenerator;
	}

	public WebElement getNoteUnassignbutton() {
		return noteUnassignbutton;
	}

	public WebElement getNoteunassign() {
		return noteunassign;
	}

	public WebElement getUnassignButton() {
		return unassignButton;
	}

	public WebElement getHealthsummitGenerator() {
		return healthsummitGenerator;
	}

	public WebElement getParentAccount() {
		return parentAccount;
	}

	public WebElement getHenryLocation() {
		return henryLocation;
	}

	public WebElement getBiotrustLocation() {
		return biotrustLocation;
	}

	public WebElement getServiceLocation() {
		return serviceLocation;
	}

	public WebElement getGeneratorNote() {
		return generatorNote;
	}

	public WebElement getOpenlink() {
		return openlink;
	}

	public WebElement getWebsiteErmsg() {
		return websiteErmsg;
	}

	public WebElement getGeneratorwebsite() {
		return generatorwebsite;
	}

	public WebElement getGeneratorpermitNumber() {
		return generatorpermitNumber;
	}

	public WebElement getInternalaccountNumber() {
		return internalaccountNumber;
	}

	public WebElement getOctoNumber() {
		return octoNumber;
	}

	public WebElement getGeneratornameErmsg() {
		return generatornameErmsg;
	}

	public WebElement getGeneratornameField() {
		return generatornameField;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

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
	
	public void OctonumberwithEdit()
	{
		Assert.assertTrue(octoNumber.isDisplayed(),
	            "Octo number field is not displayed");

	    Assert.assertFalse(octoNumber.isEnabled(),
	            "Octo number field is editable but should not be editable");

	    utilityclassobject.gettest().log(Status.PASS,
	            "Octo number field is displayed and non-editable as expected");
	}
	
	public void Servicelocation() throws InterruptedException
	{
		serviceLocation.click();
		serviceLocation.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(biotrustLocation).click().perform();
	}
	
	public void ParentaccountwithInput()
	{
		Actions act = new Actions(driver);
		act.moveToElement(parentAccount).click().perform();
		parentAccount.sendKeys("sdfs#$#123");
	}
	
	public void ParentaccountGenerator()
	{
		Actions act = new Actions(driver);
		act.moveToElement(healthsummitGenerator).click().perform();	
	}
	
	public void Unassignbutton() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(unassignButton).click().perform();
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		noteunassign.sendKeys("Done");
		Thread.sleep(200);
		noteUnassignbutton.click();
		Thread.sleep(2000);	
	}
	
	public void ParentAccountwithCostalgroup()
	{
		Actions act = new Actions(driver);
		act.moveToElement(costalgroupGenerator).click().perform();	
	}
	
	public void ParentAccountwithPricebook()
	{
		Actions act = new Actions(driver);
		act.moveToElement(pricebookGenerator).click().perform();	
	}
	
	public void KeeptheAssigned()
	{
		parentAccount.click();
		pricebookGenerator.click();
		Actions act = new Actions(driver);
		act.moveToElement(unassignButton).click().perform();
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		keeptheAssigendButton.click();

	}
	
	public void WithoutUnassign() throws InterruptedException
	{

		Actions act = new Actions(driver);
		act.moveToElement(unassignButton).click().perform();
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		noteunassign.sendKeys(Keys.CONTROL + "a");
		noteunassign.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		noteUnassignbutton.click();
		Thread.sleep(2000);	
	}

	
}
