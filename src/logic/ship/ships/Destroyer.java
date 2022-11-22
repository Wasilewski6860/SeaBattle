package logic.ship.ships;

import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;

public class Destroyer extends Ship {


    public Destroyer(LocationParams location, Battlefield battlefield) {
        super(location, battlefield, ShipConstants.DESTROYER_LENGTH);
    }
}
