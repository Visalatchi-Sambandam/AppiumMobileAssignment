package assignment.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import assignment.utils.CommonUtilsOfAppium;
import io.appium.java_client.AppiumDriver;

public class TestListener extends BaseClassAppium implements ITestListener {
	// Called when a test starts
	public void onTestStart(ITestResult result) {
		System.out.println("🚀 Starting Test: " + result.getName());
	}

	// Called when a test passes
	public void onTestSuccess(ITestResult result) {
		System.out.println("✅ Test Passed: " + result.getName());
	}

	// Called when a test fails
	public void onTestFailure(ITestResult result) {
		System.out.println("❌ Test Failed: " + result.getName());
		if (ITestResult.FAILURE == result.getStatus()) {
			Object testClass = result.getInstance();
			AppiumDriver driver = ((BaseClassAppium) testClass).driver;
			CommonUtilsOfAppium.takeScreenshot(driver, result.getName() + "_FAIL");
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
	}

}
