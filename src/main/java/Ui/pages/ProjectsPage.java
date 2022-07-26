package Ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsPage {

    public SelenideElement createProjectButton = $("#createButton");
    public SelenideElement searchField = $(".form-control.search-input");
    public SelenideElement message = $(".no-project.mt-4");

    public NewProjectPage clickCreateProjectButton() {
        createProjectButton.shouldBe(visible).click();
        return new NewProjectPage();
    }
}