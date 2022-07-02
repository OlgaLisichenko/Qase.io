package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class SearchByProjectNameTest extends BaseTest {

    /**
     * Checking the ability to search for an existing project by Project name
     */
    @Test
    public void searchByProjectNameTest() {
        String nameProject = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().isbnGs1());

        open(reader.getProjectsPageUrl());
        projectsPage.searchField.sendKeys(nameProject);

        projectCreationPage.listOfProjectNames.shouldHave(exactTexts(nameProject));
    }

    /**
     * Checking the ability to search for a non-existent project by name
     */
    @Test
    public void searchByProjectNameNegativeTest() {
        String nameProject = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().isbnGs1());

        createdRepositoryPage.deleteCreatedProject();
        projectsPage.searchField.sendKeys(nameProject);

        projectsPage.message.shouldHave(exactText("Looks like you don’t have any projects yet."));
    }
}