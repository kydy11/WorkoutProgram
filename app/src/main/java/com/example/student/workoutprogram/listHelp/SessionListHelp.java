package com.example.student.workoutprogram.listHelp;

import android.content.Context;


import com.example.student.workoutprogram.models.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SessionListHelp {
    public static final String SFILENAME="sessionInfo";

    public static void writeData(ArrayList<Session> items, Context context){

        try {
            FileOutputStream fos= context.openFileOutput(SFILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Session> readData(Context context) {
        ArrayList<Session> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(SFILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itemsList = (ArrayList<Session>) ois.readObject();
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
