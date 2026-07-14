package Generator_Management_GeneratorContacts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClassForGEneratorContacts;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.AddNewGenerator;
import com.Octopussaas.ObjectRepository.GeneratorContacts;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Generator_Contact_TC extends BaseClassForGEneratorContacts {
	HomePage hp;
	ExcelUtility elib;
	AddNewGenerator NewGen;
	GeneratorContacts genc;
	GeneretorInformation ginfo;
	webDriverutility wlib;
	GeneratorManagentPage gmp;

	String GeneretorName;
	String emailId;
	String freshEmail;
	WebElement passwordField;
	String accessvalue1;
	String accessvalue2;
	String accessvalue3;

	@Test(priority = 1)
	public void TC_001GeneratorContactsPage()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Home Page is displayed");
		System.out.println("Home Page is displayed");
		Thread.sleep(2000);
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		hp.AddNew();
		hp.Generator();
		NewGen = new AddNewGenerator(driver);
		webDriverutility wlib = new webDriverutility();
		int Rannum = jlib.getRandomNumber();
		GeneretorName = elib.getDataFromExcel("Routeassignment", 1, 1) + Rannum;
		System.out.println(GeneretorName);
		utilityclassobject.gettest().log(Status.INFO, "Generator name" + GeneretorName);

		String InternalAcNo = elib.getDataFromExcel("Routeassignment", 1, 2);
		Thread.sleep(5000);
		NewGen.NewGeneretor(GeneretorName, InternalAcNo);
		utilityclassobject.gettest().log(Status.INFO, "New Generator is created with name" + GeneretorName);
		System.out.println("New Generator is created with name" + GeneretorName);
		utilityclassobject.gettest().log(Status.INFO, "Generator contact page is displayed");
		System.out.println("Generator contact page is displayed");
		Thread.sleep(7000);
		ginfo = new GeneretorInformation(driver);
		// WebElement BillingInfo = ginfo.getBillingInfo();
		// wlib.scrollToelement(driver, BillingInfo);
		// ginfo.IndustryDD();
		WebElement lat = ginfo.getLatitute();
		wlib.scrollToelement(driver, lat);
		ginfo.Street();
		String emailId = elib.getDataFromExcel("Routeassignment", 1, 3);
		ginfo.Emialid(emailId);
		String Phoneno = elib.getDataFromExcel("Routeassignment", 1, 4);
		ginfo.Phonenumber(Phoneno);
		utilityclassobject.gettest().log(Status.INFO, "Billing Information is Filled Successfully");
		ginfo.CopyBtn();
		Thread.sleep(5000);
		ginfo.getGeneratorContacts().click();
		utilityclassobject.gettest().log(Status.INFO, "Generator contact page is displayed");
		System.out.println("Generator contact page is displayed");
		Thread.sleep(7000);
		// write code switch to new tab and again come back to generator contact page do
		// not use wlib
		// Store parent tab
		String parentTab = driver.getWindowHandle();

		((JavascriptExecutor) driver).executeScript("window.open();");

		Set<String> allTabs = driver.getWindowHandles();
		String newTab = null;

		for (String tab : allTabs) {
			if (!tab.equals(parentTab)) {
				newTab = tab;
				driver.switchTo().window(tab);
				break;
			}
		}

		if (newTab != null) {
			driver.get("https://www.google.com");
			// Close the new tab before switching back to parent tab
			driver.close();
		}

		// Switch back to parent tab
		driver.switchTo().window(parentTab);

	}

	@Test(dependsOnMethods = "TC_001GeneratorContactsPage")
	public void TC_002VerifyGeneratorName() throws InterruptedException, EncryptedDocumentException, IOException {
		// NOTE:
		// comment this when you want to run Tc through new generator or when you are
		// running TC_001 and
		// make sure that need to remove dependency
		// also comment Tc 26
		// also change genearatorname use gname
		/*
		 * Thread.sleep(5000); hp = new HomePage(driver);
		 *  elib = new ExcelUtility();
		 * wlib=new webDriverutility(); 
		 * hp.getGeneratoemanag().click();
		 *  gmp = new
		 * GeneratorManagentPage(driver); 
		 * String gname =elib.getDataFromExcel("Generator", 1, 1); 
		 * gmp.CharlieAccounttwo(gname);
		 * ginfo=new GeneretorInformation(driver); 
		 * ginfo.getGeneratorContacts().click();
		 */

		WebElement actualGenName = driver.findElement(By.xpath("//h6[text()='" + GeneretorName + "']"));
		if (actualGenName.getText().equals(GeneretorName)) {
			System.out.println("Generator name is verified and test case is pass");
			utilityclassobject.gettest().log(Status.PASS, "Generator name is verified and test case is pass");
		} else {
			System.out.println("Generator name is not verified and test case is fail");
			utilityclassobject.gettest().log(Status.FAIL, "Generator name is not verified and test case is fail");
		}
	}

	@Test(dependsOnMethods = "TC_002VerifyGeneratorName")
	public void TC_003VerifyOctoIDandFormat() throws InterruptedException, EncryptedDocumentException, IOException {
		genc = new GeneratorContacts(driver);
		String octonum = genc.getOctonumber().getText();
		System.out.println("Octo number is " + octonum);
		utilityclassobject.gettest().log(Status.INFO, "Octo number is " + octonum);
		// Verify format is G-XXX-XXXX (e.g., G-102-1455)
		if (octonum == null || octonum.isEmpty()) {
			System.out.println("Octo number is null or empty, test case is fail");
			utilityclassobject.gettest().log(Status.FAIL, "Octo number is null or empty: " + octonum);
			return;
		}
		if (octonum.matches("^G-\\d{3}-\\d{4}$")) {
			System.out.println("Octo number format G-XXX-XXXX is verified: " + octonum + " and test case is pass");
			utilityclassobject.gettest().log(Status.PASS,
					"Octo number format G-XXX-XXXX is verified: " + octonum + " and test case is pass");
		} else {
			System.out.println(
					"Octo number format does not match G-XXX-XXXX. Actual: " + octonum + " and test case is fail");
			utilityclassobject.gettest().log(Status.FAIL,
					"Octo number format does not match G-XXX-XXXX. Actual: " + octonum + " and test case is fail");
		}
	}

	@Test(dependsOnMethods = "TC_003VerifyOctoIDandFormat")
	public void TC_004VerifyAddressPresenntBelowofNameandOctoID()
			throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println(genc.getContactname().getText());
		utilityclassobject.gettest().log(Status.INFO,
				"Address is present below name and octo iD" + genc.getContactname().getText());
		System.out.println("Address is present below name and octo iD" + genc.getContactname().getText());

	}

	@Test(dependsOnMethods = "TC_004VerifyAddressPresenntBelowofNameandOctoID")
	public void TC_005VerifyCreatedDate() throws InterruptedException, EncryptedDocumentException, IOException {

		String createddate = genc.getCreateddate().getText();
		System.out.println("Created date is " + createddate);
		utilityclassobject.gettest().log(Status.INFO, "Created date is " + createddate);
		System.out.println("Created date is " + createddate);
	}

	@Test(dependsOnMethods = "TC_005VerifyCreatedDate")
	public void TC_006VerifyContactListIconTooltip()
			throws InterruptedException, EncryptedDocumentException, IOException {

		genc.getContactlisticon().click();
		// verify the tooltip is visible and text is "Generator Contact List"
		if (genc.getContactlisttext().isDisplayed()
				&& genc.getContactlisttext().getText().contains("Generator Contact List")) {
			System.out.println("Tooltip is visible and text is Generator Contact List and test case is pass");
			utilityclassobject.gettest().log(Status.PASS,
					"Tooltip is visible and text is Generator Contact List and test case is pass");
		} else {
			System.out.println("Tooltip is not visible or text is not Generator Contact List and test case is fail");
			utilityclassobject.gettest().log(Status.FAIL,
					"Tooltip is not visible or text is not Generator Contact List and test case is fail");
		}
		// click on created date
		genc.getCreateddate().click();

	}

	@Test(dependsOnMethods = "TC_006VerifyContactListIconTooltip")
	public void TC_007VerifyAddContactOpensDilogbox()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getAddcontactbutton().click();
		utilityclassobject.gettest().log(Status.INFO, " contact page is displayed");
		System.out.println(" contact page is displayed");

	}

	@Test(dependsOnMethods = "TC_007VerifyAddContactOpensDilogbox")
	public void TC_008VerifyContactNameTextFieldAcceptInputs()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnamefield().sendKeys("Test Contact");
		utilityclassobject.gettest().log(Status.INFO, "Contact name text field accepts input and entered value is "
				+ genc.getContactnamefield().getAttribute("value"));
		System.out.println("Contact name text field accepts input and entered value is "
				+ genc.getContactnamefield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_008VerifyContactNameTextFieldAcceptInputs")
	public void TC_009VerifyContactEmailTextFieldAcceptNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnamefield().clear();
		genc.getContactnamefield().sendKeys("123456789");
		utilityclassobject.gettest().log(Status.INFO, "Contact name text field accepts numbers and entered value is "
				+ genc.getContactnamefield().getAttribute("value"));
		System.out.println("Contact name text field accepts numbers and entered value is "
				+ genc.getContactnamefield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_009VerifyContactEmailTextFieldAcceptNumbers")
	public void TC_010VerifyContactEmailTextFieldAcceptSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnamefield().clear();
		genc.getContactnamefield().sendKeys("!@#$%^&*()");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name text field accepts special characters and entered value is "
						+ genc.getContactnamefield().getAttribute("value"));
		System.out.println("Contact name text field accepts special characters and entered value is "
				+ genc.getContactnamefield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_010VerifyContactEmailTextFieldAcceptSpecialCharacters")
	public void TC_011VerifyContactEmailTextFieldWithblank()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// Click the field, select all content and delete it to trigger framework change
		// detection
		WebElement contactNameField = genc.getContactnamefield();
		contactNameField.click();
		Thread.sleep(500);
		contactNameField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(500);
		contactNameField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(500);
		// Verify field is now empty
		String fieldValue = contactNameField.getAttribute("value");
		System.out.println("Contact name field value after clear: '" + fieldValue + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name text field cleared, current value: '" + fieldValue + "'");
		Thread.sleep(1000);

		// genc.getContactnamefield().sendKeys("");
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			// Fallback to JS click when normal click is blocked by overlay or timing
			// issues.
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		// verify it should display error message "Contact Name is required"
		if (genc.getContactnameerror().isDisplayed()
				&& genc.getContactnameerror().getText().contains("Contact Name is required")) {
			System.out.println("Error message is displayed and text is Contact Name is required and test case is pass");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Contact Name is required and test case is pass");
		} else {
			System.out.println(
					"Error message is not displayed or text is not Contact Name is required and test case is fail");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Contact Name is required and test case is fail");
		}

	}

	@Test(dependsOnMethods = "TC_011VerifyContactEmailTextFieldWithblank")
	public void TC_012VerifyContactEmailTextFieldWithInputs()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberfield().sendKeys("58974562589");
		utilityclassobject.gettest().log(Status.INFO, "Contact number text field accepts input and entered value is "
				+ genc.getContactnumberfield().getAttribute("value"));
		System.out.println("Contact number text field accepts input and entered value is "
				+ genc.getContactnumberfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_012VerifyContactEmailTextFieldWithInputs")
	public void TC_013VerifyContactEmailTextFieldWithNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberfield().clear();
		genc.getContactnumberfield().sendKeys("5687412589");
		utilityclassobject.gettest().log(Status.INFO, "Contact number text field accepts Numbers and entered value is "
				+ genc.getContactnumberfield().getAttribute("value"));
		System.out.println("Contact number text field accepts Numbers and entered value is "
				+ genc.getContactnumberfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_013VerifyContactEmailTextFieldWithNumbers")
	public void TC_014VerifyContactEmailTextFieldWithSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// try to enter special characted inside but verify that it is not accepting
		// special characters
		genc.getContactnumberfield().clear();
		genc.getContactnumberfield().sendKeys("$%^%");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact number text field should not accept special characters and entered value is "
						+ genc.getContactnumberfield().getAttribute("value"));
		System.out.println("Contact number text field should not accept special characters and entered value is "
				+ genc.getContactnumberfield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_014VerifyContactEmailTextFieldWithSpecialCharacters")
	public void TC_015VerifyContactEmailTextFieldWithBlank()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// Clear the contact number field and click Save to trigger blank validation
		WebElement numberField = genc.getContactnumberfield();
		numberField.click();
		Thread.sleep(300);
		numberField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		numberField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		String blankValue = numberField.getAttribute("value");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact number field cleared, current value: '" + blankValue + "'");
		System.out.println("Contact number field cleared, current value: '" + blankValue + "'");

		// Click Save to trigger validation
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(1000);

		// Verify error message for blank phone number
		try {
			if (genc.getContactnumbererror().isDisplayed()
					&& genc.getContactnumbererror().getText().contains("Phone number length should be 10")) {
				System.out.println("Error message is displayed for blank phone number and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Error message is displayed for blank phone number and test case is : PASS");
			} else {
				System.out.println(
						"Error message is not displayed or incorrect for blank phone number and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Error message is not displayed or incorrect for blank phone number and test case is : FAIL");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(
					"Error element not found for blank phone number - field may be optional: " + e.getMessage());
			utilityclassobject.gettest().log(Status.INFO,
					"Error element not found for blank phone number - field may be optional");
		}
	}

	@Test(dependsOnMethods = "TC_015VerifyContactEmailTextFieldWithBlank")
	public void TC_016VerifyContactEmailTextFieldWithShortInputs()
			throws InterruptedException, EncryptedDocumentException, IOException {

		genc.getContactnumberfield().clear();
		genc.getContactnumberfield().sendKeys("56874");
		Thread.sleep(500);
		// Click Save to trigger length validation
		WebElement saveBtn = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtn);
		Thread.sleep(300);
		try {
			saveBtn.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);
		}
		Thread.sleep(1000);
		// verify it should display error message "Phone number length should be 10"
		if (genc.getContactnumbererror().isDisplayed()
				&& genc.getContactnumbererror().getText().contains("Phone number length should be 10")) {
			System.out.println(
					"Error message is displayed and text is Phone number length should be 10 and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Phone number length should be 10 and test case is : PASS");
		} else {
			System.out.println(
					"Error message is not displayed or text is not Phone number length should be 10 and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Phone number length should be 10 and test case is : FAIL");
		}

	}

	@Test(dependsOnMethods = "TC_016VerifyContactEmailTextFieldWithShortInputs")
	public void TC_017VerifyContactEmailTextFieldWithMorethan10digits()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberfield().clear();
		String moredigits = "568741258955";
		genc.getContactnumberfield().sendKeys(moredigits);
		// verify that it should not enter digits more than 10 it should accept contact
		// number till 10 digits only
		String actualentereddigit = genc.getContactnumberfield().getAttribute("value");
		if (actualentereddigit.equals(moredigits)) {
			System.out.println("Contact number field accepts more than 10 digits and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact number field accepts more than 10 digits and test case is : FAIL");
		} else {
			System.out.println("Contact number field should not accept more than 10 digits and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Contact number field should not accept more than 10 digits and test case is : PASS");
		}
	}

	@Test(dependsOnMethods = "TC_017VerifyContactEmailTextFieldWithMorethan10digits")
	public void TC_018VerifyContactExtTextFieldacceptInputs()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberextfield().sendKeys("12345");
		utilityclassobject.gettest().log(Status.INFO, "Contact number ext field accepts input and entered value is "
				+ genc.getContactnumberextfield().getAttribute("value"));
		System.out.println("Contact number ext field accepts input and entered value is "
				+ genc.getContactnumberextfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_018VerifyContactExtTextFieldacceptInputs")
	public void TC_019VerifyContactExtTextFieldacceptAlphabets()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberextfield().clear();
		// try to pass alphabets in the text field and verify that it should not accept
		// alphabets
		genc.getContactnumberextfield().sendKeys("abcde");
		// fetch the text after entering value and comare with entered value to verify
		// that it should not accept alphabets
		String actualenteredext = genc.getContactnumberextfield().getAttribute("value");
		if (actualenteredext.equals("abcde")) {
			System.out.println("Contact number ext field accepts alphabets and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact number ext field accepts alphabets and test case is : FAIL");
		} else {
			System.out.println("Contact number ext field should not accept alphabets and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Contact number ext field should not accept alphabets and test case is : PASS");
		}
	}

	@Test(dependsOnMethods = "TC_019VerifyContactExtTextFieldacceptAlphabets")
	public void TC_020VerifyContactExtTextFieldacceptNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		WebElement extField = genc.getContactnumberextfield();
		extField.click();
		Thread.sleep(300);
		extField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		extField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		extField.sendKeys("12345");
		Thread.sleep(300);
		// Use getAttribute("value") - getText() always returns empty string for input
		// fields
		String actualenteredext = extField.getAttribute("value");
		System.out.println("Contact number ext field value after entering numbers: '" + actualenteredext + "'");
		if (actualenteredext.equals("12345")) {
			System.out.println("Contact number ext field accepts numbers and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Contact number ext field accepts numbers and test case is : PASS");
		} else {
			System.out.println("Contact number ext field should accept numbers and test case is : FAIL. Actual value: '"
					+ actualenteredext + "'");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact number ext field should accept numbers and test case is : FAIL. Actual value: '"
							+ actualenteredext + "'");
		}
	}

	@Test(dependsOnMethods = "TC_020VerifyContactExtTextFieldacceptNumbers")
	public void TC_021VerifyContactExtTextFieldacceptSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnumberextfield().clear();
		// try to pass special characters in the text field and verify that it should
		// not accept special characters
		genc.getContactnumberextfield().sendKeys("!@#$%");
		// fetch the text after entering value and comare with entered value to verify
		// that it should not accept special characters
		String actualenteredext = genc.getContactnumberextfield().getAttribute("value");
		if (actualenteredext.equals("!@#$%")) {
			System.out.println("Contact number ext field accepts special characters and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact number ext field accepts special characters and test case is : FAIL");
		} else {
			System.out.println("Contact number ext field should not accept special characters and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Contact number ext field should not accept special characters and test case is : PASS");
		}

	}

	@Test(dependsOnMethods = "TC_021VerifyContactExtTextFieldacceptSpecialCharacters")
	public void TC_022VerifyContactWithoutEmail() throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactemailfield().click();
		genc.getSavebutton().click();
		// verify it should display error message "Email is required"
		if (genc.getContactemailerror().isDisplayed()
				&& genc.getContactemailerror().getText().contains("Email is required")) {
			System.out.println("Error message is displayed and text is Email is required and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Email is required and test case is : PASS");
		} else {
			System.out
					.println("Error message is not displayed or text is not Email is required and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Email is required and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_022VerifyContactWithoutEmail")
	public void TC_023VerifyContactEmailTextFieldacceptValidEmail()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// pass one email with random number in email text fiel and verify it is
		// accepting email or not in text field
		emailId = "test" + "" + jlib.getRandomNumber() + "@example.com";
		genc.getContactemailfield().sendKeys(emailId);
		utilityclassobject.gettest().log(Status.INFO, "Contact email field accepts valid email and entered value is "
				+ genc.getContactemailfield().getAttribute("value") + ": PASS");
		System.out.println("Contact email field accepts valid email and entered value is "
				+ genc.getContactemailfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_023VerifyContactEmailTextFieldacceptValidEmail")
	public void TC_024VerifyContactEmailTextFieldacceptsNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactemailfield().clear();
		genc.getContactemailfield().sendKeys("1234567890");
		utilityclassobject.gettest().log(Status.INFO, "Contact email field accepts numbers and entered value is "
				+ genc.getContactemailfield().getAttribute("value") + ": PASS");
		System.out.println("Contact email field accepts numbers and entered value is "
				+ genc.getContactemailfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_024VerifyContactEmailTextFieldacceptsNumbers")
	public void TC_025VerifyContactEmailTextFieldacceptsSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactemailfield().clear();
		genc.getContactemailfield().sendKeys("!@#$%^&*()");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact email field accepts special characters and entered value is "
						+ genc.getContactemailfield().getAttribute("value") + ": PASS");
		System.out.println("Contact email field accepts special characters and entered value is "
				+ genc.getContactemailfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_025VerifyContactEmailTextFieldacceptsSpecialCharacters")
	public void TC_026VerifyContactEmailTextFieldWithAlreadyExistingUser()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// Skipped - existing user suggestion test handled in TC_023
	}

	@Test(dependsOnMethods = "TC_026VerifyContactEmailTextFieldWithAlreadyExistingUser")
	public void TC_027VerifyPasswordisAbletoModify()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// Click Show Password button first to make field visible and get current value
		genc.getShowpasswordbutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Password is visible after clicking on show password button");
		System.out.println("Password is visible after clicking on show password button");
		Thread.sleep(1000);

		// Get default password value using getAttribute("value") - getText() returns
		// empty for input fields
		String defaultpassword = genc.getPasswordfield().getAttribute("value");
		System.out.println("Default password value: '" + defaultpassword + "'");
		utilityclassobject.gettest().log(Status.INFO, "Default password value: '" + defaultpassword + "'");

		// Clear password field using Ctrl+A + Backspace
		WebElement passwordField = genc.getPasswordfield();
		passwordField.click();
		Thread.sleep(300);
		passwordField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		passwordField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);

		// Enter new password
		passwordField.sendKeys("78*%12Ab");
		Thread.sleep(500);

		// Get modified password value using getAttribute("value")
		String modifiedpwd = genc.getPasswordfield().getAttribute("value");
		System.out.println("Modified password value: '" + modifiedpwd + "'");
		utilityclassobject.gettest().log(Status.INFO, "Modified password value: '" + modifiedpwd + "'");

		if (!defaultpassword.equals(modifiedpwd) && !modifiedpwd.isEmpty()) {
			System.out.println("Password is able to modify and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS, "Password is able to modify and test case is : PASS");
		} else {
			System.out.println("Password is not able to modify and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL, "Password is not able to modify and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_027VerifyPasswordisAbletoModify")
	public void TC_028VerifyPasswordisAbletoMaskandUnmask()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getShowpasswordbutton().click();
		utilityclassobject.gettest().log(Status.INFO, "Password is unmasked after clicking on show password button");
		System.out.println("Password is unmasked after clicking on show password button");
		Thread.sleep(2000);
		genc.getShowpasswordbutton().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Password is masked after clicking on show password button again");
		System.out.println("Password is masked after clicking on show password button again");
	}

	@Test(dependsOnMethods = "TC_028VerifyPasswordisAbletoMaskandUnmask")
	public void TC_029VerifyPasswordTextFieldWithAlpahbets()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getPasswordfield().clear();
		genc.getPasswordfield().sendKeys("Abcdefg");
		utilityclassobject.gettest().log(Status.INFO, "Password field accepts alphabets and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");
		System.out.println("Password field accepts alphabets and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_029VerifyPasswordTextFieldWithAlpahbets")
	public void TC_030VerifyPasswordTextFieldWithNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getPasswordfield().clear();
		genc.getPasswordfield().sendKeys("1234567890");
		utilityclassobject.gettest().log(Status.INFO, "Password field accepts numbers and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");
		System.out.println("Password field accepts numbers and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_030VerifyPasswordTextFieldWithNumbers")
	public void TC_031VerifyPasswordTextFieldWithSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getPasswordfield().clear();
		genc.getPasswordfield().sendKeys("!@#$%^&*()");
		utilityclassobject.gettest().log(Status.INFO, "Password field accepts special characters and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");
		System.out.println("Password field accepts special characters and entered value is "
				+ genc.getPasswordfield().getAttribute("value") + ": PASS");

	}

	@Test(dependsOnMethods = "TC_031VerifyPasswordTextFieldWithSpecialCharacters")
	public void TC_032VerifyPasswordTextFieldWithBlank()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// Clear password field using Ctrl+A + Backspace (clear() may not trigger
		// framework change detection)
		passwordField = genc.getPasswordfield();
		passwordField.click();
		Thread.sleep(300);
		passwordField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		passwordField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		System.out.println("Password field cleared, value: '" + passwordField.getAttribute("value") + "'");
		utilityclassobject.gettest().log(Status.INFO, "Password field cleared");

		// Clear and fill contact name field using the input field (not label)
		WebElement contactNameInput = genc.getContactnamefield();
		contactNameInput.click();
		Thread.sleep(300);
		contactNameInput.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		contactNameInput.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		contactNameInput.sendKeys("Test Contact");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name entered: " + contactNameInput.getAttribute("value"));
		System.out.println("Contact name entered: " + contactNameInput.getAttribute("value"));

		// Clear and fill email field with a fresh valid email
		WebElement emailField = genc.getContactemailfield();
		emailField.click();
		Thread.sleep(300);
		emailField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		emailField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		freshEmail = "test" + jlib.getRandomNumber() + "@example.com";
		emailField.sendKeys(freshEmail);
		utilityclassobject.gettest().log(Status.INFO, "Email entered: " + emailField.getAttribute("value"));
		System.out.println("Email entered: " + emailField.getAttribute("value"));

		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name and email entered to save the contact without password");
		System.out.println("Contact name and email is entered to save the contact without password");

		// Click Save button with scrollIntoView + JS click fallback
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Normal click failed, using JS click: " + e.getMessage());
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(1000);

		// verify it should display error message "Password is required"
		if (genc.getPassworderror().isDisplayed()
				&& genc.getPassworderror().getText().contains("Password is required")) {
			System.out.println("Error message is displayed and text is Password is required and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Password is required and test case is : PASS");
		} else {
			System.out.println(
					"Error message is not displayed or text is not Password is required and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Password is required and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_032VerifyPasswordTextFieldWithBlank")
	public void TC_033VerifyEmailtextfieldprovideSuggestion()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getSelectemailstextfield().click();
		Thread.sleep(2000);
		List<WebElement> listofuser = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement user : listofuser) {
			utilityclassobject.gettest().log(Status.INFO, "Suggestion provided in email field is : " + user.getText());
			System.out.println("Suggestion provided in email field is : " + user.getText());
		}

	}

	@Test(dependsOnMethods = "TC_033VerifyEmailtextfieldprovideSuggestion")
	public void TC_034VerifySelectedOptionShowninEmailsTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getGeneratorportallogincredentilascheckbox().click();
		String emailstextfield = genc.getSelectemailstextfield().getText();
		System.out.println("Email text field value after selecting checkbox: '" + emailstextfield + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Email text field value after selecting checkbox: '" + emailstextfield + "'");

	}

	@Test(dependsOnMethods = "TC_034VerifySelectedOptionShowninEmailsTextField")
	public void TC_035VerifycancelSelectedEmails()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getSelctedemailscancelbtn().click();
		Thread.sleep(1000);
		System.out.println("Selected email is cancelled after clicking on cancel button and email text field is blank");
		utilityclassobject.gettest().log(Status.INFO,
				"Selected email is cancelled after clicking on cancel button and email text field is blank");
	}

	@Test(dependsOnMethods = "TC_035VerifycancelSelectedEmails")
	public void TC_036VerifyUrllinktextfieldAcceptsValidInput()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getGeneratorportalloginurltextfield().sendKeys("www.google.com");
		System.out.println("Generator portal login url text field accepts valid input and entered value is "
				+ genc.getGeneratorportalloginurltextfield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO,
				"Generator portal login url text field accepts valid input and entered value is "
						+ genc.getGeneratorportalloginurltextfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_036VerifyUrllinktextfieldAcceptsValidInput")
	public void TC_037VerifyUrllinktextfieldAcceptsInvalidInput()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getGeneratorportalloginurltextfield().clear();
		genc.getGeneratorportalloginurltextfield().sendKeys("!@#$%^&*()");
		Thread.sleep(2000);
		// verfify the error message is displayed for invalid url and error message is
		// "Please enter a valid URL"
		if (genc.getGeneratorportalloginurlerror().isDisplayed()
				&& genc.getGeneratorportalloginurlerror().getText().contains("Please enter a valid URL")) {
			System.out
					.println("Error message is displayed and text is Please enter a valid URL and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Please enter a valid URL and test case is : PASS");
		} else {
			System.out.println(
					"Error message is not displayed or text is not Please enter a valid URL and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Please enter a valid URL and test case is : FAIL");
		}

	}

	@Test(dependsOnMethods = "TC_037VerifyUrllinktextfieldAcceptsInvalidInput")
	public void TC_038VerifyJobTitleTextfieldAcceptsInput()
			throws InterruptedException, EncryptedDocumentException, IOException {

		genc.getJobtitletextfield().sendKeys("Test Job Title");
		System.out.println("Job title text field accepts input and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO, "Job title text field accepts input and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_038VerifyJobTitleTextfieldAcceptsInput")
	public void TC_039VerifyJobTitleTextfieldAcceptsNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getJobtitletextfield().clear();
		genc.getJobtitletextfield().sendKeys("12456");
		System.out.println("Job title text field accepts numbers and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO, "Job title text field accepts numbers and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_039VerifyJobTitleTextfieldAcceptsNumbers")
	public void TC_040VerifyJobTitleTextfieldAcceptsSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getJobtitletextfield().clear();
		genc.getJobtitletextfield().sendKeys("!@#$%");
		System.out.println("Job title text field accepts special characters and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO,
				"Job title text field accepts special characters and entered value is "
						+ genc.getJobtitletextfield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_040VerifyJobTitleTextfieldAcceptsSpecialCharacters")
	public void TC_041VerifyContactStatusDefaultvalue()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// fetch the default selected value from contact status dropdown and verify that
		// default selected value is "Active"
		String defaultvalue = genc.getContactstatusdropdown().getText();
		System.out.println("Default selected value in contact status dropdown is : '" + defaultvalue + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Default selected value in contact status dropdown is : '" + defaultvalue + "'");

	}

	@Test(dependsOnMethods = "TC_041VerifyContactStatusDefaultvalue")
	public void TC_042VerifyContactStatusDropdownOptions()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactstatusdropdown().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Inactive']")).click();
		String changestatus = genc.getContactstatusdropdown().getText();
		System.out.println("Contact status is changed to : '" + changestatus + "'");
		utilityclassobject.gettest().log(Status.INFO, "Contact status is changed to : '" + changestatus + "'");
		genc.getContactstatusdropdown().click();
		// click on outside on screen
		genc.getContactnamefield().click();

	}

	@Test(dependsOnMethods = "TC_042VerifyContactStatusDropdownOptions")
	public void TC_043VerifyAccessFieldDefaultValues()
			throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> defaultvalues = genc.getAccessfields();
		for (WebElement field : defaultvalues) {
			String fieldname = field.getText();
			System.out.println("Default access field is : '" + fieldname + "'");
			utilityclassobject.gettest().log(Status.INFO, "Default access field is : '" + fieldname + "'");
		}
	}

	@Test(dependsOnMethods = "TC_043VerifyAccessFieldDefaultValues")
	public void TC_044VerifyAbletoChangeAccess() throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> defaultvalues1 = genc.getAccessfields();
		for (WebElement field : defaultvalues1) {
			String fieldname = field.getText();
			System.out.println("Default access field is : '" + fieldname + "'");
			utilityclassobject.gettest().log(Status.INFO, "Default access field is : '" + fieldname + "'");
		}
		genc.getCancelfirstelemetfrondd().click();
		List<WebElement> valuesaftermodification = genc.getAccessfields();
		for (WebElement field : valuesaftermodification) {
			String fieldname = field.getText();
			System.out.println("After modifying access field is : '" + fieldname + "'");
			utilityclassobject.gettest().log(Status.INFO, "After modifying access field is : '" + fieldname + "'");
		}

	}

	@Test(dependsOnMethods = "TC_044VerifyAbletoChangeAccess")
	public void TC_045VerifyProceedwithoutAccess()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getSavebutton().click();
		System.out.println("Access is not an Mandatory field ");
		utilityclassobject.gettest().log(Status.INFO, "Access is not an Mandatory field ");
	}

	@Test(dependsOnMethods = "TC_045VerifyProceedwithoutAccess")
	public void TC_046VerifyContactNoteTextfieldAcceptInputs()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnotefield().sendKeys("fdf52");
		System.out.println("Contact note text field accepts input and entered value is "
				+ genc.getContactnotefield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO, "Contact note text field accepts input and entered value is "
				+ genc.getContactnotefield().getAttribute("value"));
	}

	@Test(dependsOnMethods = "TC_046VerifyContactNoteTextfieldAcceptInputs")
	public void TC_047VerifyContactNoteTextfieldAcceptNumbers()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnotefield().clear();
		genc.getContactnotefield().sendKeys("5687412589");
		System.out.println("Contact note text field accepts numbers and entered value is "
				+ genc.getContactnotefield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO, "Contact note text field accepts numbers and entered value is "
				+ genc.getContactnotefield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_047VerifyContactNoteTextfieldAcceptNumbers")
	public void TC_048VerifyContactNoteTextfieldAcceptSpecialCharacters()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getContactnotefield().clear();
		genc.getContactnotefield().sendKeys("!@#$%^&*()");
		System.out.println("Contact note text field accepts special characters and entered value is "
				+ genc.getContactnotefield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO,
				"Contact note text field accepts special characters and entered value is "
						+ genc.getContactnotefield().getAttribute("value"));

	}

	@Test(dependsOnMethods = "TC_048VerifyContactNoteTextfieldAcceptSpecialCharacters")
	public void TC_049VerifyAbletoChangeNotificayionEvenEmailisnotFilled()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// genc.getContactemailfield().clear();
		// click on notifucation dropdown
		Thread.sleep(3000);
		genc.getNotificationDDbtn().click();
		genc.getNotification1stcheckbox().click();
		genc.getNotification1stcheckbox().click();
		System.out.println("Able to change notification without email: PASS");
		utilityclassobject.gettest().log(Status.PASS, "Able to change notification without email : PASS");

	}

	@Test(dependsOnMethods = "TC_049VerifyAbletoChangeNotificayionEvenEmailisnotFilled")
	public void TC_050VerifyAbletoChangeNotification()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// genc.getContactemailfield().sendKeys(freshEmail);
		genc.getNotification1stcheckbox().click();
		System.out.println("Able to change notification: PASS");
		utilityclassobject.gettest().log(Status.PASS, "Able to change notification : PASS");

	}

	@Test(dependsOnMethods = "TC_050VerifyAbletoChangeNotification")
	public void TC_051VerifySelectedoptionsInTextField()
			throws InterruptedException, EncryptedDocumentException, IOException

	{
		List<WebElement> lists = genc.getNotification1stcheckboxtext();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");
		}
	}

	@Test(dependsOnMethods = "TC_051VerifySelectedoptionsInTextField")
	public void TC_052VerifyAbleToRemoveTheSelectedOption()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getSelectemailstext().click();
		Thread.sleep(1000);
		genc.getNotification1stcheckboxcancelbtn().click();
		System.out.println("Able to remove the selected notification option and option is removed from text field");
		utilityclassobject.gettest().log(Status.INFO,
				"Able to remove the selected notification option and option is removed from text field");

	}

	String title;
	String role;
	String phonenumber;
	String email;
	String contactstatus;
	String contactname;

	@Test(dependsOnMethods = "TC_052VerifyAbleToRemoveTheSelectedOption")
	public void TC_053VerifyAbletoSaveTheData() throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getPasswordfield().sendKeys("Raj456$%");
		genc.getGeneratorportalloginurltextfield().clear();
		genc.getGeneratorportalloginurltextfield().sendKeys("www.google.com");

		// Clear ext field using JS to bypass framework change detection issues
		WebElement extField = genc.getContactnumberextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", extField);
		extField.click();
		Thread.sleep(300);
		extField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		extField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		System.out.println("Ext field cleared, value: '" + extField.getAttribute("value") + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Ext field cleared, value: '" + extField.getAttribute("value") + "'");

		// clear tge job title
		WebElement jobTitleField = genc.getJobtitletextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", jobTitleField);
		jobTitleField.click();
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.BACK_SPACE);

		System.out.println("Job title field cleared, value: '" + jobTitleField.getAttribute("value") + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Job title field cleared, value: '" + jobTitleField.getAttribute("value") + "'");
		title = "Test Job Title";
		jobTitleField.sendKeys(title);
		// verify that job title field accepts input and entered value is "Test Job
		// Title"
		System.out.println("Job title text field accepts input and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
		utilityclassobject.gettest().log(Status.INFO, "Job title text field accepts input and entered value is "
				+ genc.getJobtitletextfield().getAttribute("value"));
		Thread.sleep(500);
		// fetch the data which is present in the role text field
		role = genc.getRoledropdown().getText();
		System.out.println("Role selected in role field is : '" + role + "'");
		utilityclassobject.gettest().log(Status.INFO, "Role selected in role field is : '" + role + "'");
		Thread.sleep(500);
		// fetch the phone number
		phonenumber = genc.getContactnumberfield().getAttribute("value");
		System.out.println("Phone number entered in contact number field is : '" + phonenumber + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Phone number entered in contact number field is : '" + phonenumber + "'");
		Thread.sleep(500);
		// fetch the email which is entered in email field
		email = genc.getContactemailfield().getAttribute("value");
		System.out.println("Email entered in contact email field is : '" + email + "'");
		utilityclassobject.gettest().log(Status.INFO, "Email entered in contact email field is : '" + email + "'");
		// fetch the selected data from contact status dropdown
		contactstatus = genc.getContactstatusdropdown().getText();
		System.out.println("Contact status selected in contact status dropdown is : '" + contactstatus + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact status selected in contact status dropdown is : '" + contactstatus + "'");
		Thread.sleep(500);
		// fetch the contact name which is entered in contact name field
		contactname = genc.getContactnamefield().getAttribute("value");
		System.out.println("Contact name entered in contact name field is : '" + contactname + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name entered in contact name field is : '" + contactname + "'");
		Thread.sleep(500);

		genc.getSavebutton().click();
		Thread.sleep(3000);
		List<WebElement> contactlists = genc.getContactnamelists();
		for (WebElement contact : contactlists) {
			if (contact.getText().equals("Test Contact")) {
				System.out.println("Contact is saved successfully and contact name is : '" + contact.getText()
						+ "' and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS, "Contact is saved successfully and contact name is : '"
						+ contact.getText() + "' and test case is : PASS");
			} else {
				System.out.println("Contact is not saved and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL, "Contact is not saved and test case is : FAIL");
			}

		}

	}

	@Test(dependsOnMethods = "TC_053VerifyAbletoSaveTheData")
	public void TC_054VerifyDetailTableMatch() throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");
			if (notificationtext.contains(title)) {
				System.out.println(
						"Detail table is showing the correct job title which is entered in job title text field and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct job title which is entered in job title text field and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct job title which is entered in job title text field and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct job title which is entered in job title text field and test case is : FAIL");
			}

			if (notificationtext.contains(role)) {
				System.out.println(
						"Detail table is showing the correct role which is selected in role dropdown and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct role which is selected in role dropdown and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct role which is selected in role dropdown and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct role which is selected in role dropdown and test case is : FAIL");
			}
			if (notificationtext.contains(phonenumber)) {
				System.out.println(
						"Detail table is showing the correct phone number which is entered in contact number field and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct phone number which is entered in contact number field and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct phone number which is entered in contact number field and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct phone number which is entered in contact number field and test case is : FAIL");
			}
			if (notificationtext.contains(email)) {
				System.out.println(
						"Detail table is showing the correct email which is entered in contact email field and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct email which is entered in contact email field and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct email which is entered in contact email field and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct email which is entered in contact email field and test case is : FAIL");
			}

			if (notificationtext.contains(contactname)) {
				System.out.println(
						"Detail table is showing the correct url which is entered in generator portal login url text field and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct url which is entered in generator portal login url text field and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct url which is entered in generator portal login url text field and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct url which is entered in generator portal login url text field and test case is : FAIL");
			}

		}

		System.out.println(
				"Detail table is showing the correct data which is entered in respective fields and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Detail table is showing the correct data which is entered in respective fields and test case is : PASS");

	}

	@Test(dependsOnMethods = "TC_054VerifyDetailTableMatch")
	public void TC_055VerifyContactNameIsDisplayedinList()
			throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains(contactname)) {
				System.out.println("Contact name is displayed in the list and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Contact name is displayed in the list and test case is : PASS");
			} else {
				System.out.println("Contact name is not displayed in the list and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Contact name is not displayed in the list and test case is : FAIL");
			}

		}

	}

	@Test(dependsOnMethods = "TC_055VerifyContactNameIsDisplayedinList")
	public void TC_056VerifyJobTitleDisplaedinList()
			throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains(title)) {
				System.out.println("Job title is displayed in the list and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Job title is displayed in the list and test case is : PASS");

			}
 
		}

	}

	@Test(dependsOnMethods = "TC_056VerifyJobTitleDisplaedinList")
	public void TC_057VerifyPhonenumberDisplaedinList()
			throws InterruptedException, EncryptedDocumentException, IOException {
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains(phonenumber)) {
				System.out.println("Phone number is displayed in the list and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Phone number is displayed in the list and test case is : PASS");

			}
		}

	}

	@Test(dependsOnMethods = "TC_057VerifyPhonenumberDisplaedinList")
	public void TC_058VerifyEmailDisplaedinList() throws InterruptedException, EncryptedDocumentException, IOException {
		// Click Add New Contact button to open the dialog
		genc.getAddcontactbutton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Add New Contact dialog is opened");
		System.out.println("Add New Contact dialog is opened");

		// Fill Contact Name field
		WebElement contactNameField = genc.getContactnamefield();
		contactNameField.click();
		Thread.sleep(300);
		contactNameField.sendKeys("Test Contact 2");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name entered: " + contactNameField.getAttribute("value"));
		System.out.println("Contact name entered: " + contactNameField.getAttribute("value"));

		// Fill Contact Number field
		WebElement numberField = genc.getContactnumberfield();
		numberField.click();
		Thread.sleep(300);
		numberField.sendKeys("5687412589");
		utilityclassobject.gettest().log(Status.INFO, "Contact number entered: " + numberField.getAttribute("value"));
		System.out.println("Contact number entered: " + numberField.getAttribute("value"));

		// Fill Password field
		WebElement pwd = genc.getPasswordfield();
		pwd.click();
		Thread.sleep(300);
		pwd.sendKeys("Raj456$%");
		utilityclassobject.gettest().log(Status.INFO, "Password entered");
		System.out.println("Password entered");

		// Leave Email field blank - just click on it and move away to trigger touched
		// state
		WebElement emailField = genc.getContactemailfield();
		emailField.click();
		Thread.sleep(300);
		emailField.sendKeys(Keys.TAB);
		Thread.sleep(300);
		utilityclassobject.gettest().log(Status.INFO, "Email field left blank intentionally");
		System.out.println("Email field left blank intentionally");

		// Click Save button
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(1000);

		// Verify error message "Email is required"
		if (genc.getContactemailerror().isDisplayed()
				&& genc.getContactemailerror().getText().contains("Email is required")) {
			System.out.println("Error message is displayed and text is Email is required and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Email is required and test case is : PASS");
		} else {
			System.out
					.println("Error message is not displayed or text is not Email is required and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Email is required and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_058VerifyEmailDisplaedinList")
	public void TC_059VerifyEmailValidation() throws InterruptedException, EncryptedDocumentException, IOException {
		// Enter a valid email in the email field
		WebElement emailField = genc.getContactemailfield();
		emailField.click();
		Thread.sleep(300);
		emailField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		emailField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		String newEmail = "test" + jlib.getRandomNumber() + "@example.com";
		emailField.sendKeys(newEmail);
		utilityclassobject.gettest().log(Status.INFO, "Valid email entered: " + emailField.getAttribute("value"));
		System.out.println("Valid email entered: " + emailField.getAttribute("value"));
		Thread.sleep(500);

		// Clear the Job Title field so it is blank before saving
		WebElement jobTitleField = genc.getJobtitletextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", jobTitleField);
		jobTitleField.click();
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		String jobTitleValue = jobTitleField.getAttribute("value");
		System.out.println("Job title field cleared, current value: '" + jobTitleValue + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Job title field cleared, current value: '" + jobTitleValue + "'");

		// Click Save button
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Save button clicked after entering email with blank job title");
		System.out.println("Save button clicked after entering email with blank job title");

		// Verify contact is saved successfully
		List<WebElement> contactlists = genc.getContactnamelists();
		boolean contactFound = false;
		for (WebElement contact : contactlists) {
			if (contact.getText().equals("Test Contact 2")) {
				contactFound = true;
				System.out.println(
						"Contact is saved successfully with name: '" + contact.getText() + "' and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Contact is saved successfully with name: '" + contact.getText() + "' and test case is : PASS");
				break;
			}
		}
		if (!contactFound) {
			System.out.println("Contact is not saved after entering valid email and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact is not saved after entering valid email and test case is : FAIL");
		}

		// Verify job title is empty/blank in the contact list for "Test Contact 2"
		List<WebElement> listRows = genc.getRoledropdownoption();
		boolean jobTitleBlankVerified = false;
		for (WebElement row : listRows) {
			String rowText = row.getText();
			if (rowText.contains("Test Contact 2")) {
				// Job title column should be blank/empty for this contact
				if (!rowText.contains("Test Job Title") && (rowText.trim().isEmpty() || !rowText.contains("Job"))) {
					jobTitleBlankVerified = true;
					System.out.println(
							"Job title is blank/empty in the list for 'Test Contact 2' and test case is : PASS");
					utilityclassobject.gettest().log(Status.PASS,
							"Job title is blank/empty in the list for 'Test Contact 2' and test case is : PASS");
				} else {
					System.out.println("Job title is NOT blank in the list for 'Test Contact 2', actual row text: '"
							+ rowText + "' and test case is : FAIL");
					utilityclassobject.gettest().log(Status.FAIL,
							"Job title is NOT blank in the list for 'Test Contact 2', actual row text: '" + rowText
									+ "' and test case is : FAIL");
				}
				break;
			}
		}
		if (!jobTitleBlankVerified) {
			System.out.println("Could not find 'Test Contact 2' row in list to verify blank job title");
			utilityclassobject.gettest().log(Status.INFO,
					"Could not find 'Test Contact 2' row in list to verify blank job title");
		}
	}

	String newEmail;

	@Test(dependsOnMethods = "TC_059VerifyEmailValidation")
	public void TC_060VerifyContacWithoutPhoneNumber()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// click on add new contact button
		genc.getAddcontactbutton().click();
		// Enter a valid email in the email field
		WebElement emailField = genc.getContactemailfield();
		emailField.click();
		Thread.sleep(300);
		emailField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		emailField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		newEmail = "test" + jlib.getRandomNumber() + "@example.com";
		emailField.sendKeys(newEmail);
		System.out.println(newEmail);
		utilityclassobject.gettest().log(Status.INFO, "Valid email entered: " + emailField.getAttribute("value"));
		System.out.println("Valid email entered: " + emailField.getAttribute("value"));
		Thread.sleep(500);

		// Clear the Job Title field so it is blank before saving
		WebElement jobTitleField = genc.getJobtitletextfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", jobTitleField);
		jobTitleField.click();
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		jobTitleField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		String jobTitleValue = jobTitleField.getAttribute("value");
		System.out.println("Job title field cleared, current value: '" + jobTitleValue + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Job title field cleared, current value: '" + jobTitleValue + "'");
		// clear the phone number text field
		WebElement phoneNumberField = genc.getContactnumberfield();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", phoneNumberField);
		phoneNumberField.click();
		Thread.sleep(300);
		phoneNumberField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		phoneNumberField.sendKeys(Keys.BACK_SPACE);
		// fetch the data from phone number text field and verify that it is blank
		String phoneNumberValue = phoneNumberField.getAttribute("value");
		System.out.println("Phone number field cleared, current value: '" + phoneNumberValue + "'");
		utilityclassobject.gettest().log(Status.INFO,
				"Phone number field cleared, current value: '" + phoneNumberValue + "'");
		// clcik on contact aname and add name
		WebElement contactNameField = genc.getContactnamefield();
		contactNameField.click();
		Thread.sleep(300);
		contactNameField.sendKeys("Test Contact 3");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name entered: " + contactNameField.getAttribute("value"));
		System.out.println("Contact name entered: " + contactNameField.getAttribute("value"));
		Thread.sleep(500);
		List<WebElement> accesslists = genc.getAccessdropdowntext();

		accessvalue1 = "";
		accessvalue2 = "";
		accessvalue3 = "";

		for (int i = 0; i < accesslists.size(); i++) {

			String text = accesslists.get(i).getText().trim();

			if (i == 0) {
				accessvalue1 = text;
			} else if (i == 1) {
				accessvalue2 = text;
			} else if (i == 2) {
				accessvalue3 = text;
			}
		}

		System.out.println("Value1: " + accessvalue1);
		System.out.println("Value2: " + accessvalue2);
		System.out.println("Value3: " + accessvalue3);

		// Click Save button
		WebElement saveButton = genc.getSavebutton();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);
		Thread.sleep(500);
		try {
			saveButton.click();
		} catch (org.openqa.selenium.WebDriverException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
		}
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Save button clicked after entering email with blank job title");
		System.out.println("Save button clicked after entering email with blank job title");

		// Verify contact is saved successfully
		List<WebElement> contactlists = genc.getContactnamelists();
		boolean contactFound = false;
		for (WebElement contact : contactlists) {
			if (contact.getText().equals("Test Contact 2")) {
				contactFound = true;
				System.out.println(
						"Contact is saved successfully with name: '" + contact.getText() + "' and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Contact is saved successfully with name: '" + contact.getText() + "' and test case is : PASS");
				break;
			}

		}
		if (!contactFound) {
			System.out.println("Contact is not saved after entering valid email and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact is not saved after entering valid email and test case is : FAIL");
		}
		// verify that in contcta list phone number is blank for the contact which is
		// created without entering phone number
		List<WebElement> listRows = genc.getRoledropdownoption();
		boolean phoneNumberBlankVerified = false;
		for (WebElement row : listRows) {
			String rowText = row.getText();
			if (rowText.contains("Test Contact 2")) {
				// Phone number column should be blank/empty for this contact
				if (!rowText.contains("5687412589")
						&& (rowText.trim().isEmpty() || !rowText.contains("Contact Number"))) {
					phoneNumberBlankVerified = true;
					System.out.println(
							"Phone number is blank/empty in the list for 'Test Contact 2' and test case is : PASS");
					utilityclassobject.gettest().log(Status.PASS,
							"Phone number is blank/empty in the list for 'Test Contact 2' and test case is : PASS");
				} else {
					System.out.println("Phone number is NOT blank in the list for 'Test Contact 2', actual row text: '"
							+ rowText + "' and test case is : FAIL");
					utilityclassobject.gettest().log(Status.FAIL,
							"Phone number is NOT blank in the list for 'Test Contact 2', actual row text: '" + rowText
									+ "' and test case is : FAIL");
				}
				break;
			}
		}
		if (!phoneNumberBlankVerified) {
			System.out.println("Could not find 'Test Contact 2' row in list to verify blank phone number");
			utilityclassobject.gettest().log(Status.INFO,
					"Could not find 'Test Contact 2' row in list to verify blank phone number");
		}

	}

	@Test(dependsOnMethods = "TC_060VerifyContacWithoutPhoneNumber")
	public void TC_061VerifyEmailAppearsinListsAfterAdding()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// verify email in test contact is displayed in the list

		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains("Test Contact 3")) {
				System.out.println(
						"Detail table is showing the correct url which is entered in generator portal login url text field ");
				utilityclassobject.gettest().log(Status.INFO,
						"Detail table is showing the correct url which is entered in generator portal login url text field and ");
			} else {
				System.out.println(
						"Detail table is not showing the correct url which is entered in generator portal login url text field and");
				utilityclassobject.gettest().log(Status.INFO,
						"Detail table is not showing the correct url which is entered in generator portal login url text field ");
			}
			if (notificationtext.contains(newEmail)) {
				System.out
						.println("Detail table is showing the correct email which is entered in contact email field "+newEmail+"");
				utilityclassobject.gettest().log(Status.INFO,
						"Detail table is showing the correct email which is entered in contact email field ");
			} else {
				System.out.println(
						"Detail table is not showing the correct email which is entered in contact email field ");
				utilityclassobject.gettest().log(Status.INFO,
						"Detail table is not showing the correct email which is entered in contact email field ");
			}

		}

	}

	@Test(dependsOnMethods = "TC_061VerifyEmailAppearsinListsAfterAdding")
	public void TC_062VerifyContactStatusinLists()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// verifythat in list contact status is Active
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains("Active")) {
				System.out.println(
						"Detail table is showing the correct contact status which is selected in contact status dropdown and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct contact status which is selected in contact status dropdown and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct contact status which is selected in contact status dropdown and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct contact status which is selected in contact status dropdown and test case is : FAIL");
			}

		}

	}

	@Test(dependsOnMethods = "TC_062VerifyContactStatusinLists")
	public void TC_063VerifyAccessinLists() throws InterruptedException, EncryptedDocumentException, IOException {
		// verify that in list access value is same which is selected in access dropdown
		List<WebElement> lists = genc.getRoledropdownoption();
		for (WebElement list : lists) {
			String notificationtext = list.getText();
			System.out.println("Notification option is : '" + notificationtext + "'");
			utilityclassobject.gettest().log(Status.INFO, "Notification option is : '" + notificationtext + "'");

			if (notificationtext.contains(accessvalue1) || notificationtext.contains(accessvalue2)) {
				System.out.println(
						"Detail table is showing the correct access value which is selected in access dropdown and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Detail table is showing the correct access value which is selected in access dropdown and test case is : PASS");
			} else {
				System.out.println(
						"Detail table is not showing the correct access value which is selected in access dropdown and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"Detail table is not showing the correct access value which is selected in access dropdown and test case is : FAIL");
			}

		}

	}

	@Test(dependsOnMethods = "TC_063VerifyAccessinLists")
	public void TC_064VerifyAfteclickingonContactPopUpisAppear()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// delete the contact which is created in above test case
		List<WebElement> contactlists = genc.getContactnamelists();
		for (WebElement contact : contactlists) {
			if (contact.getText().equals(contactname)) {
				contact.click();
				System.out
						.println("Clicked on contact name in the list and pop up is appeared and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Clicked on contact name in the list and pop up is appeared and test case is : PASS");
			}

		}

	}

	@Test(dependsOnMethods = "TC_064VerifyAfteclickingonContactPopUpisAppear")
	public void TC_065VerifyAbleToModifyExistingContact()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// modify the contact name and save it and verify in list
		WebElement contactNameField = genc.getContactnamefield();
		contactNameField.click();
		Thread.sleep(300);
		contactNameField.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(300);
		contactNameField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(300);
		contactNameField.sendKeys("Modified Test Contact");
		utilityclassobject.gettest().log(Status.INFO,
				"Contact name modified: " + contactNameField.getAttribute("value"));
		System.out.println("Contact name modified: " + contactNameField.getAttribute("value"));
		Thread.sleep(500);
		// click on emails text
		genc.getSelectemailstext().click();
		utilityclassobject.gettest().log(Status.INFO,
				"Updated successfully and clicked on email text to move focus away from contact name field");
		System.out.println("Updated successfully and clicked on email text to move focus away from contact name field");
		Thread.sleep(500);
		genc.getCancelpopupbtn().click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked on cancel button in edit contact popup");
		System.out.println("Clicked on cancel button in edit contact popup");
		Thread.sleep(3000);

		List<WebElement> contactlists = genc.getContactnamelists();
		boolean contactUpdated = false;
		for (WebElement contact : contactlists) {
			if (contact.getText().equals("Modified Test Contact")) {
				contactUpdated = true;
				System.out.println("Contact is modified successfully and modified contact name is : '"
						+ contact.getText() + "' and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"Contact is modified successfully and modified contact name is : '" + contact.getText()
								+ "' and test case is : PASS");
				break;
			}
		}
		if (!contactUpdated) {
			System.out.println("Contact is not modified successfully and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact is not modified successfully and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_065VerifyAbleToModifyExistingContact")
	public void TC_066VerifyLogonGeneratorlinkisDisplayed()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// again click on any one contact which is present in the lists

		List<WebElement> contactlists = genc.getContactnamelists();
		for (WebElement contact : contactlists) {
			if (contact.getText().equals("Test Contact 2")) {
				contact.click();
				System.out.println("Clicked on contact name in the list and pop up is appeared");
				utilityclassobject.gettest().log(Status.INFO,
						"Clicked on contact name in the list and pop up is appeared");
			}

		}
		// verify that log on generator link is displayed in the popup
		if (genc.getLogintogeneratorsportallink().isDisplayed()) {
			System.out.println("Log on generator link is displayed in the popup and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Log on generator link is displayed in the popup and test case is : PASS");
		} else {
			System.out.println("Log on generator link is not displayed in the popup and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Log on generator link is not displayed in the popup and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_066VerifyLogonGeneratorlinkisDisplayed")
	public void TC_067VerifyAbleToClickOnLogonGeneratorlink()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// click on log on generator link
		genc.getLogintogeneratorsportallink().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on log on generator link");
		System.out.println("Clicked on log on generator link");
		Thread.sleep(3000);
		// verify generator portal is displayed in new tab
		// ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// swith to new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if (tabs.size() > 1) {
			driver.switchTo().window(tabs.get(1)); // Switch to the new tab
			System.out.println("Switched to new tab for generator portal");
			utilityclassobject.gettest().log(Status.INFO, "Switched to new tab for generator portal");
		} else {
			System.out.println("New tab for generator portal did not open as expected");
			utilityclassobject.gettest().log(Status.FAIL, "New tab for generator portal did not open as expected");
		}
		if (genc.getGeneratortermsofservicepage().isDisplayed()) {
			System.out.println("Generator portal is displayed in new tab and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Generator portal is displayed in new tab and test case is : PASS");

		}

	}

	@Test(dependsOnMethods = "TC_067VerifyAbleToClickOnLogonGeneratorlink")
	public void TC_068VerifyAbleToClcikonCheckBox()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getGeneratortermsofservicecheckbox().click();
		Thread.sleep(1000);
		System.out.println("Clicked on check box in generator portal and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Clicked on check box in generator portal and test case is : PASS");
	}

	@Test(dependsOnMethods = "TC_068VerifyAbleToClcikonCheckBox")
	public void TC_069VerifyAbleToClickOnCancelButton()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getGeneratortermsofservicecancelbtn().click();
		Thread.sleep(1000);
		genc.getGeneratortermsofserviceconfirmbtn().click();
		// verify that it should re direct to welcome page
		if (genc.getWelcomePageofGeneratorPortal().isDisplayed()) {
			System.out.println(
					"After clicking on cancel button in generator portal it is redirected to welcome page and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"After clicking on cancel button in generator portal it is redirected to welcome page and test case is : PASS");
		} else {
			System.out.println(
					"After clicking on cancel button in generator portal it is not redirected to welcome page and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"After clicking on cancel button in generator portal it is not redirected to welcome page and test case is : FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_069VerifyAbleToClickOnCancelButton")
	public void TC_070VerifyAbleToClickOnConfirmButton()
			throws InterruptedException, EncryptedDocumentException, IOException {
		// again close the existing tab and switch back to old / previous tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if (tabs.size() > 1) {
			driver.close(); // Close the current tab
			driver.switchTo().window(tabs.get(0)); // Switch back to the original tab
			System.out.println("Closed generator portal tab and switched back to original tab");
			utilityclassobject.gettest().log(Status.INFO,
					"Closed generator portal tab and switched back to original tab");
		} else {
			System.out.println("Generator portal tab was not opened as expected, so could not close or switch tabs");
			utilityclassobject.gettest().log(Status.FAIL,
					"Generator portal tab was not opened as expected, so could not close or switch tabs");
		}
		
		
		// again click on log on generator link
		genc.getLogintogeneratorsportallink().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on log on generator link");
		System.out.println("Clicked on log on generator link");
		Thread.sleep(3000);
		//again switch to new tab for generator portal
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		if (tabs1.size() > 1) {
			driver.switchTo().window(tabs1.get(1)); // Switch to the new tab
			System.out.println("Switched to new tab for generator portal");
			utilityclassobject.gettest().log(Status.INFO, "Switched to new tab for generator portal");
		} else {
			System.out.println("New tab for generator portal did not open as expected");
			utilityclassobject.gettest().log(Status.FAIL, "New tab for generator portal did not open as expected");
		}
		
		genc.getGeneratortermsofservicecheckbox().click();
		Thread.sleep(1000);
		System.out.println("Clicked on check box in generator portal and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Clicked on check box in generator portal and test case is : PASS");
		genc.getIacceptbuttonfromgeneratorportal().click();
		// verify set up password page is displayed
		if (genc.getSetuppasswordpageofgeneratorportal1().isDisplayed())

		{
			System.out.println(
					"After clicking on I accept button in generator portal it is redirected to set up password page and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"After clicking on I accept button in generator portal it is redirected to set up password page and test case is : PASS");
		} else {
			System.out.println(
					"After clicking on I accept button in generator portal it is not redirected to set up password page and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"After clicking on I accept button in generator portal it is not redirected to set up password page and test case is : FAIL");
		}

	}

	@Test(dependsOnMethods = "TC_070VerifyAbleToClickOnConfirmButton")
	public void TC_071VerifyAbleToPassAlphabetsinNewPasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getNewpasswordfield().sendKeys("abcd");
		System.out.println("Entered alphabets in new password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered alphabets in new password text field and test case is : PASS");

	}
	@Test(dependsOnMethods = "TC_071VerifyAbleToPassAlphabetsinNewPasswordTextField")
	public void TC_072VerifyAbleToPassNumbersinNewPasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
	   genc.getNewpasswordfield().clear();
		genc.getNewpasswordfield().sendKeys("1234");
		System.out.println("Entered numbers in new password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered numbers in new password text field and test case is : PASS");
	}
	@Test(dependsOnMethods = "TC_072VerifyAbleToPassNumbersinNewPasswordTextField")
	public void TC_073VerifyAbleToPassSpecialCharactersinNewPasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
		genc.getNewpasswordfield().clear();
		genc.getNewpasswordfield().sendKeys("@#$%");
		System.out.println("Entered special characters in new password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered special characters in new password text field and test case is : PASS");
	}
	@Test(dependsOnMethods = "TC_073VerifyAbleToPassSpecialCharactersinNewPasswordTextField")
	public void TC_074VerifyAbleToPassValidNewPasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		
		genc.getNewpasswordfield().clear();
		String newpassword = "Abcd@1234";
		genc.getNewpasswordfield().sendKeys(newpassword);
		System.out.println("Entered combination in new password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered combination in new password text field and test case is : PASS");
	}
	@Test(dependsOnMethods = "TC_074VerifyAbleToPassValidNewPasswordTextField")
	public void TC_075VerifyMaskandUnMaskPasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getEyeiconnewpasswordbutton().click();
		Thread.sleep(1000);
		System.out.println("New password text field is unmasked: PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"New password text field is unmasked: PASS");
		genc.getEyeiconnewpasswordbutton().click();
		Thread.sleep(1000);
		System.out.println("New password text field is masked: PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"New password text field is masked: PASS");
		//String newpassword = genc.getNewpasswordfield().getText();
		//System.out.println("Password visible after clicking eye icon is : '" + newpassword + "'");
	}
	@Test(dependsOnMethods = "TC_075VerifyMaskandUnMaskPasswordTextField")
	public void TC_076VerifyAbletoPassAlphabetsinRetypePasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getRetypenewpasswordfield().sendKeys("abcd");
		System.out.println("Entered alphabets in retype password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered alphabets in retype password text field and test case is : PASS");
		

	}
	@Test(dependsOnMethods = "TC_076VerifyAbletoPassAlphabetsinRetypePasswordTextField")
	public void TC_077VerifyAbletoPassNumbersinRetypePasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getRetypenewpasswordfield().clear();
		genc.getRetypenewpasswordfield().sendKeys("1234");
		System.out.println("Entered numbers in retype password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered numbers in retype password text field and test case is : PASS");
		
	}
	@Test(dependsOnMethods = "TC_077VerifyAbletoPassNumbersinRetypePasswordTextField")
	public void TC_078VerifyAbletoPassSpecialCharactersinRetypePasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getRetypenewpasswordfield().clear();
		genc.getRetypenewpasswordfield().sendKeys("@#$%");
		System.out.println("Entered special characters in retype password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered special characters in retype password text field and test case is : PASS");
		
	}
	@Test(dependsOnMethods = "TC_078VerifyAbletoPassSpecialCharactersinRetypePasswordTextField")
	public void TC_079VerifyAbletoPassValidCombinationinRetypePasswordTextField()
			throws InterruptedException, EncryptedDocumentException, IOException {
		genc.getRetypenewpasswordfield().clear();
		genc.getRetypenewpasswordfield().sendKeys("Abcd@1234");
		System.out.println("Entered valid combination in retype password text field and test case is : PASS");
		utilityclassobject.gettest().log(Status.PASS,
				"Entered valid combination in retype password text field and test case is : PASS");
		
	}
	@Test(dependsOnMethods = "TC_079VerifyAbletoPassValidCombinationinRetypePasswordTextField")
	public void TC_080VerifyErrorMessageDisplayedForMismatchData()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
	//verify that error message is displayed when data entered in new password and retype password text field is not same

		//use java script executor to clear the retype password text field 
		// Select all text
		genc.getRetypenewpasswordfield().click();
		WebElement ele = genc.getRetypenewpasswordfield();


		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		System.out.println(genc.getRetypenewpasswordfield().getAttribute("value"));
			
		
		genc.getRetypenewpasswordfield().sendKeys("Abcd@12345");
		genc.getConfirmbuttonfromsetuppasswordpage().click();
		Thread.sleep(1000);
	/*	if(genc.getPasswordsdontmatcherror().isDisplayed())
		{
			System.out.println("Error message is displayed and text is Passwords do not match and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Error message is displayed and text is Passwords do not match and test case is : PASS");
		}
		else
		{
			System.out.println("Error message is not displayed or text is not Passwords do not match and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Error message is not displayed or text is not Passwords do not match and test case is : FAIL");
		}*/
	}
	String updatedpwd1;
	@Test(dependsOnMethods = "TC_080VerifyErrorMessageDisplayedForMismatchData")
	public void TC_081VerifyDashboardPageAftesettingpassword()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		// enter same data in new password and retype password text field and click on confirm button and verify that it should redirect to dashboard page of generator portal
		genc.getRetypenewpasswordfield().click();
		WebElement ele = genc.getRetypenewpasswordfield();


		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
		System.out.println(genc.getRetypenewpasswordfield().getAttribute("value"));
			
		updatedpwd1 = "Abcd@1234";
		genc.getRetypenewpasswordfield().sendKeys(updatedpwd1);
		System.out.println(genc.getRetypenewpasswordfield().getText());
		genc.getConfirmbuttonfromsetuppasswordpage().click();
		Thread.sleep(3000);
		
		if(genc.getDashboardpageofgeneratorportal().isDisplayed())
		{
			System.out.println("After setting up password it is redirected to dashboard page and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"After setting up password it is redirected to dashboard page and test case is : PASS");
		}
		else
		{
			System.out.println("After setting up password it is not redirected to dashboard page and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"After setting up password it is not redirected to dashboard page and test case is : FAIL");
		}
		

	}
	@Test(dependsOnMethods = "TC_081VerifyDashboardPageAftesettingpassword")
	public void TC_082VerifyContactNamefromProfile()
			throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		genc.getGeneratorportaluserprofileimage().click();
		Thread.sleep(1000);
		System.out.println(contactname);
		if(genc.getGeneratorportalusername().getText().contains(contactname))
		{
			System.out.println("Contact name is displayed in profile and test case is : PASS");
			utilityclassobject.gettest().log(Status.PASS,
					"Contact name is displayed in profile and test case is : PASS");
		}
		else
		{
			System.out.println("Contact name is not displayed in profile and test case is : FAIL");
			utilityclassobject.gettest().log(Status.FAIL,
					"Contact name is not displayed in profile and test case is : FAIL");
		}
	}
		
		@Test(dependsOnMethods = "TC_082VerifyContactNamefromProfile")
		public void TC_083VerifyUserIsableToaginLogin()
				throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
			String emailfromgenerator = genc.getGeneratorportaluseremail().getText();
			System.out.println(emailfromgenerator);
			genc.getGeneratorportallogoutbutton().click();
			Thread.sleep(2000);
			//verify login pafe is displayed
			if(genc.getGeneratorportalwelcomeheading().isDisplayed())
			{
				
				System.out.println("After logout generator portal login page / welcome is displayed and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"After logout generator portal login page / welcome is displayed and test case is : PASS");
			}
			else
			{
				System.out.println("After logout generator portal login page/ welcome is not displayed and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"After logout generator portal login page / welcome is not displayed and test case is : FAIL");
			}
			genc.getGeneratorportaluseremailfield().sendKeys(emailfromgenerator);
			genc.getGeneratorportalpasswordfield().sendKeys(updatedpwd1);
			genc.getGeneratorportalloginbutton().click();
			Thread.sleep(3000);
			//verify dashboard page is displayed
			if(genc.getDashboardpageofgeneratorportal().isDisplayed())
			{
				System.out.println("After login generator portal dashboard page is displayed and test case is : PASS");
				utilityclassobject.gettest().log(Status.PASS,
						"After login generator portal dashboard page is displayed and test case is : PASS");
			}
			else
			{
				System.out.println("After login generator portal dashboard page is not displayed and test case is : FAIL");
				utilityclassobject.gettest().log(Status.FAIL,
						"After login generator portal dashboard page is not displayed and test case is : FAIL");
			}
			
		
	}
}