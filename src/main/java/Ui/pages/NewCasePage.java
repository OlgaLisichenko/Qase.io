package Ui.pages;

import Ui.dto.NewCase;
import Ui.wrappers.DropDownCreateCase;
import Ui.wrappers.InputCreateCase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class NewCasePage {

    public SelenideElement saveButton = $("#save-case");

    public NewCasePage createCase(NewCase newCase) {
        new InputCreateCase("Title").writeCase(newCase.getTitle());
        new InputCreateCase("Description").writeCase(newCase.getDescription());
        new InputCreateCase("Pre-conditions").writeCase(newCase.getPreconditions());
        new InputCreateCase("Post-conditions").writeCase(newCase.getPostconditions());
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
