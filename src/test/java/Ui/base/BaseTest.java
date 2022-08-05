package Ui.base;

import Ui.browser.SelenideConfiguration;
import Ui.pages.*;
import Ui.steps.NewCaseSteps;
import Ui.steps.NewSuiteSteps;
import Ui.steps.SearchByProjectNameSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import Ui.steps.ProjectCreationPageSteps;
import utils.TestListener;

import java.util.Locale;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected NewProjectPage newProjectPage;
    protected CreatedRepositoryPage createdRepositoryPage;
    protected ProjectCreationPageSteps projectCreationPageSteps;
    protected SearchByProjectNameSteps searchByProjectNameSteps;
    protected NewCaseSteps newCaseSteps;
    protected NewSuiteSteps newSuiteSteps;
    protected NewSuiteModal newSuiteModal;
    protected NewCasePage newCasePage;
    protected Faker faker;

    @BeforeMethod(alwaysRun = true, description = "Opening Browser")
    public void setUp() {
        String browser = Optional.ofNullable(System.getProperty("Ui/browser")).orElse("chrome");
        SelenideConfiguration.configureBrowser(browser);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .includeSelenideSteps(true));

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        newProjectPage = new NewProjectPage();
        createdRepositoryPage = new CreatedRepositoryPage();
        projectCreationPageSteps = new ProjectCreationPageSteps();
        searchByProjectNameSteps = new SearchByProjectNameSteps();
        newCaseSteps = new NewCaseSteps();
        newSuiteSteps = new NewSuiteSteps();
        newSuiteModal = new NewSuiteModal();
        newCasePage = new NewCasePage();
        faker = new Faker(new Locale("en-US"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void closeBrowser() {
        closeWebDriver();
    }
}
