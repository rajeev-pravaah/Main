package com.Octopussaas.ObjectRepository;

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
	@FindBy(xpath = "//div[text()='Copied to clipboard!']")
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
	 
	
	
}
