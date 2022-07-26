package Ui.browser;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Browsers.*;
import static utils.PropertyReader.*;

public class SelenideConfiguration {

    public static void configureBrowser(String browser) {
        setUpBasicConfigure();

        switch (browser) {
            case "edge":
                Configuration.browser = EDGE;
                break;
            case "firefox":
                Configuration.browser = FIREFOX;
                break;
            default:
                Configuration.browser = CHROME;
                break;
        }
    }

    public static void setUpBasicConfigure() {
        Configuration.baseUrl = getBaseUrl();
        Configuration.headless = isHeadless();
        Configuration.browserSize = getBrowserSize();
        Configuration.timeout = getTimeout();
        Configuration.screenshots = getScreenshots();
    }
}
