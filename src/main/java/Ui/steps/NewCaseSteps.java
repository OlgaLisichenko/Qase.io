package Ui.steps;

import Ui.pages.CreatedRepositoryPage;
import Ui.pages.NewCasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import utils.AllureUtils;

import static com.codeborne.selenide.Condition.exactText;
import static utils.NewCaseData.newCase;

@Log4j2
public class NewCaseSteps {

    private NewCasePage newCasePage = new NewCasePage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    @Step("Creating a test Case")
    public NewCaseSteps createTestCase() {
        createdRepositoryPage.caseButton.click();
        newCasePage.createCase(newCase);
        newCasePage.saveButton.click();
        AllureUtils.screenshot();
        return this;
    }

    @Step("Check a creating a test Case with name '{caseTitle}'")
    public void checkCreatingOfTestCase(String caseTitle) {
        createdRepositoryPage.caseTitle.shouldHave(exactText(caseTitle));
    }
}
