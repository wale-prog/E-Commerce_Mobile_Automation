package utils;

import BaseClasses.TestBase;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DeviceCaps extends TestBase {

    public static void samsungA32() {
        caps = new DesiredCapabilities();
        caps.setCapability("udid", testData.getProperty("samsungA32Udid"));
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "samsung SM-A325F");
        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        caps.setCapability("noReset", false);
    }
    public static void Emulator() {
        caps = new DesiredCapabilities();
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "13.0");
//        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/Resources/Android-MyDemoAppRN.1.3.0.build-244.apk");
        caps.setCapability("appPackage", "com.msquare.market.app.dev");
        caps.setCapability("appActivity", "com.msquare.market.app.MainActivity");
        caps.setCapability("noReset", false);
        caps.setCapability("autoGrantPermissions", true);
    }
    public static void Camon18() {
        caps = new DesiredCapabilities();
        caps.setCapability("udid", testData.getProperty("camon18Udid"));
        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("platformVersion", "13.0");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/java/Resources/Android-MyDemoAppRN.1.3.0.build-244.apk");
//        caps.setCapability("appPackage", "com.msquare.market.app.dev");
//        caps.setCapability("appActivity", "com.msquare.market.app.MainActivity");
        caps.setCapability("noReset", false);
        caps.setCapability("autoGrantPermissions", true);
    }
}
