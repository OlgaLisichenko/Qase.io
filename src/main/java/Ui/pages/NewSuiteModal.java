package Ui.pages;

import Ui.dto.NewSuite;
import Ui.wrappers.Input;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewSuiteModal {

    public SelenideElement createButton = $("#save-suite-button");

    @Step("In the new test Suite filling in the fields with data")
    public NewSuiteModal createSuite(NewSuite newSuite) {
        new Input("Suite name").write(newSuite.getSuiteName());
        new Input("Description").write(newSuite.getDescription());
        new Input("Preconditions").write(newSuite.getPreconditions());
        return this;
    }
}
