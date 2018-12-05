package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.listHelp.ModelSaveFile;
import com.example.student.workoutprogram.listHelp.SessionListHelp;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Session;

import java.util.ArrayList;

public class SessionMenu extends AppCompatActivity {
    private Button addNew;
    private ListView sList;
    private int routineNumb;

    private Model model = Model.getInstance();

    //private ArrayList<Session> sItems;
    private ArrayAdapter<Session> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_menu);

        addNew =findViewById(R.id.addSessionButton);
        sList =findViewById(R.id.sessionList);

        routineNumb =getIntent().getIntExtra("routineOpened",0);




        //sItems = SessionListHelp.readData(this);
        adapter = new ArrayAdapter<Session>(this, android.R.layout.simple_list_item_1, model.getList().get(routineNumb).getList());
        sList.setAdapter(adapter);

        if(getIntent().getBooleanExtra("addToList", false)){
            //adapter.add(new Session("something"));
            model.getList().get(routineNumb).addSession(new Session(getIntent().getStringExtra("nameOfSession")));
            //SessionListHelp.writeData(sItems, this);
            ModelSaveFile.writeData(model.getList(), this);
        }



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
                toWorkoutMenu.putExtra("SessionOpened", position);
                toWorkoutMenu.putExtra("routineOpened", routineNumb);

                startActivity(toWorkoutMenu);
            }
        });
    }
}



