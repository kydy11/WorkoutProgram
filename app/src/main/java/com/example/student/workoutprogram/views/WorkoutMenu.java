package com.example.student.workoutprogram.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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
import com.example.student.workoutprogram.models.StrengthSet;
import com.example.student.workoutprogram.models.Workout;
import com.example.student.workoutprogram.models.WorkoutSet;

import java.util.ArrayList;

import static com.example.student.workoutprogram.views.WorkoutMenu.Type.Cardio;
import static com.example.student.workoutprogram.views.WorkoutMenu.Type.Strength;

public class WorkoutMenu extends AppCompatActivity {
    public enum Type{Strength, Cardio}
    private Button btn;
    private ListView wList;
    private Type type;

    private Model model = Model.getInstance();

    //private ArrayList<Workout> wItems;
    private ArrayAdapter<Workout> adapter;

    private EditText repsText;
    private EditText weightText;
    private EditText distanceText;
    private EditText unitText;
    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;
    private Button addSetBtn;
    private TextView workoutTitle;
    private ListView setList;
    private ArrayAdapter/*<WorkoutSet>*/ setAdapter;

    private int distance;

    private int reps;
    private int weight;

    private String units;
    private int hours;
    private int minutes;
    private int seconds;

    private String dialogText;

    private Type wType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_menu);

        btn = findViewById(R.id.addWorkoutButton);
        wList = findViewById(R.id.workoutList);

        repsText =findViewById(R.id.repsEditText);
        weightText =findViewById(R.id.weightEditText);
        distanceText = findViewById(R.id.distinceEditText);
        unitText = findViewById(R.id.unitEditText);
        hoursText =findViewById(R.id.timeHrEditText);
        minutesText = findViewById(R.id.timeMEditText);
        secondsText = findViewById(R.id.timeSEditText);
        addSetBtn = findViewById(R.id.addSetBtn);
        setList = findViewById(R.id.setList);
        workoutTitle = findViewById(R.id.Title);


        //wItems = WorkoutListHelp.readData(this);

        adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, model.getWorkouts());
        wList.setAdapter(adapter);


        hideSets();


        if(getIntent().getBooleanExtra("addToList", false)){
            //adapter.add(new Workout(getIntent().getStringExtra("nameOfRoutine")));
            type = (Type) getIntent().getSerializableExtra("type");

            model.addWorkout(new Workout(getIntent().getStringExtra("nameOfWorkout"), type));
            model.saveData(this);

//            //WorkoutListHelp.writeData(wItems, this);
//            ModelSaveFile modelSaveFile = new ModelSaveFile(this);
//            modelSaveFile.writeData(model.getWorkouts());
//            //RoutineListHelp.writeData(model.getWorkouts(),this);
        }

        addSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wType = model.getWorkouts().get(Workout.current).getType();

                units = unitText.getText().toString();
                hours = Integer.parseInt(hoursText.getText().toString());
                minutes =Integer.parseInt(minutesText.getText().toString());
                seconds = Integer.parseInt(secondsText.getText().toString());

                if(wType ==Cardio)
                {
                    distance = Integer.parseInt(distanceText.getText().toString());

                    model.addSet(new CardioSet(hours, minutes, seconds, distance, units));
                }else if(wType ==Strength)
                {
                    reps = Integer.parseInt(repsText.getText().toString());
                    weight = Integer.parseInt(weightText.getText().toString());

                    model.addSet(new StrengthSet(hours, minutes, seconds, reps, weight, units));
                }

                model.saveData(WorkoutMenu.this);

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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //workout list
                Workout.current =position;
                showSets(model.getWorkouts().get(Workout.current).getType());
                workoutTitle.setText(model.getWorkouts().get(Workout.current).toString());

                refreshList();
                /*FragmentManager fm = getSupportFragmentManager();
                StrengthFragment dialogFragment = StrengthFragment.newInstance();
                dialogFragment.show(fm, "Temporary Title");*/
            }
        });

        setList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                /******************************************************/// dialog code
                AlertDialog.Builder builder = new AlertDialog.Builder(WorkoutMenu.this);
                builder.setTitle("Notes");

// Set up the input
                final EditText input = new EditText(WorkoutMenu.this);
// Specify the type of input expected.
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                WorkoutSet.current = position;
                WorkoutSet set =(WorkoutSet) model.getSets().get(WorkoutSet.current);
                input.setText(set.getNotes());

// Set up the buttons
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogText = input.getText().toString();
                        WorkoutSet set =(WorkoutSet) model.getSets().get(WorkoutSet.current);
                        ((WorkoutSet) model.getSets().get(WorkoutSet.current)).setNotes(dialogText);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                /******************************************************/


            }
        });



    }
    private void hideSets(){
        repsText.setVisibility(View.GONE);
        weightText.setVisibility(View.GONE);
        distanceText.setVisibility(View.GONE);
        unitText.setVisibility(View.GONE);
        hoursText.setVisibility(View.GONE);
        minutesText.setVisibility(View.GONE);
        secondsText.setVisibility(View.GONE);
        addSetBtn.setVisibility(View.GONE);
        setList.setVisibility(View.GONE);



    }

    private void showSets(Type type){
        if(type == Strength) {
            repsText.setVisibility(View.VISIBLE);
            weightText.setVisibility(View.VISIBLE);
            distanceText.setVisibility(View.GONE);
            unitText.setHint(getString(R.string.weight_units));
            unitText.setText(getString(R.string.weight_units));
        }else {
            distanceText.setVisibility(View.VISIBLE);
            repsText.setVisibility(View.GONE);
            weightText.setVisibility(View.GONE);
            unitText.setHint(getString(R.string.distance_units));
            unitText.setText( getString(R.string.distance_units));
        }
        unitText.setVisibility(View.VISIBLE);
        hoursText.setVisibility(View.VISIBLE);
        minutesText.setVisibility(View.VISIBLE);
        secondsText.setVisibility(View.VISIBLE);
        addSetBtn.setVisibility(View.VISIBLE);
        setList.setVisibility(View.VISIBLE);

    }

    private void refreshList(){

        wType = model.getWorkouts().get(Workout.current).getType();


        if(wType == Strength){
            try {
                ArrayList<StrengthSet> sets=  model.getSets();

                setAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sets/*model.getSets()*/);
                setList.setAdapter(setAdapter);
            }catch (Exception e){
                System.out.print(e);

                setAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList());
                setList.setAdapter(setAdapter);


            }
        }else{
            ArrayList<CardioSet> sets =model.getSets();

            setAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sets/*model.getSets()*/);
            setList.setAdapter(setAdapter);

        }

    }
}
