package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class TC_152AddCardNumber extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_152AddCardNumber() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		bs = new BillingSettings(driver);
		wlib = new webDriverutility();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Step 1: Click on Profile Icon
		hp.getUserprofile().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on User Profile icon successfully");
		System.out.println("INFO: Clicked on User Profile icon successfully");

		// Step 2: Click on Transporter Settings
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Transporter Settings successfully");
		System.out.println("INFO: Clicked on Transporter Settings successfully");

		// Step 3: Click on Billing Settings
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs = new BillingSettings(driver);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Billing Settings successfully");
		System.out.println("INFO: Clicked on Billing Settings successfully");

		// Step 4: Scroll to and click Add New Payment Method button
		// XPath: //button[text()='Add New Payment Method']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		Thread.sleep(1000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		// XPath: //button[text()='Add Card Details']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(1000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter value in Card Number (Last 4 Digits) text field
		// XPath: //input[@placeholder='Last 4 Digits Of Credit Card / ACH Number']
		try {
			WebElement cardNumberTextField = wait.until(
					ExpectedConditions.visibilityOf(bs.getLast4DigitsOfCreditCardTextfield()));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardNumberTextField);
			Thread.sleep(1000);
			String creditcardno = elib.getDataFromExcel("BillingSettings", 4, 1);
			System.out.println(creditcardno);
			cardNumberTextField.clear();
			cardNumberTextField.sendKeys(creditcardno);
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.PASS, "Entered '" + creditcardno + "' in Card Number text field successfully");
			System.out.println("PASS: Entered '" + creditcardno + "' in Card Number text field successfully");
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter Card Number - " + e.getMessage());
			System.out.println("FAIL: Failed to enter Card Number - " + e.getMessage());
		}

		// Step 7: Pass the value in Account Holder Name text field
		WebElement accountHolderName = bs.getAccountHolderNameTextfield();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", accountHolderName);
		js.executeScript("arguments[0].removeAttribute('readonly')", accountHolderName);
		accountHolderName.clear();
		accountHolderName.click();
		accountHolderName.sendKeys("Raju");
		Thread.sleep(1000);
		utilityclassobject.gettest().log(Status.PASS, "Entered 'Raju' in Account Holder Name text field successfully");
		System.out.println("PASS: Entered 'Raju' in Account Holder Name text field successfully");

		// Step 8: Enter 3-digit CVV/CVC value
		Thread.sleep(2000);
		bs.getCvvCvcTextfield().sendKeys("123");

		// Step 9: Click Add Card Details Button 2
		bs.getAddCardDetailsButton2().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.PASS, "Entered '123' in CVV/CVC text field and clicked on Add Card Details button successfully");
		System.out.println("PASS: Entered '123' in CVV/CVC text field and clicked on Add Card Details button successfully");

		// Step 10: Verify Credit Card Information header is displayed
		try {
			WebElement creditCardInfoHeader = wait.until(
					ExpectedConditions.visibilityOf(bs.getCreditCardInformationHeader()));
			if (creditCardInfoHeader.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "Credit Card Information header is displayed successfully");
				System.out.println("PASS: Credit Card Information header is displayed successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Credit Card Information header is not displayed");
				System.out.println("FAIL: Credit Card Information header is not displayed");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Failed to verify Credit Card Information header - " + e.getMessage());
			System.out.println("FAIL: Failed to verify Credit Card Information header - " + e.getMessage());
		}
		Thread.sleep(8000);

		// Step 11: Enter card number '4242424242424242' in Card Number text field
		// XPath: //input[@id='card-number-input']
		try {
			// Attempt 1: Try switching into iframe if card field is inside one
			boolean insideIframe = false;
			java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found on page: " + iframes.size());
			for (WebElement iframe : iframes) {
				try {
					driver.switchTo().frame(iframe);
					java.util.List<WebElement> cardInputs = driver.findElements(By.id("card-number-input"));
					if (!cardInputs.isEmpty()) {
						insideIframe = true;
						System.out.println("INFO: Card number field found inside iframe");
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception ex) {
					driver.switchTo().defaultContent();
				}
			}

			// Attempt 2: Find card number field (inside iframe or directly on page)
			WebElement cardNumberField = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("card-number-input")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardNumberField);
			Thread.sleep(1000);

			// Remove any restrictions
			js.executeScript("arguments[0].removeAttribute('disabled')", cardNumberField);
			js.executeScript("arguments[0].removeAttribute('readonly')", cardNumberField);
			Thread.sleep(500);

			// Click to focus the field
			cardNumberField.click();
			Thread.sleep(500);

			// Clear existing value
			cardNumberField.sendKeys(Keys.CONTROL + "a");
			cardNumberField.sendKeys(Keys.DELETE);
			Thread.sleep(500);

			// Type card number character by character using Actions
			Actions actions = new Actions(driver);
			actions.moveToElement(cardNumberField).click().perform();
			Thread.sleep(500);
			String cardNum = "4242424242424242";
			for (char c : cardNum.toCharArray()) {
				actions.sendKeys(String.valueOf(c)).perform();
				Thread.sleep(80);
			}
			Thread.sleep(1000);

			// Fire input and change events via JavaScript to trigger framework listeners
			js.executeScript(
				"var el = arguments[0];" +
				"var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;" +
				"nativeInputValueSetter.call(el, '4242424242424242');" +
				"el.dispatchEvent(new Event('input', { bubbles: true }));" +
				"el.dispatchEvent(new Event('change', { bubbles: true }));",
				cardNumberField);
			Thread.sleep(1000);

			utilityclassobject.gettest().log(Status.PASS, "Entered '4242424242424242' in Card Number text field successfully");
			System.out.println("PASS: Entered '4242424242424242' in Card Number text field successfully");

			// Switch back to default content if we switched into an iframe
			if (insideIframe) {
				driver.switchTo().defaultContent();
			}

		} catch (Exception e) {
			driver.switchTo().defaultContent();
			utilityclassobject.gettest().log(Status.FAIL, "Failed to enter card number - " + e.getMessage());
			System.out.println("FAIL: Failed to enter card number - " + e.getMessage());
		}
	}
}
