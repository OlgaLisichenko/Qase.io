package Ui.steps;

import Ui.pages.ProjectsPage;
import Ui.pages.CreatedRepositoryPage;
import Ui.pages.NewProjectPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;
import static utils.PropertyReader.getProjectsPageUrl;

@Log4j2
public class ProjectCreationPageSteps {

    private ProjectsPage projectsPage = new ProjectsPage();
    private NewProjectPage newProjectPage = new NewProjectPage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    protected int initialListSize;

    @Step("The creation a new project")
    public void createNewProject() {
        initialListSize = newProjectPage.listOfProjectNames.size();
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
        newProjectPage.listOfProjectNames.
                shouldHave(containExactTextsCaseSensitive(newProjectPage.nameProject));
    }

    @Step("Checking the deleting a created project")
    public void checkProjectDeletion() {
        createdRepositoryPage.deleteCreatedProject();
        newProjectPage.listOfProjectNames.shouldHave(size(initialListSize));
    }
}