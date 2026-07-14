# BillingSettings (Page Object) — Documentation

This document describes the `BillingSettings` page object class located at
`src/main/java/com/Octopussaas/ObjectRepository/BillingSettings.java`.

Purpose
-------
`BillingSettings` encapsulates locators and accessors for elements on the billing settings page of the Octopussaas application. It uses Selenium `@FindBy` annotations and PageFactory to initialize elements.

Quick facts
-----------
- Package: `com.Octopussaas.ObjectRepository`
- Class: `BillingSettings`
- Constructor: `BillingSettings(WebDriver driver)` — initializes PageFactory elements and stores the WebDriver instance.

Primary fields (elements)
-------------------------
Below are the main private WebElement fields and their locating XPath (as declared in the class).

- `BillingHeader`
  - XPath: `//h1[contains(normalize-space(),'Billing') or contains(normalize-space(),'Billing Settings')]`
  - Purpose: Header element for the Billing or Billing Settings page

- `yeartoDateRevenue`
  - XPath: `//input[@type='number']`

- `year2025TextField`
  - XPath: `(//div[text()='2025']/ancestor::div[@class='flex items-center gap-2']/descendant::div)[2]`
  - Purpose: Container for the 2025 year control (often a sibling/wrapper element)

- `textfield2025`
  - XPath: `(//input[@type='number'])[2]`
  - Purpose: Numeric input for 2025 value

- `textfield2024`
  - XPath: `(//input[@type='number'])[3]`
  - Purpose: Numeric input for 2024 value

- `textfield2023`
  - XPath: `(//input[@type='number'])[4]`
  - Purpose: Numeric input for 2023 value

- `textfield2022`
  - XPath: `(//input[@type='number'])[5]`
  - Purpose: Numeric input for 2022 value

Other UI controls
-----------------
- `invoiceCheckbox` — `//span[text()='Invoice #']/preceding-sibling::div`
- `confirmButton` — `//button[text()='Confirm']`
- `closeButton` — `(//button[text()='✕'])[10]`
- `invoiceDateCheckbox` — `//span[text()='Invoice Date']/preceding-sibling::div`
- `dueDateCheckbox` — `//span[text()='Due Date']/preceding-sibling::div`
- `termsCheckbox` — `//span[text()='Terms']/preceding-sibling::div`
- `invoiceTotalCheckbox1` — `(//span[text()='Invoice Total']/preceding-sibling::div)[1]`
- `billToCheckbox` — `(//span[text()='Bill To']/preceding-sibling::div)[1]`
- `previousBalanceCheckbox` — `(//span[text()='Previous Balance']/preceding-sibling::div)[1]`
- `autopayStatus` — `(//span[text()='Autopay Status']/preceding-sibling::div)[1]`
- `lastPaymentCheckbox` — `(//span[text()='Last Payment']/preceding-sibling::div)[1]`
- `overdueTotalNoticeCheckbox` — `(//span[text()='Overdue Total Notice']/preceding-sibling::div)[1]`

Public getters
--------------
The class exposes the following public getters for tests to consume:

- `getTextfield2022()`
- `getTextfield2023()`
- `getTextfield2024()`
- `getTextfield2025()`
- `getYeartoDateRevenue()`
- `getYear2025TextField()`
- `getInvoiceCheckbox()`
- `getConfirmButton()`
- `getCloseButton()`
- `getInvoiceDateCheckbox()`
- `getDueDateCheckbox()`
- `getTermsCheckbox()`
- `getInvoiceTotalCheckbox1()`
- `getBillToCheckbox()`
- `getPreviousBalanceCheckbox()`
- `getAutopayStatus()`
- `getLastPaymentCheckbox()`
- `getOverdueTotalNoticeCheckbox()`
- `getBillingHeader()`
- `getDriver()`

Special helper method
---------------------
- `getHardCloseDate()` — dynamic finder. This method tries several candidate XPaths (labels, following inputs/divs, aria-label/placeholder/name) and returns the first visible/clickable element found. It waits up to 10 seconds for presence and ensures the returned element is clickable. If none found, it throws `NoSuchElementException` with a helpful listing of candidate XPaths.

Usage examples
--------------
Example: instantiate the page object in a TestNG test:

```java
// inside a test method with a valid WebDriver instance "driver"
BillingSettings bs = new BillingSettings(driver);
WebElement tf2024 = bs.getTextfield2024();
// scroll into view
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tf2024);
// set value (if enabled)
if (tf2024.isDisplayed() && tf2024.isEnabled()) {
    tf2024.clear();
    tf2024.sendKeys("123");
}
```

React/Framework-controlled input note
-------------------------------------
If the input is framework-controlled (for example React controlled input), direct assignment to `el.value` may be ignored by the framework and it may restore a previous value. To reliably set or clear such inputs you can use the native setter and dispatch events so the framework's listeners observe changes.

Recommended JS snippet (to use via `JavascriptExecutor`) that works for React-controlled inputs:

```javascript
var el = arguments[0];
var value = arguments[1];
var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;
nativeSetter.call(el, value);
// ensure React's tracker doesn't force old value
try { if (el._valueTracker) el._valueTracker.setValue(''); } catch(e) {}
// dispatch events
try { el.dispatchEvent(new InputEvent('input', { bubbles: true })); } catch(e) { el.dispatchEvent(new Event('input', { bubbles: true })); }
el.dispatchEvent(new Event('change', { bubbles: true }));
```

Troubleshooting
---------------
- If `getTextfield2024()` returns a container div instead of a real `<input>`, look for nested inputs or contenteditable elements inside the container (e.g., `container.querySelector('input, [contenteditable]')`).
- If an element is inside a shadow DOM, this page object will not locate it via standard XPaths — you'll need to walk the shadow root to access it.
- If the application validates or overwrites values after you set them, you may need to set the value then trigger the application flow that accepts the new value (for example, blur/focus, or click a confirm button).

Suggested improvements (low risk)
--------------------------------
- Add explicit `getYear2024TextField()` and `getYear2023TextField()` container getters to mirror `getYear2025TextField()` if you need to target containers for scrolling or nested input lookup.
- Extract common JS native-setter and clear logic to a reusable helper in `WebdriverUtility` so tests can call `WebdriverUtility.setInputValue(WebElement el, String value)`.

Change history / context
------------------------
- This doc was generated from `BillingSettings.java` in the repository on Apr 08, 2026.

If you want, I can:
- create a reusable helper method with the React-friendly native setter and event dispatch in `WebdriverUtility` and update the tests to use it;
- generate similar docs for other page objects (HomePage, LoginPage, etc.);
- convert this Markdown into PDF or HTML and place it in `docs/`.

---
Generated by an automated doc conversion of the source file. If you'd like different formatting or additional code examples, tell me which format you prefer (HTML / PDF / README.md in project root).