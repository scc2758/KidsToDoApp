package com.example.kidstodoapp;

import java.io.Serializable;

public class Trophy implements Serializable {

    private String name;
    private String description;
    private int pointValue;
    private boolean redeemed;
    private String imageLocation;

    Trophy(String name, String description, int pointValue) { //, String imageLocation
        this.name = name;
        this.description = description;
        this.pointValue = pointValue;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPoints() {
        return pointValue;
    }
    public void setPoints(int pointValue) {
        this.pointValue = pointValue;
    }
    public String getImage() {
        return imageLocation;
    }
    public void setImage(String imageLocation) {
        this.imageLocation = imageLocation;
    }
    public boolean isRedeemed() {
        return redeemed;
    }
    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }
}
