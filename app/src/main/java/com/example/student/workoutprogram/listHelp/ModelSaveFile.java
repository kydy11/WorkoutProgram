package com.example.student.workoutprogram.listHelp;

import android.content.Context;

import com.example.student.workoutprogram.models.Routine;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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

    public void writeData(ArrayList<Routine> items){

        try {
            Gson gson = new Gson();
            String json = gson.toJson(items);

            // write to file
            if (!modelFile.exists()){
                modelFile.createNewFile();
            }
            FileOutputStream fOut = new FileOutputStream(modelFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(json);
            myOutWriter.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Routine> readData() {
        ArrayList<Routine> itemsList = new ArrayList<Routine>();
        try {

            if (modelFile.exists()){
                BufferedReader br = new BufferedReader(new FileReader(modelFile));
                itemsList = new Gson().fromJson(br, new TypeToken<ArrayList<Routine>>(){}.getType());
                return itemsList;
            }


        } catch (FileNotFoundException e) {
            itemsList = new ArrayList<>();
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return itemsList;
    }
}
