package com.example.student.workoutprogram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Routine implements Serializable {
    public static int current;
    private String routineName;
    private ArrayList<Session> sessions;
    private ArrayList<Workout> workouts;


    public Routine(String name){
        routineName=name;
        Model model = Model.getInstance();
        sessions =new ArrayList<>();
        workouts =new ArrayList<>();
        model.addRoutine(this);
    }

    public void addSession(Session session){
        sessions.add(session);
    }

    public ArrayList<Session> getSessions(){
        return sessions;
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
        return routineName;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return this.routineName == ((Routine)obj).routineName;
//    }
}
