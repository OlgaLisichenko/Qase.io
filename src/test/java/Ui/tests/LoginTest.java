package Ui.tests;

import Ui.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import utils.TestData;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static utils.PropertyReader.*;

public class LoginTest extends BaseTest implements TestData {

    /**
     * Checking the possibility of login with valid credentials
     */
    @Test
    @TmsLink("ATQI-1")
    public void successLoginTest() {
        loginPage.loginWithCorrectUser();
        webdriver().shouldHave(url(getProjectsPageUrl()));
    }

    /**
     * Checking the possibility of login with invalid credentials
     */
    @Test(dataProvider = "Incorrect data")
    @TmsLink("ATQI-2")
    public void failedLoginTest(String username, String password) {
        loginPage.login(username, password);
        webdriver().shouldHave(url(getBaseUrl()));
    }
}
