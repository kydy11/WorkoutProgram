package com.example.student.workoutprogram.models;

import android.content.Context;

import com.example.student.workoutprogram.listHelp.ModelSaveFile;
import com.example.student.workoutprogram.views.RoutineMenu;

import java.util.ArrayList;

public class Model {
    private static final Model ourInstance = new Model();

    private ArrayList<Routine> routines;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
        routines=new ArrayList<Routine>();
        //routines =ModelSaveFile.readData(context);

    }

    public void addRoutine(Routine routine){
        if (!routines.contains(routine)) {
            routines.add(routine);
        }
        //ModelSaveFile.writeData(routines, context);
    }

    public ArrayList<Routine> getList(){
        return routines;
    }

}
