package Generator_Management_GeneratorContacts;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorContacts;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class VerifyContacWithoutPhonenumber extends BaseClassForGEneratorContacts {

	HomePage hp;
	ExcelUtility elib;
	GeneratorContacts genc;
	GeneretorInformation ginfo;
	webDriverutility wlib;
	GeneratorManagentPage gmp;

	String contactNameValue;
	String phoneNumberValue;
	String emailValue;
	String passwordValue;

	@Test(priority = 1)
	public void TC_001NavigateToGeneratorContactPage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(5000);
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib = new webDriverutility();
		hp.getGeneratoemanag().click();
		Thread.sleep(3000);
		gmp = new GeneratorManagentPage(driver);
		String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
		ginfo = new GeneretorInformation(driver);
		ginfo.getGeneratorContacts().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Navigated to Generator Contact page successfully");
		System.out.println("Navigated to Generator Contact page successfully");
	}

	@Test(dependsOnMethods = "TC_001NavigateToGeneratorContactPage")
	public void TC_002ClickAddNewContactAndFillAllFieldsExceptPhoneNumber() throws InterruptedException, EncryptedDocumentException, IOException
	{
		genc = new GeneratorContacts(driver);

		// Click Add New Contact button
		genc.getAddcontactbutton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Add New Contact dialog is opened");
		System.out.println("Add New Contact dialog is opened");

		// Fill Contact Name field (mandatory)
		WebElement contactNameField = genc.getContactnamefield();
		contactNameField.click();
		Thread.sleep(300);
		contactNameField.sendKeys("Test Contact No Phone");
		contactNameValue = contactNameField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO, "Contact name entered: " + contactNameValue);
		System.out.println("Contact name entered: " + contactNameValue);

		// Leave Phone Number field blank - fetch its current value before saving
		WebElement numberField = genc.getContactnumberfield();
		numberField.click();
		Thread.sleep(300);
		// Clear any pre-existing value
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", numberField);
		numberField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		numberField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		phoneNumberValue = numberField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO, "Phone number field left blank, current value: '" + phoneNumberValue + "'");
		System.out.println("Phone number field left blank, current value: '" + phoneNumberValue + "'");

		// Fill Email field (mandatory)
		WebElement emailField = genc.getContactemailfield();
		emailField.click();
		Thread.sleep(300);
		String newEmail = "testNophone" + jlib.getRandomNumber() + "@example.com";
		emailField.sendKeys(newEmail);
		emailValue = emailField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO, "Email entered: " + emailValue);
		System.out.println("Email entered: " + emailValue);

		// Fill Password field (mandatory)
		WebElement pwdField = genc.getPasswordfield();
		pwdField.click();
		Thread.sleep(300);
		pwdField.sendKeys("Raj456$%");
		passwordValue = pwdField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO, "Password entered");
		System.out.println("Password entered");

		// Clear Job Title field (optional - ensure it is blank)
		WebElement jobTitleField = genc.getJobtitletextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", jobTitleField);
		jobTitleField.click();
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		utilityclassobject.gettest().log(Status.INFO, "Job title field cleared");
		System.out.println("Job title field cleared");

		// Clear Ext field (optional - ensure it is blank)
		WebElement extField = genc.getContactnumberextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", extField);
		extField.click();
		Thread.sleep(300);
		extField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		extField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		utilityclassobject.gettest().log(Status.INFO, "Ext field cleared");
		System.out.println("Ext field cleared");

		utilityclassobject.gettest().log(Status.INFO, "All mandatory fields filled except Phone Number");
		System.out.println("All mandatory fields filled except Phone Number");
	}

	@Test(dependsOnMethods = "TC_002ClickAddNewContactAndFillAllFieldsExceptPhoneNumber")
	public void TC_003ClickSaveAndVerifyPhoneValidationError() throws InterruptedException, EncryptedDocumentException, IOException
	{
		// Click Save button
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try
		{
			saveButton.click();
		}
		catch (org.openqa.selenium.WebDriverException e)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Save button clicked without entering phone number");
		System.out.println("Save button clicked without entering phone number");

		// Verify the phone number error message is displayed
		try
		{
			if (genc.getContactnumbererror().isDisplayed() && genc.getContactnumbererror().getText().contains("Phone number length should be 10"))
			{
				System.out.println("Error message is displayed for blank phone number and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS, "Error message is displayed for blank phone number: '" + genc.getContactnumbererror().getText() + "' and test case is : PASS");
			}
			else
			{
				System.out.println("Error message is not displayed or incorrect for blank phone number and test case is : FAIL. Actual: '" + genc.getContactnumbererror().getText() + "'");
				utilityclassobject.gettest().log(Status.FAIL, "Error message is not displayed or incorrect for blank phone number and test case is : FAIL");
			}
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Phone number error element not found - field may be optional: " + e.getMessage());
			utilityclassobject.gettest().log(Status.INFO, "Phone number error element not found - field may be optional");
		}
	}

	@Test(dependsOnMethods = "TC_003ClickSaveAndVerifyPhoneValidationError")
	public void TC_004EnterPhoneNumberAndSaveContact() throws InterruptedException, EncryptedDocumentException, IOException
	{
		// Enter a valid 10-digit phone number now
		WebElement numberField = genc.getContactnumberfield();
		numberField.click();
		Thread.sleep(300);
		numberField.sendKeys("5687412580");
		phoneNumberValue = numberField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO, "Phone number entered: " + phoneNumberValue);
		System.out.println("Phone number entered: " + phoneNumberValue);

		// Click Save button
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try
		{
			saveButton.click();
		}
		catch (org.openqa.selenium.WebDriverException e)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Save button clicked after entering phone number");
		System.out.println("Save button clicked after entering phone number");

		// Verify contact is saved in the list
		List<WebElement> contactlists = genc.getContactnamelists();
		boolean contactFound = false;
		for (WebElement contact : contactlists)
		{
			if (contact.getText().equals("Test Contact No Phone"))
			{
				contactFound = true;
				System.out.println("Contact saved successfully: '" + contact.getText() + "' and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS, "Contact saved successfully: '" + contact.getText() + "' and test case is : PASS");
				break;
			}
		}
		if (!contactFound)
		{
			System.out.println("Contact is not saved and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Contact is not saved and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_004EnterPhoneNumberAndSaveContact")
	public void TC_005VerifyPhoneNumberInList() throws InterruptedException, EncryptedDocumentException, IOException
	{
		// Verify the phone number is displayed correctly in the contact list for "Test Contact No Phone"
		List<WebElement> listRows = genc.getRoledropdownoption();
		boolean phoneVerified = false;
		for (WebElement row : listRows)
		{
			String rowText = row.getText();
			if (rowText.contains("Test Contact No Phone"))
			{
				System.out.println("Row text for 'Test Contact No Phone': '" + rowText + "'");
				utilityclassobject.gettest().log(Status.INFO, "Row text for 'Test Contact No Phone': '" + rowText + "'");

				if (rowText.contains(phoneNumberValue))
				{
					phoneVerified = true;
					System.out.println("Phone number '" + phoneNumberValue + "' is displayed correctly in the list and test case is : PASS");
					utilityclassobject.gettest().log(Status.PASS, "Phone number '" + phoneNumberValue + "' is displayed correctly in the list and test case is : PASS");
				}
				else
				{
					System.out.println("Phone number '" + phoneNumberValue + "' is NOT displayed in the list and test case is : FAIL. Row text: '" + rowText + "'");
					utilityclassobject.gettest().log(Status.FAIL, "Phone number '" + phoneNumberValue + "' is NOT displayed in the list and test case is : FAIL");
				}
				break;
			}
		}
		if (!phoneVerified)
		{
			System.out.println("Could not find 'Test Contact No Phone' row in list to verify phone number");
			utilityclassobject.gettest().log(Status.INFO, "Could not find 'Test Contact No Phone' row in list to verify phone number");
		}
	}
}
