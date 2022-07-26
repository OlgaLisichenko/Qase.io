package Ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static utils.PropertyReader.*;

@Log4j2
public class LoginPage {

    public SelenideElement emailInput = $("#inputEmail");
    public SelenideElement passwordInput = $x("//input[@type='password']");
    public SelenideElement loginButton = $(By.id("btnLogin"));

    @Step("Login with correct user")
    public ProjectsPage loginWithCorrectUser() {
        Selenide.open(getLoginUri());
        emailInput.sendKeys(getEmail());
        passwordInput.sendKeys(getPassword());
        loginButton.click();
        return new ProjectsPage();
    }

    @Step("Login with email '{email}' and password '{password}'")
    public ProjectsPage login(String email, String password) {
        Selenide.open(getLoginUri());
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProjectsPage();
    }
}
