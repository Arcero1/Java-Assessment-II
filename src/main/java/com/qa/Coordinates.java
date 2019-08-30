package com.qa;

public class Coordinates {
    private int x, y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int get(String coordinate) {
        if (coordinate.equals("x")) return x;
        if (coordinate.equals("y")) return y;
        return 0;   // this should never happen if programmed correctly - only interacts with hardcoded elements
                    // an exception would be better though
    }

    void increment(String coordinate) {
        if (coordinate.equals("x")) x++;
        if (coordinate.equals("y")) y++;
    }


    void decrement(String coordinate) {
        if (coordinate.equals("x")) x--;
        if (coordinate.equals("y")) y--;
    }

    void reset(String coordinate) {
        if (coordinate.equals("x")) x = 0;
        if (coordinate.equals("y")) y = 0;
    }

    void set(String coordinate, int value) {
        if (coordinate.equals("x")) x = value;
        if (coordinate.equals("y")) y = value;
    }
}
