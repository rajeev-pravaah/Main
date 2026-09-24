package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DisposalFacilities {

	WebDriver driver;

	public DisposalFacilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	public WebDriver getDriver() {
		return driver;
	}
	
	
	@FindBy(xpath = "//h6[text()='Assets']")
	private WebElement assetsDD;
	@FindBy(xpath = "//h6[text()='Disposal Facilities']")
	private WebElement disposalFacilities;
	@FindBy(xpath = "//h2[text()='Disposal Facilities List']")
	private WebElement disposalFacilitiesList;
	@FindBy(xpath = "(//div[@class='relative inline-block'])[2]")
	private WebElement octoinfologo;
	@FindBy(xpath = "//h2[text()='OCTO Info: Disposal Facility']")
	private WebElement octoinfoDisposalFacilityfromtooltip;
	@FindBy(xpath = "//button[@aria-label='Close tooltip']")
	private WebElement closeTooltip;
	@FindBy(xpath = "//span[text()='Add New Disposal Facility']")
	private WebElement addNewDisposalFacilitybtn;
	@FindBy(xpath = "//input[@placeholder='Enter the name']")
	private WebElement namefieldFromAddewDisposalFacilitypopup;
	@FindBy(xpath = "//p[text()='Disposal Facility Name is required']")
	private WebElement namefielderrormsg;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitbtnFromAddNewDisposalFacilitypopup;
	@FindBy(xpath = "//h6[text()='Add New Disposal Facility']")
	private WebElement addNewDisposalFacilitypopup;
	@FindBy(xpath = "//input[@placeholder='Enter the email']")
	private WebElement emailfieldFromAddNewDisposalFacilitypopup;
	@FindBy(xpath = "//p[text()='Please enter a valid email address']")
	private WebElement emailfielderrormsg;
	@FindBy(xpath = "//div[text()='Disposal Facility Profile ']")
	private WebElement disposalFacilityProfile;
	@FindBy(id= "notification-type")
	private WebElement notificationTypedropdown;
	@FindBy(xpath = "//a[text()='Disposal Facility List']")
	private WebElement disposalFacilityListlink;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> notificationTypeoptions;
	@FindBy(id = "notification-type")
	private WebElement notificationTypefieldfromDisposalFacilityPage;
	@FindBy(xpath = "//a[text()='Disposal Facility Detail']")
	private WebElement disposalFacilityDetailLink;
	@FindBy(xpath = "//button[@aria-label='Information']")
	private WebElement octoinfotooltip;
	@FindBy(xpath = "//h2[text()='OCTO Info: Disposal Facility']")
	private WebElement octoinfotooltipheader;
	@FindBy(xpath = "//canvas[@class='maplibregl-canvas atlas-map-canvas']")
	private WebElement map;
	@FindBy(xpath = "//div[@class='truncate w-80']")
	private List<WebElement> disposalFacilityNamelists;
	@FindBy(xpath = "(//button[.//*[local-name()='svg']])[19]")
	private WebElement mapzoominbutton;
	@FindBy(xpath = "(//button[.//*[local-name()='svg']])[20]")
	private WebElement mapzoomoutbutton;
	@FindBy(xpath = "//input[@placeholder='Enter the Name']")
	private WebElement namefield;
	@FindBy(xpath = "//label[text()='Name*']")
	private WebElement nametext;
	@FindBy(xpath = "//*[contains(text(),'Autosaved') or contains(text(),'autosaved')]")
	private WebElement autoSaveMessage;
	@FindBy(xpath = "//input[@placeholder='Enter the Street']")
	private WebElement streetfield;
	@FindBy(xpath = "//p[text()='Street is required']")
	private WebElement streetfielderrormsg;
	@FindBy(xpath = "//div[@class='px-4 py-2 cursor-pointer text-sm hover:bg-gray-100']")
	private WebElement streetfieldsuggestionoptions;
	@FindBy(xpath = "//div[@class='px-4 py-2 cursor-pointer text-sm hover:bg-gray-100']")
	private List<WebElement> streetfieldsuggestionoptionslist;
	@FindBy(xpath = "//input[@placeholder='Enter the City']")
	private WebElement cityfield;
	@FindBy(id="state")
	private WebElement statefield;
	@FindBy(xpath = "//input[@placeholder='Enter the Zip']")
	private WebElement zipfield;
	@FindBy(xpath = "//input[@placeholder='Enter the Suite']")
	private WebElement suitefield;
	@FindBy(xpath = "//p[text()='City is required']")
	private WebElement cityfielderrormsg;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> statefieldoptions;
	@FindBy(xpath = "//p[text()='Zip must be numeric']")
	private WebElement zipfielderrormsg;
	@FindBy(xpath = "//p[text()='Zip is required']")
	private WebElement zipfieldreqerrormsg1;
	@FindBy(xpath = "//div[contains(@class,'marker-collection-container')]//*[name()='svg']")
	private WebElement mapmarker;
	@FindBy(xpath = "//label[text()='Zip*']")
	private WebElement zipfieldtext;
	@FindBy(xpath = "//canvas[@class='maplibregl-canvas atlas-map-canvas']")
	private WebElement mapfromDisposalfacilty;
	@FindBy(id= "phone")
	private WebElement phonefield;
	@FindBy(xpath = "//p[text()='Phone is required']")
	private WebElement phonefielderrormsg;
	@FindBy(id = "phone-ext")
	private WebElement phoneextfield;
	@FindBy(css = "[id*='disposal-facility']")
	private WebElement disposalFacilityStatusdropdown;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> disposalFacilityStatusoptions;
	@FindBy(xpath = "//div[text()='Inactive']")
	private WebElement disposalFacilityStatusInactive;
	@FindBy(xpath = "//input[@placeholder='Enter the Email']")
    private WebElement email1field;
	@FindBy(xpath = "//label[text()='Email 1*']")
	private WebElement email1text;
	@FindBy(xpath = "//p[text()='Email 1 is required']")
	private WebElement email1fielderrormsg;
	@FindBy(xpath = "//label[text()='Email 2']")
	private WebElement email2text;
	@FindBy(xpath = "//div[text()='Autosaved treatment details']")
	private WebElement treatmentAutoSaveMessage;
	@FindBy(xpath = "//label[text()='Email 2']/../descendant::input")
	private WebElement email2field;
	@FindBy(xpath = "//label[text()='Email 3']/../descendant::input")
	private WebElement email3field;
	@FindBy(xpath = "//p[text()='Notification Type* ']")
	private WebElement notificationTypefieldtext;
	@FindBy(xpath = "//p[text()='Notification Type* ']/../../descendant::button")
	private WebElement notificationTypedropdownfield;
	@FindBy(xpath = "//div[@class='flex items-center gap-2']")
	private List<WebElement>  notifiactiontypeslists;
	@FindBy(xpath = "//label[text()='State Registration Number 1*']/../descendant::input")
	private WebElement stateRegistrationNumber1field;
	@FindBy(xpath = "//p[text()='State Registration Number 1 is required']")
	private WebElement stateRegistrationNumber1fielderrormsg;
	@FindBy(xpath = "//label[text()='State Registration Number 2']/../descendant::input")
	private WebElement stateRegistrationNumber2field;
	@FindBy(xpath = "//label[text()='State Registration Number 3']/../descendant::input")
	private WebElement stateRegistrationNumber3field;
	@FindBy(xpath = "//div[@class='w-[33%] pl-2 text-sm text-gray-800 font-medium']")
	private List<WebElement> wasteprocessingfeelists;
	@FindBy(xpath = "//label[text()='Email 2']")
	private WebElement email2fieldtext;
	@FindBy(xpath = "//label[text()='Email 3']")
	private WebElement email3fieldtext;
	@FindBy(xpath = "//div[@class='w-[33%] pl-2 text-sm text-gray-800 font-medium']/../descendant::div[@class='w-[15%]']")
	private List<WebElement> wasteprocessingeachunits;
	@FindBy(id = "wasteProcessingFees.Bio/Sharps.active")
	private WebElement wasteProcessingFeesBioSharpsactivecheckbox;
	
	@FindBy(xpath = "//span[text()='Treatment']")
	private WebElement treatmenttab;
	@FindBy(xpath = "//div[@class='flex items-center rounded-full bg-gray-100  w-full p-2']")
	private WebElement biosharpcostfield;
	
	
	
	
	
	
	
	
	
	
	public WebElement getBiosharpcostfield() {
		return biosharpcostfield;
	}
	public WebElement getTreatmenttab() {
		return treatmenttab;
	}
	public WebElement getWasteProcessingFeesBioSharpsactivecheckbox() {
		return wasteProcessingFeesBioSharpsactivecheckbox;
	}
	public WebElement getWasteprocessingeachunits() {
		return wasteprocessingeachunits.get(0);
	}
	public WebElement getEmail3fieldtext() {
		return email3fieldtext;
	}
	public WebElement getEmail2fieldtext() {
		return email2fieldtext;
	}
	public List<WebElement> getWasteprocessingfeelists() {
		return wasteprocessingfeelists;
	}
	public WebElement getStateRegistrationNumber3field() {
		return stateRegistrationNumber3field;
	}
	public WebElement getStateRegistrationNumber2field() {
		return stateRegistrationNumber2field;
	}
	
	public WebElement getStateRegistrationNumber1fielderrormsg() {
		return stateRegistrationNumber1fielderrormsg;
	}
	public WebElement getStateRegistrationNumber1field() {
		return stateRegistrationNumber1field;
	}
	public List<WebElement> getNotifiactiontypeslists() {
		return notifiactiontypeslists;
	}
	public WebElement getNotificationTypedropdownfield() {
		return notificationTypedropdownfield;
	}
	public WebElement getNotificationTypefieldtext() {
		return notificationTypefieldtext;
	}
	public WebElement getEmail3field() {
		return email3field;
	}
	public WebElement getEmail2field() {
		return email2field;
	}
	public WebElement getTreatmentAutoSaveMessage() {
		return treatmentAutoSaveMessage;
	}
	public WebElement getEmail2text() {
		return email2text;
	}
	public WebElement getEmail1fielderrormsg() {
		return email1fielderrormsg;
	}
	public WebElement getEmail1text() {
		return email1text;
	}
	public WebElement getEmail1field() {
		return email1field;
	}
	public WebElement getDisposalFacilityStatusInactive() {
		return disposalFacilityStatusInactive;
	}
	public List<WebElement> getDisposalFacilityStatusoptions() {
		return disposalFacilityStatusoptions;
	}
	public WebElement getDisposalFacilityStatusdropdown() {
		return disposalFacilityStatusdropdown;
	}
	public WebElement getPhoneextfield() {
		return phoneextfield;
	}
	public WebElement getPhonefielderrormsg() {
		return phonefielderrormsg;
	}
	public WebElement getPhonefield() {
		return phonefield;
	}
	public WebElement getMapfromDisposalfacilty() {
		return mapfromDisposalfacilty;
	}
	public WebElement getZipfieldtext() {
		return zipfieldtext;
	}
	public WebElement getMapmarker() {
		return mapmarker;
	}
	public WebElement getZipfieldreqerrormsg1() {
		return zipfieldreqerrormsg1;
	}
	public WebElement getZipfielderrormsg() {
		return zipfielderrormsg;
	}
	public List<WebElement> getStatefieldoptions() {
		return statefieldoptions;
	}
	public WebElement getCityfielderrormsg() {
		return cityfielderrormsg;
	}
	public WebElement getSuitefield() {
		return suitefield;
	}
	public WebElement getZipfield() {
		return zipfield;
	}
	public WebElement getStatefield() {
		return statefield;
	}
	public WebElement getCityfield() {
		return cityfield;
	}
	public List<WebElement> getStreetfieldsuggestionoptionslist() {
		return streetfieldsuggestionoptionslist;
	}
	public WebElement getStreetfieldsuggestionoptions() {
		return streetfieldsuggestionoptions;
	}
	public WebElement getStreetfielderrormsg() {
		return streetfielderrormsg;
	}
	public WebElement getStreetfield() {
		return streetfield;
	}
	public WebElement getAutoSaveMessage() {
		return autoSaveMessage;
	}
	public WebElement getNametext() {
		return nametext;
	}
	public WebElement getNamefield() {
		return namefield;
	}
	public WebElement getMapzoomoutbutton() {
		return mapzoomoutbutton;
	}
	public WebElement getMapzoominbutton() {
		return mapzoominbutton;
	}
	public List<WebElement> getDisposalFacilityNamelists() {
		return disposalFacilityNamelists;
	}
	public WebElement getMap() {
		return map;
	}
	public WebElement getOctoinfotooltipheader() {
		return octoinfotooltipheader;
	}
	public WebElement getOctoinfotooltip() {
		return octoinfotooltip;
	}
	public WebElement getDisposalFacilityDetailLink() {
		return disposalFacilityDetailLink;
	}
	public WebElement getNotificationTypefieldfromDisposalFacilityPage() {
		return notificationTypefieldfromDisposalFacilityPage;
	}
	public List<WebElement> getNotificationTypeoptions() {
		return notificationTypeoptions;
	}
	public WebElement getDisposalFacilityListlink() {
		return disposalFacilityListlink;
	}
	public WebElement getNotificationTypedropdown() {
		return notificationTypedropdown;
	}
	public WebElement getDisposalFacilityProfile() {
		return disposalFacilityProfile;
	}
	public WebElement getEmailfielderrormsg() {
		return emailfielderrormsg;
	}
	public WebElement getEmailfieldFromAddNewDisposalFacilitypopup() {
		return emailfieldFromAddNewDisposalFacilitypopup;
	}
	public WebElement getAddNewDisposalFacilitypopup() {
		return addNewDisposalFacilitypopup;
	}
	public WebElement getSubmitbtnFromAddNewDisposalFacilitypopup() {
		return submitbtnFromAddNewDisposalFacilitypopup;
	}
	public WebElement getNamefielderrormsg() {
		return namefielderrormsg;
	}
	public WebElement getNamefieldFromAddewDisposalFacilitypopup() {
		return namefieldFromAddewDisposalFacilitypopup;
	}
	public WebElement getAddNewDisposalFacilitybtn() {
		return addNewDisposalFacilitybtn;
	}
	public WebElement getCloseTooltip() {
		return closeTooltip;
	}
	public WebElement getOctoinfoDisposalFacilityfromtooltip() {
		return octoinfoDisposalFacilityfromtooltip;
	}
	public WebElement getOctoinfologo() {
		return octoinfologo;
	}
	public WebElement getDisposalFacilitiesList() {
		return disposalFacilitiesList;
	}
	public WebElement getDisposalFacilities() {
		return disposalFacilities;
	}
	public WebElement getAssetsDD() {
		return assetsDD;
	}
	
	
	
	public void ClearTextField(WebElement field)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';",field);
		field.sendKeys(Keys.CONTROL + "a");
		field.sendKeys(Keys.DELETE);
		
	}

	// ------------------ Treatment tab helpers ------------------

	/**
	 * Returns true if the Treatment tab appears disabled/inactive.
	 * Checks common indicators: aria-disabled, CSS class hints and WebElement.isEnabled()
	 */
	public boolean isTreatmentTabDisabled() {
		try {
			String aria = treatmenttab.getAttribute("aria-disabled");
			if (aria != null) {
				return aria.equalsIgnoreCase("true");
			}
			String cls = treatmenttab.getAttribute("class");
			if (cls != null) {
				if (cls.contains("disabled") || cls.contains("opacity-50") || cls.contains("cursor-not-allowed"))
					return true;
			}
			// fallback to Selenium enabled state
			try {
				return !treatmenttab.isEnabled();
			} catch (Exception e) {
				return true;
			}
		} catch (Exception e) {
			// if element not found or other issue, treat as disabled to make checks conservative
			return true;
		}
	}

	public boolean isTreatmentTabEnabled() {
		return !isTreatmentTabDisabled();
	}

	/** Clicks the Waste Processing Fees Bio/Sharps active checkbox. Uses JS click as a fallback. */
	public void clickWasteProcessingFeesBioSharpsactivecheckbox() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wasteProcessingFeesBioSharpsactivecheckbox);
		} catch (Exception e) {
			wasteProcessingFeesBioSharpsactivecheckbox.click();
		}
	}

	/** Waits until the Treatment tab becomes enabled (or timeout). Returns true if enabled within timeout. */
	public boolean waitForTreatmentTabToBeEnabled(long timeoutSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
			return wait.until(d -> {
				try {
					String aria = treatmenttab.getAttribute("aria-disabled");
					if (aria != null)
						return aria.equalsIgnoreCase("false");
					String cls = treatmenttab.getAttribute("class");
					if (cls != null)
						return !(cls.contains("disabled") || cls.contains("opacity-50") || cls.contains("cursor-not-allowed"));
					return treatmenttab.isEnabled();
				} catch (Exception ex) {
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}
	
}
