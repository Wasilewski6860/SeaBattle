package graphic.panels;

import graphic.GraphicGameController;
import logic.ship.ShipConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlPanel extends JPanel {

    GraphicGameController controller;
    private final Image backgroundImage;
    private JLabel up;
    private  JLabel right;
    private JLabel left;
    private JLabel down;
    private InfoPanel infoLabel;


    public ControlPanel(GraphicGameController controller) {
        this.controller=controller;
        up = new JLabel(new ImageIcon("assets/img/buttons/up.png"));
        up.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isBounds(up, e.getX(), e.getY())) {
                    controller.setSelectedDir(ShipConstants.DIRECTION.TOP);
                }
            }
        });

        right = new JLabel(new ImageIcon("assets/img/buttons/right.png"));
        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isBounds(right, e.getX(), e.getY())) {
                    controller.setSelectedDir(ShipConstants.DIRECTION.RIGHT);
                }
            }
        });
        left = new JLabel(new ImageIcon("assets/img/buttons/left.png"));
        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isBounds(left, e.getX(), e.getY())) {
                    System.out.println("LEFT");
                    controller.setSelectedDir(ShipConstants.DIRECTION.LEFT);
                }
            }
        });
        down = new JLabel(new ImageIcon("assets/img/buttons/down.png"));
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isBounds(down, e.getX(), e.getY())) {
                    controller.setSelectedDir(ShipConstants.DIRECTION.BOTTOM);
                }
            }
        });

        up.setFocusable(true);
        right.setFocusable(true);
        left.setFocusable(true);
        down.setFocusable(true);
        setFocusable(true);

        backgroundImage = new ImageIcon("assets/img/control_panel_background.png").getImage();
        infoLabel = new InfoPanel();
//        add(up
//               // , BorderLayout.NORTH
//        );
//        add(down
//               // , BorderLayout.SOUTH
//        );
//        add(left
//               // , BorderLayout.WEST
//        );
//        add(right
//               // , BorderLayout.EAST
//        );
//        add(infoLabel);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1; // Starting the first row
        c.gridy = 0;
        c.gridwidth = 1;
        add(up, c);
        c.fill = GridBagConstraints.VERTICAL;
        c.gridwidth = 1;
        c.gridx = 0; // Switching to next row
        c.gridy = 1;
        add(left, c);
        c.gridwidth = 1;
        c.gridx = 1; // Switching to next row
        c.gridy = 1;
        add(down, c);
        c.gridwidth = 1;
        c.gridx = 2; // Switching to next row
        c.gridy = 1;
        add(right, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridx = 3; // Switching to next row
        c.gridy = 0;

        add(infoLabel, c);
    }

    public boolean isBounds(JLabel button, int x, int y) {
        return x > button.getX() + getX() && x < button.getX() + button.getWidth() + getX()
                && y > button.getY() + getY() &&  y < button.getY() + getY() + button.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
    public JLabel getUp() {
        return up;
    }

    public void setUp(JLabel up) {
        this.up = up;
    }

    public JLabel getRight() {
        return right;
    }


    public JLabel getLeft() {
        return left;
    }
    public JLabel getDown() {
        return down;
    }
    public InfoPanel getInfoLabel() {
        return infoLabel;
    }

}

