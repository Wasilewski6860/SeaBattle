package graphic;

import logic.Battlefield;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {

    private Battlefield battlefield;
    private int height;
    private int width;
    public boolean isWarFog;

    public FieldPanel(Battlefield battlefield, boolean isWarFog) {
        this.battlefield = battlefield;
        this.isWarFog = isWarFog;
        this.setPreferredSize(new Dimension(DrawUtils.CELL_HORIZONTAL_SIZE*battlefield.getTable().length, DrawUtils.CELL_VERTICAL_SIZE*battlefield.getTable().length));
    }
    public boolean isBounds(int x,int y){
        return   this.getBounds().contains(x,y);
    }
    public int getCellWidth() {
        return getPreferredSize().width / battlefield.getTable().length;
    }

    public int getCellHeight() {
        return getPreferredSize().height/ battlefield.getTable().length;
    }
    @Override
    protected void paintComponent(Graphics g) {
        for (int i=0;i<battlefield.getTable().length;i++){
            for (int j=0;j<battlefield.getTable()[i].length;j++){
                battlefield.getTable()[i][j].draw((Graphics2D) g, DrawUtils.CELL_VERTICAL_SIZE,DrawUtils.CELL_HORIZONTAL_SIZE, isWarFog);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Relies on being the only component
        // in a layout that will center it without
        // expanding it to fill all the space.
        Dimension d = this.getParent().getSize();
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        int size =  Math.min(w, h);
        Dimension fixedRatioSize = new Dimension(size, size);
        width=height=size;
        setPreferredSize(fixedRatioSize);

        return new Dimension(fixedRatioSize);
    }

}
