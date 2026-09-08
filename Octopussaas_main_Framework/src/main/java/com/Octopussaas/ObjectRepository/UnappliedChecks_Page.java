package com.Octopussaas.ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnappliedChecks_Page {
	WebDriver driver;

	public UnappliedChecks_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(xpath = "//h1[text()='Unapplied Checks']")
	private WebElement UnappliedChecks_Page;
	@FindBy(xpath = "//thead[@class='bg-gray-50 border-b border-gray-200 sticky top-0']/descendant::th")
	private List<WebElement> UnappliedChecks_Tablelists;
	@FindBy(xpath = "//button[text()='Quick Check Add']")
	private WebElement quickcheckaddbutton;
	@FindBy(xpath = "//input[@placeholder='Search generator by name or OCTO #...']")
	private WebElement searchgeneratorfieldfromquivkcheckadd;
	@FindBy(xpath = "//input[@placeholder='e.g. 12345']")
	private WebElement checknumberfieldfromquickcheckadd;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement amountfieldfromquickcheckadd;
	@FindBy(xpath = "//input[@placeholder='Optional note...']")
	private WebElement optionalnotefieldfromquickcheckadd;
	@FindBy(xpath = "//button[text()='Save Check']")
	private WebElement savecheckbuttonfromquickcheckadd;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelbuttonfromquickcheckadd;
	@FindBy(xpath = "//input[@placeholder='Search checks... (min 5 chars)']")
	private WebElement searchcheckfieldfromunappliedchecks;
	@FindBy(xpath = "//td[@class='px-4 py-3 text-gray-800 max-w-xl']")
	private WebElement nameofthegeneratorfromunappliedcheckstable;
	@FindBy(xpath = "//ul[@class='flex flex-col py-6']")
	private List<WebElement> sidebarlists;;
	@FindBy(xpath = "//label[text()='Date Range']/../descendant::div")
	private WebElement daterangedd;
	@FindBy(xpath = "//label[text()='Search']/../descendant::span")
	private WebElement searchiconvalidationmessage;
	@FindBy(xpath = "//tr[@class='border-b border-gray-100 hover:bg-gray-50 cursor-pointer']")
	private WebElement unappliedcheckstablelists;
	@FindBy(xpath = "//button[@class='text-primary text-sm text-nowrap hover:text-blue-900 pb-2']")
	private WebElement unappliedchecksfilterbutton;
	@FindBy(xpath = "//label[text()='Status']/../descendant::div")
	private WebElement statusdd;
	@FindBy(xpath = "//div[@class='relative flex items-center gap-2 w-full']")
	private List< WebElement> searchfieldfromunappliedchecks;
	@FindBy(xpath = "//h1[text()='Unapplied Checks']")
	private WebElement unappliedcheckspagetitle;
	@FindBy(xpath = "//label[text()='From']/../descendant::div")
	private WebElement fromdatepicker;
	@FindBy(xpath = "//div[@class='flex space-x-6']/descendant::div")
	private WebElement yearddfromfromcalendar;
	@FindBy(xpath = "//details[@class='dropdown']/descendant::li[@class='flex items-center justify-center']")
	private List<WebElement> yearsfromdd;
	@FindBy(xpath = "(//div[@class='flex space-x-6']/descendant::div)[4]")
	private WebElement monthddfromfromcalendar;
	@FindBy(xpath = "//a[@class='text-base text-left w-full']")
	private List<WebElement> monthsfromdd;
	@FindBy(xpath = "//label[text()='Date Range']/../descendant::span")
	private WebElement defaultvaluefromdaterange;
	@FindBy(xpath = "//thead[@class='bg-gray-50 border-b border-gray-200 sticky top-0']/descendant::th")
	private List<WebElement> unappliedcheckstableheaderlists;
	@FindBy(xpath = "//td[@class='px-4 py-3 text-xs text-gray-500']")
	private WebElement firstcheckidfromlist;
	@FindBy(xpath = "//div[contains(text(),'Copied to clipboard!')]")
	private WebElement copiedtoclipboardmessage;
	@FindBy(xpath = "//div[@class='flex justify-between items-center pt-3 text-sm text-gray-500 border-t border-gray-100 mt-2']/descendant::span")
	private List<WebElement> summaryfooter;
	@FindBy(xpath = "//tr[@class='border-b border-gray-100 hover:bg-gray-50 cursor-pointer']")
	private List<WebElement> numberofrowsinunappliedcheckstable;
	@FindBy(xpath = "(//div[@class='flex justify-between items-center pt-3 text-sm text-gray-500 border-t border-gray-100 mt-2']/descendant::span)[1]")
	private WebElement totalcheckfounds;
	@FindBy(xpath = "//input[@placeholder='Search generator by name or OCTO #...']")
	private WebElement searchgeneratorfieldfromunappliedchecks;
	@FindBy(xpath = "//div[@class='text-sm font-medium text-gray-800']")
	private WebElement searchgeneratorsuggestion;
	@FindBy(xpath = "(//tr[@class='border-b border-gray-100 hover:bg-gray-50 cursor-pointer']/descendant::td)[2]")
	private WebElement checkidfromunappliedcheckstable;
	@FindBy(xpath = "//tr[@class='border-b border-gray-100 hover:bg-gray-50 cursor-pointer']/descendant::td")
	private List<WebElement>  alldetailsofchecks;
	@FindBy(xpath = "//label[text()='To']/../descendant::div")
	private WebElement todatepicker;
	@FindBy(xpath = "//div[@class='react-datepicker']/descendant::summary")
	private WebElement toYeardd;
	@FindBy(xpath = "//div[@class='react-datepicker']/descendant::summary")
	private WebElement toMonthdd;
	@FindBy(xpath = "//div[text()='No unapplied checks yet. Click \"Quick Check Add\" to create one.']")
	private WebElement noUnappliedChecksMessage;
	@FindBy(xpath = "//td[@class='px-4 py-3 text-gray-800 max-w-xl']")
	private WebElement firstchecklistfromunappliedchecklist;
	@FindBy(xpath = "//label[text()='Check / Ref Number']/../descendant::div")
	private WebElement checknumberfromunappliedcheckdetailspopup;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelbuttonfromunquickaddcheckpopup;
	@FindBy(xpath = "//h2[text()='Unapplied Check Details']/../../descendant::button[text()='Delete']")
	private WebElement deletebuttonfromunappliedcheckdetails;
	@FindBy(xpath = "(//h3[text()='Delete Check']/../descendant::button)[2]")
	private WebElement deletebuttonfromuconfirmdeletepopup;
	@FindBy(xpath = "//div[text()='No matching checks found']")
	private WebElement nomatchingchecksfoundmessage;
	@FindBy(xpath = "//div[text()='Generator is required']")
	private WebElement generatorisrequiredmessage;
	@FindBy(xpath = "//div[text()='Check/Ref number is required']")
	private WebElement checknumberisrequiredmessage;
	@FindBy(xpath = "//div[text()='Amount must be greater than zero']")
	private WebElement amountmustbegreaterthanzero;
	@FindBy(xpath = "(//tr[@class='border-b border-gray-100 hover:bg-gray-50 cursor-pointer'])[1]/descendant::td[8]")
	private WebElement firstcheckpaymentdate;
	@FindBy(xpath = "(//div[@class='flex items-center gap-2']/descendant::button)[2]")
	private WebElement importfilebutton;
	@FindBy(xpath = "//h2[text()='Import Checks']")
	private WebElement importcheckspopup;
	@FindBy(xpath = "//button[text()='Download Template']")
	private WebElement downloadtemplatebutton;
	@FindBy(xpath = "//button[text()='Select File']")
	private WebElement selectfilebutton;
	@FindBy(xpath = "//button[contains(text(),'Confirm Import')]")
	private WebElement confirmimportbutton;
	@FindBy(xpath = "//tr[@class='border-b border-gray-200 ']")
	private WebElement importcheckstablelists;
	@FindBy(xpath = "//button[text()='valid)']")
	private WebElement confirmimportbuttonwithvalidtext;
	@FindBy(xpath = "//div[text()='CSV must have a header row and at least one data row']")
	private WebElement errormessageforblankcsvfile;
	@FindBy(xpath = "//p[@class='text-green-800 font-medium']")
	private WebElement successmessageforimportedchecks;
	@FindBy(xpath = "//div[@class='bg-red-50 border border-red-200 rounded-lg p-3 mb-3']")
	private WebElement errormessageforinvalidcsvfile;
	@FindBy(xpath = "//ul[@class='list-disc list-inside text-xs text-red-600 space-y-0.5']")
	private WebElement errorcountforinvalidcsvfile;
	@FindBy(xpath = "//p[text()=' checks created successfully']")
	private WebElement successmessageforimportedcheckswithcount;
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement donebuttonfromimportcheckspopup;
	@FindBy(xpath = "//h2[text()='Import Checks']/../descendant::button")
	private WebElement closebuttonfromimportresultspopup;
	@FindBy(xpath = "//button[text()='Manual Grid Entry']")
	private WebElement manualgridentrybuttonfromimportcheckspopup;
	@FindBy(xpath = "//button[text()='+ Add Row']")
	private WebElement addrowbuttonfrommanualgridentrypopup;
	@FindBy(xpath = "//tr[@class='border-b border-gray-200']")
	private List<WebElement> manualgridentrytablelists;
	@FindBy(xpath = "//td[@class='px-3 py-2']")
	private List<WebElement> removemanualgrids;
	@FindBy(xpath = "//p[text()='Validation errors:']")
	private WebElement validationerrorfrommanualgridentrypopup;
	@FindBy(xpath = "//button[contains(text(),'Create ')]")
	private WebElement createmanualgridbtn;
	@FindBy(xpath = "//input[@placeholder='e.g. 12345']")
	private WebElement checknumberfrommanualgrid;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement amountfieldfrommanualgrid;
	@FindBy(xpath = "//p[text()='Validation errors:']/../descendant::li")
	private WebElement generatorrequirederrormsg;
	@FindBy(xpath = "//input[@placeholder='Search generator...']")
	private WebElement searchgeneratorfieldfrommanualgrid;
	@FindBy(xpath = "//ul[@class='max-h-48 overflow-y-auto']")
	private WebElement searchgeneratorsuggestionfrommanualgrid;
	@FindBy(xpath = "//input[@placeholder='Optional']")
	private WebElement memofromgrid;
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement donebuttonfrommanualgridentrypopup;
	@FindBy(xpath = "//input[@type='number']/ancestor::tr/descendant::span[@class='text-cardTextGray truncate text-nowrap text-base']")
	private WebElement paymentdatepickerfrommanualgrid;
	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> paymentdatesoptionsfrommanualgrid;
	@FindBy(xpath = "//h2[text()='Import Checks']/../descendant::button")
	private WebElement closebuttonfrommanualgridentrypopup;
	@FindBy(xpath = "//td[@class='px-4 py-3 font-medium text-gray-800']")
	private WebElement firstchecknumberfrommanualgrid;
	@FindBy(xpath = "//h2[text()='Unapplied Check Details']")
	private WebElement unappliedcheckdetailspopup;
	@FindBy(xpath = "//label[@class='block text-sm text-gray-500']")
	private List<WebElement> unappliedcheckdetailspopupchecknumber;
	@FindBy(xpath = "//label[text()='Generator / Contractor']/../descendant::p")
	private WebElement generatornamfromunappliedcheckdetails;
	@FindBy(xpath = "//label[text()='Payment Date']/../descendant::button")
	private WebElement paymentdatefromunappliedcheckdetails;
	@FindBy(xpath = "//div[@class='flex gap-2']/../descendant::span")
	private WebElement editcalendar;
	@FindBy(xpath = "//label[text()='Memo']/../descendant::p")
	private WebElement memofromunappliedcheckdetails;
	@FindBy(xpath = "//label[text()='Memo']/../descendant::button")
	private WebElement editmemobuttonfromcheckdetail;
	@FindBy(xpath = "//label[text()='Memo']/../descendant::input")
	private WebElement editmemoffieldfromcheckdetail;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savememobuttonfromcheckdetail;
	@FindBy(xpath = "//div[text()='Memo updated successfully']")
	private WebElement memoupdatedsuccessfullymessage;
	@FindBy(xpath = "//label[text()='Check / Ref Number']/../descendant::p")
	private WebElement checknumberfromdetails;
	@FindBy(xpath = "//label[text()='Check / Ref Number']/../descendant::button")
	private WebElement editchecknumbutton;
	@FindBy(xpath = "//label[text()='Check / Ref Number']/../descendant::input")
	private WebElement editchecknumberfield;
	@FindBy(xpath = "//label[text()='Check / Ref Number']/../descendant::button")
	private WebElement savechecknumberbutton;
	@FindBy(xpath = "//label[text()='Invoice Number']/../descendant::button")
	private WebElement editinvoicenumbutton;
	@FindBy(xpath = "//label[text()='Invoice Number']/../descendant::p")
	private WebElement invoicenumberfromdetails;
	@FindBy(xpath = "//label[text()='Invoice Number']/../descendant::input")
	private WebElement editinvoicenumberfield;
	@FindBy(xpath = "//label[text()='Invoice Number']/../descendant::button")
	private WebElement saveinvoicenumberbutton;
	@FindBy(xpath = "//label[text()='Amount Received']/../descendant::p")
	private WebElement amountreceivedfromdetails;
	// Distinguish the edit and save buttons within the Amount Received field.
	// The first button is the edit button and the second is the save button.
	@FindBy(xpath = "(//label[text()='Amount Received']/../descendant::button)[1]")
	private WebElement editamountreceivedbutton;
	@FindBy(xpath = "//label[text()='Amount Received']/../descendant::input")
	private WebElement editamountreceivedfield;
	@FindBy(xpath = "(//label[text()='Amount Received']/../descendant::button)[1]")
	private WebElement saveamountreceivedbutton;
	@FindBy(xpath = "//div[text()='Check amount must be greater than zero. To zero out a check, delete it instead.']")
	private WebElement checkamountmustbegreaterthanzeroerrormessage;
	@FindBy(xpath = "//div[text()='Amount updated successfully']")
	private WebElement amountupdatedsuccessfullymessage;
	@FindBy(xpath = "//label[text()='Amount Received']/../descendant::div[@class='relative inline-block w-full']")
	private WebElement amountreceivededitfieldfromdetails;
	@FindBy(xpath = "//h2[text()='Unapplied Check Details']/../descendant::button")
	private WebElement closebuttonfromunappliedcheckdetailspopup;
	
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getClosebuttonfromunappliedcheckdetailspopup() {
		return closebuttonfromunappliedcheckdetailspopup;
	}
	public WebElement getAmountreceivedEditFieldfromdetails() {
		return amountreceivededitfieldfromdetails;
	}
	public WebElement getAmountupdatedsuccessfullymessage() {
		return amountupdatedsuccessfullymessage;
	}
	public WebElement getCheckamountmustbegreaterthanzeroerrormessage() {
		return checkamountmustbegreaterthanzeroerrormessage;
	}
	public WebElement getSaveamountreceivedbutton() {
		return saveamountreceivedbutton;
	}
	public WebElement getEditamountreceivedfield() {
		return editamountreceivedfield;
	}
	public WebElement getEditamountreceivedbutton() {
		return editamountreceivedbutton;
	}
	public WebElement getAmountreceivedfromdetails() {
		return amountreceivedfromdetails;
	}
	public WebElement getSaveinvoicenumberbutton() {
		return saveinvoicenumberbutton;
	}
	public WebElement getEditinvoicenumberfield() {
		return editinvoicenumberfield;
	}
	public WebElement getInvoicenumberfromdetails() {
		return invoicenumberfromdetails;
	}
	public WebElement getEditinvoicenumbutton() {
		return editinvoicenumbutton;
	}
	public WebElement getSavechecknumberbutton() {
		return savechecknumberbutton;
	}
	public WebElement getEditchecknumberfield() {
		return editchecknumberfield;
	}
	public WebElement getEditchecknumbutton() {
		return editchecknumbutton;
	}
	public WebElement getChecknumberfromdetails() {
		return checknumberfromdetails;
	}
	public WebElement getMemoupdatedsuccessfullymessage() {
		return memoupdatedsuccessfullymessage;
	}
	public WebElement getSavememobuttonfromcheckdetail() {
		return savememobuttonfromcheckdetail;
	}
	public WebElement getEditmemoffieldfromcheckdetail() {
		return editmemoffieldfromcheckdetail;
	}
	public WebElement getEditmemobuttonfromcheckdetail() {
		return editmemobuttonfromcheckdetail;
	}
	public WebElement getMemofromunappliedcheckdetails() {
		return memofromunappliedcheckdetails;
	}
	public WebElement getEditcalendar() {
		return editcalendar;
	}
	public WebElement getPaymentdatefromunappliedcheckdetails() {
		return paymentdatefromunappliedcheckdetails;
	}
	public WebElement getGeneratornamfromunappliedcheckdetails() {
		return generatornamfromunappliedcheckdetails;
	}
	public List<WebElement> getUnappliedcheckdetailspopupchecknumber() {
		return unappliedcheckdetailspopupchecknumber;
	}
	public WebElement getUnappliedcheckdetailspopup() {
		return unappliedcheckdetailspopup;
	}
	public WebElement getFirstchecknumberfrommanualgrid() {
		return firstchecknumberfrommanualgrid;
	}
	public WebElement getClosebuttonfrommanualgridentrypopup() {
		return closebuttonfrommanualgridentrypopup;
	}
	public List<WebElement> getPaymentdatesoptionsfrommanualgrid() {
		return paymentdatesoptionsfrommanualgrid;
	}
	public WebElement getPaymentdatepickerfrommanualgrid() {
		return paymentdatepickerfrommanualgrid;
	}
	public WebElement getDonebuttonfrommanualgridentrypopup() {
		return donebuttonfrommanualgridentrypopup;
	}
	
	public WebElement getMemofromgrid() {
		return memofromgrid;
	}
	public WebElement getSearchgeneratorsuggestionfrommanualgrid() {
		return searchgeneratorsuggestionfrommanualgrid;
	}
	public WebElement getSearchgeneratorfieldfrommanualgrid() {
		return searchgeneratorfieldfrommanualgrid;
	}
	public WebElement getGeneratorrequirederrormsg() {
		return generatorrequirederrormsg;
	}
	public WebElement getAmountfieldfrommanualgrid() {
		return amountfieldfrommanualgrid;
	}
	public WebElement getChecknumberfrommanualgrid() {
		return checknumberfrommanualgrid;
	}
	public WebElement getCreatemanualgridbtn() {
		return createmanualgridbtn;
	}
	public WebElement getValidationerrorfrommanualgridentrypopup() {
		return validationerrorfrommanualgridentrypopup;
	}
	public List<WebElement> getRemovemanualgrids() {
		return removemanualgrids;
	}
	public List<WebElement> getManualgridentrytablelists() {
		return manualgridentrytablelists;
	}
	public WebElement getAddrowbutton() {
		return addrowbuttonfrommanualgridentrypopup;
	}
	public WebElement getManualgridentrybutton() {
		return manualgridentrybuttonfromimportcheckspopup;
	}
	public WebElement getClosebuttonfromimportresultspopup() {
		return closebuttonfromimportresultspopup;
	}
	public WebElement getDonebuttonfromimportcheckspopup() {
		return donebuttonfromimportcheckspopup;
	}
	public WebElement getSuccessmessageforimportedcheckswithcount() {
		return successmessageforimportedcheckswithcount;
	}
	public WebElement getErrorcountforinvalidcsvfile() {
		return errorcountforinvalidcsvfile;
	}
	public WebElement getErrormessageforinvalidcsvfile() {
		return errormessageforinvalidcsvfile;
	}
	public WebElement getSuccessmessageforimportedchecks() {
		return successmessageforimportedchecks;
	}
	public WebElement getErrormessageforblankcsvfile() {
		return errormessageforblankcsvfile;
	}
	public WebElement getConfirmimportbuttonwithvalidtext() {
		return confirmimportbuttonwithvalidtext;
	}
	public WebElement getImportcheckstablelists() {
		return importcheckstablelists;
	}
	public WebElement getConfirmimportbutton() {
		return confirmimportbutton;
	}
	public WebElement getSelectfilebutton() {
		return selectfilebutton;
	}
	public WebElement getDownloadtemplatebutton() {
		return downloadtemplatebutton;
	}
	public WebElement getImportcheckspopup() {
		return importcheckspopup;
	}
	public WebElement getImportfilebutton() {
		return importfilebutton;
	}
	public WebElement getFirstcheckpaymentdate() {
		return firstcheckpaymentdate;
	}
	public WebElement getAmountmustbegreaterthanzero() {
		return amountmustbegreaterthanzero;
	}
	public WebElement getChecknumberisrequiredmessage() {
		return checknumberisrequiredmessage;
	}
	public WebElement getGeneratorisrequiredmessage() {
		return generatorisrequiredmessage;
	}
	public WebElement getNomatchingchecksfoundmessage() {
		return nomatchingchecksfoundmessage;
	}
	public WebElement getDeletebuttonfromuconfirmdeletepopup() {
		return deletebuttonfromuconfirmdeletepopup;
	}
	public WebElement getDeletebuttonfromunappliedcheckdetails() {
		return deletebuttonfromunappliedcheckdetails;
	}
	public WebElement getCancelbuttonfromunquickaddcheckpopup() {
		return cancelbuttonfromunquickaddcheckpopup;
	}
	public WebElement getChecknumberfromunappliedcheckdetailspopup() {
		return checknumberfromunappliedcheckdetailspopup;
	}
	public WebElement getFiestUnappliedcheckDetail() {
		return firstchecklistfromunappliedchecklist;
	}
	public WebElement getNoUnappliedChecksMessage() {
		return noUnappliedChecksMessage;
	}
	public WebElement getToMonthdd() {
		return toMonthdd;
	}
	public WebElement getToYeardd() {
		return toYeardd;
	}
	public WebElement getTodatepicker() {
		return todatepicker;
	}
	public List<WebElement> getAlldetailsofchecks() {
		return alldetailsofchecks;
	}
	public WebElement getCheckNumberfromunappliedcheckstable() {
		return checkidfromunappliedcheckstable;
	}
	public WebElement getSearchgeneratorsuggestion() {
		return searchgeneratorsuggestion;
	}
	public WebElement getSearchfieldfromcheckpopup() {
		return searchgeneratorfieldfromunappliedchecks;
	}
	public WebElement getTotalcheckfounds() {
		return totalcheckfounds;
	}
	public List<WebElement> getNumberofrowsinunappliedcheckstable() {
		return numberofrowsinunappliedcheckstable;
	}
	public List<WebElement> getSummaryfooter() {
		return summaryfooter;
	}
	public WebElement getCopiedtoclipboardmessage() {
		return copiedtoclipboardmessage;
	}
	public WebElement getFirstcheckidfromlist() {
		return firstcheckidfromlist;
	}
	public List<WebElement> getUnappliedcheckstableheaderlists() {
		return unappliedcheckstableheaderlists;
	}
	public WebElement getDefaultvaluefromdaterange() {
		return defaultvaluefromdaterange;
	}
	public List<WebElement> getMonthsfromdd() {
		return monthsfromdd;
	}
	public WebElement getMonthddfromfromcalendar() {
		return monthddfromfromcalendar;
	}
	public List<WebElement> getYearsfromdd() {
		return yearsfromdd;
	}

			/**
			 * Return year elements from the currently-open (visible) react-datepicker calendar.
			 * This scopes queries to the visible calendar to avoid picking years from another open datepicker.
			 */
			public List<WebElement> getVisibleYearsFromOpenCalendar() {
				return driver.findElements(By.xpath("//div[contains(@class,'react-datepicker') and not(contains(@style,'display: none'))]//a[@class='text-base']"));
			}

			/**
			 * Return month elements from the currently-open (visible) react-datepicker calendar.
			 */
			public List<WebElement> getVisibleMonthsFromOpenCalendar() {
				return driver.findElements(By.xpath("//div[contains(@class,'react-datepicker') and not(contains(@style,'display: none'))]//a[contains(@class,'text-base') and contains(@class,'text-left')]"));
			}

			/**
			 * Click a day (by visible text) inside the currently-open react-datepicker calendar.
			 */
			public void clickDayInOpenCalendar(String dayText) {
				WebElement day = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker') and not(contains(@style,'display: none'))]//div[text()='" + dayText + "']"));
				day.click();
			}
	public WebElement getYearDDfromFromcalendar() {
		return yearddfromfromcalendar;
	}
	public WebElement getFromdatepicker() {
		return fromdatepicker;
	}
	public WebElement getUnappliedcheckspagetitle() {
		return unappliedcheckspagetitle;
	}
	public List<WebElement> getSearchfieldfromunappliedchecks() {
		return searchfieldfromunappliedchecks;
	}
	public WebElement getStatusdd() {
		return statusdd;
	}
	public WebElement getUnappliedchecksfilterbutton() {
		return unappliedchecksfilterbutton;
	}
	public WebElement getUnappliedcheckstablelists() {
		return unappliedcheckstablelists;
	}
	public WebElement getSearchiconvalidationmessage() {
		return searchiconvalidationmessage;
	}
	public WebElement getDaterangedd() {
		return daterangedd;
	}
	public List<WebElement> getSideBarLists() {
		return sidebarlists;
	}
	public WebElement getNameofthegeneratorfromunappliedcheckstable() {
		return nameofthegeneratorfromunappliedcheckstable;
	}
	public WebElement getSearchcheckfieldfromunappliedchecks() {
		return searchcheckfieldfromunappliedchecks;
	}
	public WebElement getCancelbuttonfromquickcheckadd() {
		return cancelbuttonfromquickcheckadd;
	}
	public WebElement getSavecheckbuttonfromquickcheckadd() {
		return savecheckbuttonfromquickcheckadd;
	}
	public WebElement getOptionalnotefieldfromquickcheckadd() {
		return optionalnotefieldfromquickcheckadd;
	}
	public WebElement getAmountfieldfromquickcheckadd() {
		return amountfieldfromquickcheckadd;
	}
	public WebElement getChecknumberfieldfromquickcheckadd() {
		return checknumberfieldfromquickcheckadd;
	}
	public WebElement getSearchgeneratorfieldfromquivkcheckadd() {
		return searchgeneratorfieldfromquivkcheckadd;
	}
	public WebElement getQuickcheckaddbutton() {
		return quickcheckaddbutton;
	}
	public  List<WebElement> getUnappliedChecks_Tablelists() {
		return UnappliedChecks_Tablelists;
	}
	public WebElement getUnappliedChecks_Page() {
		return UnappliedChecks_Page;
	}

	/**
	 * Utility: detect common global spinner/loader elements on the page.
	 * Used by tests as a generic indicator that a save/ajax action is in progress.
	 */
	public boolean isGlobalSpinnerPresent() {
		List<WebElement> els = driver.findElements(By.xpath(
			"//*[(local-name() = 'svg') and (contains(@class,'spinner') or contains(@class,'loading') or contains(@class,'animate-spin'))] | //*[@role='progressbar'] | //*[contains(@class,'spinner') or contains(@class,'loader') or contains(@class,'loading') or contains(@class,'progress')] | //*[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'loading')] | //*[@aria-busy='true']"));
		return els != null && els.size() > 0;
	}
	
	
	public void  AddCheckNumber()
	{
		//genearte 6 digit random number
		int randomNum = (int)(Math.random() * 900000) + 100000;
		
		checknumberfieldfromquickcheckadd.sendKeys(String.valueOf(randomNum));
	}
	
	public void  AddAmountField(String txt)
	{
		amountfieldfromquickcheckadd.click();
		//write code to clear the field using robot class
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='';", amountfieldfromquickcheckadd);
		amountfieldfromquickcheckadd.sendKeys(txt);
		
	}
	public void  AddMemoNote(String txt)
	{
		optionalnotefieldfromquickcheckadd.clear();
		optionalnotefieldfromquickcheckadd.sendKeys(txt);
	}
	public void  ClickOnSaveCheckButton() throws InterruptedException
	{
		savecheckbuttonfromquickcheckadd.click();
		Thread.sleep(2000);
		cancelbuttonfromquickcheckadd.click();
	}
	
	
	
		 
		 public String CurrentSystemDate() {

			    // Get current system date in MM/dd/yyyy format
			    java.util.Date date = new java.util.Date();
			    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
			    String currentDate = sdf.format(date);

			    System.out.println("Current System Date: " + currentDate);

			    return currentDate;
			}
		 
		 
		 
		 public void pressEscToCloseNativeFileDialog() throws AWTException, InterruptedException {
				Robot robot = new Robot();
				robot.setAutoDelay(100);
				Thread.sleep(300);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(200);
		 }
	
	
}
