package logic.players;

import console.ConsoleScanner;
import logic.Battlefield;

import logic.Coordinate;
import logic.ship.ShipChecker;

public class HumanPlayer extends Player {

    public HumanPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
    }


    @Override
    public void placeShip(int length, int count) {
        int iteration = 0;

        System.out.println("Place " + length + "-deck ship ");
        while (iteration < count) {
            /**
             * Что правильней?
             * if (new ShipChecker().check(ConsoleScanner.readShipParams(this), length,getPlayerBattlefield()))iteration++;
             * Или
             */
            if (placeShip(ConsoleScanner.readShipParams(this), length)) iteration++;
        }

    }


    @Override
    public boolean shoot() {
        Coordinate coordinateOfShot = ConsoleScanner.readShotParams(this);
        return enemyBattlefield.getShot(enemyBattlefield.getCell(coordinateOfShot.x(), coordinateOfShot.y()));

    }
}
