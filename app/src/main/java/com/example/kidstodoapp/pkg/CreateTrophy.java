package com.example.kidstodoapp.pkg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.kidstodoapp.R;
import com.example.kidstodoapp.pkg.Trophy;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class CreateTrophy extends AppCompatActivity {

    HashMap<Integer, Trophy> trophyCase = new HashMap<>();
    int idnumber = 0;

    final EditText nameInput= (EditText) findViewById(R.id.editName);
    String nameString = nameInput.getText().toString();

    final EditText pointsInput= (EditText) findViewById(R.id.editPoints);
    String pointString = pointsInput.getText().toString();
    int points = Integer.parseInt(pointString);

    //Image Gallery
    private static final int PICK_IMAGE = 100;
    ImageView imageViewGallery;
    Button buttonGallery;
    Uri imageUriGallery;

    PopupWindow popUp;
    boolean click = true;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trophy);

        //Create new trophy icon and store data into hashmap
        Button newButton = findViewById(R.id.newButton);
        popUp = new PopupWindow(this);
        layout = new LinearLayout(this);
        LinearLayout mainLayout = new LinearLayout(this);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Create trophy object and add to hashmap
                Trophy ttemp = new Trophy(nameString,points);
                trophyCase.put(idnumber, ttemp);
                idnumber++;
                if (click) {
                    popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
                    popUp.update(50, 50, 300, 80);
                    click = false;
                } else {
                    popUp.dismiss();
                    click = true;
                }

            }
        });

        imageViewGallery = (ImageView)findViewById(R.id.imageView);
        buttonGallery = (Button)findViewById(R.id.changeIcon);
        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openGallery();
            }
        });

    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUriGallery = data.getData();
            imageViewGallery.setImageURI(imageUriGallery);
        }
    }
}


