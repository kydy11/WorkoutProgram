package com.example.student.workoutprogram.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.workoutprogram.DatabaseHelper;
import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.listHelp.ModelSaveFile;
import com.example.student.workoutprogram.listHelp.RoutineListHelp;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.WorkoutSet;

import java.util.ArrayList;

public class RoutineMenu extends AppCompatActivity{
    public static DatabaseHelper routineDb;
    private Button addNew;
    private ListView rList;
    private CheckBox deleteBtn;

    private Model model = Model.getInstance();

    //private ArrayList<Routine> rItems;
    private ArrayAdapter<Routine> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_menu);
        routineDb = new DatabaseHelper(this);

        addNew = findViewById(R.id.addRoutineButton);
        rList = findViewById(R.id.routineList);
        deleteBtn =findViewById(R.id.deleteRoutineBtn);

        model.loadData(this);


        //rItems = RoutineListHelp.readData(this);
        refreshList();


        final Intent toSessionMenu=new Intent(RoutineMenu.this, SessionMenu.class);
        final Intent toAddRoutineScreen=new Intent(RoutineMenu.this, AddRoutineScreen.class);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddRoutineScreen);
            }
        });

        rList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //toSessionMenu.putExtra("RoutineOpened", model.getWorkouts().get(position));
                Routine.current = position;

                if(deleteBtn.isChecked()){
                    model.removeRoutine();
                    model.saveData(RoutineMenu.this);
                    refreshList();
                }else{
                    startActivity(toSessionMenu);
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (deleteBtn.isChecked()) {
                    /******************************************************/// dialog code
                    AlertDialog.Builder builder = new AlertDialog.Builder(RoutineMenu.this);
                    builder.setTitle("Warning");

                    builder.setMessage("Deleted items cannot be recovered.");


// Set up the buttons
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteBtn.setChecked(false);
                            dialog.cancel();
                        }
                    });

                    builder.show();
                    /******************************************************/
                }
            }
        });


    }

    private void refreshList(){
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, model.getList());
        rList.setAdapter(adapter);
    }
}
