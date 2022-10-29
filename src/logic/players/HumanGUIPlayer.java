package logic.players;


import logic.Battlefield;
import logic.Coordinate;
import logic.TurnProviders.HumanGUITurnProvider;
import graphic.GraphicGameController;

public class HumanGUIPlayer extends Player{

    GraphicGameController gameController;
    public HumanGUIPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield, GraphicGameController gameController) {
        super(playerBattlefield, enemyBattlefield);
        this.gameController=gameController;
        provider  = new HumanGUITurnProvider(this,gameController);
    }

    @Override
    public boolean shoot() {
        Coordinate coordinateOfShot = provider.coordinateOfShoot();
        System.out.println("Shooting at"+ coordinateOfShot.getX()+" "+ coordinateOfShot.getY());
        return getEnemyBattlefield().getShot(getEnemyBattlefield().getCell(coordinateOfShot.getX(), coordinateOfShot.getY()));
    }
}

