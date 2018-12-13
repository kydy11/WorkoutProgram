package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.listHelp.ModelSaveFile;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;

public class AddRoutineScreen extends AppCompatActivity {
    private Button cancel;
    private Button addButton;
    private EditText nameText;
    private String name;

    private Model model = Model.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine_screen);

        cancel = findViewById(R.id.rAdd_cancel_button);
        addButton = findViewById(R.id.rAdd);
        nameText = findViewById(R.id.rNameText);

        final Intent toRoutineMenu=new Intent(AddRoutineScreen.this, RoutineMenu.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toRoutineMenu);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =nameText.getText().toString();

                /*toRoutineMenu.putExtra("addToList", true);
                toRoutineMenu.putExtra("nameOfRoutine", name);*/
                new Routine(name);
                ModelSaveFile modelSaveFile = new ModelSaveFile(AddRoutineScreen.this);
                modelSaveFile.writeData(model.getList(), v.getContext());
                startActivity(toRoutineMenu);
            }
        });
    }
}
