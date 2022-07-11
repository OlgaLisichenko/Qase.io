package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public SelenideElement emailInput = $("#inputEmail");
    public SelenideElement passwordInput = $x("//input[@type='password']");
    public SelenideElement loginButton = $(By.id("btnLogin"));

    PropertyReader propertyReader = new PropertyReader();

    public ProjectsPage loginWithCorrectUser() {
        open(propertyReader.getLoginUrl());
        emailInput.sendKeys(propertyReader.getEmail());
        passwordInput.sendKeys(propertyReader.getPassword());
        loginButton.click();
        return new ProjectsPage();
    }
}
