package Ui.tests;

import org.testng.annotations.Test;
import Ui.base.BaseTest;
import utils.Retry;

public class SearchByProjectNameTest extends BaseTest {

    /**
     * Checking the ability to search for an existing project by Project name
     */
    @Test(retryAnalyzer = Retry.class)
    public void searchByProjectNameTest() {
        String nameProject = "AT_" + faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().asin());

        searchByProjectNameSteps.checkSearchProjectByName(nameProject);

        searchByProjectNameSteps.deleteProject(nameProject);
    }

    /**
     * Checking the ability to search for a non-existent project by name
     */
    @Test
    public void searchByProjectNameNegativeTest() {
        String nameProject = "AT_" + faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(nameProject, faker.code().asin());

        createdRepositoryPage.deleteCreatedProject();

        searchByProjectNameSteps.checkSearchProjectNegative(nameProject);
    }
}