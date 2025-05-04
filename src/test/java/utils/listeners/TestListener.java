package utils.listeners;

import BaseClasses.TestBase;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.extentReports.ExtentManager;

import java.util.Objects;

import static utils.extentReports.ExtentTestManager.getTest;

public class TestListener extends TestBase implements ITestListener {
    private final Logger log = LogManager.getLogger(this);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onTestStart(ITestResult result) {
        log.info("{} test is starting...", getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("{} test has succeeded.", getTestMethodName(result));
//        String successScreenShot =
//                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
//        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("{} test has failed ", getTestMethodName(result));

        String failedScreenShot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test has failed " + testFailureLog,
                getTest().addScreenCaptureFromBase64String(failedScreenShot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("{} test is skipped", getTestMethodName(result));
        getTest().log(Status.SKIP, "Test Skipped");
    }

//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        ITestListener.super.onTestFailedWithTimeout(result);
//    }

    @Override
    public void onStart(ITestContext context) {
        log.info("{} tests are starting", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("{} tests are finishing...", context.getName());
        ExtentManager.extentReports.flush();
    }
}
