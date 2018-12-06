package com.example.student.workoutprogram.models;

public class StrengthSet extends WorkoutSet {
    private int reps;

    public StrengthSet(int hours, int minutes, int seconds, int reps, String units){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.reps=reps;
        this.units=units;
    }
    public StrengthSet(int hours, int minutes, int seconds, int reps){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
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
