package Ui.tests.cucumber.steps;

import Ui.browser.SelenideConfiguration;
import Ui.pages.CreatedRepositoryPage;
import Ui.pages.LoginPage;
import Ui.pages.ProjectsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Optional;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class SearchSteps {

    private LoginPage loginPage = new LoginPage();
    private ProjectsPage projectsPage = new ProjectsPage();
    private CreatedRepositoryPage createdRepositoryPage = new CreatedRepositoryPage();

    @Before
    public void setUp() {
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
        SelenideConfiguration.configureBrowser(browser);
    }

    @Given("User logs in")
    public void userLogsIn() {
        loginPage.loginWithCorrectUser();
    }

    @When("User searches for {string}")
    public void projectNameUserSearch(String projectName) {
        projectsPage.projectLink.shouldBe(visible);
        projectsPage.searchField.sendKeys(projectName);
    }

    @Then("{string} is in the search results")
    public void projectNameResultIsInTheSearchResults(String projectNameResult) {
        projectsPage.listOfProjectNames.shouldHave(exactTexts(projectNameResult));
    }

    @Given("User is on the {string} repository page")
    public void userIsOnTheRepositoryPage(String projectName) {
        projectsPage.projectLink.shouldBe(visible);
        projectsPage.listOfProjectNames.findBy(textCaseSensitive(projectName)).click();
    }

    @When("User does search by {string}")
    public void userDoesSearchByCaseName(String caseName) {
        createdRepositoryPage.searchField.sendKeys(caseName);
    }

    @Then("{string} is in the search result")
    public void caseNameIsInTheSearchResult(String caseNameResult) {
        createdRepositoryPage.caseTitle.shouldHave(textCaseSensitive(caseNameResult));
    }

    @After
    public void closeBrowser() {
        closeWebDriver();
    }
}