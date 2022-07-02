package steps;

import pages.CreatedRepositoryPage;
import pages.ProjectCreationPage;
import pages.ProjectsPage;
import utils.PropertyReader;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.open;

public class ProjectCreationPageSteps {

    private ProjectsPage projectsPage = new ProjectsPage();
    private ProjectCreationPage projectCreationPage = new ProjectCreationPage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();
    private PropertyReader reader = new PropertyReader();

    public int initialListSize;

    public void createNewProject() {
        initialListSize = projectCreationPage.listOfProjectNames.size();

        projectsPage.clickCreateProjectButton();
        projectCreationPage.createNewProjectWithCorrectData();
    }

    public void createNewProjectWithData(String nameProject, String code) {
        projectsPage.clickCreateProjectButton();
        projectCreationPage.createNewProject(nameProject, code);
    }

    public void checkCreatedProject() {
        open(reader.getProjectsPageUrl());
        projectCreationPage.listOfProjectNames
                .shouldHave(containExactTextsCaseSensitive(projectCreationPage.nameProject));
    }

    public void checkProjectDeletion() {
        createdRepositoryPage.deleteCreatedProject();
        projectCreationPage.listOfProjectNames.shouldHave(size(initialListSize));
    }
}