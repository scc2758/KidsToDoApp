package com.example.kidstodoapp;

import android.graphics.drawable.Icon;

public class Trophy {
    protected String name;
    protected int points;
    protected String description;
    protected Icon image;

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setImage(Icon image){
        this.image = image;
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
    public Icon getImage(){
        return image;
    }
}
