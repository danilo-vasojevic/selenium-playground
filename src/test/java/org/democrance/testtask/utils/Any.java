package org.democrance.testtask.utils;

import org.democrance.testtask.dto.PolicyDataDTO;

import java.util.Random;

public class Any {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    private static String randomString(String chars, int length) {
        StringBuilder name = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            name.append(chars.charAt(index));
        }
        return name.toString();
    }
    public static String randomText(int length) {
        return randomString(UPPERCASE_LETTERS+LOWERCASE_LETTERS, length);
    }

    public static String randomNumeric(int length) {
        return randomString(DIGITS, length);
    }

    public static String randomPhone() {
        String prefix = "5" + randomString("068", 1);
        return prefix + randomNumeric(7);
    }

    public static String randomEmail() {
        return randomText(20) + "@automation.com";
    }

    public static PolicyDataDTO validPolicyData() {
        PolicyDataDTO dto = new PolicyDataDTO();
        dto.amount = "Above 30,000";
        dto.frequency = "Monthly";
        dto.title = "Mr";
        dto.name = randomText(5);
        dto.email = randomEmail();
        dto.nationality = "Serbia";
        dto.phone = randomPhone();
        dto.id = "100000000000";

        return dto;
    }
}
