package logic;

import graphic.DrawUtils;
import graphic.Drawable;

import java.awt.*;
import logic.ship.Ship;

public class Cell implements Drawable  {

    @Override
    public void draw(Graphics2D g2d,int width,int height, boolean isWarFog) {
        DrawUtils.drawCell( g2d,   this,width,height, isWarFog);
    }
    public enum typeOfCell {
        SHELLED,
        SHIP_WRECKED,
        FREE,
        SHIP,
        SHIP_ZONE
    }

    private Ship ship;

    private final int x,y;
    private typeOfCell type;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        type = typeOfCell.FREE;
        ship = null;
    }

    //Return true when cell is ship
    //Another variant is to return true
    public boolean blast() {

        switch (type) {
            case FREE, SHIP_ZONE -> {
                type = typeOfCell.SHELLED;
                return false;
            }
            case SHIP -> {
                type = typeOfCell.SHIP_WRECKED;
                return true;
            }
            case SHELLED -> {
                return false;
            }
        }

        return false;
    }


    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public typeOfCell getType() {
        return type;
    }

    public void setType(typeOfCell type) {
        this.type = type;
    }


}
