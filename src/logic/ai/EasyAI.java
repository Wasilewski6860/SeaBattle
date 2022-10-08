package logic.ai;

import logic.Battlefield;

public class EasyAI extends AI {

    public EasyAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
    }

    @Override
    public boolean shoot() {
       return randomShoot();
    }


}
