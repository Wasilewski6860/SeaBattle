package logic.ship.ships;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;

public class Cruiser extends Ship {


    public Cruiser(DIRECTION dir, Cell startCell, Battlefield battlefield) {
        super(dir, startCell, battlefield, ShipConstants.CRUISER_LENGTH);
    }
}
