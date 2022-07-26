package Ui.tests;

import Ui.base.BaseTest;
import org.testng.annotations.Test;

public class CreateCaseTest extends BaseTest {

    /**
     * Checking the possibility of creating a test Case with filling in fields and selecting values from drop-downs
     */
    @Test
    public void createCaseTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();

        newCaseSteps.createTestCase().
                     checkCreatingOfTestCase();

        createdRepositoryPage.deleteCreatedProject();
    }
}
