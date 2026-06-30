package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneratorContacts {
	WebDriver driver;

	public GeneratorContacts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(xpath = "//h6[@title='OCTO Number']")
	private WebElement octonumber;
	@FindBy(xpath = "//h6[@title='Generator Name']/../descendant::span")
	private WebElement contactname;
	@FindBy(xpath = "//div[@class='text-sm self-end mt-2']")
	private WebElement createddate;
	@FindBy(xpath = "(//div[@class='relative inline-block'])[3]")
	private WebElement contactlisticon;
	@FindBy(xpath = "//strong[text()='Generator Contact List']")
	private WebElement contactlisttext;
	@FindBy(xpath = "//button[@class='bg-cardTextBlue text-white rounded-full px-4 py-2 flex']")
	private WebElement addcontactbutton;
	@FindBy(xpath = "//h6[text()='Add New Contact']")
	private WebElement addnewcontacdialoguebox;
	@FindBy(id = "name-input")
	private WebElement contactnamefield;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "//p[text()='Contact Name is required']")
	private WebElement contactnameerror;
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement contactnumberfield;
	@FindBy(xpath = "//p[text()='Phone number length should be 10']")
	private WebElement contactnumbererror;
	@FindBy(xpath = "//input[@id='undefined-ext']")
	private WebElement contactnumberextfield;
	@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
	private WebElement contactemailfield;
	@FindBy(xpath = "//p[text()='Email is required']")
	private WebElement contactemailerror;
	@FindBy(xpath = "//div[@class='px-4 py-2 hover:bg-gray-100 cursor-pointer min-h-9  text-gray-700']")
	private List<WebElement> listofuserfromh;
	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	private WebElement passwordfield;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement showpasswordbutton;
	@FindBy(xpath = "//p[text()='Password is required']")
	private WebElement passworderror;
	@FindBy(xpath = "//label[text()='Emails ']/../descendant::span")
	private WebElement selectemailstextfield;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement generatorportallogincredentilascheckbox;
	@FindBy(xpath = "//label[text()='Emails ']/../descendant::button")
	private WebElement selctedemailscancelbtn;
	@FindBy(id = "urlLink-input")
	private WebElement generatorportalloginurltextfield;
	@FindBy(xpath = "//div[text()='Please enter a valid URL.']")
	private WebElement generatorportalloginurlerror;
	@FindBy(id = "jobTitle-input")
	private WebElement jobtitletextfield;
	@FindBy(xpath = "//button[@id='contact-status']/descendant::span")
	private WebElement contactstatusdropdown;
	@FindBy(xpath = "//div[@role='option'] | //li[@role='option'] | //div[contains(@class,'select__option')] | //div[contains(@class,'dropdown-item')] | //ul[contains(@class,'dropdown-menu')]//li")
	private List<WebElement> contactstatusdropdownoption;
	@FindBy(xpath = "//label[@for='access']/../descendant::span[@class='truncate']")
	private  List<WebElement>  accessfields;
	@FindBy(xpath = "//label[@for='access']/../descendant::button")
	private WebElement  cancelfirstelemetfrondd;
	@FindBy(id = "contact-note")
	private WebElement contactnotefield;
	@FindBy(xpath = "//span[text()='Credit Memo Issued']")
	private WebElement notificationDDbtn;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement notification1stcheckbox;
	@FindBy(xpath = "//label[text()='Notification ']/../descendant::span[@class='truncate']")
	private List<WebElement> notification1stcheckboxtext;
	@FindBy(xpath = "//label[text()='Emails ']")
	private WebElement selectemailstext;
	@FindBy(xpath = "//label[text()='Notification ']/../descendant::button")
	private WebElement notification1stcheckboxcancelbtn;
	@FindBy(xpath = "//span[@class='break-words']")
	private List<WebElement> contactnamelists;
	@FindBy(id = "role")
	private WebElement roledropdown;
	@FindBy(xpath = "//div[@class='text-cardTextGray border-b hover:bg-cardTextGray hover:bg-opacity-10']")
	private List<WebElement> contactlists;
	@FindBy(xpath = "//label[text()='Access ']/../descendant::span[@class='truncate']")
	private List<WebElement> accessdropdowntext;
	@FindBy(xpath = "//button[text()='×']")
	private WebElement cancelpopupbtn;
	@FindBy(xpath = "//button[text()='Log into Generators Portal as this contact.']")
	private WebElement logintogeneratorsportallink;
	@FindBy(xpath = "//h6[text()='1. Relationship Between Generator, Transporter, and Octopus']")
	private WebElement generatortermsofservicepage;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement generatortermsofservicecheckbox;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement generatortermsofservicecancelbtn;
	@FindBy(xpath = "(//button[text()='Confirm'])[2]")
	private WebElement generatortermsofserviceconfirmbtn;
	@FindBy(xpath = "//h3[text()='Welcome']")
	private WebElement welcomePageofGeneratorPortal;
	@FindBy(xpath = "//button[text()='I ACCEPT']")
	private WebElement iacceptbuttonfromgeneratorportal;
	@FindBy(xpath = "//h2[text()='Set up new password']")
	private WebElement setuppasswordpageofgeneratorportal;
	@FindBy(xpath = "//h2[text()='Set up new password']")
	private WebElement setuppasswordpageofgeneratorportal1;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement newpasswordfield;
	@FindBy(xpath = "//input[@type='password']/../descendant::button")
	private WebElement eyeiconnewpasswordbutton;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement retypenewpasswordfield;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmbuttonfromsetuppasswordpage;
	@FindBy(xpath = "//div[text='Passwords don't match!']")
	private WebElement passwordsdontmatcherror;
	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardpageofgeneratorportal;
	@FindBy(xpath = "//div[@class='flex flex-col px-4 py-2']")
	private WebElement generatorportalusername;
	@FindBy(xpath = "//img[@class='rounded-full w-full h-full object-cover']")
	private WebElement generatorportaluserprofileimage;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement generatorportallogoutbutton;
	@FindBy(xpath = "//p[@class='text-sm text-cardTextGray truncate']")
	private WebElement generatorportaluseremail;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement generatorportaluseremailfield;
	@FindBy(xpath = "//h3[text()='Welcome']")
	private WebElement generatorportalwelcomeheading;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement generatorportalpasswordfield;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement generatorportalloginbutton;
	
	
	
	
	
	
	public WebElement getGeneratorportalloginbutton() {
		return generatorportalloginbutton;
	}
	public WebElement getGeneratorportalpasswordfield() {
		return generatorportalpasswordfield;
	}
	public WebElement getGeneratorportalwelcomeheading() {
		return generatorportalwelcomeheading;
	}
	public WebElement getGeneratorportaluseremailfield() {
		return generatorportaluseremailfield;
	}
	public WebElement getGeneratorportaluseremail() {
		return generatorportaluseremail;
	}
	public WebElement getGeneratorportallogoutbutton() {
		return generatorportallogoutbutton;
	}
	public WebElement getGeneratorportaluserprofileimage() {
		return generatorportaluserprofileimage;
	}
	public WebElement getGeneratorportalusername() {
		return generatorportalusername;
	}
	
	public WebElement getDashboardpageofgeneratorportal() {
		return dashboardpageofgeneratorportal;
	}
	public WebElement getPasswordsdontmatcherror() {
		return passwordsdontmatcherror;
	}
	public WebElement getConfirmbuttonfromsetuppasswordpage() {
		return confirmbuttonfromsetuppasswordpage;
	}
	public WebElement getRetypenewpasswordfield() {
		return retypenewpasswordfield;
	}
	public WebElement getEyeiconnewpasswordbutton() {
		return eyeiconnewpasswordbutton;
	}
	public WebElement getNewpasswordfield() {
		return newpasswordfield;
	}
	public WebElement getSetuppasswordpageofgeneratorportal1() {
		return setuppasswordpageofgeneratorportal1;
	}
	public WebElement getSetuppasswordpageofgeneratorportal() {
		return setuppasswordpageofgeneratorportal;
	}
	public WebElement getIacceptbuttonfromgeneratorportal() {
		return iacceptbuttonfromgeneratorportal;
	}
	public WebElement getWelcomePageofGeneratorPortal() {
		return welcomePageofGeneratorPortal;
	}
	
	public WebElement getGeneratortermsofserviceconfirmbtn() {
		return generatortermsofserviceconfirmbtn;
	}
	public WebElement getGeneratortermsofservicecancelbtn() {
		return generatortermsofservicecancelbtn;
	}
	public WebElement getGeneratortermsofservicecheckbox() {
		return generatortermsofservicecheckbox;
	}
	public WebElement getGeneratortermsofservicepage() {
		return generatortermsofservicepage;
	}
	public WebElement getLogintogeneratorsportallink() {
		return logintogeneratorsportallink;
	}
	public WebElement getCancelpopupbtn() {
		return cancelpopupbtn;
	}
	public List<WebElement> getAccessdropdowntext() {
		return accessdropdowntext;
	}
	public List<WebElement> getRoledropdownoption() {
		return contactlists;
	}
	public WebElement getRoledropdown() {
		return roledropdown;
	}
	public List<WebElement> getContactnamelists() {
		return contactnamelists;
	}
	public WebElement getNotification1stcheckboxcancelbtn() {
		return notification1stcheckboxcancelbtn;
	}
	public WebElement getSelectemailstext() {
		return selectemailstext;
	}
	public List<WebElement> getNotification1stcheckboxtext() {
		return notification1stcheckboxtext;
	}
	public WebElement getNotification1stcheckbox() {
		return notification1stcheckbox;
	}
	public WebElement getNotificationDDbtn() {
		return notificationDDbtn;
	}
	public WebElement getContactnotefield() {
		return contactnotefield;
	}
	public WebElement getCancelfirstelemetfrondd() {
		return cancelfirstelemetfrondd;
	}
	public  List<WebElement>  getAccessfields() {
		return accessfields;
	}
	public WebElement getOctonumber() {
		return octonumber;
	}
	public WebElement getContactname() {
		return contactname;
	}
	public WebElement getCreateddate() {
		return createddate;
	}
	public WebElement getContactlisticon() {
		return contactlisticon;
	}
	public WebElement getContactlisttext() {
		return contactlisttext;
	}
	public WebElement getAddcontactbutton() {
		return addcontactbutton;
	}
	public WebElement getAddnewcontacdialoguebox() {
		return addnewcontacdialoguebox;
	}
	public WebElement getContactnamefield() {
		return contactnamefield;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getContactnameerror() {
		return contactnameerror;
	}
	public WebElement getContactnumberfield() {
		return contactnumberfield;
	}
	public WebElement getContactnumbererror() {
		return contactnumbererror;
	}
	public WebElement getContactnumberextfield() {
		return contactnumberextfield;
	}
	public WebElement getContactemailfield() {
		return contactemailfield;
	}
	public WebElement getContactemailerror() {
		return contactemailerror;
	}
	public List<WebElement> getListofuserfromh() {
		return listofuserfromh;
	}
	public WebElement getPasswordfield() {
		return passwordfield;
	}
	public WebElement getShowpasswordbutton() {
		return showpasswordbutton;
	}
	public WebElement getPassworderror() {
		return passworderror;
	}
	public WebElement getSelectemailstextfield() {
		return selectemailstextfield;
	}
	public WebElement getGeneratorportallogincredentilascheckbox() {
		return generatorportallogincredentilascheckbox;
	}
	public WebElement getSelctedemailscancelbtn() {
		return selctedemailscancelbtn;
	}
	public WebElement getGeneratorportalloginurltextfield() {
		return generatorportalloginurltextfield;
	}
	public WebElement getGeneratorportalloginurlerror() {
		return generatorportalloginurlerror;
	}
	public WebElement getJobtitletextfield() {
		return jobtitletextfield;
	}
	public WebElement getContactstatusdropdown() {
		return contactstatusdropdown;
	}
	public List<WebElement> getContactstatusdropdownoption() {
		return contactstatusdropdownoption;
	}
}