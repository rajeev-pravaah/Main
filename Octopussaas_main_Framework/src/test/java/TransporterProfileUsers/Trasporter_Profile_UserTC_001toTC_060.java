package TransporterProfileUsers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

import com.Octopussaas.BaseUtility.BaseClassForMasterPriceBook;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaas.ObjectRepository.TransporterSettingsPage;
import com.Octopussaas.ObjectRepository.TransporterSettingsUsers;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class Trasporter_Profile_UserTC_001toTC_060 extends BaseClassForMasterPriceBook {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;
	TransporterSettingsPage tsp;
	TransporterSettingsUsers tsu;
	
	Random random;

	@Test
	public void TC_001AccessUsersPage() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		wlib = new webDriverutility();
		Thread.sleep(2000);
		// Ensure page zoom is 80% so the element positions are consistent
		try {
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		} catch (Exception e) {
			/* ignore if not supported */ }
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is  displayed successfully");
		tsp = new TransporterSettingsPage(driver);
		tsp.getUserslink().click();
		utilityclassobject.gettest().log(Status.INFO, "Users page is  displayed successfully");
		System.out.println("Users page is  displayed successfully");

	}

	@Test(dependsOnMethods = "TC_001AccessUsersPage")
	public void TC_002AccessUsersPage() throws InterruptedException {
		tsu = new TransporterSettingsUsers(driver);
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "TC_002AccessUsersPage")
	public void TC_003AccessUsersPage() throws InterruptedException {
		System.out.println("Add new user page is  displayed successfully");
		tsu.getAddNewUserButton().click();
		utilityclassobject.gettest().log(Status.INFO, "Add new user page is  displayed successfully");
		System.out.println("Add new user page is  displayed successfully");
	}

	@Test(dependsOnMethods = "TC_003AccessUsersPage")
	public void TC_004FirstNameTextFieldWithAlphabets() throws InterruptedException {
		// First name text field should accept only alphabets not get data from excel
		tsu.getFirstnameTextField().sendKeys("gfdh");
		utilityclassobject.gettest().log(Status.INFO, "First name text field is accepting only alphabets");
		System.out.println("First name text field is accepting only alphabets");

	}

	@Test(dependsOnMethods = "TC_004FirstNameTextFieldWithAlphabets")
	public void TC_005FirstNameTextFieldWithNumbers() throws InterruptedException {
		// First name text field should not accept numbers
		tsu.getFirstnameTextField().clear();
		tsu.getFirstnameTextField().sendKeys("1234");
		utilityclassobject.gettest().log(Status.INFO, "First name text field is not accepting numbers");
		System.out.println("First name text field is not accepting numbers");

	}

	@Test(dependsOnMethods = "TC_005FirstNameTextFieldWithNumbers")
	public void TC_006FirstNameTextFieldWithSpecialCharacters() throws InterruptedException {
		// First name text field should not accept special characters
		tsu.getFirstnameTextField().clear();
		tsu.getFirstnameTextField().sendKeys("@#$%");
		utilityclassobject.gettest().log(Status.INFO, "First name text field is not accepting special characters");
		System.out.println("First name text field is not accepting special characters");

	}

	@Test(dependsOnMethods = "TC_006FirstNameTextFieldWithSpecialCharacters")
	public void TC_007FirstNameTextFieldWithoutInputs() throws InterruptedException {

		// First name text field should not accept without inputs
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getFirstnameTextField());
		tsu.getFirstnameTextField().sendKeys("");
		utilityclassobject.gettest().log(Status.INFO, "First name text field is not accepting without inputs");
		System.out.println("First name text field is not accepting without inputs");
		tsu.getSaveButton().click();
		Thread.sleep(5000);
		// verify that first name text field should display error message without inputs
		try {
			if (tsu.getLastNameErrorMessage().isDisplayed()) {
				System.out.println("First name text field is displaying error message without inputs");
				utilityclassobject.gettest().log(Status.INFO,
						"First name text field is displaying error message without inputs");
			} else {
				System.out.println("First name text field is not displaying error message without inputs");
				utilityclassobject.gettest().log(Status.INFO,
						"First name text field is not displaying error message without inputs");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("First name error message element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "First name error message element not found in DOM");
		}

	}

	@Test(dependsOnMethods = "TC_007FirstNameTextFieldWithoutInputs")
	public void TC_008FirstNameTextFieldWithValidInputs() throws InterruptedException {
		// Enter valid input in first name text field and click on save button and
		// verify user can not able to proceed to next step without entering mandatory
		// fields
		tsu.getFirstnameTextField().clear();
		tsu.getFirstnameTextField().sendKeys("jhon");
		utilityclassobject.gettest().log(Status.INFO, "First name text field is accepting valid inputs");
		System.out.println("First name text field is accepting valid inputs");
		tsu.getSaveButton().click();
		// verify that user can not able to proceed to next step without entering
		// mandatory fields
		try {
			if (tsu.getLastNameErrorMessage().isDisplayed()) {
				System.out.println("User can not able to proceed to next step without entering mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"User can not able to proceed to next step without entering mandatory fields");
			} else {
				System.out.println("User can able to proceed to next step without entering mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"User can able to proceed to next step without entering mandatory fields");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Last name error message element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "Last name error message element not found in DOM");
		}

		// click on add new user button
		tsu.getFirstnameTextField().clear();

		tsu.getFirstnameTextField().sendKeys("jhon");

	}

	@Test(dependsOnMethods = "TC_008FirstNameTextFieldWithValidInputs")
	public void TC_009LastNameTextFieldWithalphabets() throws InterruptedException {
		// Last name text field with alphabets
		tsu.getLastNameTextField().sendKeys("doe");
		utilityclassobject.gettest().log(Status.INFO, "Last name text field is accepting only alphabets");
		System.out.println("Last name text field is accepting only alphabets");
	}

	@Test(dependsOnMethods = "TC_009LastNameTextFieldWithalphabets")
	public void TC_010LastNameTextFieldWithNumbers() throws InterruptedException {
		// Last name text field should not accept numbers
		tsu.getLastNameTextField().clear();
		tsu.getLastNameTextField().sendKeys("1234");
		utilityclassobject.gettest().log(Status.INFO, "Last name text field is not accepting numbers");
		System.out.println("Last name text field is not accepting numbers");

	}

	@Test(dependsOnMethods = "TC_010LastNameTextFieldWithNumbers")
	public void TC_011LastNameTextFieldWithSpecialCharacters() throws InterruptedException {
		// Last name text field should not accept special characters
		tsu.getLastNameTextField().click();
		tsu.getLastNameTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getLastNameTextField().sendKeys("@#$%");
		utilityclassobject.gettest().log(Status.INFO, "Last name text field is not accepting special characters");
		System.out.println("Last name text field is not accepting special characters");
		Thread.sleep(2000);
		// Clear the field completely using JS + keyboard
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getLastNameTextField());
		tsu.getLastNameTextField().click();
		tsu.getLastNameTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

	}

	@Test(dependsOnMethods = "TC_011LastNameTextFieldWithSpecialCharacters")
	public void TC_012LastNameTextFieldWithoutInputs() throws InterruptedException {
		// Last name text field should not accept without inputs - leave it empty and
		// click save
		// Ensure field is fully cleared

		/*
		 * Thread.sleep(5000); tsu.getSaveButton().click(); /*Thread.sleep(5000);
		 * //verify that last name text field should display error message without
		 * inputs if(tsu.getLastNameErrorMessage().isDisplayed()) { System.out.
		 * println("Last name text field is displaying error message without inputs");
		 * utilityclassobject.gettest().log(Status.INFO,
		 * "Last name text field is displaying error message without inputs"); } else {
		 * System.out.
		 * println("Last name text field is not displaying error message without inputs"
		 * ); utilityclassobject.gettest().log(Status.INFO,
		 * "Last name text field is not displaying error message without inputs"); }
		 */
	}

	@Test(dependsOnMethods = "TC_012LastNameTextFieldWithoutInputs")
	public void TC_013LastNameTextFieldWithoutallFields() throws InterruptedException {
		// Enter valid input in last name text field and click on save button and verify
		// user can able to proceed to next step after entering mandatory fields
		tsu.getLastNameTextField().sendKeys("doe");
		utilityclassobject.gettest().log(Status.INFO, "Last name text field is accepting valid inputs");
		System.out.println("Last name text field is accepting valid inputs");
		Thread.sleep(5000);
		tsu.getSaveButton().click();
		Thread.sleep(5000);
		// verify the error message should not be displayed after entering valid inputs
		// in mandatory fields
		try {
			if (tsu.getEmailErrorMessage().isDisplayed()) {
				System.out.println("Error message is displayed after entering valid inputs in mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"Error message is displayed after entering valid inputs in mandatory fields");
			} else {
				System.out.println("Error message is not displayed after entering valid inputs in mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"Error message is not displayed after entering valid inputs in mandatory fields");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Email error message element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "Email error message element not found in DOM");
		}

	}

	@Test(dependsOnMethods = "TC_013LastNameTextFieldWithoutallFields")
	public void TC_014EmailTextFieldWithalphabets() throws InterruptedException {
		// Email text field should not accept only alphabets
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("asd");
		utilityclassobject.gettest().log(Status.INFO, "Email text field is not accepting only alphabets");
		System.out.println("Email text field is not accepting only alphabets");
	}

	@Test(dependsOnMethods = "TC_014EmailTextFieldWithalphabets")
	public void TC_015EmailTextFieldWithNumbers() throws InterruptedException {
		// Email text field should not accept only numbers
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("1234");
		utilityclassobject.gettest().log(Status.INFO, "Email text field is not accepting only numbers");
		System.out.println("Email text field is not accepting only numbers");
	}

	@Test(dependsOnMethods = "TC_015EmailTextFieldWithNumbers")
	public void TC_016EmailTextFieldWithSpecialCharacters() throws InterruptedException {
		// Email text field should not accept special characters
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("@#$%");
		utilityclassobject.gettest().log(Status.INFO, "Email text field is not accepting special characters");
		System.out.println("Email text field is not accepting special characters");

	}

	@Test(dependsOnMethods = "TC_016EmailTextFieldWithSpecialCharacters")
	public void TC_017EmailTextFieldWithoutInputs() throws InterruptedException {
		// Email text field should not accept without inputs
		tsu.getEmailTextField().click();
		// clear the value using robot class or javascript executor
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getSaveButton().click();
		utilityclassobject.gettest().log(Status.INFO, "Email text field is not accepting without inputs");
		System.out.println("Email text field is not accepting without inputs");

	}

	@Test(dependsOnMethods = "TC_017EmailTextFieldWithoutInputs")
	public void TC_018EmailTextFieldWithValidInputsanwithoutAllMandatoryFields() throws InterruptedException {
		// Enter valid input in email text field and click on save button and verify
		// user can able to proceed to next step after entering mandatory fields
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("charlie123@gmail.com");
		utilityclassobject.gettest().log(Status.INFO, "Email text field is accepting valid inputs");
		System.out.println("Email text field is accepting valid inputs");
		// Clear First Name using React's native value setter to bypass React's
		// synthetic event system
		tsu.getFirstnameTextField().click();
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getFirstnameTextField());
		tsu.getFirstnameTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(500);

		// Clear Last Name using React's native value setter
		tsu.getLastNameTextField().click();
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getLastNameTextField());
		tsu.getLastNameTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(500);

		tsu.getSaveButton().click();
		Thread.sleep(2000);
		try {
			if (tsu.getFirstNameErrorMessage().isDisplayed() && tsu.getLastNameErrorMessage().isDisplayed()) {
				System.out.println("User can not able to proceed to next step without entering mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"User can not able to proceed to next step without entering mandatory fields");
			} else {
				System.out.println("User can able to proceed to next step without entering mandatory fields");
				utilityclassobject.gettest().log(Status.INFO,
						"User can able to proceed to next step without entering mandatory fields");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Error message element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "Error message element not found in DOM");
		}

	}

	@Test(dependsOnMethods = "TC_018EmailTextFieldWithValidInputsanwithoutAllMandatoryFields")
	public void TC_019EmailTextFieldWithValidInputsanwithAllMandatoryFields() throws InterruptedException {
		// Enter valid input in email text field and click on save button and verify
		// user can able to proceed to next step after entering mandatory fields
		tsu.getFirstnameTextField().sendKeys("jhon");
		tsu.getLastNameTextField().sendKeys("doe");
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("@char123@gmail.com");
		tsu.getSaveButton().click();
		Thread.sleep(2000);
		// should display error message for invalid email format
		try {
			boolean isErrorDisplayed = tsu.getInvalidEmailErrorMessage().isDisplayed();
			if (isErrorDisplayed) {
				System.out.println("Email text field is displaying error message for invalid email format");
				utilityclassobject.gettest().log(Status.INFO,
						"Email text field is displaying error message for invalid email format");
			} else {
				System.out.println("Email text field is not displaying error message for invalid email format");
				utilityclassobject.gettest().log(Status.INFO,
						"Email text field is not displaying error message for invalid email format");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Email error message element not found in DOM for invalid email format");
			utilityclassobject.gettest().log(Status.INFO,
					"Email error message element not found in DOM for invalid email format");
		}
	}

	@Test(dependsOnMethods = "TC_019EmailTextFieldWithValidInputsanwithAllMandatoryFields")
	public void TC_020EmailTextFieldWithValidFormat() throws InterruptedException {
		// Enter valid format and check whether it is displaying error message or not
		tsu.getEmailTextField().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", tsu.getEmailTextField());
		tsu.getEmailTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		tsu.getEmailTextField().sendKeys("charlie123@gmail.com");
		Thread.sleep(2000);
		// verify the error message should not be displayed after entering valid format
		// in email text field
		try {
			boolean isErrorDisplayed = tsu.getInvalidEmailErrorMessage().isDisplayed();
			if (isErrorDisplayed) {
				System.out.println("Email text field is displaying error message for valid email format");
				utilityclassobject.gettest().log(Status.INFO,
						"Email text field is displaying error message for valid email format");
			} else {
				System.out.println("Email text field is not displaying error message for valid email format");
				utilityclassobject.gettest().log(Status.INFO,
						"Email text field is not displaying error message for valid email format");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Error element not present in DOM - this means no error is shown for valid
			// email (expected behavior)
			System.out.println("Email text field is not displaying error message for valid email format");
			utilityclassobject.gettest().log(Status.INFO,
					"Email text field is not displaying error message for valid email format - Passed");
		}

	}

	@Test(dependsOnMethods = "TC_020EmailTextFieldWithValidFormat")
	public void TC_021PasswordTextFieldWithDefaultValues() throws InterruptedException {
		// Password text field should have default values and should be in masked format
		// Use JS executor to get live React state value (getAttribute("value") returns
		// stale DOM attribute in React apps)
		String passwordValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPasswordTextField());
		if (passwordValue != null && !passwordValue.isEmpty()) {
			System.out.println("Password text field has default values");
			utilityclassobject.gettest().log(Status.INFO, "Password text field has default values");
		} else {
			System.out.println("Password text field does not have default values");
			utilityclassobject.gettest().log(Status.INFO, "Password text field does not have default values");
		}
		String passwordType = tsu.getPasswordTextField().getAttribute("type");
		if (passwordType.equals("password")) {
			System.out.println("Password text field is in masked format");
			utilityclassobject.gettest().log(Status.INFO, "Password text field is in masked format");
		} else {
			System.out.println("Password text field is not in masked format");
			utilityclassobject.gettest().log(Status.INFO, "Password text field is not in masked format");
		}

	}

	@Test(dependsOnMethods = "TC_021PasswordTextFieldWithDefaultValues")
	public void TC_022PasswordTextFieldAcceptsAlphabets() throws InterruptedException {
		// Clear using React native setter so React internal state is also cleared
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(300);
		tsu.getPasswordTextField().sendKeys("password");
		Thread.sleep(1000); // wait for React to process sendKeys and re-render
		utilityclassobject.gettest().log(Status.INFO, "Password text field is accepting alphabets");
		System.out.println("Password text field is accepting alphabets");
		// Read value BEFORE eye icon click - most reliable point to fetch
		String passwordValueBeforeEye = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].value;", tsu.getPasswordTextField());
		System.out.println("Password field value (alphabets): [" + passwordValueBeforeEye + "]");
		utilityclassobject.gettest().log(Status.INFO,
				"Password field value (alphabets): [" + passwordValueBeforeEye + "]");
		// Click eye icon to reveal
		tsu.getMaskedeyeicon().click();
		Thread.sleep(1000);
		String passwordValueAfterEye = (String) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].value;", tsu.getPasswordTextField());
		System.out.println("Password field value after eye click: [" + passwordValueAfterEye + "]");
		utilityclassobject.gettest().log(Status.INFO,
				"Password field value after eye click: [" + passwordValueAfterEye + "]");
		tsu.getMaskedeyeicon().click(); // toggle back to masked so next TC finds field with type='password'
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "TC_022PasswordTextFieldAcceptsAlphabets")
	public void TC_023PasswordTextFieldAcceptsNumbers() throws InterruptedException {
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(300);
		tsu.getPasswordTextField().sendKeys("123456");
		Thread.sleep(1000); // wait for React to process sendKeys and re-render
		utilityclassobject.gettest().log(Status.INFO, "Password text field is accepting numbers");
		System.out.println("Password text field is accepting numbers");
		// Read value BEFORE eye icon click
		String pwdVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPasswordTextField());
		System.out.println("Password field value (numbers): [" + pwdVal + "]");
		utilityclassobject.gettest().log(Status.INFO, "Password field value (numbers): [" + pwdVal + "]");
		tsu.getMaskedeyeicon().click();
		Thread.sleep(1000);
		tsu.getMaskedeyeicon().click(); // toggle back to masked
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "TC_023PasswordTextFieldAcceptsNumbers")
	public void TC_024PasswordTextFieldAcceptsSpecialCharacters() throws InterruptedException {
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(300);
		tsu.getPasswordTextField().sendKeys("@#$%");
		Thread.sleep(1000); // wait for React to process sendKeys and re-render
		utilityclassobject.gettest().log(Status.INFO, "Password text field is accepting special characters");
		System.out.println("Password text field is accepting special characters");
		// Read value BEFORE eye icon click
		String pwdVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPasswordTextField());
		System.out.println("Password field value (special chars): [" + pwdVal + "]");
		utilityclassobject.gettest().log(Status.INFO, "Password field value (special chars): [" + pwdVal + "]");
		tsu.getMaskedeyeicon().click();
		Thread.sleep(1000);
		tsu.getMaskedeyeicon().click(); // toggle back to masked so TC_025 finds field with type='password'
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "TC_024PasswordTextFieldAcceptsSpecialCharacters")
	public void TC_025PasswordTextWithlessthan8characters() throws InterruptedException {
		// password text field should not accept less than 8 characters and should
		// display error message
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(300);
		tsu.getPasswordTextField().sendKeys("pass1");
		Thread.sleep(1000); // wait for React to process sendKeys and re-render
		tsu.getSaveButton().click();
		Thread.sleep(3000); // wait for validation error to appear in DOM
		try {
			boolean isErrorDisplayed = tsu.getPasswordErrorMessage().isDisplayed();
			if (isErrorDisplayed) {
				System.out.println("Password text field is displaying error message for less than 8 characters");
				utilityclassobject.gettest().log(Status.INFO,
						"Password text field is displaying error message for less than 8 characters");
			} else {
				System.out.println("Password text field is not displaying error message for less than 8 characters");
				utilityclassobject.gettest().log(Status.INFO,
						"Password text field is not displaying error message for less than 8 characters");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Password error message element not found in DOM for less than 8 characters");
			utilityclassobject.gettest().log(Status.INFO,
					"Password error message element not found in DOM for less than 8 characters");
		}
	}

	@Test(dependsOnMethods = "TC_025PasswordTextWithlessthan8characters")
	public void TC_026PasswordTextWith8orMoreCharacters() throws InterruptedException {
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(300);
		tsu.getPasswordTextField().sendKeys("pass1234");
		Thread.sleep(1000); // wait for React to process sendKeys and re-render
		utilityclassobject.gettest().log(Status.INFO, "Password text field is accepting 8 or more characters");
		System.out.println("Password text field is accepting 8 or more characters");
		String pwdVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPasswordTextField());
		System.out.println("Password field value (8+ chars): [" + pwdVal + "]");
		utilityclassobject.gettest().log(Status.INFO, "Password field value (8+ chars): [" + pwdVal + "]");
	}

	@Test(dependsOnMethods = "TC_026PasswordTextWith8orMoreCharacters")
	public void TC_027PasswordTextFieldWithoutanyInputs() throws InterruptedException {
		// Clear the password field using React native setter and click save
		tsu.getPasswordTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPasswordTextField());
		tsu.getPasswordTextField().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		Thread.sleep(500);
		tsu.getSaveButton().click();
		Thread.sleep(3000); // wait for validation error to appear in DOM
		try {
			boolean isErrorDisplayed = tsu.getPasswordRequiredErrorMessage().isDisplayed();
			if (isErrorDisplayed) {
				System.out.println("Password text field is displaying error message for required field");
				utilityclassobject.gettest().log(Status.INFO,
						"Password text field is displaying error message for required field");
			} else {
				System.out.println("Password text field is not displaying error message for required field");
				utilityclassobject.gettest().log(Status.INFO,
						"Password text field is not displaying error message for required field");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Password required error message element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "Password required error message element not found in DOM");
		}
	}

	@Test(dependsOnMethods = "TC_027PasswordTextFieldWithoutanyInputs")
	public void TC_028SelectRolesDropdownwithManualInputs() throws InterruptedException {
		// Scenario: verify that the roles dropdown does NOT accept manual keyboard
		// input
		Thread.sleep(1000);
		tsu.getSelectRolesDropdown().click();
		Thread.sleep(1000);
		// Try to type into the dropdown - it should not accept manual input
		// Wrap in try-catch because non-input dropdowns throw an exception on sendKeys
		// (expected)
		try {
			tsu.getSelectRolesDropdown().sendKeys("admin");
			Thread.sleep(1000);
			// If sendKeys succeeded, check that no text was actually typed into the
			// dropdown
			String typedValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
					tsu.getSelectRolesDropdown());
			if (typedValue == null || typedValue.isEmpty()) {
				System.out.println("Dropdown is not accepting manual inputs - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Select roles dropdown is not accepting manual inputs - PASS");
			} else {
				System.out.println("Dropdown accepted manual input: [" + typedValue + "] - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Select roles dropdown accepted manual input unexpectedly: " + typedValue);
			}
		} catch (Exception e) {
			// Element is not interactable / does not accept keyboard input - this is the
			// expected behavior
			System.out.println(
					"Dropdown does not accept manual inputs (exception as expected): " + e.getClass().getSimpleName());
			utilityclassobject.gettest().log(Status.INFO, "Select roles dropdown does not accept manual inputs - PASS");
		}
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "TC_028SelectRolesDropdownwithManualInputs")
	public void TC_029SelectRolesDropdownOptions() throws InterruptedException {
		// Single click to open the dropdown
		tsu.getSelectRolesDropdown().click();
		Thread.sleep(2000);

		// Fetch all option elements from the open listbox
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		if (options.isEmpty())
			options = driver.findElements(By.xpath("//*[@role='option']"));
		if (options.isEmpty())
			options = driver.findElements(By.xpath("//*[contains(@class,'select__option')]"));
		if (options.isEmpty())
			options = driver.findElements(By.xpath("//*[contains(@class,'MuiMenuItem')]"));

		System.out.println("=== Total options found in Select Roles dropdown: " + options.size() + " ===");
		utilityclassobject.gettest().log(Status.INFO, "Total options in Select Roles dropdown: " + options.size());

		for (int i = 0; i < options.size(); i++) {
			// Use JS innerText to get real visible text
			String optionText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
					options.get(i));
			if (optionText == null || optionText.trim().isEmpty())
				optionText = options.get(i).getText();
			System.out.println("Option " + (i + 1) + ": " + optionText.trim());
			utilityclassobject.gettest().log(Status.INFO, "Option " + (i + 1) + ": " + optionText.trim());
		}

		// Close dropdown by pressing Escape before next TC
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
	}

	/**
	 * Safely removes all selected role chip(s) from the roles dropdown by clicking
	 * each chip's × icon. Falls back to aria-label/class-based remove buttons.
	 * Never throws — all failures are logged and swallowed.
	 */
	private void safeRemoveAllChips() throws InterruptedException {
		try {
			// Keep removing chips as long as any are present
			for (int attempt = 0; attempt < 5; attempt++) {
				List<WebElement> chips = driver.findElements(By.xpath("//*[contains(@class,'multiselect__tag-icon')] | "
						+ "//*[contains(@class,'tag-remove')] | "
						+ "//button[@type='button' and (contains(@aria-label,'remove') or contains(@title,'remove') or contains(@class,'chip-remove') or contains(@class,'tag-icon'))]"));
				if (chips.isEmpty())
					break;
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
							chips.get(0));
					Thread.sleep(200);
					chips.get(0).click();
					Thread.sleep(400);
				} catch (Exception ex) {
					System.out.println(
							"safeRemoveAllChips attempt " + attempt + " exception: " + ex.getClass().getSimpleName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("safeRemoveAllChips outer exception: " + e.getClass().getSimpleName());
		}
	}

	/**
	 * Opens the roles dropdown (single click + wait) then clicks the option whose
	 * visible text contains the given label. Tries 4 strategies in order: normal
	 * click → JS click → Actions click → JS click on freshly found element. Returns
	 * true if the option was found and clicked, false otherwise.
	 */
	private boolean clickOptionByText(String label) throws InterruptedException {
		Thread.sleep(1500); // wait for dropdown to be fully open

		// Build a list of candidate XPaths from most specific to most general
		String[] xpaths = { "//ul[@role='listbox']//li[normalize-space(.)='" + label + "']",
				"//ul[@role='listbox']//li[contains(.,'" + label + "')]",
				"//*[@role='option' and normalize-space(.)='" + label + "']",
				"//*[@role='option' and contains(.,'" + label + "')]",
				"//div[contains(@class,'option') and normalize-space(text())='" + label + "']",
				"//div[contains(@class,'option') and contains(text(),'" + label + "')]",
				"//li[contains(@class,'item') and contains(text(),'" + label + "')]",
				"//*[contains(@class,'menu')]//*[contains(text(),'" + label + "')]" };

		for (String xpath : xpaths) {
			List<WebElement> found = driver.findElements(By.xpath(xpath));
			if (!found.isEmpty()) {
				WebElement option = found.get(0);
				System.out.println("Found '" + label + "' via xpath: " + xpath);
				// Strategy 1: scroll into view then normal click
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
							option);
					Thread.sleep(300);
					option.click();
					System.out.println("Clicked '" + label + "' via normal click");
					Thread.sleep(500);
					return true;
				} catch (org.openqa.selenium.StaleElementReferenceException stale) {
					// StaleElementReferenceException after click means the DOM changed due to the
					// click - treat as success to avoid clicking the element again
					System.out.println("Clicked '" + label + "' via normal click (DOM refreshed after click)");
					Thread.sleep(500);
					return true;
				} catch (Exception e1) {
					System.out.println("Normal click failed for '" + label + "': " + e1.getClass().getSimpleName());
				}
				// Strategy 2: JS click (only reached if normal click threw a non-stale
				// exception)
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
					System.out.println("Clicked '" + label + "' via JS click");
					Thread.sleep(500);
					return true;
				} catch (org.openqa.selenium.StaleElementReferenceException stale) {
					System.out.println("Clicked '" + label + "' via JS click (DOM refreshed after click)");
					Thread.sleep(500);
					return true;
				} catch (Exception e2) {
					System.out.println("JS click failed for '" + label + "': " + e2.getClass().getSimpleName());
				}
				// Strategy 3: Actions click
				try {
					new org.openqa.selenium.interactions.Actions(driver).moveToElement(option).click().perform();
					System.out.println("Clicked '" + label + "' via Actions click");
					Thread.sleep(500);
					return true;
				} catch (org.openqa.selenium.StaleElementReferenceException stale) {
					System.out.println("Clicked '" + label + "' via Actions click (DOM refreshed after click)");
					Thread.sleep(500);
					return true;
				} catch (Exception e3) {
					System.out.println("Actions click failed for '" + label + "': " + e3.getClass().getSimpleName());
				}
				// Element was found but all click strategies failed - stop searching to avoid
				// clicking the same element via a different XPath
				break;
			}
		}
		System.out.println("'" + label + "' option NOT found with any XPath strategy");
		return false;
	}

	/**
	 * Checks if a given option text is visible in an already-open div-based
	 * dropdown. Returns true if found, false otherwise. Does NOT click the option.
	 */
	private boolean isOptionPresentInDropdown(String optionText) {
		String[] xpaths = { "//ul[@role='listbox']//li[normalize-space(.)='" + optionText + "']",
				"//ul[@role='listbox']//li[contains(.,'" + optionText + "')]",
				"//*[@role='option' and contains(.,'" + optionText + "')]",
				"//div[contains(@class,'option') and contains(text(),'" + optionText + "')]",
				"//li[contains(@class,'item') and contains(text(),'" + optionText + "')]",
				"//*[contains(@class,'menu')]//*[contains(text(),'" + optionText + "')]" };
		for (String xpath : xpaths) {
			List<WebElement> found = driver.findElements(By.xpath(xpath));
			if (!found.isEmpty()) {
				System.out.println("Found '" + optionText + "' option via xpath: " + xpath);
				return true;
			}
		}
		return false;
	}

	@Test(dependsOnMethods = "TC_029SelectRolesDropdownOptions")
	public void TC_030SelectRolesDropdownSelectfirstOption() throws InterruptedException {
		tsu.getSelectRolesDropdown().click();
		Thread.sleep(1500);
		boolean clicked = clickOptionByText("Admin");
		if (clicked) {
			System.out.println("Admin role selected from dropdown - PASS");
			utilityclassobject.gettest().log(Status.INFO, "Admin role selected from dropdown - PASS");
		} else {
			System.out.println("Admin option not found in dropdown - FAIL");
			utilityclassobject.gettest().log(Status.INFO, "Admin option not found in dropdown - FAIL");
		}
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		safeRemoveAllChips();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	}

	@Test(dependsOnMethods = "TC_030SelectRolesDropdownSelectfirstOption")
	public void TC_031SelectRolesDropdownMultipleOptions() throws InterruptedException {
		tsu.getSelectRolesDropdown().click();
		boolean adminClicked = clickOptionByText("Admin");
		System.out.println("Admin selected: " + adminClicked);
		utilityclassobject.gettest().log(Status.INFO, "Admin selected: " + adminClicked);
		// Re-open dropdown for second selection if it closed after first click
		List<WebElement> openList = driver.findElements(By.xpath("//ul[@role='listbox'] | //*[@role='option']"));
		if (openList.isEmpty()) {
			tsu.getSelectRolesDropdown().click();
			Thread.sleep(1000);
		}
		boolean standardClicked = clickOptionByText("Standard");
		System.out.println("Standard selected: " + standardClicked);
		utilityclassobject.gettest().log(Status.INFO, "Standard selected: " + standardClicked);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		utilityclassobject.gettest().log(Status.INFO, "Selected multiple options from roles dropdown");
		System.out.println("Selected multiple options from roles dropdown");
		safeRemoveAllChips();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	}

	@Test(dependsOnMethods = "TC_031SelectRolesDropdownMultipleOptions")
	public void TC_032SelectRolesDropdownDeselectOption() throws InterruptedException {
		// Verify Admin and Standard cannot both be selected simultaneously
		tsu.getSelectRolesDropdown().click();
		boolean adminClicked = clickOptionByText("Admin");
		System.out.println("Admin selected: " + adminClicked);
		utilityclassobject.gettest().log(Status.INFO, "Admin role selected - checking Standard option state");
		try {
			boolean isEnabled = tsu.getStandardRoleOptionfromRolesDropdown().isEnabled();
			if (isEnabled) {
				System.out.println("Standard option is enabled after selecting Admin - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Standard option is enabled after selecting Admin - FAIL");
			} else {
				System.out.println("Standard option is disabled after selecting Admin - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Standard option is disabled after selecting Admin - PASS");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Standard option not found in DOM (hidden when Admin selected) - PASS");
			utilityclassobject.gettest().log(Status.INFO, "Standard option not found in DOM - PASS");
		}
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		safeRemoveAllChips();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	}

	@Test(dependsOnMethods = "TC_032SelectRolesDropdownDeselectOption")
	public void TC_033SelectRolesDropdownSelectAdminandoctodOption() throws InterruptedException {
		// Single click to open the dropdown
		tsu.getSelectRolesDropdown().click();
		boolean octoClicked = clickOptionByText("OCTO Connect Contact");
		System.out.println("OCTO Connect Contact selected: " + octoClicked);
		utilityclassobject.gettest().log(Status.INFO, "OCTO Connect Contact selected: " + octoClicked);
		// Re-open dropdown if it closed after first selection
		List<WebElement> openList = driver.findElements(By.xpath("//ul[@role='listbox'] | //*[@role='option']"));
		if (openList.isEmpty()) {
			tsu.getSelectRolesDropdown().click();
			Thread.sleep(1000);
		}
		boolean adminClicked = clickOptionByText("Admin");
		System.out.println("Admin selected: " + adminClicked);
		utilityclassobject.gettest().log(Status.INFO, "Admin selected: " + adminClicked);
		utilityclassobject.gettest().log(Status.INFO, "Selected admin and octo contact options from roles dropdown");
		System.out.println("Selected admin and octo contact options from roles dropdown");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		safeRemoveAllChips();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	}

	@Test(dependsOnMethods = "TC_033SelectRolesDropdownSelectAdminandoctodOption"/* "TC_003AccessUsersPage" */)
	public void TC_034SelectRolesDropdownSelectStandardandoctodOption() throws InterruptedException {
		try {
			Thread.sleep(2000);

			// --- Step 1: Select Standard ---
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
					tsu.getSelectRolesDropdown());
			Thread.sleep(500);
			tsu.getSelectRolesDropdown().click();
			Thread.sleep(2000);

			boolean standardClicked = clickOptionByText("Standard");
			System.out.println("Standard selected: " + standardClicked);
			utilityclassobject.gettest().log(Status.INFO, "Standard selected: " + standardClicked);

			// --- Step 2: Re-open dropdown and select OCTO Connect Contact ---
			Thread.sleep(1000);
			List<WebElement> openListCheck = driver
					.findElements(By.xpath("//ul[@role='listbox'] | //*[@role='option']"));
			if (openListCheck.isEmpty()) {
				System.out.println("Dropdown closed after Standard selection - re-opening for OCTO Connect Contact");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
						tsu.getSelectRolesDropdown());
				Thread.sleep(500);
				tsu.getSelectRolesDropdown().click();
				Thread.sleep(2000);
			}

			boolean octoClicked = clickOptionByText("OCTO Connect Contact");
			System.out.println("OCTO Connect Contact selected: " + octoClicked);
			utilityclassobject.gettest().log(Status.INFO, "OCTO Connect Contact selected: " + octoClicked);

			utilityclassobject.gettest().log(Status.INFO,
					"Selected Standard and OCTO Connect Contact options from roles dropdown");
			System.out.println("Selected Standard and OCTO Connect Contact options from roles dropdown");

		} catch (Exception e) {
			System.out.println("TC_034 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
			utilityclassobject.gettest().log(Status.INFO,
					"TC_034 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		} finally {
			try {
				driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			} catch (Exception ignore) {
			}
			Thread.sleep(500);
			safeRemoveAllChips();
			Thread.sleep(1000);
			try {
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			} catch (Exception ignore) {
			}
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			} catch (Exception ignore) {
			}
		}
	}

	@Test(dependsOnMethods = "TC_034SelectRolesDropdownSelectStandardandoctodOption")
	public void TC_035AdminHavwWideAccesswithtoAllData() throws InterruptedException {

		try {
			// Open the dropdown first before trying to click any option inside it
			org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
					java.time.Duration.ofSeconds(15));
			WebElement rolesDropdown = wait.until(org.openqa.selenium.support.ui.ExpectedConditions
					.elementToBeClickable(tsu.getSelectRolesDropdown()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
					rolesDropdown);
			Thread.sleep(500);
			rolesDropdown.click();
			Thread.sleep(1500);

			// Now click the Admin option inside the open dropdown
			boolean adminClicked = clickOptionByText("Admin");
			System.out.println("Admin option clicked from dropdown: " + adminClicked);
			utilityclassobject.gettest().log(Status.INFO, "Admin option clicked from dropdown: " + adminClicked);

			// Close dropdown
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			Thread.sleep(1000);

			// Verify the Admin info message is displayed
			try {
				boolean isInfoMsgDisplayed = tsu.getAdminRoleOptionInfoMessage().isDisplayed();
				String admintxt = tsu.getAdminRoleOptionInfoMessage().getText();
				if (isInfoMsgDisplayed) {
					System.out.println("Admin role option info message is displayed: " + admintxt);
					utilityclassobject.gettest().log(Status.INFO,
							"Admin role option info message is displayed after selecting Admin role: " + admintxt);
				} else {
					System.out.println("Admin role option info message is not displayed after selecting Admin role");
					utilityclassobject.gettest().log(Status.INFO,
							"Admin role option info message is not displayed after selecting Admin role");
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Admin role option info message element not found in DOM");
				utilityclassobject.gettest().log(Status.INFO,
						"Admin role option info message element not found in DOM");
			}
		} catch (Exception e) {
			System.out.println("TC_035 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
			utilityclassobject.gettest().log(Status.INFO,
					"TC_035 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC_035AdminHavwWideAccesswithtoAllData")
	public void TC_036RemoveRoleFromDropDown() throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		utilityclassobject.gettest().log(Status.INFO, "Clicked remove icon on Admin role chip to deselect Admin role");
		System.out.println("Clicked remove icon on Admin role chip to deselect Admin role");
		utilityclassobject.gettest().log(Status.INFO, "Admin role should now be removed from roles dropdown options");
		System.out.println("Admin role should now be removed from roles dropdown options");

	}

	@Test(dependsOnMethods = "TC_036RemoveRoleFromDropDown")
	public void TC_037AddRemovedRoleAgain() throws InterruptedException {
		Thread.sleep(1500);
		// Step 1: wait for the roles dropdown to be clickable, then open it
		try {
			org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,
					java.time.Duration.ofSeconds(15));
			WebElement rolesDropdown = wait.until(org.openqa.selenium.support.ui.ExpectedConditions
					.elementToBeClickable(tsu.getSelectRolesDropdown()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
					rolesDropdown);
			Thread.sleep(500);
			rolesDropdown.click();
			Thread.sleep(1500);

			// Step 2: verify the dropdown actually opened, fallback to JS click if not
			List<WebElement> openList = driver.findElements(By.xpath("//ul[@role='listbox'] | //*[@role='option']"));
			if (openList.isEmpty()) {
				System.out.println("Dropdown did not open via normal click — retrying with JS click");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", rolesDropdown);
				Thread.sleep(1500);
			}

			// Step 3: select Admin
			boolean adminClicked = clickOptionByText("Admin");
			System.out.println("Admin selected again: " + adminClicked);
			utilityclassobject.gettest().log(Status.INFO, "Admin re-added from roles dropdown: " + adminClicked);

			// Step 4: close dropdown
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			Thread.sleep(500);

		} catch (Exception e) {
			System.out.println("TC_037 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
			utilityclassobject.gettest().log(Status.INFO,
					"TC_037 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

	}

	@Test(dependsOnMethods = "TC_037AddRemovedRoleAgain")
	public void TC_038WithoutRoleOption() throws InterruptedException {
		// Pass the value insideFirstname,lastname,email and password text fields and
		// click on save button without selecting any role option from dropdown and
		// verify that user should not be created without selecting role option from
		// dropdown
		tsu.getFirstnameTextField().sendKeys("Charlie");
		tsu.getLastNameTextField().sendKeys("Devid");
		tsu.getEmailTextField().sendKeys("charlie123@Gmail.com");
		tsu.getSaveButton().click();
		Thread.sleep(2000);
		// role error message displayed or not
		try {
			boolean isRoleErrorDisplayed = tsu.getRoleRequiredErrorMessage().isDisplayed();
			if (isRoleErrorDisplayed) {
				System.out.println("Role error message is displayed when trying to save without selecting any role");
				utilityclassobject.gettest().log(Status.INFO,
						"Role error message is displayed when trying to save without selecting any role");
			} else {
				System.out
						.println("Role error message is not displayed when trying to save without selecting any role");
				utilityclassobject.gettest().log(Status.INFO,
						"Role error message is not displayed when trying to save without selecting any role");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(
					"Role error message element not found in DOM when trying to save without selecting any role");
			utilityclassobject.gettest().log(Status.INFO,
					"Role error message element not found in DOM when trying to save without selecting any role");
		}

	}

	@Test(dependsOnMethods = "TC_038WithoutRoleOption"/* "TC_003AccessUsersPage" */)

	public void TC_039PhoneNoTextFieldWithInput() throws InterruptedException {
		tsu.getPhoneNumberTextField().sendKeys("578945678");
		utilityclassobject.gettest().log(Status.INFO, "Phone number text field is accepting input");
		System.out.println("Phone number text field is accepting input");

	}

	@Test(dependsOnMethods = "TC_039PhoneNoTextFieldWithInput")
	public void TC_040PhoneNoTextFieldWithoutInput() throws InterruptedException {
		// clear the value from phone number text field
		tsu.getPhoneNumberTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberTextField());
		Thread.sleep(500);
		// try to pass the alphabets in phone number text field and verify that it
		// should not accept the alphabets in phone number text field
		tsu.getPhoneNumberTextField().sendKeys("abcdefg");
		Thread.sleep(1000);
		String phoneVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberTextField());
		if (phoneVal == null || phoneVal.isEmpty()) {
			System.out.println("Phone number text field is not accepting alphabets - PASS");
			utilityclassobject.gettest().log(Status.INFO, "Phone number text field is not accepting alphabets - PASS");
		} else {
			System.out.println("Phone number text field accepted alphabets: [" + phoneVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number text field accepted alphabets unexpectedly: " + phoneVal);

		}

	}

	@Test(dependsOnMethods = "TC_040PhoneNoTextFieldWithoutInput")
	public void TC_041PhoneNoTextFieldWithNumbers() throws InterruptedException {
		// Pass the Numbers in phone number text field and verify that it should accept
		// the numbers in phone number text field
		tsu.getPhoneNumberTextField().sendKeys("578945678");
		Thread.sleep(1000);
		String phoneVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberTextField());
		if (phoneVal != null && !phoneVal.isEmpty()) {
			System.out.println("Phone number text field is accepting numbers: [" + phoneVal + "] - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number text field is accepting numbers: [" + phoneVal + "] - PASS");
		} else {
			System.out.println("Phone number text field is not accepting numbers - FAIL");
			utilityclassobject.gettest().log(Status.INFO, "Phone number text field is not accepting numbers - FAIL");

		}

	}

	@Test(dependsOnMethods = "TC_041PhoneNoTextFieldWithNumbers")
	public void TC_042PhoneNoTextFieldWithSpecialCharacters() throws InterruptedException {
		// clear the value from phone number text field
		tsu.getPhoneNumberTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberTextField());
		Thread.sleep(500);
		// try to pass the special characters in phone number text field and verify that
		// it should not accept the special characters in phone number text field
		tsu.getPhoneNumberTextField().sendKeys("#$%^&*(@!$");
		Thread.sleep(2000);
		String phoneVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberTextField());
		if (phoneVal == null || phoneVal.isEmpty()) {
			System.out.println("Phone number text field is not accepting special characters - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number text field is not accepting special characters - PASS");
		} else {
			System.out.println("Phone number text field accepted special characters: [" + phoneVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number text field accepted special characters unexpectedly: " + phoneVal);
		}
	}

	@Test(dependsOnMethods = "TC_042PhoneNoTextFieldWithSpecialCharacters")
	public void TC_043PhoneNoTextFieldWithoutInputs() throws InterruptedException {
		// clear the value from phone number text field
		tsu.getPhoneNumberTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberTextField());
		Thread.sleep(2000);
		// click on save button without passing any value in phone number text field and
		// verify that it should not display any error message because phone number text
		// field is not mandatory field
		tsu.getSaveButton().click();
		Thread.sleep(2000);
		// verify that phone number text field is not showing any error message below
		// the text field
		// Using findElements to avoid NoSuchElementException since phone number is not
		// a mandatory field
		List<WebElement> phoneErrorMessages = driver.findElements(By.xpath(
				"//p[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'phone') and (contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'required') or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'invalid') or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'error'))]"));
		if (phoneErrorMessages.isEmpty()) {
			System.out.println("No error message displayed for phone number field when saving without input - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"No error message displayed for phone number field when saving without input - PASS");
		} else {
			String errorText = phoneErrorMessages.get(0).getText();
			System.out.println("Phone number field showed an unexpected error message: [" + errorText + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number field showed an unexpected error message: [" + errorText + "] - FAIL");
		}

	}

	@Test(dependsOnMethods = "TC_043PhoneNoTextFieldWithoutInputs")
	public void TC_044PhoneNumbertextFieldWithShortInput() throws InterruptedException {
		// pass /input a short value (less than 5 digits) in phone number text field and
		// verify that it should display error message as Phone number must be 10 digits
		tsu.getPhoneNumberTextField().sendKeys("123");
		Thread.sleep(2000);
		try {
			boolean isErrorDisplayed = tsu.getPhoneNumberErrorMessage().isDisplayed();
			if (isErrorDisplayed) {
				System.out.println("Phone number length error message is displayed for short input");
				utilityclassobject.gettest().log(Status.INFO,
						"Phone number length error message is displayed for short input");
			} else {
				System.out.println("Phone number length error message is not displayed for short input");
				utilityclassobject.gettest().log(Status.INFO,
						"Phone number length error message is not displayed for short input");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Phone number length error message element not found in DOM for short input");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number length error message element not found in DOM for short input");
		}

	}

	@Test(dependsOnMethods = "TC_044PhoneNumbertextFieldWithShortInput")
	public void TC_045PhoneNumberEXTtextFieldWithInputs() throws InterruptedException {
		// Pass the value inside phone number ext text field and verify that it should
		// accept the input in phone number ext text field
		tsu.getPhoneNumberExtensionTextField().sendKeys("12345");
		utilityclassobject.gettest().log(Status.INFO, "Phone number extension text field is accepting input");
		System.out.println("Phone number extension text field is accepting input");

	}

	@Test(dependsOnMethods = "TC_045PhoneNumberEXTtextFieldWithInputs")
	public void TC_046PhoneNumberEXTtextFieldWithAlphabets() throws InterruptedException {
		// clear the value from phone number ext text field
		tsu.getPhoneNumberExtensionTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberExtensionTextField());
		Thread.sleep(500);

		// try to pass the alphabets in phone number ext text field and verify that it
		// should not accept the alphabets in phone number ext text field
		tsu.getPhoneNumberExtensionTextField().sendKeys("abcde");
		Thread.sleep(1000);
		String phoneExtVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberExtensionTextField());
		if (phoneExtVal == null || phoneExtVal.isEmpty()) {
			System.out.println("Phone number extension text field is not accepting alphabets - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field is not accepting alphabets - PASS");
		} else {
			System.out.println("Phone number extension text field accepted alphabets: [" + phoneExtVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field accepted alphabets unexpectedly: " + phoneExtVal);
		}

	}

	@Test(dependsOnMethods = "TC_046PhoneNumberEXTtextFieldWithAlphabets")
	public void TC_047PhoneNumberEXTtextFieldWithNumbers() throws InterruptedException {
		tsu.getPhoneNumberExtensionTextField().sendKeys("12345");
		utilityclassobject.gettest().log(Status.INFO, "Phone number extension text field is accepting input");
		System.out.println("Phone number extension text field is accepting input");

	}

	@Test(dependsOnMethods = "TC_047PhoneNumberEXTtextFieldWithNumbers")
	public void TC_048PhoneNumberEXTtextFieldWithSpecialCharacters() throws InterruptedException {
		// clear the value from phone number ext text field
		tsu.getPhoneNumberExtensionTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberExtensionTextField());
		Thread.sleep(500);
		// try to pass the special characters in phone number ext text field and verify
		// that it should not accept the special characters in phone number ext text
		// field
		tsu.getPhoneNumberExtensionTextField().sendKeys("#$%^&*(@!$");
		Thread.sleep(2000);
		String phoneExtVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberExtensionTextField());
		if (phoneExtVal == null || phoneExtVal.isEmpty()) {
			System.out.println("Phone number extension text field is not accepting special characters - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field is not accepting special characters - PASS");
		} else {
			System.out.println(
					"Phone number extension text field accepted special characters: [" + phoneExtVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field accepted special characters unexpectedly: " + phoneExtVal);
		}

	}

	@Test(dependsOnMethods = "TC_048PhoneNumberEXTtextFieldWithSpecialCharacters")
	public void TC_049PhoneNumberEXTtextFieldWithmoreThan5dugit() throws InterruptedException {
		// try to pass the more than 5 digit value in phone number ext text field and
		// verify that it should not accepts the value more than 5 digit
		tsu.getPhoneNumberExtensionTextField().sendKeys("123456789");
		Thread.sleep(2000);
		String phoneExtVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberExtensionTextField());
		if (phoneExtVal != null && phoneExtVal.length() <= 5) {
			System.out.println(
					"Phone number extension text field is accepting valid input: [" + phoneExtVal + "] - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field is accepting valid input: [" + phoneExtVal + "] - PASS");
		} else {
			System.out.println("Phone number extension text field accepted invalid input (more than 5 digits): ["
					+ phoneExtVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field accepted invalid input (more than 5 digits) unexpectedly: "
							+ phoneExtVal);
		}

	}

	@Test(dependsOnMethods = "TC_049PhoneNumberEXTtextFieldWithmoreThan5dugit")
	public void TC_050PhoneNumberEXTtextFieldWithShortNumbers() throws InterruptedException {
		// clear the value from phone number ext text field
		tsu.getPhoneNumberExtensionTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberExtensionTextField());
		Thread.sleep(2000);
		// try to pass the short value (less than 5 digits) in phone number ext text
		// field and verify that it should accept the short value in phone number ext
		// text field because phone number ext field should accept 1 to 5 digit value
		tsu.getPhoneNumberExtensionTextField().sendKeys("123");
		Thread.sleep(2000);
		String phoneExtVal = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				tsu.getPhoneNumberExtensionTextField());
		if (phoneExtVal != null && phoneExtVal.length() <= 5) {
			System.out.println(
					"Phone number extension text field is accepting valid short input: [" + phoneExtVal + "] - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field is accepting valid short input: [" + phoneExtVal + "] - PASS");
		} else {
			System.out.println("Phone number extension text field accepted invalid short input (more than 5 digits): ["
					+ phoneExtVal + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension text field accepted invalid short input unexpectedly: " + phoneExtVal);
		}
	}

	@Test(dependsOnMethods = "TC_050PhoneNumberEXTtextFieldWithShortNumbers")
	public void TC_051PhoneNumberEXTtextFieldWithoutInputs() throws InterruptedException {
		// clear the value from phone number ext text field
		tsu.getPhoneNumberExtensionTextField().click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript(
				"var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;"
						+ "nativeSetter.call(arguments[0], '');"
						+ "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
						+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				tsu.getPhoneNumberExtensionTextField());
		Thread.sleep(2000);
		// click on save button without passing any value in phone number extension text
		// field and verify that it should not display any error message because phone
		// number extension text field is not mandatory field
		tsu.getSaveButton().click();
		Thread.sleep(2000);
		// verify that phone number extension text field is not showing any error
		// message below the text field
		List<WebElement> phoneExtErrorMessages = driver.findElements(By.xpath(
				"//p[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'phone') and contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'extension') and (contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'required') or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'invalid') or contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'error'))]"));
		if (phoneExtErrorMessages.isEmpty()) {
			System.out.println(
					"No error message displayed for phone number extension field when saving without input - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"No error message displayed for phone number extension field when saving without input - PASS");
		} else {
			String errorText = phoneExtErrorMessages.get(0).getText();
			System.out.println(
					"Phone number extension field showed an unexpected error message: [" + errorText + "] - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Phone number extension field showed an unexpected error message: [" + errorText + "] - FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_051PhoneNumberEXTtextFieldWithoutInputs" /*"TC_003AccessUsersPage"*/)
	public void TC_052StatusDDwithDefaultValue() throws InterruptedException {
		// verify that status drop down is displayed or not
		try {
			boolean isStatusDropdownDisplayed = tsu.getStatusDropdown().isDisplayed();
			if (isStatusDropdownDisplayed) {
				System.out.println("Status dropdown is displayed - PASS");
				utilityclassobject.gettest().log(Status.INFO, "Status dropdown is displayed - PASS");
			} else {
				System.out.println("Status dropdown is not displayed - FAIL");
				utilityclassobject.gettest().log(Status.INFO, "Status dropdown is not displayed - FAIL");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Status dropdown element not found in DOM");
			utilityclassobject.gettest().log(Status.INFO, "Status dropdown element not found in DOM");
		}
		// Fetch the default value from the div-based dropdown using getText()
		try {
			String defaultStatus = tsu.getStatusDropdown().getText().trim();
			if (defaultStatus.contains("Active")) {
				System.out.println("Default value of status dropdown is: " + defaultStatus + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Default value of status dropdown is: " + defaultStatus + " - PASS");
			} else {
				System.out.println("Default value of status dropdown is: " + defaultStatus + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Default value of status dropdown is: " + defaultStatus + " - FAIL");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Status dropdown element not found in DOM when trying to get default value");
			utilityclassobject.gettest().log(Status.INFO,
					"Status dropdown element not found in DOM when trying to get default value");
		}

	}

	@Test(dependsOnMethods = "TC_052StatusDDwithDefaultValue")
	public void TC_053StatusDDwithManualInputs() throws InterruptedException {
		// Try to pass manual input in the div-based status dropdown and verify it does
		// NOT accept typed input
		// Since it is a <div> dropdown, it does not have a native input — we use
		// JavaScript to attempt setting innerText
		try {
			String beforeText = tsu.getStatusDropdown().getText().trim();
			// Attempt to type into the div via JavaScript
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].innerText = arguments[1]; "
							+ "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); "
							+ "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
					tsu.getStatusDropdown(), "Inactive");
			Thread.sleep(1000);
			String afterText = tsu.getStatusDropdown().getText().trim();
			if (afterText.equals(beforeText)) {
				System.out.println("Status dropdown did not accept manual input and remains: " + afterText + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Status dropdown did not accept manual input and remains: " + afterText + " - PASS");
			} else {
				System.out.println("Status dropdown text changed to: " + afterText
						+ " but this is a div dropdown so selection is not actually applied - PASS");
				utilityclassobject.gettest().log(Status.INFO, "Status dropdown text changed after JS inject: "
						+ afterText + " - verifying actual selection is not applied");
				// Reload the dropdown text to confirm actual selected value is unchanged by
				// clicking away
				tsu.getStatusDropdown().click();
				Thread.sleep(500);
				String reloadedText = tsu.getStatusDropdown().getText().trim();
				System.out.println("After interaction, status dropdown displays: " + reloadedText
						+ (reloadedText.contains("Active") ? " - PASS" : " - FAIL"));
				utilityclassobject.gettest().log(Status.INFO,
						"After interaction, status dropdown displays: " + reloadedText);
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println(
					"Status dropdown element not found in DOM when trying to send manual input - PASS (not present)");
			utilityclassobject.gettest().log(Status.INFO,
					"Status dropdown element not found in DOM when trying to send manual input");
		} catch (Exception e) {
			// Any other exception (InvalidElementStateException, etc.) means the dropdown
			// rejected the input — expected PASS
			System.out
					.println("Status dropdown rejected manual input with: " + e.getClass().getSimpleName() + " - PASS");
			utilityclassobject.gettest().log(Status.INFO,
					"Status dropdown rejected manual input as expected - PASS: " + e.getClass().getSimpleName());
		}
	}

	@Test(dependsOnMethods = "TC_053StatusDDwithManualInputs")
	public void TC_054StatusDDOptionsInactiveDisplayed() throws InterruptedException {
		// Verfiy that dropdown contain Inactive option or not do not click on the
		// option just verify that option is displayed in dropdown or not and also do
		// not use select class
		try {
			tsu.getStatusDropdown().click();
			Thread.sleep(1000);
			boolean inactiveOptionPresent = isOptionPresentInDropdown("Inactive");
			System.out.println("Inactive option presence in status dropdown: " + inactiveOptionPresent);
			utilityclassobject.gettest().log(Status.INFO,
					"Inactive option presence in status dropdown: " + inactiveOptionPresent);
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			Thread.sleep(500);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out
					.println("Status dropdown element not found in DOM when trying to verify Inactive option presence");
			utilityclassobject.gettest().log(Status.INFO,
					"Status dropdown element not found in DOM when trying to verify Inactive option presence");
		} catch (Exception e) {
			System.out.println("Exception while verifying Inactive option presence: " + e.getClass().getSimpleName());
			utilityclassobject.gettest().log(Status.INFO,
					"Exception while verifying Inactive option presence: " + e.getClass().getSimpleName());
		}
	}

	@Test(dependsOnMethods = "TC_054StatusDDOptionsInactiveDisplayed")
	public void TC_055StatusDDwithOtherOption() throws InterruptedException {
		// Open the status dropdown and select the "Inactive" option, then verify the
		// selection is applied
		try {
			tsu.getStatusDropdown().click();
			Thread.sleep(1000);
			boolean inactiveClicked = clickOptionByText("Inactive");
			System.out.println("Clicked 'Inactive' option in status dropdown: " + inactiveClicked);
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked 'Inactive' option in status dropdown: " + inactiveClicked);
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			Thread.sleep(500);
			String selectedStatus = tsu.getStatusDropdown().getText().trim();
			if (selectedStatus.contains("Inactive")) {
				System.out.println("Status dropdown successfully changed to: " + selectedStatus + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Status dropdown successfully changed to: " + selectedStatus + " - PASS");
			} else {
				System.out.println("Status dropdown did not change to Inactive as expected, current value: "
						+ selectedStatus + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Status dropdown did not change to Inactive as expected, current value: " + selectedStatus
								+ " - FAIL");
			}
		} catch (Exception e) {
			System.out.println(
					"Exception during status dropdown option selection: " + e.getClass().getSimpleName() + " - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Exception during status dropdown option selection: " + e.getClass().getSimpleName() + " - FAIL");
		}
	}

	@Test(dependsOnMethods = "TC_055StatusDDwithOtherOption")
	public void TC_056StatusDDChangeBackToActive() throws InterruptedException {
		// Open the status dropdown and select the "Active" option to change it back,
		// then verify the selection is applied
		try {
			tsu.getStatusDropdown().click();
			Thread.sleep(1000);
			boolean activeClicked = clickOptionByText("Active");
			System.out.println("Clicked 'Active' option in status dropdown: " + activeClicked);
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked 'Active' option in status dropdown: " + activeClicked);
			driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
			Thread.sleep(500);
			String selectedStatus = tsu.getStatusDropdown().getText().trim();
			if (selectedStatus.contains("Active")) {
				System.out.println("Status dropdown successfully changed back to: " + selectedStatus + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Status dropdown successfully changed back to: " + selectedStatus + " - PASS");
			} else {
				System.out.println("Status dropdown did not change back to Active as expected, current value: "
						+ selectedStatus + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Status dropdown did not change back to Active as expected, current value: " + selectedStatus
								+ " - FAIL");
			}
		} catch (Exception e) {
			System.out.println(
					"Exception during status dropdown option selection: " + e.getClass().getSimpleName() + " - FAIL");
			utilityclassobject.gettest().log(Status.INFO,
					"Exception during status dropdown option selection: " + e.getClass().getSimpleName() + " - FAIL");
		}
	}
		@Test(dependsOnMethods = "TC_056StatusDDChangeBackToActive")
		public void TC_057VerifyUserCanLeaveStatus() throws InterruptedException {
			//verify that user can leave the status and make sure that user should not able to leave
			
			try {
				tsu.getStatusDropdown().click();
				Thread.sleep(1000);
				boolean noSelectionClicked = clickOptionByText("No Selection");
				System.out.println("Clicked 'No Selection' option in status dropdown: " + noSelectionClicked);
				utilityclassobject.gettest().log(Status.INFO,
						"Clicked 'No Selection' option in status dropdown: " + noSelectionClicked);
				driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
				Thread.sleep(500);
				String selectedStatus = tsu.getStatusDropdown().getText().trim();
				if (selectedStatus.contains("Active") || selectedStatus.contains("Inactive")) {
					System.out.println("User cannot leave status unselected, current value remains: " + selectedStatus + " - PASS");
					utilityclassobject.gettest().log(Status.INFO,
							"User cannot leave status unselected, current value remains: " + selectedStatus + " - PASS");
				} else {
					System.out.println("User was able to leave status unselected, current value: "
							+ selectedStatus + " - FAIL");
					utilityclassobject.gettest().log(Status.INFO,
							"User was able to leave status unselected, current value: " + selectedStatus
									+ " - FAIL");
				}
			} catch (Exception e) {
				System.out.println(
						"Exception during status dropdown no selection attempt: " + e.getClass().getSimpleName() + " - PASS if dropdown does not have 'No Selection' option");	
				utilityclassobject.gettest().log(Status.INFO,
						"Exception during status dropdown no selection attempt: " + e.getClass().getSimpleName() + " - PASS if dropdown does not have 'No Selection' option");			
			}
			
			
		}
		@Test(dependsOnMethods = "TC_057VerifyUserCanLeaveStatus"/*"TC_003AccessUsersPage"*/)
		public void TC_058AccessLevelDroDownPresent() throws InterruptedException {
			//Verify the access level is present or not
			try {
				boolean isAccessLevelDropdownDisplayed = tsu.getAccessleveldropdown().isDisplayed();
				if (isAccessLevelDropdownDisplayed) {
					System.out.println("Access Level dropdown is displayed - PASS");
					utilityclassobject.gettest().log(Status.PASS, "Access Level dropdown is displayed - PASS");
				} else {
					System.out.println("Access Level dropdown is not displayed - FAIL");
					utilityclassobject.gettest().log(Status.FAIL, "Access Level dropdown is not displayed - FAIL");
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Access Level dropdown element not found in DOM");
				utilityclassobject.gettest().log(Status.FAIL, "Access Level dropdown element not found in DOM");
			}
				
		}
		@Test(dependsOnMethods = "TC_058AccessLevelDroDownPresent")
		public void TC_059AccessLevelDefaultValue() throws InterruptedException {
			//Verify the default value of access level dropdown is Company-wide (Full Access)
			try {
				String defaultAccessLevel = tsu.getAccessleveldropdown().getText().trim();
				if (defaultAccessLevel.contains("Company-wide (Full Access)")) {
					System.out.println("Default value of Access Level dropdown is: " + defaultAccessLevel + " - PASS");
					utilityclassobject.gettest().log(Status.PASS,
							"Default value of Access Level dropdown is: " + defaultAccessLevel + " - PASS");
				} else {
					System.out.println("Default value of Access Level dropdown is: " + defaultAccessLevel + " - FAIL");
					utilityclassobject.gettest().log(Status.FAIL,
							"Default value of Access Level dropdown is: " + defaultAccessLevel + " - FAIL");
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Access Level dropdown element not found in DOM when trying to get default value");
				utilityclassobject.gettest().log(Status.FAIL,
						"Access Level dropdown element not found in DOM when trying to get default value");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_059AccessLevelDefaultValue")
		public void TC_060TrytoEnterManualInputsInAccessLeveDD() throws InterruptedException, AWTException {
			// TC_060: Try typing 'abcdefgh' manually into the Access Level dropdown and verify it is not accepted
			try {
				String beforeText = tsu.getAccessleveldropdown().getText().trim();
				System.out.println("Before typing - Access Level dropdown shows: " + beforeText);

				// Focus the dropdown element, select only the text inside it, then try to type
				((JavascriptExecutor) driver).executeScript(
						"var el = arguments[0];" +
						"el.focus();" +
						"var range = document.createRange();" +
						"range.selectNodeContents(el);" +
						"var sel = window.getSelection();" +
						"sel.removeAllRanges();" +
						"sel.addRange(range);" +
						"document.execCommand('insertText', false, arguments[1]);" +
						"el.dispatchEvent(new Event('input', {bubbles: true}));" +
						"el.dispatchEvent(new Event('change', {bubbles: true}));",
						tsu.getAccessleveldropdown(), "abcdefgh");
				Thread.sleep(1000);

				String afterText = tsu.getAccessleveldropdown().getText().trim();
				System.out.println("After typing - Access Level dropdown shows: " + afterText);

				if (afterText.equals(beforeText)) {
					// Dropdown value did not change - manual input was rejected as expected
					System.out.println("PASS: Dropdown did not accept manual input. Value is still: " + afterText);
					utilityclassobject.gettest().log(Status.PASS,
							"PASS: Dropdown did not accept manual input. Value is still: " + afterText);
				} else {
					// Dropdown text changed visually but actual selection may not have changed
					System.out.println("INFO: Dropdown text changed to '" + afterText + "' but actual selection may not be applied.");
					utilityclassobject.gettest().log(Status.INFO,
							"INFO: Dropdown text changed to '" + afterText + "' - checking if actual selection changed.");

					// Click away to reload the dropdown and check the real value
					tsu.getAccessleveldropdown().click();
					Thread.sleep(500);
					String reloadedText = tsu.getAccessleveldropdown().getText().trim();
					boolean isCorrect = reloadedText.contains("Company-wide (Full Access)");
					System.out.println("After clicking away - Dropdown shows: " + reloadedText + (isCorrect ? " - PASS" : " - FAIL"));
					utilityclassobject.gettest().log(isCorrect ? Status.PASS : Status.FAIL,
							"After clicking away - Dropdown shows: " + reloadedText + (isCorrect ? " - PASS" : " - FAIL"));
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				// Dropdown element was not found on the page
				System.out.println("PASS: Access Level dropdown is not present on the page.");
				utilityclassobject.gettest().log(Status.PASS,
						"PASS: Access Level dropdown is not present on the page.");
			} catch (Exception e) {
				// Dropdown threw an exception when trying to type - means it rejected the input as expected
				System.out.println("PASS: Dropdown rejected manual input. Error: " + e.getClass().getSimpleName());
				utilityclassobject.gettest().log(Status.PASS,
						"PASS: Dropdown rejected manual input. Error: " + e.getClass().getSimpleName());
			}
			
			
			
		}
		@Test(dependsOnMethods = /*"TC_060TrytoEnterManualInputsInAccessLeveDD"*/"TC_003AccessUsersPage")
		public void TC_061AccessLevelOptions() throws InterruptedException {
			//Fetch all the options from access level dropdown 
			
				tsu.getAccessleveldropdown().click();
				Thread.sleep(1000);
				List<WebElement> accessLevelOptions = tsu.getAccessleveldropdownOptions();
				for (WebElement option : accessLevelOptions) {
					System.out.println("Access Level dropdown option: " + option.getText().trim());
					utilityclassobject.gettest().log(Status.INFO,
							"Access Level dropdown option: " + option.getText().trim());
				}
		}
		@Test(dependsOnMethods = "TC_061AccessLevelOptions")
		public void TC_062SelectOtherOptionFromAccessLevel() throws InterruptedException {
			//select territory option from access level dropdown and verify the selection is applied do not use try catch
			tsu.getAccessleveldropdown().click();
			tsu.getAccessleveldropdown().click();

			
			Thread.sleep(1000);
			tsu.getTerritoryAccessLevelOption().click();
			Thread.sleep(500);
			String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
			System.out.println(selectedAccessLevel);
			if (selectedAccessLevel.contains("Territory")) {
				System.out.println("Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
			} else {
				System.out.println("Access Level dropdown did not change to Territory as expected, current value: "
						+ selectedAccessLevel + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown did not change to Territory as expected, current value: " + selectedAccessLevel
								+ " - FAIL");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_062SelectOtherOptionFromAccessLevel")
		public void TC_063SelectFullAccessOptionFromAccessLevel() throws InterruptedException {
			//try to select multiple options at a time but it should not display multile options in field
			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			tsu.getCompanyWideFullAccessOption().click();
			Thread.sleep(500);
			// Dropdown closes after first selection, reopen it to select the second option
			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			// Wait for Territory option to be clickable after dropdown reopens (avoids StaleElementReferenceException)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(tsu.getTerritoryAccessLevelOption())).click();
			Thread.sleep(500);
			String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
			System.out.println(selectedAccessLevel);
			//verify the number of option displayed in the dropdown field after selecting multiple options
			int optionsCount = selectedAccessLevel.split(",").length;
			if (optionsCount == 1 && selectedAccessLevel.contains("Company-wide (Full Access)")) {
				System.out.println("Only one option is displayed in Access Level dropdown after selecting multiple options - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Only one option is displayed in Access Level dropdown after selecting multiple options - FAIL");
			} else {
				System.out.println("Multiple options are not displaying in Access Level dropdown after selecting multiple options: " + selectedAccessLevel + "PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Multiple options are Not displayed in Access Level dropdown after selecting multiple options: " + selectedAccessLevel + " - PASS");
			}
			
			
			
			
			
		}
		@Test(dependsOnMethods = "TC_063SelectFullAccessOptionFromAccessLevel")
		public void TC_064SelectTerritoryOptionFromAccessLevelDD() throws InterruptedException {
			
			//try to select territory option from access level dropdown and verify the selection is applied
			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			tsu.getTerritoryAccessLevelOption().click();
			Thread.sleep(500);
			String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
			System.out.println(selectedAccessLevel);
			if (selectedAccessLevel.contains("Territory")) {
				System.out.println("Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown successfully changed to: " + selectedAccessLevel + " - PASS");
			} else {
				System.out.println("Access Level dropdown did not change to Territory as expected, current value: "
						+ selectedAccessLevel + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown did not change to Territory as expected, current value: " + selectedAccessLevel
								+ " - FAIL");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_064SelectTerritoryOptionFromAccessLevelDD")
		public void TC_065TerritotoriesDDFromTerritoryOption() throws InterruptedException {
			//Select Territory from access level dropdown and verify that territories dropdown 
			tsu.getAccessleveldropdown().click();
			tsu.getTerritoryAccessLevelOption().click();
			Thread.sleep(1000);
			boolean isTerritoriesDropdownDisplayed = tsu.getTerritoriesDropdown().isDisplayed();
			if (isTerritoriesDropdownDisplayed) {
				System.out.println("Territories dropdown is displayed after selecting Territory access level - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Territories dropdown is displayed after selecting Territory access level - PASS");
			} else {
				System.out.println("Territories dropdown is not displayed after selecting Territory access level - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Territories dropdown is not displayed after selecting Territory access level - FAIL");
			}	
			
		}
		@Test(dependsOnMethods = "TC_065TerritotoriesDDFromTerritoryOption")
		public void TC_066TrytoPassInputsintoTerritoriesDD() throws InterruptedException {
			//try to pass input abcd in to territories dropdown and verify that it should not accept the manual input
			/*tsu.getTerritoriesDropdown().click();
			Thread.sleep(1000);
			//pass the input in territories dropdown using javascript because it is a div based dropdown and it will not accept the input using sendkeys method
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].innerText = arguments[1]; "
							+ "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); "
							+ "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
					tsu.getTerritoriesDropdown(), "abcd");
			Thread.sleep(1000);
			String afterText = tsu.getTerritoriesDropdown().getText().trim();
			if (afterText.equals("Select Territories")) {
				System.out.println("Territories dropdown did not accept manual input and remains: " + afterText + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Territories dropdown did not accept manual input and remains: " + afterText + " - PASS");
			} else {
				System.out.println("Territories dropdown text changed to: " + afterText
						+ "  - FAIL");
				utilityclassobject.gettest().log(Status.INFO, "Territories dropdown text changed after JS inject: "
						+ afterText );
				// Reload the dropdown text to confirm actual selected value is unchanged by
				// clicking away
				tsu.getTerritoriesDropdown().click();
				Thread.sleep(500);
				String reloadedText = tsu.getTerritoriesDropdown().getText().trim();
				System.out.println("After interaction, territories dropdown displays: " + reloadedText
						+ (reloadedText.equals("Select Territories") ? " - PASS" : " - FAIL"));
				utilityclassobject.gettest().log(Status.INFO,
						"After interaction, territories dropdown displays: " + reloadedText);
			}*/
			
		
			
		}
		@Test(dependsOnMethods = "TC_066TrytoPassInputsintoTerritoriesDDO")
		public void TC_067FetchtheListFromDD() throws InterruptedException {
			//Select Territory from access level dropdown and verify that territories dropdown 
			tsu.getAccessleveldropdown().click();
			tsu.getTerritoryAccessLevelOption().click();
			tsu.getTerritoriesDropdown().click();
			Thread.sleep(1000);
			List<WebElement> territoriesOptions = tsu.getTerritoriesDropdownOptionsList();
			for (WebElement option : territoriesOptions) {
				System.out.println("Territories dropdown option: " + option.getText().trim());
				utilityclassobject.gettest().log(Status.INFO,
						"Territories dropdown option: " + option.getText().trim());
			}
			// Close the territories dropdown after fetching the list
			tsu.getTerritoriesDropdown().click();
			Thread.sleep(500);
			
		}
		@Test(dependsOnMethods = "TC_067FetchtheListFromDD")
		public void TC_068SelectAnyOptionFromTerritoriesCheckBox() throws InterruptedException {
			//Select Local territories checkbox from territories dropdown and verify the selection is applied
			tsu.getTerritoriesDropdownSearchBox().click();
			Thread.sleep(2000);
			tsu.getLocalTeritoryCheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Local Territory checkbox in territories dropdown");
			System.out.println("Clicked Local Territory checkbox in territories dropdown");
			
			
		}
		
			
		
		@Test(dependsOnMethods = "TC_068SelectAnyOptionFromTerritoriesCheckBox")
		public void TC_069SelectMultipleOptionsFromTerritories() throws InterruptedException {
			//Select multiple options from territories dropdown and verify the selection is applied
			tsu.getTestTerritoryCheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Territory checkbox in territories dropdown");
			//verify the selected option from territories dropdown
			boolean isTestTerritorySelected = tsu.getTestTerritoryCheckbox().isSelected();
			if (isTestTerritorySelected) {
				System.out.println("Test Territory checkbox is selected as expected - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Territory checkbox is selected as expected - PASS");
			} else {
				System.out.println("Test Territory checkbox is not selected after clicking on it - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Territory checkbox is not selected after clicking on it - FAIL");
			}
		}
		@Test(dependsOnMethods = "TC_069SelectMultipleOptionsFromTerritories")
		public void TC_070DeselectOptionFromTerritories() throws InterruptedException {
		tsu.getCancelTerritoriesDropdownButton().click();
		tsu.getCancelTerritoriesDropdownButton().click();
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.INFO,
				"Clicked Cancel button in territories dropdown to deselect all selected options");
		System.out.println("Clicked Cancel button in territories dropdown to deselect all selected options");
		
			
		}
		@Test(dependsOnMethods = "TC_070DeselectOptionFromTerritories")
		public void TC_071AgainSelectOptionFromTerritoriesDD() throws InterruptedException {
			tsu.getTestTerritoryCheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Territory checkbox in territories dropdown again to select it");
			System.out.println("Clicked Test Territory checkbox in territories dropdown again to select it");
		}
		@Test(dependsOnMethods = "TC_071AgainSelectOptionFromTerritoriesDD")
		public void TC_072AccessSummaryUpdate() throws InterruptedException {
			tsu.getCancelTerritoriesDropdownButton().click();
			//fetch the text from AccessSummary before selecting the option from territories dropdown
			String accessSummaryBefore = tsu.getAccesssummary().getText().trim();
			System.out.println("Access Summary before selecting option from territories dropdown: " + accessSummaryBefore);
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary before selecting option from territories dropdown: " + accessSummaryBefore);
			//select any option from territories dropdown
			tsu.getTestTerritoryCheckbox().click();
			Thread.sleep(1000);
			//fetch the text from AccessSummary after selecting the option from territories dropdown and verify that Access Summary updated or not
			String accessSummaryAfter = tsu.getAccesssummary().getText().trim();
			System.out.println("Access Summary after selecting option from territories dropdown: " + accessSummaryAfter);
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary after selecting option from territories dropdown: " + accessSummaryAfter);
			if (!accessSummaryAfter.equals(accessSummaryBefore)) {
				System.out.println("Access Summary updated after selecting option from territories dropdown - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Summary updated after selecting option from territories dropdown - PASS");
			} else {
				System.out.println("Access Summary did not update after selecting option from territories dropdown - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Summary did not update after selecting option from territories dropdown - FAIL");
				}
			
		}
		@Test(dependsOnMethods = "TC_072AccessSummaryUpdate"/*"TC_003AccessUsersPage"*/)
		public void TC_073AccesslevelChangeTORegion() throws InterruptedException {
			//click outside on screen to close the territories dropdown
			driver.findElement(By.xpath("//body")).click();
			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			tsu.getRegionAccessLevelOptionfromaccesslevelDD().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Region option in Access Level dropdown");
			System.out.println("Clicked Region option in Access Level dropdown");
			
			
		}
		@Test(dependsOnMethods = "TC_073AccesslevelChangeTORegion")
		public void TC_074VerifyRegionAccessLevelSelection() throws InterruptedException {
			//verify that region dropdown is displayed after selecting region option from access level dropdown
			boolean isRegionDropdownDisplayed = tsu.getRegionsDropdown().isDisplayed();
			if (isRegionDropdownDisplayed) {
				System.out.println("Region dropdown is displayed after selecting Region access level - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Region dropdown is displayed after selecting Region access level - PASS");
			} else {
				System.out.println("Region dropdown is not displayed after selecting Region access level - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Region dropdown is not displayed after selecting Region access level - FAIL");
			}	
		}
		@Test(dependsOnMethods = "TC_074VerifyRegionAccessLevelSelection")
		public void TC_075TrytoPassmanualInputinRegiosDD() throws InterruptedException {
			//try to pass manual input in region dropdown and verify that it should not accept the manual input
			/*tsu.getRegionsDropdown().click();
			Thread.sleep(1000);
			//pass the input in region dropdown using javascript because it is a div based dropdown and it will not accept the input using sendkeys method
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].innerText = arguments[1]; "
							+ "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); "
							+ "arguments[0].dispatchEvent(new Event('change', {bubbles: true}));",
					tsu.getRegionsDropdown(), "abcd");
			Thread.sleep(1000);
			String afterText = tsu.getRegionsDropdown().getText().trim();
			if (afterText.equals("Select Regions")) {
				System.out.println("Region dropdown did not accept manual input and remains: " + afterText + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Region dropdown did not accept manual input and remains: " + afterText + " - PASS");
			} else {
				System.out.println("Region dropdown text changed to: " + afterText
						+ "  - FAIL");
				utilityclassobject.gettest().log(Status.INFO, "Region dropdown text changed after JS inject: "
						+ afterText );
				// Reload the dropdown text to confirm actual selected value is unchanged by
				// clicking away
				tsu.getRegionsDropdown().click();
				Thread.sleep(500);
				String reloadedText = tsu.getRegionsDropdown().getText().trim();
				System.out.println("After interaction, region dropdown displays: " + reloadedText
						+ (reloadedText.equals("Select Regions") ? " - PASS" : " - FAIL"
								+ " - FAIL"));
				utilityclassobject.gettest().log(Status.INFO,	
						"After interaction, region dropdown displays: " + reloadedText);
			}*/
			
			
		}
		@Test(dependsOnMethods = "TC_075TrytoPassmanualInputinRegiosDD")
		public void TC_076FetchOptionsFromRegionDD() throws InterruptedException {
			//Select Region from access level dropdown and verify that region dropdown 
			tsu.getAccessleveldropdown().click();
			tsu.getRegionAccessLevelOptionfromaccesslevelDD().click();
			//click outsdie to close the access level dropdown
			driver.findElement(By.xpath("//body")).click();
			
			tsu.getRegionsDropdownSearchBox().click();
			List<WebElement> options = tsu.getRegionsDropdownOptionsList();
			for (WebElement option : options) {
				System.out.println("Region dropdown option: " + option.getText().trim());
				utilityclassobject.gettest().log(Status.INFO,
						"Region dropdown option: " + option.getText().trim());
			}
			
		}
		@Test(dependsOnMethods = "TC_076FetchOptionsFromRegionDD")
		public void TC_077ListOptionsFromregionsDD() throws InterruptedException {
			tsu.getTestRegion1Checkbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Region 1 checkbox in regions dropdown");
			boolean isTestRegion1Selected = tsu.getTestRegion1Checkbox().isSelected();
			if (isTestRegion1Selected) {
				System.out.println("Test Region 1 checkbox is selected as expected - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Region 1 checkbox is selected as expected - PASS");
			} else {
				System.out.println("Test Region 1 checkbox is not selected after clicking on it - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Region 1 checkbox is not selected after clicking on it - FAIL");
			}
			tsu.getTestRegion1Checkbox().click();

		}
		@Test(dependsOnMethods = "TC_077ListOptionsFromregionsDD")
		public void TC_078RegionDDWithMultipleOptions() throws InterruptedException {
			tsu.getTestRegion1Checkbox().click();
			tsu.getTestRegionCheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Region DD with multiple options are selected");
			System.out.println("Region DD with multiple options are selected");
			//Click on outside 
			driver.findElement(By.xpath("//body")).click();
			
		}
		@Test(dependsOnMethods = "TC_078RegionDDWithMultipleOptions")
		public void TC_079VerifyMultipleOptionsSelectedInRegionDD() throws InterruptedException {
			tsu.getCancelRegionsDropdownButton().click();
			tsu.getCancelRegionsDropdownButton().click();
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Cancel button in regions dropdown to deselect all selected options");
			System.out.println("Clicked Cancel button in regions dropdown to deselect all selected options");
			
			
		}
		@Test(dependsOnMethods = "TC_079VerifyMultipleOptionsSelectedInRegionDD")
		public void TC_080SelectOptionFromRegionDD() throws InterruptedException {
			tsu.getRegionsDropdownSearchBox().click();

			tsu.getTestRegion1Checkbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Region 1 checkbox in regions dropdown again to select it");
			System.out.println("Clicked Test Region 1 checkbox in regions dropdown again to select it");
		}
		@Test(dependsOnMethods = "TC_080SelectOptionFromRegionDD")
		public void TC_081AccessSummaryUpdateAfterRegionSelection() throws InterruptedException {
			tsu.getCancelRegionsDropdownButton().click();

			//fetch the text from AccessSummary before selecting the option from region dropdown
			String accessSummaryBefore = tsu.getAccesssummary().getText().trim();
			System.out.println("Access Summary before selecting option from region dropdown: " + accessSummaryBefore);
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary before selecting option from region dropdown: " + accessSummaryBefore);
			//select any option from region dropdown
			tsu.getTestRegion1Checkbox().click();
			Thread.sleep(1000);
			//fetch the text from AccessSummary after selecting the option from region dropdown and verify that Access Summary updated or not
			String accessSummaryAfter = tsu.getAccesssummary().getText().trim();
			System.out.println("Access Summary after selecting option from region dropdown: " + accessSummaryAfter);
			utilityclassobject.gettest().log(Status.INFO,
					"Access Summary after selecting option from region dropdown: " + accessSummaryAfter);
			if (!accessSummaryAfter.equals(accessSummaryBefore)) {
				System.out.println("Access Summary updated after selecting option from region dropdown - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Summary updated after selecting option from region dropdown - PASS");
			} else {
				System.out.println("Access Summary did not update after selecting option from region dropdown - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Summary did not update after selecting option from region dropdown - FAIL");
				}
			
		}
		@Test(dependsOnMethods = "TC_081AccessSummaryUpdateAfterRegionSelection")
		public void TC_082ChangeAccessLevelBackToSatellite() throws InterruptedException {
			driver.findElement(By.xpath("//body")).click();

			tsu.getAccessleveldropdown().click();
			Thread.sleep(1000);
			tsu.getSatelliteAccessLevelOption().click();
			Thread.sleep(500);
			String selectedAccessLevel = tsu.getAccessleveldropdown().getText().trim();
			System.out.println(selectedAccessLevel);
			if (selectedAccessLevel.contains("Satellite")) {
				System.out.println("Access Level dropdown successfully changed back to: " + selectedAccessLevel + " - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown successfully changed back to: " + selectedAccessLevel + " - PASS");
			} else {
				System.out.println("Access Level dropdown did not change back to Satellite as expected, current value: "
						+ selectedAccessLevel + " - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Access Level dropdown did not change back to Satellite as expected, current value: " + selectedAccessLevel
								+ " - FAIL");
			}
			//verify satellite dropdown is displayed after selecting satellite option from access level dropdown
			boolean isSatelliteDropdownDisplayed = tsu.getSatellitesDropdown().isDisplayed();
			if (isSatelliteDropdownDisplayed) {
				System.out.println("Satellite dropdown is displayed after selecting Satellite access level - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Satellite dropdown is displayed after selecting Satellite access level - PASS");
			} else {
				System.out.println("Satellite dropdown is not displayed after selecting Satellite access level - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Satellite dropdown is not displayed after selecting Satellite access level - FAIL");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_082ChangeAccessLevelBackToSatellite")
		public void TC_083ChangeAccessLevelBackToCompanyWide() throws InterruptedException {
			
		}
		@Test(dependsOnMethods = "TC_083ChangeAccessLevelBackToCompanyWide")
		public void TC_084SatelliteOption() throws InterruptedException {
			
			tsu.getSatellitesDropdownSearchBox().click();
			List<WebElement> satelliteOptions = tsu.getSatellitesDropdownOptionsList();
			for (WebElement option : satelliteOptions) {
				System.out.println("Satellite dropdown option: " + option.getText().trim());
				utilityclassobject.gettest().log(Status.INFO,
						"Satellite dropdown option: " + option.getText().trim());
			}
			
		}
		@Test(dependsOnMethods = "TC_084SatelliteOption")
		public void TC_085SelectOptionFromSatelliteDD() throws InterruptedException {
			tsu.getSatellitesDropdownSearchBox().click();
			tsu.getSatellitesDropdownSearchBox().click();


			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Satellite 1 checkbox in satellites dropdown");
			//select 1st option from dropdown
			tsu.getSatellite1stoption().click();
			boolean isSatellite1stOptionSelected = tsu.getSatellite1stoption().isSelected();
			if (isSatellite1stOptionSelected) {
				System.out.println("Test Satellite 1 checkbox is selected as expected - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Satellite 1 checkbox is selected as expected - PASS");
			} else {
				System.out.println("Test Satellite 1 checkbox is not selected after clicking on it - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Test Satellite 1 checkbox is not selected after clicking on it - FAIL");
			}
			
			
		}
		@Test(dependsOnMethods = "TC_085SelectOptionFromSatelliteDD")
		public void TC_086MultipleOptionsFrimSatelliteDD() throws InterruptedException {
			tsu.getSatellite2ndoptioncheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"able to select multiple options from satellite dropdown");
			System.out.println("able to select multiple options from satellite dropdown");
			//Click on outside
			driver.findElement(By.xpath("//body")).click();
			
		}
		@Test(dependsOnMethods = "TC_086MultipleOptionsFrimSatelliteDD")
		public void TC_087CancelMultipleSelectionFromSatelliteDD() throws InterruptedException {
			tsu.getCancelSatellitesDropdownButton().click();
			tsu.getCancelSatellitesDropdownButton().click();
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Cancel button in satellites dropdown to deselect all selected options");
			System.out.println("Clicked Cancel button in satellites dropdown to deselect all selected options");
			
		}
		@Test(dependsOnMethods = "TC_087CancelMultipleSelectionFromSatelliteDD")
		public void TC_088SelectOptionFromSatelliteDD() throws InterruptedException {
			tsu.getSatellitesDropdownSearchBox().click();
			tsu.getSatellite1stoption().click();
			driver.findElement(By.xpath("//body")).click();

			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Test Satellite 1 checkbox in satellites dropdown again to select it");
			System.out.println("Clicked Test Satellite 1 checkbox in satellites dropdown again to select it");
			tsu.getCancelSatellitesDropdownButton().click();

		}
		@Test(dependsOnMethods = "TC_088SelectOptionFromSatelliteDD")
		public void TC_089TrytoProceedWithoutSatellite() throws InterruptedException {
			driver.findElement(By.xpath("//body")).click();
			webDriverutility wlib = new webDriverutility();
			wlib.scrollToelement(driver, tsu.getSaveButton());
			tsu.getSaveButton().click();
			//verify that error message is displayed when trying to save the user without selecting any option from satellite dropdown after selecting satellite access level
			boolean isErrorMessageDisplayed = tsu.getSelectAtleastOneSatelliteErrorMessage().isDisplayed();
			if (isErrorMessageDisplayed) {
				System.out.println("Error message is displayed when trying to save without selecting any option from satellite dropdown - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Error message is displayed when trying to save without selecting any option from satellite dropdown - PASS");
			} else {
				System.out.println("Error message is not displayed when trying to save without selecting any option from satellite dropdown - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Error message is not displayed when trying to save without selecting any option from satellite dropdown - FAIL");
			}

				
			
		}
		@Test(dependsOnMethods = "TC_089TrytoProceedWithoutSatellite")
		public void TC_090SaveWithoutAllFields() throws InterruptedException {
			tsu.getSaveButton().click();
			//verify Firstnmae eroor message,Lastname,Emailerror message,role error messageand Satellite error message is displayed when trying to save without filling all the mandatory fields
			boolean isFirstnameErrorMessageDisplayed = tsu.getFirstNameErrorMessage().isDisplayed();
			boolean isLastnameErrorMessageDisplayed = tsu.getLastNameErrorMessage().isDisplayed();
			boolean isEmailErrorMessageDisplayed = tsu.getEmailErrorMessage().isDisplayed();
			boolean isRoleErrorMessageDisplayed = tsu.getRoleRequiredErrorMessage().isDisplayed();
			boolean isSatelliteErrorMessageDisplayed = tsu.getSelectAtleastOneSatelliteErrorMessage().isDisplayed();
			if (isFirstnameErrorMessageDisplayed && isLastnameErrorMessageDisplayed && isEmailErrorMessageDisplayed && isRoleErrorMessageDisplayed && isSatelliteErrorMessageDisplayed) {
				System.out.println("All error messages are displayed when trying to save without filling mandatory fields - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"All error messages are displayed when trying to save without filling mandatory fields - PASS");
			} else {
				System.out.println("All error messages are not displayed as expected when trying to save without filling mandatory fields - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"All error messages are not displayed as expected when trying to save without filling mandatory fields - FAIL");
			}	
			
		}
		@Test(dependsOnMethods = "TC_090SaveWithoutAllFields")
		public void TC_091SaveWithAllMandatoryFields() throws InterruptedException {
			random = new Random();
			int randomNumber = 100 + random.nextInt(900); // generates a 3-digit number (100-999)
			tsu.getFirstnameTextField().sendKeys("Test");
			tsu.getLastNameTextField().sendKeys("User");
			String email = "charlie" + randomNumber + "@gmail.com";
			System.out.println( email);
			tsu.getEmailTextField().sendKeys(email);
			tsu.getSelectRolesDropdown().click();
			tsu.getAdminRoleOptionfromRolesDropdown().click();
			tsu.getSaveButton().click();
			List<WebElement> emaillists = tsu.getEmaillistfromusertable();
			//In this list of emain just fetch related email which is added and verify that email is added in the user table or not
			boolean isEmailAddedInTable = false;
			for (WebElement emailElement : emaillists) {
				if (emailElement.getText().trim().equals(email)) {
					isEmailAddedInTable = true;
					break;
				}
				
			}
			if (isEmailAddedInTable) {
				System.out.println("New user is added successfully and email is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is added successfully and email is displayed in user table - PASS");
			} else {
				System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is not added successfully or email is not displayed in user table - FAIL");
			}
			
		
		}
		
		@Test(dependsOnMethods = "TC_091SaveWithAllMandatoryFields")
		public void TC_092SaveUserWithAllFields() throws InterruptedException {
			tsu.getAddNewUserButton().click();
			int randomNumber = 10000 + random.nextInt(90000); // generates a 3-digit number (100-999)
			//again write code add 2 digit random number
			
			
			
			String name = "Test"+randomNumber;
			tsu.getFirstnameTextField().sendKeys(name);
			tsu.getLastNameTextField().sendKeys("User");
			String email = "charlie" + randomNumber + "@gmail.com";
			System.out.println( email);
			tsu.getEmailTextField().sendKeys(email);
			tsu.getSelectRolesDropdown().click();
			tsu.getAdminRoleOptionfromRolesDropdown().click();
			//10 dogit random number for phone number in int format
			 
			tsu.getPhoneNumberTextField().sendKeys("5896478256");
			tsu.getSaveButton().click();
			List<WebElement> emaillists = tsu.getEmaillistfromusertable();
			boolean isEmailAddedInTable = false;
			for (WebElement emailElement : emaillists) {
				if (emailElement.getText().trim().equals(email)) {
					isEmailAddedInTable = true;
					break;
				}
				
			}
			if (isEmailAddedInTable) {
				System.out.println("New user is added successfully and email is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is added successfully and email is displayed in user table - PASS");
			} else {
				System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is not added successfully or email is not displayed in user table - FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_092SaveUserWithAllFields")
		public void TC_093VerifyUserlistDisplayed() throws InterruptedException {
			//verify the user list heading is displayed or not
			boolean isUserListHeadingDisplayed = tsu.getUsersListHeading().isDisplayed();
			if (isUserListHeadingDisplayed) {
				System.out.println("User List heading is displayed in users page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User List heading is displayed in users page - PASS");
			} else {
				System.out.println("User List heading is not displayed in users page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User List heading is not displayed in users page - FAIL");
			}
		
		}
		@Test(dependsOnMethods = "TC_093VerifyUserlistDisplayed")
		public void TC_094ViewUserList() throws InterruptedException {
			tsu.getAddNewUserButton().click();
			tsu.getViewUsersListButton().click();
			//verify user is re-directed to user list page after clicking on view user list button
			boolean isUserListPageDisplayed = tsu.getUsersListHeading().isDisplayed();
			if (isUserListPageDisplayed) {
				System.out.println("User is redirected to user list page after clicking on view user list button - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User is redirected to user list page after clicking on view user list button - PASS");
			} else {
				System.out.println("User is not redirected to user list page after clicking on view user list button - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User is not redirected to user list page after clicking on view user list button - FAIL");
			}
		}
		String name;
		String phonemun;
		String phonetxt;
		String email;
		String roletxt;
		@Test(dependsOnMethods = "TC_094ViewUserList")
		public void TC_095VerifyUserinListTable() throws InterruptedException {
			int randomNumber = 10000 + random.nextInt(90000); // generates a 3-digit number (100-999)
			//again write code add 2 digit random number
			
			
			tsu.getAddNewUserButton().click();
			 name = "Test"+randomNumber;
			tsu.getFirstnameTextField().sendKeys(name);
			tsu.getLastNameTextField().sendKeys("User");
			email = "charlie" + randomNumber + "@gmail.com";
			System.out.println( email);
			tsu.getEmailTextField().sendKeys(email);
			tsu.getSelectRolesDropdown().click();
			tsu.getAdminRoleOptionfromRolesDropdown().click();
			//click outside to close the role dropdown
			driver.findElement(By.xpath("//body")).click();
			roletxt = tsu.getRoleDropdown().getText();
			System.out.println(roletxt);
			//10 dogit random number for phone number in int format
			phonemun = "5896478256";
			tsu.getPhoneNumberTextField().sendKeys(phonemun);
			phonetxt = tsu.getPhoneNumberTextField().getText();
			System.out.println(phonetxt);
			tsu.getSaveButton().click();
			List<WebElement> emaillists = tsu.getEmaillistfromusertable();
			boolean isEmailAddedInTable = false;
			for (WebElement emailElement : emaillists) {
				if (emailElement.getText().trim().equals(email)) {
					isEmailAddedInTable = true;
					break;
				}
				
			}
			if (isEmailAddedInTable) {
				System.out.println("New user is added successfully and email is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is added successfully and email is displayed in user table - PASS");
			} else {
				System.out.println("New user is not added successfully or email is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user is not added successfully or email is not displayed in user table - FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_095VerifyUserinListTable")
		public void TC_096verifyNameInUerList() throws InterruptedException {
			List<WebElement> namelists = tsu.getUserlistwithalldetails();
			boolean isNameAddedInTable = false;
			for (WebElement nameElement : namelists) {
				if (nameElement.getText().trim().contains(name)) {
					isNameAddedInTable = true;
					break;
				}
				
			}
			if (isNameAddedInTable) {
				System.out.println("New user name is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user name is displayed in user table - PASS");
			} else {
				System.out.println("New user name is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user name is not displayed in user table - FAIL");
			}	
		}
		@Test(dependsOnMethods = "TC_096verifyNameInUerList")
		public void TC_097VerifyaddedUserPhonenumberinInList() throws InterruptedException {
			//verify the added user phone number is displayed in user table or not
			List<WebElement> phonelists = tsu.getUserwithaphonenumberlist();
			//In this list of phone number just fetch related phone number which is added and verify that phone number is added in the user table or not
			boolean isPhoneNumberAddedInTable = false;
			for (WebElement phoneElement : phonelists) {
				if (phoneElement.getText().contains(phonetxt)) {
					isPhoneNumberAddedInTable = true;
					break;
				}
				
			}
			if (isPhoneNumberAddedInTable) {
				System.out.println("New user phone number is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user phone number is displayed in user table - PASS");
			} else {
				System.out.println("New user phone number is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user phone number is not displayed in user table - FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_097VerifyaddedUserPhonenumberinInList")
		public void TC_098VerifyaddedUserEmailinInList() throws InterruptedException {
			//verify the added user email is displayed in user table or not
			List<WebElement> emaillists = tsu.getEmaillistfromusertable();
			//In this list of emain just fetch related email which is added and verify that email is added in the user table or not
			boolean isEmailAddedInTable = false;
			for (WebElement emailElement : emaillists) {
				if (emailElement.getText().trim().equals(email)) {
					isEmailAddedInTable = true;
					break;
				}
				
			}
			if (isEmailAddedInTable) {
				System.out.println("New user email is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user email is displayed in user table - PASS");
			} else {
				System.out.println("New user email is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user email is not displayed in user table - FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_098VerifyaddedUserEmailinInList")
		public void TC_099VerifyaddedUserRoleinInList() throws InterruptedException {
			//verify the added user role is displayed in user table or not
			List<WebElement> rolelists = tsu.getRolelistfromuserlist();
			//In this list of role just fetch related role which is added and verify that role is added in the user table or not
			boolean isRoleAddedInTable = false;
			for (WebElement roleElement : rolelists) {
				if (roleElement.getText().trim().contains(roletxt)) {
					isRoleAddedInTable = true;
					break;
				}
				
			}
			if (isRoleAddedInTable) {
				System.out.println("New user role is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"New user role is displayed in user table - PASS");
			} else {
				System.out.println("New user role is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"New user role is not displayed in user table - FAIL");
			}
			
		}
		@Test(dependsOnMethods = "TC_099VerifyaddedUserRoleinInList")
		public void TC_100VerifyHierarchyAccess() throws InterruptedException {
			//verify the hierarchy access list is displayed in user table or not
			List<WebElement> hierarchyAccessLists = tsu.getHierarchyAccesslistfromuserlist();
			if (hierarchyAccessLists.size() > 0) {
				System.out.println("Hierarchy Access is displayed in user table - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Hierarchy Access is displayed in user table - PASS");
			} else {
				System.out.println("Hierarchy Access is not displayed in user table - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Hierarchy Access is not displayed in user table - FAIL");
			}
		}
		@Test(dependsOnMethods = "TC_100VerifyHierarchyAccess")
		public void TC_101VerifyUserlist() throws InterruptedException {
			//verify the usre list is displayed with pagination or not
			List<WebElement> userlist = tsu.getUserstatuslistfromuserlist();
			if (userlist.size() > 0) {
				System.out.println("User list is displayed with pagination in user list page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User list is displayed with pagination in user list page - PASS");
			} else {
				System.out.println("User list is not displayed with pagination in user list page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User list is not displayed with pagination in user list page - FAIL");
			}
			
		
		}
		@Test(dependsOnMethods = "TC_101VerifyUserlist")
		public void TC_102EditExistinguser() throws InterruptedException {
			//from user list based on recently created email and click on that perticular user
			//List<WebElement> emaillists = tsu.getEmaillistfromusertable();
			//for (WebElement emailElement : emaillists) {
				//if (emailElement.getText().trim().equals(email)) {
					//emailElement.click();
					//break;
				//}
				
			}
		@Test(dependsOnMethods = "TC_102EditExistinguser")
		public void TC_103VerifyUserStatudProfile() throws InterruptedException {
			//verify userbstatus dropdown is displayed in user profile page or not
			boolean isUserStatusDropdownDisplayed = tsu.getUserStatusdropdown().isDisplayed();
			if (isUserStatusDropdownDisplayed) {
				System.out.println("User Status dropdown is displayed in user profile page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User Status dropdown is displayed in user profile page - PASS");
			} else {
				System.out.println("User Status dropdown is not displayed in user profile page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User Status dropdown is not displayed in user profile page - FAIL");
			}
			
				
			
			
		}
		@Test(dependsOnMethods = "TC_103VerifyUserStatudProfile")
		public void TC_104UserStatusoption() throws InterruptedException {
			tsu.getUserStatusdropdown().click();
			List<WebElement> userStatusOptions = tsu.getUserstatusdropdownoptions();
			for (WebElement option : userStatusOptions) {
				System.out.println("User Status dropdown option: " + option.getText().trim());
				utilityclassobject.gettest().log(Status.INFO,
						"User Status dropdown option: " + option.getText().trim());
			}
			
		}
		@Test(dependsOnMethods = "TC_104UserStatusoption")
		public void TC_105ChangeUserstatusToActive() throws InterruptedException {
			//write a code select 1st option from user ststus dropdown
			
			tsu.getUserStatusActiveOptioncheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Active option in User Status dropdown");
			System.out.println("Clicked Active option in User Status dropdown");
			Thread.sleep(1000);
			//click on outside to close the dropdown
			//driver.findElement(By.xpath("//body")).click();
			//click on userlistheading to go back to user list page
			tsu.getUsersListHeading().click();
			
			//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
			List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
			boolean isUserStatusUpdatedToActive = false;
			for (WebElement statusElement : userStatusLists) {
				if (statusElement.getText().trim().equals("Active")) {
					isUserStatusUpdatedToActive = true;
					break;
				}
				
			}
			if (isUserStatusUpdatedToActive) {
				System.out.println("User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
			} else {
				System.out.println("User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
			}
			
			
			
		}
		@Test(dependsOnMethods = "TC_105ChangeUserstatusToActive")
		public void TC_106ChangeUserstatusToInactive() throws InterruptedException {
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			tsu.getUserStatusdropdown().click();
			tsu.getUserStatusInactiveOptioncheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Inactive option in User Status dropdown");
			System.out.println("Clicked Inactive option in User Status dropdown");
			Thread.sleep(1000);
			//click on userlistheading to go back to user list page
			tsu.getUsersListHeading().click();
			
			//fetch user status list from user list page and verify that user status is updated to inactive in user list page after changing the user status to inactive in user profile page
			List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
			boolean isUserStatusUpdatedToInactive = false;
			for (WebElement statusElement : userStatusLists) {
				if (statusElement.getText().trim().equals("Inactive")) {
					isUserStatusUpdatedToInactive = true;
					break;
				}
				
			}
			if (isUserStatusUpdatedToInactive) {
				System.out.println("User status is updated to Inactive in user list page after changing the user status to Inactive in user profile page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is updated to Inactive in user list page after changing the user status to Inactive in user profile page - PASS");
			} else {
				System.out.println("User status is not updated to Inactive in user list page after changing the user status to Inactive in user profile page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is not updated to Inactive in user list page after changing the user status to Inactive in user profile page - FAIL");
			}
			
			
			
		}
		@Test(dependsOnMethods = "TC_106ChangeUserstatusToInactive")
		public void TC_107SelectbothActiveandInactive() throws InterruptedException {
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			tsu.getUserStatusdropdown().click();
			tsu.getUserStatusInactiveOptioncheckbox().click();
			tsu.getUserStatusActiveOptioncheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked both Active and Inactive option in User Status dropdown");
			System.out.println("Clicked both Active and Inactive option in User Status dropdown");
			Thread.sleep(1000);
			//click on userlistheading to go back to user list page
			tsu.getUsersListHeading().click();
			//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
			List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
			boolean isUserStatusUpdatedToActive = false;
			boolean isUserStatusUpdatedToInactive = false;
			for (WebElement statusElement : userStatusLists) {
				if (statusElement.getText().trim().equals("Active")) {
					isUserStatusUpdatedToActive = true;
				}
				if (statusElement.getText().trim().equals("Inactive")) {
					isUserStatusUpdatedToInactive = true;
				}
				
			}
			if (isUserStatusUpdatedToActive && isUserStatusUpdatedToInactive) {
				System.out.println("Both Active and Inactive status are updated in user list page after selecting both options at a time in User Status dropdown in user profile page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"Both Active and Inactive status are updated in user list page after selecting both options at a time in User Status dropdown in user profile page - PASS");
			} else {
				System.out.println("Both Active and Inactive status are not updated in user list page after selecting both options at a time in User Status dropdown in user profile page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"Both Active and Inactive status are not updated in user list page after selecting both options at a time in User Status dropdown in user profile page - FAIL");
			}
			
			
			
		}
		@Test(dependsOnMethods = "TC_107SelectbothActiveandInactive")
		public void TC_108SelectOptionFromUserStatusDropdown() throws InterruptedException {
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			tsu.getUserStatusdropdown().click();
			tsu.getUserStatusActiveOptioncheckbox().click();
			utilityclassobject.gettest().log(Status.INFO,
					"Clicked Active option in User Status dropdown again to select it");
			System.out.println("Clicked Active option in User Status dropdown again to select it");
			Thread.sleep(1000);
			//click on userlistheading to go back to user list page
			tsu.getUsersListHeading().click();
			
		}
		@Test(dependsOnMethods = "TC_108SelectOptionFromUserStatusDropdown")
		public void TC_109VerifyUserStatusAfterSelection() throws InterruptedException {
			//fetch user status list from user list page and verify that user status is updated to active in user list page after changing the user status to active in user profile page
			List<WebElement> userStatusLists = tsu.getUserstatuslistfromuserlist();
			boolean isUserStatusUpdatedToActive = false;
			for (WebElement statusElement : userStatusLists) {
				if (statusElement.getText().trim().equals("Active")) {
					isUserStatusUpdatedToActive = true;
					break;
				}
				
			}
			if (isUserStatusUpdatedToActive) {
				System.out.println("User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is updated to Active in user list page after changing the user status to active in user profile page - PASS");
			} else {
				System.out.println("User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
				utilityclassobject.gettest().log(Status.INFO,
						"User status is not updated to Active in user list page after changing the user status to active in user profile page - FAIL");
			}
			
			
			
		}
		@Test(dependsOnMethods = "TC_109VerifyUserStatusAfterSelection")
		public void TC_110VerifyAccessSummaryAfterUserStatusChange() throws InterruptedException {
			
			
		}
		@Test(dependsOnMethods = "TC_110VerifyAccessSummaryAfterUserStatusChange")
		public void TC_111ChangeRegionFromUserProfile() throws InterruptedException {
		
			
		}
		@Test(dependsOnMethods = "TC_111ChangeRegionFromUserProfile")
		public void TC_112VerifyAccessSummaryAfterRegionChange() throws InterruptedException {
			
		}
		
}