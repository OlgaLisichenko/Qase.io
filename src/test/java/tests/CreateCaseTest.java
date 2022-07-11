package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;


public class CreateCaseTest extends BaseTest {

    /**
     * Checking the possibility of creating a test Case with filling in fields and selecting values from drop-downs
     */
    @Test
    public void createCaseTest() {
        String caseTitle = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        createdRepositoryPage.caseButton.click();

        createCasePage.createCase(
                caseTitle, faker.book().title(), faker.weather().description(),
                "Draft", "Trivial", "Regression");

        createCasePage.saveButton.click();

        createdRepositoryPage.caseTitle.shouldHave(exactText(caseTitle));
    }
}
