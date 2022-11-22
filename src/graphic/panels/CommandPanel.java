package graphic.panels;

import graphic.GraphicGameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommandPanel extends JPanel {
    private Image backgroundImage;
    private GraphicGameController controller;
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
                //System.out.println("NEW GAME");
                controller.newGameParty();
                controller.refresh();
            }
        });
        changeFirstPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeFirstPlayer.png"));
        changeFirstPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               // System.out.println("CFP");
                controller.changeFirstPlayer();
                controller.refresh();
            }
        });
        changeSecondPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeSecondPlayer.png"));
        changeSecondPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //System.out.println("CSP");
                controller.changeSecondPlayer();
                controller.refresh();
            }
        });
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
