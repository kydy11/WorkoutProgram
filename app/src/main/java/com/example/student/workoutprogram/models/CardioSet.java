package com.example.student.workoutprogram.models;

public class CardioSet extends WorkoutSet {
    private int distance;

    public CardioSet(int hours, int minutes, int seconds, int distince, String units){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.distance=distince;
        this.units=units;
    }
    public CardioSet(int hours, int minutes, int seconds, int distance){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        this.distance=distance;
        this.units="mi";
    }
    public String calcPace(){
        time = hours +minutes/60 +seconds/3600;
        double pace=(time/this.distance);
        float result =(float)(int)(pace *100)/100;//reduce to two decimal places
        return ""+result +" h/"+units;

    }
    public String calcSpeed(){
        double speed=(this.distance/this.time);
        float result =(float)(int)(speed *100)/100;//reduce to two decimal places
        return ""+result+" "+units+"/h";
    }

}
