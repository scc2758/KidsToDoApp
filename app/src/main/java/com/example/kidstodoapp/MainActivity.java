package com.example.kidstodoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
<<<<<<< HEAD
import android.view.ViewGroup;
import android.widget.TextView;
=======
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
>>>>>>> branch_sean

// This comment was made by Sean Youngstone
public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<ToDoEntry> toDoEntries;

    RecyclerView recyclerView;

    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.toDoList);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
=======
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

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
>>>>>>> branch_sean
    }

}