package Ui.tests;

import Ui.base.BaseTest;
import org.testng.annotations.Test;
import utils.TestConstants;

import static com.codeborne.selenide.Condition.exactText;

public class CreateNewProjectNegativeTest extends BaseTest implements TestConstants {

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with invalid data
     */
    @Test
    public void createNewProjectWithIncorrectCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), faker.code().isbnRegistrant());

        newProjectPage.errorMessage.shouldHave(exactText("The code format is invalid."));
    }

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with data
     * containing less than two characters
     */
    @Test
    public void createNewProjectWithOneCharacterCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), faker.code().isbnGroup());

        newProjectPage.errorMessage.shouldHave(exactText("The code must be at least 2 characters."));
    }

    /**
     * Checking the possibility of creating a new project by filling in the "Project Code" field with an existing code
     */
    @Test
    public void createNewProjectWithSameCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData(faker.name().title(), INCORRECT_CODE);

        newProjectPage.errorMessage.shouldHave(exactText("The selected project code is already in use."));
    }
}

