package logic.players;

import logic.Battlefield;
import logic.ship.Ship;
import logic.ship.ShipConstants;

public abstract class Player {
    public Battlefield playerBattlefield;
    public Battlefield enemyBattlefield;

    public Player(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        this.playerBattlefield = playerBattlefield;
        this.enemyBattlefield = enemyBattlefield;
    }

    public abstract void placeShip(int length, int count);

    public boolean placeShip(Ship.LocationParams location, int length) {
        return playerBattlefield.placeShip(length, location);
    }

    public void placeShips() {
        placeShip(ShipConstants.BATTLESHIP_LENGTH, Battlefield.BATTLE_SHIPS_COUNT);
        placeShip(ShipConstants.CRUISER_LENGTH, Battlefield.CRUISERS_COUNT);
//      placeShip(TYPE_OF_SHIP.DESTROYER, Battlefield.DESTROYERS_COUNT);
//      placeShip(TYPE_OF_SHIP.TORPEDO_BOAT, Battlefield.TORPEDO_BOATS_COUNT);
    }

    public abstract boolean shoot();

    public boolean isWinner() {
        return enemyBattlefield.getShips().size() == 0;
    }

    public Battlefield getPlayerBattlefield() {
        return playerBattlefield;
    }
}
