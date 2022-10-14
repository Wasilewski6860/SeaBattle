package logic.TurnProviders;

import console.CLI;
import logic.Coordinate;
import logic.TurnProviders.TurnProvider;
import logic.players.Player;
import logic.ship.Ship;
import logic.ship.ShipChecker;
import logic.ship.ShipConstants;

import java.util.Random;

public class AITurnProvider extends TurnProvider {
    public AITurnProvider(Player player) {
        super(player);
    }

    @Override
    public Ship.LocationParams locationParams() {
        Random rnd = new Random();

            int x = rnd.nextInt(10);
            int y = rnd.nextInt(10);
            ShipConstants.DIRECTION dir = ShipConstants.DIRECTION.TOP;
            int dirIntRnd = rnd.nextInt(3);

            if (dirIntRnd == 0) dir = ShipConstants.DIRECTION.TOP;
            else if (dirIntRnd == 1) dir = ShipConstants.DIRECTION.BOTTOM;
            else if (dirIntRnd == 2) dir = ShipConstants.DIRECTION.RIGHT;
            else if (dirIntRnd == 3) dir = ShipConstants.DIRECTION.LEFT;

            return new Ship.LocationParams(dir,getPlayer().getPlayerBattlefield().getCell(x,y));

    }

    @Override
    public Coordinate coordinateOfShoot() {
        Random rnd = new Random();
        int x = rnd.nextInt(10);
        int y = rnd.nextInt(10);

        while (!getPlayer().getEnemyBattlefield().isShootable(x,y)) {
            x = rnd.nextInt(10);
            y = rnd.nextInt(10);
        }
        return new Coordinate(x,y);
    }
}
