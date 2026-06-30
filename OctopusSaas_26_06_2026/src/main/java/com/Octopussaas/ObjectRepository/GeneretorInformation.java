package com.Octopussaas.ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Octopussaass.WebdriverUtility.webDriverutility;

public class GeneretorInformation {
	WebDriver driver;
	Actions act;

	public GeneretorInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h6[@title='Generator Name']")
	private WebElement GenName;
	@FindBy(xpath = "//h6[@title='Internal Account Number']")
	private WebElement InternalAcNo;
	@FindBy(xpath = "//h6[contains(text(),'Generator Billing Information')]")
	private WebElement BillingInfo;
	@FindBy(id  = "industry-type")
	private WebElement Industry;
	@FindBy(xpath = "//span[contains(text(),'Urgent Care Clinics')]")
	private WebElement urgentCareElement;
	@FindBy(xpath = "//p[contains(text(),'Latitude:')]")
	private WebElement Latitute;
	@FindBy(id  = "serviceAddress-street")
	private WebElement street;
	@FindBy(xpath = "//div[contains(text(),'1237 3rd Street Southeast')]")
	private WebElement road;
	@FindBy(id = "serviceAddress-email")
	private WebElement EmailId;
	@FindBy(id = "serviceAddress-phone")
	private WebElement Phoneno;
	@FindBy(xpath = "//div[@class='flex w-full py-2 font-medium']")
	private WebElement genereteOff;
     @FindBy(xpath = "(//div[@class='flex w-full mt-6'])[1]")
     private WebElement latitude;
	@FindBy(xpath = "(//div[@class='flex w-full mt-6'])[2]")
	private WebElement longitude;
	@FindBy(xpath = "//button[@class='enabled:hover:text-primary']")
	private WebElement copybtn;
	@FindBy(xpath = "//input[@id='billingAddress-street']")
	private WebElement billingstreet;
	@FindBy(xpath = "//h6[contains(text(),'Sunday')]")
	private WebElement sunday;
	@FindBy(xpath = "//input[@placeholder='Monday Opening Time']")
	private WebElement mondayopen;
	@FindBy(xpath = "//span[contains(text(),'8:00 AM')]")
	private WebElement opn;
	@FindBy(xpath = "//input[@placeholder='Monday Lunch Start Time']")
	private WebElement lunch;
	@FindBy(xpath = "//span[contains(text(),'11:30 AM')]")
	private WebElement lunchtime;
	@FindBy(xpath = "//input[@placeholder='Monday Lunch End Time']")
	private WebElement lunchend;
	@FindBy(xpath = "//span[contains(text(),'12:30 PM')]")
	private WebElement lunchendtime;
	@FindBy(xpath = "//input[@placeholder='Monday Closing Time']")
	private WebElement mondayclose;
	@FindBy(xpath = "//span[contains(text(),'5:00 PM')]")
	private WebElement closemon;
	@FindBy(xpath = "//span[@class='w-1/4 flex items-center justify-center']")
	private WebElement copyobtn;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[4]")
	private WebElement tuecopy;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[6]")
	private WebElement wedcopy;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[8]")
	private WebElement thucopy;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[10]")
	private WebElement fricopy;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[12]")
	private WebElement satcopy;
	@FindBy(xpath = "(//span[@class='w-1/4 flex items-center justify-center'])[14]")
	private WebElement suncopy;
	@FindBy(xpath = "//span[contains(text(),'Contracted')]")
	private WebElement contracedsc;
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer') and contains(@class,'border-2')]")
	private WebElement checkBox;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement Yesbtn;
	@FindBy(xpath = "//div[@class='relative inline-block']")
	private WebElement ellipse;
	@FindBy(xpath = "//button[contains(text(),'Route Assignment')]")
	private WebElement route;
	@FindBy(xpath = "(//button[contains(text(),'✕')])[2]")
	private WebElement cancelbtn;
	@FindBy(xpath = "//div[@class='react-datepicker__input-container']")
	private WebElement calendar;
	@FindBy(xpath = "//a[text()='Generator Contacts']")
	private WebElement generatorContacts;
	@FindBy(xpath = "//span[text()='Contracted']/../../descendant::div")
	private WebElement contractedcheckbox;
	@FindBy(xpath = "//textarea[@name='cancellationNote']")
	private WebElement cancellationNote;
	@FindBy(xpath = "//button[text()='Terminate The Contract']")
	private WebElement terminateContractbtn;
	
	
	
	
	
	public WebElement getTerminateContractbtn() {
		return terminateContractbtn;
	}
	public WebElement getCancellationNote() {
		return cancellationNote;
	}
	public WebElement getContractedcheckbox() {
		return contractedcheckbox;
	}
	public WebElement getGeneratorContacts() {
		return generatorContacts;
	}


