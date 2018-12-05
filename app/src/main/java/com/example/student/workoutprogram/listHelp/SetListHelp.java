package com.example.student.workoutprogram.listHelp;

import android.content.Context;


import com.example.student.workoutprogram.models.WorkoutSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SetListHelp {
    public static final String SETFILENAME="setInfo";

    public static void writeData(ArrayList<WorkoutSet> items, Context context){

        try {
            FileOutputStream fos= context.openFileOutput(SETFILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<WorkoutSet> readData(Context context) {
        ArrayList<WorkoutSet> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(SETFILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<WorkoutSet>) ois.readObject();
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
