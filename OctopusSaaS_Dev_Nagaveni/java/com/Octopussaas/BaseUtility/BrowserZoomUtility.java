package com.Octopussaas.BaseUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserZoomUtility {

    private WebDriver driver;

    /**
     * Launch Chrome, open Octopus app URL, set window size and page zoom to 80%.
     * @param url Application URL (e.g. https://app.octopus.com)
     * @return initialized WebDriver instance
     */
    public WebDriver launchOctopusWith80PercentZoom(String url) {
        driver = new ChromeDriver();

        // Maximize first to ensure consistent sizing, then reduce to 80% of screen
        driver.manage().window().maximize();

        // Optionally set a concrete size approximating 80% of common screens
        // (you can adjust these values if needed)
        // driver.manage().window().setSize(new Dimension(1280, 720));

        driver.get(url);

        // Set page zoom to 80%
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
        }

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
