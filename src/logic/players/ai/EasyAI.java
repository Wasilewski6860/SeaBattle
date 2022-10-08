package logic.players.ai;

import logic.Battlefield;

public class EasyAI extends AIPlayer{

    public EasyAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
    }

    @Override
    public boolean shoot() {
        return randomShoot();
    }
}
