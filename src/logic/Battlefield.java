package logic;

import java.util.ArrayList;
import java.util.List;

import static logic.Ship.TYPE_OF_SHIP;
import static logic.Ship.DIRECTION;

public class Battlefield {

    private Cell[][] table;
    private List<Ship> ships;
    private final borderPlacer borderPlacer;
    private final ShipChecker shipChecker;

    public static final int BATTLE_SHIPS_COUNT = 1;
    public static final int CRUISERS_COUNT = 2;
    public static final int DESTROYERS_COUNT = 3;
    public static final int TORPEDO_BOATS_COUNT = 4;

    private static final int TABLE_HEIGHT = 10;
    private static final int TABLE_WIDTH = 10;

    public Battlefield() {

        this.table = new Cell[TABLE_HEIGHT][TABLE_WIDTH];
        this.borderPlacer = new borderPlacer(this);
        this.shipChecker = new ShipChecker(this);

        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = new Cell(j, i);

        this.ships = new ArrayList<>();
    }

    public boolean placeShip(final TYPE_OF_SHIP type, final DIRECTION dir, final Cell startCell) {

        if (shipChecker.check(type, dir, startCell)) {
            Ship ship = new Ship(type, dir, startCell, this);
            ships.add(ship);
            borderPlacer.setBorders(ship);
            return true;
        }
        return false;
    }

    public Cell getCell(int x, int y) {
        return table[y][x];
    }

    public Cell[][] getTable() {
        return table;
    }

    public void setTable(Cell[][] table) {
        this.table = table;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean getShot(Cell cell) {
        //    List<Ship> tempShip = ships;
        Ship ship = cell.getShip();
       // boolean isSuccessful = false;

        if (ship != null) {
            // System.out.println("Table ship shot");
         //   isSuccessful = true;
            ship.getWound(cell);
            if (ship.getHp() == 0) {
                //  System.out.println("Table ship died");
                for (Cell borderCell : ship.getBorders()) {
                    borderCell.setType(Cell.typeOfCell.SHELLED);
                }
                ships.remove(ship);
            }
            return true;
        } else cell.blast();
        //return isSuccessful;
        return false;
    }

}