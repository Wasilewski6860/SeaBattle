package graphic;

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
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),null);
    }

    public CommandPanel() {
        newGame =new JLabel(new ImageIcon("assets/img/buttons/start.png"));
        changeFirstPlayer=new JLabel(new ImageIcon("assets/img/buttons/changeFirstPlayer.png"));
        changeSecondPlayer=new JLabel(new ImageIcon("assets/img/buttons/changeSecondPlayer.png"));
        backgroundImage = new ImageIcon("assets/img/command_panel_background.png").getImage();
        add(newGame);
        add(changeFirstPlayer);
        add(changeSecondPlayer);
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public JLabel getNewGame() {
        return newGame;
    }

    public void setNewGame(JLabel newGame) {
        this.newGame = newGame;
    }

    public JLabel getChangeFirstPlayer() {
        return changeFirstPlayer;
    }

    public void setChangeFirstPlayer(JLabel changeFirstPlayer) {
        this.changeFirstPlayer = changeFirstPlayer;
    }

    public JLabel getChangeSecondPlayer() {
        return changeSecondPlayer;
    }

    public void setChangeSecondPlayer(JLabel changeSecondPlayer) {
        this.changeSecondPlayer = changeSecondPlayer;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        start.draw((Graphics2D) g);
//        changeFirstPlayer.draw((Graphics2D)g);
//        changeSecondPlayer.draw((Graphics2D)g);
//    }
}
