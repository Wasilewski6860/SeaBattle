package logic.ship;

import logic.Battlefield;
import logic.Cell;
import logic.ship.ShipConstants.DIRECTION;
import logic.ship.ShipConstants.TYPE_OF_SHIP;

public class ShipChecker {

    private Battlefield battlefield;

    public ShipChecker(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public boolean check(TYPE_OF_SHIP type, DIRECTION dir, Cell startCell) {

        int length = 0;
        switch (type) {
            case BATTLESHIP -> length = 4;
            case CRUISER -> length = 3;
            case DESTROYER -> length = 2;
            case TORPEDO_BOAT -> length = 1;
        }
        if (checkForAccommodation(battlefield, length, dir, startCell)) if (checkForCollisions(battlefield, dir, startCell, length))  return true;

        return false;
    }

    private static boolean checkForAccommodation(Battlefield battlefield, int length, DIRECTION dir, Cell startCell) {
        switch (dir) {
            case TOP -> {
                // int j = 0;
                for (int i = startCell.getY(); i > startCell.getY() - length; i--) {
                    // System.out.println("i "+i+" ");
                    if (i < 0) return false;
                    //   j++;
                }
            }
            case RIGHT -> {
                //   int j = 0;
                for (int i = startCell.getX(); i < startCell.getX() + length; i++) {
                    if (i >= 10) return false;
                    //     j++;
                }
            }
            case LEFT -> {
                //   int j = 0;
                for (int i = startCell.getX(); i > startCell.getX() - length; i--) {
                    if (i < 0) return false;
                    //     j++;
                }
            }
            case BOTTOM -> {
                // int j = 0;
                for (int i = startCell.getY(); i < startCell.getY() + length; i++) {
                    if (i >= 10) return false;
                    //    j++;
                }
            }
        }
        return true;
    }

    private static boolean checkForCollisions(Battlefield battlefield,  DIRECTION dir, Cell startCell, int length) {
        //check for free of neighbour cells
        Cell[][] cellTable = battlefield.getTable();
        switch (dir) {
            case TOP -> {
                for (int i = startCell.getY(); i > startCell.getY() - length; i--) {
                    if (cellTable[i][startCell.getX()].getType() != Cell.typeOfCell.FREE) {
                        return false;
                    }
                    //  return   cellTable[i][startCell.getX()].getType() != Cell.typeOfCell.free;
                }
            }
            case RIGHT -> {
                for (int i = startCell.getX(); i < startCell.getX() + length; i++) {
                    if (cellTable[startCell.getY()][i].getType() != Cell.typeOfCell.FREE) {
                        return false;
                    }
                    //    return   cellTable[startCell.getY()][i].getType() != Cell.typeOfCell.free;
                }
            }
            case LEFT -> {
                for (int i = startCell.getX(); i > startCell.getX() - length; i--) {
                    if (cellTable[startCell.getY()][i].getType() != Cell.typeOfCell.FREE) {
                        // System.out.println("Collision!");
                        return false;
                    }
                    // return   cellTable[startCell.getY()][i].getType() != Cell.typeOfCell.free;
                }
            }
            case BOTTOM -> {
                for (int i = startCell.getY(); i < startCell.getY() + length; i++) {

                    if (cellTable[i][startCell.getX()].getType() != Cell.typeOfCell.FREE) {
                        //   System.out.println("Collision!");
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
