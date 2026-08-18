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
	@FindBy(xpath = "//div[@class='h-[40px] flex items-center']")
	private WebElement daterangedd;
	
	
	
	
	
	
	
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
