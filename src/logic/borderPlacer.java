package logic;

import java.util.ArrayList;
import java.util.List;

public class borderPlacer {

   private Battlefield battlefield;

    public List<Cell> setBorders(Ship ship) {

        Cell[][] tableForOverride = battlefield.getTable();
        ArrayList<Cell> list = new ArrayList<>();

        Cell[] shipBody = ship.getShipBody();

        for (Cell shipDeck : shipBody) {

            if (shipDeck.getX() != 0) {
                setBorder(tableForOverride, list, shipDeck, 0, -1);
                if (shipDeck.getY() != 0) {
                    setBorder(tableForOverride, list, shipDeck, -1, -1);
                }
                if (shipDeck.getY() != tableForOverride.length - 1) {
                    setBorder(tableForOverride, list, shipDeck, 1, -1);
                }
            }
            if (shipDeck.getX() != tableForOverride.length - 1) {
                setBorder(tableForOverride, list, shipDeck, 0, 1);
                if (shipDeck.getY() != 0) {
                    setBorder(tableForOverride, list, shipDeck, -1, 1);
                }
                if (shipDeck.getY() != tableForOverride.length - 1) {
                    setBorder(tableForOverride, list, shipDeck, 1, 1);
                }
            }
            if (shipDeck.getY() != 0) {
                setBorder(tableForOverride, list, shipDeck, -1, 0);
            }
            if (shipDeck.getY() != tableForOverride.length - 1) {
                setBorder(tableForOverride, list, shipDeck, 1, 0);
            }

        }
        battlefield.setTable(tableForOverride);
        ship.setBorders(list);
        return list;
    }

    private void setBorder(Cell[][] tableForOverride, ArrayList<Cell> list, Cell shipDeck, int deltaY, int deltaX) {

        Cell cell = tableForOverride[shipDeck.getY() + deltaY][shipDeck.getX() + deltaX];
        if (cell.getType() != Cell.typeOfCell.SHIP) {
            cell.setType(Cell.typeOfCell.SHIP_ZONE);
            list.add(cell);
        }
    }


    private static boolean checkForAccommodation(Battlefield battlefield, int length, Ship.DIRECTION dir, Cell startCell) {
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

    private static boolean checkForCollisions(Battlefield battlefield, Ship.TYPE_OF_SHIP type, Ship.DIRECTION dir, Cell startCell, int length) {
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

        battlefield.setTable(cellTable);
        return true;
    }

    public borderPlacer(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

}
