package logic.ship;

import logic.Battlefield;
import logic.Cell;

public class ShipParams {
    ShipConstants.DIRECTION dir;
    Cell startCell;
    ShipConstants.TYPE_OF_SHIP type;

    public ShipParams(ShipConstants.DIRECTION dir, Cell startCell, ShipConstants.TYPE_OF_SHIP type) {
        this.dir = dir;
        this.startCell = startCell;
        this.type = type;
    }
}
