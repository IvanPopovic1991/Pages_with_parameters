package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecution implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Started test " + result.getTestClass().getName() + " -> " + result.getMethod().getMethodName());
        System.out.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test " + result.getTestClass().getName() + " -> " + result.getMethod().getMethodName() +" PASSED");
        System.out.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test " + result.getTestClass().getName() + " -> " + result.getMethod().getMethodName() +" FAILED");
        System.out.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test " + result.getTestClass().getName() + " -> " + result.getMethod().getMethodName() +" SKIPPED");
        System.out.flush();
    }
}
