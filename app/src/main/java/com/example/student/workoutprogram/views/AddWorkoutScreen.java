package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.models.CardioSet;
import com.example.student.workoutprogram.models.StrengthSet;

public class AddWorkoutScreen extends AppCompatActivity {
    private Button cancel;
    private Button addButton;
    private EditText nameText;
    private String name;
    private RadioButton cardioR;
    private RadioButton strengthR;
    private WorkoutMenu.Type type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_screen);

        cancel = findViewById(R.id.wAdd_cancel_button);
        addButton = findViewById(R.id.wAdd);
        nameText = findViewById(R.id.wNameText);
        cardioR = findViewById(R.id.cardioR);
        strengthR = findViewById(R.id.strengthR);

        final Intent toWorkoutMenu=new Intent(AddWorkoutScreen.this, WorkoutMenu.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toWorkoutMenu);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =nameText.getText().toString();
                if(cardioR.isChecked()){
                    type =WorkoutMenu.Type.Cardio;
                }else if(strengthR.isChecked()){
                    type =WorkoutMenu.Type.Strength;
                }
                toWorkoutMenu.putExtra("addToList", true);
                toWorkoutMenu.putExtra("nameOfWorkout", name);
                toWorkoutMenu.putExtra("type", type);
                startActivity(toWorkoutMenu);
            }
        });
    }
}
