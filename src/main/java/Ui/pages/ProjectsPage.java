package Ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import utils.AllureUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class ProjectsPage {

    public SelenideElement createProjectButton = $("#createButton");
    public SelenideElement searchField = $(".form-control.search-input");
    public SelenideElement message = $(".no-project.mt-4");
    public SelenideElement projectLink = $(".project-name");
    public ElementsCollection listOfProjectInformation = $$(".project-row");
    public ElementsCollection listOfProjectNames = $$(".defect-title");

    public NewProjectPage clickCreateProjectButton() {
        log.info("Navigate to New project page");
        createProjectButton.shouldBe(visible).click();
        AllureUtils.screenshot();
        return new NewProjectPage();
    }
}