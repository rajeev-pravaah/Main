package Demo;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Octopussaas.BaseUtility.Baseclass;
import com.Octopussaas.ObjectRepository.GeneratorManagentPage;
import com.Octopussaas.ObjectRepository.GeneretorInformation;
import com.Octopussaas.ObjectRepository.HomePage;
import com.Octopussaas.ObjectRepository.RouteAssignment;

public class DemoAddServiceTest extends Baseclass {

    @Test
    public void addSingleServiceForCharlie() throws InterruptedException {
        // Hard-coded generator account name
        String generatorAccount = "Charlie_109793";

        // Navigate to Generator Management using robust helper from DemoRouteOptimizeTest
        HomePage hp = new HomePage(driver);
        GeneratorManagentPage gmp = new GeneratorManagentPage(driver);

        // Use the helper method from DemoRouteOptimizeTest by creating an instance and calling it via reflection
        // (We can't call private helper directly; instead copy the robust click logic here.)
        try {
            // try normal click
            wlib.waitUntilElementClickable(driver, hp.getGeneratoemanag());
            wlib.scrollToelement(driver, hp.getGeneratoemanag());
            hp.getGeneratoemanag().click();
        } catch (Exception e) {
            // fallback to JS click
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", hp.getGeneratoemanag());
        }

        // Search for the generator and click it
        wlib.waitForElementPresent(driver, gmp.getSearchtxt());
        gmp.getSearchtxt().clear();
        gmp.getSearchtxt().sendKeys(generatorAccount);

        WebElement acct = null;
        String accountXpath = "//div[@title='" + generatorAccount + "']";
        for (int i = 0; i < 5; i++) {
            try {
                acct = driver.findElement(org.openqa.selenium.By.xpath(accountXpath));
                wlib.waitUntilElementClickable(driver, acct);
                acct.click();
                break;
            } catch (Exception ex) {
                Thread.sleep(1000);
            }
        }
        if (acct == null) {
            throw new RuntimeException("Account not found: " + generatorAccount);
        }

        // Open generator info and go to Route Assignment
        GeneretorInformation gip = new GeneretorInformation(driver);
        wlib.waitUntilElementClickable(driver, gip.getEllipse());
        gip.Ellisebtn();

        // On Route Assignment, add a single service
        RouteAssignment ras = new RouteAssignment(driver);
        wlib.waitUntilElementClickable(driver, ras.getAddservice());
        ras.AddService();

        System.out.println("Add service flow completed for: " + generatorAccount);
    }
}