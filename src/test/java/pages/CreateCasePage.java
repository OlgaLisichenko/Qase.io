package pages;

import com.codeborne.selenide.SelenideElement;
import wrappers.DropDownCreateCase;
import wrappers.InputCreateCase;

import static com.codeborne.selenide.Selenide.$;

public class CreateCasePage {

    public SelenideElement saveButton = $("#save-case");

    public CreateCasePage createCase(String title, String description, String preconditions,
                                     String status, String severity,  String type) {
        new InputCreateCase("Title").writeCase(title);
        new InputCreateCase("Description").writeCase(description);
        new InputCreateCase("Pre-conditions").writeCase(preconditions);
        new DropDownCreateCase("Status").selectForNewCase(status);
        new DropDownCreateCase("Severity").selectForNewCase(severity);
        new DropDownCreateCase("Type").selectForNewCase(type);
        return this;
    }
}
