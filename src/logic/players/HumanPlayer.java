package logic.players;

import logic.Battlefield;
import logic.Ship;

import java.util.Random;
import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
    }


    @Override
    public  void placeShip(Ship.TYPE_OF_SHIP type, int count) {
        int iteration = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Place "+type );
        while (iteration < count) {
            System.out.println(" x =");
            int x = in.nextInt();
            System.out.println(" y =");
            int y = in.nextInt();

            Ship.DIRECTION dir = switch (in.nextLine()) {
                case "left" -> Ship.DIRECTION.LEFT;
                case "top" -> Ship.DIRECTION.TOP;
                case "bottom" -> Ship.DIRECTION.BOTTOM;
                case "right" -> Ship.DIRECTION.RIGHT;
                default -> Ship.DIRECTION.BOTTOM;
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
