package graphic;

import logic.Cell;

import javax.swing.*;
import java.awt.*;

public class DrawUtils {

    private static final Image free = loadImage("assets/img/free.png");
    private static final Image shelled = loadImage("assets/img/shelled.png");
    private static final Image shipWrecked = loadImage("assets/img/shipWrecked.png");
    private static final Image ship =  loadImage("assets/img/ship.png");
    public static final int CELL_SIZE = 30;
    public static final int CELL_VERTICAL_SIZE = free.getHeight(null);
    public static final int CELL_HORIZONTAL_SIZE = free.getWidth(null);

    private static void drawImage(Graphics2D g2d,String path,int x,int y ,int width,int height){
        g2d.drawImage(new ImageIcon(path).getImage(), x, y,width,height,  null);
    }

    public static void drawCell(Graphics2D g2d, Cell cell,int width,int height, boolean isWarFog) {
        int x = cell.getX()*width;
        int y = cell.getY()*height;

        //  g2d.drawImage(free,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
        switch (cell.getType()){
            case SHIP -> {
                if (isWarFog) g2d.drawImage(free, x, y,width,height,  null);
                else {
                    switch (cell.getShip().getLength()){
                        case 4 ->{
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/img/battleship/battleship_bottom.png",  x,y,width,height );
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/img/battleship/battleship_right.png",  x,y,width,height );
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/img/battleship/battleship_left.png",  x,y,width,height );

                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/img/battleship/battleship_top.png",  x,y,width,height );

                                }
                            }
                        }
                        case 3 ->{
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/img/cruiser/cruiser_bottom.png",  x,y ,width,height);
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/img/cruiser/cruiser_right.png",  x,y ,width,height);
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/img/cruiser/cruiser_left.png",  x,y ,width,height);
                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/img/cruiser/cruiser_top.png",  x,y,width,height );
                                }
                            }
                        }
                        case 2 ->{

                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/img/destroyer/destroyer_bottom.png",  x,y ,width,height);
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/img/destroyer/destroyer_right.png",  x,y,width,height );
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/img/destroyer/destroyer_left.png",  x,y,width,height );
                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/img/destroyer/destroyer_top.png",  x,y ,width,height);
                                }
                            }
                        }
                        case 1->{
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/img/torpedo/torpedo_bottom.png",  x,y ,width,height);
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/img/torpedo/torpedo_right.png",  x,y ,width,height);
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/img/torpedo/torpedo_left.png",  x,y ,width,height);
                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/img/torpedo/torpedo_top.png",  x,y ,width,height);
                                }
                            }
                        }
                        default -> {
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/img/default_ship/default_ship_bottom.png",  x,y,width,height );
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/img/default_ship/default_ship_right.png",  x,y ,width,height);
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/img/default_ship/default_ship_left.png",  x,y ,width,height);
                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/img/default_ship/default_ship_top.png",  x,y ,width,height);
                                }
                            }
                        }
                    }
                }
            }
            case SHELLED -> {
                g2d.drawImage(shelled,x, y, width,height,null);
            }
            case FREE, SHIP_ZONE -> {
                g2d.drawImage(free,x, y, width,height,null);
            }
            case SHIP_WRECKED -> {
                g2d.drawImage(shipWrecked,x, y, width,height,null);
            }

        }
    }

    public static Image loadImage(String path) {
        return new ImageIcon(path).getImage();
    }
}