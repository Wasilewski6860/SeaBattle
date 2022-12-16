package logic.players.ai;

import logic.Battlefield;
import logic.TurnProviders.NormalAITurnProvider;

import java.awt.geom.Point2D;

public class NormalAI extends AIPlayer {

    public NormalAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
        provider = new NormalAITurnProvider(this);
    }

    public boolean smartShoot(){
        if (isHunting) {

            boolean isShooted = false;

            if (!isShooted) isShooted = simpleShoot(-1, 0);
            if (!isShooted) isShooted = simpleShoot(0, 1);
            if (!isShooted) isShooted = simpleShoot(1, 0);
            if (!isShooted) isShooted = simpleShoot(0, -1);

            if (!isShooted){
                preyBody.remove();
                if (preyBody.size()!=0)     target = preyBody.element();
                if (preyBody.size()==0){
                    isHunting = false;
                }
            }
            return isShooted;
        }
        else return super.randomShoot();
    }
    @Override
    public boolean shoot() {
        //boolean t = randomShoot();
        while (smartShoot());
        return false;
    }
}
