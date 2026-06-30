package com.Octopussaas.ObjectRepository;

import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Random;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;
//import com.google.protobuf.Duration;

public class AssestsDrivers {
	WebDriver driver;
	String email;
	
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
	@FindBy (xpath = "//p[contains(text(),'Phone number must be 10 digits')]")
	private WebElement phonetextErmsg;
	@FindBy (xpath = "//input[@id='phoneNumber-ext']")
	private WebElement exttextfield;
	@FindBy (xpath = "//button[contains(text(),'Send OCTO Field App Login Instructions')]")
	private WebElement octoLoginButton;
	@FindBy (xpath = "//input[@placeholder='Enter Email']")
	private WebElement driverEmail;
	@FindBy (xpath = "//input[@placeholder='Enter Password']")
	private WebElement driverPassword;
	@FindBy (xpath = "//p[contains (text(),'Password must be at least 8 characters long')]")
	private WebElement passwordErmsg;
	@FindBy (xpath = "//button[@id='togglePasswordVisibility']")
	private WebElement passwordVisibility;
	@FindBy (xpath = "//p[contains(text(),'Password is required')]")
	private WebElement passwordMandatoryErmsg;
	@FindBy (xpath = "//div[@data-testid='dateOfBirth']")
	private WebElement dateofBirth;
	@FindBy (xpath = "//div[@data-testid='dateOfBirth']")
	private WebElement dateofBirthcalendar;
	@FindBy (xpath = "//a[contains(text(),'1998')]")
	private WebElement selectedYear;
	@FindBy (xpath = "(//details[@class='dropdown'])[1]")
	private WebElement yearsDropdown;
	@FindBy (xpath = "(//details[@class='dropdown'])[2]")
	private WebElement monthDropdown;
	@FindBy (xpath = "//a[contains(text(),'November')]")
	private WebElement selectedMonth;
	@FindBy (xpath = "//input[@placeholder='Enter Driver License Number']")
	private WebElement driverlicense;
	@FindBy (xpath = "//div[@data-testid='licenseExpirationDate']")
	private WebElement licenseExpirationCalendar;
	@FindBy (xpath ="(//details[@class='dropdown'])[1]")
	private WebElement licenseYearDrpdown;
	@FindBy (xpath = "//a[contains(text(),'2010')]")
	private WebElement selectedlicenseYear;
	@FindBy (xpath = "(//details[@class='dropdown'])[2]")
	private WebElement licenseMonthDropdown;
	@FindBy (xpath = "//a[contains (text(),'July')]")
	private WebElement selectedlicenseMonth;
	@FindBy (xpath = "//input[@placeholder='Enter Emergency Contact Person']")
	private WebElement emgcontactperson;
	@FindBy (xpath = "//input[@id='emergencyContactPhone']")
	private WebElement emgcontactPhone;
	@FindBy (xpath = "//p[contains (text(),'Phone number must be 10 digits')]")
	private WebElement emgcontactPhoneErmsg;
	@FindBy (xpath = "//input[@id='emergencyContactPhone-ext']")
	private WebElement emgExt;
	@FindBy (xpath = "//div[@data-testid='startDate']")
	private WebElement startDateCalendar;
	@FindBy (xpath = "//div[@data-testid='dotMedicalCardExpirationDate']")
	private WebElement medicalDateCalendar;
	@FindBy (xpath = "//div[@data-testid='driverLocation']")
	private WebElement driverlistLocation;
	@FindBy (xpath = "(//li[contains (text(),'NovaOrbit Satellite Offic')])[1]")
	private WebElement novaorbitLocation;
	@FindBy (xpath = "(//li[contains (text(),'AstroLink Control Cente')])[1]")
	private WebElement astrolinkLocation;
	@FindBy (xpath = "(//li[contains (text(),'BioTrust Medical Disposal')])[1]")
	private WebElement biotrustLocation;
	@FindBy (xpath = "(//li[contains (text(),'CosmoBridge Satellite Hu')])[1]")
	private WebElement cosmobridgeLocation;
	@FindBy (xpath = "(//li[contains (text(),'SecureCare Medical Disposal')])[1]")
	private WebElement secureCareLocation;
	@FindBy (xpath = "//span[contains(text(),'BioTrust Medical Disposal')]/following-sibling::button")
	private WebElement biotrustCancelation;
	@FindBy (xpath = "(//span[contains(text(),'CosmoBridge Satellite Hu')]/following-sibling::button)[1]")
	private WebElement cosmoBridgeCancelation;
	@FindBy (xpath = "(//span[contains(text(),'SecureCare Medical Disposal')]/following-sibling::button)[1]")
	private WebElement secureCarecancelation;
	@FindBy (xpath = "(//span[contains(text(),'AstroNet Statio')]/following-sibling::button)[1]")
	private WebElement astronetCancelation;
	@FindBy (xpath = "//div[@data-testid='startDate']")
	private WebElement stardateCalendar;
	@FindBy (xpath = "(//details[@class='dropdown'])[1]")
	private WebElement startdateyearsdrpdown;
	@FindBy (xpath = "//a[contains (text(),'2038')]")
	private WebElement selectedStartyear;
	@FindBy (xpath = "//input[@id='hourlyWage']")
	private WebElement hourlywage;
	@FindBy (xpath = "//div[@data-testid='scheduledWorkDays']")
	private WebElement scheduledworkday;
	@FindBy (xpath = "//li[contains (text(),'Monday')]")
	private WebElement monday;
	@FindBy (xpath = "//li[contains (text(),'Tuesday')]")
	private WebElement tuesday;
	@FindBy (xpath = "//li[contains (text(),'Wednesday')]")
	private WebElement wednesday;
	@FindBy (xpath = "//li[contains (text(),'Thursday')]")
	private WebElement thursday;
	@FindBy (xpath = "//li[contains (text(),'Friday')]")
	private WebElement friday;
	@FindBy (xpath = "//li[contains (text(),'Saturday')]")
	private WebElement saturday;
	@FindBy (xpath = "//li[contains (text(),'Sunday')]")
	private WebElement sunday;
	@FindBy (xpath = "//div[@data-testid='zebraPrintingSize']")
	private WebElement zebraPrintingField;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Small')]")
	private WebElement small;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Medium')]")
	private WebElement medium;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Large')]")
	private WebElement large;
	@FindBy (xpath = "//div[@data-testid='limitedDutyStatus']")
	private WebElement dutystatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Full Duty')]")
	private WebElement fullduty;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Limited Duty')]")
	private WebElement limitedDuty;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Off Duty')]")
	private WebElement offDuty;
	@FindBy (xpath = "//div[@data-testid='driverStatus']")
	private WebElement driverstatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Active')]")
	private WebElement activedriverstatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Inactive')]")
	private WebElement inactivedriverstatus;
	@FindBy (xpath = "(//input[@type='file'])[1]")
	private WebElement licensefield;
	@FindBy (xpath = "(//*[local-name()='svg' and contains(@class,'text-cardTextGray')])[9]")
	private WebElement uploadfile;
	@FindBy (xpath = "//button[contains(@class,'text-red-500')]")
	private WebElement deleteicon;
	@FindBy (xpath = "(//input[@type='file'])[2]")
	private WebElement medicalfield;
	@FindBy (xpath = "//button[@class='hover:text-red-500']")
	private WebElement medicaldeleteicon;
	@FindBy (xpath = "//button[contains (text(),'Send OCTO Field App Login Instructions')]")
	private WebElement loginInsturctionButton;
	@FindBy (xpath = "(//div[contains(.,'Call customer')]//div[@role='checkbox'])[1]")
	private WebElement callcustomerCheckbox;
	@FindBy (xpath = "(//div[contains(.,'Call customer')]//div[@role='checkbox'])[2]")
	private WebElement emailcustomerCheckbox;
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy (xpath = "//button[@id='viewDriverList']")
	private WebElement driverList;
	@FindBy (xpath = "//div[@data-testid='multiselect-dropdown']")
	private WebElement listeddriverStatus;
	@FindBy (xpath = "//div[@class='relative flex items-center gap-2 w-full']//span[contains(text(),'Active')]")
	private WebElement listedActivestatus;
	@FindBy (xpath = "//div[@class='relative flex items-center gap-2 w-full']//span[contains(text(),'Inactive')]")
	private WebElement listedInactivestatus;
	@FindBy (xpath = "//div[contains(text(),'100072')]/ancestor::a//input[@type='checkbox']")
	private WebElement checkbox;
	@FindBy (xpath = "//button[contains (text(),'Export')]")
	private WebElement exportCheckbox;
	@FindBy (xpath = "//div[contains(text(),'100072')]/ancestor::a//div[contains (text(),'arjun K reddy')]")
	private WebElement addeddriverName;
	@FindBy (xpath = "//input[@placeholder='Enter Hours Scheduled to Work']")
	private WebElement hoursScheduled;
	
	
	
