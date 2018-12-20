package com.example.student.workoutprogram.models;

import com.example.student.workoutprogram.views.WorkoutMenu;

import java.io.Serializable;
import java.util.ArrayList;


public class Workout implements Serializable {
    public static int current;
    private String workoutName;
    private WorkoutMenu.Type type;
    private ArrayList<WorkoutSet> workoutSets;

    public Workout(String name, WorkoutMenu.Type type){
        workoutName=name;
        this.type =type;
        workoutSets =new ArrayList<>();
    }

    public void addSet(WorkoutSet set){
        workoutSets.add(set);
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public ArrayList<WorkoutSet> getSets(){
        if(workoutSets.size()!=0) {
            return workoutSets;
        }else{
            workoutSets =new ArrayList<>();
            return workoutSets;
        }
    }

    @Override
    public String toString() {
        //return super.toString();
        return workoutName;
    }

}
