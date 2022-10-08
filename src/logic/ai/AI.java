package logic.ai;

import logic.Cell;
import logic.Ship;
import logic.Battlefield;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class AI {

    protected enum typeOfSearching {
        SEARCHING,
        RIGHT,
        LEFT,
        TOP,
        BOTTOM
    }

    protected Cell target;
    protected Queue<Cell> preyBody;
    protected boolean isHunting;
    protected Battlefield playerBattlefield;
    private Battlefield enemyBattlefield;
    protected typeOfSearching type;

    public AI(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        target = null;
        isHunting = false;
        this.playerBattlefield = playerBattlefield;
        this.enemyBattlefield = enemyBattlefield;
        preyBody = new LinkedList<>();
        type = typeOfSearching.SEARCHING;
    }

    public void placeShip(Ship.TYPE_OF_SHIP type, int count) {
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

            if (enemyBattlefield.placeShip(type, dir, enemyBattlefield.getCell(x, y))) iteration++;
        }
    }



    public void placeShips() {
        placeShip(Ship.TYPE_OF_SHIP.BATTLESHIP, 1);
        placeShip(Ship.TYPE_OF_SHIP.CRUISER, 2);
        placeShip(Ship.TYPE_OF_SHIP.DESTROYER, 3);
        placeShip(Ship.TYPE_OF_SHIP.TORPEDO_BOAT, 4);
    }



    public abstract boolean shoot();

    protected boolean randomShoot() {

        System.out.println("    Idiot didnt found a ship(   ");
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


    public typeOfSearching getType() {
        return type;
    }

    public void setType(typeOfSearching type) {
        this.type = type;
    }
}