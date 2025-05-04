package Pages;

import BaseClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DashboardPage extends PageBase {
    public DashboardPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "open menu")
    private WebElement hamburgerMenu;

    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement loginLink;

    @AndroidFindBy(accessibility = "container header")
    private WebElement pageHeader;

    // Methods
    public void clickHamburgerMenu() {
        click(hamburgerMenu);
    }
    public void clickLoginLink() {
        click(loginLink);
    }

    public WebElement getPageHeader() {
        return pageHeader;
    }
}
