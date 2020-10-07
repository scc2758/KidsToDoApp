package com.example.kidstodoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Locale;

public class BuyingTrophy extends Activity{

    TrophyCase trophyCase = new TrophyCase();
    Trophy trophy = new Trophy();
    
    private Button trophyBtn;
    private Button buy;
    private ImageButton image;
    private TextView priceTV;
    private TextView nameTV;
    private TextView descripTV;
    final int price = trophy.getPoints();
    String name = trophy.getName();
    String descrip = trophy.getDescription();
    int point = trophyCase.points;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        trophyBtn.findViewById(R.id.trophyBtn);
        buy.findViewById(R.id.buy);
        priceTV.findViewById(R.id.priceTV);
        nameTV.findViewById(R.id.nameTV);
        descripTV.findViewById(R.id.descripTV);

        nameTV.setText(String.format(Locale.US, "$%d", name));
        priceTV.setText(String.format(Locale.US, "$%d", price));
        descripTV.setText(String.format(Locale.US, "$%d", descrip));

       // int width = dm.widthPixels;
        //int height = dm.heightPixels;
        //getWindow().setLayout((int)(width*.5),(int)(height*.5));

        trophyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), TrophyCase.class);
                startActivity(startIntent);
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point -= price;
            }
        });
    }

}
