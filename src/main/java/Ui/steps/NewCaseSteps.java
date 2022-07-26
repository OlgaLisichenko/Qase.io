package Ui.steps;

import Ui.dto.NewCase;
import Ui.pages.CreatedRepositoryPage;
import Ui.pages.NewCasePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.DataConstants;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;

@Log4j2
public class NewCaseSteps implements DataConstants {

    private NewCasePage newCasePage = new NewCasePage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    Faker faker = new Faker(new Locale("en-US"));

    String caseTitle = faker.name().title();

    NewCase newCase = NewCase.builder().
            title(caseTitle).
            description(faker.book().title()).
            preconditions(faker.weather().description()).
            postconditions(faker.weather().description()).
            status(CASE_STATUS).
            priority(CASE_PRIORITY).
            severity(CASE_SEVERITY).
            type(CASE_TYPE).
            layer(CASE_LAYER).
            isFlaky(CASE_IS_FLAKY).
            behavior(CASE_BEHAVIOR).
            automationStatus(CASE_AUTOMATION_STATUS).
            build();

    @Step("Creating a test Case")
    public NewCaseSteps createTestCase() {
        createdRepositoryPage.caseButton.click();
        newCasePage.createCase(newCase);
        newCasePage.saveButton.click();
        return this;
    }

    @Step("Check a creating a test Case")
    public void checkCreatingOfTestCase() {
        createdRepositoryPage.caseTitle.shouldHave(exactText(caseTitle));
    }
}
