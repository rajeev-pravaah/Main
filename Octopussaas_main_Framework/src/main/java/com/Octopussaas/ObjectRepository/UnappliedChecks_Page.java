package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(xpath = "//a[@class='text-base']")
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
	private List<WebElement>  alldetailsofchecks;;
	
	
	
	
	
	
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
	
	
	
}
