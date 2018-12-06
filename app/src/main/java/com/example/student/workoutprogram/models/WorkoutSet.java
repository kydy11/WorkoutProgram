package com.example.student.workoutprogram.models;

import java.io.Serializable;

public class WorkoutSet implements Serializable {
    protected int time;
    protected String units;
    protected String notes;

    protected String getNotes(){
        return notes;
    }

}

