package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
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

public class TC_164DefaultNameWithAccountTypeDropdown extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_164DefaultNameWithAccountTypeDropdown() throws InterruptedException, EncryptedDocumentException, IOException {

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
		// XPath: (//button[text()='Add Card Details'])[1]
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

		// Step 9: Click on Add Card Details button
		bs.getAddCardDetailsButton().click();
		Thread.sleep(3000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add Card Details button successfully");
		System.out.println("INFO: Clicked on Add Card Details button successfully");

		// Step 10: Verify that Bank Account Information is displayed
		try {
			WebElement bankAccountInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//label[contains(text(),'Bank Account Information')]")));
			if (bankAccountInfo.isDisplayed()) {
				utilityclassobject.gettest().log(Status.PASS, "Bank account information is displayed successfully");
				System.out.println("PASS: Bank account information is displayed successfully");
			} else {
				utilityclassobject.gettest().log(Status.FAIL, "Bank account information is not displayed");
				System.out.println("FAIL: Bank account information is not displayed");
			}
		} catch (Exception e) {
			utilityclassobject.gettest().log(Status.FAIL, "Bank account information section not found - " + e.getMessage());
			System.out.println("FAIL: Bank account information section not found - " + e.getMessage());
		}
		Thread.sleep(5000);

		// Step 11: Switch to iframe and fetch the default value from Account Type dropdown
		// XPath: //select[@id='field-_r_1_']  (inside iframe)
		// The Account Type dropdown is inside an iframe - must switch to frame first
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean dropdownFound = false;

		// Strategy 1: Loop all iframes to find the Account Type dropdown
		try {
			java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found on page: " + iframes.size());

			for (int i = 0; i < iframes.size(); i++) {
				try {
					String frameName = iframes.get(i).getAttribute("name");
					String frameId   = iframes.get(i).getAttribute("id");
					System.out.println("INFO: iframe[" + i + "] name='" + frameName + "' id='" + frameId + "'");
					driver.switchTo().frame(iframes.get(i));

					java.util.List<WebElement> dropdowns = driver.findElements(
							By.xpath("//select[@id='field-_r_1_'] | //select[contains(@id,'accountType') or contains(@name,'accountType') or contains(@id,'account-type')]"));

					if (!dropdowns.isEmpty()) {
						WebElement accountTypeDropdown = dropdowns.get(0);
						js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
						Thread.sleep(500);

						// Fetch the default selected value using Select class
						Select selectObj = new Select(accountTypeDropdown);
						WebElement defaultOption = selectObj.getFirstSelectedOption();
						String defaultValue = defaultOption.getText().trim();
						String defaultAttrValue = defaultOption.getAttribute("value");

						System.out.println("INFO: Default selected option TEXT  = '" + defaultValue + "'");
						System.out.println("INFO: Default selected option VALUE = '" + defaultAttrValue + "'");

						// Also print all available options
						java.util.List<WebElement> allOptions = selectObj.getOptions();
						System.out.println("INFO: Total options in Account Type dropdown: " + allOptions.size());
						for (int j = 0; j < allOptions.size(); j++) {
							System.out.println("INFO: Option[" + j + "] text='" + allOptions.get(j).getText() + "' value='" + allOptions.get(j).getAttribute("value") + "'");
						}

						if (defaultValue != null && !defaultValue.isEmpty()) {
							utilityclassobject.gettest().log(Status.PASS,
									"iframe[" + i + "]: Default value fetched from Account Type dropdown successfully: '" + defaultValue + "'");
							System.out.println("PASS: iframe[" + i + "]: Default value fetched from Account Type dropdown: '" + defaultValue + "'");
						} else {
							utilityclassobject.gettest().log(Status.FAIL,
									"Account Type dropdown default value is empty");
							System.out.println("FAIL: Account Type dropdown default value is empty");
						}

						dropdownFound = true;
						break;
					}
					driver.switchTo().defaultContent();
				} catch (Exception ex) {
					driver.switchTo().defaultContent();
					System.out.println("INFO: iframe[" + i + "] did not contain Account Type dropdown - " + ex.getMessage());
				}
			}
		} catch (Exception e1) {
			System.out.println("INFO: Strategy 1 (loop iframes) failed - " + e1.getMessage());
			driver.switchTo().defaultContent();
		}

		// Strategy 2: Fallback - switch to frame(0) directly
		if (!dropdownFound) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				WebElement accountTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//select[@id='field-_r_1_'] | //select[contains(@id,'accountType') or contains(@name,'accountType')]")));
				js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
				Thread.sleep(500);

				Select selectObj = new Select(accountTypeDropdown);
				WebElement defaultOption = selectObj.getFirstSelectedOption();
				String defaultValue = defaultOption.getText().trim();

				System.out.println("INFO: Fallback frame(0) - Default selected option TEXT = '" + defaultValue + "'");

				if (defaultValue != null && !defaultValue.isEmpty()) {
					utilityclassobject.gettest().log(Status.PASS,
							"Fallback frame(0): Default value fetched from Account Type dropdown: '" + defaultValue + "'");
					System.out.println("PASS: Fallback frame(0): Default value fetched from Account Type dropdown: '" + defaultValue + "'");
				} else {
					utilityclassobject.gettest().log(Status.FAIL, "Fallback: Account Type dropdown default value is empty");
					System.out.println("FAIL: Fallback: Account Type dropdown default value is empty");
				}
				dropdownFound = true;
			} catch (Exception e2) {
				System.out.println("INFO: Strategy 2 (frame index 0) failed - " + e2.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		// Strategy 3: Fallback - use bs.getAccounttypedropdowninACH() via PageFactory after switching frame
		if (!dropdownFound) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				WebElement accountTypeDropdown = bs.getAccounttypedropdowninACH();
				js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
				Thread.sleep(500);

				Select selectObj = new Select(accountTypeDropdown);
				WebElement defaultOption = selectObj.getFirstSelectedOption();
				String defaultValue = defaultOption.getText().trim();

				System.out.println("INFO: Strategy 3 PageFactory - Default selected option TEXT = '" + defaultValue + "'");

				if (defaultValue != null && !defaultValue.isEmpty()) {
					utilityclassobject.gettest().log(Status.PASS,
							"Strategy 3 PageFactory: Default value fetched from Account Type dropdown: '" + defaultValue + "'");
					System.out.println("PASS: Strategy 3 PageFactory: Default value fetched: '" + defaultValue + "'");
				} else {
					utilityclassobject.gettest().log(Status.FAIL, "Strategy 3: Account Type dropdown default value is empty");
					System.out.println("FAIL: Strategy 3: Account Type dropdown default value is empty");
				}
				dropdownFound = true;
			} catch (Exception e3) {
				System.out.println("INFO: Strategy 3 (PageFactory getAccounttypedropdowninACH) failed - " + e3.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		if (!dropdownFound) {
			utilityclassobject.gettest().log(Status.FAIL, "Account Type dropdown not found in any iframe using all strategies");
			System.out.println("FAIL: Account Type dropdown not found in any iframe using all strategies");
		}

		// Always switch back to default content
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
}
