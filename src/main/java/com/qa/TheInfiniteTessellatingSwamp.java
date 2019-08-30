package com.qa;

import java.util.Scanner;

class TheInfiniteTessellatingSwamp {
    private TITSPrompt prompt = new TITSPrompt();
    private Player player;
    private Treasure treasure;
    private Scanner scanner = new Scanner(System.in);
    private long distance;
    private int mapSize;
    private int mapHeight;
    private int mapWidth;

    TheInfiniteTessellatingSwamp() {
        do {
            startSequence();
            while(!hasWon()) playerTurn();
            prompt.win();

        } while(scanner.nextLine().equals("yes"));
    }

    private void playerTurn() {
        queryMove();
        calculateDistance();
        showDistance();
    }

    private void startSequence() {
        queryMapSize();
        prompt.welcome();
        spawn();
        showDistance();
        player.move(scanner.nextLine()); // this is to temporarily fix the bug below
        queryMove();
        prompt.firstMove();
        calculateDistance();
        showDistance();
    }

    private void spawn() {
        treasure = new Treasure(mapSize);

        // reject spawn on same coordinates
        while(hasWon()) {
            player = new Player(mapSize);
            calculateDistance();
        }
    }

    private boolean hasWon() {
        return distance == 0;
    }

    private void calculateDistance() {
        int distanceX = player.coordinates.get("x") - treasure.coordinates.get("x");
        int distanceY = player.coordinates.get("y") - treasure.coordinates.get("y");
        distance = distanceX * distanceX + distanceY * distanceY;
    }

    private void showDistance() {
        System.out.println(Math.sqrt(distance));
    }


    // QUERIES /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void queryMove() {
        scanner.reset();
        while(!player.move(scanner.nextLine())){
            prompt.incorrect();
        } // BUG : this always runs incorrectly once.
    }

    private void queryMapSize() {
        prompt.mapSize();

        mapSize = 0;
        try {
            mapSize = scanner.nextInt();
            if (mapSize < 4) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("map size must be at least 4 x 4");
        }
    }
}
