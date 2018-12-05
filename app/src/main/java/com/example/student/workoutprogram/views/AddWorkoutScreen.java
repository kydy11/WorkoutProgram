package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.workoutprogram.R;

public class AddWorkoutScreen extends AppCompatActivity {
    private Button cancel;
    private Button addButton;
    private EditText nameText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout_screen);

        cancel = findViewById(R.id.wAdd_cancel_button);
        addButton = findViewById(R.id.wAdd);
        nameText = findViewById(R.id.wNameText);

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
                toWorkoutMenu.putExtra("addToList", true);
                toWorkoutMenu.putExtra("nameOfWorkout", name);
                startActivity(toWorkoutMenu);
            }
        });
    }
}
