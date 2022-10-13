package logic.ship;

import logic.Battlefield;
import logic.Cell;

import java.util.ArrayList;
import java.util.List;
import logic.ship.ShipConstants.DIRECTION;

public abstract class Ship {

    public class LocationParams{
        ShipConstants.DIRECTION dir;
        Cell startCell;
        ShipConstants.TYPE_OF_SHIP type;

        public LocationParams(ShipConstants.DIRECTION dir, Cell startCell, ShipConstants.TYPE_OF_SHIP type) {
            this.dir = dir;
            this.startCell = startCell;
            this.type = type;
        }

        public ShipConstants.DIRECTION getDir() {
            return dir;
        }

        public Cell getStartCell() {
            return startCell;
        }

        public ShipConstants.TYPE_OF_SHIP getType() {
            return type;
        }
    }
    private Cell[] shipBody;//
    private List<Cell> borders;
    private Battlefield shipBattlefield;//
    private int hp;//
    private final int length;//
    private final Cell startCell;//
    private DIRECTION direction;//

    public Ship(DIRECTION dir, Cell startCell, Battlefield battlefield, int length) {

        this.length = length;
        shipBody = new Cell[length];
        hp=length;
        this.startCell = startCell;
        this.shipBattlefield = battlefield;
        this.direction = dir;

        Cell[][] cellTable = this.shipBattlefield.getTable();

        switch (dir) {
            case TOP -> {
                int j = 0;
                for (int i = startCell.getY(); i > startCell.getY() - length; i--) {
                    cellTable[i][startCell.getX()].setType(Cell.typeOfCell.SHIP);
                    cellTable[i][startCell.getX()].setShip(this);
                    shipBody[j] = cellTable[i][startCell.getX()];
                    j++;
                }
            }
            case RIGHT -> {
                int j = 0;
                for (int i = startCell.getX(); i < startCell.getX() + length; i++) {
                    cellTable[startCell.getY()][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startCell.getY()][i];
                    cellTable[startCell.getY()][i].setShip(this);
                    j++;
                }
            }
            case LEFT -> {
                int j = 0;
                for (int i = startCell.getX(); i > startCell.getX() - length; i--) {
                    cellTable[startCell.getY()][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startCell.getY()][i];
                    cellTable[startCell.getY()][i].setShip(this);
                    j++;
                }
            }
            case BOTTOM -> {
                int j = 0;
                for (int i = startCell.getY(); i < startCell.getY() + length; i++) {
                    cellTable[i][startCell.getX()].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[i][startCell.getX()];
                    cellTable[i][startCell.getX()].setShip(this);
                    j++;
                }
            }
        }
        this.shipBattlefield.setTable(cellTable);
    }
    public int  getWound(Cell cell) {
        if (cell.blast()) {
            if (hp > 0) hp--;
        }
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
