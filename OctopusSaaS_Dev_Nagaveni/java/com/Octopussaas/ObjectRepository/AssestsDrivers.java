package com.Octopussaas.ObjectRepository;

import java.nio.channels.WritableByteChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
import com.google.protobuf.Duration;

public class AssestsDrivers {
	WebDriver driver;
	
	public AssestsDrivers(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Assets')]")
	private WebElement assets;
	@FindBy(xpath = "//h6[contains(text(),'Drivers')]")
	private WebElement assetsDrivers;
	@FindBy(xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement driversTooltip;
	@FindBy (xpath = "//span[contains (text(),'Add New Driver')]")
	private WebElement addNewdriverButton;
	@FindBy (xpath = "//input[@placeholder='Enter First Name']")
	private WebElement firstnameField;
	@FindBy(xpath = "//p[contains (text(),'First name is required')]")
	private WebElement firstnameErmsg;
	@FindBy (xpath = "//button[contains (text(),'Add New Driver')]")
	private WebElement addnewSubmitButton;
	@FindBy (xpath = "//input[@placeholder='Enter Middle Initial']")
	private WebElement middleIntialField;
	@FindBy (xpath = "//input[@placeholder='Enter Last Name']")
	private WebElement lastnameField;
	@FindBy (xpath = "//p[contains (text(),'Last name is required')]")
	private WebElement lastnameErmsg;
	@FindBy (xpath = "//input[@placeholder='Enter Email']")
	private WebElement emailField;
	@FindBy (xpath = "//p[contains (text(),'Email is required')]")
	private WebElement emailErmsg;
	@FindBy (xpath = "//div[@role='combobox']")
	private WebElement driverLocation;
	@FindBy (xpath = "//li[contains(text(),'(Henry) Premier Med Waste Solution display')]")
	private WebElement henryLocation;
	@FindBy (xpath = "//li[contains(text(),'hhhh')]")
	private WebElement hhhLocation;
	@FindBy (xpath = "(//li[contains(text(),'SafeMed Biohazard Solutions')])[1]")
	private WebElement safemedLocation;
	@FindBy (xpath = "(//li[contains (text(),'Orbital Reach Station')])[1]")
	private WebElement orbitalReachLocation;
	@FindBy (xpath = "//li[contains (text(),'SecureCare Medical Disposal')]")
	private WebElement secureCarelocation;
	@FindBy (xpath = "//li[contains (text(),'MediTrust Waste Services')]")
	private WebElement medicalTrustlocation;
	@FindBy (xpath = "(//li[contains (text(),'NovaSky Satellite Offic')])[1]")
	private WebElement novaskySatellitelocation;
	@FindBy (xpath = "(//li[contains (text(),'Zenith Satellite Service')])[1]")
	private WebElement zenithSatellitelocation;
	@FindBy (xpath = "//span[contains(text(),'(Henry) Premier Med Waste Solution display')]/following-sibling::button")
	private WebElement henryCancelbutton;
	@FindBy (xpath = "//span[contains(text(),'hhhh')]/following-sibling::button")
	private WebElement hhhCancelbutton;
	@FindBy (xpath = "(//span[contains(text(),'SafeMed Biohazard Solutions')]/following-sibling::button)[1]")
	private WebElement safemedCancelbutton;
	@FindBy (xpath = "(//span[contains(text(),'Orbital Reach Station')]/following-sibling::button)[1]")
	private WebElement orbitalcancelButton;
	@FindBy (xpath = "//button[@id='driver-status']")
	private WebElement driverStatus;
	@FindBy (xpath = "//div[contains(text(),'Inactive')]")
	private WebElement inactiveStatus;
	@FindBy (xpath = "//div[contains(text(),'Active')]")
	private WebElement activeStatus;
	@FindBy (xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement driverprofileOctoinfo;
	@FindBy (xpath = "//button[@aria-label='Close tooltip']")
	private WebElement tooltipCancelbutton;
	@FindBy (xpath = "//input[@placeholder='Enter First Name']")
	private WebElement driverFirstname;
	@FindBy (xpath = "//input[@placeholder='Enter Middle Initial']")
	private WebElement driverMiddlename;
	@FindBy (xpath = "//input[@placeholder='Enter Last Name']")
	private WebElement driverLastname;
	@FindBy (xpath = "//input[@placeholder='Enter OCTO ID']")
	private WebElement octoID;
	@FindBy (xpath = "//input[@id='phoneNumber']")
	private WebElement phonetextField;
	
	
	
	
	
	public WebElement getPhonetextField() {
		return phonetextField;
	}

	public WebElement getOctoID() {
		return octoID;
	}

	public WebElement getDriverLastname() {
		return driverLastname;
	}

	public WebElement getDriverMiddlename() {
		return driverMiddlename;
	}

	public WebElement getDriverFirstname() {
		return driverFirstname;
	}

	public WebElement getTooltipCancelbutton() {
		return tooltipCancelbutton;
	}

	public WebElement getDriverprofileOctoinfo() {
		return driverprofileOctoinfo;
	}

	public WebElement getActiveStatus() {
		return activeStatus;
	}

	public WebElement getInactiveStatus() {
		return inactiveStatus;
	}

	public WebElement getDriverStatus() {
		return driverStatus;
	}

	public WebElement getOrbitalcancelButton() {
		return orbitalcancelButton;
	}

	public WebElement getSafemedCancelbutton() {
		return safemedCancelbutton;
	}

	public WebElement getHhhCancelbutton() {
		return hhhCancelbutton;
	}

	public WebElement getHenryCancelbutton() {
		return henryCancelbutton;
	}

	public WebElement getZenithSatellitelocation() {
		return zenithSatellitelocation;
	}

	public WebElement getNovaskySatellitelocation() {
		return novaskySatellitelocation;
	}

	public WebElement getMedicalTrustlocation() {
		return medicalTrustlocation;
	}

	public WebElement getSecureCarelocation() {
		return secureCarelocation;
	}

	public WebElement getOrbitalReachLocation() {
		return orbitalReachLocation;
	}

	public WebElement getSafemedLocation() {
		return safemedLocation;
	}

	public WebElement getHhhLocation() {
		return hhhLocation;
	}

	public WebElement getHenryLocation() {
		return henryLocation;
	}

	public WebElement getDriverLocation() {
		return driverLocation;
	}

	public WebElement getEmailErmsg() {
		return emailErmsg;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getLastnameErmsg() {
		return lastnameErmsg;
	}

	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getMiddleIntialField() {
		return middleIntialField;
	}

	public WebElement getAddnewSubmitButton() {
		return addnewSubmitButton;
	}

	public WebElement getFirstnameErmsg() {
		return firstnameErmsg;
	}

	public WebElement getFirstnameField() {
		return firstnameField;
	}

	public WebElement getAddNewdriverButton() {
		return addNewdriverButton;
	}

	public WebElement getDriversTooltip() {
		return driversTooltip;
	}

	public WebElement getAssestsDrivers() {
		return assetsDrivers;
	}

	public WebElement getAssests() {
		return assets;
	}
	
	public void Drivers()
	{
		assets.click();
		Actions act = new Actions(driver);
		act.moveToElement(assetsDrivers).click().perform();
	}
	
	public void AddnewDriverSubmit()
	{
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, addnewSubmitButton);
		addnewSubmitButton.click();
	}
	
	public void DriverLocation()
	{
		WebElement loction = driver.findElement(By.xpath("//div[@role='combobox']"));
	    Assert.assertTrue(loction.isDisplayed(), "Driver location assignment is displayed");
	    WebElement henrylocation = driver.findElement(By.xpath("//span[contains(text(),'(Henry) Premier Med Waste Solution display')]"));
	    Assert.assertTrue(henrylocation.isDisplayed(), "(Henry) Premier Med Waste Solution display is displayed");
	    WebElement hhhlocation =  driver.findElement(By.xpath("//span[contains(text(),'hhhh')]"));
	    Assert.assertTrue(hhhlocation.isDisplayed(), "hhhh is displayed");
	    WebElement safemedlocation = driver.findElement(By.xpath("(//span[contains(text(),'SafeMed Biohazard Solutions')])[1]"));
	    	Assert.assertTrue(safemedlocation.isDisplayed(), "SafeMed Biohazard Solutions is displayed");
	    	WebElement orbitallocation = driver.findElement(By.xpath("(//span[contains(text(),'Orbital Reach Station')])[1]"));
	    	Assert.assertTrue(orbitallocation.isDisplayed(), "Orbital Reach Station is displayed");
	}
	 
	public void UnchecktheDriverLocation() throws InterruptedException
	{
		driverLocation.click();
		henryLocation.click();
		Thread.sleep(2000);
		hhhLocation.click();
		Thread.sleep(2000);
		safemedLocation.click();
		Thread.sleep(2000);
		orbitalReachLocation.click();
		Thread.sleep(2000);
	}
	
	public void DriverLocationCheck() throws InterruptedException
	{
		driverLocation.click();
		henryLocation.click();
		Thread.sleep(2000);
		hhhLocation.click();
		Thread.sleep(2000);
		safemedLocation.click();
		Thread.sleep(2000);
		orbitalReachLocation.click();
		Thread.sleep(2000);
		secureCarelocation.click();
		Thread.sleep(2000);
		secureCarelocation.click();
		Actions act = new Actions(driver);
		act.moveToElement(medicalTrustlocation).click().perform();
		act.moveToElement(medicalTrustlocation).click().perform();
		Actions act1 = new Actions(driver);
		act.moveToElement(novaskySatellitelocation).click().perform();
		act.moveToElement(novaskySatellitelocation).click().perform();
		Actions act2 = new Actions(driver);
		act.moveToElement(zenithSatellitelocation).click().perform();
		act.moveToElement(zenithSatellitelocation).click().perform();
	}
	
	public void RemoveLocation()
	{
		WebElement loction = driver.findElement(By.xpath("//div[@role='combobox']"));
	    Assert.assertTrue(loction.isDisplayed(), "Driver location assignment is displayed");
	    henryCancelbutton.click();
	    hhhCancelbutton.click();
	    safemedCancelbutton.click();
	    orbitalcancelButton.click();	
	}
	
	public void Driverstatus()
	{
		WebElement driverstatus = driver.findElement(By.xpath("//button[@id='driver-status']"));
	    Assert.assertTrue(driverstatus.isDisplayed(), "Driver Status dropdown is displayed");
	    WebElement activestatus = driver.findElement(By.xpath("//span[contains(text(),'Active')]"));
	    Assert.assertTrue(activestatus.isDisplayed(), "In Driver Status dropdown Active status is displayed");

	}
	
	public void CheckDriverstatus()
	{
		driverStatus.click();
		WebElement activestatus1 = driver.findElement(By.xpath("//div[contains(text(),'Active')]"));
	    Assert.assertTrue(activestatus1.isDisplayed(), "In Driver Status dropdown Active status is displayed");
	    WebElement inactivestatus = driver.findElement(By.xpath("//div[contains(text(),'Inactive')]"));
	    Assert.assertTrue(inactivestatus.isDisplayed(), "In Driver Status dropdown Inactive status is displayed");
	}
	
	public void DriverStatusselection() throws InterruptedException
	{
		driverStatus.click();
		driverStatus.click();
		inactiveStatus.click();
		Thread.sleep(2000);
		driverStatus.click();
		driverStatus.click();
		driverStatus.click();
		activeStatus.click();
	}
	
	public void Addnew()
	{
		addnewSubmitButton.click();
		WebElement fstnameErmsg = driver.findElement(By.xpath("//p[contains (text(),'First name is required')]"));
	    Assert.assertTrue(fstnameErmsg.isDisplayed(), "First name error message is displayed");
	    WebElement lstnameErmsg = driver.findElement(By.xpath("//p[contains (text(),'Last name is required')]"));
	    Assert.assertTrue(lstnameErmsg.isDisplayed(), "last name error message is displayed");
	    WebElement emilErmsg = driver.findElement(By.xpath("//p[contains (text(),'Email is required')]"));
	    Assert.assertTrue(emilErmsg.isDisplayed(), "Email error message is displayed");

	}
	
	public void NewDriverLocation()
	{
		WebElement loction = driver.findElement(By.xpath("//div[@role='combobox']"));
	    Assert.assertTrue(loction.isDisplayed(), "Driver location assignment is displayed");
	}
	
	public void FirstnamewithValue()
	{
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='Enter First Name']"));
	    Assert.assertTrue(firstname.isDisplayed(), "First name textfield is displayed");
	    WebElement value = driver.findElement(By.xpath("//input[@value='Arjun']"));
	    Assert.assertTrue(value.isDisplayed(), "First name textfield with value is displayed");
	}
	
	public void Middlenamevalue()
	{
		WebElement middlename = driver.findElement(By.xpath("//input[@placeholder='Enter Middle Initial']"));
	    Assert.assertTrue(middlename.isDisplayed(), "middle name textfield is displayed");
	    WebElement value = driver.findElement(By.xpath("//input[@value='R']"));
	    Assert.assertTrue(value.isDisplayed(), "middle name textfield with value is displayed");
	}
	
	public void LastnameValue()
	{
		WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']"));
	    Assert.assertTrue(lastname.isDisplayed(), "lastname name textfield is displayed");
	    WebElement value = driver.findElement(By.xpath("//input[@value='Reddy']"));
	    Assert.assertTrue(value.isDisplayed(), "last name textfield with value is displayed");
	}
	
	public void OctoIDField()
	{
		WebElement idOctoField = driver.findElement(By.xpath("//input[@placeholder='Enter OCTO ID']"));
	    Assert.assertTrue(idOctoField.isDisplayed(), "Octo ID textfield is displayed");
	    WebElement value = driver.findElement(By.xpath("//input[@value='100057']"));
	    Assert.assertTrue(value.isDisplayed(), "Octo ID textfield with value is displayed");
	}
	
	public void OctoIdwithEdit()
	{
		octoID.click();
		String beforeValue = octoID.getAttribute("value");
		octoID.sendKeys("12345");
		String afterValue = octoID.getAttribute("value");
		Assert.assertEquals(beforeValue, afterValue, 
		    "OctoID field accepted input, but it should not be editable!");

		utilityclassobject.gettest().log(Status.INFO, 
		    "OctoID field did not accept input as expected");
	}
	
	

	
	

}
