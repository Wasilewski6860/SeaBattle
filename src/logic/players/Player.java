package logic.players;

import logic.Battlefield;
import logic.Ship;

import java.util.Random;
import java.util.Scanner;

public abstract class Player {
  public Battlefield playerBattlefield;
  public  Battlefield enemyBattlefield;

    public Player(Battlefield playerBattlefield, Battlefield enemyBattlefield) {
        this.playerBattlefield = playerBattlefield;
        this.enemyBattlefield = enemyBattlefield;
    }

    /*

                protected static void placeShips(Battlefield battlefield) {
                    placeShip(battlefield, Ship.TYPE_OF_SHIP.BATTLESHIP,Battlefield.BATTLE_SHIPS_COUNT);
                    placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER,Battlefield.CRUISERS_COUNT);
                    placeShip(battlefield, Ship.TYPE_OF_SHIP.DESTROYER,Battlefield.DESTROYERS_COUNT);
                    placeShip(battlefield, Ship.TYPE_OF_SHIP.TORPEDO_BOAT,Battlefield.TORPEDO_BOATS_COUNT);
                }

                private static void placeShip(Battlefield battlefield,Ship.TYPE_OF_SHIP type, int count){
                    System.out.println("Place "+type);
                    for (int i = 0; i < Battlefield.CRUISERS_COUNT; i++) {
                        while (!placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER)) {
                            placeShip(battlefield, Ship.TYPE_OF_SHIP.CRUISER);
                        }
                    }
                    printScreen();
                }

                protected static boolean placeShip(Battlefield battlefield, Ship.TYPE_OF_SHIP type) {

                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter direction:");
                    String strDirection = in.nextLine();
                    System.out.println("Your dir is " + strDirection);

                    System.out.println("Enter coordinates x,y:");
                    int x = in.nextInt();
                    int y = in.nextInt();
                    System.out.println(type + " coordinates is " + x + " " + y);


                    Ship.DIRECTION dir = switch (strDirection) {
                        case "left" -> Ship.DIRECTION.LEFT;
                        case "top" -> Ship.DIRECTION.TOP;
                        case "bottom" -> Ship.DIRECTION.BOTTOM;
                        default -> Ship.DIRECTION.RIGHT;
                    };

                    return battlefield.placeShip(type, dir, battlefield.getCell(x, y));
                }


                */
    public abstract void placeShip(Ship.TYPE_OF_SHIP type, int count);

    public  boolean placeShip(int x, int y, Ship.TYPE_OF_SHIP type, Ship.DIRECTION direction) {
        return playerBattlefield.placeShip(type,direction,playerBattlefield.getCell(x,y));
    }

    public void placeShips() {
        placeShip( Ship.TYPE_OF_SHIP.BATTLESHIP,Battlefield.BATTLE_SHIPS_COUNT);
        placeShip( Ship.TYPE_OF_SHIP.CRUISER,Battlefield.CRUISERS_COUNT);
     //   placeShip( Ship.TYPE_OF_SHIP.DESTROYER,Battlefield.DESTROYERS_COUNT);
      //  placeShip( Ship.TYPE_OF_SHIP.TORPEDO_BOAT,Battlefield.TORPEDO_BOATS_COUNT);
    }

    public abstract boolean shoot();
}
