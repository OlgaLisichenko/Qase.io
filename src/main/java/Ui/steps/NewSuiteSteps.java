package Ui.steps;

import Ui.pages.CreatedRepositoryPage;
import Ui.pages.NewSuiteModal;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.NewSuiteData;

import static com.codeborne.selenide.Condition.exactText;

@Log4j2
public class NewSuiteSteps implements NewSuiteData {

    private NewSuiteModal newSuiteModal = new NewSuiteModal();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    @Step("Creating a test Suite")
    public NewSuiteSteps createTestSuite() {
        createdRepositoryPage.suiteButton.click();
        newSuiteModal.createSuite(newSuite);
        newSuiteModal.createButton.click();
        return this;
    }

    @Step("Check a creating a test Suite with name '{suiteName}'")
    public void checkCreatingOfTestSuite(String suiteName) {
        createdRepositoryPage.suiteName.shouldHave(exactText(suiteName));
    }
}
