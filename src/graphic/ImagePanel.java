package graphic;

import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    private Image image;
    private int width;
    private int height;
    public ImagePanel(Image image,int width,int height) {
        this.image = image;
        this.width=width;
        this.height=height;
        setSize(width, height);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this);
    }

}
