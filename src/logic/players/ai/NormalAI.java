package logic.players.ai;

import logic.Battlefield;
import logic.TurnProviders.AITurnProvider;
import logic.TurnProviders.NormalAITurnProvider;
import logic.TurnProviders.TurnProvider;
import logic.players.Player;

public class NormalAI extends AIPlayer {

    public NormalAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
        provider = new NormalAITurnProvider(this);
    }

    @Override
    public boolean shoot() {

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
}
