package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.models.CardioSet;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.Session;
import com.example.student.workoutprogram.models.Workout;
import com.example.student.workoutprogram.models.WorkoutSet;

import java.util.ArrayList;

public class WorkoutMenu extends AppCompatActivity {
    public static enum Type{Strength, Cardio};
    private Button btn;
    private ListView wList;
    private Type type;

    private Model model = Model.getInstance();

    //private ArrayList<Workout> wItems;
    private ArrayAdapter<Workout> adapter;

    private EditText distanceText;
    private EditText unitText;
    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;
    private Button addSetBtn;
    private TextView workoutTitle;
    private ListView setList;
    private ArrayAdapter<WorkoutSet> setAdapter;

    private int distance;
    private String units;
    private int hours;
    private int minutes;
    private int seconds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_menu);

        btn = findViewById(R.id.addWorkoutButton);
        wList = findViewById(R.id.workoutList);

        distanceText = findViewById(R.id.distinceEditText);
        unitText = findViewById(R.id.dUnitEditText);
        hoursText =findViewById(R.id.cTimeHrEditText);
        minutesText = findViewById(R.id.cTimeMEditText);
        secondsText = findViewById(R.id.cTimeSEditText);
        addSetBtn = findViewById(R.id.addCSetBtn);
        setList = findViewById(R.id.cSetList);
        workoutTitle = findViewById(R.id.Title);


        //wItems = WorkoutListHelp.readData(this);

        adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts());
        wList.setAdapter(adapter);

        setAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).getSets());
        setList.setAdapter(setAdapter);

        if(getIntent().getBooleanExtra("addToList", false)){
            //adapter.add(new Workout(getIntent().getStringExtra("nameOfRoutine")));
            type = (Type) getIntent().getSerializableExtra("type");

            model.addWorkout(new Workout(getIntent().getStringExtra("nameOfWorkout"), type));
            model.saveData(this);

            //WorkoutListHelp.writeData(wItems, this);
//            ModelSaveFile modelSaveFile = new ModelSaveFile(this);
//            modelSaveFile.writeData(model.getWorkouts());
            //RoutineListHelp.writeData(model.getWorkouts(),this);
        }

        addSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distance = Integer.parseInt(distanceText.getText().toString());
                units = unitText.getText().toString();
                hours = Integer.parseInt(hoursText.getText().toString());
                minutes =Integer.parseInt(minutesText.getText().toString());
                seconds = Integer.parseInt(secondsText.getText().toString());

                model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).addSet(new CardioSet(hours,minutes,seconds,distance,units));

                refreshList();

            }
        });



        final Intent toAddScreen = new Intent(WorkoutMenu.this, AddWorkoutScreen.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toAddScreen);
            }
        });

        wList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Workout.current =position;
                workoutTitle.setText(model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).toString());

                refreshList();
                /*FragmentManager fm = getSupportFragmentManager();
                StrengthFragment dialogFragment = StrengthFragment.newInstance();
                dialogFragment.show(fm, "Temporary Title");*/
            }
        });



    }
    private void refreshList(){
        setAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).getSets());
        setList.setAdapter(setAdapter);
    }
}
