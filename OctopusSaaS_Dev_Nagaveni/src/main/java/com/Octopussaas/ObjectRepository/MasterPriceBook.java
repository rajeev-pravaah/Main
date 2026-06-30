package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPriceBook {
	WebDriver driver;

	public MasterPriceBook(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	

	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//a[text()='View Price Book']")
	private WebElement viewpricebook;
	@FindBy(xpath = "//div[@class='flex items-center gap-2']")
	private WebElement togglebuttontext;
	@FindBy(xpath = "//p[text()='View Mode']/../descendant::button")
	private WebElement togglebuttonvivewmode;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesbuttoninEdittoggle;
	@FindBy(xpath = "//p[text()='Edit Mode']/../descendant::button")
	private WebElement togglebuttoneditmode;
	@FindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement servicepriceinputfield;
	@FindBy(xpath = "//h3[text()='Are you sure you want to edit the containers?']")
	private WebElement editmodepopuptext;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesbuttoninEditmodepopup;
	@FindBy(xpath = "(//button[text()='Cancel'])[4]")
	private WebElement cancelbuttoninEditmodepopup;
	@FindBy(xpath = "//h1[text()='Master Price Book']/../descendant::button")
	private WebElement servicesundermasterpricebook;
	@FindBy(xpath = "//h3[text()='Bio/Sharps']")
	private WebElement bioSharps;
	@FindBy(xpath = "//h3[text()='Bio/Sharps']/../descendant::button")
	private WebElement infoiconbesideBioSharps;
	@FindBy(xpath = "//div[text()='Active']")
	private WebElement activeheading;
	@FindBy(xpath = "//input[@value='test 38 Master']/ancestor::div[@class='flex items-center border-b min-w-fit border-gray-300 gap-2']/descendant::div[@role='checkbox']")
	private WebElement checkboxtest38master;
	@FindBy(xpath = "//div[text()='Active']/../descendant::div[text()='Master Item Name']")
	private WebElement masteritemnameheadingbesideactive;
	@FindBy(xpath = "//div[text()='Master Item Name']/../descendant::div[text()='Assigned to Generators']")
	private WebElement assignedtogeneratorsheadingbesidemasteritemname;
	@FindBy(xpath = "//div[text()='Assigned to Generators']/../descendant::div[text()='Service Price']")
	private WebElement servicepriceheadingbesideassignedtogenerators;
	@FindBy(xpath = "//div[text()='Service Price']/../descendant::div[text()='Allotment']")
	private WebElement allotmentheadingbesideserviceprice;
	@FindBy(xpath = "//div[text()='Allotment']/../descendant::div[text()='Additional Container Rate']")
	private WebElement additionalcontainerrateheadingbesideallotment;
	@FindBy(xpath = "//div[text()='Additional Container Rate']/../descendant::div[text()='Charge Per Pound']")
	private WebElement chargeperpoundheadingbesideadditionalcontainerrate;
	@FindBy(xpath = "//div[text()='Charge Per Pound']/../descendant::div[text()='Price Per Pound/Overweight Fees']")
	private WebElement priceperpoundoverweightfeesheadingbesidechargeperpound;
	
	
	
	public WebElement getPriceperpoundoverweightfeesheadingbesidechargeperpound() {
		return priceperpoundoverweightfeesheadingbesidechargeperpound;
	}
	public WebElement getChargeperpoundheadingbesideadditionalcontainerrate() {
		return chargeperpoundheadingbesideadditionalcontainerrate;
	}
	public WebElement getAdditionalcontainerrateheadingbesideallotment() {
		return additionalcontainerrateheadingbesideallotment;
	}
	public WebElement getAllotmentheadingbesideserviceprice() {
		return allotmentheadingbesideserviceprice;
	}
	public WebElement getServicepriceheadingbesideassignedtogenerators() {
		return servicepriceheadingbesideassignedtogenerators;
	}
	public WebElement getAssignedtogeneratorsheadingbesidemasteritemname() {
		return assignedtogeneratorsheadingbesidemasteritemname;
	}
	public WebElement getMasteritemnameheadingbesideactive() {
		return masteritemnameheadingbesideactive;
	}
	public WebElement getCheckboxtest38master() {
		return checkboxtest38master;
	}
	public WebElement getActiveheading() {
		return activeheading;
	}
	public WebElement getInfoiconbesideBioSharps() {
		return infoiconbesideBioSharps;
	}
	public WebElement getBioSharps() {
		return bioSharps;
	}
	public WebElement getServicesundermasterpricebook() {
		return servicesundermasterpricebook;
	}
	public WebElement getCancelbuttoninEditmodepopup() {
		return cancelbuttoninEditmodepopup;
	}
	public WebElement getYesbuttoninEditmodepopup() {
		return yesbuttoninEditmodepopup;
	}
	public WebElement getEditmodepopuptext() {
		return editmodepopuptext;
	}
	public WebElement getServicepriceinputfield() {
		return servicepriceinputfield;
	}
	public WebElement getTogglebuttoneditmode() {
		return togglebuttoneditmode;
	}
	public WebElement getYesbuttoninEdittoggle() {
		return yesbuttoninEdittoggle;
	}
	public WebElement getTogglebuttonViewMode() {
		return togglebuttonvivewmode;
	}
	public WebElement getTogglebuttonText() {
		return togglebuttontext;
	}
	public WebElement getViewpricebook() {
		return viewpricebook;
	}
	
	
}
