package ListnerUtility;


import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
				TakesScreenshot ts = (TakesScreenshot) utilityclassobject.getDriver();
				String srcFile = ts.getScreenshotAs(OutputType.BASE64);
				String time = new Date().toString().replace(" ", "_").replace(":", "_");
				if (test != null) test.addScreenCaptureFromBase64String(srcFile,testname+" "+time); 	 
				if (test != null) test.log(Status.FAIL, result.getMethod().getMethodName() + "==Failed==");
			} catch (Throwable t) {
				System.err.println("ERROR in ListnerUilityImp.onTestFailure: " + t.getMessage());
				t.printStackTrace();
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			try {
				if (test != null) test.log(Status.FAIL, result.getMethod().getMethodName() + "==Failed==");
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