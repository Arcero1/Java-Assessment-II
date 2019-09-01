package com.qa;

// class is package-private
class Coordinates {
    private int x, y;
    private static int xMax, yMax;

    Coordinates() {
        randomise();
    }

    static void setMaxDimensions(String coordinate, int maxValue) {
        if(isX(coordinate)) {
            xMax = maxValue;
        } else {
            yMax = maxValue;
        }
    }

    private void randomise() {
        this.x = (int) (Math.random() * xMax);
        this.y = (int) (Math.random() * yMax);
    }

    int get(String coordinate) {
        return isX(coordinate) ? x : y;
    }

    void increment(String coordinate) {
        if (isX(coordinate)) {
            x++;
        } else {
            y++;
        }

        wrap(coordinate);
    }

    void decrement(String coordinate) {
        if (isX(coordinate)) {
            x--;
        } else {
            y--;
        }

        wrap(coordinate);
    }

    private void wrap(String coordinate) {
        if(isX(coordinate)) {
            x = x > xMax ? 0 : (x < 0 ? xMax : x);
            return;
        }
        y = y > yMax ? 0 : (y < 0 ? yMax : y);
    }

    private static boolean isX(String coordinate) {
        try {
            if (coordinate.equals("x") || coordinate.equals("y")) {
                return coordinate.equals("x");
            }
            throw new IncorrectCoordinateException();
        } catch (IncorrectCoordinateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Deprecated
    void reset(String coordinate) {
        if (coordinate.equals("x")) x = 0;
        if (coordinate.equals("y")) y = 0;
    }

    @Deprecated
    void set(String coordinate, int value) {
        if (coordinate.equals("x")) x = value;
        if (coordinate.equals("y")) y = value;
    }
}
