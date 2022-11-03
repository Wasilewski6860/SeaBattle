package graphic;

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
    public boolean isBounds(int x,int y){
        return   this.getBounds().contains(x,y);
    }
    public int getCellWidth() {
        // System.out.println("Get cell width"+", getSW:"+getSize().width+" table size "+battlefield.getTable().length);
        return getWidth() / battlefield.getTable().length;
    }

    public int getCellHeight() {
        //System.out.println("Get cell height"+", getSH:"+getSize().height+" table size "+battlefield.getTable().length);
        return getHeight()/ battlefield.getTable().length;
    }
    @Override
    protected void paintComponent(Graphics g) {
        for (int i=0;i<battlefield.getTable().length;i++){
            for (int j=0;j<battlefield.getTable()[i].length;j++){
                battlefield.getTable()[i][j].draw((Graphics2D) g, getCellWidth(),getCellHeight(), isWarFog);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Relies on being the only component
        // in a layout that will center it without
        // expanding it to fill all the space.
        Dimension d = this.getParent().getSize();

        if ((double)d.width / d.height > 1) {
            // Width is bigger
            sizeY = d.height;
            sizeX = (int) (d.height  );
        } else {
            sizeX = d.width;
            sizeY = (int) (d.width );
        }

        return new Dimension(sizeX, sizeY);
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }


    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public boolean isWarFog() {
        return isWarFog;
    }

    public void setWarFog(boolean warFog) {
        isWarFog = warFog;
    }
}
