package OctopussaasBillingSettings;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_121DaysTextfieldWithoutSuspenssionSettings extends BaseClass80 {

	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;

	@Test
	public void TC_121DaysTextfieldWithoutSuspenssionSettings() throws InterruptedException, EncryptedDocumentException, IOException {

		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");
		System.out.println("INFO: Home page is displayed successfully");
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is displayed successfully");
		System.out.println("INFO: Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		bs = new BillingSettings(driver);

		// Scroll to payment terms dropdown as anchor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getPaymenttermsdropdown());
		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		System.out.println("INFO: Billing setting page is displayed successfully");
		Thread.sleep(2000);

		// Scroll to the Subsequent Checkbox from Suspension Settings
		wlib.scrollToelement(driver, bs.getSubsequentCheckboxfromsuspenssionsettings());
		Thread.sleep(2000);

		// Step 1: Uncheck the Subsequent Checkbox from Suspension Settings
		WebElement subsequentCheckbox = bs.getSubsequentCheckboxfromsuspenssionsettings();

		// Check if already checked - if so uncheck it, otherwise leave it unchecked
		String checkboxClass = subsequentCheckbox.getAttribute("class");
		if (checkboxClass != null && (checkboxClass.contains("checked") || checkboxClass.contains("active")
				|| checkboxClass.contains("bg-") || checkboxClass.contains("true"))) {
			// Already checked - click to uncheck
			subsequentCheckbox.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Unchecked the Subsequent Checkbox from Suspension Settings successfully");
			System.out.println("INFO: Unchecked the Subsequent Checkbox from Suspension Settings successfully");
		} else {
			// Not checked - first check it then uncheck it
			subsequentCheckbox.click();
			Thread.sleep(1000);
			utilityclassobject.gettest().log(Status.INFO, "Checked the Subsequent Checkbox from Suspension Settings");
			System.out.println("INFO: Checked the Subsequent Checkbox from Suspension Settings");
			subsequentCheckbox.click();
			Thread.sleep(2000);
			utilityclassobject.gettest().log(Status.INFO, "Unchecked the Subsequent Checkbox from Suspension Settings successfully");
			System.out.println("INFO: Unchecked the Subsequent Checkbox from Suspension Settings successfully");
		}

		// Step 2: Try to enter a value in Days text field - it should have disappeared
		List<WebElement> daysTextFields = driver.findElements(
				org.openqa.selenium.By.xpath("(//span[text()='Subsequent:'])[3]/../../descendant::input"));

		if (daysTextFields == null || daysTextFields.isEmpty()) {
			// Days text field is not visible - test passed as expected
			System.out.println("Days text field is NOT displayed after unchecking the Subsequent Checkbox - Behaviour is correct");
			utilityclassobject.gettest().log(Status.PASS, "Days text field disappeared after unchecking the Subsequent Checkbox from Suspension Settings - Behaviour is correct");
		} else {
			// Days text field is still visible - try to enter value
			WebElement daysTextField = daysTextFields.get(0);
			if (daysTextField.isDisplayed()) {
				daysTextField.click();
				Thread.sleep(1000);
				daysTextField.sendKeys(Keys.CONTROL + "a");
				daysTextField.sendKeys(Keys.DELETE);
				daysTextField.sendKeys("10");
				Thread.sleep(1000);
				System.out.println("Days text field is still displayed - Entered value '10' in the Days text field");
				utilityclassobject.gettest().log(Status.FAIL, "Days text field is still displayed after unchecking the Subsequent Checkbox - Days text field should have disappeared");
			} else {
				System.out.println("Days text field is NOT displayed after unchecking the Subsequent Checkbox Disappear - Behaviour is correct");
				utilityclassobject.gettest().log(Status.PASS, "Days text field disappeared after unchecking the Subsequent Checkbox from Suspension Settings - Behaviour is correct");
			}
			
		}
		Thread.sleep(2000);
		subsequentCheckbox.click();

	}
}
