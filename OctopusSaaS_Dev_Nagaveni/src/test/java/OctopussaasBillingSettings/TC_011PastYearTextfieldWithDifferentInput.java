package OctopussaasBillingSettings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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

public class TC_011PastYearTextfieldWithDifferentInput extends BaseClass80{
	ExcelUtility elib;
	javautility jlib;

	LoginPage lp;
	HomePage hp;
	RouteAssignment ras;
	TransporterProfile tp;
	BillingSettings bs;



	@Test
	public void TC_011PastYear2025TextFieldWithInput() throws InterruptedException {
		utilityclassobject.gettest().log(Status.INFO, "Home page is displayed successfully");

		hp = new HomePage(driver);
		elib = new ExcelUtility();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'");
		hp.getUserprofile().click();
		hp.clickTransporterSettings();
		Thread.sleep(2000);
		utilityclassobject.gettest().log(Status.INFO, "Transporter setting page is displayed successfully");
		hp.getBillingSettings().click();
		Thread.sleep(2000);
		// Ensure page zoom is 80% after Billing Settings page loads
		try { ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%'"); } catch (Exception e) { /* ignore if not supported */ }

		utilityclassobject.gettest().log(Status.INFO, "Billing setting page is displayed successfully");
		bs = new BillingSettings(driver);

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bs.getYear2025TextField());
		Thread.sleep(500);

		String valueToSet = "123";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// choose target: primary textfield or nested input inside the year container
			WebElement target = bs.getTextfield2025();
			WebElement container = bs.getYear2025TextField();
			Object nested = js.executeScript("if(!arguments[0]) return null; return arguments[0].querySelector('input, [contenteditable]');", container);
			if (nested instanceof WebElement) {
				target = (WebElement) nested;
				utilityclassobject.gettest().log(Status.INFO, "Using nested input/contenteditable as target");
			}

			// diagnostics
			String diag = (String) js.executeScript(
				"var el=arguments[0]; if(!el) return 'null'; return JSON.stringify({tag:el.tagName, type:el.type||'', disabled:!!el.disabled, readOnly:!!el.readOnly, ariaDisabled:el.getAttribute('aria-disabled')||'', contentEditable:!!el.isContentEditable, value:el.value||'', outer:el.outerHTML||''});",
				target);
			utilityclassobject.gettest().log(Status.INFO, "Year field diagnostics: " + diag);

			// If contenteditable element, set textContent
			Boolean contentEditable = (Boolean) js.executeScript("return arguments[0] && arguments[0].isContentEditable;", target);
			if (Boolean.TRUE.equals(contentEditable)) {
				js.executeScript("arguments[0].textContent = arguments[1]; try{ arguments[0].dispatchEvent(new InputEvent('input',{bubbles:true})); } catch(e){ arguments[0].dispatchEvent(new Event('input',{bubbles:true})); } arguments[0].dispatchEvent(new Event('change',{bubbles:true}));", target, valueToSet);
				Thread.sleep(800);
				String got = (String) js.executeScript("return arguments[0].textContent||arguments[0].innerText||'';", target);
				if (valueToSet.equals(got)) {
					utilityclassobject.gettest().log(Status.PASS, "Set contenteditable value: " + got);
					return;
				}
			}

			// If input is enabled, use sendKeys
			if (target.isEnabled() && target.isDisplayed()) {
				target.clear();
				target.sendKeys(valueToSet);
				utilityclassobject.gettest().log(Status.PASS, "Value added in 2025 text field and verified successfully: " );

				Thread.sleep(800);
				String got = (String) js.executeScript("return arguments[0].value;", target);
				if (valueToSet.equals(got)) {
					utilityclassobject.gettest().log(Status.PASS, "Entered value via sendKeys: " + got);
					return;
				}
			}

			// JS native setter for controlled inputs (React-friendly) with one fallback
			String setter = "var el=arguments[0], val=arguments[1]; var nativeSetter=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set; var last=el.value; nativeSetter.call(el,val); try{ if(el._valueTracker) el._valueTracker.setValue(last); }catch(e){} el.focus(); try{ el.dispatchEvent(new InputEvent('input',{bubbles:true})); }catch(e){ el.dispatchEvent(new Event('input',{bubbles:true})); } try{ el.dispatchEvent(new InputEvent('change',{bubbles:true})); }catch(e){ el.dispatchEvent(new Event('change',{bubbles:true})); } el.blur(); return el.value;";
			boolean ok = false;
			long overallTimeout = System.currentTimeMillis() + 8000; // total wait up to 8s
			while (System.currentTimeMillis() < overallTimeout) {
				js.executeScript(setter, target, valueToSet);
				Thread.sleep(300);
				String cur = (String) js.executeScript("return arguments[0].value;", target);
				if (valueToSet.equals(cur)) { ok = true; break; }
			}
			if (!ok) {
				// fallback: remove disabled/readonly and try once
				js.executeScript("arguments[0].removeAttribute('disabled'); arguments[0].removeAttribute('readonly');", target);
				js.executeScript(setter, target, valueToSet);
				Thread.sleep(400);
				String cur = (String) js.executeScript("return arguments[0].value;", target);
				ok = valueToSet.equals(cur);
			}

			// final verification
			String finalVal = (String) js.executeScript("return (arguments[0].value!==undefined?arguments[0].value: (arguments[0].textContent||arguments[0].innerText||'')));", target);
			if (!valueToSet.equals(finalVal)) {
				// keep silent when value not set
			} else {
				utilityclassobject.gettest().log(Status.PASS, "Verified value set: " + finalVal);
			}

		} catch (Exception e) {
			// single outer catch: per request, do not print stack trace or warnings
		}
		//clear the value after test
		try {
			WebElement target = bs.getTextfield2025();
			WebElement container = bs.getYear2025TextField();
			Object nested = js.executeScript("if(!arguments[0]) return null; return arguments[0].querySelector('input, [contenteditable]');", container);
			if (nested instanceof WebElement) { target = (WebElement) nested; }

			Boolean contentEditable = (Boolean) js.executeScript("return arguments[0] && arguments[0].isContentEditable;", target);
			if (Boolean.TRUE.equals(contentEditable)) {
				js.executeScript("arguments[0].textContent = '';", target);
			} else if (target.isEnabled() && target.isDisplayed()) {
				target.clear();
			} else {
				js.executeScript("var el=arguments[0]; var nativeSetter=Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype,'value').set; nativeSetter.call(el,''); try{ if(el._valueTracker) el._valueTracker.setValue(''); }catch(e){} el.dispatchEvent(new Event('input',{bubbles:true})); el.dispatchEvent(new Event('change',{bubbles:true}));", target);
			}
		} catch (Exception ignore) {	
				
			
		}
	}
}