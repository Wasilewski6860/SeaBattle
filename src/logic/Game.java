package logic;

import logic.players.HumanGUIPlayer;
import logic.players.HumanPlayer;
import logic.players.Player;

import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;
import logic.players.ai.NormalAI;
import logic.ship.ShipConstants;
import newGraphic.GraphicGameController;

public class Game {


    public void changeFirstPlayer(GraphicGameController graphicGameController) {
        System.out.println("You are in changeFirstPlayer method");
        if (player1 instanceof HumanGUIPlayer) {
            System.out.println("fp was humangui");
            player1 = new EasyAI(player1.getPlayerBattlefield(),player1.getEnemyBattlefield());
            System.out.println("it is easyAi now");
        }else if (player1 instanceof EasyAI) {
            System.out.println("fp was easyAi");
            player1 = new NormalAI(player1.getPlayerBattlefield(),player1.getEnemyBattlefield());
            System.out.println("it is normalAi now");
        }
        else if (player1 instanceof NormalAI) {
            System.out.println("fp was normalAi");
            player1 = new HumanGUIPlayer(player1.getPlayerBattlefield(),player1.getEnemyBattlefield(),graphicGameController);
            System.out.println("it is humangui now");
        }
    }
    public void changeSecondPlayer(GraphicGameController graphicGameController) {
        if (player2 instanceof HumanGUIPlayer) {
            player2 = new EasyAI(player2.getPlayerBattlefield(),player2.getEnemyBattlefield());
        }else if (player2 instanceof EasyAI) {
            player2 = new NormalAI(player2.getPlayerBattlefield(),player2.getEnemyBattlefield());
        }
        else if (player2 instanceof NormalAI) {
            player2 = new HumanGUIPlayer(player2.getPlayerBattlefield(),player2.getEnemyBattlefield(),graphicGameController);
        }
    }

    public enum GAME_STATE{
        PLACING,
        SHOOTING,
    }
    public enum TURN{
        FIRST_PLAYER_TURN,
        SECOND_PLAYER_TURN
    }
    public GAME_STATE currentState;
    public TURN currentTurn;
    public boolean isWaiting = false;
    protected  Battlefield firstPlayerField;
    protected  Battlefield secondPlayerField;

    public  Player player1;
    public  Player player2;

    public Game() {
        firstPlayerField = new Battlefield();
        secondPlayerField = new Battlefield();
       // player1 = new HumanPlayer(firstPlayerField, secondPlayerField);
         player1 = new NormalAI(firstPlayerField, secondPlayerField);
        player2 = new NormalAI(secondPlayerField, firstPlayerField);
        currentState = GAME_STATE.PLACING;
        currentTurn = TURN.FIRST_PLAYER_TURN;
    }

    public void nextTurn(){
        switch (currentState){
            case PLACING -> {
                if (currentTurn==TURN.FIRST_PLAYER_TURN){
                    player1.placeShips();
                    currentTurn=TURN.SECOND_PLAYER_TURN;
                    return;
                }
                else {
                    player2.placeShips();
                    currentTurn=TURN.FIRST_PLAYER_TURN;
                    currentState = GAME_STATE.SHOOTING;
                    return;
                }
            }
            case SHOOTING -> {
                switch (currentTurn){
                    case FIRST_PLAYER_TURN -> {
                        while (player1.shoot() && !player1.isWinner());
                        currentTurn=TURN.SECOND_PLAYER_TURN;
                        return;
                    }
                    case SECOND_PLAYER_TURN -> {
                        while (player2.shoot() && !player2.isWinner());
                        currentTurn=TURN.FIRST_PLAYER_TURN;
                        return;
                    }
                }
            }
        }
    }

    public void turn(){
        switch (currentState){
            case PLACING -> {
                if (currentTurn==TURN.FIRST_PLAYER_TURN){
                    if (player1 instanceof AIPlayer){
                        System.out.println("First player is AI");
                        player1.placeShips();
                        currentTurn=TURN.SECOND_PLAYER_TURN;
                    }
                    else if (player1.placeShip())currentTurn=TURN.SECOND_PLAYER_TURN;
                }
                else {
                    if (player2 instanceof AIPlayer) {
                        //System.out.println("Second player is AI");
                        player2.placeShips();
                        currentTurn = TURN.FIRST_PLAYER_TURN;
                        currentState = GAME_STATE.SHOOTING;
                    } else if (player2.placeShip()) {
                        currentTurn = TURN.FIRST_PLAYER_TURN;
                        currentState = GAME_STATE.SHOOTING;
                }
                }
            }
            case SHOOTING -> {
                switch (currentTurn){
                    case FIRST_PLAYER_TURN -> {
                        if (player1.shoot() && !player1.isWinner()){
                            if (player1 instanceof AIPlayer)   turn();
                        }
                        else currentTurn=TURN.SECOND_PLAYER_TURN;
                    }
                    case SECOND_PLAYER_TURN -> {
                        if (player2.shoot()&& !player2.isWinner()){
                            if (player2 instanceof AIPlayer)   turn();
                        }
                        else currentTurn=TURN.FIRST_PLAYER_TURN;
                    }
                }
            }
        }
    }


    public Player getWinner() {
        if (currentState==GAME_STATE.PLACING) return null;

        else if (player1.isWinner()) return player1;
        else if (player2.isWinner()) return player2;
        else return null;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public  Player getPlayer2() {
        return this.player2;
    }

}
