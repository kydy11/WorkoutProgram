package com.example.student.workoutprogram.models;

import android.content.Context;

import com.example.student.workoutprogram.DatabaseHelper;
import com.example.student.workoutprogram.listHelp.ModelSaveFile;
import com.example.student.workoutprogram.listHelp.RoutineListHelp;
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
        routines.add(routine);

    }

    public void addSession(Session session){
        routines.get(Routine.current).addSession(session);
    }

    public void addWorkout(Workout workout){
        routines.get(Routine.current).getSessions().get(Session.current).addWorkout(workout);
    }

    public void addSet(WorkoutSet set){
        routines.get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).addSet(set);
    }

    public ArrayList<Routine> getList(){
        return routines;
    }

    public void loadData(Context context){
        ModelSaveFile modelSaveFile = new ModelSaveFile(context);
        routines = modelSaveFile.readData();
        //routines =RoutineListHelp.readData(context);
    }

    public void saveData(Context context){
        ModelSaveFile modelSaveFile = new ModelSaveFile(context);
        modelSaveFile.writeData(routines);
    }

}
