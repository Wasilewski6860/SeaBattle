package logic.players;

import logic.Battlefield;

import logic.Coordinate;
import logic.TurnProviders.HumanTurnProvider;

public class HumanPlayer extends Player {


    public HumanPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
        provider = new HumanTurnProvider(this);
    }

    @Override
    public void placeShipsOfCertainType(int length, int count) {
        System.out.println("Place " + length + "-deck ship ");
        int iteration = 0;
        while (iteration < count) {
            if (placeShip(provider.locationParams(), length)) iteration++;
        }
    }


    @Override
    public boolean shoot() {
        Coordinate coordinateOfShot = provider.coordinateOfShoot();
        return getEnemyBattlefield().getShot(getEnemyBattlefield().getCell(coordinateOfShot.getX(), coordinateOfShot.getY()));
    }


}
