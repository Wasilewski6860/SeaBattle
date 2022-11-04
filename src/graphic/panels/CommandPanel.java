package graphic.panels;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {

    private Image backgroundImage;
    private JLabel newGame;
    private JLabel changeFirstPlayer;
    private JLabel changeSecondPlayer;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }

    public CommandPanel() {
        newGame = new JLabel(new ImageIcon("assets/img/buttons/newGame.png"));
        changeFirstPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeFirstPlayer.png"));
        changeSecondPlayer = new JLabel(new ImageIcon("assets/img/buttons/changeSecondPlayer.png"));
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
