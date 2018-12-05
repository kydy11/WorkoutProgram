package com.example.student.workoutprogram.listHelp;

import android.content.Context;

import com.example.student.workoutprogram.models.Routine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RoutineListHelp {
    public static final String RFILENAME="routineInfo";

    public static void writeData(ArrayList<Routine> items, Context context){

        try {
            FileOutputStream fos= context.openFileOutput(RFILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Routine> readData(Context context) {
        ArrayList<Routine> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(RFILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<Routine>) ois.readObject();
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
