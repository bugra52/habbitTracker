package com.bugra.habit.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HabitLog {

    private List<HabitEntry> habitEntries = new ArrayList<>();

    public HabitLog() {
        this.habitEntries = new ArrayList<>();
    }

    public void addEntry(HabitEntry entry) {
        this.habitEntries.add(entry);
    }

    public List<HabitEntry> getEntriesByDate(LocalDate date) {
        ArrayList<HabitEntry> entriesByDate = new ArrayList<>();
        for (HabitEntry entry : habitEntries) {
            if (entry.getDate().equals(date)) {
                entriesByDate.add(entry);
            }
        }
        return entriesByDate;
    }

    public List<HabitEntry> getEntriesByHabit(Habit habit) {
        ArrayList<HabitEntry> entriesByHabit = new ArrayList<>();
        for (HabitEntry entry : habitEntries) {
            if (entry.getHabit().getName().equals(habit.getName())) {
                entriesByHabit.add(entry);
            }
        }
        return entriesByHabit;
    }

    public void printLog() {
        for (HabitEntry entry : habitEntries) {
            System.out.println(
                    entry.getDate() + " | " + entry.getHabit().getName() + " | " + entry.isAchieved());
        }
    }

    public List<HabitEntry> getLogs() {
        return habitEntries;

    }

}
