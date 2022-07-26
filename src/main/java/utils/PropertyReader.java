package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getLoginUri() {
        return properties.getProperty("login.uri");
    }

    public static String getProjectsPageUrl() {
        return properties.getProperty("projectsPage.url");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static String getBrowserSize() {
        return properties.getProperty("browserSize");
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static boolean getScreenshots() {
        return Boolean.parseBoolean(properties.getProperty("screenshots"));
    }

    public static String getBaseUrlApi() {
        return properties.getProperty("baseApi.url");
    }

    public static String getToken() {
        return properties.getProperty("token");
    }

    public static String getProjectApiUri() {
        return properties.getProperty("projectApi.uri");
    }

    public static String getRunApiUri() {
        return properties.getProperty("runApi.uri");
    }

    public static String getDefectApiUri() {
        return properties.getProperty("defectApi.uri");
    }

    public static String getResultApiUri() {
        return properties.getProperty("resultApi.uri");
    }
}