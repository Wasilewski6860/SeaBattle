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
        gameController = new GraphicGameController(this);

        this.addMouseListener(gameController);

        firstFieldPanel = new FieldPanel(game.getFirstPlayerField(), false);
        secondFieldPanel = new FieldPanel(game.getSecondPlayerField(), false);

        commandPanel = new CommandPanel(gameController);
        controlPanel = new ControlPanel(gameController);

        commandPanel.setFocusable(true);
        commandPanel.setVisible(true);
        controlPanel.setFocusable(true);
        controlPanel.setVisible(true);

        add(commandPanel = new CommandPanel(gameController), BorderLayout.NORTH);
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
//        commandPanel.repaint();
//        controlPanel.repaint();
//        firstFieldPanel.repaint();
//        secondFieldPanel.repaint();
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

    public void recalcVisible() {
        boolean player1isHuman = game.getPlayer1() instanceof HumanGUIPlayer;
        boolean player2isHuman = game.getPlayer2() instanceof HumanGUIPlayer;
        boolean isPlayer1Turn = game.getCurrentTurn() == Game.TURN.FIRST_PLAYER_TURN;

//        gameController.getWarFog();

//        if (player1isHuman && isPlayer1Turn) {
//            firstFieldPanel.isWarFog = false;
//            secondFieldPanel.isWarFog = true;
//        } else if (player2isHuman && !isPlayer1Turn) {
//            firstFieldPanel.isWarFog = true;
//            secondFieldPanel.isWarFog = false;
//        }

        if (player1isHuman && player2isHuman) {
            if (isPlayer1Turn) {
                firstFieldPanel.isWarFog = false; //*
                secondFieldPanel.isWarFog = true;//*
            } else {
                firstFieldPanel.isWarFog = true;//*
                secondFieldPanel.isWarFog = false;//*
            }
        }

        if (player1isHuman && !player2isHuman) {
                firstFieldPanel.isWarFog = false;
                secondFieldPanel.isWarFog = true;
        }

        if (!player1isHuman && player2isHuman) {
                firstFieldPanel.isWarFog = true;//*
                secondFieldPanel.isWarFog = false;//*
        }

        if (!player1isHuman && !player2isHuman) {
            firstFieldPanel.isWarFog = false;
            secondFieldPanel.isWarFog = false;
        }
    }

    public void newGame() {
        firstFieldPanel.setBattlefield(game.getFirstPlayerField());
        secondFieldPanel.setBattlefield(game.getSecondPlayerField());
    }

    public Game getGame() {
        return game;
    }
}
