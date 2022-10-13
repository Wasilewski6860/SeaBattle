package logic.ship.ships;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;

public class TorpedoBoat extends Ship {


    public TorpedoBoat(DIRECTION dir, Cell startCell, Battlefield battlefield) {
        super(dir, startCell, battlefield, ShipConstants.TORPEDO_BOAT_LENGTH);
    }
}
