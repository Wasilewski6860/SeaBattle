package console;

import logic.Coordinate;
import logic.players.Player;
import logic.ship.Ship;
import logic.ship.ShipConstants;

import java.util.Scanner;

public class ConsoleScanner {

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
