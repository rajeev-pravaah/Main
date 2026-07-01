package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SatelliteLocation {
	WebDriver driver;

	public SatelliteLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//h6[text()='Assets']")
	private WebElement Assets;
	@FindBy(xpath = "//h6[text()='Satellite Locations']")
	private WebElement Satellite_Locations;
	@FindBy(xpath = "//h2[text()='Satellite Locations List']")
	private WebElement SatelliteLocationsList;
	@FindBy(xpath = "//a[contains(@href,'/edit')]")
	private List<WebElement> listofsatellitelocations;
	@FindBy(xpath = "//span[text()='Add New Satellite Location']")
	private WebElement AddNewSatelliteLocationbutton;
	@FindBy(xpath = "//h6[text()='Add New Satellite Location']")
	private WebElement AddNewSatelliteLocationPopUp;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement SatelliteLocationName;
	@FindBy(xpath = "//button[text()='Add New Satellite Location']")
	private WebElement AddNewSatelliteLocationButtoninPopup;
	@FindBy(xpath = "//p[text()='Satellite Location Name is required']")
	private WebElement SatelliteLocationNameErrorMessage;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement addnewsastelliteemailfield;
	@FindBy(xpath = "//p[text()='Please enter a valid email address']")
	private WebElement addnewsastelliteemailfielderrormessage;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement addnewsastellitewebsitefield;
	@FindBy(xpath = "//p[text()='Please enter a valid website URL']")
	private WebElement addnewsastellitewebsitefielderrormessage;
	@FindBy(xpath = "//button[@id='satellite-location status']")
	private WebElement addnewsastatellitelocationstatusdropdown;
	@FindBy(xpath = "//div[text()='Inactive']")
	private WebElement inactivestatusdropdown;
	@FindBy(xpath = "//div[text()='Inactive']/../../descendant::div")
	private WebElement activestatusdropdown;
	@FindBy(xpath = "//button[text()='Add New Satellite Location']")
	private WebElement addnewsastatellitelocationbuttonfrompopup;
	@FindBy(xpath = "//div[text()='Satellite Location Profile']")
	private WebElement satellitelocationprofile;
	@FindBy(xpath = "//div[text()='Satellite Location Profile']/../descendant::button")
	private WebElement satellitelocationinformationtootltipicon;
	@FindBy(xpath = "//h2[text()='OCTO Info: Satellite Locations']")
	private WebElement satellitelocationinformationpopup;
	@FindBy(xpath = "//button[@aria-label='Close tooltip']")
	private WebElement closepopupbutton;
	@FindBy(xpath = "//label[text()='Company Name*']/../descendant::input")
	private WebElement companynamefield;
	@FindBy(xpath = "//label[text()='Company Display Name*']/../descendant::input")
	private WebElement companydisplaynamefield;
	@FindBy(xpath = "//label[text()='General Phone*']")
	private WebElement generalphonetext;
	@FindBy(xpath = "//p[text()='Company Display Name is required']")
	private WebElement companydisplaynameerrormessage;
	@FindBy(xpath = "//label[text()='General Phone*']/../descendant::input")
	private WebElement generalphonefield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;
	@FindBy(xpath = "(//p[text()='Phone is required'])[1]")
	private WebElement generalphoneerrormessage;
	@FindBy(xpath = "(//label[text()='General Phone*']/../descendant::input)[2]")
	private WebElement generalphoneextfield;
	
	
	
	
	
	
	
	
	
	public WebElement getGeneralphoneextfield() {
		return generalphoneextfield;
	}
	public WebElement getGeneralphoneerrormessage() {
		return generalphoneerrormessage;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getGeneralphonefield() {
		return generalphonefield;
	}
	public WebElement getCompanydisplaynameerrormessage() {
		return companydisplaynameerrormessage;
	}
	public WebElement getGeneralphonetext() {
		return generalphonetext;
	}
	public WebElement getCompanydisplaynamefield() {
		return companydisplaynamefield;
	}
	public WebElement getCompanynamefield() {
		return companynamefield;
	}
	public WebElement getClosepopupbutton() {
		return closepopupbutton;
	}
	public WebElement getSatellitelocationinformationpopup() {
		return satellitelocationinformationpopup;
	}
	public WebElement getSatellitelocationinformationtootltipicon() {
		return satellitelocationinformationtootltipicon;
	}
	public WebElement getSatellitelocationprofile() {
		return satellitelocationprofile;
	}
	public WebElement getAddnewsastatellitelocationbuttonfrompopup() {
		return addnewsastatellitelocationbuttonfrompopup;
	}
	public WebElement getActiveStatusDD() {
		return activestatusdropdown;
	}
	public WebElement getInactivestatusdropdown() {
		return inactivestatusdropdown;
	}
	public WebElement getAddnewsastatellitelocationstatusdropdown() {
		return addnewsastatellitelocationstatusdropdown;
	}
	public WebElement getAddnewsastellitewebsitefielderrormessage() {
		return addnewsastellitewebsitefielderrormessage;
	}
	public WebElement getAddnewsastellitewebsitefield() {
		return addnewsastellitewebsitefield;
	}
	public WebElement getAddnewsastelliteemailfielderrormessage() {
		return addnewsastelliteemailfielderrormessage;
	}
	public WebElement getAddnewsastelliteemailfield() {
		return addnewsastelliteemailfield;
	}
	public WebElement getSatelliteLocationNameErrorMessage() {
		return SatelliteLocationNameErrorMessage;
	}
	public WebElement getAddNewSatelliteLocationButtoninpopup() {
		return AddNewSatelliteLocationButtoninPopup;
	}
	public WebElement getSatelliteLocationName() {
		return SatelliteLocationName;
	}
	public WebElement getAddNewSatelliteLocationPopUp() {
		return AddNewSatelliteLocationPopUp;
	}
	public WebElement getAddNewSatelliteLocationbutton() {
		return AddNewSatelliteLocationbutton;
	}
	public List<WebElement> getListofsatellitelocations() {
		return listofsatellitelocations;
	}
	public WebElement getSatelliteLocationsList() {
		return SatelliteLocationsList;
	}
	public WebElement getSatellite_Locations() {
		return Satellite_Locations;
	}
	
		public WebElement getAssets() {
		return Assets;
	}
		
		
	
	public void ClearTextField(WebElement txt) throws InterruptedException
		{
			txt.click();
	 		Thread.sleep(1000);

	 		Actions actions = new Actions(driver);

	 		actions.click(txt)
	 		       .keyDown(Keys.CONTROL)
	 		       .sendKeys("a")
	 		       .keyUp(Keys.CONTROL)
	 		       .sendKeys(Keys.DELETE)
	 		       .perform();
		}
}
