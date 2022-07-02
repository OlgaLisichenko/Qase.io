package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreatedRepositoryPage {

    public SelenideElement settingsLink = $("[title='Settings']");
    public SelenideElement deleteProjectButton = $(".btn.btn-cancel");
    public SelenideElement suiteButton = $("#create-suite-button");
    public SelenideElement caseButton = $("#create-case-button");
    public SelenideElement suiteName = $(".DvbSwG");
    public SelenideElement caseTitle = $(".jp0OXJ.nzJYNg");

    public void deleteCreatedProject() {
        settingsLink.click();
        deleteProjectButton.click();
        deleteProjectButton.click();
    }
}