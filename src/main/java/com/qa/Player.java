package com.qa;

class Player extends Feature {

    void move(String direction) {
        switch (direction) {
            case "north":
                super.coordinates.increment("y");
                break;
            case "south":
                super.coordinates.decrement("y");
                break;
            case "east":
                super.coordinates.increment("x");
                break;
            case "west":
                super.coordinates.decrement("x");
                break;
        }

    }
}
