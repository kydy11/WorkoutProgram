package com.example.student.workoutprogram.listHelp;

import android.content.Context;

import com.example.student.workoutprogram.models.Routine;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ModelSaveFile {
    public static final String MFILENAME="/sdcard/modelInfo";

    public static void writeData(ArrayList<Routine> items, Context context){

        try {
            Gson gson = new Gson();
            String json = gson.toJson(items);

            // write on SD card file data from the text box
            File myFile = new File(MFILENAME);
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(json);
            myOutWriter.close();
            fOut.close();

//            FileOutputStream fos= context.openFileOutput(MFILENAME, Context.MODE_PRIVATE);
//            ObjectOutputStream oos =new ObjectOutputStream(fos);
//            oos.writeObject(items);
//            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Routine> readData(Context context) {
        ArrayList<Routine> itemsList = null;
        try {
            FileInputStream fis = context.openFileInput(MFILENAME);
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
