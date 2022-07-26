package Ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class NewProjectPage {

    public SelenideElement nameProjectInput = $("#inputTitle");
    public SelenideElement codeProjectInput = $("#inputCode");
    public SelenideElement createProjectButton = $(".btn.btn-primary");
    public ElementsCollection  listOfProjectNames = $$(".defect-title");
    public SelenideElement errorMessage = $(".form-control-feedback");

    Faker faker = new Faker(new Locale("en-US"));

    public String nameProject = faker.name().title();

    @Step("Creating a new project with correct data ")
    public void createNewProjectWithCorrectData() {
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.clear();
        codeProjectInput.sendKeys(faker.code().asin());
        createProjectButton.click();
    }

    @Step("Creating a new project with project name '{nameProject}' and code '{code}'")
    public void createNewProject(String nameProject, String code) {
        nameProjectInput.sendKeys(nameProject);
        codeProjectInput.clear();
        codeProjectInput.sendKeys(code);
        createProjectButton.click();
    }
}
