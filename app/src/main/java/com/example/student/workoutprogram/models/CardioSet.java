package com.example.student.workoutprogram.models;

public class CardioSet extends WorkoutSet {
    private int distince;

    public CardioSet(int time, int distince, String units){
        this.time=time;
        this.distince=distince;
        this.units=units;
    }
    public CardioSet(int time, int distince){
        this.time=time;
        this.distince=distince;
        this.units="mi";
    }
    public String calcPace(){
        float pace=(this.time/this.distince);
        float result =(float)(int)(pace *100)/100;//reduce to two decimal places
        return ""+result +" s/"+units;

    }
    public String calcSpeed(){
        float speed=(this.distince/this.time);
        float result =(float)(int)(speed *100)/100;//reduce to two decimal places
        return ""+result+" "+units+"/s";
    }

}
