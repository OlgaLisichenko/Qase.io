package pages;

import com.codeborne.selenide.SelenideElement;
import wrappers.InputCreateSuite;

import static com.codeborne.selenide.Selenide.$;

public class CreateSuiteModal {

    public SelenideElement createButton = $("#save-suite-button");

    public CreateSuiteModal createSuite(String suiteName, String description, String preconditions) {
        new InputCreateSuite("Suite name").writeSuite(suiteName);
        new InputCreateSuite("Description").writeSuite(description);
        new InputCreateSuite("Preconditions").writeSuite(preconditions);
        return this;
    }
}
