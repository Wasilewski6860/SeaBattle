package logic;

import logic.players.HumanPlayer;
import logic.players.Player;

import logic.players.ai.NormalAI;

public class Game {

    protected static Battlefield firstPlayerField;
    protected static Battlefield secondPlayerField;

    public static Player player1;
    public static Player player2;

    public Game() {
        firstPlayerField = new Battlefield();
        secondPlayerField = new Battlefield();
        player1 = new HumanPlayer(firstPlayerField, secondPlayerField);
        player2 = new NormalAI(secondPlayerField, firstPlayerField);
    }

    public Player getWinner(){
       // currentTurnTeam = currentTurnTeam == Teams.North ? Teams.South : Teams.North;
        if (player1.isWinner())return player1;
        else if (player2.isWinner()) return player2;
        else return null;
    }


    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

}
