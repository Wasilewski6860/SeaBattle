package logic;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    public enum TYPE_OF_SHIP {
        BATTLESHIP,
        CRUISER,
        DESTROYER,
        TORPEDO_BOAT
    }

    public enum DIRECTION {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    private Cell[] shipBody;//
    private List<Cell> borders;
    private Battlefield shipBattlefield;//
    private int hp;//
    private final Cell startCell;//
    private final TYPE_OF_SHIP type;//
    private final DIRECTION direction;//

    public Ship(TYPE_OF_SHIP type, DIRECTION dir, Cell startCell, Battlefield battlefield) {

        this.type = type;
        this.startCell = startCell;
        this.shipBattlefield = battlefield;
        this.direction = dir;

        Cell[][] cellTable = this.shipBattlefield.getTable();

        switch (type) {
            case BATTLESHIP -> {
                hp = 4;
                shipBody = new Cell[hp];
            }
            case CRUISER -> {
                hp = 3;
                shipBody = new Cell[hp];
            }
            case DESTROYER -> {
                hp = 2;
                shipBody = new Cell[hp];
            }
            case TORPEDO_BOAT -> {
                hp = 1;
                shipBody = new Cell[hp];
            }
        }


        switch (dir) {
            case TOP -> {
                int j = 0;
                for (int i = startCell.getY(); i > startCell.getY() - hp; i--) {
                    cellTable[i][startCell.getX()].setType(Cell.typeOfCell.SHIP);
                    cellTable[i][startCell.getX()].setShip(this);
                    shipBody[j] = cellTable[i][startCell.getX()];
                    j++;
                }
            }
            case RIGHT -> {
                int j = 0;
                for (int i = startCell.getX(); i < startCell.getX() + hp; i++) {
                    cellTable[startCell.getY()][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startCell.getY()][i];
                    cellTable[startCell.getY()][i].setShip(this);
                    j++;
                }
            }
            case LEFT -> {
                int j = 0;
                for (int i = startCell.getX(); i > startCell.getX() - hp; i--) {
                    cellTable[startCell.getY()][i].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[startCell.getY()][i];
                    cellTable[startCell.getY()][i].setShip(this);
                    j++;
                }
            }
            case BOTTOM -> {
                int j = 0;
                for (int i = startCell.getY(); i < startCell.getY() + hp; i++) {
                    cellTable[i][startCell.getX()].setType(Cell.typeOfCell.SHIP);
                    shipBody[j] = cellTable[i][startCell.getX()];
                    cellTable[i][startCell.getX()].setShip(this);
                    j++;
                }
            }
        }
        this.shipBattlefield.setTable(cellTable);
    }

    protected int  getWound(Cell cell) {
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

    public void setBorders(ArrayList<Cell> borders) {
        this.borders = borders;
    }

}
