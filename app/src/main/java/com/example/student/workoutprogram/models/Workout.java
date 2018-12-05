package com.example.student.workoutprogram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    private String workoutName;
    private ArrayList<WorkoutSet> workoutSets;

    public Workout(String name){
        workoutName=name;
        workoutSets =new ArrayList<>();
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public ArrayList<WorkoutSet> getList(){
        return workoutSets;
    }

    @Override
    public String toString() {
        //return super.toString();
        return workoutName;
    }

}
