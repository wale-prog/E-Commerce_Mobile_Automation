package Tests;

import BaseClasses.TestBase;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReports.ExtentTestManager.startTest;

public class AppTest extends TestBase {

    LoginPage loginPage;

    public void initializer() {
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Validate that user is able to launch the application")
    public void launchApplication(Method method) {
//        startTest(method.getName(), method.getAnnotation(Test.class).description(), "App-launch");

        initializer();
        waitForElement(60).until(ExpectedConditions.visibilityOf(loginPage.getPagebody()));
        while (loginPage.getNextBtn().isEmpty()) {
            swipeGesture();
        }
        loginPage.clickNextBtn();
        sleep(10);
    }
}
