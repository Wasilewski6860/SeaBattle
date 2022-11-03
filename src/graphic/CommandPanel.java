package graphic;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel {

    private Image backgroundImage;
    public JLabel start;
    public JLabel changeFirstPlayer;
    public JLabel changeSecondPlayer;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),null);
    }

    public CommandPanel() {
        start=new JLabel(new ImageIcon("assets/img/buttons/start.png"));
        changeFirstPlayer=new JLabel(new ImageIcon("assets/img/buttons/changeFirstPlayer.png"));
        changeSecondPlayer=new JLabel(new ImageIcon("assets/img/buttons/changeSecondPlayer.png"));
        backgroundImage = new ImageIcon("assets/img/command_panel_background.png").getImage();
        add(start);
        add(changeFirstPlayer);
        add(changeSecondPlayer);
    }



//    @Override
//    protected void paintComponent(Graphics g) {
//        start.draw((Graphics2D) g);
//        changeFirstPlayer.draw((Graphics2D)g);
//        changeSecondPlayer.draw((Graphics2D)g);
//    }
}
