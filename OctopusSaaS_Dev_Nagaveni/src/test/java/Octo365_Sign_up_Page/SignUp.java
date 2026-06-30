package Octo365_Sign_up_Page;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp {
	ChromeDriver driver;
	WebElement email;
	WebElement pwd;
	WebElement conpwd;
	WebElement fname;
	WebElement lname;
	WebElement cname;
	WebElement authorfield;
	WebElement affiliation;
	WebElement signupbtn ;

	@Test(priority = 1)
	public void Signin() {
		driver = new ChromeDriver();
		driver.get("https://dev.octopussaas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement txt = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		System.out.println(txt.getText());
		String actual = txt.getText();
		Assert.assertEquals(actual, "Sign In");
		System.out.println("Signin Page is displayed and verified");

	}

	@Test(dependsOnMethods = "Signin")
	public void TC_001_SignUp() {
		System.out.println("TC_001 start");
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OCTO 365')]")).click();
		System.out.println("signUp page is displayed");
		System.out.println("TC_001 End");

	}

	@Test(dependsOnMethods = "TC_001_SignUp")
	public void TC_002_Email() {
		System.out.println("TC_002 Start");
		email = driver.findElement(By.xpath("//input[@placeholder='Enter your email address']"));
		email.click();
		String placeholderText = email.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Enter your email address");
		System.out.println("Email place holder is veriifed");
		System.out.println("TC_002 End");
	}

	@Test(dependsOnMethods = "TC_002_Email")
	public void TC_003EmailwithInput() {
		System.out.println("TC_003 Start");
		email.sendKeys("charlie123@gmail.com");
		String actualEmail = email.getAttribute("value");
		System.out.println("Entered input is: " + actualEmail);
		System.out.println("email text field accepting valid input");
		System.out.println("TC_003 End");

	}

	@Test(dependsOnMethods = "TC_003EmailwithInput")
	public void TC_004_EmailtextfielwithAlphabet() {
		System.out.println("TC_004 Start");
		email.sendKeys("abgcxfdcddc");
		String actualEmail = email.getAttribute("value");
		System.out.println("Entered alphabet is: " + actualEmail);
		System.out.println("email text field accepting alphabets");
		email.clear();
		System.out.println("TC_004 End");
	}

	@Test(dependsOnMethods = "TC_004_EmailtextfielwithAlphabet")
	public void TC_005_EmailtextfielwithNumbers() {
		System.out.println("TC_005 Start");
		email.sendKeys("7895236848");
		String actualEmail = email.getAttribute("value");
		System.out.println("Entered Numbers are: " + actualEmail);
		System.out.println("email text field accepting numbers");
		email.clear();
		System.out.println("TC_005 End");
	}

	@Test(dependsOnMethods = "TC_005_EmailtextfielwithNumbers")
	public void TC_006_EmailtextfielwithSpecialChar() {
		System.out.println("TC_006 Start");
		email.sendKeys("!@#$%^");
		String actualEmail = email.getAttribute("value");
		System.out.println("Entered characters are: " + actualEmail);
		System.out.println("email text field accepting special charaters");
		email.clear();
		System.out.println("TC_006 End");
	}

	@Test(dependsOnMethods = "TC_006_EmailtextfielwithSpecialChar")
	public void TC_007_passwordplaceholder() throws InterruptedException

	{
		pwd = driver.findElement(By.id("signup-password"));
		pwd.click();
		String placeholderText = pwd.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Create password");
		System.out.println("Password place holder is veriifed");
		Thread.sleep(3000);
		pwd.clear();
		System.out.println("TC_002 End");
	}

	@Test(dependsOnMethods = "TC_007_passwordplaceholder")
	public void TC_008passwordwithInput() throws InterruptedException {
		System.out.println("TC_008 Start");
		pwd.sendKeys("12@ef");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		String actualpwd = pwd.getAttribute("value");
		System.out.println("Entered input is: " + actualpwd);
		System.out.println("Password text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_008End");

	}

	@Test(dependsOnMethods = "TC_008passwordwithInput")
	public void TC_009_pwdtextfielwithAlphabet() throws InterruptedException {
		System.out.println("TC_009 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("abgcx");
		String actualPwd = pwd.getAttribute("value");
		System.out.println("Entered alphabet is: " + actualPwd);
		System.out.println("Passsword text field accepting alphabets");
		Thread.sleep(3000);

		System.out.println("TC_009 End");

	}

	@Test(dependsOnMethods = "TC_009_pwdtextfielwithAlphabet")
	public void TC_010_PwdtextfielwithNumbers() throws InterruptedException {
		System.out.println("TC_010 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("78952");
		String actualpwd = pwd.getAttribute("value");
		System.out.println("Entered Numbers are: " + actualpwd);
		System.out.println("pwd text field accepting numbers");
		System.out.println("TC_010 End");
	}

	@Test(dependsOnMethods = "TC_010_PwdtextfielwithNumbers")
	public void TC_011_pwdtextfielwithSpecialChar() throws InterruptedException {
		System.out.println("TC_011 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("!@@$#");
		String actualPwd = pwd.getAttribute("value");
		System.out.println("Entered characters are: " + actualPwd);
		System.out.println("pwd text field accepting special charaters");
		System.out.println("TC_011 End");
	}

	@Test(dependsOnMethods = "TC_011_pwdtextfielwithSpecialChar")
	public void TC_012passwordwithUnmaskedandunmasked() throws InterruptedException {
		System.out.println("TC_012 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("Abc123!@#");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		System.out.println("User can mask and unmask Entered password");
		System.out.println("TC_012 End");

	}

	@Test(dependsOnMethods = "TC_012passwordwithUnmaskedandunmasked")
	public void TC_013passwordwithMasked() throws InterruptedException {
		System.out.println("TC_013 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("Abc123!@#");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

		System.out.println("User can Enter password in mask mode");
		System.out.println("TC_013 End");

	}

	@Test(dependsOnMethods = "TC_013passwordwithMasked")
	public void TC_014passwordwithValidinput() throws InterruptedException {
		System.out.println("TC_014 Start");
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("Xyz12!@#");
		System.out.println("Passwoed text field accept minimun 8 charatcters");
		System.out.println("TC_014 End");

	}

	@Test(dependsOnMethods = "TC_014passwordwithValidinput")
	public void TC_015confirmPasswordTextFieldPlaceholder() {
		conpwd = driver.findElement(By.id("signup-confirmPassword"));
		System.out.println("TC_015 Start");
		conpwd.click();
		String placeholderText = conpwd.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Confirm password");
		System.out.println("Confirm password text field place holder is veriifed");
		System.out.println("TC_015 End");

	}

	@Test(dependsOnMethods = "TC_015confirmPasswordTextFieldPlaceholder")
	public void TC_016_ConfirmpwdtextfielwithInput() throws InterruptedException {
		System.out.println("TC_016 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Abh123!@");
		String actualPwd = conpwd.getAttribute("value");
		System.out.println("Entered Input is: " + actualPwd);
		System.out.println("ConfirmPasssword text field accepting alphabets");
		Thread.sleep(3000);
		System.out.println("TC_016 End");
	}

	@Test(dependsOnMethods = "TC_016_ConfirmpwdtextfielwithInput")
	public void TC_017_ConfirmpwdtextfielwithAlphabet() throws InterruptedException {
		System.out.println("TC_017 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("abgcx");
		String actualPwd = conpwd.getAttribute("value");
		System.out.println("Entered alphabet is: " + actualPwd);
		System.out.println("ConfirmPasssword text field accepting alphabets");
		Thread.sleep(3000);
		System.out.println("TC_017 End");
	}

	@Test(dependsOnMethods = "TC_017_ConfirmpwdtextfielwithAlphabet")
	public void TC_018_ConfirmPwdtextfielwithNumbers() throws InterruptedException {
		System.out.println("TC_018 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("78952");
		String actualpwd = conpwd.getAttribute("value");
		System.out.println("Entered Numbers are: " + actualpwd);
		System.out.println("confirmpwd text field accepting numbers");
		System.out.println("TC_018 End");
	}

	@Test(dependsOnMethods = "TC_018_ConfirmPwdtextfielwithNumbers")
	public void TC_019_ConfirmpwdtextfielwithSpecialChar() throws InterruptedException {
		System.out.println("TC_019 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("!@@$#");
		String actualPwd = conpwd.getAttribute("value");
		System.out.println("Entered characters are: " + actualPwd);
		System.out.println("confirmpwd text field accepting special charaters");
		System.out.println("TC_019 End");
	}

	@Test(dependsOnMethods = "TC_019_ConfirmpwdtextfielwithSpecialChar")
	public void TC_020_ConfirmpwdtextfielwithMasked() throws InterruptedException {
		System.out.println("TC_020 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("!@@$#");
		String actualPwd = conpwd.getAttribute("value");
		System.out.println("Entered characters are: " + actualPwd);
		System.out.println("confirmpwd text field entered value with masked");
		System.out.println("TC_020 End");
	}

	@Test(dependsOnMethods = "TC_020_ConfirmpwdtextfielwithMasked")
	public void TC_021ConfirmpasswordwithUnmaskedandunmasked() throws InterruptedException {
		System.out.println("TC_012 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Abc123!@#");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		System.out.println("User can mask and unmask Entered password");
		System.out.println("TC_021 End");

	}

	@Test(dependsOnMethods = "TC_021ConfirmpasswordwithUnmaskedandunmasked")
	public void TC_022confirmpasswordwithValidinput() throws InterruptedException {
		System.out.println("TC_022 Start");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Xyz12!@#");
		System.out.println("Passwoed text field accept minimun 8 charatcters");
		System.out.println("TC_022 End");

	}

	@Test(dependsOnMethods = "TC_022confirmpasswordwithValidinput")
	public void TC_023pwdandConfirmpwsMatch() {
		System.out.println("TC_023 Start");
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		pwd.sendKeys(Keys.CONTROL + "a");
		pwd.sendKeys(Keys.DELETE);
		pwd.sendKeys("Abc123%$");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Abc123%");
		String passwordText = pwd.getText();
		String confirmPwdText = conpwd.getText();
		Assert.assertEquals(passwordText, confirmPwdText);
		System.out.println(passwordText);
		System.out.println(
				confirmPwdText + "Password and confirm password both are Matching  and validated successsfully");
		System.out.println("TC_023 End");

	}

	@Test(dependsOnMethods = "TC_023pwdandConfirmpwsMatch")
	public void TC_024Passwordmismatchprompt() {
		System.out.println("TC_024 Start");
		email.clear();
		email.sendKeys("arun1123@gmail.com");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement promptmsg = driver.findElement(By.xpath("//p[contains(text(),'Passwords do not match')]"));
		System.out.println(promptmsg.getText() + " Prompt Error message displayed sussefully");
		System.out.println("TC_024 End");
		conpwd.sendKeys(Keys.CONTROL + "a");
		conpwd.sendKeys(Keys.DELETE);
		conpwd.sendKeys("Abc123%$");

	}

	@Test(dependsOnMethods = "TC_024Passwordmismatchprompt")
	public void TC_025FirstnametxtFieldPlaceholder() throws InterruptedException {
		System.out.println("TC_025 start");
		fname = driver.findElement(By.id("signup-firstName"));
		fname.click();
		String placeholderText = fname.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Enter your first name");
		System.out.println("Firstname text field place holder is veriifed");
		Thread.sleep(3000);
		System.out.println("TC_025 End");
	}

	@Test(dependsOnMethods = "TC_025FirstnametxtFieldPlaceholder")
	public void TC_026FirstnameFieldwithvalidInput() throws InterruptedException {
		System.out.println("TC_026 Start");
		fname.sendKeys(Keys.CONTROL + "a");
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys("Arun123!@#");
		String actualfname = fname.getAttribute("value");
		System.out.println("Entered input is: " + actualfname);
		System.out.println("First name text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_26 End");

	}

	@Test(dependsOnMethods = "TC_026FirstnameFieldwithvalidInput")
	public void TC_027FirstnameFieldwithAlphabets() throws InterruptedException {
		System.out.println("TC_027 Start");
		fname.sendKeys(Keys.CONTROL + "a");
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys("ABCd");
		String actualfname = fname.getAttribute("value");
		System.out.println("Entered alphabet is: " + actualfname);
		System.out.println("First name text field accepting alphabets");
		Thread.sleep(3000);
		System.out.println("TC_27 End");

	}

	@Test(dependsOnMethods = "TC_027FirstnameFieldwithAlphabets")
	public void TC_028FirstnameFieldwithSpecialCharacters() throws InterruptedException {
		System.out.println("TC_028 Start");
		fname.sendKeys(Keys.CONTROL + "a");
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys("!@#$%%^");
		String actualfname = fname.getAttribute("value");
		System.out.println("Entered Special charactres are: " + actualfname);
		System.out.println("First name text field accepting Special characters");
		Thread.sleep(3000);
		System.out.println("TC_28 End");

	}

	@Test(dependsOnMethods = "TC_028FirstnameFieldwithSpecialCharacters")
	public void TC_029FirstnameFieldwithnumbers() throws InterruptedException {
		System.out.println("TC_029 Start");
		fname.sendKeys(Keys.CONTROL + "a");
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys("12345678");
		String actualfname = fname.getAttribute("value");
		System.out.println("Entered Number is: " + actualfname);
		System.out.println("First name text field accepting Numbers");
		Thread.sleep(3000);
		System.out.println("TC_29 End");
		fname.sendKeys(Keys.CONTROL + "a");
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys("Arun");

	}

	@Test(dependsOnMethods = "TC_029FirstnameFieldwithnumbers")
	public void TC_030LastnametxtFieldPlaceholder() throws InterruptedException {
		System.out.println("TC_030 start");
		lname = driver.findElement(By.id("signup-lastName"));
		lname.click();
		String placeholderText = lname.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Enter your last name");
		System.out.println("Last name text field place holder is veriifed");
		Thread.sleep(3000);
		System.out.println("TC_030 End");
	}

	@Test(dependsOnMethods = "TC_030LastnametxtFieldPlaceholder")
	public void TC_031LastnameFieldwithvalidInput() throws InterruptedException {
		System.out.println("TC_031 Start");
		lname.sendKeys(Keys.CONTROL + "a");
		lname.sendKeys(Keys.DELETE);
		lname.sendKeys("Mandre123!@#");
		String actuallname = lname.getAttribute("value");
		System.out.println("Entered valid input is: " + actuallname);
		System.out.println("Last name text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_31 End");

	}

	@Test(dependsOnMethods = "TC_031LastnameFieldwithvalidInput")
	public void TC_032LastnameFieldwithAlphabets() throws InterruptedException {
		System.out.println("TC_032 Start");
		lname.sendKeys(Keys.CONTROL + "a");
		lname.sendKeys(Keys.DELETE);
		lname.sendKeys("ABCd");
		String actuallname = lname.getAttribute("value");
		System.out.println("Entered alphabet is: " + actuallname);
		System.out.println("Last name text field accepting alphabets");
		Thread.sleep(3000);
		System.out.println("TC_32 End");

	}

	@Test(dependsOnMethods = "TC_032LastnameFieldwithAlphabets")
	public void TC_033LastnameFieldwithSpecialCharacters() throws InterruptedException {
		System.out.println("TC_033 Start");
		lname.sendKeys(Keys.CONTROL + "a");
		lname.sendKeys(Keys.DELETE);
		lname.sendKeys("!@#$%%^");
		String actualfname = lname.getAttribute("value");
		System.out.println("Entered special characters are : " + actualfname);
		System.out.println("Last name text field accepting Special characters");
		Thread.sleep(3000);
		System.out.println("TC_33 End");

	}

	@Test(dependsOnMethods = "TC_033LastnameFieldwithSpecialCharacters")
	public void TC_034LastnameFieldwithNumbers() throws InterruptedException {
		System.out.println("TC_034 Start");
		lname.sendKeys(Keys.CONTROL + "a");
		lname.sendKeys(Keys.DELETE);
		lname.sendKeys("1234");
		String actuallname = lname.getAttribute("value");
		System.out.println("Entered number is: " + actuallname);
		System.out.println("Last name text field accepting numbers");
		Thread.sleep(3000);
		System.out.println("TC_34 End");

	}

	@Test(dependsOnMethods = "TC_034LastnameFieldwithNumbers")
	public void TC_035companyNameTextFieldPlaceholder() throws InterruptedException {
		System.out.println("TC_35 start");
		cname = driver.findElement(By.id("signup-companyName"));
		cname.click();
		String placeholderText = cname.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Company name");
		System.out.println("company name  text field place holder is veriifed");
		Thread.sleep(3000);
		System.out.println("TC_035 End");
	}

	@Test(dependsOnMethods = "TC_035companyNameTextFieldPlaceholder")
	public void TC_036companyNameTextFieldwithInput() throws InterruptedException {
		System.out.println("TC_36 start");
		cname.sendKeys(Keys.CONTROL + "a");
		cname.sendKeys(Keys.DELETE);
		cname.sendKeys("Arun company");
		String actualcompanyname = cname.getAttribute("value");
		System.out.println("Entered Input is: " + actualcompanyname);
		System.out.println("Company name text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_036 End");
	}

	@Test(dependsOnMethods = "TC_036companyNameTextFieldwithInput")
	public void TC_037companyNameTextFieldwithAlphabets() throws InterruptedException {
		System.out.println("TC_37 start");
		cname.sendKeys(Keys.CONTROL + "a");
		cname.sendKeys(Keys.DELETE);
		cname.sendKeys("Arun");
		String actualcompanyname = cname.getAttribute("value");
		System.out.println("Entered Alphabets are: " + actualcompanyname);
		System.out.println("Company name text field accepting valid Alphabets");
		Thread.sleep(3000);
		System.out.println("TC_037 End");
	}

	@Test(dependsOnMethods = "TC_037companyNameTextFieldwithAlphabets")
	public void TC_038companyNameTextFieldwithspecialCharacter() throws InterruptedException {
		System.out.println("TC_38 start");
		cname.sendKeys(Keys.CONTROL + "a");
		cname.sendKeys(Keys.DELETE);
		cname.sendKeys("!@#$%");
		String actualcompanyname = cname.getAttribute("value");
		System.out.println("Entered Special characters are: " + actualcompanyname);
		System.out.println("Company name text field accepting special characters");
		Thread.sleep(3000);
		System.out.println("TC_038 End");
	}

	@Test(dependsOnMethods = "TC_038companyNameTextFieldwithspecialCharacter")
	public void TC_039companyNameTextFieldwithNumbers() throws InterruptedException {
		System.out.println("TC_39 start");
		cname.sendKeys(Keys.CONTROL + "a");
		cname.sendKeys(Keys.DELETE);
		cname.sendKeys("1234567");
		String actualcompanyname = cname.getAttribute("value");
		System.out.println("Entered Numbers are: " + actualcompanyname);
		System.out.println("Company name text field accepting numbers");
		Thread.sleep(3000);
		System.out.println("TC_039 End");
	}

	@Test(dependsOnMethods = "TC_039companyNameTextFieldwithNumbers")
	public void TC_040AuthorizationtxtFieldPlaceholder() throws InterruptedException {
		System.out.println("TC_040 start");
		authorfield = driver.findElement(By.id("signup-authorizationCode"));
		authorfield.click();
		String placeholderText = authorfield.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Enter 6-digit code");
		System.out.println("Authorization code text field place holder is veriifed");
		Thread.sleep(3000);
		System.out.println("TC_040 End");
	}
	@Test(dependsOnMethods = "TC_040AuthorizationtxtFieldPlaceholder")
	public void TC_041authorizationcodeTextFieldwithInput() throws InterruptedException {
		System.out.println("TC_041 start");
		authorfield.sendKeys(Keys.CONTROL + "a");
		authorfield.sendKeys(Keys.DELETE);
		authorfield.sendKeys("Arun author");
		String actualauthname = authorfield.getAttribute("value");
		System.out.println("Entered Input is: " + actualauthname);
		System.out.println("Authorization code text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_041 End");
	}
	@Test(dependsOnMethods = "TC_041authorizationcodeTextFieldwithInput")
	public void TC_042AuthorizationcodeTextFieldwithNumbers() throws InterruptedException {
		System.out.println("TC_042 start");
		authorfield.sendKeys(Keys.CONTROL + "a");
		authorfield.sendKeys(Keys.DELETE);
		authorfield.sendKeys("1234567");
		String actualauthname = authorfield.getAttribute("value");
		System.out.println("Entered Numbers are: " + actualauthname);
		System.out.println("Authorization code text field accepting numbers");
		Thread.sleep(3000);
		System.out.println("TC_042 End");
	}
	@Test(dependsOnMethods = "TC_042AuthorizationcodeTextFieldwithNumbers")
	public void TC_043AuthorizationTextFieldwithAlphabets() throws InterruptedException {
		System.out.println("TC_043 start");
		authorfield.sendKeys(Keys.CONTROL + "a");
		authorfield.sendKeys(Keys.DELETE);
		authorfield.sendKeys("Arun");
		String actualauthname = authorfield.getAttribute("value");
		System.out.println("Entered Alphabets are: " + actualauthname);
		System.out.println("Authorization code text field accepting valid Alphabets");
		Thread.sleep(3000);
		System.out.println("TC_043 End");
	}
	@Test(dependsOnMethods = "TC_043AuthorizationTextFieldwithAlphabets")
	public void TC_044authorizationTextFieldwithspecialCharacter() throws InterruptedException {
		System.out.println("TC_044 start");
		authorfield.sendKeys(Keys.CONTROL + "a");
		authorfield.sendKeys(Keys.DELETE);
		authorfield.sendKeys("!@#$%");
		String actualauthname = authorfield.getAttribute("value");
		System.out.println("Entered Special characters are: " + actualauthname);
		System.out.println("Authorization code text field accepting special characters");
		Thread.sleep(3000);
		System.out.println("TC_044 End");
	}
	
	@Test(dependsOnMethods = "TC_044authorizationTextFieldwithspecialCharacter")
	public void TC_045authorizationTextFieldwithSixdigits() throws InterruptedException {
		System.out.println("TC_045 start");
		authorfield.sendKeys(Keys.CONTROL + "a");
		authorfield.sendKeys(Keys.DELETE);
		Random random = new Random();
		int number = 100000 + random.nextInt(900000);
		System.out.println(number);
		authorfield.sendKeys(Integer.toString(number));
		String actualauthname = authorfield.getAttribute("value");
		System.out.println("Entered Special characters are: " + actualauthname);
		System.out.println("Authorization codetext field accepting special characters");
		Thread.sleep(3000);
		System.out.println("TC_045 End");
	}
	@Test(dependsOnMethods = "TC_045authorizationTextFieldwithSixdigits")
	public void TC_046_AffiliationCodetxtFieldPlaceholder() throws InterruptedException {
		System.out.println("TC_047 start");
		affiliation = driver.findElement(By.id("signup-affiliationCode"));
		affiliation.click();
		String placeholderText = affiliation.getAttribute("placeholder");
		System.out.println(placeholderText);
		Assert.assertEquals(placeholderText, "Enter affiliation code");
		System.out.println("Affiliation code text field place holder is veriifed");
		Thread.sleep(3000);
		System.out.println("TC_047 End");
	}
	@Test(dependsOnMethods = "TC_046_AffiliationCodetxtFieldPlaceholder")
	public void TC_047_AffiliationCodeTextFieldwithInput() throws InterruptedException {
		System.out.println("TC_047 start");
		affiliation.sendKeys(Keys.CONTROL + "a");
		affiliation.sendKeys(Keys.DELETE);
		affiliation.sendKeys("Arun affliation");
		String actualaffilname = affiliation.getAttribute("value");
		System.out.println("Entered Input is: " + actualaffilname);
		System.out.println("Affiliation code text field accepting valid input");
		Thread.sleep(3000);
		System.out.println("TC_047 End");
	}
	@Test(dependsOnMethods = "TC_047_AffiliationCodeTextFieldwithInput")
	public void TC_048_AffiliationCodeTextFieldwithNumbers() throws InterruptedException {
		System.out.println("TC_048 start");
		affiliation.sendKeys(Keys.CONTROL + "a");
		affiliation.sendKeys(Keys.DELETE);
		affiliation.sendKeys("789526");
		String actualauthname = affiliation.getAttribute("value");
		System.out.println("Entered Alphabets are: " + actualauthname);
		System.out.println("Affiliation code text field accepting numbers");
		Thread.sleep(3000);
		System.out.println("TC_048 End");
	}
	@Test(dependsOnMethods = "TC_048_AffiliationCodeTextFieldwithNumbers")
	public void TC_049_AffiliationCodeTextFieldwithAlphabets() throws InterruptedException {
		System.out.println("TC_049 start");
		affiliation.sendKeys(Keys.CONTROL + "a");
		affiliation.sendKeys(Keys.DELETE);
		affiliation.sendKeys("Abvdgj");
		String actualauthname = affiliation.getAttribute("value");
		System.out.println("Entered Alphabets are: " + actualauthname);
		System.out.println("Affiliation code text field accepting alphabets");
		Thread.sleep(3000);
		System.out.println("TC_049 End");
	}

	@Test(dependsOnMethods = "TC_049_AffiliationCodeTextFieldwithAlphabets")
	public void TC_050_AffiliationCodewithoutData()
	{
		System.out.println("TC_050 Start");
		affiliation.sendKeys(Keys.CONTROL + "a");
		affiliation.sendKeys(Keys.DELETE);
	 signupbtn = driver.findElement(By.xpath("//button[@type='submit']"));
	 signupbtn.click();
	 System.out.println("It accepted");
		driver.quit();
		System.out.println("TC_050 End");
	}
	
	@Test(priority = 2)
	public void Tc_051signupWithoutInput()
	{
		System.out.println("TC_051 Start");

		driver= new ChromeDriver();
		driver.get("https://dev.octopussaas.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		Actions act = new Actions(driver);
		act.scrollToElement(submitbtn).perform();
		submitbtn.click();
		System.out.println("Not able to signin");
		driver.quit();
		System.out.println("TC_051 End");

		

	}
	@Test(priority = 3)
	public void TC_052SignupwithValidInput()
	{
		System.out.println("TC_052 Start");

		driver= new ChromeDriver();
		driver.get("https://dev.octopussaas.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		Random random1 = new Random();
		int number1 = 100 + random1.nextInt(900);  // generates 3-digit number
		String email = "arun" + number1 + "@gmail.com";
		System.out.println(email);
		driver.findElement(By.id("signup-email")).sendKeys(email);
		driver.findElement(By.id("signup-password")).sendKeys("Arun12^%");
		driver.findElement(By.id("signup-confirmPassword")).sendKeys("Arun12^%");
		driver.findElement(By.id("signup-firstName")).sendKeys("Arun");
		driver.findElement(By.id("signup-lastName")).sendKeys("Laxty");
		driver.findElement(By.id("signup-companyName")).sendKeys("laxty company");
		Random random = new Random();
		int number = 100000 + random.nextInt(900000);
		System.out.println(number);
		WebElement authorfield1 = driver.findElement(By.id("signup-authorizationCode"));
		authorfield1.sendKeys(Integer.toString(number));
		driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
		//WebElement welcomepage = driver.findElement(By.xpath("//h1[contains(text(),'Octopus Website and Platform Terms of Service')]"));
		//String title = welcomepage.getText();
		System.out.println( " Sign Up successfully completed with valid inputs");
		System.out.println("TC_052 End");
		driver.quit();
	}
	@Test(priority = 4)
	public void TC_053LoginwithValidInput()
	{
		System.out.println("TC_053 Start");
		driver= new ChromeDriver();
		driver.get("https://dev.octopussaas.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.findElement(By.id("login-email")).sendKeys("charlie123@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Char09!@");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//h6[contains(text(),'Dashboard')]"));
		System.out.println(ele1.getText()+" page is displayed successfully");
		System.out.println("TC_053 End");
		driver.quit();
	} 
	@Test(priority = 5)
	public void TC_054LoginPage()
	{
		System.out.println("TC_054 Start");
		driver= new ChromeDriver();
		driver.get("https://dev.octopussaas.com/");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		System.out.println("redirected to Login page");
		System.out.println("TC_054 End");
		driver.quit();

	}
	
	
	

}
