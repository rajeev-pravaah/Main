package OctoRouteAssignmentFlowTc;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.FileUtility.ExcelUtility;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.LoginPage;
import com.Octopussaas.ObjectRepository.RouteAssignment;
import com.Octopussaass.WebdriverUtility.javautility;
import com.Octopussaass.WebdriverUtility.utilityclassobject;
import com.Octopussaass.WebdriverUtility.webDriverutility;
import com.aventstack.extentreports.Status;

@Listeners(ListnerUtility.ListnerUilityImp.class)

public class TC_078ServiceHistoryReportDetails  extends Baseclass{
	ExcelUtility elib;
	javautility jlib;
	webDriverutility wlib;
	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	GeneratorManagentPage gmp;
	GeneretorInformation gip;

	@Test
	public void TC_078() throws InterruptedException, EncryptedDocumentException, IOException, AWTException, HeadlessException, UnsupportedFlavorException {
		hp = new HomePage(driver);
		elib = new ExcelUtility();
		hp.getGeneratoemanag().click();
		gmp = new GeneratorManagentPage(driver);
		String gname = elib.getDataFromExcel("Generator", 1, 1);
		gmp.CharlieAccounttwo(gname);
		ras = new RouteAssignment(driver);
		gip = new GeneretorInformation(driver);
		gip.Ellisebtn();
		utilityclassobject.gettest().log(Status.INFO, "Route assignment page is displayed successfully");
		Thread.sleep(15000);
		ras.AddService();
		Thread.sleep(5000);
		utilityclassobject.gettest().log(Status.INFO, "Add service displayed all text field successfully");
		ras.Route1();
		utilityclassobject.gettest().log(Status.INFO, "Route selected successfully");
		ras.ServiceFrequency();
		utilityclassobject.gettest().log(Status.INFO, "Service frequency selected successfully");
		ras.SelectWeekDay();
		ras.getClickoutside().click();
		;
		utilityclassobject.gettest().log(Status.INFO, "week days selected successfully");
		ras.getCalendar().click();
		LocalDate today = LocalDate.now();
		String day = String.valueOf(today.getDayOfMonth());
		driver.findElement(By.xpath("//*[text()='" + day + "']")).click();
		utilityclassobject.gettest().log(Status.INFO, "Current date selected successfully");
		ras.ServiceType();
		utilityclassobject.gettest().log(Status.INFO, "Service type selected successfully");
		WebElement element = ras.getDefaultdisposalFacility();
		if (element.isDisplayed()) {
			System.out.println("Default disposal facility Element is visible");
		} else {
			System.out.println("Default disposal facility Element is not visible");
		}
		Assert.assertTrue(element.isDisplayed());
		utilityclassobject.gettest().log(Status.INFO, "Default disposal facility displayed successfully");
		ras.defaultdisposaldd();
		utilityclassobject.gettest().log(Status.INFO, "Default disposal facility seleccted value successfully");
		ras.ServiceDuration();
		utilityclassobject.gettest().log(Status.INFO, "Service duration selected successfully");
		Thread.sleep(5000);
		ras.ScopeOfWork();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work selected successfully");
		Thread.sleep(2000);
		ras.IncreaseGalone();
		ras.IncreaseGaltwo();
		utilityclassobject.gettest().log(Status.INFO, "Scope of work increased successfully");
		ras.AddRoute();
		utilityclassobject.gettest().log(Status.INFO, "Service is added to route successfully");
		String serviceType = driver
				.findElement(By.xpath("//span[contains(@class,'truncate') and text()='Medical Waste']")).getText();
		System.out.println(serviceType);
		Thread.sleep(15000);
		ras.CopyToclipBoard();
		ras.MovetoCancelService();
		String name = driver.findElement(
			    By.xpath("//h6[strong[contains(text(),'Service History Report')]]")
			).getText();

			System.out.println(name);
			Assert.assertTrue(name.contains(gname),"Expected text not found in actual name!");		
			utilityclassobject.gettest().log(Status.INFO, "Service history report name verified succesfully");
			// Expected headers list (updated)
			List<String> expectedHeaders = Arrays.asList(
			        "Date & Time",
			        "Service ID",
			        "OCTO Number",
			        "Service Type",
			        "Route",
			        "Service Vehicle",
			        "Driver",
			        "Service Status",
			        "Transfer Status"
			);

			// Fetch actual headers from UI
			List<WebElement> actualHeaders = driver.findElements(
			        By.xpath("//div[@id='history']//div[contains(@class,'sticky')]//div")
			);

			// Validate count first
			Assert.assertEquals(actualHeaders.size(), expectedHeaders.size(),
			        "Header count mismatch!");

			// Compare each header
			for (int i = 0; i < expectedHeaders.size(); i++) {

			    String actualText = actualHeaders.get(i).getText().trim();

			    Assert.assertTrue(actualText.contains(expectedHeaders.get(i)),
			            "Mismatch at index " + i +
			            " | Expected: " + expectedHeaders.get(i) +
			            " | Actual: " + actualText);

			    System.out.println("Verified Header: " + actualText);
				utilityclassobject.gettest().log(Status.INFO, "Service history details verified succesfully");

			}

		ras.RemoveServiceSchedule();
		utilityclassobject.gettest().log(Status.INFO, "Service is removed succesfully");
		
	}
}
