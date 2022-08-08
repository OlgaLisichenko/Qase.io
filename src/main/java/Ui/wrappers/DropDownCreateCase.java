package Ui.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class DropDownCreateCase {

    protected String label;

    public DropDownCreateCase(String label) {
        this.label = label;
    }

    public void selectForNewCase(String option) {
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'form-group')]//button", label)).click();

        log.info("Set option '{}'", option);
        $x(String.format("//div[text()='%s']", option)).click();
    }
}
