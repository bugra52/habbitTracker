package com.bugra.habit.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import com.bugra.habit.model.Habit;
import com.bugra.habit.model.HabitEntry;
import com.bugra.habit.model.HabitLog;
import com.bugra.habit.model.HabitTracker;
import com.bugra.habit.util.DateHelper;
import com.bugra.habit.util.InputHelper;

public class HabitApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HabitTracker habitTracker = new HabitTracker();
        HabitLog habitLog = new HabitLog();

        while (true) {
            showMenu();

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    handleCreateHabit(scanner, habitTracker);
                    break;
                case "2":
                    handleCreateHabitEntry(scanner, habitTracker, habitLog);
                    break;
                case "3":
                    showHabits(habitTracker);
                    break;
                case "4":
                    showLogs(habitLog);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Not a valid command.");
            }

        }

    }

    public static void showMenu() {
        System.out.println("1. Create new habit");
        System.out.println("2. Create new habit entry");
        System.out.println("3. List all habits");
        System.out.println("4. Show log");
        System.out.println("5. Exit");
    }

    public static void showHabits(HabitTracker habitTracker) {
        List<Habit> habits = habitTracker.getHabits();

        if (habits.isEmpty()) {
            System.out.println("No habit found");
            return;
        }

        System.out.println("Habits: ");
        for (Habit habit : habits) {
            System.out.println(
                    "- " + habit.getName() + " | Goal: " + habit.getGoal() + " | Status: " + habit.getStatus());
        }
    }

    public static void showLogs(HabitLog habitLog) {
        List<HabitEntry> entries = habitLog.getLogs();

        if (entries.isEmpty()) {
            System.out.println("No entry found");
            return;
        }

        System.out.println("Logs: ");
        for (HabitEntry entry : entries) {
            System.out.println(
                    "- " + entry.getDate() + " | Habit: " + entry.getHabit().getName() + " | Achieved: "
                            + entry.isAchieved());
        }

    }

    public static void handleCreateHabit(Scanner scanner, HabitTracker habitTracker) {

        String name = InputHelper.readStringFromUser(scanner, "Name the habit.");

        String description = InputHelper.readStringFromUser(scanner, "Describe your habit.");

        int goal = InputHelper.readIntFromUser(scanner, "What is your goal?");

        Habit newHabit = new Habit(name, description, goal);
        boolean alreadyExists = false;

        for (Habit habit : habitTracker.getHabits()) {
            if (habit.getName().equalsIgnoreCase(newHabit.getName())) {
                alreadyExists = true;
            }
        }

        if (!alreadyExists) {
            habitTracker.addHabit(newHabit);
            System.out.println("Habit added successfully!");
        } else {
            System.out.println("Habit already exists.");
        }

    }

    public static void handleCreateHabitEntry(Scanner scanner, HabitTracker habitTracker, HabitLog habitLog) {
        LocalDate date = DateHelper.readDateFromUser(scanner);
        if (date == null) {
            return;
        }
        System.out.println("Select habit: ");

        String habitName = scanner.nextLine();
        Habit habit = habitTracker.getHabitByName(habitName);

        if (habit == null) {
            System.out.println("Habit not found");
            return;
        }

        boolean status = InputHelper.readYesOrNo(scanner, "Did you achieved your goal today? Answer with yes or no.");
        HabitEntry habitEntry = new HabitEntry(date, habit, status);
        habitLog.addEntry(habitEntry);

    }

}
