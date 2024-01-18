package com.example.onlinebookstore.generator;

import java.util.Random;

public class IsbnGenerator {
    private static final int MIN_NUMBER = 100000;
    private static final int MAX_NUMBER = 999999;
    private static final Random RANDOM = new Random();

    public static String generateIsbn() {
        return "978-" + "0-" + "13-"
                + RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER
                + "-1";
    }
}
