package Ui.tests;

import Ui.base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import utils.TestConstants;

import static com.codeborne.selenide.Condition.exactText;

public class CreateNewProjectNegativeTest extends BaseTest implements TestConstants {

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with invalid data
     */
    @Test
    @TmsLink("ATQI-5")
    public void createNewProjectWithIncorrectCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData("AT_" + faker.name().title(), "AT_" + faker.code().isbnRegistrant());

        newProjectPage.errorMessage.shouldHave(exactText("The code format is invalid."));
    }

    /**
     * Checking the possibility of creating a new project with filling in the "Project Code" field with data
     * containing less than two characters
     */
    @Test
    @TmsLink("ATQI-6")
    public void createNewProjectWithOneCharacterCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData("AT_" + faker.name().title(), faker.code().isbnGroup());

        newProjectPage.errorMessage.shouldHave(exactText("The code must be at least 2 characters."));
    }

    /**
     * Checking the possibility of creating a new project by filling in the "Project Code" field with an existing code
     */
    @Test
    @TmsLink("ATQI-7")
    public void createNewProjectWithSameCodeTest() {
        loginPage.loginWithCorrectUser();
        projectCreationPageSteps.createNewProjectWithData("AT_" + faker.name().title(), INCORRECT_CODE);

        newProjectPage.errorMessage.shouldHave(exactText("The selected project code is already in use."));
    }
}

