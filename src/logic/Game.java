package logic;

import logic.players.HumanGUIPlayer;
import logic.players.Player;

import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;
import logic.players.ai.NormalAI;
import graphic.GraphicGameController;
import logic.ship.Ship;

import java.util.List;

public class Game {

    public enum GAME_STATE {
        PLACING,
        SHOOTING,
        FINISH
    }

    public enum TURN {
        FIRST_PLAYER_TURN,
        SECOND_PLAYER_TURN
    }

    private GAME_STATE currentState;
    private TURN currentTurn;
    private Battlefield firstPlayerField;
    private Battlefield secondPlayerField;

    private Player player1;
    private Player player2;

    private int firstPlayersVictories = 0;
    private int secondPlayersVictories = 0;

    public Game() {
        newGameParty();
    }

    public void newGameParty() {
        if (currentState == GAME_STATE.FINISH) {
            if (player1.isWinner()) firstPlayersVictories++;
            else secondPlayersVictories++;
        }

        firstPlayerField = new Battlefield();
        secondPlayerField = new Battlefield();
        player1 = new NormalAI(firstPlayerField, secondPlayerField);
        player2 = new NormalAI(secondPlayerField, firstPlayerField);
        currentState = GAME_STATE.PLACING;
        currentTurn = TURN.FIRST_PLAYER_TURN;
    }

    public void turn() {
        switch (currentState) {
            case PLACING -> {
                if (currentTurn == TURN.FIRST_PLAYER_TURN) {
                    if (player1.placeShip())
                        changeCurrentTurn();
                } else if (player2.placeShip()) {
                    changeCurrentTurn();
                    changeCurrentState();
                }
            }

            case SHOOTING -> {
                Player currentPlayer = currentTurn == TURN.FIRST_PLAYER_TURN ? player1 : player2;

                if (getWinner() == null) {
                    boolean isShooted = currentPlayer.shoot();
                    if (!isShooted)
                        changeCurrentTurn();
                } else
                    changeCurrentState();
            }
        }
    }

    public void changeFirstPlayer(GraphicGameController graphicGameController) {
        if (player1 instanceof HumanGUIPlayer)
            player1 = new EasyAI(player1.getPlayerBattlefield(), player1.getEnemyBattlefield());
        else if (player1 instanceof EasyAI)
            player1 = new NormalAI(player1.getPlayerBattlefield(), player1.getEnemyBattlefield());
        else if (player1 instanceof NormalAI)
            player1 = new HumanGUIPlayer(player1.getPlayerBattlefield(), player1.getEnemyBattlefield(), graphicGameController);
    }

    public void changeSecondPlayer(GraphicGameController graphicGameController) {
        if (player2 instanceof HumanGUIPlayer)
            player2 = new EasyAI(player2.getPlayerBattlefield(), player2.getEnemyBattlefield());
        else if (player2 instanceof EasyAI)
            player2 = new NormalAI(player2.getPlayerBattlefield(), player2.getEnemyBattlefield());
        else if (player2 instanceof NormalAI)
            player2 = new HumanGUIPlayer(player2.getPlayerBattlefield(), player2.getEnemyBattlefield(), graphicGameController);
    }

    public void changePlayer(GraphicGameController graphicGameController, Player player) {
        if (player instanceof HumanGUIPlayer)
            player = new EasyAI(player.getPlayerBattlefield(), player.getEnemyBattlefield());
        else if (player instanceof EasyAI)
            player = new NormalAI(player.getPlayerBattlefield(), player.getEnemyBattlefield());
        else if (player instanceof NormalAI)
            player = new HumanGUIPlayer(player.getPlayerBattlefield(), player.getEnemyBattlefield(), graphicGameController);
    }

    public void changeCurrentTurn() {
        currentTurn = (currentTurn == TURN.FIRST_PLAYER_TURN) ? TURN.SECOND_PLAYER_TURN : TURN.FIRST_PLAYER_TURN;
    }

    public void changeCurrentState() {
        currentState = (currentState == GAME_STATE.PLACING) ? GAME_STATE.SHOOTING : GAME_STATE.FINISH;
    }

    public Player getWinner() {
        if (currentState == GAME_STATE.PLACING) return null;
        else if (player1.isWinner()) return player1;
        else if (player2.isWinner()) return player2;
        else return null;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public GAME_STATE getCurrentState() {
        return currentState;
    }

    public TURN getCurrentTurn() {
        return currentTurn;
    }

    public Battlefield getFirstPlayerField() {
        return firstPlayerField;
    }

    public Battlefield getSecondPlayerField() {
        return secondPlayerField;
    }

    public int getFirstPlayersVictories() {
        return firstPlayersVictories;
    }

    public int getSecondPlayersVictories() {
        return secondPlayersVictories;
    }

    public boolean isFinished() {
        return currentState != GAME_STATE.PLACING && getWinner() == null;
    }
}
