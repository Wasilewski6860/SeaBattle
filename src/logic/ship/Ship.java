package logic.ship;

import logic.Battlefield;
import logic.Cell;

import java.util.ArrayList;
import java.util.List;

import logic.ship.ShipConstants.DIRECTION;

public class Ship {

    public static class LocationParams {
        ShipConstants.DIRECTION dir;
        Cell startCell;


        public LocationParams(ShipConstants.DIRECTION dir, Cell startCell) {
            this.dir = dir;
            this.startCell = startCell;
        }

        public ShipConstants.DIRECTION getDir() {
            return dir;
        }

        public Cell getStartCell() {
            return startCell;
        }
    }

    private Cell[] shipBody;//
    private List<Cell> borders;
    private Battlefield shipBattlefield;//
    private int hp;//
    private final int length;//
    private LocationParams location;

    public Ship(LocationParams location, Battlefield battlefield, int length) {

        this.length = length;
        shipBody = new Cell[length];
        hp = length;
        shipBattlefield = battlefield;

        Cell[][] cellTable = shipBattlefield.getTable();

        int startPosY = location.getStartCell().getY();
        int startPosX = location.getStartCell().getX();
        switch (location.getDir()) {
            case TOP -> {
                int j = 0;
                for (int i = startPosY; i > startPosY - length; i--) {
                    cellTable[i][startPosX].setType(Cell.typeOfCell.SHIP);
                    cellTable[i][startPosX].setShip(this);
                    shipBody[j] = cellTable[i][startPosX];
                    j++;
                }
            }
            case RIGHT -> {
                int j = 0;
                for (int i = startPosX; i < startPosX + length; i++) {
                    cellTable[startPosY][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startPosY][i];
                    cellTable[startPosY][i].setShip(this);
                    j++;
                }
            }
            case LEFT -> {
                int j = 0;
                for (int i = startPosX; i > startPosX - length; i--) {
                    cellTable[startPosY][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startPosY][i];
                    cellTable[startPosY][i].setShip(this);
                    j++;
                }
            }
            case BOTTOM -> {
                int j = 0;
                for (int i = startPosY; i < startPosY + length; i++) {
                    cellTable[i][startPosX].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[i][startPosX];
                    cellTable[i][startPosX].setShip(this);
                    j++;
                }
            }
        }
        this.shipBattlefield.setTable(cellTable);
    }

    public int getWound(Cell cell) {
        if (cell.blast()) if (hp > 0) hp--;
        return hp;
    }

    public Cell[] getShipBody() {
        return shipBody;
    }

    public int getHp() {
        return hp;
    }

    public List<Cell> getBorders() {
        return borders;
    }

    public void setBorders(List<Cell> borders) {
        this.borders = borders;
    }

}
