package graphic.panels;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    private final Image backgroundImage;
    private JLabel up;
    private  JLabel right;
    private JLabel left;
    private JLabel down;
    private InfoPanel infoLabel;


    public ControlPanel() {
        up = new JLabel(new ImageIcon("assets/img/buttons/up.png"));
        right = new JLabel(new ImageIcon("assets/img/buttons/right.png"));
        left = new JLabel(new ImageIcon("assets/img/buttons/left.png"));
        down = new JLabel(new ImageIcon("assets/img/buttons/down.png"));
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

