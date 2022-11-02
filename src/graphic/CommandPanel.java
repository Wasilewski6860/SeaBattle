package graphic;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel {

    private Game game;
    private GraphicGameController controller;
    public JButton start;
    public JButton changeFirstPlayer;
    public JButton changeSecondPlayer;

    public CommandPanel(GraphicGameController graphicGameController, Game game) {
        start=new JButton(new ImageIcon("assets/buttons/start.png"));
        changeFirstPlayer=new JButton(new ImageIcon("assets/buttons/changeFirstPlayer.png"));
        changeSecondPlayer=new JButton(new ImageIcon("assets/buttons/changeSecondPlayer.png"));
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
