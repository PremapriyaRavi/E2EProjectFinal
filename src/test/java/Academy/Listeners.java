package Academy;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;
import resources.ExtentReportNG;

public class Listeners extends BaseClass implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	//parallel exe to avoid overriding
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {	
		extentTest.get().log(Status.PASS,"TestPassed");
	}
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodName = result.getMethod().getMethodName();
		System.out.println(testmethodName);
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {

		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodName,driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
