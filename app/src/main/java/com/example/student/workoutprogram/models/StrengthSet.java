package com.example.student.workoutprogram.models;

public class StrengthSet extends WorkoutSet {
    private int reps;

    public StrengthSet(int time, int reps, String units){
        this.time=time;
        this.reps=reps;
        this.units=units;
    }
    public StrengthSet(int time, int reps){
        this.time=time;
        this.reps=reps;
        this.units="lb";
    }
    public StrengthSet(int reps, String units){
        this.reps=reps;
        this.units=units;
    }
    public StrengthSet(int reps){
        this.reps=reps;
        this.units="lb";
    }

}
