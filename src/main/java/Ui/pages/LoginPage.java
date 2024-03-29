package Ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.AllureUtils;
import static com.codeborne.selenide.Selenide.*;
import static utils.PropertyReader.*;

@Log4j2
public class LoginPage {

    public SelenideElement emailInput = $("#inputEmail");
    public SelenideElement passwordInput = $x("//input[@type='password']");
    public SelenideElement loginButton = $(By.id("btnLogin"));

    @Step("Login with correct user")
    public ProjectsPage loginWithCorrectUser() {
        log.info("Navigate to {}", getBaseUrl());
        open(getBaseUrl());
        log.info("Set '{}' like username and '{}' like password for login", getEmail(), getPassword());
        emailInput.sendKeys(getEmail());
        passwordInput.sendKeys(getPassword());
        log.info("Navigate to {}", getProjectsPageUrl());
        loginButton.click();
        AllureUtils.screenshot();
        return new ProjectsPage();
    }

    @Step("Login with email '{email}' and password '{password}'")
    public ProjectsPage login(String email, String password) {
        log.info("Navigate to {}", getBaseUrl());
        open(getBaseUrl());
        log.info("Set '{}' like username and '{}' like password for login", email, password);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        log.info("Navigate to {}", getProjectsPageUrl());
        loginButton.click();
        AllureUtils.screenshot();
        return new ProjectsPage();
    }
}
