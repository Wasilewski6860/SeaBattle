package graphic.panels.info;

import graphic.GraphicGameController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class InfoPanel extends JPanel {
    public InfoTable table;
    private final GraphicGameController controller;
    public InfoPanel(GraphicGameController controller) {
        this.controller=controller;
        setLayout(new BorderLayout());
        table=new InfoTable(controller);
        setPreferredSize(new Dimension(300,150));
        table.setOpaque(false);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
        renderer.setOpaque(false);

        ImageIcon image = new ImageIcon("assets/img/icon.png");
        JPanel background = new JPanel( new BorderLayout() ) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image.getImage(), 0, table.getTableHeader().getHeight(), table.getWidth(), table.getHeight(), this);
            }
        };
        background.add( table );
        add(background);
    }
}
