package graphic;

import logic.Cell;

import javax.swing.*;
import java.awt.*;

public class DrawUtils {

    private static final Image free = loadImage("assets/free.png");
    private static final Image shelled = loadImage("assets/shelled.png");
    private static final Image shipWrecked = loadImage("assets/shipWrecked.png");
    private static final Image ship =  loadImage("assets/ship.png");


    public static void drawCell(Graphics2D g2d, int x, int y, Cell.typeOfCell type, boolean isWarFog) {
        switch (type){
            case SHIP -> {
              if (isWarFog) g2d.drawImage(free, x, y, null);
              else g2d.drawImage(ship, x, y, null);
            }
            case SHELLED -> {
                 g2d.drawImage(shelled, x, y, null);
            }
            case FREE, SHIP_ZONE -> {
                g2d.drawImage(free, x, y, null);
            }
            case SHIP_WRECKED -> {
               g2d.drawImage(shipWrecked, x, y, null);
            }

        }
    }

    public static Image loadImage(String path) {
        return new ImageIcon(path).getImage();
    }
}
