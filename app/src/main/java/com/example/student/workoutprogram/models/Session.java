package com.example.student.workoutprogram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Session implements Serializable {
    public static Session current;
    private static int idNumb;
    private String sessionName;
    private int id;
//    private ArrayList<Workout> workouts;

    public Session(String name){
        sessionName=name;
        if(idNumb ==0){
            idNumb =1;
        }
        id =idNumb;
        idNumb++;
//        workouts =new ArrayList<>();
    }

    public String getSessionName(){
        return sessionName;
    }

    public int getId(){
        return this.id;
    }

//    public void addWorkout(Workout workout){
//        workouts.add(workout);
//    }

//    public ArrayList<Workout> getWorkouts(){
//        return workouts;
//    }

    @Override
    public String toString() {
        //return super.toString();
        return sessionName;
    }

//    @Override
//    public boolean equals(/*@androidx.annotation.Nullable Object obj*/ Object session) {
////        return super.equals(obj);
//        return this.sessionName.equals(session.getSessionName());
//    }

    public boolean is (Session session){

        if( this.getSessionName().equals(session.getSessionName()) && this.getId()==session.getId() ){
            return true;
        }else{
            return false;
        }
    }
}
