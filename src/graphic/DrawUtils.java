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

    public static void drawCell(Graphics2D g2d, Cell cell, boolean isWarFog) {

          //  g2d.drawImage(free,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
        switch (cell.getType()){
            case SHIP -> {
              if (isWarFog) g2d.drawImage(free, cell.getX(), cell.getY(), null);
              else {
                  switch (cell.getShip().getLength()){
                      case 4 ->{
                            switch (cell.getShip().getLocation().getDir()){
                                case BOTTOM -> {
                                    //System.out.println("Try to place battleship_bottom at "+cell.getX()+" "+cell.getY());
                                    g2d.drawImage(new ImageIcon("assets/battleship/battleship_bottom.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                                }
                                case RIGHT -> {
                                    //System.out.println("Try to place battleship_right at "+cell.getX()+" "+cell.getY());
                                    g2d.drawImage(new ImageIcon("assets/battleship/battleship_right.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                                }
                                case LEFT -> {
                                    //System.out.println("Try to place battleship_left at "+cell.getX()+" "+cell.getY());
                                    g2d.drawImage(new ImageIcon("assets/battleship/battleship_left.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                                }
                                case TOP -> {
                                    //System.out.println("Try to place battleship_top at "+cell.getX()+" "+cell.getY());
                                    g2d.drawImage(new ImageIcon("assets/battleship/battleship_top.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                                }
                            }
                      }
                      case 3 ->{
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  //System.out.println("Try to place cruiser_bottom at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/cruiser/cruiser_bottom.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case RIGHT -> {
                                  //System.out.println("Try to place cruiser_right at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/cruiser/cruiser_right.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case LEFT -> {
                                  //System.out.println("Try to place cruiser_left at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/cruiser/cruiser_left.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case TOP -> {
                                  //System.out.println("Try to place cruiser_top at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/cruiser/cruiser_top.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                          }
                      }
                      case 2 ->{

                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  //System.out.println("Try to place destroyer_bottom at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/destroyer/destroyer_bottom.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case RIGHT -> {
                                  //System.out.println("Try to place destroyer_right at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/destroyer/destroyer_right.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case LEFT -> {
                                  //System.out.println("Try to place destroyer_left at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/destroyer/destroyer_left.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case TOP -> {
                                  //System.out.println("Try to place destroyer_top at "+cell.getX()+" "+cell.getY());
                                  g2d.drawImage(new ImageIcon("assets/destroyer/destroyer_top.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                          }
                      }
                      case 1->{
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  g2d.drawImage(new ImageIcon("assets/torpedo/torpedo_bottom.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case RIGHT -> {
                                  g2d.drawImage(new ImageIcon("assets/torpedo/torpedo_right.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case LEFT -> {
                                  g2d.drawImage(new ImageIcon("assets/torpedo/torpedo_left.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case TOP -> {
                                  g2d.drawImage(new ImageIcon("assets/torpedo/torpedo_top.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                          }
                      }
                      default -> {
                          switch (cell.getShip().getLocation().getDir()){
                              case BOTTOM -> {
                                  g2d.drawImage(new ImageIcon("assets/default_ship/default_ship_bottom.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case RIGHT -> {
                                  g2d.drawImage(new ImageIcon("assets/default_ship/default_ship_right.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case LEFT -> {
                                  g2d.drawImage(new ImageIcon("assets/default_ship/default_ship_left.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                              case TOP -> {
                                  g2d.drawImage(new ImageIcon("assets/default_ship/default_ship_top.png").getImage() , cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
                              }
                          }
                      }
              }
              }
            }
            case SHELLED -> {
                //System.out.println("Try to place shelled at "+cell.getX()+" "+cell.getY());
                 g2d.drawImage(shelled,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }
            case FREE, SHIP_ZONE -> {
                //System.out.println("Try to place free,ship_zone at "+cell.getX()+" "+cell.getY());
                g2d.drawImage(free,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }
            case SHIP_WRECKED -> {
                //System.out.println("Try to place ship_wrecked at "+cell.getX()+" "+cell.getY());
               g2d.drawImage(shipWrecked,cell.getX()* free.getWidth(null), cell.getY()* free.getHeight(null), null);
            }

        }
    }

    public static Image loadImage(String path) {
        return new ImageIcon(path).getImage();
    }

    //TODO Доработать
    public static void drawButton(Graphics g, int x, int y, int sizeX, int sizeY, Color color, String text){
        g.setColor(color);
        g.fillOval(x-sizeX/2, y-sizeY/2, sizeY, sizeY);
        g.fillOval(x+sizeX/2-sizeY/2, y-sizeY/2, sizeY, sizeY);
        g.setColor(Color.BLACK);
        g.drawOval(x-sizeX/2, y-sizeY/2, sizeY, sizeY);
        g.drawOval(x+sizeX/2-sizeY/2, y-sizeY/2, sizeY, sizeY);
        g.setColor(color);
        g.fillRect(x-sizeX/2+sizeY/2, y-sizeY/2, sizeX-sizeY/2, sizeY);
        g.setColor(Color.BLACK);
        g.drawString(text,x+sizeX/4,y+sizeY/4);
        //drawCenteredString(g, text, new Rectangle(x-sizeX/2+sizeY/2, y-sizeY/2, sizeX-sizeY/2, sizeY), new Font("TimesRoman", Font.PLAIN, sizeX/8));

    }
}
