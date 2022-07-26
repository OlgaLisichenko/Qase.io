package Ui.steps;

import Ui.dto.NewSuite;
import Ui.pages.CreatedRepositoryPage;
import Ui.pages.NewSuiteModal;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;

@Log4j2
public class NewSuiteSteps {

    private NewSuiteModal newSuiteModal = new NewSuiteModal();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    Faker faker = new Faker(new Locale("en-US"));

    String suiteName = faker.name().title();

    NewSuite newSuite = NewSuite.builder().
            suiteName(suiteName).
            description(faker.book().title()).
            preconditions(faker.weather().description()).
            build();

    @Step("Creating a test Suite")
    public NewSuiteSteps createTestSuite() {
        createdRepositoryPage.suiteButton.click();
        newSuiteModal.createSuite(newSuite);
        newSuiteModal.createButton.click();
        return this;
    }

    @Step("Check a creating a test Suite")
    public void checkCreatingOfTestSuite() {
        createdRepositoryPage.suiteName.shouldHave(exactText(suiteName));
    }
}
