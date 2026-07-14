package com.Octopussaas.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='email']")
	private WebElement EmailAdressTextField;

	@FindBy(xpath = "//input[@type=\"password\"]")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement LoginBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmailAdressTextField() {
		return EmailAdressTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	/**
	 * Logs into the application.
	 * Uses explicit waits and deliberate pauses between interactions to avoid
	 * Firebase Auth bot-detection errors (auth/too-many-requests, auth/wrong-password
	 * triggered by automation speed).
	 */
	public void LoginToApp(String Username, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// ── Step 1: Wait for the email field to be visible & clickable ──────────────
		wait.until(ExpectedConditions.visibilityOf(EmailAdressTextField));
		wait.until(ExpectedConditions.elementToBeClickable(EmailAdressTextField));
		EmailAdressTextField.click();
		Thread.sleep(500);
		EmailAdressTextField.clear();
		// Type via JS first to ensure Angular/Firebase form detects the change
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].value = '';", EmailAdressTextField);
		EmailAdressTextField.sendKeys(Username);
		Thread.sleep(800);

		// ── Step 2: Wait for the password field ────────────────────────────────────
		wait.until(ExpectedConditions.visibilityOf(PasswordTextField));
		wait.until(ExpectedConditions.elementToBeClickable(PasswordTextField));
		PasswordTextField.click();
		Thread.sleep(500);
		PasswordTextField.clear();
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].value = '';", PasswordTextField);
		PasswordTextField.sendKeys(password);
		Thread.sleep(800);

		// ── Step 3: Wait for the login button and click ────────────────────────────
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
		LoginBtn.click();

		// ── Step 4: Wait until Firebase auth completes and the dashboard loads ──────
		// Dashboard/home URL no longer contains "/auth" or "/login"
		try {
			wait.until(ExpectedConditions.not(
					ExpectedConditions.urlContains("/auth")));
		} catch (Exception e) {
			// If URL check times out, a short hard wait is the fallback
			Thread.sleep(5000);
		}

		// Final buffer to allow the React/Angular app to fully render after login
		Thread.sleep(3000);
	}
}
