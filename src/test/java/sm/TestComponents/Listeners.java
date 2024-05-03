package sm.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import sm.resources.ExtentReporterNG;

public class Listeners extends baseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);		//unique thread id(ErrorValidationTest)->test

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Invoked each time a test succeeds
		extentTest.get().log(Status.PASS, "Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String filePath = null;
		try {

			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {

			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		// Screenshot, Attach to report
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Invoked each time a test is skipped.
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Invoked each time a method fails but has been annotated with
		// successPercentage and this failure
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
		// Invoked each time a test fails due to a timeout.
	}

	@Override
	public void onStart(ITestContext context) {
		// Invoked before running all the test methods belonging to the classes inside
		// the &lt;test&gt; tag
		// and calling all their Configuration methods
	}

	@Override
	public void onFinish(ITestContext context) {
		// Invoked after all the test methods belonging to the classes inside the
		// &lt;test&gt; tag have run
		// and all their Configuration methods have been called.
		extent.flush();
	}

}
