package tests;

import browser.SelenideConfiguration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.ProjectCreationPageSteps;
import utils.PropertyReader;

import java.util.Locale;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {

    protected LoginPage loginPage;
    protected PropertyReader reader;
    protected ProjectsPage projectsPage;
    protected ProjectCreationPage projectCreationPage;
    protected CreatedRepositoryPage createdRepositoryPage;
    protected ProjectCreationPageSteps projectCreationPageSteps;
    protected CreateSuiteModal createSuiteModal;
    protected CreateCasePage createCasePage;
    protected Faker faker;

    @BeforeMethod
    public void setUp() {
        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
        SelenideConfiguration.configureBrowser(browser);

        loginPage = new LoginPage();
        reader = new PropertyReader();
        projectsPage = new ProjectsPage();
        projectCreationPage = new ProjectCreationPage();
        createdRepositoryPage = new CreatedRepositoryPage();
        projectCreationPageSteps = new ProjectCreationPageSteps();
        createSuiteModal = new CreateSuiteModal();
        createCasePage = new CreateCasePage();
        faker = new Faker(new Locale("en-US"));
    }

    @AfterMethod
    public void closeBrowser(){
        closeWebDriver();
    }
}
