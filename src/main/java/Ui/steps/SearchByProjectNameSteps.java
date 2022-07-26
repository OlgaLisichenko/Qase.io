package Ui.steps;

import Ui.pages.NewProjectPage;
import Ui.pages.ProjectsPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static utils.PropertyReader.getProjectsPageUrl;

@Log4j2
public class SearchByProjectNameSteps {

    private ProjectsPage projectsPage = new ProjectsPage();
    private NewProjectPage newProjectPage = new NewProjectPage();

    @Step("Checking search for a project by Project name '{nameProject}'")
    public void checkSearchProjectByName(String nameProject) {
        open(getProjectsPageUrl());
        projectsPage.searchField.sendKeys(nameProject);
        newProjectPage.listOfProjectNames.shouldHave(exactTexts(nameProject));
    }

    @Step("Checking search for a non-existent project by Project name '{nameProject}'")
    public void checkSearchProjectNegative(String nameProject) {
        projectsPage.searchField.sendKeys(nameProject);
        projectsPage.message.shouldHave(exactText("Looks like you don’t have any projects yet."));
    }
}
