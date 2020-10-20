package com.example.kidstodoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Locale;

public class BuyingTrophy extends Activity{

    private String name ;
    private String descrip;
    private int point;
    TrophyCase trophyCase = new TrophyCase();
    Trophy trophy = new Trophy(name, descrip,point);
    
    private Button trophyBtn;
    private Button buy;
    private ImageButton imageBtn;
    private TextView priceTV;
    private TextView nameTV;
    private TextView descripTV;
    final int price = trophy.getPoints();
    Icon image = trophy.getImage();


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem_window);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        trophyBtn.findViewById(R.id.trophyBtn);
        buy.findViewById(R.id.buy);
        priceTV.findViewById(R.id.priceTV);
        nameTV.findViewById(R.id.nameTV);
        descripTV.findViewById(R.id.descripTV);
        imageBtn.findViewById(R.id.imageBtn);

        nameTV.setText(String.format(Locale.US, "$%d", name));
        priceTV.setText(String.format(Locale.US, "$%d", price));
        descripTV.setText(String.format(Locale.US, "$%d", descrip));
        imageBtn.setImageIcon(image);

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
