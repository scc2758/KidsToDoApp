package com.example.kidstodoapp;

import android.widget.ImageButton;

public class Trophy {
    protected String name;
    protected int points;
    protected String description;
    protected ImageButton image;

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
    public String getDescription(){
        return description;
    }
}
