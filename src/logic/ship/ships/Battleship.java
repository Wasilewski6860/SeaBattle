package logic.ship.ships;


import logic.Battlefield;
import logic.Cell;
import logic.ship.Ship;
import logic.ship.ShipConstants;
import logic.ship.ShipConstants.DIRECTION;
import logic.ship.ShipConstants.*;

public class Battleship extends Ship {


    public Battleship(DIRECTION dir, Cell startCell, Battlefield battlefield) {
        super(dir, startCell, battlefield, ShipConstants.BATTLESHIP_LENGTH);
    }

}
