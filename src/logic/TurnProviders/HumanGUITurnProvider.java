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
        int x = gameController.getSelectedX();
        int y = gameController.getSelectedY();
        ShipConstants.DIRECTION dir = gameController.getSelectedDir();

        return new Ship.LocationParams(dir,getPlayer().getPlayerBattlefield().getCell(x,y));
    }

    @Override
    public Coordinate coordinateOfShoot() {
        int x = gameController.getSelectedX();
        int y = gameController.getSelectedY();
        return new Coordinate(x,y);
    }
}
