package logic;

import java.util.ArrayList;
import java.util.List;


import logic.ship.BorderPlacer;
import logic.ship.Ship;
import logic.ship.ShipChecker;

public class Battlefield {

    private Cell[][] table;
    private List<Ship> ships;
    private final BorderPlacer borderPlacer;
    private final ShipChecker shipChecker;

    public static final int BATTLE_SHIPS_COUNT = 1;
    public static final int CRUISERS_COUNT = 2;
    public static final int DESTROYERS_COUNT = 3;
    public static final int TORPEDO_BOATS_COUNT = 4;

    private static final int TABLE_HEIGHT = 10;
    private static final int TABLE_WIDTH = 10;

    public Battlefield() {

        this.table = new Cell[TABLE_HEIGHT][TABLE_WIDTH];
        this.borderPlacer = new BorderPlacer(this);
        this.shipChecker = new ShipChecker();

        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = new Cell(j, i);

        this.ships = new ArrayList<>();
    }

    public boolean placeShip(int length, Ship.LocationParams location) {


        if (shipChecker.check(location, length, this)) {
            Ship ship = new Ship(location, this, length);
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

    public boolean isShootable(int x, int y) {
        Cell cell = getCell(x, y);
        return cell.getType() != Cell.typeOfCell.SHELLED && cell.getType() != Cell.typeOfCell.SHIP_WRECKED;
    }

    public boolean containsShip(int x, int y) {
        Cell cell = getCell(x, y);
        return cell.getType() == Cell.typeOfCell.SHIP;
    }

    public boolean getShot(Cell cell) {
        //    List<Ship> tempShip = ships;
        Ship ship = cell.getShip();
        // boolean isSuccessful = false;

        if (ship != null) {
            // System.out.println("Table ship shot");
            //   isSuccessful = true;
            int currentShipHp = ship.getWound(cell);
            if (currentShipHp == 0) {
                //  System.out.println("Table ship died");
                borderPlacer.resetBorders(ship);
                ships.remove(ship);
            }
            return true;
        } else cell.blast();
        //return isSuccessful;
        return false;
    }

}