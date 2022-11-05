package graphic.panels;

import graphic.GraphicGameController;
import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommandPanel extends JPanel {

    private Image backgroundImage;
    GraphicGameController controller;
    private JLabel newGame;
    private JLabel changeFirstPlayer;
    private JLabel changeSecondPlayer;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }

    public CommandPanel(GraphicGameController controller) {
        this.controller=controller;
        newGame = new JLabel(new ImageIcon("assets/img/buttons/newGame.png"));
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (newGame.getBounds().contains(e.getX(), e.getY())) {
                    System.out.println("New Game");
                    controller.game.newGameParty();
                }
            }
        });
        newGame.setFocusable(true);
        changeFirstPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeFirstPlayer.png"));
        changeFirstPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (changeFirstPlayer.getBounds().contains(e.getX(), e.getY())) {
                    System.out.println("ChangeFirstPlayer");
                    controller.game.changeFirstPlayer(controller);
                }
            }
        });
        changeSecondPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeSecondPlayer.png"));
        changeSecondPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (changeSecondPlayer.getBounds().contains(e.getX(), e.getY())) {
                    System.out.println("ChangeSecondPlayer");
                    controller.game.changeSecondPlayer(controller);
                }
            }
        });
        changeFirstPlayer.setFocusable(true);
        changeSecondPlayer.setFocusable(true);
        backgroundImage = new ImageIcon("assets/img/command_panel_background.png").getImage();
        add(newGame);
        add(changeFirstPlayer);
        add(changeSecondPlayer);
    }

    public JLabel getNewGame() {
        return newGame;
    }

    public JLabel getChangeFirstPlayer() {
        return changeFirstPlayer;
    }

    public JLabel getChangeSecondPlayer() {
        return changeSecondPlayer;
    }

}