	public WebElement getHoursScheduled() {
		return hoursScheduled;
	}
	public WebElement getAddeddriverName() {
		return addeddriverName;
	}
	public WebElement getExportCheckbox() {
		return exportCheckbox;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	public WebElement getListedInactivestatus() {
		return listedInactivestatus;
	}
	public WebElement getListedActivestatus() {
		return listedActivestatus;
	}
	public WebElement getListeddriverStatus() {
		return listeddriverStatus;
	}
	public WebElement getDriverList() {
		return driverList;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getEmailcustomerCheckbox() {
		return emailcustomerCheckbox;
	}
	public WebElement getCallcustomerCheckbox() {
		return callcustomerCheckbox;
	}
	public WebElement getLoginInsturctionButton() {
		return loginInsturctionButton;
	}
	public WebElement getMedicaldeleteicon() {
		return medicaldeleteicon;
	}
	public WebElement getMedicalfield() {
		return medicalfield;
	}
	public WebElement getDeleteicon() {
		return deleteicon;
	}
	public WebElement getLicensefield() {
		return licensefield;
	}
	public WebElement getActivedriverstatus() {
		return activedriverstatus;
	}
	public WebElement getInactivedriverstatus() {
		return inactivedriverstatus;
	}

	public WebElement getDriverstatus() {
		return driverstatus;
	}

	public WebElement getOffDuty() {
		return offDuty;
	}

	public WebElement getLimitedDuty() {
		return limitedDuty;
	}

	public WebElement getFullduty() {
		return fullduty;
	}

	public WebElement getDutystatus() {
		return dutystatus;
	}

	public WebElement getLarge() {
		return large;
	}

	public WebElement getMedium() {
		return medium;
	}

	public WebElement getSmall() {
		return small;
	}

	public WebElement getZebraPrintingField() {
		return zebraPrintingField;
	}

	public WebElement getSunday() {
		return sunday;
	}

	public WebElement getSaturday() {
		return saturday;
	}

	public WebElement getFriday() {
		return friday;
	}

	public WebElement getThursday() {
		return thursday;
	}

	public WebElement getWednesday() {
		return wednesday;
	}

	public WebElement getTuesday() {
		return tuesday;
	}

	public WebElement getMonday() {
		return monday;
	}

	public WebElement getScheduledworkday() {
		return scheduledworkday;
	}

	public WebElement getHourlywage() {
		return hourlywage;
	}

	public WebElement getSelectedStartyear() {
		return selectedStartyear;
	}

	public WebElement getStartdateyearsdrpdown() {
		return startdateyearsdrpdown;
	}

	public WebElement getStardateCalendar() {
		return stardateCalendar;
	}

	public WebElement getAstronetCancelation() {
		return astronetCancelation;
	}

	public WebElement getSecureCarecancelation() {
		return secureCarecancelation;
	}

	public WebElement getCosmoBridgeCancelation() {
		return cosmoBridgeCancelation;
	}

	public WebElement getBiotrustCancelation() {
		return biotrustCancelation;
	}

	public WebElement getSecureCareLocation() {
		return secureCareLocation;
	}

	public WebElement getCosmobridgeLocation() {
		return cosmobridgeLocation;
	}

	public WebElement getBiotrustLocation() {
		return biotrustLocation;
	}

	public WebElement getAstrolinkLocation() {
		return astrolinkLocation;
	}

	public WebElement getNovaorbitLocation() {
		return novaorbitLocation;
	}

	public WebElement getDriverlistLocation() {
		return driverlistLocation;
	}

	public WebElement getMedicalDateCalendar() {
		return medicalDateCalendar;
	}

	public WebElement getStartDateCalendar() {
		return startDateCalendar;
	}

	public WebElement getEmgExt() {
		return emgExt;
	}

	public WebElement getEmgcontactPhoneErmsg() {
		return emgcontactPhoneErmsg;
	}

	public WebElement getEmgcontactPhone() {
		return emgcontactPhone;
	}

	public WebElement getEmgcontactperson() {
		return emgcontactperson;
	}

	public WebElement getSelectedlicenseMonth() {
		return selectedlicenseMonth;
	}

	public WebElement getLicenseMonthDropdown() {
		return licenseMonthDropdown;
	}

	public WebElement getSelectedlicenseYear() {
		return selectedlicenseYear;
	}

	public WebElement getLicenseYearDrpdown() {
		return licenseYearDrpdown;
	}

	public WebElement getLicenseExpirationCalendar() {
		return licenseExpirationCalendar;
	}

	public WebElement getDriverlicense() {
		return driverlicense;
	}

	public WebElement getSelectedMonth() {
		return selectedMonth;
	}

	public WebElement getMonthDropdown() {
		return monthDropdown;
	}

	public WebElement getDateofBirthcalendar() {
		return dateofBirthcalendar;
	}

	public WebElement getYearsDropdown() {
		return yearsDropdown;
	}

	public WebElement getSelectedYear() {
		return selectedYear;
	}

	public WebElement getDateofBirth() {
		return dateofBirth;
	}

	public WebElement getPasswordMandatoryErmsg() {
		return passwordMandatoryErmsg;
	}

	public WebElement getPasswordVisibility() {
		return passwordVisibility;
	}

	public WebElement getPasswordErmsg() {
		return passwordErmsg;
	}

	public WebElement getDriverPassword() {
		return driverPassword;
	}

	public WebElement getDriverEmail() {
		return driverEmail;
	}

	public WebElement getOctoLoginButton() {
		return octoLoginButton;
	}

	public WebElement getExttextfield() {
		return exttextfield;
	}

	public WebElement getPhonetextErmsg() {
		return phonetextErmsg;
	}

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
	public WebElement getUploadfile() {
		return uploadfile;
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
	}
	
	public void Middlenamevalue()
	{
		WebElement middlename = driver.findElement(By.xpath("//input[@placeholder='Enter Middle Initial']"));
	    Assert.assertTrue(middlename.isDisplayed(), "middle name textfield is displayed");
	}
	
	public void LastnameValue()
	{
		WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']"));
	    Assert.assertTrue(lastname.isDisplayed(), "lastname name textfield is displayed");
	}
	
	public void OctoIDField()
	{
		WebElement idOctoField = driver.findElement(By.xpath("//input[@placeholder='Enter OCTO ID']"));
	    Assert.assertTrue(idOctoField.isDisplayed(), "Octo ID textfield is displayed");
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
	
	public void OctoLoginButton()
	{
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, octoLoginButton);
		octoLoginButton.click();
	}
	
	public void DriverEmail()
	{
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
		Assert.assertTrue(email.isDisplayed(), "Email Textfield is displayed");
	}
	
	public void EmailwithEdit()
	{
		driverEmail.click();
		driverEmail.sendKeys(Keys.CONTROL + "a");
		driverEmail.sendKeys(Keys.DELETE);
		javautility jlib = new javautility();
		int randomnumber = jlib.getRandomNumber();
		Random random6digit = new Random();
		int Sixnumber = 100000 + random6digit.nextInt(900000); // 100000–999999
		email = "test" + Sixnumber + "@gmail.com";
		driverEmail.sendKeys(email);
	}
	
	public void DateofBirthCalendarwithInput()
	{
		dateofBirth.click();
		dateofBirth.sendKeys("shdg635@3#");

		String readonly = dateofBirth.getAttribute("readonly");

		if (readonly != null) {
		    System.out.println("Field is readonly → typing is NOT allowed (expected)");
		}
	}
	
	public void DateofbirthwithDate()
	{
		dateofBirth.click();
		dateofBirth.click();
		driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--today')]")).click();
		dateofBirth.click();

	}
	
	public void DateofbirthwithYear()
	{
		dateofBirthcalendar.click();
		yearsDropdown.click();
		Actions act = new Actions(driver);
		act.moveToElement(selectedYear).click().perform();
	}
	
	public void DateofbirthwithMonth()
	{
		dateofBirthcalendar.click();
		monthDropdown.click();
		Actions act = new Actions(driver);
		act.moveToElement(selectedMonth).click().perform();
	}
	
	public void LicenseExpiratiowithDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		By calendar = By.xpath("//div[@data-testid='licenseExpirationDate']");

		WebElement calendarElement =
		        wait.until(ExpectedConditions.elementToBeClickable(calendar));

		calendarElement.click();

		WebElement today =
		        wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//div[contains(@class,'react-datepicker__day--today')]")));

		today.click();

	}
	
	
	public void LicenseExpirationwithYear()
	{
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		By calendar = By.xpath("//div[@data-testid='licenseExpirationDate']");

		WebElement calendarElement =
		        wait.until(ExpectedConditions.elementToBeClickable(calendar));

		calendarElement.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.xpath("//div[@class='react-datepicker']")));

