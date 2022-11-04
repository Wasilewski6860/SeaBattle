package graphic.panels;

import graphic.GraphicGameController;
import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private  Image backgroundImage;
    private  JLabel currentState;
    private  JLabel currentTurn;
    private  JLabel selectedDir;
    private JLabel selectedCoordinate;
    private  JLabel typeOfFirstPlayer;
    private  JLabel typeOfSecondPlayer;
    private  JLabel firstPlayerVictoriesInfo;
    private  JLabel secondPlayerVictoriesInfo;

    public InfoPanel() {
        currentState = new JLabel("Current state: NONE");
        currentState.setPreferredSize(new Dimension(150, 20));
        currentTurn = new JLabel("Current turn: " + "\n" + " FIRST_PLAYER_TURN ");
        currentTurn.setPreferredSize(new Dimension(150, 20));
        typeOfFirstPlayer = new JLabel("First player is Normal AI");
        typeOfFirstPlayer.setPreferredSize(new Dimension(150, 20));
        typeOfSecondPlayer = new JLabel("First player is Normal AI");
        typeOfSecondPlayer.setPreferredSize(new Dimension(150, 20));
        selectedDir = new JLabel("Selected direction is TOP");
        selectedDir.setPreferredSize(new Dimension(150, 20));
        selectedCoordinate = new JLabel("Selected coordinate is: none");
        selectedCoordinate.setPreferredSize(new Dimension(150, 20));
        firstPlayerVictoriesInfo = new JLabel("First player victories is 0");
        firstPlayerVictoriesInfo.setPreferredSize(new Dimension(150, 20));
        secondPlayerVictoriesInfo = new JLabel("Second player victories is 0");
        secondPlayerVictoriesInfo.setPreferredSize(new Dimension(150, 20));
        backgroundImage = new ImageIcon("assets/img/info.png").getImage();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = 1;

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0; // Starting the first row
        c.gridwidth = 1;
        add(currentState, c);
        c.gridy++;
        add(currentTurn, c);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridy++;
        add(typeOfFirstPlayer, c);
        c.gridy++;
        add(typeOfSecondPlayer, c);
        c.gridy++;
        add(selectedDir, c);
        c.gridy++;
        add(selectedCoordinate, c);
        c.gridy++; // Switching to next row
        add(firstPlayerVictoriesInfo, c);
        c.gridy++; // Switching to next row
        add(secondPlayerVictoriesInfo, c);

    }

    public void update(Game game, GraphicGameController controller) {
        currentState.setText("Current state: " + game.getCurrentState());
        currentTurn.setText("Current turn: \n" + game.getCurrentTurn());
        selectedDir.setText("Selected direction is " + controller.getSelectedDir());
        selectedCoordinate.setText("Selected coordinate is (" + controller.getSelectedX() + "," + controller.getSelectedX() + ")");
        typeOfFirstPlayer.setText("First player is " + ((game.getPlayer1() instanceof AIPlayer) ? ((game.getPlayer1() instanceof EasyAI) ? "Easy AI" : "Norman AI") : "Human Player"));
        typeOfSecondPlayer.setText("Second player is " + ((game.getPlayer2() instanceof AIPlayer) ? ((game.getPlayer2() instanceof EasyAI) ? "Easy AI" : "Norman AI") : "Human Player"));
        firstPlayerVictoriesInfo.setText("First player victories is " + game.getFirstPlayersVictories());
        secondPlayerVictoriesInfo.setText("Second player victories is " + game.getSecondPlayersVictories());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
}
