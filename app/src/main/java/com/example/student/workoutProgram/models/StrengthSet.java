package com.example.student.workoutprogram.models;

public class StrengthSet extends WorkoutSet {
    private int reps;
    private int weight;

    public StrengthSet(int hours, int minutes, int seconds, int reps, int weight, String units){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.reps=reps;
        this.weight=weight;
        this.units=units;
        session=Session.current;
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

    @Override
    public String toString() {
        //return super.toString();
        return (reps + ", " + weight + " " + units + ", " + ( hours*60 +((float) (((int) ((float) seconds/60)*100))/100) ) +" minutes");
    }
}
