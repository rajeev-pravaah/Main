package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
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

public class TC_163ACHAccountHolderName extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_163ACHAccountHolderName() throws InterruptedException, EncryptedDocumentException, IOException {

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
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
		// XPath: //button[text()='Add Card Details']
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddCardDetailsButton());
		Thread.sleep(8000);
		bs.getAddCardDetailsButton().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 6: Enter last 4 digits in credit card number field
		bs.getLast4DigitsOfCreditCardTextfield().sendKeys(elib.getDataFromExcel("BillingSettings", 4, 1));
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Entered last 4 digits of credit card successfully");
		System.out.println("INFO: Entered last 4 digits of credit card successfully");

		// Step 7: Enter Account Holder Name as Rajeev
		bs.getAccountHolderNameTextfield().sendKeys("Rajeev");
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Entered account holder name successfully");
		System.out.println("INFO: Entered account holder name successfully");

		// Step 8: Click on ACH radio button
		bs.getACHradiobtn().click();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on ACH radio button successfully");
		System.out.println("INFO: Clicked on ACH radio button successfully");

		// Step 9: Click on Add Card Details button without JavascriptExecutor
		bs.getAddCardDetailsButton().click();

		// Step 10: Verify that Bank Account Information is displayed
		WebElement bankAccountInfo = driver.findElement(By.xpath("//label[contains(text(),'Bank Account Information')]"));
		wait.until(ExpectedConditions.visibilityOf(bankAccountInfo));
		if (bankAccountInfo.isDisplayed()) {
			utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
			System.out.println("PASS: Bank account information is displayed successfully");
		} else {
			utilityclassobject.gettest().log(Status.FAIL, "Bank account information is not displayed");
			System.out.println("FAIL: Bank account information is not displayed");
		}
		Thread.sleep(5000);

		// Switch to frame and enter Account Holder Name - Multi-strategy approach
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean valuePassed = false;

		// Strategy 1: Switch by frame name/id "005h1"
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("005h1");
			WebElement nameField = wait.until(ExpectedConditions.visibilityOf(bs.getAccountholdersnameinACH()));
			nameField.clear();
			nameField.click();
			nameField.sendKeys("Rajeev");
			Thread.sleep(500);
			valuePassed = true;
			utilityclassobject.gettest().log(Status.PASS, "Strategy 1: Switched to frame 'name/id=005h1' and entered 'Rajeev' in Account Holder Name successfully");
			System.out.println("PASS: Strategy 1: Switched to frame 'name/id=005h1' and entered 'Rajeev' in Account Holder Name successfully");
		} catch (Exception e1) {
			System.out.println("INFO: Strategy 1 (frame name/id '005h1') failed - " + e1.getMessage());
			driver.switchTo().defaultContent();
		}

		// Strategy 2: Loop all iframes, try name/id contains "005h1" or find field inside
		if (!valuePassed) {
			try {
				driver.switchTo().defaultContent();
				java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
				System.out.println("INFO: Total iframes on page: " + iframes.size());
				for (int i = 0; i < iframes.size(); i++) {
					try {
						String frameName = iframes.get(i).getAttribute("name");
						String frameId   = iframes.get(i).getAttribute("id");
						System.out.println("INFO: iframe[" + i + "] name='" + frameName + "' id='" + frameId + "'");
						driver.switchTo().frame(iframes.get(i));
						java.util.List<WebElement> fields = driver.findElements(
								By.xpath("//input[@name='fullName' or @placeholder='Account Holder Name' or @id='account-holder-name' or contains(@placeholder,'Holder') or contains(@placeholder,'holder')]"));
						if (!fields.isEmpty()) {
							WebElement nameField = fields.get(0);
							js.executeScript("arguments[0].scrollIntoView(true);", nameField);
							Thread.sleep(300);
							js.executeScript("arguments[0].removeAttribute('disabled');", nameField);
							js.executeScript("arguments[0].removeAttribute('readonly');", nameField);
							nameField.clear();
							nameField.click();
							nameField.sendKeys("Rajeev");
							Thread.sleep(500);
							// Fire React/Angular input events
							js.executeScript(
								"var el=arguments[0];" +
								"var nv=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
								"nv.call(el,'Rajeev');" +
								"el.dispatchEvent(new Event('input',{bubbles:true}));" +
								"el.dispatchEvent(new Event('change',{bubbles:true}));", nameField);
							Thread.sleep(500);
							valuePassed = true;
							utilityclassobject.gettest().log(Status.PASS, "Strategy 2: Switched to iframe[" + i + "] and entered 'Rajeev' in Account Holder Name successfully");
							System.out.println("PASS: Strategy 2: Switched to iframe[" + i + "] and entered 'Rajeev' in Account Holder Name successfully");
							break;
						}
						driver.switchTo().defaultContent();
					} catch (Exception ex) {
						driver.switchTo().defaultContent();
						System.out.println("INFO: iframe[" + i + "] skipped - " + ex.getMessage());
					}
				}
			} catch (Exception e2) {
				System.out.println("INFO: Strategy 2 (loop iframes) failed - " + e2.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		// Strategy 3: Switch by index 0, then find field
		if (!valuePassed) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//input[@name='fullName' or @placeholder='Account Holder Name' or contains(@placeholder,'Holder')]")));
				js.executeScript("arguments[0].removeAttribute('disabled');", nameField);
				nameField.clear();
				nameField.click();
				nameField.sendKeys("Rajeev");
				Thread.sleep(500);
				js.executeScript(
					"var el=arguments[0];" +
					"var nv=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set;" +
					"nv.call(el,'Rajeev');" +
					"el.dispatchEvent(new Event('input',{bubbles:true}));" +
					"el.dispatchEvent(new Event('change',{bubbles:true}));", nameField);
				Thread.sleep(500);
				valuePassed = true;
				utilityclassobject.gettest().log(Status.PASS, "Strategy 3: Switched to frame(0) and entered 'Rajeev' in Account Holder Name successfully");
				System.out.println("PASS: Strategy 3: Switched to frame(0) and entered 'Rajeev' in Account Holder Name successfully");
			} catch (Exception e3) {
				System.out.println("INFO: Strategy 3 (frame index 0) failed - " + e3.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		// Strategy 4: Actions class sendKeys inside frame
		if (!valuePassed) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("005h1");
				WebElement nameField = driver.findElement(By.xpath("//input[@name='fullName' or @placeholder='Account Holder Name' or contains(@placeholder,'Holder')]"));
				js.executeScript("arguments[0].scrollIntoView({block:'center'});", nameField);
				Thread.sleep(500);
				new Actions(driver).moveToElement(nameField).click().sendKeys("Rajeev").perform();
				Thread.sleep(500);
				valuePassed = true;
				utilityclassobject.gettest().log(Status.PASS, "Strategy 4: Actions sendKeys 'Rajeev' in Account Holder Name successfully");
				System.out.println("PASS: Strategy 4: Actions sendKeys 'Rajeev' in Account Holder Name successfully");
			} catch (Exception e4) {
				System.out.println("INFO: Strategy 4 (Actions sendKeys) failed - " + e4.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		if (!valuePassed) {
			utilityclassobject.gettest().log(Status.FAIL, "All strategies failed to enter value in Account Holder Name inside iframe");
			System.out.println("FAIL: All strategies failed to enter value in Account Holder Name inside iframe");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
}
