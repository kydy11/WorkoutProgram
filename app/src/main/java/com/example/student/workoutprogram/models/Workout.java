package com.example.student.workoutprogram.models;

import com.example.student.workoutprogram.views.WorkoutMenu;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.student.workoutprogram.views.WorkoutMenu.Type.Cardio;
import static com.example.student.workoutprogram.views.WorkoutMenu.Type.Strength;


public class Workout implements Serializable {
    public static int current;
    private String workoutName;
    private WorkoutMenu.Type type;
//    private ArrayList<WorkoutSet> workoutSets;

    private ArrayList<CardioSet> cardioSets;
    private ArrayList<StrengthSet> strengthSets;

    public Workout(String name, WorkoutMenu.Type type){
        workoutName=name;
        this.type =type;

        cardioSets =new ArrayList<>();
        strengthSets =new ArrayList<>();
    }

    public void addSet(CardioSet set){
        cardioSets.add(set);
    }
    public void addSet(StrengthSet set){
        strengthSets.add(set);
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public ArrayList getSets(){
        if(type == Cardio) {
            if (cardioSets.size() > 0) {
                return cardioSets;
            } else {
                cardioSets = new ArrayList<>();
                return cardioSets;
            }
        }else if(type == Strength){
            if (cardioSets.size() > 0) {
                return strengthSets;
            } else {
                strengthSets = new ArrayList<>();
                return strengthSets;
            }
        }
        return new ArrayList();
    }

    public WorkoutMenu.Type getType(){
        return this.type;
    }



    @Override
    public String toString() {
        //return super.toString();
        return workoutName;
    }

}
