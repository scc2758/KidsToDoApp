package com.example.kidstodoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TrophyCase extends AppCompatActivity {

    int points = 100;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_case);
        TextView numPt = (TextView) findViewById(R.id.numPt);
        Button homeBtn = (Button) findViewById(R.id.homeBtn);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        TextView earnedText = (TextView) findViewById(R.id.earnedText);
        TextView availableText = (TextView) findViewById(R.id.availableText);
        ImageButton earnedPrize = (ImageButton) findViewById(R.id.earnedPrize);
        ImageButton availablePrize = (ImageButton) findViewById(R.id.availablePrize);
        numPt.setText(String.format("Points: %d", points));

        earnedPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TrophyCase.this, "You already have this one!", Toast.LENGTH_LONG).show();
            }
        });
        availablePrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrophyCase.this, PopAva.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TrophyCase.this, "Add Trophy", Toast.LENGTH_LONG).show();
                //Intent startIntent = new Intent(getApplicationContext(), );
                //startActivity(startIntent);
            }
        });
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
    //private void setSupportActionBar(Toolbar toolbar) {
    //}
}