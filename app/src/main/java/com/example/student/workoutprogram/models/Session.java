package com.example.student.workoutprogram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Session implements Serializable {
    public static int current;
    private String sessionName;
    private ArrayList<Workout> workouts;

    public Session(String name){
        sessionName=name;
        workouts =new ArrayList<>();
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public ArrayList<Workout> getWorkouts(){
        return workouts;
    }

    @Override
    public String toString() {
        //return super.toString();
        return sessionName;
    }
}
