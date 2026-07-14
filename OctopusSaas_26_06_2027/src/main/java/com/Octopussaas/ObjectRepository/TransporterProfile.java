package com.Octopussaas.ObjectRepository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

public class TransporterProfile {
	WebDriver driver;

	public TransporterProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	Actions act;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement companynametxtfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Submitbtn;
	@FindBy(xpath = "//div[@class='ml-6']")
	private WebElement ClickOnOtherside;
	@FindBy(xpath = "//input[@placeholder='Enter company display name']")
	private WebElement ccompanydisplayname;
	@FindBy(xpath = "(//input[@placeholder='(123) 456-7890'])[1]")
	private WebElement phonenumber;
	@FindBy(xpath = "//input[@placeholder='name@company.com']")
	private WebElement generalEmail;
	@FindBy(xpath = "//input[@placeholder='https://example.com']")
	private WebElement websiteUrl;
	@FindBy(xpath = "//button[@title='Open link']")
	private WebElement RedirectUrl;
	@FindBy(xpath = "//div[@data-testid='custom-date-picker']")
	private WebElement Startfacialyear;
	@FindBy(xpath = "//input[@placeholder='https://example.com/reviews']")
	private WebElement googleReviewLink;
	@FindBy(xpath = "//div[@data-testid='custom-date-picker']")
	private WebElement datePicker;
    @FindBy(xpath = "(//*[local-name()='svg' and contains(@class,'text-cardTextGray')])[1]")
    private WebElement uploadfile;
    @FindBy(xpath = "(//h3[contains(text(),'Generator Profile Not Setup')])[2]")
    private WebElement profilenotsetuppopup;
    
