package Ui.steps;

import Ui.pages.CreatedRepositoryPage;
import Ui.pages.ProjectsPage;
import Ui.pages.NewProjectPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static utils.PropertyReader.getProjectsPageUrl;

@Log4j2
public class ProjectCreationPageSteps {

    private ProjectsPage projectsPage = new ProjectsPage();
    private NewProjectPage newProjectPage = new NewProjectPage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    @Step("Get initial project list size")
    public int getInitialListSize() {
        projectsPage.projectLink.shouldBe(visible);
        return projectsPage.listOfProjectInformation.size();
    }

    @Step("The creation a new project")
    public void createNewProject() {
        projectsPage.clickCreateProjectButton();
        newProjectPage.createNewProjectWithCorrectData();
    }

    @Step("The creation a new project with project name '{nameProject}' and code '{code}'")
    public void createNewProjectWithData(String nameProject, String code) {
        projectsPage.clickCreateProjectButton();
        newProjectPage.createNewProject(nameProject, code);
    }

    @Step("Checking the creation a new project")
    public void checkCreatedProject() {
        open(getProjectsPageUrl());
        projectsPage.listOfProjectNames.
                shouldHave(containExactTextsCaseSensitive(newProjectPage.nameProject));
    }

    @Step("Checking the deleting a created project")
    public void checkProjectDeletion(int expectedSize) {
        projectsPage.listOfProjectInformation.shouldBe(size(expectedSize));
    }

    @Step("Deleting a created project")
    public void deleteProject() {
        projectsPage.listOfProjectNames.findBy(textCaseSensitive(newProjectPage.nameProject)).click();
        createdRepositoryPage.deleteCreatedProject();
    }
}