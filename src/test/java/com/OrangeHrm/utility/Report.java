package com.OrangeHrm.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.OrangeHrm.tests.BaseTest;

import io.qameta.allure.Attachment;

public class Report implements ITestListener{
	// Text attachments for Allure
	BaseTest bt= new BaseTest();
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        saveScreenshotPNG();
        saveTextLog(Result.getMethod().getConstructorOrMethod().getName() + "Screenshot Saved.");
    }
}
