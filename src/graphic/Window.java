package graphic;

import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.Player;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        //device.setFullScreenWindow(this);
        setSize(1980,900);

        Game game = new Game();
        DrawPanel mainPanel = new DrawPanel(game);
        DrawPanel tempPanel = new DrawPanel(game);
        game.player1 = new HumanGUIPlayer(game.getPlayer1().getPlayerBattlefield(), game.getPlayer1().getEnemyBattlefield(), mainPanel);
        mainPanel.currentPlayer= game.player1;
        tempPanel.currentPlayer = game.player2;
        //  DrawPanel tempPanel = new DrawPanel(game);
        mainPanel.setFocusable(true);
        mainPanel.addKeyListener(mainPanel);
        tempPanel.setFocusable(true);
        tempPanel.addKeyListener(tempPanel);

        JPanel p= (JPanel) getContentPane();
        p.setLayout(new GridLayout(1,2));
        p.add(mainPanel);
        p.add(tempPanel);
    }

}
