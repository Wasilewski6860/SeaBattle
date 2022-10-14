package logic.TurnProviders;

import console.CLI;
import logic.Coordinate;
import logic.players.Player;
import logic.ship.Ship;

public abstract  class   TurnProvider {

    private Player player;
    public TurnProvider( Player player) {
        this.player=player;
    }

    public abstract Ship.LocationParams locationParams();
    public abstract Coordinate coordinateOfShoot();

    public Player getPlayer() {
        return player;
    }
}
