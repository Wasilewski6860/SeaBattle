package logic.ship.ships;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;

public class Cruiser extends Ship {


    public Cruiser(LocationParams location, Battlefield battlefield) {
        super(location, battlefield, ShipConstants.CRUISER_LENGTH);
    }
}
