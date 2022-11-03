package graphic;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {


    private Image backgroundImage;
    public JLabel up;
    public JLabel right;
    public JLabel left;
    public JLabel down;
    public InfoPanel infoLabel;


    public ControlPanel( ) {
        up=new JLabel(new ImageIcon("assets/buttons/up.png"));
        right=new JLabel(new ImageIcon("assets/buttons/right.png"));
        left=new JLabel(new ImageIcon("assets/buttons/left.png"));
        down=new JLabel(new ImageIcon("assets/buttons/down.png"));
        backgroundImage = new ImageIcon("assets/command_panel_background.png").getImage();
        infoLabel =new InfoPanel();
        add(up
               // , BorderLayout.NORTH
        );
        add(down
               // , BorderLayout.SOUTH
        );
        add(left
               // , BorderLayout.WEST
        );
        add(right
               // , BorderLayout.EAST
        );
        add(infoLabel);
//        setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.weightx = 1;
//        c.weighty = 1;
//        c.fill = GridBagConstraints.VERTICAL;
//        c.gridx = 1; // Starting the first row
//        c.gridy=0;
//        c.gridwidth = 1;
//        add(up, c);
//        c.fill = GridBagConstraints.VERTICAL;
//        c.gridwidth = 1;
//        c.gridx=0; // Switching to next row
//        c.gridy=1;
//        add(left,c);
//        c.gridwidth = 1;
//        c.gridx=1; // Switching to next row
//        c.gridy=1;
//        add(down,c);
//        c.gridwidth = 1;
//        c.gridx=2; // Switching to next row
//        c.gridy=1;
//        add(right,c);
//        c.fill = GridBagConstraints.BOTH;
//        c.gridwidth = 1;
//        c.gridx=3; // Switching to next row
//        add(infoLabel,c);
    }

    public boolean isBounds(JLabel button,int x,int y){
        System.out.println("x "+x+" y"+y+" button.getX() "+button.getX()+" button.getWidth() "+button.getWidth()+
                " button.getY()"+button.getY()+" button.getHeight() "+button.getHeight()+" getX() "+getX()+" getY() "+getY());
        boolean b1= x>button.getX();
        boolean b2 =x<button.getX()+button.getWidth();
        boolean b3= y > button.getY()+getY();
        boolean b4 =y < button.getY()+getY()+button.getHeight();
        return b1 && b2 && b3 && b4;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),null);
    }

}

