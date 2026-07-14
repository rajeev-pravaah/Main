package ListnerUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("[SimpleListener] Suite start: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("[SimpleListener] Suite finish: " + suite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[SimpleListener] Test start: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[SimpleListener] Test success: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[SimpleListener] Test failure: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SimpleListener] Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // no-op
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("[SimpleListener] Test context start: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[SimpleListener] Test context finish: " + context.getName());
    }
}
