package Ui.tests;

import Ui.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class CreateNewProjectTest extends BaseTest {

    /**
     * Checking the possibility of creating a new project
     */
    @Test
    @TmsLink("ATQI-3")
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
    @TmsLink("ATQI-4")
    public void deleteNewProjectTest() {
        loginPage.loginWithCorrectUser();

        int expectedSize = projectCreationPageSteps.getInitialListSize();

        projectCreationPageSteps.createNewProject();
        createdRepositoryPage.deleteCreatedProject();

        projectCreationPageSteps.checkProjectDeletion(expectedSize);
    }
}
