package com.example.kidstodoapp;

public class Trophy {
    protected String name;
    protected int points;

    public void setName(String name) {
        this.name = name;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getName(){
        return name;
    }
    public int getPoints(){
        return points;
    }
}
