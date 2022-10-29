package logic.TurnProviders;


import logic.Coordinate;
import logic.players.Player;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import graphic.GraphicGameController;

public class HumanGUITurnProvider extends TurnProvider{
    GraphicGameController gameController;
    public HumanGUITurnProvider(Player player, GraphicGameController gameController) {
        super(player);
        this.gameController = gameController;
    }

    @Override
    public Ship.LocationParams locationParams() {
        int x = gameController.selectedX;
        int y = gameController.selectedY;
        ShipConstants.DIRECTION dir = gameController.selectedDir;

        return new Ship.LocationParams(dir,getPlayer().getPlayerBattlefield().getCell(x,y));
    }

    @Override
    public Coordinate coordinateOfShoot() {
        int x = gameController.selectedX;
        int y = gameController.selectedY;
        return new Coordinate(x,y);
    }
}
