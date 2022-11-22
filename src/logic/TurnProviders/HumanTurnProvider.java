package logic.TurnProviders;

import console.CLI;
import logic.Coordinate;
import logic.players.Player;
import logic.ship.Ship;

public class HumanTurnProvider extends TurnProvider {
    public HumanTurnProvider(Player player) {
        super(player);
    }

    @Override
    public Ship.LocationParams locationParams() {
        return CLI.readShipParams(getPlayer());
    }

    @Override
    public Coordinate coordinateOfShoot() {
        return CLI.readShotParams(getPlayer());
    }
}
