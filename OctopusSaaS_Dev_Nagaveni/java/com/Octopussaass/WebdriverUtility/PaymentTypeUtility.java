package com.Octopussaass.WebdriverUtility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Small helper utility for verifying presence/displayed state of payment-type checkboxes
 * (Credit Memo, Credit Card / ACH, Check) used in Billing Settings tests.
 */
public class PaymentTypeUtility {
    private final WebDriver driver;

    public PaymentTypeUtility(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCreditMemoDisplayed() {
        return isDisplayed("//span[text()='Credit Memo']/../descendant::div");
    }

    public boolean isCreditCardACHDisplayed() {
        return isDisplayed("//span[text()='Credit Card / ACH']/../descendant::div");
    }

    public boolean isCheckDisplayed() {
        return isDisplayed("//span[text()='Check']/../descendant::div");
    }

    private boolean isDisplayed(String xpath) {
        try {
            WebElement el = driver.findElement(By.xpath(xpath));
            return el != null && el.isDisplayed();
        } catch (Throwable t) {
            // element not present or other error -> treat as not displayed
            return false;
        }
    }

    /**
     * Convenience method that returns a map of the three payment types to their displayed state.
     */
    public Map<String, Boolean> checkAll() {
        Map<String, Boolean> result = new HashMap<>();
        result.put("Credit Memo", isCreditMemoDisplayed());
        result.put("Credit Card / ACH", isCreditCardACHDisplayed());
        result.put("Check", isCheckDisplayed());
        return result;
    }
}