	public WebElement getCalendar() {
		return calendar;
	}
	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	public WebElement getRoute() {
		return route;
	}
	public WebElement getEllipse() {
		return ellipse;
	}
	public WebElement getYesbtn() {
		return Yesbtn;
	}
	public WebElement getCheckBox() {
		return checkBox;
	}
	public WebElement getContracedsc() {
		return contracedsc;
	}
	public WebElement getSuncopy() {
		return suncopy;
	}
	public WebElement getSatcopy() {
		return satcopy;
	}
	public WebElement getFricopy() {
		return fricopy;
	}
	public WebElement getThucopy() {
		return thucopy;
	}
	public WebElement getWedcopy() {
		return wedcopy;
	}
	public WebElement getTuecopy() {
		return tuecopy;
	}
	public WebElement getCopyobtn() {
		return copyobtn;
	}
	public WebElement getMondayclose() {
		return mondayclose;
	}
	public WebElement getClosemon() {
		return closemon;
	}
	public WebElement getLunchend() {
		return lunchend;
	}
	public WebElement getLunchendtime() {
		return lunchendtime;
	}
	public WebElement getLunchtime() {
		return lunchtime;
	}
	public WebElement getLunch() {
		return lunch;
	}
	public WebElement getOpn() {
		return opn;
	}
	public WebElement getMondayopen() {
		return mondayopen;
	}
	public WebElement getSunday() {
		return sunday;
	}
	public WebElement getBillingstreet() {
		return billingstreet;
	}
	public WebElement getCopybtn() {
		return copybtn;
	}
	public WebElement getLongitude() {
		return longitude;
	}
	public WebElement getLatitude() {
		return latitude;
	}
	public WebElement getGenereteOff() {
		return genereteOff;
	}
	public WebElement getPhoneno() {
		return Phoneno;
	}
	public WebElement getEmailId() {
		return EmailId;
	}
	public WebElement getRoad() {
		return road;
	}
	public WebElement getStreet() {
		return street;
	}
	public WebElement getLatitute() {
		return Latitute;
	}
	public WebElement getUrgentCareElement() {
		return urgentCareElement;
	}
	public WebElement getIndustry() {
		return Industry;
	}
	public WebElement getBillingInfo() {
		return BillingInfo;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getGenName() {
		return GenName;
	}
	public WebElement getInternalAcNo() {
		return InternalAcNo;
	}
	public String GeneratorName()
	{
		String gname = GenName.getText();
		return gname;
	}
	public String InternalAcNumber()
	{
		String InAcNo = InternalAcNo.getText();
		return InAcNo;
	}
	public void IndustryDD() throws AWTException
	{
		Industry.click();
		String txt = urgentCareElement.getText();
		Robot r = new Robot();
		
		Industry.sendKeys(txt);
		r.keyPress(KeyEvent.VK_ENTER);
		
	}
	public void Street()
	{
		
		street.click();
		street.sendKeys("1237 3");
		Actions act= new Actions(driver);
		act.moveToElement(road).click().perform();
	}
	public void Emialid(String Email)
	{
		EmailId.click();
		EmailId.sendKeys(Email);
		
	}
	public void Phonenumber(String Phone)
	{
		Phoneno.click();
		Phoneno.sendKeys(Phone);
	}
	public void CopyBtn()
	{
		Actions act = new Actions(driver);
		act.scrollToElement(copybtn).perform();
		copybtn.click();
	}
	public void MondayOpen()
	{
		mondayopen.click();
		mondayopen.sendKeys("8:00");
		Actions act= new Actions(driver);
		act.moveToElement(opn).click().perform();
	}
	public void lunchTime()
	{
		lunch.click();
		lunch.sendKeys("11:30");
		Actions act= new Actions(driver);
		act.moveToElement(lunchtime).click().perform();
		
	}
	public void lunchEnd()
	{
		lunchend.click();
		lunchend.sendKeys("12:30");
		Actions act= new Actions(driver);
		act.moveToElement(lunchendtime).click().perform();
		
	}
	public void MondayClose()
	{
		mondayclose.click();
		mondayclose.sendKeys("5:00");
		Actions act= new Actions(driver);
		act.moveToElement(closemon).click().perform();
		
	}
	public void CopyPasteToAllDay()
	{
		copyobtn.click();
		tuecopy.click();
		wedcopy.click();
		thucopy.click();
		fricopy.click();
		satcopy.click();
		suncopy.click();
	}
	public void Contracted() throws InterruptedException
	{
		Actions act= new Actions(driver);
          act.scrollToElement(contracedsc).perform();
          checkBox.click();
  		Actions act1= new Actions(driver);
  		webDriverutility wlib = new webDriverutility();
  		wlib.waitUntilElementClickable(driver, Yesbtn);
  		act1.doubleClick(Yesbtn).perform();
  		//cancelbtn.click();
  		Thread.sleep(4000);

         // Yesbtn.click();
	}
	public void Ellisebtn()
	{
		webDriverutility wlib = new webDriverutility();
		Actions actions = new Actions(driver);
		// ensure ellipse menu is in view
		actions.scrollToElement(ellipse).perform();
		// wait and click ellipse
		wlib.waitUntilElementClickable(driver, ellipse);
		ellipse.click();
		// wait and click route assignment option
		wlib.waitUntilElementClickable(driver, route);
		route.click();
	}
	
	
	
}