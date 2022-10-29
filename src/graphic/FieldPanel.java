package graphic;

import logic.Battlefield;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {

    private Battlefield battlefield;
    public boolean isWarFog;

    public FieldPanel(Battlefield battlefield, boolean isWarFog) {
        this.battlefield = battlefield;
        this.isWarFog = isWarFog;
    }
    public boolean isBounds(int x,int y){
        return   this.getBounds().contains(x,y);
    }
    public int getCellWidth() {
        return getWidth() / battlefield.getTable().length;
    }

    public int getCellHeight() {
        return getHeight()/ battlefield.getTable().length;
    }
    @Override
    protected void paintComponent(Graphics g) {
        for (int i=0;i<battlefield.getTable().length;i++){
            for (int j=0;j<battlefield.getTable()[i].length;j++){
                battlefield.getTable()[i][j].draw((Graphics2D) g,isWarFog);
            }
        }
    }
}
