package com.Octopussaas.ObjectRepository;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TransporterSettingsUsers {
	WebDriver driver;

	public TransporterSettingsUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public WebDriver getDriver() {
		return driver;
	}
	@FindBy(xpath = "//span[text()='Add New User']")
	private WebElement AddNewUserButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement firstnameTextField;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;
	@FindBy(xpath = "//p[text()='First Name is required']")
	private WebElement firstNameErrorMessage;
	@FindBy(xpath = "//p[text()='Last Name is required']")
	private WebElement lastNameErrorMessage;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement lastNameTextField;
	@FindBy(xpath = "//p[text()='Email is required']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement emailTextField;
	@FindBy(xpath = "//p[text()='Please enter a valid email address']")
	private WebElement invalidEmailErrorMessage;
	@FindBy(xpath = "//input[@type='password' or @type='text'][preceding-sibling::*[contains(@class,'eye')] or following-sibling::button or parent::div[contains(@class,'password')] or @autocomplete='new-password' or @autocomplete='current-password' or @name='password']")
	private WebElement passwordTextField;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement maskedeyeicon;
	@FindBy(xpath = "//p[text()='Password must be at least 8 characters long']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath = "//p[text()='Password is required']")
	private WebElement passwordRequiredErrorMessage;
	@FindBy(xpath = "//span[text()='Select Role(s)']/ancestor::div[@role='button' or @tabindex or contains(@class,'select') or contains(@class,'dropdown')][1]")
	private WebElement selectRolesDropdown;
	@FindBy(xpath = "//ul[@role='listbox']//li[contains(.,'Admin')] | //*[@role='option' and contains(.,'Admin')] | //div[contains(@class,'option') and contains(text(),'Admin')] | //li[contains(@class,'item') and contains(text(),'Admin')]")
	private WebElement adminRoleOptionfromRolesDropdown;
	@FindBy(xpath = "//ul[@role='listbox']//li[contains(.,'Standard')] | //*[@role='option' and contains(.,'Standard')] | //div[contains(@class,'option') and contains(.,'Standard')] | //li[contains(@class,'item') and contains(.,'Standard')]")
	private WebElement standardRoleOptionfromRolesDropdown;
	@FindBy(xpath = "//p[text()='At least one role must be selected']")
	private WebElement atleastOneRoleMustBeSelectedfromRolesDropdown;
	@FindBy(xpath = "//ul[@role='listbox']//li[contains(.,'OCTO Connect Contact')] | //*[@role='option' and contains(.,'OCTO Connect Contact')] | //div[contains(@class,'option') and contains(.,'OCTO Connect Contact')] | //li[contains(@class,'item') and contains(.,'OCTO Connect Contact')]")
	private WebElement octoConnectContactRoleOptionfromRolesDropdown;
	@FindBy(xpath = "//p[text()='Admin users automatically have company-wide access to all data.']")
	private WebElement adminRoleOptionInfoMessage;
	@FindBy(xpath = "//p[text()='Role is required']")
	private WebElement roleRequiredErrorMessage;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	private WebElement phoneNumberTextField;
	@FindBy(xpath = "//p[text()='Phone number must be 10 digits']")
	private WebElement phoneNumberErrorMessage;
	@FindBy(xpath = "//input[@id='phoneNumber-ext']")
	private WebElement phoneNumberExtensionTextField;
	@FindBy(xpath = "//label[text()='Status*']")
	private WebElement statusLabel;
	@FindBy(xpath = "//div[@class='relative flex items-center  my-2 ']")
	private WebElement statusDropdown;
	@FindBy(xpath = "//div[text()='Inactive']")
	private WebElement statusInactiveOption;
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement accessleveldropdown;
	@FindBy(xpath = "//div[@class='flex items-center gap-2']")
	private List<WebElement> accessleveldropdownOptions;
	@FindBy(xpath = "//div[text()='Territory']")
	private WebElement territoryAccessLevelOption;
	@FindBy(xpath = "//div[contains(text(),'Company-wide') and contains(text(),'Full Access')]")
	private WebElement companyWideFullAccessOption;
	@FindBy(xpath = "//label[text()='Territories*']/../div")
	private WebElement territoriesDropdown;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> territoriesDropdownOptionsList;
	@FindBy(xpath = "//li[text()='local teritory']/descendant::input")
	private WebElement localTeritoryCheckbox;
	@FindBy(xpath = "(//label[text()='Territories*']/../div/descendant::div)[5]")
	private WebElement territoriesDropdownSearchBox;
	@FindBy(xpath = "//li[text()='Test Territory']/descendant::input")
	private WebElement testTerritoryCheckbox;
	@FindBy(xpath = "//label[text()='Territories*']/../descendant::button")
	private WebElement cancelTerritoriesDropdownButton;
	@FindBy(xpath = "//div[@class='mt-3 p-3 bg-blue-50 rounded-lg border border-blue-200']")
	private WebElement accesssummary;
	@FindBy(xpath = "//div[text()='Region']")
	private WebElement regionAccessLevelOptionfromaccesslevelDD;
	@FindBy(xpath = "//label[text()='Regions*']/../descendant::div")
	private WebElement regionsDropdown;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> regionsDropdownOptionsList;
	@FindBy(xpath = "(//label[text()='Regions*']/../descendant::div)[6]")
	private WebElement regionsDropdownSearchBox;
	@FindBy(xpath = "//li[text()='test region 1 (Test Territory)']/descendant::input")
	private WebElement testRegion1Checkbox;
	@FindBy(xpath = "//li[text()='test region (Test Territory)']/descendant::input")
	private WebElement testRegionCheckbox;
	@FindBy(xpath = "//label[text()='Regions*']/../descendant::button")
	private WebElement cancelRegionsDropdownButton;
	@FindBy(xpath = "//div[text()='Satellite']")
	private WebElement satelliteAccessLevelOption;
	@FindBy(xpath = "//label[text()='Satellites*']/../descendant::div")
	private WebElement satellitesDropdown;
	@FindBy(xpath = "(//label[text()='Satellites*']/../descendant::div)[6]")
	private WebElement satellitesDropdownSearchBox;
	@FindBy(xpath = "//li[@role='option']")
	private List<WebElement> satellitesDropdownOptionsList;
	@FindBy(xpath = "(//li[@role='option'])[1]/descendant::input")
	private WebElement satellite1stoption;
	@FindBy(xpath = "(//li[@role='option'])[2]/descendant::input")
	private WebElement satellite2ndoptioncheckbox;
	@FindBy(xpath = "//label[text()='Satellites*']/../descendant::button")
	private WebElement cancelSatellitesDropdownButton;
	@FindBy(xpath = "//p[text()='Select at least one satellite']")
	private WebElement selectAtleastOneSatelliteErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'min-w-fit')]//div[contains(text(),'@')]")
	private List<WebElement> emaillistfromusertable;
	@FindBy(xpath = "//h2[text()='Users List']")
	private WebElement usersListHeading;
	@FindBy(xpath = "//button[text()='View User List']")
	private WebElement viewUsersListButton;
	@FindBy(xpath = "//a[contains(@href,'/admin/users/edit')]/div[1]")
	private List<WebElement> userlistwithalldetails;
	@FindBy(xpath = "//a[contains(@href,'/admin/users/edit')]//div[contains(@title,'(')]")
	private List<WebElement> userwithaphonenumberlist;
	@FindBy(xpath = "//label[text()='Role*']/../descendant::div")
	private WebElement roleDropdown;
	@FindBy(xpath = "//div[contains(@class,'border-b')]/div[4]")
	private List<WebElement> rolelistfromuserlist;
	@FindBy(xpath = "//div[text()='Hierarchy Access']")
	private WebElement hierarchyAccessHeading;
	@FindBy(xpath = "//a[contains(@class,'items-center')]//div[contains(@class,'truncate')][5]")
	private List<WebElement> hierarchyAccesslistfromuserlist;
	@FindBy(xpath = "//a[contains(@class,'items-center')]//div[contains(@class,'truncate')][6]")
	private List<WebElement> userstatuslistfromuserlist;
	@FindBy(xpath = "//h6[text()='User Profile']")
	private WebElement userProfileHeading;
	@FindBy(xpath = "//div[@class='flex items-center py-4 px-8 border-b border-cardBorderCol']")
	private List<WebElement> userprofiledetailsfromuserprofilepage;
	@FindBy(xpath = "//span[text()='User Status']")
	private WebElement userStatusdropdown;
	@FindBy(xpath = "//div[@class='relative flex items-center gap-2 w-full']")
	private List<WebElement> userstatusdropdownoptions;
	@FindBy(xpath = "//div[@class='w-4 h-4 border rounded flex items-center justify-center border-gray-300 bg-white']")
	 private WebElement userStatusActiveOptioncheckbox;
	@FindBy(xpath = "//div[@data-testid='multiselect-dropdown']")
	private WebElement userStatusdd;
	@FindBy(xpath = "(//div[@class='w-4 h-4 border rounded flex items-center justify-center border-gray-300 bg-white'])[2]")
	private WebElement userStatusInactiveOptioncheckbox;
	
	
	
	
	
	public WebElement getUserStatusInactiveOptioncheckbox() {
		return userStatusInactiveOptioncheckbox;
	}
	public WebElement getUserStatusdd() {
		return userStatusdd;
	}
	public WebElement getUserStatusActiveOptioncheckbox() {
		return userStatusActiveOptioncheckbox;
	}
	public List<WebElement> getUserstatusdropdownoptions() {
		return userstatusdropdownoptions;
	}
	public WebElement getUserStatusdropdown() {
		return userStatusdropdown;
	}
	public List<WebElement> getUserprofiledetailsfromuserprofilepage() {
		return userprofiledetailsfromuserprofilepage;
	}
	public WebElement getUserProfileHeading() {
		return userProfileHeading;
	}
	public List<WebElement> getUserstatuslistfromuserlist() {
		return userstatuslistfromuserlist;
	}
	public List<WebElement> getHierarchyAccesslistfromuserlist() {
		return hierarchyAccesslistfromuserlist;
	}
	public WebElement getHierarchyAccessHeading() {
		return hierarchyAccessHeading;
	}
	public List<WebElement> getRolelistfromuserlist() {
		return rolelistfromuserlist;
	}
	public WebElement getRoleDropdown() {
		return roleDropdown;
	}
	
	
	public List<WebElement> getUserwithaphonenumberlist() {
		return userwithaphonenumberlist;
	}
	public List<WebElement> getUserlistwithalldetails() {
		return userlistwithalldetails;
	}
	public WebElement getViewUsersListButton() {
		return viewUsersListButton;
	}
	public WebElement getUsersListHeading() {
		return usersListHeading;
	}
	public List<WebElement> getEmaillistfromusertable() {
		return emaillistfromusertable;
	}
	public WebElement getSelectAtleastOneSatelliteErrorMessage() {
		return selectAtleastOneSatelliteErrorMessage;
	}
	public WebElement getCancelSatellitesDropdownButton() {
		return cancelSatellitesDropdownButton;
	}
	public WebElement getSatellite2ndoptioncheckbox() {
		return satellite2ndoptioncheckbox;
	}
	public WebElement getSatellite1stoption() {
		return satellite1stoption;
	}
	public List<WebElement> getSatellitesDropdownOptionsList() {
		return satellitesDropdownOptionsList;
	}
	public WebElement getSatellitesDropdownSearchBox() {
		return satellitesDropdownSearchBox;
	}
	public WebElement getSatellitesDropdown() {
		return satellitesDropdown;
	}
	public WebElement getSatelliteAccessLevelOption() {
		return satelliteAccessLevelOption;
	}
	public WebElement getCancelRegionsDropdownButton() {
		return cancelRegionsDropdownButton;
	}
	public WebElement getTestRegionCheckbox() {
		return testRegionCheckbox;
	}
	public WebElement getTestRegion1Checkbox() {
		return testRegion1Checkbox;
	}
	public WebElement getRegionsDropdownSearchBox() {
		return regionsDropdownSearchBox;
	}
	public List<WebElement> getRegionsDropdownOptionsList() {
		return regionsDropdownOptionsList;
	}
	public WebElement getRegionsDropdown() {
		return regionsDropdown;
	}
	public WebElement getRegionAccessLevelOptionfromaccesslevelDD() {
		return regionAccessLevelOptionfromaccesslevelDD;
	}
	public WebElement getAccesssummary() {
		return accesssummary;
	}
	public WebElement getCancelTerritoriesDropdownButton() {
		return cancelTerritoriesDropdownButton;
	}
	public WebElement getTestTerritoryCheckbox() {
		return testTerritoryCheckbox;
	}
	public WebElement getTerritoriesDropdownSearchBox() {
		return territoriesDropdownSearchBox;
	}
	public WebElement getLocalTeritoryCheckbox() {
		return localTeritoryCheckbox;
	}
	public List<WebElement> getTerritoriesDropdownOptionsList() {
		return territoriesDropdownOptionsList;
	}
	public WebElement getTerritoriesDropdown() {
		return territoriesDropdown;
	}
	public WebElement getCompanyWideFullAccessOption() {
		return companyWideFullAccessOption;
	}
	public WebElement getTerritoryAccessLevelOption() {
		return territoryAccessLevelOption;
	}
	public List<WebElement> getAccessleveldropdownOptions() {
		return accessleveldropdownOptions;
	}
	public WebElement getAccessleveldropdown() {
		return accessleveldropdown;
	}
	public WebElement getStatusInactiveOption() {
		return statusInactiveOption;
	}
	public WebElement getStatusDropdown() {
		return statusDropdown;
	}
	public WebElement getStatusLabel() {
		return statusLabel;
	}
	public WebElement getPhoneNumberExtensionTextField() {
		return phoneNumberExtensionTextField;
	}
	public WebElement getPhoneNumberErrorMessage() {
		return phoneNumberErrorMessage;
	}
	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}
	public WebElement getRoleRequiredErrorMessage() {
		return roleRequiredErrorMessage;
	}
	public WebElement getAdminRoleOptionInfoMessage() {
		return adminRoleOptionInfoMessage;
	}
	public WebElement getOctoConnectContactRoleOptionfromRolesDropdown() {
		return octoConnectContactRoleOptionfromRolesDropdown;
	}
	public WebElement getAtleastOneRoleMustBeSelectedfromRolesDropdown() {
		return atleastOneRoleMustBeSelectedfromRolesDropdown;
	}
	public WebElement getStandardRoleOptionfromRolesDropdown() {
		return standardRoleOptionfromRolesDropdown;
	}
	public WebElement getAdminRoleOptionfromRolesDropdown() {
		return adminRoleOptionfromRolesDropdown;
	}
	public WebElement getSelectRolesDropdown() {
		return selectRolesDropdown;
	}
	public WebElement getPasswordRequiredErrorMessage() {
		return passwordRequiredErrorMessage;
	}
	public WebElement getPasswordErrorMessage() {
		return passwordErrorMessage;
	}
	public WebElement getMaskedeyeicon() {
		return maskedeyeicon;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getInvalidEmailErrorMessage() {
		return invalidEmailErrorMessage;
	}
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	public WebElement getEmailErrorMessage() {
		return emailErrorMessage;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getLastNameErrorMessage() {
		return lastNameErrorMessage;
	}
	public WebElement getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}
	public WebElement getAddNewUserButton() {
		return AddNewUserButton;
	}
}
