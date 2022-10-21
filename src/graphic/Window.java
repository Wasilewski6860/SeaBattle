package graphic;

import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.Player;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500, 1000);

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
        //requestFocus();
      //  this.add(mainPanel, BorderLayout.WEST);
       //  this.add(tempPanel, BorderLayout.EAST);

        JPanel p= (JPanel) getContentPane();
        p.setLayout(new GridLayout(1,2)); //set your own layout
        p.add(mainPanel); //add panel with blue border
        p.add(tempPanel);//add panel with green border
    }
}
