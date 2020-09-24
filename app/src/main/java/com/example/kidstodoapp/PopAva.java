package com.example.kidstodoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PopAva extends Activity{

    TrophyCase points = new TrophyCase();
    int point = points.points;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Button trophyBtn = (Button)findViewById(R.id.trophyBtn);
        Button buy = (Button)findViewById(R.id.buy);
        TextView priceTV = (TextView)findViewById(R.id.priceTV);
        TextView nameTV = (TextView)findViewById(R.id.nameTV);

        Trophy gift = new Trophy();
        final int price = gift.getPoints();
        String name = gift.getName();

        nameTV.setText(String.format("%d", name));
        priceTV.setText(String.format("Price is %d", price));

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
