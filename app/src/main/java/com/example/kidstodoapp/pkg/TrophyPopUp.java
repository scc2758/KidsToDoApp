package com.example.kidstodoapp.pkg;

import android.os.Bundle;

import com.example.kidstodoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class TrophyPopUp extends AppCompatActivity {

    HashMap<Integer, Trophy> trophyCase = new HashMap<>();
    int idnumber = 0;

    final EditText nameInput= (EditText) findViewById(R.id.editName);
    String nameString = nameInput.getText().toString();

    final EditText pointsInput= (EditText) findViewById(R.id.editPoints);
    String pointString = pointsInput.getText().toString();
    int points = Integer.parseInt(pointString);


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_pop_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button newButton = findViewById(R.id.newButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Trophy ttemp = new Trophy(nameString,points);
                trophyCase.put(idnumber, ttemp);
                idnumber++;
            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Trophy ttemp = trophyCase.get(idnumber);
                ttemp.setName(nameString);
                ttemp.setName(pointString);
            }
        });

        }



}