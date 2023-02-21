package org.example.utils;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ServiceUtils {
    private static final String CHAR_SET_OF_LETTERS = "abcdghijklmopqrtuvwxyz";
    Faker faker = new Faker();


    public String generatePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail(String firstName, String lastName) {
        return firstName + "." + lastName +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddhhmmss")) + "@example.com";
    }

    public static String textThatContainsOnly1Letter() {
        int LENGTH = 1;
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHAR_SET_OF_LETTERS.length());
            result.append(CHAR_SET_OF_LETTERS.charAt(index));
        }
        return result.toString().toUpperCase();
    }
}
