package com.bugra.habit.model;

public class Habit {

    private String name;
    private String description;
    private int goal;
    private int status;

    public Habit(String name, String description, int goal) {
        this.name = name;
        this.description = description;
        this.goal = goal;
        this.status = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String habitName) {
        this.name = habitName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String habitDescription) {
        this.description = habitDescription;
    }

    public int getGoal() {
        return this.goal;
    }

    public void setGoal(int habitGoal) {
        this.goal = habitGoal;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int habitStatus) {
        this.status = habitStatus;
    }

    public void incrementStatus() {
        this.status++;
    }

    public boolean goalAchieved() {
        return this.status == this.goal;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
