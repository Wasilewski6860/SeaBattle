package logic.ship;

import java.util.ArrayList;
import java.util.List;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;

public class BorderPlacer {

    private Battlefield battlefield;

    public List<Cell> setBorders(Ship ship) {

        List<Cell> list = new ArrayList<>();
        Cell[] shipBody = ship.getShipBody();

        for (Cell shipDeck : shipBody) {
            if (shipDeck.getX() != 0) {
                setBorder(list, shipDeck, 0, -1);
                if (shipDeck.getY() != 0) setBorder(list, shipDeck, -1, -1);
                if (shipDeck.getY() != battlefield.getTable().length - 1) setBorder(list, shipDeck, 1, -1);
            }
            if (shipDeck.getX() != battlefield.getTable().length - 1) {
                setBorder(list, shipDeck, 0, 1);
                if (shipDeck.getY() != 0) setBorder(list, shipDeck, -1, 1);
                if (shipDeck.getY() != battlefield.getTable().length - 1) setBorder(list, shipDeck, 1, 1);
            }
            if (shipDeck.getY() != 0) setBorder(list, shipDeck, -1, 0);
            if (shipDeck.getY() != battlefield.getTable().length - 1) setBorder(list, shipDeck, 1, 0);
        }
        ship.setBorders(list);
        return list;
    }

    public List<Cell> resetBorders(Ship ship) {
        for (Cell borderCell : ship.getBorders()) borderCell.setType(Cell.typeOfCell.SHELLED);
        return ship.getBorders();
    }

    private Cell setBorder(List<Cell> list, Cell shipDeck, int deltaY, int deltaX) {

        Cell cell = battlefield.getTable()[shipDeck.getY() + deltaY][shipDeck.getX() + deltaX];
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
