package graphic.panels.info;

import graphic.GraphicGameController;
import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;

import javax.swing.*;

public class InfoTable extends JTable {

    private final GraphicGameController controller;
    public InfoTable(GraphicGameController controller) {
        this.controller=controller;
        setModel(new InfoModel(controller));
        //setJTableColumnsWidth( 200, 10, 30, 30, 30);
    }

}
