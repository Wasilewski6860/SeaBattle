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
