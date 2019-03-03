package com.example.student.workoutprogram.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.Session;

import java.util.ArrayList;

public class SessionMenu extends AppCompatActivity {
    private Button addNew;
    private ListView sList;
    private CheckBox deleteBtn;

    private Model model = Model.getInstance();

    //private ArrayList<Session> sItems;
    private ArrayAdapter<Session> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_menu);

        addNew =findViewById(R.id.addSessionButton);
        sList =findViewById(R.id.sessionList);
        deleteBtn =findViewById(R.id.deleteSessionBtn);






        if(getIntent().getBooleanExtra("addToList", false)){
            //adapter.add(new Session("something"));
            model.addSession(new Session(getIntent().getStringExtra("nameOfSession")));

            model.saveData(this);

        }

        refreshList();



        final Intent toWorkoutMenu=new Intent(SessionMenu.this, WorkoutMenu.class);
        final Intent toAddSessionScreen=new Intent(SessionMenu.this, AddSessionScreen.class);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddSessionScreen);
            }
        });

        sList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Session.current = model.getSessions().get(position);

                if(deleteBtn.isChecked()){
                    model.removeSession();
                    model.saveData(SessionMenu.this);
                    refreshList();
                }else {
                    startActivity(toWorkoutMenu);
                }
            }

        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteBtn.isChecked()) {
                    /******************************************************/// dialog code
                    AlertDialog.Builder builder = new AlertDialog.Builder(SessionMenu.this);
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
        ArrayList<Session> sessions =  model.getSessions();
        if (sessions.size() != 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sessions);
            sList.setAdapter(adapter);
        }
    }


}



