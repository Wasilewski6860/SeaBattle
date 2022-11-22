package logic.players.ai;

import logic.Battlefield;
import logic.TurnProviders.AITurnProvider;
import logic.TurnProviders.TurnProvider;

public class EasyAI extends AIPlayer{

    public EasyAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
        provider = new AITurnProvider(this);
    }

    @Override
    public boolean shoot() {
        while (randomShoot());
        return false;
    }
}
