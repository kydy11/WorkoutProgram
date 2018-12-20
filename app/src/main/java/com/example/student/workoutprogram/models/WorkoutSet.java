package com.example.student.workoutprogram.models;

import java.io.Serializable;

public class WorkoutSet implements Serializable {
    public static int current;

    protected int hours;
    protected int minutes;
    protected int seconds;
    protected double time;
    protected String units;
    protected String notes;

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    @Override
    public String toString(){
        if (this.getClass().equals(CardioSet.class)) {
            return ((CardioSet)this).toString();
        } else {
            return ((StrengthSet)this).toString();
        }

    }




}

