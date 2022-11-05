package graphic;

import logic.Game;
import logic.ship.ShipConstants;

import java.awt.event.*;

public class GraphicGameController implements MouseListener {

    public Game game;
    public GUI gui;
    private int selectedX;
    private int selectedY;
    private ShipConstants.DIRECTION selectedDir;

    public GraphicGameController(Game game, GUI gui) {
        this.game = game;
        this.gui = gui;
        selectedX = selectedY = 0;
        selectedDir = ShipConstants.DIRECTION.TOP;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        selectedX = e.getX();
        selectedY = e.getY();

        if (gui.isFirstFieldBounds(selectedX, selectedY)) {
            selectedX = (selectedX - gui.getFirstFieldPanel().getX()) / gui.getFirstFieldPanel().getCellWidth();
            selectedY = (selectedY - gui.getFirstFieldPanel().getY()) / gui.getFirstFieldPanel().getCellHeight();
            game.turn();
        }
        else if (gui.isSecondFieldBounds(selectedX, selectedY)) {
            selectedX = (selectedX - gui.getSecondFieldPanel().getX()) / gui.getSecondFieldPanel().getCellWidth();
            selectedY = (selectedY - gui.getSecondFieldPanel().getY()) / gui.getSecondFieldPanel().getCellHeight();
            game.turn();
        }

        gui.getControlPanel().getInfoLabel().update(game, this);
        gui.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getSelectedX() {
        return selectedX;
    }
    public int getSelectedY() {
        return selectedY;
    }
    public ShipConstants.DIRECTION getSelectedDir() {
        return selectedDir;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void setSelectedX(int selectedX) {
        this.selectedX = selectedX;
    }

    public void setSelectedY(int selectedY) {
        this.selectedY = selectedY;
    }

    public void setSelectedDir(ShipConstants.DIRECTION selectedDir) {
        this.selectedDir = selectedDir;
    }
}
