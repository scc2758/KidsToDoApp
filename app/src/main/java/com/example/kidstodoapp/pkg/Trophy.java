package com.example.kidstodoapp.pkg;

import java.util.HashMap;

public class Trophy {

    final HashMap<Integer, Trophy> trophyCase = new HashMap<>();

    private String name;
        int points;

        Trophy(String name, int points) {
            this.name = name;
            this.points = points;
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPoints(int points) {
            this.name = name;
        }

}
