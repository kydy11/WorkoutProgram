package com.example.student.workoutprogram.models;

public class CardioSet extends WorkoutSet {
    private int distance;

    public CardioSet(int hours, int minutes, int seconds, int distance, String units){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.distance=distance;
        this.units=units;
        time = hours +minutes/60 +seconds/3600;
        session=Session.current;
    }
    public CardioSet(int hours, int minutes, int seconds, int distance){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.distance=distance;
        this.units="mi";
        time = hours +minutes/60 +seconds/3600;
    }
    public String calcPace(){
        double pace=(time/this.distance);
        float result =(float)(int)(pace *100)/100;//reduce to two decimal places
        return ""+result +" h/"+units;

    }
    public String calcSpeed(){
        double speed=(this.distance/this.time);
        float result =(float)(int)(speed *100)/100;//reduce to two decimal places
        return ""+result+" "+units+"/h";
    }

    //@androidx.annotation.NonNull
    @Override
    public String toString() {
        //return super.toString();
        return distance + " " + units + ", speed: " +calcSpeed() + ", pace: "+ calcPace();//distance, speed, pace.
    }
}
