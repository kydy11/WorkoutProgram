package com.example.student.workoutprogram.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Routine implements Serializable {
    private String routineName;
    private ArrayList<Session> sessions;


    public Routine(String name){
        routineName=name;
        Model model = Model.getInstance();
        model.addRoutine(this);
        sessions =new ArrayList<>();
    }

    public void addSession(Session session){
        sessions.add(session);
    }

    public ArrayList<Session> getList(){
        return sessions;
    }


    @Override
    public String toString() {
        //return super.toString();
        return routineName;
    }

    @Override
    public boolean equals(Object obj) {
        return this.routineName == ((Routine)obj).routineName;
    }
}
