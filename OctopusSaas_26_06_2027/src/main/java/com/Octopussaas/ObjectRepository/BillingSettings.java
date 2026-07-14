package com.Octopussaas.ObjectRepository;

import java.util.List;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class BillingSettings {
	WebDriver driver;

	public BillingSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//h1[contains(normalize-space(),'Billing') or contains(normalize-space(),'Billing Settings')]")
	private WebElement BillingHeader;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement yeartoDateRevenue;
	@FindBy(xpath = "(//div[text()='2025']/ancestor::div[@class='flex items-center gap-2']/descendant::div)[2]")
	private WebElement year2025TextField;
	@FindBy(xpath = "//span[text()='Invoice #']/preceding-sibling::div")
	private WebElement invoiceCheckbox;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmButton;
	@FindBy(xpath = "//button[text()='Confirm']/ancestor::div[contains(@class,'flex')]//button[text()='✕'] | //button[text()='✕'][last()]")
	private WebElement closeButton;
	@FindBy(xpath = "//span[text()='Invoice Date']/preceding-sibling::div")
	private WebElement invoiceDateCheckbox;
	@FindBy(xpath = "//span[text()='Due Date']/preceding-sibling::div")
	private WebElement dueDateCheckbox;
	@FindBy(xpath = "//span[text()='Terms']/preceding-sibling::div")
	private WebElement termsCheckbox;
	@FindBy(xpath = "(//span[text()='Invoice Total']/preceding-sibling::div)[1]")
	private WebElement invoiceTotalCheckbox1;
	@FindBy(xpath = "(//span[text()='Bill To']/preceding-sibling::div)[1]")
	private WebElement billToCheckbox;
	@FindBy(xpath = "(//span[text()='Previous Balance']/preceding-sibling::div)[1]")
	private WebElement previousBalanceCheckbox;
	@FindBy(xpath = "(//span[text()='Autopay Status']/preceding-sibling::div)[1]")
	private WebElement autopayStatus;
	@FindBy(xpath = "(//span[text()='Last Payment']/preceding-sibling::div)[1]")
	private WebElement lastPaymentCheckbox;
	@FindBy(xpath = "(//span[text()='Overdue Total Notice']/preceding-sibling::div)[1]")
	private WebElement overdueTotalNoticeCheckbox;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement textfield2025;
	@FindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement textfield2024;
	@FindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement textfield2023;
	@FindBy(xpath = "(//input[@type='number'])[5]")
	private WebElement textfield2022;
	@FindBy(xpath = "(//input[@type='number'])[6]")
	private WebElement textfield2021;
	@FindBy(xpath = "(//input[@type='number'])[7]")
	private WebElement textfield2020;
	@FindBy(xpath = "(//input[@type='number'])[8]")
	private WebElement textfield2019;
	@FindBy(xpath = "(//input[@type='number'])[9]")
	private WebElement textfield2018;
	@FindBy(xpath = "(//input[@type='number'])[10]")
	private WebElement textfield2017;
	@FindBy(xpath = "(//input[@type='number'])[11]")
	private WebElement textfield2016;
	@FindBy(xpath = "(//span[text()='Account Number']/preceding-sibling::div)[1]")
	private WebElement accountNumberCheckbox;
	@FindBy(xpath = "(//span[text()='Generator Location Name']/preceding-sibling::div)[1]")
	private WebElement generatorLocationNameCheckbox;
	@FindBy(xpath = "(//span[text()='Generator Service Address']/preceding-sibling::div)[1]")
	private WebElement generatorServiceAddressCheckbox;
	@FindBy (xpath = "(//span[text()='Service Date']/preceding-sibling::div)[1]")
	private WebElement serviceDateCheckbox;
	@FindBy(xpath = "(//span[text()='Document ID']/preceding-sibling::div)[1]")
	private WebElement documentIDCheckbox;
	@FindBy(xpath = "(//span[text()='Description']/preceding-sibling::div)[1]")
	private WebElement descriptionChcekbox;
	@FindBy(xpath = "(//span[text()='Quantity']/preceding-sibling::div)[1]")
	private WebElement quantityChcekbox;
	@FindBy(xpath = "(//span[text()='Weight']/preceding-sibling::div)[1]")
	private WebElement weightcheckBox;
	@FindBy(xpath = "(//span[text()='Total']/preceding-sibling::div)[1]")
	private WebElement totalcheckbox;
	@FindBy(xpath = "(//span[text()='Taxes']/preceding-sibling::div)[1]")
	private WebElement taxesCheckbox;
	@FindBy(xpath = "(//span[text()='Subtotal']/preceding-sibling::div)[1]")
	private WebElement subtotalCheckbox;
	@FindBy(xpath = "(//span[text()='Rate']/preceding-sibling::div)[1]")
	private WebElement rateCheckbox;
	@FindBy(xpath = "(//span[text()='Discount']/preceding-sibling::div)[1]")
	private WebElement discountCheckbox;
	@FindBy(xpath = "(//span[text()='Invoice Total']/preceding-sibling::div)[2]")
	private WebElement invoiceTotalCheckbox2fromInvoicefooter;
	@FindBy(xpath = "(//span[text()='Aging Report']/preceding-sibling::div)[1]")
	private WebElement agingReportCheckbox;
	@FindBy(xpath = "(//span[text()='Payment Voucher']/preceding-sibling::div)[1]")
	private WebElement paymentVoucherCheckbox;
	@FindBy(xpath = "//div[@data-placeholder='Enter a message to display on all invoices']")
	private WebElement custominvoicemessageTextfield;
	@FindBy(xpath = "//h3[text()='Printing & Envelope Instructions']")
	private WebElement printingAndEnvelopeInstructionsHeader;
	@FindBy(xpath = "(//button[@type='button'])[8]")
	private WebElement paymenttermsdropdown;
	@FindBy(xpath = "//p[text()='+ Add Payment Type']")
	private WebElement addPaymentTypelink;
	@FindBy(xpath = "//div[@class='bg-white rounded-lg p-6 w-96 shadow-lg']")
	private WebElement addPaymentTypePopup;
	@FindBy(xpath = "//input[@placeholder='Enter payment type name']")
	private WebElement paymentTypeTextField;
	@FindBy(xpath = "(//button[text()='Cancel'])[3]")
	private WebElement cancelButtonfrompaymentTypePopup;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonfromPaymentTypePopup;
	@FindBy (xpath = "//div[@class='flex flex-wrap gap-6 pl-6']")
	private WebElement acceptedpaymentTypeListSection;
	@FindBy(xpath = "//span[text()='card']/../descendant::div")
	private WebElement cardCheckbox;
	@FindBy(xpath = "//div[@class='w-3 h-3 bg-white rounded-full']")
	private WebElement autoapplyecxessradiobtn;
	@FindBy(xpath = "(//div[@class='flex items-center rounded-lg  gap-3  cursor-pointer']/../descendant::div)[5]")
	private WebElement holdexcessPaymentasaccountcredit;
	@FindBy(xpath = "//span[text()='Electronic Billing (Email)']/preceding-sibling::div")
    private WebElement 	electronicBillingCheckbox;
	@FindBy(xpath = "//span[text()='Generator Portal Billing']/preceding-sibling::div")
	private WebElement generatorPortalBillingCheckbox;
	@FindBy(xpath = "//span[text()='Paper Billing']/preceding-sibling::div")
	private WebElement paperBillingCheckbox;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement replayToemailAddresstextfield;
	@FindBy(xpath = "//span[text()='OCTO Smart Manifest']/preceding-sibling::div")
	private WebElement octoSmartManifestCheckbox;
	@FindBy(xpath = "//span[text()='OCTO Delivery Receipts']/preceding-sibling::div")
	private WebElement octoDeliveryReceiptsCheckbox;
	@FindBy(xpath = "//span[text()='OCTO Shredding Service Document']/preceding-sibling::div")
	private WebElement octoShreddingServiceDocumentCheckbox;
	@FindBy(xpath = "//span[text()='Initial:']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div")
	private WebElement notificationfrequencyinitialCheckbox;
	@FindBy(xpath = "//div[text()='Subsequent:']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::div")
	private WebElement notificationfrequencySubsequentCheckbox;
	@FindBy(xpath = "//span[text()='Initial:']/following::input[1]")
	private WebElement notificationfrequencyinitialTextfield;
	@FindBy(xpath = "//span[text()='Subsequent:']/following::input[1]")
	private WebElement notificationfrequencySubsequentTextfield;
	@FindBy(xpath = "//span[text()='Invoice remainder email will be sent']/../descendant::input")
	private WebElement notificationfrequency1daystrxtfield;
	@FindBy(xpath = "//span[text()='The first overdue email is sent']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div")
	private WebElement firstoverdueEmailInitialCheckbox;
	@FindBy(xpath = "//div[text()='Reminders are sent at intervals of']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::div")
	private WebElement remindersentatintervalsSubsequentCheckbox;
	@FindBy(xpath = "//span[text()='The first overdue email is sent']/ancestor::div[@class='flex items-center gap-1 flex-wrap']/descendant::input")
	private WebElement thefirstoverdueemailSentInitialDaysTextfield;
	@FindBy(xpath = "(//div[text()='Reminders are sent at intervals of']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::input)[2]")
	private WebElement SecondremindersentatintervalsSubsequentDaysTextfield;
	@FindBy(xpath = "(//div[text()='Reminders are sent at intervals of']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::div)[11]")
	private WebElement SecondremindersentatintervalsSubsequentChckbox;
	@FindBy(xpath="//span[text()='Send payment confirmation emails']/../../descendant::div")
	private WebElement sendpaymentconfirmationemailsCheckbox;	
	@FindBy(xpath = "(//div[@class='flex items-center rounded-lg  gap-3 ']/descendant::div)[65]")
	private WebElement suspensiionsettingcheckbox;
	@FindBy(xpath = "(//div[@class='relative flex items-center  my-2 '])[2]")
	private WebElement automativsuspensionSettingsSectiondropdown;
	@FindBy(xpath = "//span[text()='Whenever the auto suspension terms have been met.']/../descendant::div")
	private WebElement suspensionofservicesnotificationCheckbox;
	@FindBy(xpath = "(//span[text()='Initial:'])[3]/../../descendant::div")
	private WebElement initialCheckboxfromsuspenssionsettings;
	@FindBy(xpath = "//span[text()='Subsequent:']/../../descendant::div")
	private WebElement subsequentCheckboxfromsuspenssionsettings;
	@FindBy(xpath = "//span[text()='Subsequent:']/../../descendant::input")
	private WebElement subsequentDaysTextfieldfromsuspenssionsettings;
	@FindBy(xpath = "//div[@class='mt-1']")
	private WebElement eventbillingradiobtn;
	@FindBy(xpath = "(//div[@class='mt-1'])[2]")
	private WebElement consolidatedmonthlyradiobtn;
	@FindBy(xpath = "(//div[@class='mt-1'])[3]")
	private WebElement flatmonthlyradiobtn;
	@FindBy(xpath = "//span[text()='Show Rate and Total']/../descendant::div")
	private WebElement showRateandTotalCheckbox;
	@FindBy(xpath = "//span[text()='Hide Rate and Total']/../descendant::div")
	private WebElement hideRateandTotalCheckbox;
	@FindBy(xpath = "//h6[text()='Add New']")
	private WebElement addNewDropdown;
	@FindBy(xpath = "//li[@role='option'] | //ul[@role='listbox']/li | //div[@role='option']")
	private List<WebElement> addNewDropdownOptions;
	@FindBy(xpath = "//div[@aria-label='Open feedback survey']")
	private WebElement feedbackbtn;
	@FindBy(xpath = "//span[text()='Tell us what you think']")
	private WebElement tellUsWhatYouThinkPopup;
	@FindBy(xpath = "//div[@title='Notifications']")
	private WebElement notificationsBellIcon;
	@FindBy(xpath = "//div[contains(@class,'notification') or contains(@id,'notification') or contains(@aria-label,'notification') or contains(@class,'Notification')]")
	private WebElement notificationPopup;
	@FindBy(xpath = "//div[@title='OCTO Info']")
	private WebElement octoInfoIcon;
	@FindBy(xpath = "//div[@class='relative']")
	private WebElement profileIcon;
	@FindBy(xpath = "//a[text()='My Settings']")
	private WebElement mySettingsOptionfromProfileDropdown;
	@FindBy(xpath = "//a[text()='Audit Log']")
	private WebElement auditLogOptionfromProfileDropdown;
	@FindBy(xpath = "//a[text()='Historical Data Manifest']")
	private WebElement historicalDataManifestOptionfromProfileDropdown;
	@FindBy(xpath = "//button[text()='View TOS']")
	private WebElement viewTOSButtonfromProfileDropdown;
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logoutButtonfromProfileDropdown;
	@FindBy(xpath = "//div[contains(text(),'Subsequent:')]/../descendant::input")
	private WebElement subsequent1DaysTextfieldfromNotificationSettings;
	@FindBy(xpath = "(//div[text()='Reminders are sent at intervals of']/ancestor::div[@class='pl-6 flex items-center gap-4 my-4']/descendant::div)[11]")
	private WebElement subsequentcheckboxremindersaresentcheckbox;
	@FindBy(xpath = "//button[text()='Add New Payment Method']")
	private WebElement addNewPaymentMethodButton;
	@FindBy(xpath = "(//button[text()='Add Card Details'])[1]")
	private WebElement addCardDetailsButton;
	@FindBy(xpath = "//label[contains(text(),'Name this payment method: (Last 4 Digits Of Credit Card / ACH Number) *')]")
	private WebElement nameThisPaymentMethodTextfield;
	@FindBy(xpath = "//input[@placeholder='Last 4 Digits Of Credit Card / ACH Number']")
	private WebElement last4DigitsOfCreditCardTextfield;
	@FindBy(xpath = "//label[text()='Account Holder Name *']/../descendant::input")
	private WebElement accountHolderNameTextfield;
	@FindBy(xpath = "(//div[@class='w-3 h-3 bg-white rounded-full'])[3]")
	private WebElement creditcardradiobtn;
	// Make Default radio button scoped to the 'Raju' payment card
	@FindBy(xpath = "//div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'border') and contains(@class,'rounded')]/descendant::input[@type='radio'] | //div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'p-4')]/descendant::input[@type='radio'] | //div[normalize-space(text())='Raju']/ancestor::div[contains(@class,'relative')]/descendant::input[@type='radio']")
	private WebElement makeDefaultRadioButtonRaju;
	public WebElement getMakeDefaultRadioButtonRaju() {
		return makeDefaultRadioButtonRaju;
	}
	
	
	@FindBy(xpath = "//span[text()='ACH']/../descendant::div")
	private WebElement achradiobtn;
	@FindBy(xpath = "//input[@placeholder='Enter CVV/CVC']")
	private WebElement cvvCvcTextfield;
	@FindBy(xpath = "//button[text()='Add Card Details']")
	private WebElement addCardDetailsButton2;
	@FindBy(xpath = "//label[text()='Credit Card Information']")
	private WebElement creditCardInformationHeader;
	@FindBy(xpath = "//input[@id='card-number-input']")
	private WebElement cardNumberTextfield;
	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	private WebElement expirationDateTextfield;
	@FindBy(xpath = "//input[@id='cvc-input']")
	private WebElement cvcTextfieldinframe;
	@FindBy(xpath = "//select[@id='country-input']")
	private WebElement countryDropdowninframe;
	@FindBy(xpath = "//input[@id='postal-code-input']")
	private WebElement postalCodeTextfieldinframe;
	@FindBy(xpath = "//button[.//span[text()='Save'] or normalize-space(text())='Save'] | //button[normalize-space()='Save']")
	private WebElement saveButtoninframe;
	@FindBy(xpath = "//h3[text()='Are you sure?']/../../descendant::button[text()='Delete'] | //h3[text()='Are you sure']/../../descendant::button[text()='Delete']")
	private WebElement deleteButtonforExistingCard;
	@FindBy(xpath = "(//button[text()='Delete'])[last()]")
	private WebElement deleteButtonforExistingCard2;
	@FindBy(xpath = "//div[contains(@class,'toast') and (contains(text(),'deleted') or contains(text(),'Deleted') or contains(text(),'removed') or contains(text(),'Removed') or contains(text(),'success') or contains(text(),'Success'))] | //div[@role='alert'][contains(text(),'deleted') or contains(text(),'removed') or contains(text(),'success')] | //span[contains(text(),'Payment method deleted') or contains(text(),'deleted successfully')]")
	private WebElement deleteConfirmationMessage;
	@FindBy(xpath = "//span[text()='Save']/../../descendant::button[text()='Cancel']")
	private WebElement cancelPaymentbutton;
	@FindBy(xpath = "//input[@id='field-_r_0_']")
	private WebElement accountholdersnameinACH;
	@FindBy(xpath = "//select[@id='field-_r_1_']")
	private WebElement accounttypedropdowninACH;
	@FindBy(xpath = "//button[text()='Provide bank account details']")
	private WebElement providebankaccountdetailsbuttoninACH;
	@FindBy(xpath = "//input[@id='instant']")
	private WebElement instantradiobutton;
	@FindBy(xpath = "//input[@name='routingNumber']")
	private WebElement routingnumbertextfieldinACHaccountdetails;
	@FindBy(xpath = "//input[@name='accountNumber']")
	private WebElement accountnumbertextfieldinACHaccountdetails;
	@FindBy(xpath = "//select[@name='accountSubType']")
	private WebElement accountSubTypeDropdowninACHaccountdetails;
	@FindBy(xpath = "//button[contains(text(),'Submit Bank Details')]")
	private WebElement submitBankDetailsButtoninACH;
	@FindBy(xpath = "//div[text()='Raju']/ancestor::div[@class='flex-1']/descendant::div[8]")
	private WebElement makedefault;
	
	
	
	public WebElement getSubmitBankDetailsButtoninACH() {
		return submitBankDetailsButtoninACH;
	}
	public WebElement getAccountSubTypeDropdowninACHaccountdetails() {
		return accountSubTypeDropdowninACHaccountdetails;
	}
	public WebElement getAccountnumbertextfieldinACHaccountdetails() {
		return accountnumbertextfieldinACHaccountdetails;
	}
	public WebElement getRoutingnumbertextfieldinACHaccountdetails() {
		return routingnumbertextfieldinACHaccountdetails;
	}
	public WebElement getInstantradiobutton() {
		return instantradiobutton;
	}
	public WebElement getProvidebankaccountdetailsbuttoninACH() {
		return providebankaccountdetailsbuttoninACH;
	}
	public WebElement getAccounttypedropdowninACH() {
		return accounttypedropdowninACH;
	}
	public WebElement getAccountholdersnameinACH() {
		return accountholdersnameinACH;
	}
	public WebElement getCancelPaymentbutton() {
		return cancelPaymentbutton;
	}
	public WebElement getDeleteButtonforExistingCard2() {
		return deleteButtonforExistingCard2;
	}
	public WebElement getDeleteButtonforExistingCard() {
		return deleteButtonforExistingCard;
	}
	public WebElement getDeleteConfirmationMessage() {
		return deleteConfirmationMessage;
	}
	public WebElement getSaveButtoninframe() {
		return saveButtoninframe;
	}
	public WebElement getPostalCodeTextfieldinframe() {
		return postalCodeTextfieldinframe;
	}
	public WebElement getCountryDropdowninframe() {
		return countryDropdowninframe;
	}
	public WebElement getCvcTextfieldinframe() {
		return cvcTextfieldinframe;
	}
	public WebElement getExpirationDateTextfield() {
		return expirationDateTextfield;
	}
	public WebElement getCardNumberTextfield() {
		return cardNumberTextfield;
	}
	public WebElement getCreditCardInformationHeader() {
		return creditCardInformationHeader;
	}
	public WebElement getAddCardDetailsButton2() {
		return addCardDetailsButton2;
	}
	public WebElement getCvvCvcTextfield() {
		return cvvCvcTextfield;
	}
	public WebElement getACHradiobtn() {
		return achradiobtn;
	}
	public WebElement getCreditcardradiobtn() {
		return creditcardradiobtn;
	}
	public WebElement getAccountHolderNameTextfield() {
		return accountHolderNameTextfield;
	}
	public WebElement getLast4DigitsOfCreditCardTextfield() {
		return last4DigitsOfCreditCardTextfield;
	}
	public WebElement getNameThisPaymentMethodTextfield() {
		return nameThisPaymentMethodTextfield;
	}
	public WebElement getAddCardDetailsButton() {
		return addCardDetailsButton;
	}
	public WebElement getAddNewPaymentMethodButton() {
		return addNewPaymentMethodButton;
	}
	public WebElement getSubsequentcheckboxremindersaresentcheckbox() {
		return subsequentcheckboxremindersaresentcheckbox;
	}
	public WebElement getSubsequent1DaysTextfieldfromNotificationSettings() {
		return subsequent1DaysTextfieldfromNotificationSettings;
	}
	public WebElement getLogoutButtonfromProfileDropdown() {
		return logoutButtonfromProfileDropdown;
	}
	public WebElement getViewTOSButtonfromProfileDropdown() {
		return viewTOSButtonfromProfileDropdown;
	}
	public WebElement getHistoricalDataManifestOptionfromProfileDropdown() {
		return historicalDataManifestOptionfromProfileDropdown;
	}
	public WebElement getAuditLogOptionfromProfileDropdown() {
		return auditLogOptionfromProfileDropdown;
	}
	public WebElement getMySettingsOptionfromProfileDropdown() {
		return mySettingsOptionfromProfileDropdown;
	}
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	public WebElement getOctoInfoIcon() {
		return octoInfoIcon;
	}
	public WebElement getNotificationsBellIcon() {
		return notificationsBellIcon;
	}
	public WebElement getNotificationPopup() {
		return notificationPopup;
	}
	public WebElement getFeedbackbtn() {
		return feedbackbtn;
	}
	public WebElement getAddNewDropdown() {
		return addNewDropdown;
	}
	public List<WebElement> getAddNewDropdownOptions() {
		return addNewDropdownOptions;
	}
	public WebElement getTellUsWhatYouThinkPopup() {
		return tellUsWhatYouThinkPopup;
	}
	public WebElement getHideRateandTotalCheckbox() {
		return hideRateandTotalCheckbox;
	}
	public WebElement getShowRateandTotalCheckbox() {
		return showRateandTotalCheckbox;
	}
	public WebElement getFlatmonthlyradiobtn() {
		return flatmonthlyradiobtn;
	}
	public WebElement getConsolidatedmonthlyradiobtn() {
		return consolidatedmonthlyradiobtn;
	}
	public WebElement getEventbillingradiobtn() {
		return eventbillingradiobtn;
	}
	public WebElement getSubsequentDaysTextfieldfromsuspenssionsettings() {
		return subsequentDaysTextfieldfromsuspenssionsettings;
	}
	public WebElement getSubsequentCheckboxfromsuspenssionsettings() {
		return subsequentCheckboxfromsuspenssionsettings;
	}
	public WebElement getInitialCheckboxfromsuspenssionsettings() {
		return initialCheckboxfromsuspenssionsettings;
	}
	public WebElement getSuspensionofservicesnotificationCheckbox() {
		return suspensionofservicesnotificationCheckbox;
	}
	public WebElement getAutomativsuspensionSettingsSectiondropdown() {
		return automativsuspensionSettingsSectiondropdown;
	}
	public WebElement getSuspensiionsettingcheckbox() {
		return suspensiionsettingcheckbox;
	}
	public WebElement getSendpaymentconfirmationemailsCheckbox() {
		return sendpaymentconfirmationemailsCheckbox;
	}
	public WebElement getSecondremindersentatintervalsSubsequentChckbox() {
		return SecondremindersentatintervalsSubsequentChckbox;
	}
	
	public WebElement getNotificationfrequencyinitialCheckbox() {
		return notificationfrequencyinitialCheckbox;
	}
	public WebElement getSecondremindersentatintervalsSubsequentDaysTextfield() {
		return SecondremindersentatintervalsSubsequentDaysTextfield;
	}
	
	
	public WebElement getThefirstoverdueemailSentInitialDaysTextfield() {
		return thefirstoverdueemailSentInitialDaysTextfield;
	}
	
	public WebElement getRemindersentatintervalsSubsequentCheckbox() {
		return remindersentatintervalsSubsequentCheckbox;
	}
	
	public WebElement getFirstoverdueEmailInitialCheckbox() {
		return firstoverdueEmailInitialCheckbox;
	}
	
	public WebElement getNotificationfrequency1daystrxtfield() {
		return notificationfrequency1daystrxtfield;
	}
	
	// By-locators for robust re-finding to avoid stale-element issues
    private By notificationfrequencyinitialCheckboxBy = By.xpath("//span[text()='Initial:']/ancestor::div[@class='pl-6 flex items-center gap-4']/descendant::div");
    private By notificationfrequencyinitialTextfieldBy = By.xpath("//span[text()='Initial:']/following::input[1]");
	
	public WebElement getNotificationfrequencySubsequentTextfield() {
		return notificationfrequencySubsequentTextfield;
	}
	public WebElement getNotificationfrequencyinitialTextfield() {
		return notificationfrequencyinitialTextfield;
	}
	
	public WebElement getNotificationfrequencySubsequentChcekBox() {
		return notificationfrequencySubsequentCheckbox;
	}
	
	public WebElement getNotificationfrequencyinitialCheckBox() {
		return notificationfrequencyinitialCheckbox;
	}
	
	public WebElement getOctoShreddingServiceDocumentCheckbox() {
		return octoShreddingServiceDocumentCheckbox;
	}
	
	public WebElement getOctoDeliveryReceiptsCheckbox() {
		return octoDeliveryReceiptsCheckbox;
	}
	public WebElement getOctoSmartManifestCheckbox() {
		return octoSmartManifestCheckbox;
	}
	public WebElement getReplayToemailAddresstextfield() {
		return replayToemailAddresstextfield;
	}
	public WebElement getPaperBillingCheckbox() {
		return paperBillingCheckbox;
	}
	
	public WebElement getGeneratorPortalBillingCheckbox() {
		return generatorPortalBillingCheckbox;
	}
	
	public WebElement getElectronicBillingCheckbox() {
		return electronicBillingCheckbox;
	}
	
	
	public WebElement getHoldexcessPaymentasaccountcredit() {
		return holdexcessPaymentasaccountcredit;
	}
	public WebElement getAutoapplyecxessradiobtn() {
		return autoapplyecxessradiobtn;
	}
	
	public WebElement getCardCheckbox() {
		return cardCheckbox;
	}
	public WebElement getAcceptedpaymentTypeListSection() {
		return acceptedpaymentTypeListSection;
	}
	public WebElement getSaveButtonfromPaymentTypePopup() {
		return saveButtonfromPaymentTypePopup;
	}
	public WebElement getCancelButtonfrompaymentTypePopup() {
		return cancelButtonfrompaymentTypePopup;
	}
	public WebElement getPaymentTypeTextField() {
		return paymentTypeTextField;
	}
	
	
	public WebElement getAddPaymentTypePopup() {
		return addPaymentTypePopup;
	}
	public WebElement getAddPaymentTypelink() {
		return addPaymentTypelink;
	}
	
	
	
	public WebElement getPaymenttermsdropdown() {
		return paymenttermsdropdown;
	}
	public WebElement getPrintingAndEnvelopeInstructionsHeader() {
		return printingAndEnvelopeInstructionsHeader;
	}
	public WebElement getCustominvoicemessageTextfield() {
		return custominvoicemessageTextfield;
	}
	public WebElement getPaymentVoucherCheckbox() {
		return paymentVoucherCheckbox;
	}
	public WebElement getAgingReportCheckbox() {
		return agingReportCheckbox;
	}
	public WebElement getInvoiceTotalCheckbox2fromInvoicefooter() {
		return invoiceTotalCheckbox2fromInvoicefooter;
	}
	public WebElement getDiscountCheckbox() {
		return discountCheckbox;
	}
	public WebElement getRateCheckbox() {
		return rateCheckbox;
	}
	public WebElement getSubtotalCheckbox() {
		return subtotalCheckbox;
	}
	public WebElement getTaxesCheckbox() {
		return taxesCheckbox;
	}
	public WebElement getTotalcheckbox() {
		return totalcheckbox;
	}
	public WebElement getWeightcheckBox() {
		return weightcheckBox;
	}
	public WebElement getQuantityChcekbox() {
		return quantityChcekbox;
	}
	public WebElement getDescriptionChcekbox() {
		return descriptionChcekbox;
	}
	public WebElement getDocumentIDCheckbox() {
		return documentIDCheckbox;
	}
	public WebElement getServiceDateCheckbox() {
		return serviceDateCheckbox;
	}
	public WebElement getGeneratorServiceAddressCheckbox() {
		return generatorServiceAddressCheckbox;
	}
	public WebElement getGeneratorLocationNameCheckbox() {
		return generatorLocationNameCheckbox;
	}
	public WebElement getAccountNumberCheckbox() {
		return accountNumberCheckbox;
	}
	public WebElement getTextfield2016() {
		return textfield2016;
	}
	public WebElement getTextfield2017() {
		return textfield2017;
	}
	public WebElement getTextfield2018() {
		return textfield2018;
	}
	public WebElement getTextfield2019() {
		return textfield2019;
	}
	public WebElement getTextfield2020() {
		return textfield2020;
	}
	public WebElement getTextfield2021() {
		return textfield2021;
	}
	public WebElement getTextfield2022() {
		return textfield2022;
	}
	public WebElement getTextfield2023() {
		return textfield2023;
	}
	public WebElement getTextfield2024() {
		return textfield2024;
	}
	public WebElement getTextfield2025() {
		return textfield2025;
	}
	public WebElement getOverdueTotalNoticeCheckbox() {
		return overdueTotalNoticeCheckbox;
	}
	public WebElement getLastPaymentCheckbox() {
		return lastPaymentCheckbox;
	}
	public WebElement getAutopayStatus() {
		return autopayStatus;
	}
	public WebElement getPreviousBalanceCheckbox() {
		return previousBalanceCheckbox;
	}
	public WebElement getBillToCheckbox() {
		return billToCheckbox;
	}
	public WebElement getInvoiceTotalCheckbox1() {
		return invoiceTotalCheckbox1;
	}
	public WebElement getTermsCheckbox() {
		return termsCheckbox;
	}
	public WebElement getDueDateCheckbox() {
		return dueDateCheckbox;
	}
	public WebElement getInvoiceDateCheckbox() {
		return invoiceDateCheckbox;
	}
	public WebElement getCloseButton() {
		return closeButton;
	}
	public WebElement getConfirmButton() {
		return confirmButton;
	}
	public WebElement getInvoiceCheckbox() {
		return invoiceCheckbox;
	}
	public WebElement getYear2025TextField() {
		return year2025TextField;
	}
	public WebElement getYeartoDateRevenue() {
		return yeartoDateRevenue;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getBillingHeader() {
		return BillingHeader;
	}
	
	// Dynamically find the Hard Close date element using several candidate XPaths with a wait.
	public WebElement getHardCloseDate() {
		List<By> candidates = Arrays.asList(
			By.xpath("//label[contains(normalize-space(),'Hard Close')]/following-sibling::*[1]"),
			By.xpath("//label[contains(normalize-space(),'Hard Close')]/following::input[1]"),
			By.xpath("//*[contains(normalize-space(),'Hard Close')]/following::div[1]"),
			By.xpath("//input[contains(@aria-label,'Hard Close') or contains(@placeholder,'Hard Close') or contains(@name,'hardClose')]")
		);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (By by : candidates) {
			try {
				// wait until at least one element located by this By is present
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				List<WebElement> els = driver.findElements(by);
				for (WebElement el : els) {
					if (el != null && el.isDisplayed()) {
						// ensure visibility
						wait.until(ExpectedConditions.elementToBeClickable(el));
						return el;
					}
				}
			} catch (Exception e) {
				// ignore and try next candidate
			}
		}
		// build helpful debug message
		StringBuilder sb = new StringBuilder();
		sb.append("Tried the following XPaths:\n");
		for (By b : candidates) sb.append(b.toString()).append("\n");
		throw new NoSuchElementException("Hard Close date element not found. " + sb.toString());
	}

	// Robust check for custom-styled checkbox state. Some UI checkbox widgets are divs
	// without a native checked property. This method examines several attributes
	// (aria-checked, class, and finally isSelected) to determine state.
	public boolean isNotificationfrequencyinitialChecked() {
		WebElement checkboxEl = null;
		try {
			checkboxEl = driver.findElement(notificationfrequencyinitialCheckboxBy);
		} catch (Exception e) {
			checkboxEl = notificationfrequencyinitialCheckbox; // fallback to PageFactory field
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(checkboxEl));
		} catch (Exception e) {
			// ignore
		}
		try {
			String aria = checkboxEl.getAttribute("aria-checked");
			if (aria != null) {
				if (aria.equalsIgnoreCase("true") || aria.equalsIgnoreCase("checked"))
					return true;
				if (aria.equalsIgnoreCase("false") || aria.equalsIgnoreCase("unchecked"))
					return false;
			}
		} catch (Exception e) {
			// ignore
		}
		try {
			String cls = checkboxEl.getAttribute("class");
			if (cls != null) {
				// common patterns for checked state in custom controls
				if (cls.contains("checked") || cls.contains("active") || cls.contains("bg-") || cls.contains("true") || cls.contains("selected"))
					return true;
				if (cls.contains("unchecked") || cls.contains("inactive") || cls.contains("false"))
					return false;
			}
		} catch (Exception e) {
			// ignore
		}
		try {
			// Fallback to isSelected (useful if element is an input)
			return checkboxEl.isSelected();
		} catch (Exception e) {
			// if everything fails, assume unchecked
			return false;
		}
	}

	// Click helper with fallback to JS click. Returns true if after the method
	// the checkbox appears checked.
	public boolean clickNotificationfrequencyinitialCheckbox() {
		WebElement checkboxEl = null;
		try {
			checkboxEl = driver.findElement(notificationfrequencyinitialCheckboxBy);
		} catch (Exception e) {
			checkboxEl = notificationfrequencyinitialCheckbox;
		}
		try {
			checkboxEl.click();
			Thread.sleep(300);
			if (isNotificationfrequencyinitialChecked()) return true;
		} catch (Exception e) {
			// ignore and try JS click
		}
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkboxEl);
			Thread.sleep(300);
		} catch (Exception e) {
			// ignore
		}
		return isNotificationfrequencyinitialChecked();
	}

    // Ensure the Initial notification checkbox reaches desired state (checked/unchecked).
    // Tries multiple strategies: normal click, JS click, waits for attribute/class change.
    public boolean ensureNotificationfrequencyinitialChecked(boolean wantChecked, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
         try {
            // try to find element each time to avoid stale element refs
            try { driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ignore) {}
         } catch (Exception e) {
             // ignore
         }
         // scroll into view to improve click reliability
         try {
            WebElement el = null;
            try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
         } catch (Exception e) {
             // ignore
         }
         int attempts = 0;
         while (attempts < 4) {
            boolean current = isNotificationfrequencyinitialChecked();
            if (current == wantChecked) {
                return true;
            }
            try {
                WebElement el = null;
                try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
                wait.until(ExpectedConditions.elementToBeClickable(el));
                el.click();
                Thread.sleep(300);
            } catch (Exception e) {
                try {
                    WebElement el = null;
                    try { el = driver.findElement(notificationfrequencyinitialCheckboxBy); } catch (Exception ex) { el = notificationfrequencyinitialCheckbox; }
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                    Thread.sleep(300);
                } catch (Exception ex) {
                    // ignore and continue to next attempt
                }
            }
            // small wait for DOM updates
            try { Thread.sleep(300); } catch (InterruptedException ie) { /* ignore */ }
            // if some frameworks change aria-checked or class, wait briefly for it
            try {
                wait.withTimeout(Duration.ofSeconds(1)).until(d -> isNotificationfrequencyinitialChecked() == wantChecked);
                return isNotificationfrequencyinitialChecked() == wantChecked;
            } catch (Exception e) {
                // not yet changed, continue
            }
            attempts++;
         }
         return isNotificationfrequencyinitialChecked() == wantChecked;
     }
 
 }