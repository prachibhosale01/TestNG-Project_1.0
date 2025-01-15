/*package utils;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentManager.createInstance("target/ExtentReport.html");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test instance for the current test
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());

        // Attach screenshot to the ExtentReport
        ExtentManager.getTest().log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
        ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);  
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports instance
        ExtentManager.getInstance().flush();
    }
    
    private String captureScreenshot(WebDriver driver, String testName) {
        // Cast WebDriver to TakesScreenshot to capture screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);  // Capture screenshot as a file

        // Define the destination path for the screenshot
        String destinationPath = "target/screenshots/" + testName + ".png";
        File destination = new File(destinationPath);

        try {
            // Save the screenshot to the specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationPath;  // Return the screenshot file path
    }
}*/
