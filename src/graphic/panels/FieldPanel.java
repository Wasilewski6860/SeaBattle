package graphic.panels;

import logic.Battlefield;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {

    private Battlefield battlefield;
    private int sizeY;
    private int sizeX;
    public boolean isWarFog;

    public FieldPanel(Battlefield battlefield, boolean isWarFog) {
        this.battlefield = battlefield;
        this.isWarFog = isWarFog;
        //this.setPreferredSize(new Dimension(DrawUtils.CELL_HORIZONTAL_SIZE*battlefield.getTable().length, DrawUtils.CELL_VERTICAL_SIZE*battlefield.getTable().length));
    }


    public int getCellWidth() {
        return getWidth() / battlefield.getTable().length;
    }

    public int getCellHeight() {
        return getHeight() / battlefield.getTable().length;
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < battlefield.getTable().length; i++) {
            for (int j = 0; j < battlefield.getTable()[i].length; j++) {
                battlefield.getTable()[i][j].draw((Graphics2D) g, getCellWidth(), getCellHeight(), isWarFog);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = this.getParent().getSize();
        if (d.width > d.height) {
            sizeY = d.height;
            sizeX = d.height;
        } else {
            sizeX = d.width;
            sizeY = d.width;
        }
        return new Dimension(sizeX, sizeY);
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

}
