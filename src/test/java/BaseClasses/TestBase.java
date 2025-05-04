package BaseClasses;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DeviceCaps;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static AndroidDriver driver;
    public static DesiredCapabilities caps;
    public static String filePath_testDataProp = "src/test/java/testData.properties";
    public static Properties testData;
    FileInputStream fis;
    Logger log = LogManager.getLogger(this);
    public static String testFailureLog;

    public TestBase() {
        loadPropFile();    }

    public void loadPropFile() {
        testData = new Properties();
        try {
            fis = new FileInputStream("src/test/java/testData.properties");
            testData.load(fis);
        } catch (IOException e) {
            log.error("The location of the test data property file is not valid");
        }
    }

    @BeforeClass
    public void setup() {
//        startServer();
        String device = testData.getProperty("device1");
        switch (device) {
            case("SamsungA32"):
                log.info("The test is running on Samsung A32");
                DeviceCaps.samsungA32();
                break;
            case("Emulator"):
                log.info("The test is running on the emulator");
                DeviceCaps.Emulator();
                break;
            case("Camon18"):
                log.info("The test is running on the Camon 18");
                DeviceCaps.Camon18();
                break;
            default:
                throw new IllegalArgumentException("The phone selected is not configured");
        }
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
        } catch (MalformedURLException e) {
            log.error("The remote URL is not correct, please check");
        }
    }

    public void sleep(int seconds) {
        try{
            Thread.sleep(seconds * 1000L);
        }catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void validateText(WebElement el, String message) {
        try {
            Assert.assertEquals(el.getText(), message, "Expected " + message + " but found " + el.getText());
        }catch (AssertionError e) {
            testFailureLog = "with the following reasons: Expected " + message + " but found " + el.getText();
            log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
    public void swipeGesture() {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "left",
                "percent", 1.0,
                "speed", 7500
        ));
    }

    public WebDriverWait waitForElement(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    @AfterClass
    public void tearDown() {
        if(null != driver) {
            driver.quit();
        }
    }
}
