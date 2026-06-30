package ListnerUtility;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.Octopussaass.WebdriverUtility.utilityclassobject;

public class ListnerUilityImp implements ITestListener, ISuiteListener {
	 ExtentSparkReporter spark;
		public ExtentReports report;
		public static ExtentTest test;

		// explicit public no-arg constructor
		public ListnerUilityImp() {
			// no-op
		}

		@Override
		public void onStart(ISuite suite) {
			// make listener resilient to runtime errors so TestNG doesn't fail to start
			try {
				System.out.println("report configuration");
				// spark report config
				String time = new Date().toString().replace(" ", "_").replace(":", "_");

				spark = new ExtentSparkReporter("./Advance report/report" + time + ".html");
				spark.config().setDocumentTitle("Octopussaas Test case Results");
				spark.config().setReportName("Octopus saas reporter");
				spark.config().setTheme(Theme.DARK);
				// add environment information and create
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os", "windows - 10");
				report.setSystemInfo("Browser", "chrome-10");
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onStart(ISuite): " + t.getMessage());
				t.printStackTrace();
			}
		}

		@Override
		public void onFinish(ISuite suite) {
			// TODO Auto-generated method stub
			try {
				System.out.println("Report finish");
				if (report != null) report.flush();
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onFinish(ISuite): " + t.getMessage());
				t.printStackTrace();
			}

		}

		@Override
		public void onTestStart(ITestResult result) {
			try {
				System.out.println("----" + result.getMethod().getMethodName() + "--start--");
				if (report == null) {
					// initialize a minimal report to avoid NPE
					report = new ExtentReports();
				}
				test = report.createTest(result.getMethod().getMethodName());
				utilityclassobject.setTest(test);
				
				test.log(Status.INFO, result.getMethod().getMethodName()+"==started==");
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onTestStart: " + t.getMessage());
				t.printStackTrace();
			}

		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			try {
				System.out.println("----" + result.getMethod().getMethodName() + "--end--");
				if (test != null) test.log(Status.PASS, result.getMethod().getMethodName() + "===completed==");
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onTestSuccess: " + t.getMessage());
				t.printStackTrace();
			}
		}

		@Override
		public void onTestFailure(ITestResult result) {
			try {
				String testname = result.getMethod().getMethodName();
				String time = new Date().toString().replace(" ", "_").replace(":", "_");

				// Get the active ExtentTest - prefer ThreadLocal, fall back to static field
				ExtentTest currentTest = utilityclassobject.gettest() != null ? utilityclassobject.gettest() : test;

				// Get driver - check for null before casting
				WebDriver failedDriver = utilityclassobject.getDriver();
				if (failedDriver == null) {
					System.err.println("[SCREENSHOT] Driver is null - cannot take screenshot for: " + testname);
					if (currentTest != null) {
						currentTest.log(Status.FAIL, result.getMethod().getMethodName() + " ==Failed== (No screenshot - driver was null)");
						// Log the actual failure cause if available
						if (result.getThrowable() != null) {
							currentTest.log(Status.FAIL, "Failure reason: " + result.getThrowable().getMessage());
						}
					}
					return;
				}

				// Take screenshot and save as physical file
				TakesScreenshot ts = (TakesScreenshot) failedDriver;
				String screenshotDir = "./Screenshots/";
				File dir = new File(screenshotDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String screenshotPath = screenshotDir + testname + "_" + time + ".png";
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				File destFile = new File(screenshotPath);
				Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("[SCREENSHOT] Saved to: " + destFile.getAbsolutePath());

				// Also embed in Extent Report via Base64
				String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
				if (currentTest != null) {
					currentTest.addScreenCaptureFromBase64String(base64Screenshot, testname + " " + time);
					currentTest.log(Status.FAIL, result.getMethod().getMethodName() + " ==Failed==");
					if (result.getThrowable() != null) {
						currentTest.log(Status.FAIL, "Failure reason: " + result.getThrowable().getMessage());
					}
				}
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onTestFailure: " + t.getMessage());
				t.printStackTrace();
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			try {
				String testname = result.getMethod().getMethodName();
				String time = new Date().toString().replace(" ", "_").replace(":", "_");
				System.out.println("[SCREENSHOT] Test skipped (dependency failed): " + testname);

				ExtentTest currentTest = utilityclassobject.gettest() != null ? utilityclassobject.gettest() : test;

				// Attempt screenshot even on skipped tests (dependency failures)
				WebDriver skippedDriver = utilityclassobject.getDriver();
				if (skippedDriver != null) {
					try {
						TakesScreenshot ts = (TakesScreenshot) skippedDriver;
						String screenshotDir = "./Screenshots/";
						File dir = new File(screenshotDir);
						if (!dir.exists()) {
							dir.mkdirs();
						}
						String screenshotPath = screenshotDir + testname + "_SKIPPED_" + time + ".png";
						File srcFile = ts.getScreenshotAs(OutputType.FILE);
						File destFile = new File(screenshotPath);
						Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
						System.out.println("[SCREENSHOT] Skipped test screenshot saved to: " + destFile.getAbsolutePath());

						String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);
						if (currentTest != null) {
							currentTest.addScreenCaptureFromBase64String(base64Screenshot, testname + " SKIPPED " + time);
						}
					} catch (Throwable screenshotEx) {
						System.err.println("[SCREENSHOT] Could not take screenshot for skipped test: " + screenshotEx.getMessage());
					}
				}

				if (currentTest != null) {
					currentTest.log(Status.SKIP, result.getMethod().getMethodName() + " ==Skipped (dependency failed)==");
				}
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onTestSkipped: " + t.getMessage());
				t.printStackTrace();
			}
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onStart(context);
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			ITestListener.super.onFinish(context);
		}
}