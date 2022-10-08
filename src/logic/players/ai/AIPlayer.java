package logic.players.ai;

import logic.Battlefield;
import logic.Cell;
import logic.Ship;
import logic.ai.AI;
import logic.players.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class AIPlayer extends Player {

    protected Cell target;
    protected Queue<Cell> preyBody;
    protected boolean isHunting;

    public AIPlayer(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        super(playerBattlefield, enemyBattlefield);

        target = null;
        isHunting = false;
        preyBody = new LinkedList<>();
    }

    @Override
    public  void placeShip(Ship.TYPE_OF_SHIP type, int count) {
        int iteration = 0;
        Random rnd = new Random();

        while (iteration < count) {
            int x = rnd.nextInt(10);
            int y = rnd.nextInt(10);
            Ship.DIRECTION dir = Ship.DIRECTION.TOP;
            int dirIntRnd = rnd.nextInt(3);

            if (dirIntRnd == 0) dir = Ship.DIRECTION.TOP;
            else if (dirIntRnd == 1) dir = Ship.DIRECTION.BOTTOM;
            else if (dirIntRnd == 2) dir = Ship.DIRECTION.RIGHT;
            else if (dirIntRnd == 3) dir = Ship.DIRECTION.LEFT;

            if (placeShip(x,y,type,dir)) iteration++;
        }
    }
    protected boolean randomShoot() {

        Random rnd = new Random();
        int x = rnd.nextInt(10);
        int y = rnd.nextInt(10);

        Cell[][] cells = playerBattlefield.getTable();
        Cell cell = cells[y][x];

        while (cell.getType() == Cell.typeOfCell.SHELLED || cell.getType() == Cell.typeOfCell.SHIP_WRECKED) {
            x = rnd.nextInt(10);
            y = rnd.nextInt(10);
            cell = cells[y][x];
        }

        if (cell.getType() == Cell.typeOfCell.SHIP) {
            preyBody.add(cell);
            target = preyBody.element();
            isHunting = true;
            System.out.println("An idiot detected a ship!");
        }
        return playerBattlefield.getShot(playerBattlefield.getCell(x, y));
    }

    protected boolean simpleShoot(int deltaX, int deltaY) {
        Cell tempCell;
        if (target.getX() + deltaX >= 0 && target.getX() + deltaX <= playerBattlefield.getTable().length - 1
                && target.getY() + deltaY >= 0 && target.getY() + deltaY <= playerBattlefield.getTable().length - 1
                //     && table.getCell(mostWanted.getX()+deltaX,mostWanted.getY()+deltaY).blast()
                && (playerBattlefield.getCell(target.getX() + deltaX, target.getY() + deltaY).getType() != Cell.typeOfCell.SHELLED
                && playerBattlefield.getCell(target.getX() + deltaX, target.getY() + deltaY).getType() != Cell.typeOfCell.SHIP_WRECKED)
        ) {

            tempCell = playerBattlefield.getCell(target.getX() + deltaX, target.getY() + deltaY);
            if (tempCell.getType() == Cell.typeOfCell.SHIP) {
                preyBody.add(tempCell);
                target = preyBody.element();
            }
            playerBattlefield.getShot(tempCell);
            return true;

        }
        return false;
    }

}
