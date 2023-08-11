package FullProject.TestClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class AutoScreenShot {
    public static String getScreenshot(WebDriver driver, String methodName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotDirectory = System.getProperty("user.dir") + "/Reports/";
        String screenshotName = screenshotDirectory + methodName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(screenshotName);
        FileUtils.copyFile(source, destination);
        return screenshotName;
    }

    public static void addScreenshotToReport(ExtentTest test, String screenshotPath) throws IOException {
        test.addScreenCaptureFromPath(screenshotPath);
    }

	


	}

