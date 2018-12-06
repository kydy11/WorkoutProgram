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
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.Workout;

public class WorkoutMenu extends AppCompatActivity {
    private Button btn;
    private ListView wList;
    private int routineNumb;
    private int sessionNumb;

    private Model model = Model.getInstance();

    //private ArrayList<Workout> wItems;
    private ArrayAdapter<Workout> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_menu);

        btn = findViewById(R.id.addWorkoutButton);
        wList = findViewById(R.id.workoutList);

        sessionNumb =getIntent().getIntExtra("sessionOpened",0);
        routineNumb =getIntent().getIntExtra("routineOpened",0);


        //wItems = WorkoutListHelp.readData(this);
        adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, model.getList().get(routineNumb).getList().get(sessionNumb).getList());
        wList.setAdapter(adapter);

        if(getIntent().getBooleanExtra("addToList", false)){
            adapter.add(new Workout(getIntent().getStringExtra("nameOfRoutine")));
            model.getList().add(new Routine(getIntent().getStringExtra("nameOfRoutine")));
            //WorkoutListHelp.writeData(wItems, this);
            ModelSaveFile.writeData(model.getList(), this);
        }



        final Intent toAddScreen = new Intent(WorkoutMenu.this, AddWorkoutScreen.class);
        final Intent toWorkoutPage = new Intent(WorkoutMenu.this, SetEditPage.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddScreen);
            }
        });

        wList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(toWorkoutPage);
            }
        });



    }
}
