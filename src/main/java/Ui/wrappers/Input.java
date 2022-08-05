package Ui.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input {

    protected String label;

    public Input(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Set the text '{}' into the field", text);
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'form-group')]//input", label))
                .sendKeys(text);
    }
}
