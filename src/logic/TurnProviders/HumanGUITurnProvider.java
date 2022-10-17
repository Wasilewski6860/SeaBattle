package logic.TurnProviders;

import graphic.DrawPanel;
import graphic.DrawUtils;
import logic.Coordinate;
import logic.players.Player;
import logic.ship.Ship;
import logic.ship.ShipConstants;

public class HumanGUITurnProvider extends TurnProvider{
    DrawPanel dp;
    public HumanGUITurnProvider(Player player, DrawPanel drawPanel) {
        super(player);
        dp = drawPanel;
    }

    @Override
    public Ship.LocationParams locationParams() {
        int x = dp.x/ DrawUtils.CELL_HORIZONTAL_SIZE;
        int y = dp.y/ DrawUtils.CELL_VERTICAL_SIZE;
        ShipConstants.DIRECTION dir = dp.dir;

        return new Ship.LocationParams(dir,getPlayer().getPlayerBattlefield().getCell(x,y));
    }

    @Override
    public Coordinate coordinateOfShoot() {
        int x = dp.x/ DrawUtils.CELL_HORIZONTAL_SIZE;
        int y = dp.y/ DrawUtils.CELL_VERTICAL_SIZE;
        return new Coordinate(x,y);
    }
}
