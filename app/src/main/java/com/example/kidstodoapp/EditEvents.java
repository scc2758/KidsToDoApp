package com.example.kidstodoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EditEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_events_activity);
        if (savedInstanceState == null) {
/*            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EditEventsFragment.newInstance())
                    .commitNow();*/
        }
    }
}