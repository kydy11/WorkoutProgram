package com.example.student.workoutprogram.models;

import android.content.Context;

import com.example.student.workoutprogram.listHelp.ModelSaveFile;

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
        routines.get(Routine.current).addWorkout(workout);
    }

    public void addSet( CardioSet set){
        this.getWorkouts().get(Workout.current).addSet(set);
    }
    public void addSet(StrengthSet set){
        this.getWorkouts().get(Workout.current).addSet(set);
    }

    /*******/
    public ArrayList<Routine> getList(){
        return routines;
    }

    public ArrayList<Session> getSessions(){

        Routine routine = routines.get(Routine.current);
        ArrayList<Session> sessions =routine.getSessions();

        return sessions;
    }

    public ArrayList<Workout> getWorkouts(){

        Routine routine = routines.get(Routine.current);
        ArrayList<Workout> workouts =routine.getWorkouts();

        return workouts;
    }

    public ArrayList /*<workoutSet>*/ getSets(){

        ArrayList<Workout> workouts=this.getWorkouts();
        Workout workout =workouts.get(Workout.current);
        ArrayList sets= workout.getSets();

        return sets;
    }
    /*******/

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