    //Nagaveni
    @FindBy(xpath = "//input[@placeholder='Registration #1']")
    private WebElement registrationNumber1;
    @FindBy(xpath = "//p[contains (text(), 'Registration Number 1 is required')]")
    private WebElement registrationNumber1Ermsg;
	@FindBy (xpath = "//input[@placeholder='Registration #2 (optional)']")
	private WebElement registrationNumber2;
	@FindBy (xpath = "//input[@placeholder=\"EPA ID (if applicable)\"]")
	private WebElement epaIDNumber;
	@FindBy (xpath = "//input[@placeholder=\"DOT number\"]")
	private WebElement dotNumber;
	@FindBy (xpath = "//input[@placeholder='Employer Identification Number']")
	private WebElement einNumber;
	@FindBy (xpath = "//input[@placeholder='Entity ID']")
	private WebElement entityId;
	@FindBy (xpath = "//input[@placeholder='SOS number']")
	private WebElement sosCode;
	@FindBy (xpath = "//input[@placeholder='SIC code']")
	private WebElement sicCode;
	@FindBy (xpath = "//input[@placeholder=\"NAICS code\"]")
	private WebElement naicsCode;
	@FindBy (xpath = "//input[@placeholder=\"CAGE code\"]")
	private WebElement cageCode;
	@FindBy (xpath = "(//button[@type=\"button\"])[1]")
	private WebElement tooltip;
	@FindBy (xpath = "//input[@id='serviceAddress-name']")
	private WebElement serviceName;
	@FindBy (xpath = "((//label[contains(text(),'Name')]/following::p[contains(text(),'This field is required')][1]))[1]")
	private WebElement serviceNameErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-street']")
	private WebElement serviceAddress;
	@FindBy(xpath = "//input[@id='serviceAddress-street']")
	private WebElement street1;
	@FindBy(xpath = "//div[contains(text(),'1237 3rd Street Southeast')]")
	private WebElement road;
	@FindBy (xpath = "(//label[contains(text(),'Street')]/following::p[contains(text(),'This field is required')][1])[1]")
	private WebElement serviceAddressErmsg;
	@FindBy (xpath = "//input[@id=\"serviceAddress-suite\"]")
	private WebElement suite;
	@FindBy (xpath = "//input[@id='serviceAddress-city']")
	private WebElement city;
	@FindBy (xpath = "(//label[contains(text(),'City')]/following::p[contains(text(),'This field is required')][1])[1]")
	private WebElement serviceCityErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-state']")
	private WebElement state;
	@FindBy (xpath = "//li[@role='option' and normalize-space()='AZ']")
	private WebElement stateOptionAZ;
	//@FindBy (xpath = "(//p[contains (text(), 'This field is required')])[]")
	//private WebElement stateErmsg;
	@FindBy (xpath = "//li[@role='option' and normalize-space()='CA']")
	private WebElement stateoptionCA;
	@FindBy (xpath ="//input[@id='serviceAddress-zipCode']")
	private WebElement zipCode;
	@FindBy (xpath = "(//label[contains(text(),'ZIP Code')]/following::p[contains(text(),'This field is required')][1])[1]")
	private WebElement zipcodeErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-email']")
	private WebElement email;
	@FindBy (xpath = "//p[contains (text(), 'Invalid email format')]")
	private WebElement invalidErmsg;
	@FindBy (xpath = "(//label[contains(text(),'Email')]/parent::div/following-sibling::p[contains(text(),'This field is required')])[1]")
	private WebElement emailErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-phone']")
	private WebElement servicePhone;
	@FindBy (xpath ="(//label[normalize-space()='Phone *']/parent::div/following-sibling::p[1])[1]")
	private WebElement servicephoneErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-phone-ext']")
	private WebElement phoneExt;
	@FindBy (xpath = "//button[@id='address-copy-button']")
	private WebElement copyButton;
	@FindBy (xpath = "//input[@id='billingAddress-name']")
	private WebElement billingaddName;
	@FindBy (xpath = "(//label[contains(text(),'Name')]/following::p[contains(text(),'This field is required')][1])[2]")
	private WebElement nameErmag;
	@FindBy (xpath = "//input[@id='billingAddress-street']")
	private WebElement billingaddStreet;
	@FindBy (xpath = "(//label[contains(text(),'Street')]/following::p[contains(text(),'This field is required')][1])[2]")
	private WebElement billingStreetErmsg;
	@FindBy (xpath = "//input[@id='billingAddress-suite']")
	private WebElement billingSuite;
	@FindBy (xpath = "//input[@id='billingAddress-city']")
	private WebElement billingCity;
	@FindBy (xpath = "(//label[contains(text(),'City')]/following::p[contains(text(),'This field is required')][1])[2]")
	private WebElement billingCityErmsg;
	@FindBy (xpath = "//input[@id='billingAddress-state']")
	private WebElement billingaddState;
	@FindBy (xpath = "//li[@role='option' and normalize-space()='AZ']")
	private WebElement billingAZstate;
	@FindBy (xpath ="//li[@role='option' and normalize-space()='CA']")
	private WebElement billingCAstate;
	@FindBy (xpath = "//input[@id='billingAddress-zipCode']")
	private WebElement billingaddZipcode;
	@FindBy (xpath = "(//label[contains(text(),'ZIP Code')]/following::p[contains(text(),'This field is required')][1])[2]")
	private WebElement billingZipcodeErmsg;
	@FindBy (xpath = "//input[@id='billingAddress-email']")
	private WebElement billingEmail;
	@FindBy (xpath = "//p[contains (text(), 'Invalid email format')]")
	private WebElement billingEmailErmsg;
	@FindBy (xpath = "(//label[contains(text(),'Email')]/parent::div/following-sibling::p[contains(text(),'This field is required')])[3]")
	private WebElement billingEmailErrormsg;
	@FindBy (xpath = "//input[@id='billingAddress-phone']")
	private WebElement billindaddPhone;
	@FindBy (xpath = "(//label[normalize-space()='Phone *']/parent::div/following-sibling::p[1])[2]")
	private WebElement billingPhoneErmsg;
	@FindBy (xpath = "//input[@id='billingAddress-phone-ext']")
	private WebElement billingaddExt;
	@FindBy (xpath = "(//div[@class='relative inline-block'])[3]")
	private WebElement businessTooltip;
	@FindBy (xpath = "//input[@placeholder='Monday Opening Time']")
	private WebElement businessMondaytime;
	@FindBy(xpath = "//span[contains(text(),'8:00 AM')]")
	private WebElement mondayOpenTime;
	@FindBy (xpath = "//input[@placeholder='Tuesday Opening Time']")
	private WebElement businessTuesday;
	@FindBy (xpath = "//span[contains(text(),'8:30 AM')]")
	private WebElement tuesdayopentime;
	@FindBy (xpath = "//input[@placeholder='Wednesday Opening Time']")
	private WebElement businessWednesday;
	@FindBy (xpath = "//span[contains(text(),'8:30 AM')]")
	private WebElement wednesdayOpenTime;
	@FindBy (xpath = "//input[@placeholder='Thursday Opening Time']")
	private WebElement businessThursday;
	@FindBy (xpath = "//span[contains(text(),'8:00 AM')]")
	private WebElement thursdayOpentime;
	@FindBy (xpath = "//input[@placeholder='Friday Opening Time']")
	private WebElement businessFriday;
	@FindBy (xpath = "//span[contains(text(),'8:00 AM')]")
	private WebElement firdayOpenTime;
	@FindBy (xpath = "//input[@placeholder='Saturday Opening Time']")
	private WebElement businessSaturday;
	@FindBy (xpath = "//span[contains(text(),'8:00 AM')]")
	private WebElement saturdayOpenTime;
	@FindBy (xpath = "//input[@placeholder='Sunday Opening Time']")
	private WebElement businessSunday;
	@FindBy (xpath = "//span[contains(text(),'8:30 AM')]")
	private WebElement sundayOpenTime;
	@FindBy (xpath = "//input[@placeholder='Monday Lunch Start Time']")
	private WebElement businessMondaylunch;
	@FindBy (xpath = "//span[contains(text(),'11:30 AM')]")
	private WebElement mondaylunchTime;
	@FindBy (xpath = "//input[@placeholder='Monday Lunch End Time']")
	private WebElement businessMondaylunchEnd;
	@FindBy (xpath = "//span[contains(text(),'12:30 PM')]")
	private WebElement mondayLunchEndTime;
	@FindBy (xpath = "//input[@placeholder='Monday Closing Time']")
	private WebElement businessMondayclose;
	@FindBy (xpath = "//span[contains(text(),'5:00 PM')]")
	private WebElement mondaycloseTime;
	@FindBy (xpath = "(//div[@class='flex items-center rounded-lg  justify-center '])[1]")
	private WebElement mondayCheckbox;
	@FindBy (xpath = "(//div[@class='flex items-center rounded-lg  justify-center '])[2]")
	private WebElement tuesdayCheckBox;
	@FindBy (xpath = "(//div[@class='flex items-center rounded-lg  justify-center '])[3]")
	private WebElement wednesdayCheckBox;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[1]")
	private WebElement copybutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[4]")
	private WebElement tuesdayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[6]")
	private WebElement wednesdayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[8]")
	private WebElement thursdayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[10]")
	private WebElement fridayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[12]")
	private WebElement saturdayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[14]")
	private WebElement sundayPastebutton;
	@FindBy (xpath = "(//span[@class='w-1/2 flex items-center justify-center'])[4]")
	private WebElement thursdayCheckBox;
	@FindBy (xpath = "//div[@data-placeholder='Brief one-line description']")
	private WebElement shortdescription;
	@FindBy (xpath = "//div[@data-placeholder='Detailed company bio']")
	private WebElement bioField;
	@FindBy (xpath = "(//div[@class='relative inline-block'])[4]")
	private WebElement serviceOfferedTooltip;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Medical Waste Services')]]//div[@role='checkbox']/div")
	private WebElement medicalwasteCheckbox;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Paper Shredding Services')]] //div[@role='checkbox']/div")
	private WebElement papersheddingCheckbox;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Electronic Waste Recycling Services')]] //div[@role='checkbox']/div")
	private WebElement electronicwasteCheckbox;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Disposal Facilities')]] //div[@role='checkbox']/div")
	private WebElement disposalfacilityCheckbox;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Product Destruction')]] //div[@role='checkbox']/div")
	private WebElement productCheckbox;
	@FindBy (xpath = "//div[contains(@class,'flex items-center')][.//text()[contains(.,'Universal Waste')]] //div[@role='checkbox']/div")
	private WebElement universalwasteCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Bio/Sharps']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement biosharpCheckbox;
	@FindBy (xpath = "//span[normalize-space()='APHIS Services (Animal & Plant Health Inspection)']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement aphisCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Onsite Paper Shredding']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement onsiteCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Offsite Paper Shredding']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement offsiteCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Medical Waste Transfer Station']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement transferCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Medical Waste Treatment Facilities']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement treatmentCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Recycling']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement recyclingCheckbox;
	@FindBy (xpath = "//span[normalize-space()='Solid Waste']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement solidCheckBox;
	@FindBy (xpath = "//span[normalize-space()='Portable Toilet / Sanitation Industry']/preceding-sibling::div[@role='checkbox']/div")
	private WebElement portableCheckbox;
	@FindBy (xpath = "//h3[contains(text(),'Are you sure?')]")
	private WebElement confirmationBox;
	@FindBy (xpath = "//button[contains (text(), 'Confirm')]")
	private WebElement confirmButton;
	@FindBy (xpath = "//input[@placeholder='dispatch@company.com']")
	private WebElement dispatchEmail;
	@FindBy (xpath = "//p[contains (text(),'Please enter a valid email address')]")
	private WebElement dispatchEmailInvalid;
	@FindBy (xpath = "//p[contains (text(),'Email is required')]")
	private WebElement dispatchEmailErmsg;
	@FindBy (xpath = "(//input[@placeholder='(123) 456-7890'])[4]")
	private WebElement dispatchPhonefield;
	@FindBy (xpath = "(//p[contains(text(),'Phone is required')])[2]")
	private WebElement dispatchPhoneErmsg;
	@FindBy (xpath = "//input[@id='undefined-ext']")
	private WebElement dispathchExtField;
	@FindBy (xpath = "//div[@class='w-3 h-3 bg-white rounded-full']")
	private WebElement optInButton;
	@FindBy (xpath = "(//div[@type='button'])[1]")
	private WebElement categoriesDropdown;
	@FindBy (xpath = "//input[@class='h-4 w-4 rounded border-gray-300']//following-sibling::span[contains(text(),'E-Waste Recycling Services')]")
	private WebElement categoryEwaste;
	@FindBy (xpath = "//input[@class='h-4 w-4 rounded border-gray-300']//following-sibling::span[contains(text(),'Container Supplier (Medical Waste)')]")
	private WebElement containerMedicalwaste;
	@FindBy (xpath = "//input[@class='h-4 w-4 rounded border-gray-300']//following-sibling::span[contains(text(),'Consulting Services')]")
	private WebElement consultingService;
	@FindBy (xpath = "//input[@class='h-4 w-4 rounded border-gray-300']//following-sibling::span[contains(text(),'Online OSHA Training')]")
	private WebElement onlineCategory;
	@FindBy (xpath = "//p[contains(text(),'At least one category is required')]")
	private WebElement categoryErmsg;
	@FindBy (xpath = "//input[@value='nationwide']")
	private WebElement nationwideRadioButton;
	@FindBy (xpath = "//input[@value='local']")
	private WebElement cityRadioButton;
	@FindBy (xpath = "//input[@placeholder='City *']")
	private WebElement serviceareaCity;
	@FindBy (xpath = "(//div[@type='button'])[2]")
	private WebElement serviceareaState;
	@FindBy (xpath = "//span[contains(text(),'AK')]")
	private WebElement serviceStateAK;
	@FindBy (xpath = "//span[contains(text(),'AZ')]")
	private WebElement serviceStateAZ;
	@FindBy (xpath = "//input[@placeholder='Miles *']")
	private WebElement ServiceareaMiles;
	@FindBy (xpath = "//button[contains(text(),'Add')]")
	private WebElement addButton;
	@FindBy (xpath = "//p[contains(text(),'Please select a service area type')]")
	private WebElement serviceareaErmsg;
	@FindBy (xpath = "(//button[@type='button']//*[name()='svg'])[8]")
	private WebElement deleteButton;
	@FindBy (xpath = "//button[@id='state']")
	private WebElement stateTransistStatedrp;
	@FindBy (xpath = "//input[@placeholder='Enter Transit ID']")
	private WebElement transistIdField;
	@FindBy (xpath = "//input[@placeholder='Enter Transit ID']/following::button[1]")
	private WebElement transistAddButton;
	@FindBy (xpath = "//p[text()='Added State Transit IDs']/following::button[1]")
	private WebElement transistDeletebutton;
	
	

	public WebElement getTransistDeletebutton() {
		return transistDeletebutton;
	}
	public WebElement getTransistAddButton() {
		return transistAddButton;
	}
	public WebElement getTransistIdField() {
		return transistIdField;
	}
	public WebElement getStateTransistStatedrp() {
		return stateTransistStatedrp;
	}
	public WebElement getStreet1() {
		return street1;
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public WebElement getServiceareaErmsg() {
		return serviceareaErmsg;
	}
	public WebElement getAddButton() {
		return addButton;
	}
	public WebElement getServiceareaMiles() {
		return ServiceareaMiles;
	}
	public WebElement getServiceStateAK() {
		return serviceStateAK;
	}
	public WebElement getServiceareaState() {
		return serviceareaState;
	}
	public WebElement getServiceareaCity() {
		return serviceareaCity;
	}
	public WebElement getCityRadioButton() {
		return cityRadioButton;
	}
	public WebElement getNationwideRadioButton() {
		return nationwideRadioButton;
	}
	public WebElement getCategoryErmsg() {
		return categoryErmsg;
	}
	public WebElement getOnlineCategory() {
		return onlineCategory;
	}
	public WebElement getConsultingService() {
		return consultingService;
	}
	public WebElement getContainerMedicalwaste() {
		return containerMedicalwaste;
	}
	public WebElement getCategoryEwaste() {
		return categoryEwaste;
	}
	public WebElement getCategoriesDropdown() {
		return categoriesDropdown;
	}
	public WebElement getOptInButton() {
		return optInButton;
	}
	public WebElement getDispathchExtField() {
		return dispathchExtField;
	}
	public WebElement getDispatchPhoneErmsg() {
		return dispatchPhoneErmsg;
	}
	public WebElement getDispatchPhonefield() {
		return dispatchPhonefield;
	}
	public WebElement getDispatchEmailErmsg() {
		return dispatchEmailErmsg;
	}
	public WebElement getDispatchEmailInvalid() {
		return dispatchEmailInvalid;
	}
	public WebElement getDispatchEmail() {
		return dispatchEmail;
	}
	public WebElement getConfirmButton() {
		return confirmButton;
	}
	public WebElement getConfirmationBox() {
		return confirmationBox;
	}
	public WebElement getPortableCheckbox() {
		return portableCheckbox;
	}
	public WebElement getSolidCheckBox() {
		return solidCheckBox;
	}
	public WebElement getRecyclingCheckbox() {
		return recyclingCheckbox;
	}
	public WebElement getTreatmentCheckbox() {
		return treatmentCheckbox;
	}
	public WebElement getTransferCheckbox() {
		return transferCheckbox;
	}
	public WebElement getOffsiteCheckbox() {
		return offsiteCheckbox;
	}
	public WebElement getOnsiteCheckbox() {
		return onsiteCheckbox;
	}
	public WebElement getAphisCheckbox() {
		return aphisCheckbox;
	}
	public WebElement getBiosharpCheckbox() {
		return biosharpCheckbox;
	}
	public WebElement getUniversalwasteCheckbox() {
		return universalwasteCheckbox;
	}
	public WebElement getProductCheckbox() {
		return productCheckbox;
	}
	public WebElement getDisposalfacilityCheckbox() {
		return disposalfacilityCheckbox;
	}
	public WebElement getElectronicwasteCheckbox() {
		return electronicwasteCheckbox;
	}
	public WebElement getPapersheddingCheckbox() {
		return papersheddingCheckbox;
	}
	public WebElement getMedicalwasteCheckbox() {
		return medicalwasteCheckbox;
	}
	public WebElement getServiceOfferedTooltip() {
		return serviceOfferedTooltip;
	}
	public WebElement getBioField() {
		return bioField;
	}
	public WebElement getShortdescription() {
		return shortdescription;
	}
	public WebElement getThursdayCheckBox() {
		return thursdayCheckBox;
	}
	public WebElement getSundayPastebutton() {
		return sundayPastebutton;
	}
	public WebElement getSaturdayPastebutton() {
		return saturdayPastebutton;
	}
	public WebElement getFridayPastebutton() {
		return fridayPastebutton;
	}
	public WebElement getThursdayPastebutton() {
		return thursdayPastebutton;
	}
	public WebElement getWednesdayPastebutton() {
		return wednesdayPastebutton;
	}
	public WebElement getTuesdayPastebutton() {
		return tuesdayPastebutton;
	}
	public WebElement getCopybutton() {
		return copybutton;
	}
	public WebElement getWednesdayCheckBox() {
		return wednesdayCheckBox;
	}
	public WebElement getTuesdayCheckBox() {
		return tuesdayCheckBox;
	}
	public WebElement getMondayCheckbox() {
		return mondayCheckbox;
	}
	public WebElement getMondaycloseTime() {
		return mondaycloseTime;
	}
	public WebElement getMondayLunchEndTime() {
		return mondayLunchEndTime;
	}
	public WebElement getMondaylunchTime() {
		return mondaylunchTime;
	}
	public WebElement getBusinessMondayclose() {
		return businessMondayclose;
	}
	public WebElement getBusinessMondaylunchEnd() {
		return businessMondaylunchEnd;
	}
	public WebElement getBusinessMondaylunch() {
		return businessMondaylunch;
	}
	public WebElement getSaturdayOpenTime() {
		return saturdayOpenTime;
	}
	public WebElement getBusinessSaturday() {
		return businessSaturday;
	}
	public WebElement getFirdayOpenTime() {
		return firdayOpenTime;
	}
	public WebElement getBusinessFriday() {
		return businessFriday;
	}
	public WebElement getThursdayOpentime() {
		return thursdayOpentime;
	}
	public WebElement getBusinessThursday() {
		return businessThursday;
	}
	public WebElement getWednesdayOpenTime() {
		return wednesdayOpenTime;
	}
	public WebElement getBusinessWednesday() {
		return businessWednesday;
	}
	public WebElement getTuesdayopentime() {
		return tuesdayopentime;
	}
	public WebElement getBusinessTuesday() {
		return businessTuesday;
	}
	public WebElement getMondayOpenTime() {
		return mondayOpenTime;
	}
	public WebElement getBusinessMondaytime() {
		return businessMondaytime;
	}
	public WebElement getBusinessTooltip() {
		return businessTooltip;
	}
	public WebElement getBillingaddExt() {
		return billingaddExt;
	}
	public WebElement getBillingPhoneErmsg() {
		return billingPhoneErmsg;
	}
	public WebElement getBillindaddPhone() {
		return billindaddPhone;
	}
	public WebElement getBillingEmailErrormsg() {
		return billingEmailErrormsg;
	}
	public WebElement getBillingEmailErmsg() {
		return billingEmailErmsg;
	}
	public WebElement getBillingEmail() {
		return billingEmail;
	}
	public WebElement getBillingZipcodeErmsg() {
		return billingZipcodeErmsg;
	}
	public WebElement getBillingAZstate() {
		return billingAZstate;
	}
	public WebElement getBillingCAstate() {
		return billingCAstate;
	}
	
	public WebElement getBillingStreetErmsg() {
		return billingStreetErmsg;
	}
	public WebElement getNameErmag() {
		return nameErmag;
	}
	public WebElement getBillingaddZipcode() {
		return billingaddZipcode;
	}
	public WebElement getBillingaddState() {
		return billingaddState;
	}
	public WebElement getBillingCityErmsg() {
		return billingCityErmsg;
	}
	public WebElement getBillingCity() {
		return billingCity;
	}
	public WebElement getBillingSuite() {
		return billingSuite;
	}
	public WebElement getBillingaddStreet() {
		return billingaddStreet;
	}
	
	public WebElement getBillingaddName() {
		return billingaddName;
	}
	public WebElement getCopyButton() {
		return copyButton;
	}
	public WebElement getPhoneExt() {
		return phoneExt;
	}
	public WebElement getServicephoneErmsg() {
		return servicephoneErmsg;
	}
	public WebElement getServicePhone() {
		return servicePhone;
	}
	public WebElement getEmailErmsg() {
		return emailErmsg;
	}
	public WebElement getInvalidErmsg() {
		return invalidErmsg;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getZipcodeErmsg() {
		return zipcodeErmsg;
	}
	public WebElement getZipCode() {
		return zipCode;
	}
	public WebElement getStateoptionCA() {
		return stateoptionCA;
	}
	/*public WebElement getStateErmsg() {
		return stateErmsg;
	}*/
	public WebElement getStateOptionAZ() {
		return stateOptionAZ;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getServiceCityErmsg() {
		return serviceCityErmsg;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getSuite() {
		return suite;
	}
	public WebElement getRoad() {
		return road;
	}
	
	public WebElement getServiceAddressErmsg() {
		return serviceAddressErmsg;
	}
	public WebElement getServiceAddress() {
		return serviceAddress;
	}
	public WebElement getServiceNameErmsg() {
		return serviceNameErmsg;
	}
	public WebElement getServiceName() {
		return serviceName;
	}
	public WebElement getTooltip() {
		return tooltip;
	}
	public WebElement getCageCode() {
		return cageCode;
	}
	public WebElement getNaicsCode() {
		return naicsCode;
	}
	public WebElement getSicCode() {
		return sicCode;
	}
	public WebElement getSosCode() {
		return sosCode;
	}
	public WebElement getEntityId() {
		return entityId;
	}
	public WebElement getEinNumber() {
		return einNumber;
	}
	public WebElement getDotNumber() {
		return dotNumber;
	}
	public WebElement getEpaIDNumber() {
		return epaIDNumber;
	}
	public WebElement getRegistrationNumber2() {
		return registrationNumber2;
	}
	public WebElement getRegistrationNumber1Ermsg() {
		return registrationNumber1Ermsg;
	}
	public WebElement getRegistrationNumber1() {
		return registrationNumber1;
	}
	public WebElement getProfilenotsetuppopup() {
		return profilenotsetuppopup;
	}
	public WebElement getUploadfile() {
		return uploadfile;
	}
	public WebElement getDatePicker() {
		return datePicker;
	}
	public WebElement getGoogleReviewLink() {
		return googleReviewLink;
	}
	public WebElement getStartfacialyear() {
		return Startfacialyear;
	}
	public WebElement getRedirectUrl() {
		return RedirectUrl;
	}
	public WebElement getWebsiteUrl() {
		return websiteUrl;
	}
	public WebElement getGeneralEmail() {
		return generalEmail;
	}
	public WebElement getPhonenumber() {
		return phonenumber;
	}
	public WebElement getCcompanydisplayname() {
		return ccompanydisplayname;
	}
	public WebElement getClickOnOtherside() {
		return ClickOnOtherside;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCompanynametxtfield() {
		return companynametxtfield;
	}
	
	public void CompanyNameTextField()
	{
		companynametxtfield.click();
	}
	public void SubmitBtn()
	{
		webDriverutility wlib = new webDriverutility();
		wlib.scrollToelement(driver, Submitbtn);
		Submitbtn.click();
	}
	public void GeneralPhoneNumberWithInput(String Input)
	{
		phonenumber.sendKeys(Input);
	}
	public void GeneralPhoneWithAlphbets(String Input)
	{
		phonenumber.sendKeys(Input);
	}
	public void GeneralPhoneWithNumbers(String Input)
	{
		phonenumber.sendKeys(Input);
	}
	public void GeneralPhoneWithSpecialCharacter(String Input)
	{
		phonenumber.sendKeys(Input);
	}
	public void GeneralEmailwithInput(String Input)
	{
		generalEmail.sendKeys(Input);
	}
	public void GeneralEmailwithAlphabets(String Input)
	{
		generalEmail.sendKeys(Input);
	}
	public void GeneralEmailwithNumbers(String Input)
	{
		generalEmail.sendKeys(Input);
	}
	public void WebSiteURLwithValiInput(String Input)
	{
		websiteUrl.sendKeys(Input);
	}

	public void WebSiteURLwithAlphabet(String Input)
	{
		websiteUrl.sendKeys(Input);
	}

	public void WebSiteURLwithNumber(String Input)
	{
		websiteUrl.sendKeys(Input);
	}

	public void WebSiteURLwithSpecialChar(String Input)
	{
		websiteUrl.sendKeys(Input);
	}
	public void GoogleReviewLink(String linkInput)
	{
		googleReviewLink.sendKeys(linkInput);
	}
	public void ToolTip()
	{
		tooltip.click();
	}
	
	public void SelectAZstate()
	{
		act.moveToElement(stateOptionAZ).click().perform();
	
	}
	
	public void SelectCAstate()
	{
		act.moveToElement(stateoptionCA).click().perform();
	}
	
	public void BillingStreet() throws InterruptedException
	{
		billingaddStreet.click();
		billingaddStreet.sendKeys(Keys.CONTROL + "a");
		billingaddStreet.sendKeys(Keys.DELETE);
		billingaddStreet.sendKeys("1237 3");
		Thread.sleep(2000);
		act= new Actions(driver);
		act.moveToElement(road).click().perform();
	}
	
	public void SelectbillinAZstate()
	{
		Actions act1 = new Actions(driver);
		act1.moveToElement(billingAZstate).click().perform();

	}
	
	public void SelectbillingCAstate()
	{
		Actions act2 = new Actions(driver);
		act2.moveToElement(billingCAstate).click().perform();
	}
	
	public void BusinessToolTip()
	{
		businessTooltip.click();
	}
	
	public void MondayTime()
	{
		businessMondaytime.click();
		mondayOpenTime.click();
	}
	
	public void TuesdayTime()
	{
		businessTuesday.click();
		tuesdayopentime.click();
	}
	
	public void WednesdayTime()
	{
		businessWednesday.click();
		wednesdayOpenTime.click();
	}
	
	public void ThursdayTime()
	{
		businessThursday.click();
		thursdayOpentime.click();
	}
	
	public void FridayTime()
	{
		businessFriday.click();
		firdayOpenTime.click();
	}
	
	public void SaturdayTime()
	{
		businessSaturday.click();
		saturdayOpenTime.click();
	}
	
	public void SundayTime()
	{
		businessSunday.click();
		sundayOpenTime.click();
	}
	
	public void Mondaylunchtime()
	{
		businessMondaylunch.click();
		mondaylunchTime.click();
	}
	
	public void MondaylunchEnd()
	{
		businessMondaylunchEnd.click();
		mondayLunchEndTime.click();
	}
	
	public void MondaycloseTime()
	{
		businessMondayclose.click();
		mondaycloseTime.click();
	}
	
	public void MondayCheckBox()
	{
		mondayCheckbox.click();
	}
	
	public void CheckBox()
	{
		mondayCheckbox.click();
		mondayCheckbox.click();
	}
	
	public void MultipleCheckbox()
	{
		mondayCheckbox.click();
		tuesdayCheckBox.click();
		wednesdayCheckBox.click();
	}
	
	public void PasteButton()
	{
		copybutton.click();
		tuesdayPastebutton.click();
		wednesdayPastebutton.click();
		thursdayPastebutton.click();
		fridayPastebutton.click();
		saturdayPastebutton.click();
		sundayPastebutton.click();
	}
	
	public void PasteForParticularday()
	{
		copybutton.click();
		tuesdayCheckBox.click();
		wednesdayCheckBox.click();
		tuesdayPastebutton.click();
		wednesdayPastebutton.click();
	}
	
	public void PastewithCloseddays()
	{
		copybutton.click();
		thursdayPastebutton.click();
		thursdayCheckBox.click();
	}
	
	public void ServiceofferedTooltip()
	{
		serviceOfferedTooltip.click();
		WebElement popup = driver.findElement(By.xpath("//b[contains (text(), 'Services Offered')]"));
	       Assert.assertTrue(popup.isDisplayed(), "Service Offered popup is  visible");
	}
	
	public void ServiceofferedCheckbox()
	{
		medicalwasteCheckbox.click();
		papersheddingCheckbox.click();
		electronicwasteCheckbox.click();
		disposalfacilityCheckbox.click();
		productCheckbox.click();
		universalwasteCheckbox.click();
	}
	
	public void ServiceofferedsubWaste()
	{
		biosharpCheckbox.click();
		aphisCheckbox.click();
		onsiteCheckbox.click();
		offsiteCheckbox.click();
		transferCheckbox.click();
		treatmentCheckbox.click();
	}
	
	public void ServiceofferedDisable()
	{
		recyclingCheckbox.click();
		solidCheckBox.click();
		portableCheckbox.click();
	}
	
	public void ServiceCancelation()
	{
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void BioSharpCancelation()
	{
		biosharpCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void AphisCancelation()
	{
		aphisCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void OnsiteCancelation()
	{
		onsiteCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void OffsiteCancelation()
	{
		offsiteCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void TransferCancelation()
	{
		transferCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void TreatmentCancelation()
	{
		treatmentCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void waitForOverlayToDisappear() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.xpath("//div[contains(@class,'fixed inset-0')]")
	    ));
	}
	
	public void MedicalwasteCancelation()
	{
		medicalwasteCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void PapersheddingCancelation()
	{
		papersheddingCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void ElectronicwasteCancelation()
	{
		electronicwasteCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void DisposalfacilityCancelation()
	{
		disposalfacilityCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void ProductdestructionCancelation()
	{
		productCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void UniversalwasteCancelation()
	{
		universalwasteCheckbox.click();
		confirmationBox.isDisplayed();
		confirmButton.click();
	}
	
	public void OptInButton()
	{
		optInButton.click();
	}
	
	public void CategoryEwaste()
	{
		categoriesDropdown.click();
		categoryEwaste.click();
		onlineCategory.click();
		consultingService.click();
	}
	
	public void CategorySelection()
	{
		categoriesDropdown.click();
		containerMedicalwaste.click();
		consultingService.click();
		onlineCategory.click();
		categoryEwaste.click();
	}
	
	public void ServiceareastateAk()
	{
		Actions act3 = new Actions(driver);
		act3.moveToElement(serviceStateAK).click().perform();
	}
	
	public void ServiceareaatateAZ()
	{
		Actions act4 = new Actions(driver);
		act4.moveToElement(serviceStateAZ).click().perform();
	}
	
	public void ServiceAreaWithInput() throws EncryptedDocumentException, IOException
	{
		ServiceareaMiles.click();
		ServiceareaMiles.sendKeys(Keys.CONTROL + "a");
		ServiceareaMiles.sendKeys(Keys.DELETE);
		ExcelUtility elib = new ExcelUtility();
		String input = elib.getDataFromExcel("TransporterProfile", 64, 1);
		ServiceareaMiles.sendKeys(input);
		int data = elib.GetRowcount("TransporterProfile");
		System.out.println(data);
	}
	
	public void ServiceAreacityInput() throws EncryptedDocumentException, IOException
	{
		serviceareaCity.click();
		serviceareaCity.sendKeys(Keys.CONTROL + "a");
		serviceareaCity.sendKeys(Keys.DELETE);
		ExcelUtility elib = new ExcelUtility();
		String input = elib.getDataFromExcel("TransporterProfile", 61, 1);
		serviceareaCity.sendKeys(input);
		utilityclassobject.gettest().log(Status.INFO, "Service area city textfield accepted Input");
	}
	
	public void CategoryDropdown()
	{
		categoriesDropdown.click();
	}
	
	public void ServicedeleteButton()
	{
		deleteButton.click();
	}
	
	public void Streets() throws InterruptedException
	{
		street1.click();
		street1.sendKeys(Keys.CONTROL + "a");
		street1.sendKeys(Keys.DELETE);
		street1.sendKeys("1237 3");
		Thread.sleep(2000);
		act= new Actions(driver);
		act.moveToElement(road).click().perform();
	}
	
	public void UncheckMainservice()
	{
		MedicalwasteCancelation();
		waitForOverlayToDisappear();
		PapersheddingCancelation();
		waitForOverlayToDisappear();
		ElectronicwasteCancelation();
		waitForOverlayToDisappear();
		DisposalfacilityCancelation();
		waitForOverlayToDisappear();
		ProductdestructionCancelation();
		waitForOverlayToDisappear();
		UniversalwasteCancelation();
		waitForOverlayToDisappear();
	}
	
	public void StateTransistDropdown()
	{
		stateTransistStatedrp.click();
		Actions act5 = new Actions(driver);
		act5.moveToElement(stateOptionAZ).click().perform();
	}
	
	public void StatetransistDropdwons()
	{
		stateTransistStatedrp.click();
		Actions act6 = new Actions(driver);
		act6.moveToElement(stateoptionCA).click().perform();
	}
}
