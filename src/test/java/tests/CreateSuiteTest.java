package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;

public class CreateSuiteTest extends BaseTest {

    /**
     * Checking the possibility of creating a set with filling in the fields
     */
    @Test
    public void createSuiteTest() {
        String suiteName = faker.name().title();

        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProject();
        createdRepositoryPage.suiteButton.click();

        createSuiteModal.createSuite(
                suiteName,
                faker.book().title(),
                faker.weather().description());

        createSuiteModal.createButton.click();

        createdRepositoryPage.suiteName.shouldHave(exactText(suiteName));
    }
}
