package com.example.kidstodoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Locale;

public class RedeemTrophy extends Activity{

    private String name ;
    private String descrip;
    private int points;
    private String imageLocation;
    TrophyCase trophyCase = new TrophyCase();
    //Trophy trophy = new Trophy(name, descrip,points,imageLocation);
    private Button trophyBtn;
    private Button buy;
    private ImageButton imageBtn;
    private TextView pointsTV;
    private TextView nameTV;
    private TextView descripTV;
    //Icon image = trophy.getImage();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_trophy);
        trophyBtn.findViewById(R.id.trophyBtn);
        buy.findViewById(R.id.buy);
        pointsTV.findViewById(R.id.pointsTV);
        nameTV.findViewById(R.id.nameTV);
        descripTV.findViewById(R.id.descripTV);
        imageBtn.findViewById(R.id.imageBtn);

        nameTV.setText(String.format(Locale.US, "$%d", name));
        pointsTV.setText(String.format(Locale.US, "$%d", points));
        descripTV.setText(String.format(Locale.US, "$%d", descrip));
        imageBtn.findViewById(R.id.trophyImage);

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
                TrophyCase.pointsEarned -= points;
            }
        });
    }
   /* private void redeemed(final CheckBox redeemed) {
        redeemed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mTrophy.setRedeemed(redeemed.isChecked());
                Intent result = new Intent();
                result.putExtra("position", position);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }*/
}
