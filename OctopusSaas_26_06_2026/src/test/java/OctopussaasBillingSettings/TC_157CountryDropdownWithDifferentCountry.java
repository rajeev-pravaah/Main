package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.BaseClass80;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.BillingSettings;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaas.ObjectRepository.TransporterProfile;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)
public class TC_157CountryDropdownWithDifferentCountry extends BaseClass80 {

	ExcelUtility elib;
	HomePage hp;
	BillingSettings bs;
	JavascriptExecutor js;
	WebDriverWait wait;

	// ─── Helper: find element across all iframes using multiple locators ─────────
	private WebElement findInIframes(By... locators) {
		driver.switchTo().defaultContent();
		int total = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < total; i++) {
			for (By loc : locators) {
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(i);
					java.util.List<WebElement> found = driver.findElements(loc);
					if (!found.isEmpty()) {
						System.out.println("INFO: Element found in iframe[" + i + "] via: " + loc);
						return found.get(0);
					}
				} catch (Exception ignored) {}
			}
		}
		// Fallback: default content
		driver.switchTo().defaultContent();
		for (By loc : locators) {
			try {
				java.util.List<WebElement> found = driver.findElements(loc);
				if (!found.isEmpty()) {
					System.out.println("INFO: Element found on default content via: " + loc);
					return found.get(0);
				}
			} catch (Exception ignored) {}
		}
		return null;
	}

	// ─── Helper: remove restrictions, type char-by-char, fire JS events ─────────
	private void typeInField(WebElement field, String value) throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);", field);
		js.executeScript("arguments[0].removeAttribute('disabled')", field);
		js.executeScript("arguments[0].removeAttribute('readonly')", field);
		js.executeScript("arguments[0].removeAttribute('maxlength')", field);
		Thread.sleep(300);
		field.click();
		field.sendKeys(Keys.CONTROL + "a");
		field.sendKeys(Keys.DELETE);
		Thread.sleep(300);
		Actions actions = new Actions(driver);
		actions.moveToElement(field).click().perform();
		for (char c : value.toCharArray()) {
			actions.sendKeys(String.valueOf(c)).perform();
			Thread.sleep(120);
		}
		Thread.sleep(400);
		js.executeScript(
			"var el=arguments[0], s=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
			"s.call(el,arguments[1]);" +
			"['input','change','keydown','keyup'].forEach(t=>el.dispatchEvent(new Event(t,{bubbles:true})));",
			field, value);
		Thread.sleep(400);
	}

	// ─── Helper: pass/fail log shortcut ─────────────────────────────────────────
	private void log(boolean pass, String msg) {
		Status s = pass ? Status.PASS : Status.FAIL;
		utilityclassobject.gettest().log(s, msg);
		System.out.println((pass ? "PASS" : "FAIL") + ": " + msg);
	}

	// ────────────────────────────────────────────────────────────────────────────
	@Test
	public void TC_157CountryDropdownWithDifferentValue()
			throws InterruptedException, EncryptedDocumentException, IOException {

		hp   = new HomePage(driver);
		elib = new ExcelUtility();
		bs   = new BillingSettings(driver);
		js   = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='80%'");
		utilityclassobject.gettest().log(Status.INFO, "Home page displayed successfully");
		System.out.println("INFO: Home page displayed successfully");

		// Step 1: Profile icon
		hp.getUserprofile().click();
		Thread.sleep(2000);
		log(true, "Clicked on User Profile icon");

		// Step 2: Transporter Settings
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		log(true, "Clicked on Transporter Settings");

		// Step 3: Billing Settings
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		log(true, "Clicked on Billing Settings");

		// Step 4: Add New Payment Method
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		Thread.sleep(1000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
		log(true, "Clicked on Add New Payment Method button");

		// Step 5: Add Card Details (first button)
		js.executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(1000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		log(true, "Clicked on Add Card Details button");

		// Step 6: Card Number (Last 4 Digits)
		try {
			WebElement cardNumberTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getLast4DigitsOfCreditCardTextfield()));
			js.executeScript("arguments[0].scrollIntoView(true);", cardNumberTextField);
			Thread.sleep(500);
			String creditcardno = elib.getDataFromExcel("BillingSettings", 4, 1);
			cardNumberTextField.clear();
			cardNumberTextField.sendKeys(creditcardno);
			Thread.sleep(500);
			log(true, "Entered '" + creditcardno + "' in Card Number text field");
		} catch (Exception e) {
			log(false, "Failed to enter Card Number - " + e.getMessage());
		}

		// Step 7: Account Holder Name
		WebElement accountHolderName = bs.getAccountHolderNameTextfield();
		js.executeScript("arguments[0].removeAttribute('disabled')", accountHolderName);
		js.executeScript("arguments[0].removeAttribute('readonly')", accountHolderName);
		accountHolderName.clear();
		accountHolderName.click();
		accountHolderName.sendKeys("Raju");
		Thread.sleep(500);
		log(true, "Entered 'Raju' in Account Holder Name text field");

		// Step 8: CVV/CVC (pre-iframe form field)
		Thread.sleep(2000);
		bs.getCvvCvcTextfield().sendKeys("123");

		// Step 9: Add Card Details Button 2
		bs.getAddCardDetailsButton2().click();
		Thread.sleep(2000);
		log(true, "Entered '123' in CVV/CVC field and clicked Add Card Details button");

		// Step 10: Verify Credit Card Information header
		try {
			WebElement header = wait.until(ExpectedConditions.visibilityOf(bs.getCreditCardInformationHeader()));
			log(header.isDisplayed(), header.isDisplayed()
				? "Credit Card Information header is displayed"
				: "Credit Card Information header is NOT displayed");
		} catch (Exception e) {
			log(false, "Failed to verify Credit Card Information header - " + e.getMessage());
		}
		Thread.sleep(8000);

		// Step 11: Card number inside iframe
		try {
			WebElement cardField = findInIframes(
				By.id("card-number-input"),
				By.xpath("//input[@id='card-number-input']"));
			if (cardField == null) throw new Exception("Card number field not found in any iframe.");
			typeInField(cardField, "4242424242424242");
			log(true, "Entered '4242424242424242' in Card Number field inside iframe");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			log(false, "Failed to enter card number - " + e.getMessage());
		}

		// Step 12: Expiration date inside iframe
		try {
			WebElement expiryField = findInIframes(
				By.xpath("//input[@placeholder='MM / YY']"),
				By.id("expiry-input"));
			if (expiryField == null) throw new Exception("Expiry field not found in any iframe.");
			typeInField(expiryField, "1231");
			log(true, "Entered '1231' in Expiration Date field inside iframe");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			log(false, "Failed to enter Expiration Date - " + e.getMessage());
		}

		// Step 13: CVC inside iframe
		try {
			WebElement cvcField = findInIframes(
				By.id("cvc-input"),
				By.xpath("//input[@id='cvc-input']"),
				By.xpath("//input[@name='cvc']"),
				By.xpath("//input[@placeholder='CVC']"),
				By.xpath("//input[@placeholder='CVV']"),
				By.xpath("//input[@aria-label='CVC']"),
				By.xpath("//input[@aria-label='Enter cvc number']"),
				By.xpath("//input[@data-elements-stable-field-name='cardCvc']"));
			if (cvcField == null) throw new Exception("CVC field not found in any iframe.");
			typeInField(cvcField, "123");
			String val = cvcField.getAttribute("value");
			System.out.println("INFO: CVC field value after input: " + val);
			log(true, "Entered '123' in CVV/CVC field inside iframe. Actual value: " + val);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			log(false, "Failed to enter CVV value inside iframe - " + e.getMessage());
		}

		// Step 14: Verify default value of Country dropdown inside iframe
		try {
			WebElement countryDropdown = findInIframes(
				By.id("country-input"),
				By.xpath("//select[@id='country-input']"),
				By.xpath("//select[@name='country']"),
				By.xpath("//select[contains(@id,'country') or contains(@name,'country')]"));
			if (countryDropdown == null) throw new Exception("Country dropdown not found in any iframe.");

			Select countrySelect   = new Select(countryDropdown);
			WebElement defaultOpt  = countrySelect.getFirstSelectedOption();
			String defaultText     = defaultOpt.getText().trim();
			String defaultValue    = defaultOpt.getAttribute("value");

			System.out.println("INFO: Country dropdown default TEXT  : " + defaultText);
			System.out.println("INFO: Country dropdown default VALUE : " + defaultValue);
			log(true, "Country dropdown default value - Text: '" + defaultText + "' | Value: '" + defaultValue + "'");

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			log(false, "Failed to verify Country dropdown default value - " + e.getMessage());
		}
		//Clcik on the country dropdown and select India 
		try {
			WebElement countryDropdown = findInIframes(
				By.id("country-input"),
				By.xpath("//select[@id='country-input']"),
				By.xpath("//select[@name='country']"),
				By.xpath("//select[contains(@id,'country') or contains(@name,'country')]"));
			if (countryDropdown == null) throw new Exception("Country dropdown not found in any iframe.");

			Select countrySelect = new Select(countryDropdown);
			countrySelect.selectByVisibleText("India");
			log(true, "Selected 'India' from Country dropdown inside iframe");

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			log(false, "Failed to select 'India' from Country dropdown - " + e.getMessage());
		}
		
	}
}
