package console;

import logic.players.HumanPlayer;
import logic.players.Player;
import logic.ship.ShipConstants;
import logic.ship.ShipParams;

import java.util.Scanner;

public class ConsoleScanner {

    public static ShipParams readShipParams(Player humanPlayer, ShipConstants.TYPE_OF_SHIP type) {
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

        return new ShipParams( dir, humanPlayer.getPlayerBattlefield().getCell(x,y) ,type );
    }
}
