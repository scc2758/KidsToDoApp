package com.example.kidstodoapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Locale;

public class TrophyCase extends AppCompatActivity implements TrophyAdapter.OnEntryListener {
    private static ArrayList<Trophy> existingTrophy = new ArrayList<>();
    private static ArrayList<Trophy> archivedTrophy = new ArrayList<>();
    private TrophyAdapter adapterEarned;
    private TrophyAdapter adapterAvailable;

    private Button homeBtn;
    private Button createNewTrophy;
    private ImageButton trophyImage;
    private TextView numPt;
    public static int pointsTotal;
    private MainActivity main = new MainActivity();

    private final int VIEW = 1;
    private final int NEW = 2;
    private final int EDIT = 3;
    private final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy_case);
        numPt.findViewById(R.id.numPt);
        homeBtn.findViewById(R.id.homeBtn);
        numPt.setText(String.format(Locale.US, "$%d", pointsTotal));
        adapterEarned = new TrophyAdapter(existingTrophy, this);
        adapterAvailable = new TrophyAdapter(archivedTrophy, this);
        GridView earnedGrid = (GridView) findViewById(R.id.earnedGrid);
        GridView availableGrid = (GridView) findViewById(R.id.availableGrid);

        earnedGrid.setAdapter((ListAdapter) adapterEarned);
        availableGrid.setAdapter((ListAdapter) adapterAvailable);

        createNewTrophy = findViewById(R.id.AddTrophy);
        createNewTrophy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddTrophy.class);
                startActivityForResult(intent, NEW);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (requestCode == NEW) {
            if (resultCode == RESULT_OK) {
                Bundle extras = result.getExtras();
                Trophy newTemp = (Trophy) extras.getSerializable("Trophy");
                existingTrophy.add(newTemp);
            }
        }
        if (requestCode == VIEW) {
            if (resultCode == RESULT_OK) {
                Bundle extras = result.getExtras();
                int position = extras.getInt("position");
                Trophy trophy = existingTrophy.remove(position);
                adapterEarned.notifyItemRemoved(position);
                trophy.setCompleted(true);
            }
        }
    }

    @Override
    public void onEntryClick(int position) {
        Intent intent = new Intent(this, ToDoEntryActivity.class);
        intent.putExtra("Trophy", existingTrophy.get(position));
        intent.putExtra("position", position);
        startActivityForResult(intent, VIEW);
    }
    @SuppressLint("IntentReset")
    private void sendSms(AlertDialog dialog,final String title) {               //Tries to send an sms
        String message = "Automated message from KidsToDoApp:" + "\n" + "I redeemed the" + title + "trophy!";
        boolean sent = true;
        try {
            SmsManager.getDefault().sendTextMessage(Utility.getPhoneNumber(), null, message, null, null);
        }
        catch(Exception e) {
            //Toast.makeText(TrophyActivity.this,"Unable to Send Message", Toast.LENGTH_SHORT).show();
            sent = false;
        }
        if(sent) {
            //Toast.makeText(TrophyActivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }
    //Checks to see if the user has given SMS permissions
    private void smsPermissions(AlertDialog dialog, final String title) {       //If they have given permissions, tries to send an SMS
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {sendSms(dialog, title);}
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {sendSms(dialog, title);}
            else {dialog.dismiss();}
        }
    }
    private void smsDialog(final String title) {                                //Dialog confirming that the user would like to send an SMS to their parent
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Send SMS");
        builder.setMessage("Would you like to send an SMS to your parent asking for help?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Later Overridden
                //If there were cases where the dialog should NOT close onClick, then this same tactic would be used
                //But in this case, doing this mainly to change it from an AlertDialog.Builder to an AlertDialog
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Later Overridden
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smsPermissions(dialog, title);   //Checks for permissions
            }
        });
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}