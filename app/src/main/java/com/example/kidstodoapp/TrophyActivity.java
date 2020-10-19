package com.example.kidstodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TrophyActivity extends AppCompatActivity {

    private Trophy mTrophy;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_entry);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        this.mTrophy = (Trophy) extras.getSerializable("Trophy");
        this.position = extras.getInt("position");

        TextView nameTextView = findViewById(R.id.entry_name_textview);
        TextView descriptionTextView = findViewById(R.id.entry_description_textview);
        TextView pointsTextView = findViewById(R.id.entry_points_textview);
        final CheckBox redeemed = findViewById(R.id.completion_check_box);

        redeemed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mTrophy.setCompleted(redeemed.isChecked());
                Intent result = new Intent();
                result.putExtra("position", position);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        nameTextView.setText(mTrophy.getName());
        descriptionTextView.setText(mTrophy.getDescription());
        int points = mTrophy.getPoints();
        pointsTextView.setText(points);

        redeemed.setChecked(mTrophy.isRedeemed());
    }
}