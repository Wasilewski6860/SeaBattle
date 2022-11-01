package graphic;

import logic.Cell;

import javax.swing.*;
import java.awt.*;

public class DrawUtils {

    private static final Image free = loadImage("assets/free.png");
    private static final Image shelled = loadImage("assets/shelled.png");
    private static final Image shipWrecked = loadImage("assets/shipWrecked.png");
    private static final Image ship =  loadImage("assets/ship.png");
    public static final int CELL_SIZE = 30;
    public static final int CELL_VERTICAL_SIZE = free.getHeight(null);
    public static final int CELL_HORIZONTAL_SIZE = free.getWidth(null);

    private static void drawImage(Graphics2D g2d,String path,int x,int y,int width,int height){
        g2d.drawImage(new ImageIcon(path).getImage(), x, y,width,height, null);
    }

    public static void drawCell(Graphics2D g2d,int width, int height, Cell cell, boolean isWarFog) {
        int x = cell.getX()*width;
        int y = cell.getY()*height;

          //  g2d.drawImage(free,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
        switch (cell.getType()){
            case SHIP -> {
              if (isWarFog) g2d.drawImage(free, x, y,width,height, null);
              else {
                  switch (cell.getShip().getLength()){
                      case 4 ->{
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    drawImage(g2d,"assets/battleship/battleship_bottom.png", x,y,width,height);
                                }
                                case RIGHT -> {
                                    drawImage(g2d,"assets/battleship/battleship_right.png", x,y,width,height);
                                }
                                case LEFT -> {
                                    drawImage(g2d,"assets/battleship/battleship_left.png", x,y,width,height);

                                }
                                case TOP -> {
                                    drawImage(g2d,"assets/battleship/battleship_top.png", x,y,width,height);

                                }
                            }
                      }
                      case 3 ->{
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  drawImage(g2d,"assets/cruiser/cruiser_bottom.png", x,y,width,height);
                              }
                              case RIGHT -> {
                                  drawImage(g2d,"assets/cruiser/cruiser_right.png", x,y,width,height);
                              }
                              case LEFT -> {
                                  drawImage(g2d,"assets/cruiser/cruiser_left.png", x,y,width,height);
                              }
                              case TOP -> {
                                  drawImage(g2d,"assets/cruiser/cruiser_top.png", x,y,width,height);
                              }
                          }
                      }
                      case 2 ->{

                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  drawImage(g2d,"assets/destroyer/destroyer_bottom.png", x,y,width,height);
                              }
                              case RIGHT -> {
                                  drawImage(g2d,"assets/destroyer/destroyer_right.png", x,y,width,height);
                              }
                              case LEFT -> {
                                  drawImage(g2d,"assets/destroyer/destroyer_left.png", x,y,width,height);
                              }
                              case TOP -> {
                                  drawImage(g2d,"assets/destroyer/destroyer_top.png", x,y,width,height);
                              }
                          }
                      }
                      case 1->{
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  drawImage(g2d,"assets/torpedo/torpedo_bottom.png", x,y,width,height);
                              }
                              case RIGHT -> {
                                  drawImage(g2d,"assets/torpedo/torpedo_right.png", x,y,width,height);
                              }
                              case LEFT -> {
                                  drawImage(g2d,"assets/torpedo/torpedo_left.png", x,y,width,height);
                              }
                              case TOP -> {
                                  drawImage(g2d,"assets/torpedo/torpedo_top.png", x,y,width,height);
                              }
                          }
                      }
                      default -> {
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  drawImage(g2d,"assets/default_ship/default_ship_bottom.png", x,y,width,height);
                              }
                              case RIGHT -> {
                                  drawImage(g2d,"assets/default_ship/default_ship_right.png", x,y,width,height);
                              }
                              case LEFT -> {
                                  drawImage(g2d,"assets/default_ship/default_ship_left.png", x,y,width,height);
                              }
                              case TOP -> {
                                  drawImage(g2d,"assets/default_ship/default_ship_top.png", x,y,width,height);
                              }
                          }
                      }
              }
              }
            }
            case SHELLED -> {
                 g2d.drawImage(shelled,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }
            case FREE, SHIP_ZONE -> {
                g2d.drawImage(free,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }
            case SHIP_WRECKED -> {
               g2d.drawImage(shipWrecked,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }

        }
    }

    public static Image loadImage(String path) {
        return new ImageIcon(path).getImage();
    }

    //TODO Доработать
    public static void drawButton(Graphics2D g, int x, int y, int sizeX, int sizeY, String imagePath ){

        g.drawImage(new ImageIcon(imagePath).getImage(),x,y,sizeX,sizeY,null);
        //drawCenteredString(g, text, new Rectangle(x-sizeX/2+sizeY/2, y-sizeY/2, sizeX-sizeY/2, sizeY), new Font("TimesRoman", Font.PLAIN, sizeX/8));

    }
}
