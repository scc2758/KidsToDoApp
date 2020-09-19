package com.example.kidstodoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

// This comment was made by Sean Youngstone

//Main file of the app - HomeScreen
public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    //
    private ArrayList<ToDoEntry> toDoEntries;

    String chore[], choreDescription[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        recyclerView = findViewById(R.id.recyclerView);

        // two list of strings that is placed inside the string.xml file to be placed in the entry and task description
        chore = getResources().getStringArray(R.array.toDoList);
        choreDescription = getResources().getStringArray(R.array.description);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        toDoEntries = new ArrayList<ToDoEntry>();

        for (int i = 0 ; i < 10 ; i++) {
            toDoEntries.add(new ToDoEntry("Entry " + i, "Description " + i));
        }

        ToDoAdapter adapter = new ToDoAdapter(toDoEntries);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button addEntryButton = (Button) findViewById(R.id.add_entry_button);

        addEntryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ToDoEntryActivity.class);
                startActivity(intent);
            }
        });
    }

}