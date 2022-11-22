package logic.ship;

import logic.Battlefield;
import logic.Cell;
import logic.ship.ShipConstants.DIRECTION;

public class ShipChecker {

    //private Battlefield battlefield;

    // public ShipChecker(Battlefield battlefield) {
    //     this.battlefield = battlefield;
    // }

    public boolean check(Ship.LocationParams location, int length, Battlefield battlefield) {

        if (checkForAccommodation(length, location)) if (checkForCollisions(battlefield, location, length)) return true;

        return false;
    }

    private static boolean checkForAccommodation(int length, Ship.LocationParams location) {
        int startPosY = location.getStartCell().getY();
        int startPosX = location.getStartCell().getX();
        switch (location.getDir()) {
            case TOP -> {
                // int j = 0;
                for (int i = startPosY; i > startPosY - length; i--) {
                    // System.out.println("i "+i+" ");
                    if (i < 0) return false;
                    //   j++;
                }
            }
            case RIGHT -> {
                //   int j = 0;
                for (int i = startPosX; i < startPosX + length; i++) {
                    if (i >= 10) return false;
                    //     j++;
                }
            }
            case LEFT -> {
                //   int j = 0;
                for (int i = startPosX; i > startPosX - length; i--) {
                    if (i < 0) return false;
                    //     j++;
                }
            }
            case BOTTOM -> {
                // int j = 0;
                for (int i = startPosY; i < startPosY + length; i++) {
                    if (i >= 10) return false;
                    //    j++;
                }
            }
        }
        return true;
    }

    private static boolean checkForCollisions(Battlefield battlefield, Ship.LocationParams location, int length) {
        //check for free of neighbour cells
        Cell[][] cellTable = battlefield.getTable();
        int startPosY = location.getStartCell().getY();
        int startPosX = location.getStartCell().getX();
        switch (location.getDir()) {
            case TOP -> {
                for (int i = startPosY; i > startPosY - length; i--) {
                    if (cellTable[i][startPosX].getType() != Cell.typeOfCell.FREE) {
                        return false;
                    }
                    //  return   cellTable[i][startPosX].getType() != Cell.typeOfCell.free;
                }
            }
            case RIGHT -> {
                for (int i = startPosX; i < startPosX + length; i++) {
                    if (cellTable[startPosY][i].getType() != Cell.typeOfCell.FREE) {
                        return false;
                    }
                    //    return   cellTable[startPosY][i].getType() != Cell.typeOfCell.free;
                }
            }
            case LEFT -> {
                for (int i = startPosX; i > startPosX - length; i--) {
                    if (cellTable[startPosY][i].getType() != Cell.typeOfCell.FREE) {
                        // System.out.println("Collision!");
                        return false;
                    }
                    // return   cellTable[startPosY][i].getType() != Cell.typeOfCell.free;
                }
            }
            case BOTTOM -> {
                for (int i = startPosY; i < startPosY + length; i++) {

                    if (cellTable[i][startPosX].getType() != Cell.typeOfCell.FREE) {
                        //   System.out.println("Collision!");
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
