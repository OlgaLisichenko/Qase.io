package Ui.tests;

import Ui.base.BaseTest;
import org.testng.annotations.Test;

import static utils.NewSuiteData.newSuite;

public class CreateSuiteTest extends BaseTest {

    /**
     * Checking the possibility of creating a set with filling in the fields
     */
    @Test
    public void createSuiteTest() {

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();

        newSuiteSteps.createTestSuite()
                     .checkCreatingOfTestSuite(newSuite.getSuiteName());

        createdRepositoryPage.deleteCreatedProject();
    }
}
