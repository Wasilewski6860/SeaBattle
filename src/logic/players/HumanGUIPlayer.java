package logic.players;

import graphic.DrawPanel;
import logic.Battlefield;
import logic.Coordinate;
import logic.TurnProviders.HumanGUITurnProvider;

public class HumanGUIPlayer extends Player{

    DrawPanel dp;
    public HumanGUIPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield, DrawPanel dp) {
        super(playerBattlefield, enemyBattlefield);
        this.dp=dp;
        provider  = new HumanGUITurnProvider(this,dp);
    }

    @Override
    public boolean shoot() {
        Coordinate coordinateOfShot = provider.coordinateOfShoot();
        System.out.println("Shooting at"+ coordinateOfShot.getX()+" "+ coordinateOfShot.getY());
        return getEnemyBattlefield().getShot(getEnemyBattlefield().getCell(coordinateOfShot.getX(), coordinateOfShot.getY()));
    }
}

