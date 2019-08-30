package com.qa;

public class Player extends Feature {
    Player (int mapSize) {
        super(mapSize);
    }

    boolean move(String direction) {

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
            default:
                return false;
        }

        if (super.coordinates.get("x") > getMapSize()) {
            super.coordinates.reset("x");
        }

        else if (super.coordinates.get("x") < 0) {
            super.coordinates.set("x", getMapSize());
        }

        else if (super.coordinates.get("y") > getMapSize()) {
            super.coordinates.reset("y");
        }

        else if (super.coordinates.get("y") < 0) {
            super.coordinates.set("y", getMapSize());
        }

        return true;
    }
}
