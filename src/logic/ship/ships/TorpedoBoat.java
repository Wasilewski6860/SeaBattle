package logic.ship.ships;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;

public class TorpedoBoat extends Ship {


    public TorpedoBoat(LocationParams location, Battlefield battlefield) {
        super(location, battlefield, ShipConstants.TORPEDO_BOAT_LENGTH);
    }
}
