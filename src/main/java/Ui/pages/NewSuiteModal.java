package Ui.pages;

import Ui.dto.NewSuite;
import Ui.wrappers.InputCreateSuite;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NewSuiteModal {

    public SelenideElement createButton = $("#save-suite-button");

    public NewSuiteModal createSuite(NewSuite newSuite) {
        new InputCreateSuite("Suite name").writeSuite(newSuite.getSuiteName());
        new InputCreateSuite("Description").writeSuite(newSuite.getDescription());
        new InputCreateSuite("Preconditions").writeSuite(newSuite.getPreconditions());
        return this;
    }
}
