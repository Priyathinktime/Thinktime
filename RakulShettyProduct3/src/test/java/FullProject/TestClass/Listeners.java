package FullProject.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FullProject.properties.ExtentReporterNG;
 



public class Listeners extends BaseTest implements ITestListener {
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private ExtentReports extent = ExtentReporterNG.getReports();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extent.createTest(result.getMethod().getMethodName()));

        WebDriver driver = (WebDriver) result.getAttribute("driver");
        result.setAttribute("extentTest", extentTest.get()); // Pass the extent test instance to the test
        result.setAttribute("driver", driver); // Pass the driver instance to the test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        // Retrieve the shared driver instance
        WebDriver driver = (WebDriver) result.getAttribute("driver");

        String screenshotPath = null;
        try {
            screenshotPath = AutoScreenShot.getScreenshot(driver, result.getMethod().getMethodName());
            AutoScreenShot.addScreenshotToReport(extentTest.get(), screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Test Suite finished: " + context.getName());
    }
}
