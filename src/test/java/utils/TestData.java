package utils;

import org.testng.annotations.DataProvider;

import static utils.PropertyReader.getEmail;
import static utils.PropertyReader.getPassword;

public interface TestData {

    @DataProvider(name = "Incorrect data")
    static Object[][] inputIncorrectData() {
        return new Object[][] {
                {getEmail(), ""},
                {getEmail(), "1111"},
                {"", getPassword()},
                {"qwer", getPassword()},
                {"qwer", "1111"},
                {"", ""},
                {"     ", "     "}
        };
    }
}
