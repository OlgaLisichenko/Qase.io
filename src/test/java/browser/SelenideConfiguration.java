package browser;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Browsers.*;

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
        Configuration.baseUrl = "https://qase.io/";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }
}
