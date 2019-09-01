package com.qa;

import java.util.Scanner;

class TITSQuery {
    private Scanner scanner = new Scanner(System.in);
    private TITSPrompt prompt = new TITSPrompt();

    String queryMove() {
        while(true) {
            String input;
            do {
                input = scanner.nextLine();
            } while (input.isEmpty());
            if (Constants.validDirectionInputs.contains(input)) {
                return input;
            }
            prompt.incorrectDirectionInput();
        }
    }

    void queryMapSize() {
        Coordinates.setMaxDimensions("x", queryMapWidth());
        Coordinates.setMaxDimensions("y", queryMapHeight());
    }

    boolean confirm() {
        return scanner.nextLine().equals("yes");
    }

    private int queryMapWidth() {
        prompt.mapWidth();

        try {
            return queryMapDimension();
        } catch (IncorrectInputException e) {
            e.printStackTrace();
            System.out.print("Map width must be at least 4 : ");
            return queryMapWidth();
        }
    }

    private int queryMapHeight() {
        prompt.mapHeight();

        try {
            return queryMapDimension();
        } catch (IncorrectInputException e) {
            e.printStackTrace();
            System.out.print("Map height must be at least 4 : ");
            return queryMapHeight();
        }
    }

    private int queryMapDimension() throws IncorrectInputException {
        int mapSize;

        while(true) {
            try{
                mapSize = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Map dimension must be a number. Try again : ");
            }
        }

        if (mapSize < 4) {
            throw new IncorrectInputException();
        } else {
            return mapSize;
        }
    }


}
