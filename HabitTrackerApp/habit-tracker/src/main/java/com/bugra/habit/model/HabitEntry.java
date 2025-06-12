package com.bugra.habit.model;

import java.util.Objects;
import java.time.LocalDate;

public class HabitEntry {

    private LocalDate date;
    private boolean achieved;
    private Habit habit;

    public HabitEntry(LocalDate date, Habit habit, boolean achieved) {
        this.date = date;
        this.achieved = achieved;
        this.habit = habit;
    }

    public boolean isAchieved() {
        return this.achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

}
