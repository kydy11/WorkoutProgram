package com.example.student.workoutprogram.listHelp;

import android.content.Context;
import android.os.Environment;

import com.example.student.workoutprogram.models.Routine;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ModelSaveFile {
    public File modelFile;
    public Context context;

    public ModelSaveFile(Context context)
    {
        this.context = context;
        String baseDirectory = context.getFilesDir().toString();
        modelFile = new File(baseDirectory, "modelInfo");
    }

    public void writeData(ArrayList<Routine> items, Context context){

        try {
            Gson gson = new Gson();
            String json = gson.toJson(items);

            // write on SD card file data from the text box
            if (!modelFile.exists()){
                modelFile.createNewFile();
            }
            FileOutputStream fOut = new FileOutputStream(modelFile);
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
        }
    }

    public ArrayList<Routine> readData() {
        ArrayList<Routine> itemsList = new ArrayList<Routine>();
//        int i;
//        String s="";
        try {
//            FileInputStream fis =new FileInputStream(modelFile);
//            InputStreamReader myInputReader = new InputStreamReader(fis);

//            while ((i =myInputReader.read())!=-1){
//                s+=(char)i;
//            }
//
//            System.out.println(s);
            if (modelFile.exists()){
                BufferedReader br = new BufferedReader(new FileReader(modelFile));
                itemsList = new Gson().fromJson(br, new TypeToken<ArrayList<Routine>>(){}.getType());
                return itemsList;
            }

            //itemsList = (ArrayList<Routine>) );


//            FileInputStream fis = context.openFileInput(MFILENAME);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            itemsList = (ArrayList<Routine>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
//            modelFile = new File(MFILENAME);
//            if (!modelFile.exists()){
//                try {
//                    modelFile.createNewFile();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
        }/*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */catch (Exception e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
