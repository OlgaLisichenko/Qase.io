package Ui.pages;

import Ui.dto.NewCase;
import Ui.wrappers.DropDownCreateCase;
import Ui.wrappers.Input;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewCasePage {

    public SelenideElement saveButton = $("#save-case");

    @Step("In the new Case filling in the fields with data")
    public NewCasePage createCase(NewCase newCase) {
        new Input("Title").write(newCase.getTitle());
        new Input("Description").write(newCase.getDescription());
        new Input("Pre-conditions").write(newCase.getPreconditions());
        new Input("Post-conditions").write(newCase.getPostconditions());
        new DropDownCreateCase("Status").selectForNewCase(newCase.getStatus());
        new DropDownCreateCase("Priority").selectForNewCase(newCase.getPriority());
        new DropDownCreateCase("Severity").selectForNewCase(newCase.getSeverity());
        new DropDownCreateCase("Type").selectForNewCase(newCase.getType());
        new DropDownCreateCase("Layer").selectForNewCase(newCase.getLayer());
        new DropDownCreateCase("Is flaky").selectForNewCase(newCase.getIsFlaky());
        new DropDownCreateCase("Behavior").selectForNewCase(newCase.getBehavior());
        new DropDownCreateCase("Automation status").selectForNewCase(newCase.getAutomationStatus());
        return this;
    }
}
