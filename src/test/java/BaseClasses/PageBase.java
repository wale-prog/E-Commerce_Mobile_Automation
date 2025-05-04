package BaseClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    private final AndroidDriver driver;
    public PageBase(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void waitForVisibility(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void click(WebElement el) {
        waitForVisibility(el);
        el.click();
    }

    public void enterText(WebElement el, String text) {
        waitForVisibility(el);
        el.sendKeys(text);
    }
    public void clearField(WebElement el) {
        waitForVisibility(el);
        el.clear();
    }
}
