package com.Octopussaas.ObjectRepository;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
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

import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
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
	public WebElement keeptheAssigendButton;
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
	@FindBy (xpath = "//button[@id='generator-status']")
	private WebElement generatorStatus;
	@FindBy (xpath = "(//div[@class='relative inline-block']//button)[2]")
	private WebElement tooltip;
	@FindBy (xpath = "//button[@aria-label='Close tooltip']")
	private WebElement closetooltip;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Prospect')]")
	private WebElement prospectStatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Dead File')]")
	private WebElement deadfielStatus;
	@FindBy (xpath = "//li[@role='option']//div[contains (text(),'Administrative Account')]")
	private WebElement administrativeStatus;
	@FindBy (xpath = "//textarea[@name='cancellationNote']")
	private WebElement statusNote;
	@FindBy (xpath = "//button[contains (text(),'Update The Status')]")
	private WebElement updateStatus;
	@FindBy (xpath = "//button[contains (text(),'Keep Current Status')]")
	private WebElement keepCureentstatus;
	@FindBy (xpath = "(//button[contains (text(),'✕')])[4]")
	private WebElement statusCancelbutton;
	@FindBy (xpath = "//input[@id='industry-type']")
	private WebElement industryType;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'Urgent Care Clinics')]")
	private WebElement uregentCareType;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'Skilled Nursing')]")
	private WebElement skillednursingType;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'Non-Medical Professional')]")
	private WebElement nonmedicalType;
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer') and contains(@class,'border-2')]")
	private WebElement checkBox;
	@FindBy (xpath = "//input[@id='serviceAddress-email']")
	private WebElement serviceEmail;
	@FindBy (xpath = "//input[@id='serviceAddress-phone']")
	private WebElement servicePhone;
	@FindBy (xpath = "//h6[text()='Generator Service Information']/following-sibling::button[@type='button']")
	private WebElement copyButton;
	@FindBy (xpath = "//input[@id='billingAddress-street']")
	private WebElement billingaddressStreet;
	@FindBy (xpath = "//input[@id='billingAddress-email']")
	private WebElement billingaddressEmail;
	@FindBy (xpath = "//input[@id='billingAddress-phone']")
	private WebElement billinaddressPhone;
	@FindBy (xpath = "//input[@id='serviceAddress-attention']")
	private WebElement serviceAttention;
	@FindBy(xpath = "//span[contains(text(),'Contracted')]")
	private WebElement contracedsc;
	@FindBy (xpath = "//input[@id='serviceAddress-city']")
	private WebElement serviceCity;
	@FindBy (xpath = "//input[@id='serviceAddress-state']")
	private WebElement serviceState;
	@FindBy (xpath = "//input[@id='serviceAddress-zipCode']")
	private WebElement serviceZipode;
	@FindBy (xpath = "//input[@id='serviceAddress-suite']")
	private WebElement serviceSuite;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'AZ')]")
	private WebElement aZstate;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'FL')]")
	private WebElement fLstate;
	@FindBy (xpath = "//li[@role='option']//span[contains (text(),'WV')]")
	private WebElement wVState;
	@FindBy (xpath = "//p[contains (text(),'Invalid email format')]")
	private WebElement emailinvalidErmsg;
	@FindBy (xpath = "//p[contains (text(),'Phone number must be 10 digits')]")
	private WebElement phoneErmsg;
	@FindBy (xpath = "//input[@id='serviceAddress-phone-ext']")
	private WebElement ext;
	@FindBy (xpath = "//input[@id='billingAddress-attention']")
	private WebElement billingattention;
	@FindBy (xpath = "//input[@id='billingAddress-city']")
	private WebElement billingcity;
	@FindBy (xpath = "//input[@id='billingAddress-state']")
	private WebElement billingstate; 
	@FindBy (xpath = "//input[@id='billingAddress-zipCode']")
	private WebElement billingzipcode;
	@FindBy (xpath = "//input[@id='billingAddress-suite']")
	private WebElement billingsuite;
	@FindBy (xpath = "//input[@id='billingAddress-email']")
	private WebElement billingEmail;
	@FindBy (xpath = "//p[contains (text(),'Invalid email format')]")
	private WebElement billingEmailinvalidmsg;
	@FindBy (xpath = "//input[@id='billingAddress-phone']")
	private WebElement billingPhone;
	@FindBy (xpath = "//p[contains (text(),'Phone number must be 10 digits')]")
	private WebElement billingPhoneErmsg;
	@FindBy (xpath = "//input[@id='billingAddress-phone-ext']")
	private WebElement billingExt;
	@FindBy (xpath = "//input[@placeholder='Monday Opening Time']")
	private WebElement mondayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Monday Lunch Start Time']")
	private WebElement mondaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Monday Lunch End Time']")
	private WebElement mondaylunchend;	
	@FindBy (xpath = "//input[@placeholder='Monday Closing Time']")
	private WebElement mondayclosetime;
	@FindBy (xpath = "//input[@placeholder='Tuesday Opening Time']")
	private WebElement tuesdayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Tuesday Lunch Start Time']")
	private WebElement tuesdaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Tuesday Lunch End Time']")
	private WebElement tuesdaylunchend;
	@FindBy (xpath = "//input[@placeholder='Tuesday Closing Time']")
	private WebElement tuesdaylunchclosetime;
	@FindBy (xpath = "//input[@placeholder='Wednesday Opening Time']")
	private WebElement wednesdayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Wednesday Lunch Start Time']")
	private WebElement wendesdaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Wednesday Lunch End Time']")
	private WebElement wendesdaylunchend;
	@FindBy (xpath = "//input[@placeholder='Wednesday Closing Time']")
	private WebElement wednesdayclosingtime;
	@FindBy (xpath = "//input[@placeholder='Thursday Opening Time']")
	private WebElement thursdayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Thursday Lunch Start Time']")
	private WebElement thursdaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Thursday Lunch End Time']")
	private WebElement thursdaylunchend;
	@FindBy (xpath = "//input[@placeholder='Thursday Closing Time']")
	private WebElement thursdayclosingtime;
	@FindBy (xpath = "//input[@placeholder='Friday Opening Time']")
	private WebElement fridayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Friday Lunch Start Time']")
	private WebElement fridaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Friday Lunch End Time']")
	private WebElement fridaylunchend;
	@FindBy (xpath = "//input[@placeholder='Friday Closing Time']")
	private WebElement fridayclosingtime;
	@FindBy (xpath = "//input[@placeholder='Saturday Opening Time']")
	private WebElement saturdayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Saturday Lunch Start Time']")
	private WebElement saturdaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Saturday Lunch End Time']")
	private WebElement saturdaylunchend;
	@FindBy (xpath = "//input[@placeholder='Saturday Closing Time']")
	private WebElement saturdayclosingtime;
	@FindBy (xpath = "//input[@placeholder='Sunday Opening Time']")
	private WebElement sundayopeningtime;
	@FindBy (xpath = "//input[@placeholder='Sunday Lunch Start Time']")
	private WebElement sundaylunchstart;
	@FindBy (xpath = "//input[@placeholder='Sunday Lunch End Time']")
	private WebElement sundaylunchend;
	@FindBy (xpath = "//input[@placeholder='Sunday Closing Time']")
	private WebElement sundayclosingtime;
	@FindBy (xpath = "//ul[@role='listbox']/descendant::span[text()='8:00 AM']")
	private WebElement morningtime;
	@FindBy (xpath = "//ul[@role='listbox']/descendant::span[text()='12:00 PM']")
	private WebElement lunchsarttiming;
	@FindBy (xpath = "//ul[@role='listbox']/descendant::span[text()='12:30 PM']")
	private WebElement lunchendtiming;
	@FindBy (xpath = "//ul[@role='listbox']/descendant::span[text()='6:00 PM']")
	private WebElement closetime;
	@FindBy (xpath = "//li[.//h6[text()='Thursday']]//div[@role='checkbox']")
	private WebElement thursdayCheckbox;
	@FindBy (xpath = "//li[.//h6[text()='Friday']]//div[@role='checkbox']")
	private WebElement fridayCheckbox;
	@FindBy (xpath = "//li[.//h6[text()='Saturday']]//div[@role='checkbox']")
	private WebElement saturdayCheckbox;
	@FindBy (xpath = "//li[.//h6[text()='Sunday']]//div[@role='checkbox']")
	private WebElement sundayCheckbox;
	@FindBy (xpath = "(//li[.//h6[text()='Monday']]//span[@class='w-1/4 flex items-center justify-center'])[1]")
	private WebElement mondaycopybutton;
	@FindBy (xpath = "(//li[.//h6[text()='Friday']]//span[@class='w-1/4 flex items-center justify-center'])[2]")
	private WebElement fridaypastebutton;
	@FindBy (xpath = "(//li[.//h6[text()='Saturday']]//span[@class='w-1/4 flex items-center justify-center'])[2]")
	private WebElement saturdaypastebutton;
	@FindBy (xpath = "(//li[.//h6[text()='Sunday']]//span[@class='w-1/4 flex items-center justify-center'])[2]")
	private WebElement sundaypastebutton;
	@FindBy (xpath ="(//li[.//h6[text()='Tuesday']]//span[@class='w-1/4 flex items-center justify-center'])[2]")
	private WebElement tuesdayPastebutton;
	@FindBy (xpath = "//li[.//h6[text()='Tuesday']]//div[@role='checkbox']")
	private WebElement tuesdaycheckbox;
	@FindBy (xpath = "//a[contains (text(),'Generator Billing')]")
	private WebElement generatorbilling;
	@FindBy (xpath = "//a[contains (text(),'Generator Information')]")
	private WebElement generatorInformation;
	
	
	
	public WebElement getGeneratorInformation() {
		return generatorInformation;
	}

	public WebElement getGeneratorbilling() {
		return generatorbilling;
	}

	public WebElement getTuesdaycheckbox() {
		return tuesdaycheckbox;
	}

	public WebElement getTuesdayPastebutton() {
		return tuesdayPastebutton;
	}

	public WebElement getSundaypastebutton() {
		return sundaypastebutton;
	}

	public WebElement getSaturdaypastebutton() {
		return saturdaypastebutton;
	}

	public WebElement getFridaypastebutton() {
		return fridaypastebutton;
	}

	public WebElement getMondaycopybutton() {
		return mondaycopybutton;
	}

	public WebElement getSundayCheckbox() {
		return sundayCheckbox;
	}

	public WebElement getSaturdayCheckbox() {
		return saturdayCheckbox;
	}

	public WebElement getFridayCheckbox() {
		return fridayCheckbox;
	}

	public WebElement getThursdayCheckbox() {
		return thursdayCheckbox;
	}

	public WebElement getClosetime() {
		return closetime;
	}

	public WebElement getLunchendtiming() {
		return lunchendtiming;
	}

	public WebElement getLunchsarttiming() {
		return lunchsarttiming;
	}

	public WebElement getMorningtime() {
		return morningtime;
	}

	public WebElement getSundayclosingtime() {
		return sundayclosingtime;
	}

	public WebElement getSundaylunchend() {
		return sundaylunchend;
	}

	public WebElement getSundaylunchstart() {
		return sundaylunchstart;
	}

	public WebElement getSundayopeningtime() {
		return sundayopeningtime;
	}

	public WebElement getSaturdayclosingtime() {
		return saturdayclosingtime;
	}

	public WebElement getSaturdaylunchend() {
		return saturdaylunchend;
	}

	public WebElement getSaturdaylunchstart() {
		return saturdaylunchstart;
	}

	public WebElement getSaturdayopeningtime() {
		return saturdayopeningtime;
	}

	public WebElement getFridayclosingtime() {
		return fridayclosingtime;
	}

	public WebElement getFridaylunchend() {
		return fridaylunchend;
	}

	public WebElement getFridaylunchstart() {
		return fridaylunchstart;
	}

	public WebElement getFridayopeningtime() {
		return fridayopeningtime;
	}

	public WebElement getThursdayclosingtime() {
		return thursdayclosingtime;
	}

	public WebElement getThursdaylunchend() {
		return thursdaylunchend;
	}

	public WebElement getThursdaylunchstart() {
		return thursdaylunchstart;
	}

	public WebElement getThursdayopeningtime() {
		return thursdayopeningtime;
	}

	public WebElement getWednesdayclosingtime() {
		return wednesdayclosingtime;
	}

	public WebElement getWendesdaylunchend() {
		return wendesdaylunchend;
	}

	public WebElement getWendesdaylunchstart() {
		return wendesdaylunchstart;
	}

	public WebElement getWednesdayopeningtime() {
		return wednesdayopeningtime;
	}

	public WebElement getTuesdaylunchclosetime() {
		return tuesdaylunchclosetime;
	}

	public WebElement getTuesdaylunchend() {
		return tuesdaylunchend;
	}

	public WebElement getTuesdaylunchstart() {
		return tuesdaylunchstart;
	}
	
	public WebElement getTuesdayopeningtime() {
		return tuesdayopeningtime;
	}


	public WebElement getMondayclosetime() {
		return mondayclosetime;
	}


	public WebElement getMondaylunchend() {
		return mondaylunchend;
	}


	public WebElement getMondaylunchstart() {
		return mondaylunchstart;
	}


	public WebElement getMondayopeningtime() {
		return mondayopeningtime;
	}


	public WebElement getBillingExt() {
		return billingExt;
	}


	public WebElement getBillingPhoneErmsg() {
		return billingPhoneErmsg;
	}

	public WebElement getBillingPhone() {
		return billingPhone;
	}

	public WebElement getBillingEmailinvalidmsg() {
		return billingEmailinvalidmsg;
	}

	public WebElement getBillingEmail() {
		return billingEmail;
	}

	public WebElement getBillingsuite() {
		return billingsuite;
	}

	public WebElement getBillingzipcode() {
		return billingzipcode;
	}

	public WebElement getBillingstate() {
		return billingstate;
	}

	public WebElement getBillingcity() {
		return billingcity;
	}

	public WebElement getBillingattention() {
		return billingattention;
	}

	public WebElement getExt() {
		return ext;
	}

	public WebElement getPhoneErmsg() {
		return phoneErmsg;
	}

	public WebElement getEmailinvalidErmsg() {
		return emailinvalidErmsg;
	}

	public WebElement getwVState() {
		return wVState;
	}

	public WebElement getfLstate() {
		return fLstate;
	}

	public WebElement getaZstate() {
		return aZstate;
	}

	public WebElement getServiceSuite() {
		return serviceSuite;
	}

	public WebElement getServiceZipode() {
		return serviceZipode;
	}

	public WebElement getServiceState() {
		return serviceState;
	}

	public WebElement getServiceCity() {
		return serviceCity;
	}

	public WebElement getServiceAttention() {
		return serviceAttention;
	}

	public WebElement getBillinaddressPhone() {
		return billinaddressPhone;
	}

	public WebElement getBillingaddressEmail() {
		return billingaddressEmail;
	}

	public WebElement getBillingaddressStreet() {
		return billingaddressStreet;
	}

	public WebElement getCopyButton() {
		return copyButton;
	}

	public WebElement getServicePhone() {
		return servicePhone;
	}

	public WebElement getServiceEmail() {
		return serviceEmail;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}


	public WebElement getNonmedicalType() {
		return nonmedicalType;
	}

	public WebElement getSkillednursingType() {
		return skillednursingType;
	}

	public WebElement getUregentCareType() {
		return uregentCareType;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getKeepCureentstatus() {
		return keepCureentstatus;
	}

	public WebElement getUpdateStatus() {
		return updateStatus;
	}

	public WebElement getStatusNote() {
		return statusNote;
	}

	public WebElement getAdministrativeStatus() {
		return administrativeStatus;
	}

	public WebElement getDeadfielStatus() {
		return deadfielStatus;
	}

	public WebElement getProspectStatus() {
		return prospectStatus;
	}

	public WebElement getClosetooltip() {
		return closetooltip;
	}

	public WebElement getTooltip() {
		return tooltip;
	}

	public WebElement getGeneratorStatus() {
		return generatorStatus;
	}

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
	
	public void Updatestatus() throws InterruptedException
	{
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		statusNote.sendKeys("Remove");
		Thread.sleep(200);
		updateStatus.click();
		Thread.sleep(2000);
	}
	
	public void KeepCurrentstatus() throws InterruptedException
	{
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		statusNote.sendKeys("Remove");
		Thread.sleep(200);
		keepCureentstatus.click();
		Thread.sleep(2000);
	}
	
	public void StatuswithoutNote() throws InterruptedException
	{
		WebElement location = driver.findElement(By.xpath("//div[@class='modal-box']"));
		Assert.assertTrue(location.isDisplayed(), "Model box is displayed");
		statusNote.sendKeys(Keys.CONTROL + "a");
		statusNote.sendKeys(Keys.DELETE);
		updateStatus.click();
		Thread.sleep(200);
		keepCureentstatus.click();
	}
	
	public void IndustrytypeOption() throws InterruptedException
	{
		uregentCareType.click();
		Thread.sleep(200);
		industryType.click();
		Actions act = new Actions(driver);
		act.moveToElement(skillednursingType).click().perform();
		Thread.sleep(200);
		industryType.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(nonmedicalType).click().perform();
		
	}
	
	public void ContractedCheckbox() throws InterruptedException
	{
		checkBox.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='flex items-center rounded-lg  gap-2 w-fit ']"));
		
		Thread.sleep(200);
		String ariaDisabled = element.getAttribute("aria-disabled");

	    if ("true".equals(ariaDisabled)) {
	        System.out.println("Element is disabled");
	    } else {
	        System.out.println("Element is enabled");
	    }
	}
	
	public void Contracted() throws InterruptedException
	{
		Actions act= new Actions(driver);
          act.scrollToElement(contracedsc).perform();
          checkBox.click();
  		Actions act1= new Actions(driver);
  		webDriverutility wlib = new webDriverutility();
  		/*
  		wlib.waitUntilElementClickable(driver, Yesbtn);
  		act1.doubleClick(Yesbtn).perform();
  		//cancelbtn.click();
  		Thread.sleep(4000);*/

         // Yesbtn.click();
	}
	
	public void Servicestate() throws InterruptedException
	{
		serviceState.click();
		aZstate.click();
		Thread.sleep(200);
		serviceState.click();
		Actions act = new Actions(driver);
		act.moveToElement(fLstate).click().perform();
		Thread.sleep(200);
		serviceState.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(wVState).click().perform();
	}
	
	public void GeneratorInformation() throws InterruptedException
	{
		WebElement generatormanagment = driver.findElement(By.xpath("//h6[contains (text(),'Generator Management')]"));
		generatormanagment.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement generatorlocation = driver.findElement(By.xpath("//h6[contains (text(),'Generator Locations')]"));
		generatorlocation.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		

		WebElement searchoption = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//input[@placeholder='Search by Name, Phone Number, Email, or Address']")));

		searchoption.click();
		searchoption.sendKeys("Max_298310");
		Thread.sleep(20000);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement generator = wait2.until(
		    ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//div[contains(text(),'OCTO Number')]/following::div[contains(text(),'G-108-3316')]")
		        )
		    )
		);

		generator.click();
		Thread.sleep(2000);
		By generatorInfo = By.xpath("//a[contains(text(),'Generator Information')]");

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait3.until(ExpectedConditions.refreshed(
		        ExpectedConditions.elementToBeClickable(generatorInfo)));

		driver.findElement(generatorInfo).click();
		Thread.sleep(20000);
	}
	
	public void billingState() throws InterruptedException
	{
		billingstate.click();
		aZstate.click();
		Thread.sleep(200);
		billingstate.click();
		Actions act = new Actions(driver);
		act.moveToElement(fLstate).click().perform();
		Thread.sleep(200);
		billingstate.click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(wVState).click().perform();
	}
	
	public void weekdayswithcheckbox() throws InterruptedException
	{
		thursdayCheckbox.click();
		if (!thursdayCheckbox.getAttribute("aria-checked").equals("true")) {
			thursdayCheckbox.click();		
	}
		
		Thread.sleep(2000);
		@Nullable
		String openingtimeDisabled = thursdayopeningtime.getAttribute("disabled");
		Assert.assertNotNull(openingtimeDisabled, "Opening Time dropdown is enabled.");
		System.out.println("Thursday Opening Time dropdown is disabled.");
		
		String lunchstartDisabled = thursdaylunchstart.getAttribute("disabled");
		Assert.assertNotNull(lunchstartDisabled, " lunch start dropdown is enabled.");
		System.out.println("Thursday lunch start dropdown is disabled.");
		
		String lunchendDisabled = thursdaylunchend.getAttribute("disabled");
		Assert.assertNotNull(lunchendDisabled, " lunch end dropdown is enabled.");
		System.out.println("Thursday lunch end dropdown is disabled.");
		
		String closingtimeDisabled = thursdayclosingtime.getAttribute("disabled");
		Assert.assertNotNull(closingtimeDisabled, "closing time dropdown is enabled.");
		System.out.println("Thursday closing time  dropdown is disabled.");			      
		    
	}
	
	public void TuesdaywithCheckbox() throws InterruptedException
	{
	@Nullable
	String openingtimeDisabled = tuesdayopeningtime.getAttribute("disabled");
	Assert.assertNotNull(openingtimeDisabled, "Opening Time dropdown is enabled.");
	System.out.println("Tuesday Opening Time dropdown is disabled.");
	
	String lunchstartDisabled = tuesdaylunchstart.getAttribute("disabled");
	Assert.assertNotNull(lunchstartDisabled, " lunch start dropdown is enabled.");
	System.out.println("Tuesday lunch start dropdown is disabled.");
	
	String lunchendDisabled = tuesdaylunchend.getAttribute("disabled");
	Assert.assertNotNull(lunchendDisabled, " lunch end dropdown is enabled.");
	System.out.println("Tuesday lunch end dropdown is disabled.");
	
	String closingtimeDisabled = tuesdaylunchclosetime.getAttribute("disabled");
	Assert.assertNotNull(closingtimeDisabled, "closing time dropdown is enabled.");
	System.out.println("Tuesday closing time  dropdown is disabled.");			      
	    
}

	
}
