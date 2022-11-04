package graphic;

import graphic.panels.CommandPanel;
import graphic.panels.ControlPanel;
import graphic.panels.FieldPanel;
import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.ai.AIPlayer;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public Game game;
    private GraphicGameController gameController;

    private FieldPanel firstFieldPanel;
    private FieldPanel secondFieldPanel;
    private CommandPanel commandPanel;
    private ControlPanel controlPanel;

    public GUI(Game game) throws HeadlessException {
        this.game = game;
        setIconImage(DrawUtils.loadImage("assets/img/icon.png"));
        this.setSize(1779, 936);
        //setResizable(false);
        gameController = new GraphicGameController(game, this);

        this.addMouseListener(gameController);

        firstFieldPanel = new FieldPanel(game.getFirstPlayerField(), false);
        secondFieldPanel = new FieldPanel(game.getSecondPlayerField(), false);

        commandPanel = new CommandPanel();
        controlPanel = new ControlPanel();

        commandPanel.setFocusable(true);
        commandPanel.setVisible(true);
        controlPanel.setFocusable(true);
        controlPanel.setVisible(true);

        add(commandPanel = new CommandPanel(), BorderLayout.NORTH);
        add(firstFieldPanel = new FieldPanel(game.getFirstPlayerField(), false), BorderLayout.WEST);
        add(secondFieldPanel = new FieldPanel(game.getSecondPlayerField(), false), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        this.setFocusable(true);
        this.setVisible(true);
    }

    public boolean isFirstFieldBounds(int x, int y) {
        return firstFieldPanel.getBounds().contains(x, y);
    }

    public boolean isSecondFieldBounds(int x, int y) {
        return secondFieldPanel.getBounds().contains(x, y);
    }

    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
        recalcVisible();
        commandPanel.repaint();
        controlPanel.repaint();
        firstFieldPanel.repaint();
        secondFieldPanel.repaint();
    }

    public FieldPanel getFirstFieldPanel() {
        return firstFieldPanel;
    }

    public FieldPanel getSecondFieldPanel() {
        return secondFieldPanel;
    }

    public CommandPanel getCommandPanel() {
        return commandPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void recalcVisible(){
        if (game.getPlayer1() instanceof HumanGUIPlayer && game.getPlayer2() instanceof HumanGUIPlayer) {
            if (game.getCurrentTurn() == Game.TURN.FIRST_PLAYER_TURN) {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = true;
            } else {
                firstFieldPanel.isWarFog = true;
                secondFieldPanel.isWarFog = false;
            }
        }
        if (game.getPlayer1() instanceof HumanGUIPlayer && game.getPlayer2() instanceof AIPlayer) {
            if (game.getCurrentTurn() == Game.TURN.FIRST_PLAYER_TURN) {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = true;
            } else {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = true;
            }
        }
        if (game.getPlayer1() instanceof AIPlayer && game.getPlayer2() instanceof HumanGUIPlayer) {
            if (game.getCurrentTurn() == Game.TURN.FIRST_PLAYER_TURN) {
                firstFieldPanel.isWarFog = true;
                secondFieldPanel.isWarFog = false;
            } else {
                firstFieldPanel.isWarFog = true;
                secondFieldPanel.isWarFog = false;
            }
        }
        if (game.getPlayer1() instanceof AIPlayer && game.getPlayer2() instanceof AIPlayer) {
            if (game.getCurrentTurn() == Game.TURN.FIRST_PLAYER_TURN) {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = false;
            } else {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = false;
            }
        }
        firstFieldPanel.setBattlefield(game.getFirstPlayerField());
        secondFieldPanel.setBattlefield(game.getSecondPlayerField());
    }
}
