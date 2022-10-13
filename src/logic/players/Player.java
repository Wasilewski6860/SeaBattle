package logic.players;

import logic.Battlefield;
import logic.ship.ShipConstants.TYPE_OF_SHIP;
import logic.ship.ShipConstants.DIRECTION;

public abstract class Player {
    public Battlefield playerBattlefield;
    public Battlefield enemyBattlefield;



    public Player(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        this.playerBattlefield = playerBattlefield;
        this.enemyBattlefield = enemyBattlefield;
    }

    public abstract void placeShip(TYPE_OF_SHIP type, int count);

    public boolean placeShip(int x, int y, TYPE_OF_SHIP type, DIRECTION direction) {
        return playerBattlefield.placeShip(type, direction, playerBattlefield.getCell(x, y));
    }

    public void placeShips() {
        placeShip(TYPE_OF_SHIP.BATTLESHIP, Battlefield.BATTLE_SHIPS_COUNT);
        placeShip(TYPE_OF_SHIP.CRUISER, Battlefield.CRUISERS_COUNT);
//        placeShip(TYPE_OF_SHIP.DESTROYER, Battlefield.DESTROYERS_COUNT);
//        placeShip(TYPE_OF_SHIP.TORPEDO_BOAT, Battlefield.TORPEDO_BOATS_COUNT);
    }

    public abstract boolean shoot();

    public boolean isWinner(){
        return enemyBattlefield.getShips().size() == 0;
    }
    public Battlefield getPlayerBattlefield() {
        return playerBattlefield;
    }
}
