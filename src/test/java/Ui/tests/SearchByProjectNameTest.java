package Ui.tests;

import org.testng.annotations.Test;
import Ui.base.BaseTest;

public class SearchByProjectNameTest extends BaseTest {

    /**
     * Checking the ability to search for an existing project by Project name
     */
    @Test
    public void searchByProjectNameTest() {
        String nameProject = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().asin());

        searchByProjectNameSteps.checkSearchProjectByName(nameProject);
    }

    /**
     * Checking the ability to search for a non-existent project by name
     */
    @Test
    public void searchByProjectNameNegativeTest() {
        String nameProject = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().asin());

        createdRepositoryPage.deleteCreatedProject();

        searchByProjectNameSteps.checkSearchProjectNegative(nameProject);
    }
}