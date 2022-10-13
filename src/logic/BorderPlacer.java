package logic;

import java.util.ArrayList;
import java.util.List;

public class BorderPlacer {

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

    public List<Cell> resetBorders(Ship ship) {

        for (Cell borderCell : ship.getBorders()) {
            borderCell.setType(Cell.typeOfCell.SHELLED);
        }

        return ship.getBorders();
    }

    private Cell setBorder(Cell[][] tableForOverride, ArrayList<Cell> list, Cell shipDeck, int deltaY, int deltaX) {

        Cell cell = tableForOverride[shipDeck.getY() + deltaY][shipDeck.getX() + deltaX];
        if (cell.getType() != Cell.typeOfCell.SHIP) {
            cell.setType(Cell.typeOfCell.SHIP_ZONE);
            list.add(cell);
        }
        return cell;
    }


    public BorderPlacer(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

}
