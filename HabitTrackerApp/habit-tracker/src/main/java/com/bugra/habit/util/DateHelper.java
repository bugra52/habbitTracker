package com.bugra.habit.util;

import java.time.LocalDate;
import java.util.Scanner;

public class DateHelper {

    public static LocalDate readDateFromUser(Scanner scanner) {
        while (true) {
            System.out.println("Select date (use this format: yyyy-MM-dd) or press Enter for today");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                return null;
            }

            if (input.equals("")) {
                return LocalDate.now();
            }

            try {
                return LocalDate.parse(input);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Wrong date format, please try again");
            }
        }
    }

}
