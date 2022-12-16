package graphic.panels.info;

import graphic.GraphicGameController;
import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;

public class InfoModel implements TableModel {

    private String currentState;
    private  String currentTurn;
    private  String selectedDir;
    private String selectedCoordinate;
    private  String typeOfFirstPlayer;
    private  String typeOfSecondPlayer;
    private  String firstPlayerVictoriesInfo;
    private  String secondPlayerVictoriesInfo;
    private int ROW_COUNT=8;
    private int COL_COUNT=1;

    private Image backgroundImage;
    private final GraphicGameController controller;

    public InfoModel(GraphicGameController controller) {
        this.controller=controller;
        //backgroundImage = new ImageIcon("assets/img/info.png").getImage();
        currentState =  "Current state: NONE";
        currentTurn =  "Current turn: " + "\n" + " FIRST_PLAYER_TURN ";
        typeOfFirstPlayer = "First player is Normal AI";
        //typeOfFirstPlayer.setPreferredSize(new Dimension(150, 20));
        typeOfSecondPlayer =  "First player is Normal AI";
        //typeOfSecondPlayer.setPreferredSize(new Dimension(150, 20));
        selectedDir =  "Selected direction is TOP";
        //selectedDir.setPreferredSize(new Dimension(150, 20));
        selectedCoordinate =  "Selected coordinate is: none";
        //selectedCoordinate.setPreferredSize(new Dimension(150, 20));
        firstPlayerVictoriesInfo =  "First player victories is 0";
        //firstPlayerVictoriesInfo.setPreferredSize(new Dimension(150, 20));
        secondPlayerVictoriesInfo =  "Second player victories is 0";
        //secondPlayerVictoriesInfo.setPreferredSize(new Dimension(150, 20));
    }

    @Override
    public int getRowCount() {
        return ROW_COUNT;
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Info State";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (rowIndex){
            case 0 ->{
                currentState="Current state: "+controller.getCurrentState().toString();
                return currentState;}
            case 1 ->{
                currentTurn="Current turn: "+controller.getCurrentTurn().toString();
                return currentTurn;}
            case 2 ->{
                selectedDir="Selected direction is : "+controller.getSelectedDir().toString();
                return selectedDir;}
            case 3 ->{
                selectedCoordinate="Selected coordinate is: "+controller.getSelectedCoordinate().toString();
                return selectedCoordinate;}
            case 4 ->{
                typeOfFirstPlayer="First player is" + controller.getPlayer1().toString();
                return typeOfFirstPlayer;}
            case 5 ->{
                typeOfSecondPlayer="Second player is" + controller.getPlayer2().toString();
                return typeOfSecondPlayer;}
            case 6 ->{
                firstPlayerVictoriesInfo="First player victories is "+controller.getFirstPlayersVictories();
                return firstPlayerVictoriesInfo;}
            case 7 ->{
                secondPlayerVictoriesInfo="Second player victories is "+controller.getSecondPlayersVictories();
                return secondPlayerVictoriesInfo;}
            default -> {return "InfoPanel";}
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

}
