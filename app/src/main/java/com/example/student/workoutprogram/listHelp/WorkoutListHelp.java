package com.example.student.workoutprogram.listHelp;

import android.content.Context;

import com.example.student.workoutprogram.models.Workout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WorkoutListHelp {
    public static final String WFILENAME="workoutInfo";

    public static void writeData(ArrayList<Workout> items, Context context){

        try {
            FileOutputStream fos= context.openFileOutput(WFILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Workout> readData(Context context) {
        ArrayList<Workout> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(WFILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<Workout>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
