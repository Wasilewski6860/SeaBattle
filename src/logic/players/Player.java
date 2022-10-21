package logic.players;

import logic.Battlefield;
import logic.TurnProviders.TurnProvider;
import logic.ship.Ship;
import logic.ship.ShipConstants;

public abstract class Player {
    private Battlefield playerBattlefield;
    private Battlefield enemyBattlefield;
    public TurnProvider provider;

    public Player(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        this.playerBattlefield = playerBattlefield;
        this.enemyBattlefield = enemyBattlefield;
    }

    public void placeShipsOfCertainType(int length, int count) {
        int iteration = 0;
        while (iteration < count) {
            if (placeShip(provider.locationParams(), length)) iteration++;
        }
    }

    public boolean placeShip(Ship.LocationParams location, int length) {
        return playerBattlefield.placeShip(length, location);
    }

    public void placeShips() {

        placeShipsOfCertainType(ShipConstants.BATTLESHIP_LENGTH, Battlefield.BATTLE_SHIPS_COUNT);
        placeShipsOfCertainType(ShipConstants.CRUISER_LENGTH, Battlefield.CRUISERS_COUNT);
//      placeShip(TYPE_OF_SHIP.DESTROYER, Battlefield.DESTROYERS_COUNT);
//      placeShip(TYPE_OF_SHIP.TORPEDO_BOAT, Battlefield.TORPEDO_BOATS_COUNT);
    }

    public abstract boolean shoot();
    public boolean placeShip(){
        switch (this.getPlayerBattlefield().getShips().size()){
            case 0->{
                this.placeShip(this.provider.locationParams(), ShipConstants.BATTLESHIP_LENGTH);
                return false;
            }
            case 1 ->{
                this.placeShip(this.provider.locationParams(), ShipConstants.CRUISER_LENGTH);
                return false;
            }
            case 2 ->{
                this.placeShip(this.provider.locationParams(), ShipConstants.CRUISER_LENGTH);
                return true;
            }
//            case 3, 4, 5 ->{
//                this.placeShip(this.provider.locationParams(), ShipConstants.DESTROYER_LENGTH);
//                return false;
//            }
//            case 6, 7, 8, 9 ->{
//                this.placeShip(this.provider.locationParams(), ShipConstants.TORPEDO_BOAT_LENGTH);
//                return false;
//            }
            default -> {return true;}
        }
    }

    public boolean isWinner() {
        return enemyBattlefield.getShips().size() == 0;
    }

    public Battlefield getPlayerBattlefield() {
        return playerBattlefield;
    }

    public Battlefield getEnemyBattlefield() {
        return enemyBattlefield;
    }

    public void setProvider(TurnProvider provider) {
        this.provider = provider;
    }
}

