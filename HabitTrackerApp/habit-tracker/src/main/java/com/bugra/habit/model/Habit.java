package com.bugra.habit.model;

public class Habit {

    private String habitName;
    private String habitDescription;
    private int habitGoal;
    private int habitStatus;

    public Habit(String habitName, String habitDescription, int habitGoal, int habitStatus) {
        this.habitName = habitName;
        this.habitDescription = habitDescription;
        this.habitGoal = habitGoal;
        this.habitStatus = habitStatus;
    }

    public String getHabitName() {
        return this.habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getHabitDescription() {
        return this.habitDescription;
    }

    public void setHabitDescription(String habitDescription) {
        this.habitDescription = habitDescription;
    }

    public int getHabitGoal() {
        return this.habitGoal;
    }

    public void setHabitGoal(int habitGoal) {
        this.habitGoal = habitGoal;
    }

    public int getHabitStatus() {
        return this.habitStatus;
    }

    public void setHabitStatus(int habitStatus) {
        this.habitStatus = habitStatus;
    }

    public boolean goalAchieved() {
        if (this.habitGoal == this.habitStatus) {
            return true;
        }
        return false;
    }

}
