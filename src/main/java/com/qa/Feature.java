package com.qa;

abstract class Feature {
    Coordinates coordinates;
    private int mapSize = 4;

    Feature(int mapSize) {
        this.mapSize = mapSize;
        newCoordinates();
    }

    private void newCoordinates() {
        this.coordinates = new Coordinates((int) (Math.random() * mapSize), (int) (Math.random() * mapSize));
    }

    int getMapSize() {
        return mapSize;
    }
}
