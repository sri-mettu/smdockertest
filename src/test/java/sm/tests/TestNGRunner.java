package sm.tests;

import org.testng.TestNG;

import com.aventstack.extentreports.ExtentReports;

public class TestNGRunner {

	static TestNG testNg;

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//ExtentReports extent = new ExtentReports();
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {EscortManagementTest.class, StandAloneTest.class });
		//testNg.addListener(extent);
		testNg.run();
	}

}
