package com.Octopussaas.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Octo365SignUP {
	WebDriver driver;

	public Octo365SignUP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "signup-email")
	private WebElement email;
	@FindBy(id = "signup-password")
	private WebElement pwd;
	@FindBy(id = "signup-confirmPassword")
	private WebElement conpwd;
	@FindBy(id = "signup-firstName")
	private WebElement fname;
	@FindBy(id = "signup-lastName")
	private WebElement lname;
	@FindBy(id = "signup-companyName")
	private WebElement compname;
	@FindBy(id = "signup-authorizationCode")
	private WebElement authcode;
	@FindBy(id = "//button[contains(@class,'bg-blue-500')]")
	private WebElement submitbtn;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement loginlnk;
	@FindBy(xpath = "//button[contains(text(),'ACCEPT')]")
	private WebElement aceptterms;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement termscheckbox;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelbtn;
	@FindBy(xpath = "//div[@class='modal-box']")
	private WebElement cancelcinfirmationPopup;
	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	private WebElement cancelconfirmationPopupCancelbtn;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement deleteicon;
	@FindBy(xpath = "//div[text()='companylogo.jpg']/following-sibling::div//button[1]")
	private WebElement editicon;
	@FindBy(xpath = "//div[@target='_blank']")
	private WebElement comapanylogotext;
	@FindBy(xpath = "//button[@type='button']/../../descendant::div")
	private WebElement companylogotext;
	
	public WebElement getCompanylogotext() {
		return companylogotext;
	}
	
	public WebElement getComapanylogotext() {
		return comapanylogotext;
	}
	
	public WebElement getEditicon() {
		return editicon;
	}
	
	public WebElement getDeleteicon() {
		return deleteicon;
	}
	
	public WebElement getCancelconfirmationPopupCancelbtn() {
		return cancelconfirmationPopupCancelbtn;
	}
	
	public WebElement getCancelcinfirmationPopup() {
		return cancelcinfirmationPopup;
	}
	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getTermscheckbox() {
		return termscheckbox;
	}
	public WebElement getAceptterms() {
		return aceptterms;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getConpwd() {
		return conpwd;
	}
	public WebElement getFname() {
		return fname;
	}
	public WebElement getLname() {
		return lname;
	}
	public WebElement getCompname() {
		return compname;
	}
	public WebElement getAuthcode() {
		return authcode;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public WebElement getLoginlnk() {
		return loginlnk;
	}
	
	public void EmailTextField(String Enter_emailId)
	{
		email.sendKeys(Enter_emailId);
	}
	public void PasswordTextField(String Enter_pwswd)
	{
		pwd.sendKeys(Enter_pwswd);
	}
	public void ConFirmPwdTextField(String Enter_Conpwd)
	{
		conpwd.sendKeys(Enter_Conpwd);
	}
	public void FirstnameTextField(String Enter_firstname)
	{
		fname.sendKeys(Enter_firstname);
	}
	public void LastNameTextField(String Enter_lastname)
	{
		lname.sendKeys(Enter_lastname);
	}
	public void CompanyName(String Enter_cpmanyname)
	{
		compname.sendKeys(Enter_cpmanyname);
	}
	public void AuthorizationCode(int Enter_authcode)
	{
		 authcode.sendKeys(String.valueOf(Enter_authcode));
	}
	public void SignUpBtn()
	{
		 driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

		
	}
	public void CheckBox()
	{
		termscheckbox.click();
		
	}
	public void AcceptTerms()
	{
		aceptterms.click();

	}

}
