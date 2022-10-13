package logic;

import console.ConsolePrinter;
import logic.players.HumanPlayer;
import logic.players.Player;

import logic.players.ai.NormalAI;
import logic.ship.ShipConstants.TYPE_OF_SHIP;
import logic.ship.ShipConstants.DIRECTION;

import java.util.Scanner;

public class Game {

    protected static Battlefield firstPlayerField;
    protected static Battlefield secondPlayerField;

    public static Player player1;
    public static Player player2;


    protected static void initialize() {
        firstPlayerField = new Battlefield();
        secondPlayerField = new Battlefield();
        player1 = new HumanPlayer(firstPlayerField, secondPlayerField);
        player2 = new NormalAI(secondPlayerField, firstPlayerField);
    }

    public static void play() {

        initialize();
        ConsolePrinter consolePrinter = new ConsolePrinter(player1.playerBattlefield, player2.playerBattlefield);

        player1.placeShips();
        player2.placeShips();
        consolePrinter.printScreen();

        while (!player1.isWinner() && !player2.isWinner()) {
            while (player1.shoot()) System.out.println();
            consolePrinter.printScreen();
            while (player2.shoot()) System.out.println();
            consolePrinter.printScreen();
        }

        if (!player1.isWinner()) System.out.println("You lose");
        if (!player2.isWinner()) System.out.println("Congratulations! You win!");

    }


    public static void main(String[] args) {
        play();
    }
}
