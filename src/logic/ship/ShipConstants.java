package logic.ship;

public class ShipConstants {

    public enum TYPE_OF_SHIP {
        BATTLESHIP,
        CRUISER,
        DESTROYER,
        TORPEDO_BOAT
    }
    public static final int BATTLESHIP_LENGTH=4;
    public static final int CRUISER_LENGTH=3;
    public static final int DESTROYER_LENGTH=2;
    public static final int TORPEDO_BOAT_LENGTH=1;

    public enum DIRECTION {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

}
