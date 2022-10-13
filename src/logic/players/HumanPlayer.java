package logic.players;

import console.ConsoleScanner;
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
            if (placeShip(ConsoleScanner.readShipParams(this,type))) iteration++;
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
