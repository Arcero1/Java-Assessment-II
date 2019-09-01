package com.qa;

class TITSPrompt {
    void welcome() {
        System.out.println("You wake up in a gray swamp");
        System.out.println("There are no distinguishing features, you are very lost");
        System.out.println("In your hands, a watch like device displaying a seemingly random number");
        System.out.println("Try moving 'north', 'south', 'east' or 'west'");
    }

    void firstMove() {
        System.out.println("The number on the device changes, it must be a distance towards something");
        System.out.println("Keep going!");
    }

    void win() {
        System.out.println("You have found a treasure!");
        System.out.println("Would you like to play again?");
    }

    void incorrectDirectionInput() {
        System.out.println("That direction leads nowhere!");
        System.out.println("Try moving 'north', 'south', 'east' or 'west'");
    }

    void mapWidth() {
        System.out.print("Enter map width : ");
    }

    void mapHeight() {
        System.out.print("Enter map height : ");
    }
}
