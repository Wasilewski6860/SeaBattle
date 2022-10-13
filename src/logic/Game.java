package logic;

import logic.players.HumanPlayer;
import logic.players.Player;


import java.util.Scanner;

public class Game {

    protected static Battlefield firstPlayerField;
    protected static Battlefield secondPlayerField;

    static Player[] players;

    protected static void initialize() {
        firstPlayerField = new Battlefield();
        secondPlayerField = new Battlefield();
        players = new Player[]{new HumanPlayer(firstPlayerField, secondPlayerField), new logic.players.ai.NormalAI(secondPlayerField, firstPlayerField)};
    }

    protected static void placeShips(Battlefield battlefield) {
        placeShip(battlefield, Ship.TYPE_OF_SHIP.BATTLESHIP,Battlefield.BATTLE_SHIPS_COUNT);
        placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER,Battlefield.CRUISERS_COUNT);
        placeShip(battlefield, Ship.TYPE_OF_SHIP.DESTROYER,Battlefield.DESTROYERS_COUNT);
        placeShip(battlefield, Ship.TYPE_OF_SHIP.TORPEDO_BOAT,Battlefield.TORPEDO_BOATS_COUNT);
    }

    private static void placeShip(Battlefield battlefield,Ship.TYPE_OF_SHIP type, int count){
        System.out.println("Place "+type);
        for (int i = 0; i < Battlefield.CRUISERS_COUNT; i++) {
            while (!placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER)) {
                placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER);
            }
        }
        printScreen();
    }
    protected static boolean placeShip(Battlefield battlefield, Ship.TYPE_OF_SHIP type) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter direction:");
        String strDirection = in.nextLine();
        System.out.println("Your dir is " + strDirection);

        System.out.println("Enter coordinates x,y:");
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(type + " coordinates is " + x + " " + y);


        Ship.DIRECTION dir = switch (strDirection) {
            case "left" -> Ship.DIRECTION.LEFT;
            case "top" -> Ship.DIRECTION.TOP;
            case "bottom" -> Ship.DIRECTION.BOTTOM;
            default -> Ship.DIRECTION.RIGHT;
        };

        return battlefield.placeShip(type, dir, battlefield.getCell(x, y));

    }

    public static void printScreen(Battlefield battlefield, boolean isWarFogActive){
        Cell[][] cellTable = battlefield.getTable();
        for (Cell[] row : cellTable) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP ->{ if(!isWarFogActive) System.out.print(" " + "s"); else System.out.print(" " + "_");}
                    case SHELLED ->{  System.out.print(" " + "*"); }
                    case SHIP_ZONE ->{ if(!isWarFogActive) System.out.print(" " + "."); else System.out.print(" " + "_");}
                    case SHIP_WRECKED ->{System.out.print(" " + "w");}
                    case FREE ->{  System.out.print(" " + "_"); }
                }
            }
        }
    }
    public static void printScreen() {

        Cell[][] playerCellTable = firstPlayerField.getTable();
        Cell[][] enemyCellTable = secondPlayerField.getTable();

        System.out.println("Player table");
        for (Cell[] row : playerCellTable) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP -> System.out.print(" " + "s");
                    case SHELLED -> System.out.print(" " + "*");
                    case SHIP_ZONE -> System.out.print(" " + ".");
                    case FREE -> System.out.print(" " + "_");
                    case SHIP_WRECKED -> System.out.print(" " + "w");
                }
            }
        }
        System.out.println();
        System.out.println("Enemy table 1");
        for (Cell[] row : enemyCellTable) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP -> System.out.print(" " + "s");
                    case SHELLED -> System.out.print(" " + "*");
                    case SHIP_ZONE -> System.out.print(" " + ".");
                    case FREE -> System.out.print(" " + "_");
                    case SHIP_WRECKED -> System.out.print(" " + "w");
                }
            }
        }
        System.out.println();
        System.out.println("Enemy table 2");
        for (Cell[] row : enemyCellTable) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP, SHIP_ZONE, FREE -> System.out.print(" " + "_");
                    case SHELLED -> System.out.print(" " + "*");
                    case SHIP_WRECKED -> System.out.print(" " + "w");
                }
            }
        }

    }

    public static void play() {

        initialize();

//        playerBattlefield.placeShip(Ship.TYPE_OF_SHIP.BATTLESHIP, Ship.DIRECTION.RIGHT,playerBattlefield.getCell(0,0));
//        playerBattlefield.placeShip(Ship.TYPE_OF_SHIP.BATTLESHIP, Ship.DIRECTION.RIGHT,playerBattlefield.getCell(0,2));
//        playerBattlefield.placeShip(Ship.TYPE_OF_SHIP.BATTLESHIP, Ship.DIRECTION.RIGHT,playerBattlefield.getCell(0,4));
//        playerBattlefield.placeShip(Ship.TYPE_OF_SHIP.BATTLESHIP, Ship.DIRECTION.RIGHT,playerBattlefield.getCell(0,6));

//        printScreen();
//        System.out.println("Place enemy ships");
//        idiot.placeShips();
//        printScreen();
//        System.out.println("Place player ships");
//        placeShips(playerBattlefield);
//        printScreen();

        for (Player player : players){
            player.placeShips();
        }
        printScreen();
        while (firstPlayerField.getShips().size() != 0 && secondPlayerField.getShips().size() != 0)
        for (Player player : players){
           while (player.shoot()) System.out.println();
           printScreen();
        }
//        Scanner in = new Scanner(System.in);
//
//        while (playerBattlefield.getShips().size() != 0 && enemyBattlefield.getShips().size() != 0) {
//            while (playerAttack(in)) System.out.println();
//            while (idiot.shoot()) System.out.println();
//            printScreen();
//            System.out.println("your count = " + playerBattlefield.getShips().size() + " enemy count = " + enemyBattlefield.getShips().size());
//        }

        if (firstPlayerField.getShips().size() == 0) System.out.println("You lose");
        if (secondPlayerField.getShips().size() == 0) System.out.println("Congratulations! You win!");

    }

    private static boolean playerAttack(Scanner in) {
        System.out.println("Enter x,y coordinates of your shot: ");
        int x = in.nextInt();
        int y = in.nextInt();

        return secondPlayerField.getShot(secondPlayerField.getCell(x, y));

    }


    public static void main(String[] args) {
        play();
    }
}
