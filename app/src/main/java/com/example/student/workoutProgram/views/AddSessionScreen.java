package com.example.student.workoutprogram.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.workoutprogram.R;

public class AddSessionScreen extends AppCompatActivity {
    private Button cancel;
    private Button addButton;
    private EditText nameText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session_screen);

        cancel = findViewById(R.id.sAdd_cancel_button);
        addButton = findViewById(R.id.sAdd);
        nameText = findViewById(R.id.sNameText);

        final Intent toSessionMenu=new Intent(AddSessionScreen.this, SessionMenu.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toSessionMenu);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =nameText.getText().toString();
                toSessionMenu.putExtra("addToList", true);
                toSessionMenu.putExtra("nameOfSession", name);
                startActivity(toSessionMenu);
            }
        });
    }
}
