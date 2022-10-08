package logic.ai;

import logic.Battlefield;

public class NormalAI extends AI{

    public NormalAI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);
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
