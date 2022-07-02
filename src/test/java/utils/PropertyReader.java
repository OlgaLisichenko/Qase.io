package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return properties.getProperty("email");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getLoginUrl() {
        return properties.getProperty("login.url");
    }

    public String getProjectsPageUrl() {
        return properties.getProperty("projectsPage.url");
    }
}