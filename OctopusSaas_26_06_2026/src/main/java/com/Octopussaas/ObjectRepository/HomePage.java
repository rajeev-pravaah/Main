package com.Octopussaas.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h6[contains(text(),'Add New')]")
	private WebElement Addnewdd;
	@FindBy(xpath = "//li[contains(text(),'Generator')]")
	private WebElement Gen;
	@FindBy(xpath = "//h6[contains(text(),'Generator Management')]")
	private WebElement generatoemanag;
	@FindBy(xpath = "//img[@alt='User Avatar']")
	private WebElement userprofile;
	@FindBy(xpath = "//a[contains(text(),'Transporter Settings')]")
	private WebElement transporterSettings;
	@FindBy(xpath = "//a[text()='Billing Settings']")
	private WebElement billingSettings;
	

	public WebElement getTransporterSettings() {
		return transporterSettings;
	}
	public WebElement getUserprofile() {
		return userprofile;
	}
	public WebElement getGeneratoemanag() {
		return generatoemanag;
	}
	public WebElement getGen() {
		return Gen;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getAddnewdd() {
		return Addnewdd;
	}
	
	public void AddNew()
	{
		Addnewdd.click();
	}
	public void Generator()
	{
		Gen.click();
	}
	public WebElement getBillingSettings() {
		return billingSettings;
	}
	
	public void clickTransporterSettings() {
		// Try direct element first
		try {
			if (transporterSettings != null && transporterSettings.isDisplayed()) { transporterSettings.click(); return; }
		} catch (Exception e) { /* ignore and fallback */ }
		// Fallback: try to find any element containing 'transporter' text and click it
		try {
			List<WebElement> els = driver.findElements(By.xpath("//*[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'transporter')]"));
			for (WebElement el : els) {
				if (el.isDisplayed()) { el.click(); return; }
			}
		} catch (Exception e) { /* ignore */ }
		throw new NoSuchElementException("Transporter Settings element not found");
	}
	
	//Nagaveni
		@FindBy (xpath = "//button[@class='flex items-center gap-4 focus:outline-none']")
		private WebElement myProfile;
		@FindBy (xpath = "//a[contains (text(),'Transporter Settings')]")
		private WebElement transporterSetting;
		@FindBy (xpath = "//a[contains (text(),'My Settings')]")
		private WebElement mySettings;
		@FindBy (xpath = "//a[contains (text(),'Historical Data Manifest')]")
		private WebElement manifestSettingsElement;
		@FindBy (xpath = "//a[contains (text(),'Audit Log')]")
		private WebElement auditLog;
		@FindBy (xpath = "//button[contains (text(),'View TOS')]")
		private WebElement viewTos;
		@FindBy (xpath = "//button[contains (text(),'Logout')]")
		private WebElement logOut;
		@FindBy (xpath = "//input[@placeholder='First Name']")
		private WebElement firstName;
		@FindBy (xpath = "//input[@value='henry@test.com']")
		private WebElement email;
		@FindBy (xpath = "//input[@type='tel']")
		private WebElement phoneTextfield;
		@FindBy (xpath = "//input[@placeholder='Last Name']")
		private WebElement lastname;
		@FindBy (xpath = "//button[contains(text(),'Change Password')]")
		private WebElement password;
		@FindBy (xpath = "(//div[@role='combobox'])[2]")
		private WebElement notification;
		@FindBy (xpath = "(//div[@role='combobox'])[1]")
		private WebElement roles;
		@FindBy (xpath = "//div[@class='bg-white z-20 grid gap-2 rounded-cardRadii max-w-md p-4 w-full min-h-fit']")
		private WebElement changePassword;
		@FindBy (xpath = "//input[@id='undefined-ext']")
		private WebElement extField;
		@FindBy (xpath = "//li[contains (text(), 'Admin')]")
		private WebElement adminRole;
		@FindBy (xpath = "//li[contains (text(), 'OCTO Connect Contact')]")
		private WebElement octoConnectRole;
		@FindBy (xpath = "//li[contains (text(), 'Standard')]")
		private WebElement standardRole;
		@FindBy (xpath = "//li[contains (text(), 'OCTO Connect Request – New Partnership Opportunity')]")
		private WebElement octoConnectRequest;
		@FindBy (xpath = "//li[contains (text(), 'Service Overview')]")
		private WebElement serviceOverview;
		@FindBy (xpath = "//li[contains (text(), 'SSR – Response Received')]")
		private WebElement ssrService;
		@FindBy (xpath = "//li[contains (text(), 'New SSR – New Service Opportunity')]")
		private WebElement newSSRservice;
		@FindBy (xpath = "//li[contains (text(), 'Termination Request')]")
		private WebElement terminationRequest;

		
		public WebElement getTerminationRequest() {
			return terminationRequest;
		}
		public WebElement getNewSSRservice() {
			return newSSRservice;
		}
		public WebElement getSsrService() {
			return ssrService;
		}
		public WebElement getServiceOverview() {
			return serviceOverview;
		}
		public WebElement getOctoConnectRequest() {
			return octoConnectRequest;
		}
		public WebElement getStandardRole() {
			return standardRole;
		}
		public WebElement getOctoConnectRole() {
			return octoConnectRole;
		}
		public WebElement getAdminRole() {
			return adminRole;
		}
		public WebElement getExtField() {
			return extField;
		}
		public WebElement getPhoneTextfield() {
			return phoneTextfield;
		}
		public WebElement getChangePassword() {
			return changePassword;
		}
		public WebElement getRoles() {
			return roles;
		}
		public WebElement getNotification() {
			return notification;
		}
		public WebElement getPassword() {
			return password;
		}
		public WebElement getLastname() {
			return lastname;
		}
		public WebElement getEmail() {
			return email;
		}
		public WebElement getFirstName() {
			return firstName;
		}
		public WebElement getLogOut() {
			return logOut;
		}
		public WebElement getViewTos() {
			return viewTos;
		}
		public WebElement getAuditLog() {
			return auditLog;
		}
		public WebElement getManifestSettingsElement() {
			return manifestSettingsElement;
		}
		public WebElement getMySettings() {
			return mySettings;
		}
		public WebElement getTransporterSetting() {
			return transporterSetting;
		}
		public WebElement getMyProfile() {
			return myProfile;
		}
		
		public void Myprofile() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(30000);
			String text = transporterSetting.getText();
			System.out.println(text);
			String text1 = mySettings.getText();
			System.out.println(text1);
			String text2 = manifestSettingsElement.getText();
			System.out.println(text2);
			String text3 = auditLog.getText();
			System.out.println(text3);
			String text4 = viewTos.getText();
			System.out.println(text4);
			myProfile.click();
		}
		
		public void TransporterSettings() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act1 = new Actions(driver);
			act1.moveToElement(transporterSetting).click().perform();
			Thread.sleep(2000);
		}
		
		public void Mysettings() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act2 = new Actions(driver);
			act2.moveToElement(mySettings).click().perform();
			Thread.sleep(2000);
		}
		
		public void Auditlog() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act3 = new Actions(driver);
			act3.moveToElement(auditLog).click().perform();
			Thread.sleep(2000);
		}
		
		public void Historicalmanifest() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act4 = new Actions(driver);
			act4.moveToElement(manifestSettingsElement).click().perform();
			Thread.sleep(2000);
		}
		
		public void Logout() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act5 = new Actions(driver);
			act5.moveToElement(logOut).click().perform();
			Thread.sleep(2000);
		}
		
		public void ViewTos() throws InterruptedException
		{
			myProfile.click();
			Thread.sleep(2000);
			Actions act6 = new Actions(driver);
			act6.moveToElement(viewTos).click().perform();
			Thread.sleep(20000);
		}
		
		public void MysettingsProfile()
		{
			myProfile.click();
			Actions act2 = new Actions(driver);
			act2.moveToElement(mySettings).click().perform();
			String fistnameText = firstName.getText();
			System.out.println(fistnameText);
			String emailText = email.getText();
			System.out.println(emailText);
			String phoneText = phoneTextfield.getText();
			System.out.println(phoneText);
			String lastnameText = lastname.getText();
			System.out.println(lastnameText);
			String passwordText = password.getText();
			System.out.println(passwordText);
			String notificationText = notification.getText();
			System.out.println(notificationText);
			String rolesText = roles.getText();
			System.out.println(rolesText);
		}
		
		public void ChangePassword()
		{
			myProfile.click();
			Actions act2 = new Actions(driver);
			act2.moveToElement(mySettings).click().perform();
			password.click();
			WebElement popup = driver.findElement(By.xpath("//div[@class='bg-white z-20 grid gap-2 rounded-cardRadii max-w-md p-4 w-full min-h-fit']"));
		    Assert.assertTrue(popup.isDisplayed(), "Change password popup is  visible");	
		}
		
		public void RoleDropdown()
		{
			roles.click();
			WebElement popup = driver.findElement(By.xpath("//ul[@role='listbox']"));
		    Assert.assertTrue(popup.isDisplayed(), "Roles listbox is displayed");
		    WebElement roles1 = driver.findElement(By.xpath("//li[contains (text(), 'Admin')]") );
		    Assert.assertTrue(roles1.isDisplayed(), "Admin role is displayed");
		    WebElement roles2 = driver.findElement(By.xpath("//li[contains (text(), 'OCTO Connect Contact')]") );
		    Assert.assertTrue(roles2.isDisplayed(), "Octo connect role is displayed");
		    
		}
		
		public void NotificationDropdown()
		{
			notification.click();
			WebElement popup = driver.findElement(By.xpath("//ul[@role='listbox']"));
		    Assert.assertTrue(popup.isDisplayed(), "Notification listbox is displayed");
		    WebElement Service1 = driver.findElement(By.xpath("//li[contains (text(), 'OCTO Connect Request – New Partnership Opportunity')]") );
		    Assert.assertTrue(Service1.isDisplayed(), "OCTO Connect Request – New Partnership Opportunity service is displayed");
		    WebElement Service2 = driver.findElement(By.xpath("//li[contains (text(), 'Service Overview')]") );
		    Assert.assertTrue(Service2.isDisplayed(), "Service overview service is displayed");
		    WebElement Service3 = driver.findElement(By.xpath("//li[contains (text(), 'SSR – Response Received')]") );
		    Assert.assertTrue(Service3.isDisplayed(), "SSR service is displayed");
		    WebElement Service4 = driver.findElement(By.xpath("//li[contains (text(), 'New SSR – New Service Opportunity')]") );
		    Assert.assertTrue(Service4.isDisplayed(), " New SSR service is displayed");
		    WebElement Service5 = driver.findElement(By.xpath("//li[contains (text(), 'Termination Request')]") );
		    Assert.assertTrue(Service5.isDisplayed(), " Termination request service is displayed");
		 }
		
		public void Admin() throws InterruptedException
		{
			roles.click();
			Thread.sleep(1000);
			adminRole.click();
			adminRole.click();
		}
		
		public void OctoConnectContact() throws InterruptedException
		{
			roles.click();
			Thread.sleep(1000);
			octoConnectRole.click();
			octoConnectRole.click();	
		}
		
		public void Standard() throws InterruptedException
		{
			roles.click();
			Thread.sleep(1000);
			adminRole.click();
			Thread.sleep(1000);
			standardRole.click();
		}
		
		public void OctoConnectRequest() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			octoConnectRequest.click();
			octoConnectRequest.click();	
		}
		
		public void Serviceoverview() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			serviceOverview.click();
			serviceOverview.click();
		}
		
		public void SSRservice() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			ssrService.click();
			ssrService.click();
		}
		
		public void NewSSRservice() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			newSSRservice.click();
			newSSRservice.click();	
		}
		
		public void TerminationRequest() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			terminationRequest.click();
			terminationRequest.click();
		}
		
		public void MutipleService() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			octoConnectRequest.click();
			serviceOverview.click();
			ssrService.click();
			newSSRservice.click();
			terminationRequest.click();
			Thread.sleep(1000);
			octoConnectRequest.click();
			terminationRequest.click();

		}
		
		public void ServiceAtonce() throws InterruptedException
		{
			notification.click();
			Thread.sleep(2000);
			octoConnectRequest.click();
			serviceOverview.click();
			ssrService.click();
			newSSRservice.click();
			terminationRequest.click();
			Thread.sleep(2000);
			octoConnectRequest.click();
			serviceOverview.click();
			ssrService.click();
			newSSRservice.click();
			terminationRequest.click();	
		}

	

	
}