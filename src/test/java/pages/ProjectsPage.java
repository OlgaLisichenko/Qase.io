package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage {

    public SelenideElement createProjectButton = $("#createButton");
    public SelenideElement searchField = $(".form-control.search-input");
    public SelenideElement message = $(".no-project.mt-4");

    public ProjectCreationPage clickCreateProjectButton() {
        createProjectButton.shouldBe(visible).click();
        return new ProjectCreationPage();
    }
}