		WebElement year =
		        wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("(//details[@class='dropdown'])[1]")));

		year.click();
		WebElement selectedYear =
		        wait.until(ExpectedConditions.elementToBeClickable(
		                By.xpath("//a[contains(text(),'2010')]")));

		selectedYear.click();
		
	}
	
		public void AddnewDriver()
		{
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, addnewSubmitButton);
		addnewSubmitButton.click();
		}
		
		public void licenseExpirationwithDate()
		{
			licenseExpirationCalendar.click();
			licenseMonthDropdown.click();
			Actions act = new Actions(driver);
			act.moveToElement(selectedlicenseMonth).click().perform();
			
		}
		
		public void StartDateCalendar()
		{
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
			By startDate = By.xpath("//div[@data-testid='startDate']");
			WebElement element = wait.until(
			            ExpectedConditions.elementToBeClickable(startDate));
			element.click();
			}
			/*Actions act1 = new Actions(driver);
			act1.moveToElement(startDateCalendar).click().perform();*/
		
		
		public void MedicalDateCalendar()
		{
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
		    By medicalDate = By.xpath("//div[@data-testid='dotMedicalCardExpirationDate']");
		    wait.until(ExpectedConditions.presenceOfElementLocated(medicalDate));

		    // Re-fetch fresh element
		    WebElement element = driver.findElement(medicalDate);

		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    js.executeScript(
		        "arguments[0].scrollIntoView({block:'center'});",
		        element);

		    js.executeScript("arguments[0].click();", element);
			
			/*Actions act2 = new Actions(driver);
			act2.moveToElement(medicalDateCalendar).click().perform();*/
		}
		
		public void DriverlistLocation()
		{
			WebElement loction = driver.findElement(By.xpath("//div[@data-testid='driverLocation']"));
		    Assert.assertTrue(loction.isDisplayed(), "Driver location assignment is displayed");
		    WebElement henrylocation = driver.findElement(By.xpath("//span[contains(text(),'BioTrust Medical Disposal')]"));
		    Assert.assertTrue(henrylocation.isDisplayed(), "BioTrust Medical Disposal is displayed");
		    WebElement hhhlocation =  driver.findElement(By.xpath("(//span[contains (text(),'CosmoBridge Satellite Hu')])[1]"));
		    Assert.assertTrue(hhhlocation.isDisplayed(), "CosmoBridge Satellite Hu is displayed");
		    WebElement safemedlocation = driver.findElement(By.xpath("(//span[contains (text(),'SecureCare Medical Disposal')])[1]"));
		    	Assert.assertTrue(safemedlocation.isDisplayed(), "SecureCare Medical Disposal is displayed");
		    	WebElement orbitallocation = driver.findElement(By.xpath("(//span[contains (text(),'AstroNet Statio')])[1]"));
		    	Assert.assertTrue(orbitallocation.isDisplayed(), "AstroNet Statio is displayed");
		}
		
		public void DriverlistLocationInput()
		{
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
			By dropdown = By.xpath("//div[@data-testid='driverLocation']");
			WebElement element = wait.until(
			        ExpectedConditions.elementToBeClickable(dropdown));
			element.click();

			Actions action = new Actions(driver);

			action.sendKeys("sdh#$$76").perform();
			element.click();
		}
		
		public void DriverListlocationUncheck() throws InterruptedException
		{
			driverlistLocation.click();
			biotrustLocation.click();
			Thread.sleep(2000);

			cosmobridgeLocation.click();
			Thread.sleep(2000);

			secureCarelocation.click();
			Thread.sleep(2000);

			Actions act = new Actions(driver);
			act.moveToElement(novaorbitLocation).click().perform();
			Thread.sleep(2000);
		
			Actions act1 = new Actions(driver);
			act1.moveToElement(astrolinkLocation).click().perform();
			Thread.sleep(2000);


		}
		
		public void DriverListLocationCheck() throws InterruptedException
		{
			driverlistLocation.click();
			driverlistLocation.click();

			biotrustLocation.click();
			Thread.sleep(2000);

			cosmobridgeLocation.click();
			Thread.sleep(2000);

			secureCarelocation.click();
			Thread.sleep(2000);

			Actions act = new Actions(driver);
			act.moveToElement(novaorbitLocation).click().perform();
			Thread.sleep(2000);

			Actions act1 = new Actions(driver);
			act1.moveToElement(astrolinkLocation).click().perform();
			Thread.sleep(2000);
			driverlistLocation.click();

			
		}
		
		public void DriverlistremoveLocation() throws InterruptedException
		{
			Thread.sleep(2000);
			WebElement loction = driver.findElement(By.xpath("//div[@data-testid='driverLocation']"));
		    Assert.assertTrue(loction.isDisplayed(), "Driver location assignment is displayed");
		    Actions act = new Actions(driver);
		    act.moveToElement(biotrustCancelation).click().perform();
		    Thread.sleep(2000);
		    Actions act1 = new Actions(driver);
		    act1.moveToElement(cosmoBridgeCancelation).click().perform();
		    
		}
		
		public void DriverLicense()
		{
			Actions act = new Actions(driver);
			act.moveToElement(driverlicense).click().perform();
		}
		
		public void StartDatewithDate()
		{
			startDateCalendar.click();
			driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--today')]")).click();
			startDateCalendar.click();

		}
		
		public void StartDatewithYear()
		{
			startDateCalendar.click();
			Actions act1 = new Actions(driver);
			act1.moveToElement(startdateyearsdrpdown).click();
			Actions act = new Actions(driver);
			act.moveToElement(selectedStartyear).click();
			startDateCalendar.click();
		}
		
		public void DaysScheduledtoWork()
		{
			Actions act = new Actions(driver);

			scheduledworkday.click();

			act.sendKeys("hjfj874")
			   .sendKeys(Keys.ENTER)
			   .perform();
		}
		
		public void DaysSchediledworkDrpdown()
		{
			scheduledworkday.click();
			WebElement day1 = driver.findElement(By.xpath("//li[contains (text(),'Monday')]"));
		    Assert.assertTrue(day1.isDisplayed(), "Monday is displayed");
		    WebElement day2 = driver.findElement(By.xpath("//li[contains (text(),'Tuesday')]"));
		    Assert.assertTrue(day2.isDisplayed(), "Tuesday is displayed");
		    WebElement day3 =  driver.findElement(By.xpath("//li[contains (text(),'Wednesday')]"));
		    Assert.assertTrue(day3.isDisplayed(), "wednesday is displayed");
		    WebElement day4 = driver.findElement(By.xpath("//li[contains (text(),'Thursday')]"));
		    	Assert.assertTrue(day4.isDisplayed(), "Thursady is displayed");
		    	WebElement day5 = driver.findElement(By.xpath("//li[contains (text(),'Friday')]"));
		    	Assert.assertTrue(day5.isDisplayed(), "Friday is displayed");
		    	WebElement day6 = driver.findElement(By.xpath("//li[contains (text(),'Saturday')]"));
		    	Assert.assertTrue(day6.isDisplayed(), "saturday is displayed");
		    	WebElement day7 = driver.findElement(By.xpath("//li[contains (text(),'Sunday')]"));
		    	Assert.assertTrue(day7.isDisplayed(), "sunday is displayed");
			scheduledworkday.click();

		}
		
		public void DaysSchedulewithDays() throws InterruptedException
		{
			scheduledworkday.click();
			monday.click();
			Thread.sleep(2000);
			monday.click();
			scheduledworkday.click();

		}
		
		public void ScheduledworkwithMultipleDays() throws InterruptedException
		{
			scheduledworkday.click();
			monday.click();
			Thread.sleep(2000);
			tuesday.click();
			Thread.sleep(2000);
			wednesday.click();
			Thread.sleep(2000);
			thursday.click();
			Thread.sleep(2000);
			friday.click();
			Thread.sleep(2000);
			saturday.click();
			Thread.sleep(2000);
			sunday.click();
			Thread.sleep(2000);
			scheduledworkday.click();
		}
	
		public void ScheduledworkwithUnselect() throws InterruptedException
		{
			scheduledworkday.click();
			monday.click();
			Thread.sleep(2000);
			tuesday.click();
			Thread.sleep(2000);
			wednesday.click();
			Thread.sleep(2000);
			thursday.click();
			Thread.sleep(2000);
			friday.click();
			Thread.sleep(2000);
			saturday.click();
			Thread.sleep(2000);
			sunday.click();
			Thread.sleep(2000);
			scheduledworkday.click();
		}
		
		public void ScheduledworkdaywithDays() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement dropdown = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//div[@data-testid='scheduledWorkDays']")));

		    Assert.assertTrue(dropdown.isDisplayed(),
		            "Scheduled workday dropdown is displayed");

		    String[] days = {
		            "Monday",
		            "Tuesday",
		            "Wednesday",
		            "Thursday",
		            "Friday",
		            "Saturday",
		            "Sunday"
		    };

		    Actions actions = new Actions(driver);

		    for (String day : days) {

		        WebElement dayElement = wait.until(
		                ExpectedConditions.presenceOfElementLocated(
		                        By.xpath("//span[contains(text(),'" + day + "')]")));

		        actions.moveToElement(dayElement).perform();

		        Assert.assertTrue(dayElement.isDisplayed(),
		                day + " is displayed");
		    }
		}
		
		public void ZebraPrinting()
		{
			Actions act = new Actions(driver);

			zebraPrintingField.click();

			act.sendKeys("hjfj874")
			   .sendKeys(Keys.ENTER)
			   .perform();
			
		}
		
		public void ZebraPrintingwithOption()
		{
			zebraPrintingField.click();
			WebElement option = driver.findElement(By.xpath("//div[contains (text(),'Small')]"));
		    Assert.assertTrue(option.isDisplayed(), "Small is displayed");
		    WebElement option1 = driver.findElement(By.xpath("//div[contains (text(),'Medium')]"));
		    Assert.assertTrue(option1.isDisplayed(), "Medium is displayed");
		    WebElement option2 =  driver.findElement(By.xpath("//div[contains (text(),'Large')]"));
		    Assert.assertTrue(option2.isDisplayed(), "Large is displayed");

		}

		public void ZebraprintingwithSelection() throws InterruptedException
		{
			zebraPrintingField.click();
			zebraPrintingField.click();
			small.click();
			zebraPrintingField.click();
		}
		
		public void ZebraprintingwithMultiple() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    zebraPrintingField.click();
		    zebraPrintingField.click();
		    small.click();
		    zebraPrintingField.click();



		    /* Select first option
		    WebElement smallOption = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//li[@role='option'][normalize-space()='Small']")
		        )
		    );

		    smallOption.click();*/

		    // Try selecting second option
		    zebraPrintingField.click();
		    zebraPrintingField.click();
		    medium.click();
		    

		    /*WebElement mediumOption = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//li[@role='option'][normalize-space()='Medium']")
		        )
		    );

		    mediumOption.click();*/

		    // Validation
		    List<WebElement> selectedOptions = driver.findElements(
		        By.xpath("//li[@aria-selected='true']")
		    );

		    if (selectedOptions.size() > 1) {
		        System.out.println("FAILED : Field accepts multiple options");
		    } else {
		        System.out.println("PASSED : Field allows only single selection");
		    }
		}
		
		public void Zebraprintingwithontheroption() throws InterruptedException
		{
			zebraPrintingField.click();
			Thread.sleep(2000);
			large.click();
			zebraPrintingField.click();
			zebraPrintingField.click();

		}
		
		public void Zebraprinting()
		{
			WebElement option = driver.findElement(By.xpath("//div[@data-testid='zebraPrintingSize']"));
		    Assert.assertTrue(option.isDisplayed(), "zebraPrintingSize dropdown is displayed");
		    WebElement option1 = driver.findElement(By.xpath("//span[contains (text(),'Large')]"));
		    Assert.assertTrue(option1.isDisplayed(), "Large is displayed");
		}
		
		public void DutyStatus()
		{
			Actions act = new Actions(driver);

			dutystatus.click();

			act.sendKeys("hjfj874")
			   .sendKeys(Keys.ENTER)
			   .perform();
		}
		
		public void DutystatuswithOption()
		{
			dutystatus.click();
			dutystatus.click();
			dutystatus.click();
			WebElement fullduty = driver.findElement(By.xpath("//li[@role='option']//div[contains (text(),'Full Duty')]"));
		    Assert.assertTrue(fullduty.isDisplayed(), "Fullduty dropdown is displayed");
		    WebElement limitedduty = driver.findElement(By.xpath("//li[@role='option']//div[contains (text(),'Limited Duty')]"));
		    Assert.assertTrue(limitedduty.isDisplayed(), "Limited duty is displayed");
		    WebElement offduty = driver.findElement(By.xpath("//li[@role='option']//div[contains (text(),'Off Duty')]"));
		    Assert.assertTrue(offduty.isDisplayed(), "offDuty is displayed");
		    dutystatus.click();
		}
		
		public void Dutystatuswithclick() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.elementToBeClickable(dutystatus)).click();

			wait.until(ExpectedConditions.elementToBeClickable(fullduty)).click();

			wait.until(ExpectedConditions.elementToBeClickable(dutystatus)).click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", offDuty);

			wait.until(ExpectedConditions.elementToBeClickable(offDuty)).click();
		}
		
		public void DutystatuswithMultiple()
		{
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    dutystatus.click();
			    fullduty.click();
			    dutystatus.click();




			    /* Select first option
			    WebElement smallOption = wait.until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath("//li[@role='option'][normalize-space()='Small']")
			        )
			    );

			    smallOption.click();*/

			    // Try selecting second option
			   dutystatus.click();
			   dutystatus.click();
			   limitedDuty.click();
			   dutystatus.click();
			   dutystatus.click();


			    

			    /*WebElement mediumOption = wait.until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath("//li[@role='option'][normalize-space()='Medium']")
			        )
			    );

			    mediumOption.click();*/

			    // Validation
			    List<WebElement> selectedOptions = driver.findElements(
			        By.xpath("//li[@aria-selected='true']")
			    );

			    if (selectedOptions.size() > 1) {
			        System.out.println("FAILED : Field accepts multiple options");
			    } else {
			        System.out.println("PASSED : Field allows only single selection");
			    }
		}
		
		public void DutystatuswithChangeinoption() throws InterruptedException
		{
			dutystatus.click();
			Thread.sleep(2000);
			fullduty.click();
			dutystatus.click();
			dutystatus.click();
		}
		
		public void Dutystatuswithselectedoption()
		{
			WebElement dropdown = driver.findElement(By.xpath("//div[@data-testid='limitedDutyStatus']"));
		    Assert.assertTrue(dropdown.isDisplayed(), "Dutystatus dropdown is displayed");
		    WebElement option1 = driver.findElement(By.xpath("//span[contains (text(),'Full Duty')]"));
		    Assert.assertTrue(option1.isDisplayed(), "Fullduty is displayed");

		}
		
		public void DriverstatuswithInput()
		{
			Actions act = new Actions(driver);
			driverstatus.click();
			act.sendKeys("hjfj874")
			   .sendKeys(Keys.ENTER)
			   .perform();
			driverstatus.click();

			
		}
		
		public void DriverStatuswithOption()
		{
			driverstatus.click();
			WebElement dropdown = driver.findElement(By.xpath("//li[@role='option']//div[contains (text(),'Active')]"));
		    Assert.assertTrue(dropdown.isDisplayed(), "Active status dropdown is displayed");
		    WebElement option1 = driver.findElement(By.xpath("//li[@role='option']//div[contains (text(),'Inactive')]"));
		    Assert.assertTrue(option1.isDisplayed(), "Inactive status is displayed");

		}
		
		public void Driverstatusselectedoption() throws InterruptedException
		{
			driverstatus.click();
			driverstatus.click();
			Thread.sleep(2000);
			activedriverstatus.click();
		} 
		
		public void DriverstatuswithMultiple()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement statusDropdown = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//div[@data-testid='driverStatus']")
			    )
			);

			statusDropdown.click();

			WebElement activeOption = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//li[@role='option']//div[contains(text(),'Active')]")
			    )
			);

			activeOption.click();

			statusDropdown = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//div[@data-testid='driverStatus']")
			    )
			);

			statusDropdown.click();

			WebElement inactiveOption = wait.until(
			    ExpectedConditions.elementToBeClickable(
			        By.xpath("//li[@role='option']//div[contains(text(),'Inactive')]")
			    )
			);

			inactiveOption.click();

			List<WebElement> selectedOptions = driver.findElements(
			    By.xpath("//li[@aria-selected='true']")
			);

			if (selectedOptions.size() > 1) {
			    System.out.println("FAILED : Field accepts multiple options");
			} else {
			    System.out.println("PASSED : Field allows only single selection");
			}
		}
		
		public void Driverstatuswithontheroption()
		{
			driverstatus.click();
			activedriverstatus.click();
			driverstatus.click();
		}
		
		public void Driverwithselectedoption()
		{
			WebElement dropdown = driver.findElement(By.xpath("//div[@data-testid='driverStatus']"));
		    Assert.assertTrue(dropdown.isDisplayed(), "Driver status dropdown is displayed");
		    WebElement option1 = driver.findElement(By.xpath("//span[contains (text(),'Active')]"));
		    Assert.assertTrue(option1.isDisplayed(), "Inactive status is displayed");
			driverstatus.click();

		}
		
		public void LicensefieldwithInput()
		{
			WebElement uploadContainer =
					driver.findElement(By.xpath("//div[@data-testid='licensePhoto']"));

					JavascriptExecutor js =
					(JavascriptExecutor) driver;

					js.executeScript(
					    "arguments[0].scrollIntoView({block:'center'});",
					    uploadContainer
					);

			String fieldType = licensefield.getAttribute("type");

			System.out.println("Field Type : " + fieldType);

			try {
			    
			    licensefield.sendKeys("hjfj874");

			    System.out.println("FAILED : Field accepted invalid input");

			} catch (Exception e) {

			    System.out.println("PASSED : File input field does not accept alphanumeric text input");
			    
			    System.out.println("Exception : " + e.getMessage());
			}
		}
		
		
		public void MedicalcardfieldwithInput()
		{
			WebElement medicalcardfield = driver.findElement(By.xpath("(//input[@type='file'])[2]"));

			String fieldType = medicalcardfield.getAttribute("type");

			System.out.println("Field Type : " + fieldType);

			try {
			    
				medicalcardfield.sendKeys("hjfj874");

			    System.out.println("FAILED : Field accepted invalid input");

			} catch (Exception e) {

			    System.out.println("PASSED : File input field does not accept alphanumeric text input");
			    
			    System.out.println("Exception : " + e.getMessage());
			}
		}
		
		public void OctofieldLoginButton()
		{
			webDriverutility wlib = new webDriverutility();
			wlib.scrollToelement(driver, octoLoginButton);
			octoLoginButton.click();
		}
		
		public void OctoFieldappaccesswithOption()
		{
			WebElement option = driver.findElement(By.xpath("(//div[contains(.,'Call customer')]//div[@role='checkbox'])[1]"));
		    Assert.assertTrue(option.isDisplayed(), "Call customer is displayed");
		    WebElement option1 = driver.findElement(By.xpath("(//div[contains(.,'Call customer')]//div[@role='checkbox'])[2]"));
		    Assert.assertTrue(option1.isDisplayed(), "Email customer is displayed");
		}
		
		public void Octofieldappwithselectedoptions() throws InterruptedException
		{
			callcustomerCheckbox.click();
			Thread.sleep(2000);
			callcustomerCheckbox.click();
			Thread.sleep(2000);
			emailcustomerCheckbox.click();
			Thread.sleep(2000);
			emailcustomerCheckbox.click();
		}
		
		public void Octofieldappwithunselectedoptions() throws InterruptedException
		{
			callcustomerCheckbox.click();
			Thread.sleep(2000);
			emailcustomerCheckbox.click();
		}
		
		public void OctofieldappwithCalloption() throws InterruptedException
		{
			callcustomerCheckbox.click();
			Thread.sleep(2000);
		}
		
		public void OctofieldappwithEmailoption() throws InterruptedException
		{
			callcustomerCheckbox.click();
			Thread.sleep(2000);
			emailcustomerCheckbox.click();
		}
		
		public void Savebutton()
		{
			webDriverutility wlib = new webDriverutility();
			wlib.scrollToelement(driver, saveButton);
			saveButton.click();
		}
		
		public void Driverlist() throws InterruptedException
		{
			webDriverutility wlib = new webDriverutility();
			wlib.scrollToelement(driver, driverList);
			driverList.click();
			Thread.sleep(2000);
			WebElement option = driver.findElement(By.xpath("//div[@class='p-5']"));
		    Assert.assertTrue(option.isDisplayed(), "Driverlist is displayed");
		}
		
		public void AddedDriver() throws InterruptedException
		{
			webDriverutility wlib = new webDriverutility();
			WebElement addeddriver = driver.findElement(By.xpath("//div[contains(text(),'100072')]"));
			wlib.scrollToelement(driver, addeddriver);
			Thread.sleep(2000);
		    Assert.assertTrue(addeddriver.isDisplayed(), "addeddriver is displayed");
		
		}
		
		public void DriverswithActivestatus() throws InterruptedException
		{
		    listeddriverStatus.click();
		    Actions act = new Actions(driver);
		    act.moveToElement(listedActivestatus).click();
		    Thread.sleep(3000);
		    Actions act1 = new Actions(driver);
		    act1.moveToElement(listeddriverStatus).click();
		}
		
		public void DriverswithInactivestatus() throws InterruptedException
		{
			WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search options...']"));
			search.sendKeys("Inactive");
		    listedInactivestatus.click();
		    Thread.sleep(3000);
		}
			
		public void DriverswithAddedname() throws InterruptedException
		{
			WebElement addeddrivername = driver.findElement(By.xpath("//div[contains(text(),'100072')]/ancestor::a//div[contains (text(),'arjun K reddy')]"));
		    Assert.assertTrue(addeddrivername.isDisplayed(), "addeddriver name is displayed in the list");

		}
		
		public void DriverswithAddedOctoID()
		{
			WebElement addeddriveroctoid = driver.findElement(By.xpath("//div[contains(text(),'100072')]/ancestor::a//div[contains (text(),'100072')]"));
		    Assert.assertTrue(addeddriveroctoid.isDisplayed(), "addeddriver name is displayed in the list");

		}
		
		public void DriverswithPhonenumber()
		{
			WebElement addeddriverphone = driver.findElement(By.xpath("//div[contains(text(),'100072')]/ancestor::a//span[contains (text(),'(987) 667-5234')]"));
		    Assert.assertTrue(addeddriverphone.isDisplayed(), "addeddriver name is displayed in the list");

		}
		
		public void DriverswithEmail()
		{
		  System.out.println(email);
	 
		}
		
		public void DriverswithDriverLocation()
		{
			WebElement addeddrivelocation = driver.findElement(By.xpath("//div[text()='100072']/ancestor::a//div[contains(@class,'truncate w-60')]//p"));
		    Assert.assertTrue(addeddrivelocation.isDisplayed(), "addeddriver name is displayed in the list");
		}
		
		public void DriverswithDriverstatus()
		{
			WebElement addeddrivestatus = driver.findElement(By.xpath("//div[contains(text(),'100072')]/ancestor::a//div[contains (text(),'active')]"));
		    Assert.assertTrue(addeddrivestatus.isDisplayed(), "addeddriver name is displayed in the list");
		}
		
		
		

		
}

