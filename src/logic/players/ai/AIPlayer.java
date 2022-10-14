package logic.players.ai;

import logic.Battlefield;
import logic.Cell;

import logic.Coordinate;
import logic.TurnProviders.AITurnProvider;
import logic.TurnProviders.HumanTurnProvider;
import logic.TurnProviders.TurnProvider;
import logic.players.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import logic.ship.Ship;
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
        provider = new AITurnProvider(this);
    }

    protected boolean randomShoot() {

        Coordinate coordinate = provider.coordinateOfShoot();
        if (enemyBattlefield.containsShip( coordinate.getX(), coordinate.getY())) {
            preyBody.add(enemyBattlefield.getCell(coordinate.getX(), coordinate.getY()));
            target = preyBody.element();
            isHunting = true;
        }
        shelledCells.add(enemyBattlefield.getCell(coordinate.getX(), coordinate.getY()));
        return enemyBattlefield.getShot(enemyBattlefield.getCell(coordinate.getX(), coordinate.getY()));
    }

    protected boolean simpleShoot(int deltaX, int deltaY) {
        Cell tempCell;
        int currentX = target.getX() + deltaX;
        int currentY = target.getY() + deltaY;
        if (currentX >= 0 && currentX <= enemyBattlefield.getTable().length - 1
                && currentY >= 0 && currentY <= enemyBattlefield.getTable().length - 1
                //     && table.getCell(mostWanted.getX()+deltaX,mostWanted.getY()+deltaY).blast()
                && !shelledCells.contains( enemyBattlefield.getCell( currentX,currentY))
        ) {

            tempCell = enemyBattlefield.getCell(currentX, currentY);
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
