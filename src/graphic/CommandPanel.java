package graphic;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel {

    private Game game;
    private Image backgroundImage;
    private GraphicGameController controller;
    public JButton start;
    public JButton changeFirstPlayer;
    public JButton changeSecondPlayer;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),null);
    }

    public CommandPanel(GraphicGameController graphicGameController, Game game) {
        start=new JButton(new ImageIcon("assets/buttons/start.png"));
        changeFirstPlayer=new JButton(new ImageIcon("assets/buttons/changeFirstPlayer.png"));
        changeSecondPlayer=new JButton(new ImageIcon("assets/buttons/changeSecondPlayer.png"));
        backgroundImage = new ImageIcon("assents/img/command_panel_background.png").getImage();
        add(start);
        add(changeFirstPlayer);
        add(changeSecondPlayer);
        controller=graphicGameController;
        this.game=game;
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.turn();
            }
        });
        changeFirstPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeFirstPlayer(controller);
            }
        });
        changeSecondPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeSecondPlayer(controller);
            }
        });


    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        start.draw((Graphics2D) g);
//        changeFirstPlayer.draw((Graphics2D)g);
//        changeSecondPlayer.draw((Graphics2D)g);
//    }
}
