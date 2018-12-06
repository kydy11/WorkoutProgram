package com.example.student.workoutprogram.models;

import java.io.Serializable;

public class WorkoutSet implements Serializable {
    protected int hours;
    protected int minutes;
    protected int seconds;
    protected double time;
    protected String units;
    protected String notes;

    protected String getNotes(){
        return notes;
    }

}

