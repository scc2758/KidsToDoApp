package com.example.kidstodoapp.pkg;

import android.os.Bundle;

import com.example.kidstodoapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class TrophyPopUp extends AppCompatActivity {

    HashMap<Integer, Trophy> trophyCase = new HashMap<>();
    int idnumber = 0;

    final EditText nameInput= (EditText) findViewById(R.id.editName);
    String name = nameInput.getText().toString();

    final EditText pointsInput= (EditText) findViewById(R.id.editPoints);
    String stemp = pointsInput.getText().toString();
    int points = Integer.parseInt(stemp);

   //if trophy case doesn't contain id then,

    Trophy ttemp = new Trophy(name,points);
    //trophyCase.put(idnumber, ttemp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_pop_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

        
            }
        });
    }
}