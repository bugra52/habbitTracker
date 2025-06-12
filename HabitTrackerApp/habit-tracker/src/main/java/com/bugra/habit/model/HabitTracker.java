package com.bugra.habit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HabitTracker {

    private List<Habit> habits = new ArrayList<>();

    public HabitTracker() {
        this.habits = new ArrayList<>();
    }

    public void addHabit(Habit habit) {
        this.habits.add(habit);
    }

    public void removeHabit(Habit habit) {
        this.habits.remove(habit);
    }

    public void printHabits() {
        for (Habit habit : habits) {
            System.out.println(habit.getName());
        }
    }

    public void incrementHabit(Habit habit) {
        habit.incrementStatus();
    }

    public boolean allHabitsAchieved() {

        for (Habit habit : habits) {
            if (!habit.goalAchieved()) {
                return false;
            }
        }
        return true;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public Habit getHabitByName(String name) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(name)) {
                return habit;
            }
        }

        return null;
    }

}
