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

import com.Octopussaass.WebdriverUtility.webDriverutility;

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
	@FindBy(xpath = "//input[@placeholder='Enter General Email']")
	private WebElement generalemailfield;
	@FindBy(xpath = "//p[text()='Email is required']")
	private WebElement generalemailerrormessage;
	@FindBy(xpath = "//label[text()='Website URL']/../descendant::input")
	private WebElement generalwebsitefield;
	@FindBy(xpath = "//label[text()='Start of Fiscal Year']/../descendant::span")
	private WebElement startoffiscalyearfield;
	@FindBy(xpath = "//div[@data-testid='startOfFiscalYear']//following-sibling::*[name()='svg']")
	private WebElement startoffiscalendaricon;
	@FindBy(xpath = "//input[@placeholder='Enter Business Hours']")
	private WebElement businesshoursfield;
	@FindBy(xpath = "//input[@placeholder='Enter Google Review Link']")
	private WebElement googlereviewlinkfield;
	@FindBy(xpath = "//p[text()='Please enter a valid URL']")
	private WebElement googlereviewlinkerrormessage;
	@FindBy(xpath = "//div[contains(@class,'truncate') and contains(@class,'max-w-60')]")
	private List<WebElement> satelliteLocationNameinlist;
	@FindBy(xpath = "(//label[text()='Company Logo ']/../descendant::button)[2]")
	private WebElement companylogodeletebutton;
	@FindBy(xpath = "//label[text()='Company Logo ']/../descendant::div")
	private WebElement companylogopfield;
	@FindBy(xpath = "//p[text()='Satellite Location Status* ']/../../descendant::button")
	private WebElement satellitelocationstatusdropdown;
	@FindBy(id = "satellite-location status")
	private WebElement satellitelocationstatusdropdownfield;
	@FindBy(xpath = "//div[text()='Inactive']")
	private WebElement inactivefromstatusdropdownfield;
	@FindBy(xpath = "//div[text()='Active']")
	private WebElement activefromstatusdropdownfield;
	@FindBy(xpath = "//input[@placeholder='Enter Registration Number 1']")
	private WebElement registrationnumber1field;
	@FindBy(xpath = "//p[text()='Registration Number 1 is required']")
	private WebElement registrationnumber1errormessage;
	@FindBy(xpath = "//input[@placeholder='Enter Registration Number 2']")
	private WebElement registrationnumber2field;
	@FindBy(xpath = "//input[@placeholder='Enter EPA ID Number']")
	private WebElement epanumberfield;
	@FindBy(xpath = "//input[@placeholder='Enter DOT Number']")
	private WebElement dotnumberfield;
	@FindBy(xpath = "//input[@placeholder='Enter EIN']")
	private WebElement einfield;
	@FindBy(xpath = "//input[@placeholder='Enter Entity ID Number']")
	private WebElement entityidnumberfield;
	@FindBy(xpath = "//input[@placeholder='Enter SOS Number']")
	private WebElement sosnumberfield;
	@FindBy(xpath = "//input[@placeholder='Enter SIC Code']")
	private WebElement siccodefield;
	@FindBy(xpath = "//input[@placeholder='Enter NAICS Code']")
	private WebElement naicscodefield;
	@FindBy(xpath = "//input[@placeholder='Enter CAGE Code']")
	private WebElement cagecodefield;
	@FindBy(id = "serviceAddress-name")
	private WebElement satelliteserviceinfonamefield;
	@FindBy(id = "serviceAddress-street")
	private WebElement satelliteserviceinfostreetfield;
	@FindBy(xpath = "(//p[text()='This field is required'])[1]")
	private WebElement satelliteserviceinfonameerrormessage;
	@FindBy(xpath = "(//p[text()='This field is required'])[2]")
	private WebElement satelliteserviceinfostreeterrormessage;
	@FindBy(xpath = "//div[@class='font-medium']/../..")
	private WebElement streetSuggestionbox;
	@FindBy(xpath = "//span[text()='Medical Waste Services']")
	private WebElement medicalwasteservicestxt;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getMedicalwasteservicestxt() {
		return medicalwasteservicestxt;
	}
	public WebElement getStreetSuggestionbox() {
		return streetSuggestionbox;
	}
	public WebElement getSatelliteserviceinfostreeterrormessage() {
		return satelliteserviceinfostreeterrormessage;
	}
	public WebElement getSatelliteserviceinfoNameerrormessage() {
		return satelliteserviceinfonameerrormessage;
	}
	public WebElement getSatelliteserviceinfostreetfield() {
		return satelliteserviceinfostreetfield;
	}
	public WebElement getCagecodefield() {
		return cagecodefield;
	}
	public WebElement getSatelliteserviceinfonamefield() {
		return satelliteserviceinfonamefield;
	}
	public WebElement getNaicscodefield() {
		return naicscodefield;
	}
	public WebElement getSiccodefield() {
		return siccodefield;
	}
	public WebElement getSosnumberfield() {
		return sosnumberfield;
	}
	public WebElement getEntityidnumberfield() {
		return entityidnumberfield;
	}
	public WebElement getEinfield() {
		return einfield;
	}
	public WebElement getDotnumberfield() {
		return dotnumberfield;
	}
	public WebElement getEpanumberfield() {
		return epanumberfield;
	}
	public WebElement getRegistrationnumber2field() {
		return registrationnumber2field;
	}
	public WebElement getRegistrationnumber1errormessage() {
		return registrationnumber1errormessage;
	}
	public WebElement getRegistrationnumber1field() {
		return registrationnumber1field;
	}
	public WebElement getActivefromstatusdropdownfield() {
		return activefromstatusdropdownfield;
	}
	public WebElement getInactivefromstatusdropdownfield() {
		return inactivefromstatusdropdownfield;
	}
	public WebElement getSatellitelocationstatusdropdownfield() {
		return satellitelocationstatusdropdownfield;
	}
	public WebElement getSatellitelocationstatusdropdown() {
		return satellitelocationstatusdropdown;
	}
	public WebElement getCompanylogopfield() {
		return companylogopfield;
	}
	public WebElement getCompanylogodeletebutton() {
		return companylogodeletebutton;
	}
	public List<WebElement> getSatelliteLocationNameinlist() {
		return satelliteLocationNameinlist;
	}
	public WebElement getGooglereviewlinkerrormessage() {
		return googlereviewlinkerrormessage;
	}
	public WebElement getGooglereviewlinkfield() {
		return googlereviewlinkfield;
	}
	public WebElement getBusinesshoursfield() {
		return businesshoursfield;
	}
	public WebElement getStartoffiscalendaricon() {
		return startoffiscalendaricon;
	}
	public WebElement getStartoffiscalyearfield() {
		return startoffiscalyearfield;
	}
	public WebElement getGeneralwebsitefield() {
		return generalwebsitefield;
	}
	public WebElement getGeneralemailerrormessage() {
		return generalemailerrormessage;
	}
	public WebElement getGeneralemailfield() {
		return generalemailfield;
	}
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
	public void SaveButton()
	{
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, savebutton);
		savebutton.click();
	}
}
