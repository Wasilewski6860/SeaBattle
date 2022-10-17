package graphic;

import logic.Game;
import logic.players.Player;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300, 1000);

        Game game = new Game();
        DrawPanel mainPanel = new DrawPanel(game);
        mainPanel.setFocusable(true);
        requestFocus();
        this.add(mainPanel);
    }
}
