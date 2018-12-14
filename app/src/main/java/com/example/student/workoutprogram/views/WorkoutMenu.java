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
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.Session;
import com.example.student.workoutprogram.models.Workout;

public class WorkoutMenu extends AppCompatActivity {
    public static enum Type{Strength, Cardio};
    private Button btn;
    private ListView wList;
    private Type type;

    private Model model = Model.getInstance();

    //private ArrayList<Workout> wItems;
    private ArrayAdapter<Workout> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_menu);

        btn = findViewById(R.id.addWorkoutButton);
        wList = findViewById(R.id.workoutList);



        //wItems = WorkoutListHelp.readData(this);
        adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts());
        wList.setAdapter(adapter);

        if(getIntent().getBooleanExtra("addToList", false)){
            //adapter.add(new Workout(getIntent().getStringExtra("nameOfRoutine")));
            type = (Type) getIntent().getSerializableExtra("type");

            model.getList().get(Routine.current).getSessions().get(Session.current).addWorkout(new Workout(getIntent().getStringExtra("nameOfWorkout"), type));
            model.saveData(this);

            //WorkoutListHelp.writeData(wItems, this);
//            ModelSaveFile modelSaveFile = new ModelSaveFile(this);
//            modelSaveFile.writeData(model.getWorkouts());
            //RoutineListHelp.writeData(model.getWorkouts(),this);
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
                Workout.current =position;
                startActivity(toWorkoutPage);
            }
        });



    }
}
