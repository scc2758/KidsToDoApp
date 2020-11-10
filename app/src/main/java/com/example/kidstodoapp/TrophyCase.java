package com.example.kidstodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

public class TrophyCase extends AppCompatActivity implements TrophyAdapter.OnEntryListener  {

    private static ArrayList<Trophy> existingTrophies = new ArrayList<>();
    private static ArrayList<Trophy> archivedTrophies = new ArrayList<>();

    static int pointsEarned = 0;
    private TrophyAdapter adapter;
    private RecyclerView recyclerView;

    private final int NEW_ENTRY_REQUEST = 1;
    private final int VIEW_ENTRY_REQUEST = 2;
    private final int EDIT_ENTRY_REQUEST = 3;

    private ImageButton trophy;
    private TextView pointsDisplay;
    private Button createNewTrophy;

    private final int VIEW = 1;
    private final int NEW = 2;
    private final int EDIT = 3;
    private final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_case);

        //Points Display
        pointsDisplay = findViewById(R.id.points_display);
        setPointsDisplay();

        //Set up recycler view
        adapter = new TrophyAdapter(existingTrophies, this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        createNewTrophy = findViewById(R.id.add_trophy_button);
        createNewTrophy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateTrophyActivity.class);
                startActivityForResult(intent, NEW_ENTRY_REQUEST);
            }
        });

    }

    public void setPointsDisplay() {
        pointsDisplay.setText(String.format(Locale.US, "Total Points: $%d", pointsEarned));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (requestCode == NEW_ENTRY_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bundle extras = result.getExtras();
                Trophy newTrophy = (Trophy) extras.getSerializable("Trophy");
                existingTrophies.add(newTrophy);
                //Collections.sort(existingTrophies);
                recyclerView.setAdapter(adapter);
            }
        }
        if (requestCode == EDIT_ENTRY_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bundle extras = result.getExtras();
                int position = extras.getInt("position");
                if (extras.getBoolean("Deleted")) {
                    existingTrophies.remove(position);
                    adapter.notifyItemRemoved(position);
                } else {
                    Trophy editedTrophy = (Trophy) extras.getSerializable("Trophy");
                    existingTrophies.set(position, editedTrophy);
                    //Collections.sort(existingTrophies);
                }
                recyclerView.setAdapter(adapter);
            }
        }
        if (requestCode == VIEW_ENTRY_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bundle extras = result.getExtras();
                int position = extras.getInt("position");
                Trophy trophy = existingTrophies.remove(position);
                adapter.notifyItemRemoved(position);
                trophy.setRedeemed(true);
                archivedTrophies.add(trophy);
                pointsEarned += trophy.getPoints();
                setPointsDisplay();
            }
        }
    }
    @Override
    public void onEntryClick(int position) {
        Intent intent = new Intent(this, TrophyActivity.class);
        intent.putExtra("Trophy", existingTrophies.get(position));
        intent.putExtra("position", position);
        startActivityForResult(intent, VIEW_ENTRY_REQUEST);
    }
    @Override
    public void onEditClick(int position) {
        Intent intent = new Intent(this, CreateToDoEntryActivity.class);
        intent.putExtra("Trophy", existingTrophies.get(position));
        intent.putExtra("position", position);
        startActivityForResult(intent, EDIT_ENTRY_REQUEST);
    }
}




