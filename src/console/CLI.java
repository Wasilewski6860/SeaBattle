package console;

import logic.Battlefield;
import logic.Cell;
import logic.Coordinate;
import logic.Game;
import logic.players.Player;
import logic.ship.Ship;
import logic.ship.ShipConstants;

import java.util.Scanner;

public class CLI {

   private Game game;

    public CLI() {
        game= new Game();
    }

    public void run(){
        printScreen();
        game.player1.placeShips();
        game.player2.placeShips();
        printScreen();

        while (game.getWinner()==null) {
            while (game.getPlayer1().shoot() && !game.player1.isWinner()) printScreen();
            printScreen();
            while (game.getPlayer2().shoot()&& !game.player1.isWinner()) printScreen();
            printScreen();
        }

        if (game.getPlayer1().isWinner()) System.out.println("You lose");
        if (game.getPlayer2().isWinner()) System.out.println("Congratulations! You win!");

    }

//    public void placePlayerShip(Player player,int length){
//        switch (player.type){
//            case HUMAN -> {
//                player.placeShip(readShipParams(player),length);
//            }
//            case AI -> {
//                player.
//            }
//        }
//
//    }
    private static void printField(Battlefield battlefield, boolean isWarFogActive) {
        System.out.println();
        for (Cell[] row : battlefield.getTable()) {
            System.out.println();
            for (Cell cell : row) {
                switch (cell.getType()) {
                    case SHIP -> {
                        if (!isWarFogActive) System.out.print(" " + "s");
                        else System.out.print(" " + "_");
                    }
                    case SHELLED -> System.out.print(" " + "*");
                    case SHIP_ZONE -> {
                        if (!isWarFogActive) System.out.print(" " + ".");
                        else System.out.print(" " + "_");
                    }
                    case SHIP_WRECKED -> System.out.print(" " + "w");
                    case FREE -> System.out.print(" " + "_");
                }
            }
        }
        System.out.println();
    }

    public void printScreen() {
        printField(Game.getPlayer1().getPlayerBattlefield(), false);
        printField(Game.getPlayer2().getPlayerBattlefield(), true);
        printField(Game.getPlayer2().getPlayerBattlefield(), false);
    }

    public static Ship.LocationParams readShipParams(Player humanPlayer) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter direction:");
        String strDirection = in.nextLine();
        System.out.println("Your dir is " + strDirection);

        System.out.println("Enter coordinates x,y:");
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(" Coordinates is " + x + " " + y);

        ShipConstants.DIRECTION dir = switch (strDirection) {
            case "left" -> ShipConstants.DIRECTION.LEFT;
            case "top" -> ShipConstants.DIRECTION.TOP;
            case "bottom" -> ShipConstants.DIRECTION.BOTTOM;
            default -> ShipConstants.DIRECTION.RIGHT;
        };

        return new Ship.LocationParams(dir, humanPlayer.getPlayerBattlefield().getCell(x, y));
    }

    public static Coordinate readShotParams(Player humanPlayer) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x,y coordinates of your shot: ");
        int x = in.nextInt();
        int y = in.nextInt();

        return new Coordinate(x, y);
    }
}
