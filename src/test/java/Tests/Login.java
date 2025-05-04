package Tests;

import BaseClasses.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class Login extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    public void initializer() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 1, description = "Validate the user is able to launch the test app")
    public void verify_user_can_launch_test_app(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");
        initializer();

        Assert.assertEquals(driver.currentActivity(), ".MainActivity");
    }
    @Test(priority = 2, description = "Validate user is able to navigate to the login page")
    public void verify_user_can_navigate_to_login_page(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        dashboardPage.clickHamburgerMenu();
        dashboardPage.clickLoginLink();
        validateText(loginPage.getPageHeading(), "Login");
    }
    @Test(priority = 3, description = "Verify that the user cannot login to the application with blank credentials")
    public void verify_user_cannot_login_with_blank_credentials(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clickLoginBtn();
        validateText(loginPage.getUsernameErrorMsg(), "Username is required");
    }
    @Test(priority = 4, description = "Verify that user cannot login with blank username field")
    public void verify_user_cannot_login_with_empty_username_field(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.enterPassword(testData.getProperty("validPassword"));
        loginPage.clickLoginBtn();
        validateText(loginPage.getUsernameErrorMsg(), "Username is required");
    }
    @Test(priority = 5, description = "Verify that user cannot login without password")
    public void verify_user_cannot_login_with_empty_password_field(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clearPasswordField();
        loginPage.enterUsername(testData.getProperty("validUsername"));
        loginPage.clickLoginBtn();
        validateText(loginPage.getPasswordErrorMsg(), "Password is required,");
    }
    @Test(priority = 6, description = "Verify that user cannot login with incorrect username and correct password")
    public void verify_user_cannot_login_with_incorrect_password_and_correct_username(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clearUsernameField();
        loginPage.enterUsername(testData.getProperty("invalidUsername"));
        loginPage.enterPassword(testData.getProperty("validPassword"));
        loginPage.clickLoginBtn();
        validateText(loginPage.getInvalidCredentialsError(), "Provided credentials do not match any user in this service.");
    }
    @Test(priority = 7, description = "Verify that user cannot login with correct username and incorrect password")
    public void verify_user_cannot_login_with_correct_password_and_incorrect_username(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clearPasswordField();
        loginPage.clearUsernameField();
        loginPage.enterUsername(testData.getProperty("validUsername"));
        loginPage.enterPassword("password");
        loginPage.clickLoginBtn();
        validateText(loginPage.getInvalidCredentialsError(), "Provided credentials do not match any user in this service.");
    }
    @Test(priority = 8, description = "Verify that user cannot login with locked out account")
    public void verify_user_cannot_login_with_locked_account(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clearPasswordField();
        loginPage.clearUsernameField();
        loginPage.clickLockedOutAccount();
        loginPage.clickLoginBtn();
        validateText(loginPage.getLockOutErrorMsg(), "Sorry, this user has been locked out.");
    }
    @Test(priority = 9, description = "Verify that the user can log in successfully")
    public void verify_user_is_able_to_login(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Login_test");

        loginPage.clearPasswordField();
        loginPage.clearUsernameField();
        loginPage.enterUsername(testData.getProperty("validUsername"));
        loginPage.enterPassword(testData.getProperty("validPassword"));
        loginPage.clickLoginBtn();

        Assert.assertTrue(dashboardPage.getPageHeader().isDisplayed());
        sleep(5);

    }

}