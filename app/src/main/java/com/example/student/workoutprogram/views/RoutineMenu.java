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
import com.example.student.workoutprogram.listHelp.RoutineListHelp;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;

import java.util.ArrayList;

public class RoutineMenu extends AppCompatActivity {
    private Button addNew;
    private ListView rList;

    private Model model = Model.getInstance();

    //private ArrayList<Routine> rItems;
    private ArrayAdapter<Routine> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_menu);

        addNew = findViewById(R.id.addRoutineButton);
        rList = findViewById(R.id.routineList);

        //model.loadData(this);


        //rItems = RoutineListHelp.readData(this);
        adapter = new ArrayAdapter<Routine>(this, android.R.layout.simple_list_item_1, model.getList());
        rList.setAdapter(adapter);


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

                //toSessionMenu.putExtra("RoutineOpened", model.getList().get(position));
                toSessionMenu.putExtra("RoutineOpened", position);
                startActivity(toSessionMenu);
            }
        });


    }
}
