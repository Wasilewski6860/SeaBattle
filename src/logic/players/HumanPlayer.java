package logic.players;

import logic.Battlefield;

import java.util.Scanner;

import logic.ship.ShipConstants.TYPE_OF_SHIP;
import logic.ship.ShipConstants.DIRECTION;

public class HumanPlayer extends Player{

    public HumanPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
    }


    @Override
    public  void placeShip(TYPE_OF_SHIP type, int count) {
        int iteration = 0;


        System.out.println("Place "+type );
        while (iteration < count) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter direction:");
            String strDirection = in.nextLine();
            System.out.println("Your dir is " + strDirection);

            System.out.println("Enter coordinates x,y:");
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(type + " coordinates is " + x + " " + y);


            DIRECTION dir = switch (strDirection) {
                case "left" -> DIRECTION.LEFT;
                case "top" -> DIRECTION.TOP;
                case "bottom" -> DIRECTION.BOTTOM;
                default -> DIRECTION.RIGHT;
            };

            System.out.println("Selected dir is"+dir);
            if (placeShip(x,y,type,dir)) iteration++;
        }

    }


    @Override
    public  boolean shoot() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x,y coordinates of your shot: ");
        int x = in.nextInt();
        int y = in.nextInt();

        return enemyBattlefield.getShot(enemyBattlefield.getCell(x, y));

    }
}
