package Pages;

import BaseClasses.PageBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends PageBase {
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Username input field")
    private WebElement usernameField;

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Login button")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']/*[1]")
    private WebElement pageHeading;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Username is required\")")
    private WebElement usernameErrorMsg;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password is required\")")
    private WebElement passwordErrorMsg;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/*[1]")
    private WebElement invalidCredentialsError;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"alice@example.com (locked out)-autofill\")")
    private WebElement lockedOutAccount;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sorry, this user has been locked out.\")")
    private WebElement lockOutErrorMsg;

    @AndroidFindBy(accessibility = "Next")
    private List<WebElement> nextBtn;
    @AndroidFindBy(className = "android.widget.ImageView")
    private WebElement pagebody;

    //Methods

    public void clickNextBtn() {
        click(nextBtn.get(0));
    }
    public List<WebElement> getNextBtn() {
        return nextBtn;
    }

    public WebElement getPagebody() {
        return pagebody;
    }

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void clearUsernameField() {
        clearField(usernameField);
    }
    public void clearPasswordField() {
        clearField(passwordField);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public WebElement getPageHeading() {
        return pageHeading;
    }

    public WebElement getUsernameErrorMsg() {
        return usernameErrorMsg;
    }
    public WebElement getPasswordErrorMsg() {
        return passwordErrorMsg;
    }

    public WebElement getInvalidCredentialsError() {
        return invalidCredentialsError;
    }

    public void clickLockedOutAccount() {
        click(lockedOutAccount);
    }

    public WebElement getLockOutErrorMsg() {
        return lockOutErrorMsg;
    }
}
