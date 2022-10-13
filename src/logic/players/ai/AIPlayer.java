package logic.players.ai;

import logic.Battlefield;
import logic.Cell;

import logic.players.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import logic.ship.ShipConstants.TYPE_OF_SHIP;
import logic.ship.ShipConstants.DIRECTION;

public abstract class AIPlayer extends Player {

    protected Cell target;
    protected Queue<Cell> preyBody;
    protected Queue<Cell> shelledCells;
    protected boolean isHunting;

    public AIPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);

        target = null;
        isHunting = false;
        preyBody = new LinkedList<>();
        shelledCells=new LinkedList<>();
    }

    @Override
    public  void placeShip(TYPE_OF_SHIP type, int count) {
        int iteration = 0;
        Random rnd = new Random();

        while (iteration < count) {
            int x = rnd.nextInt(10);
            int y = rnd.nextInt(10);
            DIRECTION dir = DIRECTION.TOP;
            int dirIntRnd = rnd.nextInt(3);

            if (dirIntRnd == 0) dir = DIRECTION.TOP;
            else if (dirIntRnd == 1) dir = DIRECTION.BOTTOM;
            else if (dirIntRnd == 2) dir = DIRECTION.RIGHT;
            else if (dirIntRnd == 3) dir = DIRECTION.LEFT;

            if (placeShip(x,y,type,dir)) iteration++;
        }
    }
    protected boolean randomShoot() {

        Random rnd = new Random();
        int x = rnd.nextInt(10);
        int y = rnd.nextInt(10);

        while (shelledCells.contains(enemyBattlefield.getCell(x,y))) {
            x = rnd.nextInt(10);
            y = rnd.nextInt(10);
        }

        if (enemyBattlefield.containsShip(x,y)) {
            preyBody.add(enemyBattlefield.getCell(x,y));
            target = preyBody.element();
            isHunting = true;
            System.out.println("An idiot detected a ship!");
        }
        shelledCells.add(enemyBattlefield.getCell(x,y));
        return enemyBattlefield.getShot(enemyBattlefield.getCell(x, y));
    }

    protected boolean simpleShoot(int deltaX, int deltaY) {
        Cell tempCell;
        if (target.getX() + deltaX >= 0 && target.getX() + deltaX <= enemyBattlefield.getTable().length - 1
                && target.getY() + deltaY >= 0 && target.getY() + deltaY <= enemyBattlefield.getTable().length - 1
                //     && table.getCell(mostWanted.getX()+deltaX,mostWanted.getY()+deltaY).blast()
                && !shelledCells.contains( enemyBattlefield.getCell( target.getX()+deltaX,target.getY()+deltaY))
        ) {

            tempCell = enemyBattlefield.getCell(target.getX() + deltaX, target.getY() + deltaY);
            if (enemyBattlefield.containsShip(tempCell.getX(),tempCell.getY())) {
                preyBody.add(tempCell);
                target = preyBody.element();
            }
            shelledCells.add(tempCell);
            enemyBattlefield.getShot(tempCell);
            return true;

        }
        return false;
    }

}
