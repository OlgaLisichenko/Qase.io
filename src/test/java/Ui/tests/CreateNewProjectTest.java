package Ui.tests;

import Ui.base.BaseTest;
import org.testng.annotations.Test;

public class CreateNewProjectTest extends BaseTest {

    /**
     * Checking the possibility of creating a new project
     */
    @Test
    public void createNewProjectTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();

        projectCreationPageSteps.checkCreatedProject();

        projectCreationPageSteps.deleteProject();
    }

    /**
     * Checking the possibility of deleting a created project
     */
    @Test
    public void deleteNewProjectTest() {
        loginPage.loginWithCorrectUser();

        int expectedSize = projectCreationPageSteps.getInitialListSize();

        projectCreationPageSteps.createNewProject();
        createdRepositoryPage.deleteCreatedProject();

        projectCreationPageSteps.checkProjectDeletion(expectedSize);
    }
}
