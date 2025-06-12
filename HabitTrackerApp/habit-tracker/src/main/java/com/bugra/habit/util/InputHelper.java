package com.bugra.habit.util;

import java.util.Scanner;

public class InputHelper {

    public static int readIntFromUser(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("No valid number. Try again.");
            }

        }

    }

    public static String readStringFromUser(Scanner scanner, String prompt) {

        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                continue;
            }
            return input;

        }

    }

    public static boolean readYesOrNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ja")) {
                return true;
            }
            if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("nein")) {
                return false;
            }

            System.out.println("Please enter yes or no");

        }

    }

}
