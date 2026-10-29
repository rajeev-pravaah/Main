package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GeneratorPortal {
	WebDriver driver;
	public GeneratorPortal(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy (xpath = "//button[@class='flex items-center gap-4 focus:outline-none']")
	private WebElement userprofileButton;
	@FindBy (xpath = "//a[contains (text(),'Transporter Settings')]")
	private WebElement transportesettings;
	@FindBy (xpath = "//a[contains (text(),'Log In to Generator Portal')]")
	private WebElement generatorportalLink;
	@FindBy (xpath = "//div[@class='w-full flex flex-col items-center max-w-md bg-white p-8 sm:p-10 rounded-2xl shadow-[0_8px_30px_rgb(0,0,0,0.04)] border border-gray-100']")
	private WebElement welcomepage;
	@FindBy (xpath = "//input[@placeholder='Enter Email']")
	private WebElement emailtextfield;
	@FindBy (xpath = "//input[@type='password']")
	private WebElement passwordtextfield;
	@FindBy (xpath = "//button[contains (text(),'Login')]")
	private WebElement login;
	@FindBy (xpath = "//input[@name='password']/following-sibling::button[@type='button']")
	private WebElement eyeicon;
	@FindBy (xpath = "//div[contains (text(),'Forgot Password?')]")
	private WebElement forgotpassword;
	@FindBy (xpath ="//input[@placeholder='Enter Email']")
	private WebElement forgotpasswordEmail;
	@FindBy (xpath = "//button[contains (text(),'Submit')]")
	private WebElement submitButton;
	@FindBy (xpath = "//div[contains (text(),'Back to Login')]")
	private WebElement backtoLoginButton;
	@FindBy (xpath = "//button[contains (text(),'New User Registration')]")
	private WebElement newuserRegistrationButton;
	@FindBy (xpath = "//div[@class='w-full flex flex-col items-center max-w-md bg-white p-8 sm:p-10 rounded-2xl shadow-[0_8px_30px_rgb(0,0,0,0.04)] border border-gray-100']")
	private WebElement userRegistrationPage;
	@FindBy (xpath = "//input[@placeholder='First Name *']")
	private WebElement firstname;
	@FindBy (xpath = "//button[contains (text(),'Register Now')]")
	private WebElement registernowButton;
	@FindBy (xpath = "//input[@placeholder='Last Name *']")
	private WebElement lastname;
	@FindBy (xpath = "//input[@placeholder='Email Address *']")
	private WebElement regEmail;
	@FindBy (xpath = "//input[@type='tel']")
	private WebElement phoneNumber;
	@FindBy (xpath = "//input[@name='companyName']")
	private WebElement companyname;
	@FindBy (xpath = "//input[@placeholder='Service Location Address']")
	private WebElement serivcelocationAddress;
	@FindBy (xpath = "//input[@placeholder='Account Number (if known)']")
	private WebElement accountNumber;
	@FindBy (xpath = "//div[contains (text(),'Already have an account? Login')]")
	private WebElement alreadyhaveanaccount;
	
	
	public WebElement getAlreadyhaveanaccount() {
		return alreadyhaveanaccount;
	}

	public WebElement getAccountNumber() {
		return accountNumber;
	}

	public WebElement getSerivcelocationAddress() {
		return serivcelocationAddress;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getRegEmail() {
		return regEmail;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getRegisternowButton() {
		return registernowButton;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getUserRegistrationPage() {
		return userRegistrationPage;
	}

	public WebElement getNewuserRegistrationButton() {
		return newuserRegistrationButton;
	}

	public WebElement getBacktoLoginButton() {
		return backtoLoginButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getForgotpasswordEmail() {
		return forgotpasswordEmail;
	}

	public WebElement getForgotpassword() {
		return forgotpassword;
	}

	public WebElement getEyeicon() {
		return eyeicon;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}
	
	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}


	public WebElement getWelcomepage() {
		return welcomepage;
	}


	public WebElement getGeneratorportalLink() {
		return generatorportalLink;
	}


	public WebElement getTransportesettings() {
		return transportesettings;
	}


	public WebElement getUserprofileButton() {
		return userprofileButton;
	}
}
