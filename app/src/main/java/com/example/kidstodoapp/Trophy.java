package com.example.kidstodoapp;

import android.graphics.drawable.Icon;

import java.io.Serializable;

public class Trophy implements Serializable {

    private String name;
    private String description;
    private int pointValue;
    private boolean redeemed;
    private Icon image;
    //BufferedImage image;

    Trophy(String name, String description, int pointValue) {
        this.name = name;
        this.description = description;
        this.pointValue = pointValue;
        //this.image = ImageIO.read(new File(name + ".png"));
    /*    try {
            img = ImageIO.read(new File("logo.png"));
        } catch (IOException e) {
        }
        redeemed = false;*/
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPoints(int pointValue) {
        this.pointValue = pointValue;
    }
    public void setCompleted(boolean redeemed) {
        this.redeemed = redeemed;
    }
    public void setImage(Icon image){
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getPoints() {
        return pointValue;
    }
    public boolean isRedeemed() {
        return redeemed;
    }
    public Icon getImage(){
        return image;
    }
}