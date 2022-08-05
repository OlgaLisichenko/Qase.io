package Ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static utils.PropertyReader.getProjectsPageUrl;

@Log4j2
public class CreatedRepositoryPage {

    public SelenideElement settingsLink = $("[title='Settings']");
    public SelenideElement deleteProjectButton = $(".btn.btn-cancel");
    public SelenideElement suiteButton = $("#create-suite-button");
    public SelenideElement caseButton = $("#create-case-button");
    public SelenideElement suiteName = $(".DvbSwG");
    public SelenideElement caseTitle = $(".jp0OXJ.nzJYNg");
    public SelenideElement searchField = $(".form-control.search-input");

    @Step("Deleting a created project")
    public void deleteCreatedProject() {
        settingsLink.click();
        deleteProjectButton.click();
        log.info("Delete the project and navigate to {}", getProjectsPageUrl());
        deleteProjectButton.click();
    }
}