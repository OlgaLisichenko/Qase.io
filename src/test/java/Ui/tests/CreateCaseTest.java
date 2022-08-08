package Ui.tests;

import Ui.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static utils.NewCaseData.newCase;

public class CreateCaseTest extends BaseTest {

    /**
     * Checking the possibility of creating a test Case with filling in fields and selecting values from drop-downs
     */
    @Test
    @TmsLink("ATQI-8")
    public void createCaseTest() {

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();

        newCaseSteps.createTestCase()
                    .checkCreatingOfTestCase(newCase.getTitle());

        createdRepositoryPage.deleteCreatedProject();
    }
}
