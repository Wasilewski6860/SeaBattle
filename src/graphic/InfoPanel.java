package graphic;

import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    JLabel currentTurn;
    JLabel typeOfFirstPlayer;
    JLabel typeOfSecondPlayer;
    JLabel firstPlayerVictoriesInfo;
    JLabel secondPlayerVictoriesInfo;

    public InfoPanel() {
        currentTurn=new JLabel( "First player turn");
        typeOfFirstPlayer=new JLabel("Normal AI");
        typeOfSecondPlayer=new JLabel("Normal AI");
        firstPlayerVictoriesInfo=new JLabel("0");
        secondPlayerVictoriesInfo=new JLabel("0");

        // В области рисования, конечно же

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;

// The same for rows
        c.weighty = 1;

// Let the buttons to occupy entire cells
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0; // Starting the first row
        c.gridwidth = 1;
        add(currentTurn, c);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridy++; // Switching to next row
        add(typeOfFirstPlayer,c);
        c.gridy++; // Switching to next row
        add(typeOfSecondPlayer,c);
        c.gridy++; // Switching to next row
        add(firstPlayerVictoriesInfo,c);
        c.gridy++; // Switching to next row
        add(secondPlayerVictoriesInfo,c);

    }

    public void update(Game game){
        currentTurn.setText(" "+game.currentTurn);
        String str1 = "";
        if (game.getPlayer1() instanceof HumanGUIPlayer) str1="Human";
        else if (game.getPlayer1() instanceof  EasyAI) str1 = "Easy AI";
        else str1="Normal AI";
        typeOfFirstPlayer.setText(" Player1 is "+str1);
        String str2 = "";
        if (game.getPlayer2() instanceof HumanGUIPlayer) str2="Human";
        else if (game.getPlayer2() instanceof  EasyAI) str2 = "Easy AI";
        else str2="Normal AI";
        typeOfSecondPlayer.setText( "Player2 is "+str2);
        //typeOfFirstPlayer.setText(" "+((game.getPlayer2() instanceof AIPlayer)?((game.getPlayer2() instanceof EasyAI)? "Easy AI" : "Norman AI") : "Human Player"));
        firstPlayerVictoriesInfo.setText(" "+game.firstPlayersVictories);
        secondPlayerVictoriesInfo.setText(" "+game.secondPlayersVictories);
    }
    public JLabel getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(JLabel currentTurn) {
        this.currentTurn = currentTurn;
    }

    public JLabel getTypeOfFirstPlayer() {
        return typeOfFirstPlayer;
    }

    public void setTypeOfFirstPlayer(JLabel typeOfFirstPlayer) {
        this.typeOfFirstPlayer = typeOfFirstPlayer;
    }

    public JLabel getTypeOfSecondPlayer() {
        return typeOfSecondPlayer;
    }

    public void setTypeOfSecondPlayer(JLabel typeOfSecondPlayer) {
        this.typeOfSecondPlayer = typeOfSecondPlayer;
    }

    public JLabel getFirstPlayerVictoriesInfo() {
        return firstPlayerVictoriesInfo;
    }

    public void setFirstPlayerVictoriesInfo(JLabel firstPlayerVictoriesInfo) {
        this.firstPlayerVictoriesInfo = firstPlayerVictoriesInfo;
    }

    public JLabel getSecondPlayerVictoriesInfo() {
        return secondPlayerVictoriesInfo;
    }

    public void setSecondPlayerVictoriesInfo(JLabel secondPlayerVictoriesInfo) {
        this.secondPlayerVictoriesInfo = secondPlayerVictoriesInfo;
    }
}
