package utils;

import Ui.dto.NewCase;
import com.github.javafaker.Faker;

import java.util.Locale;

public interface NewCaseData {

    String CASE_STATUS = "Draft";
    String CASE_SEVERITY = "Trivial";
    String CASE_TYPE = "Regression";
    String CASE_PRIORITY = "Low";
    String CASE_LAYER = "E2E";
    String CASE_IS_FLAKY = "No";
    String CASE_BEHAVIOR = "Positive";
    String CASE_AUTOMATION_STATUS = "Automated";

    Faker faker = new Faker(new Locale("en-US"));

    NewCase newCase = NewCase.builder().
            title("AT_" + faker.name().title()).
            description("AT_" + faker.book().title()).
            preconditions("AT_" + faker.weather().description()).
            postconditions("AT_" + faker.weather().description()).
            status(CASE_STATUS).
            priority(CASE_PRIORITY).
            severity(CASE_SEVERITY).
            type(CASE_TYPE).
            layer(CASE_LAYER).
            isFlaky(CASE_IS_FLAKY).
            behavior(CASE_BEHAVIOR).
            automationStatus(CASE_AUTOMATION_STATUS).
            build();
}
