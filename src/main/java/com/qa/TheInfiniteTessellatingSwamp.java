package com.qa;

public class TheInfiniteTessellatingSwamp {
    private TITSPrompt prompt = new TITSPrompt();
    private TITSQuery query = new TITSQuery();
    private Player player;
    private Treasure treasure;
    private long distance;



    TheInfiniteTessellatingSwamp() {
        do {
            query.queryMapSize();
            startSequence();

            while(!hasWon()) playerTurn();

            prompt.win();
        } while(query.confirm());
    }

    private void playerTurn() {
        player.move(query.queryMove());
        showDistance();
    }

    private void startSequence() {
        prompt.welcome();
        spawn();
        player.move(query.queryMove());
        prompt.firstMove();
        showDistance();
    }

    private void spawn() {
        treasure = new Treasure();

        // reject spawn on same coordinates
        do {
            player = new Player();
        } while (hasWon());

        showDistance();
    }

    private boolean hasWon() {
        calculateDistance();
        return distance == 0;
    }

    private void calculateDistance() {
        int distanceX = player.coordinates.get("x") - treasure.coordinates.get("x");
        int distanceY = player.coordinates.get("y") - treasure.coordinates.get("y");
        distance = distanceX * distanceX + distanceY * distanceY;
    }

    private void showDistance() {
        calculateDistance();
        System.out.println(Math.sqrt(distance));
    }

}
