package OctopussaasBillingSettings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TC_166AccountTypeBusinessInACH extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_166AccountTypeBusinessInACH() throws InterruptedException, EncryptedDocumentException, IOException {

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
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getAddNewPaymentMethodButton());
		Thread.sleep(1000);
		bs.getAddNewPaymentMethodButton().click();
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Clicked on Add New Payment Method button successfully");
		System.out.println("INFO: Clicked on Add New Payment Method button successfully");

		// Step 5: Click Add Card Details button
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

		// Step 11: Switch to iframe → click on Account Type dropdown → select 'Business' → verify selection
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean selectionVerified = false;
		final String EXPECTED_VALUE = "Business";

		// Strategy 1: Loop all iframes to find the Account Type dropdown
		try {
			List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println("INFO: Total iframes found on page: " + iframes.size());

			for (int i = 0; i < iframes.size(); i++) {
				try {
					String frameName = iframes.get(i).getAttribute("name");
					String frameId   = iframes.get(i).getAttribute("id");
					System.out.println("INFO: iframe[" + i + "] name='" + frameName + "' id='" + frameId + "'");
					driver.switchTo().frame(iframes.get(i));

					List<WebElement> dropdowns = driver.findElements(
							By.xpath("//select[@id='field-_r_1_'] | //select[contains(@id,'accountType') or contains(@name,'accountType') or contains(@id,'account-type')]"));

					if (!dropdowns.isEmpty()) {
						WebElement accountTypeDropdown = dropdowns.get(0);
						js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
						Thread.sleep(500);

						// Select 'Business' from the Account Type dropdown
						Select selectObj = new Select(accountTypeDropdown);
						selectObj.selectByVisibleText(EXPECTED_VALUE);
						Thread.sleep(1000);
						System.out.println("INFO: Selected '" + EXPECTED_VALUE + "' from Account Type dropdown in iframe[" + i + "]");

						// Verify the selected option
						WebElement selectedOption = selectObj.getFirstSelectedOption();
						String selectedText = selectedOption.getText().trim();

						System.out.println("INFO: Currently selected value in Account Type dropdown: '" + selectedText + "'");

						if (selectedText.equalsIgnoreCase(EXPECTED_VALUE)) {
							utilityclassobject.gettest().log(Status.PASS,
									"'" + EXPECTED_VALUE + "' is selected and displayed in the Account Type dropdown successfully from iframe[" + i + "]");
							System.out.println("PASS: '" + EXPECTED_VALUE + "' is selected and displayed in the Account Type dropdown successfully");
						} else {
							utilityclassobject.gettest().log(Status.FAIL,
									"Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "' in Account Type dropdown");
							System.out.println("FAIL: Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "' in Account Type dropdown");
						}

						selectionVerified = true;
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
		if (!selectionVerified) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				WebElement accountTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//select[@id='field-_r_1_'] | //select[contains(@id,'accountType') or contains(@name,'accountType')]")));
				js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
				Thread.sleep(500);

				// Select 'Business'
				Select selectObj = new Select(accountTypeDropdown);
				selectObj.selectByVisibleText(EXPECTED_VALUE);
				Thread.sleep(1000);
				System.out.println("INFO: Strategy 2 - Selected '" + EXPECTED_VALUE + "' from Account Type dropdown");

				// Verify the selected option
				WebElement selectedOption = selectObj.getFirstSelectedOption();
				String selectedText = selectedOption.getText().trim();
				System.out.println("INFO: Strategy 2 - Currently selected value: '" + selectedText + "'");

				if (selectedText.equalsIgnoreCase(EXPECTED_VALUE)) {
					utilityclassobject.gettest().log(Status.PASS,
							"Strategy 2 frame(0): '" + EXPECTED_VALUE + "' is selected and displayed in Account Type dropdown successfully");
					System.out.println("PASS: Strategy 2: '" + EXPECTED_VALUE + "' is selected and displayed in the Account Type dropdown successfully");
				} else {
					utilityclassobject.gettest().log(Status.FAIL,
							"Strategy 2: Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "'");
					System.out.println("FAIL: Strategy 2: Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "'");
				}
				selectionVerified = true;
			} catch (Exception e2) {
				System.out.println("INFO: Strategy 2 (frame index 0) failed - " + e2.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		// Strategy 3: Fallback - use bs.getAccounttypedropdowninACH() via PageFactory
		if (!selectionVerified) {
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				WebElement accountTypeDropdown = bs.getAccounttypedropdowninACH();
				js.executeScript("arguments[0].scrollIntoView(true);", accountTypeDropdown);
				Thread.sleep(500);

				// Select 'Business'
				Select selectObj = new Select(accountTypeDropdown);
				selectObj.selectByVisibleText(EXPECTED_VALUE);
				Thread.sleep(1000);
				System.out.println("INFO: Strategy 3 PageFactory - Selected '" + EXPECTED_VALUE + "' from Account Type dropdown");

				// Verify the selected option
				WebElement selectedOption = selectObj.getFirstSelectedOption();
				String selectedText = selectedOption.getText().trim();
				System.out.println("INFO: Strategy 3 PageFactory - Currently selected value: '" + selectedText + "'");

				if (selectedText.equalsIgnoreCase(EXPECTED_VALUE)) {
					utilityclassobject.gettest().log(Status.PASS,
							"Strategy 3 PageFactory: '" + EXPECTED_VALUE + "' is selected and displayed in Account Type dropdown successfully");
					System.out.println("PASS: Strategy 3 PageFactory: '" + EXPECTED_VALUE + "' is selected and displayed in the Account Type dropdown successfully");
				} else {
					utilityclassobject.gettest().log(Status.FAIL,
							"Strategy 3: Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "'");
					System.out.println("FAIL: Strategy 3: Expected '" + EXPECTED_VALUE + "' but found '" + selectedText + "'");
				}
				selectionVerified = true;
			} catch (Exception e3) {
				System.out.println("INFO: Strategy 3 (PageFactory getAccounttypedropdowninACH) failed - " + e3.getMessage());
				driver.switchTo().defaultContent();
			}
		}

		if (!selectionVerified) {
			utilityclassobject.gettest().log(Status.FAIL,
					"Account Type dropdown not found in any iframe - could not select '" + EXPECTED_VALUE + "' using all strategies");
			System.out.println("FAIL: Account Type dropdown not found in any iframe using all strategies");
		}

		// Always switch back to default content
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
	}
}
