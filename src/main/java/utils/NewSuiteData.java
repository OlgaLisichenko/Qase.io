package utils;

import Ui.dto.NewSuite;
import com.github.javafaker.Faker;

import java.util.Locale;

public interface NewSuiteData {

    Faker faker = new Faker(new Locale("en-US"));

    NewSuite newSuite = NewSuite.builder().
            suiteName("AT_" + faker.name().title()).
            description("AT_" + faker.book().title()).
            preconditions("AT_" + faker.weather().description()).
            build();
}
