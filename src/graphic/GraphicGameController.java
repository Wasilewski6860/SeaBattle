package graphic;

import logic.Coordinate;
import logic.Game;
import logic.players.Player;
import logic.ship.ShipConstants;

import java.awt.event.*;

public class GraphicGameController implements MouseListener {

    public Game game;
    public GUI gui;
    private int selectedX;
    private int selectedY;
    private ShipConstants.DIRECTION selectedDir;

    public GraphicGameController(GUI gui) {
        this.game = gui.getGame();
        this.gui = gui;
        selectedX = selectedY = 0;
        selectedDir = ShipConstants.DIRECTION.TOP;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectedX = e.getX();
        selectedY = e.getY();
        if (gui.isFirstFieldBounds(selectedX, selectedY)) {
            getSelectedCoordinates(gui.getFirstFieldPanel().cellClickCoordinates(selectedX, selectedY));
            game.turn();
        } else if (gui.isSecondFieldBounds(selectedX, selectedY)) {
            getSelectedCoordinates(gui.getSecondFieldPanel().cellClickCoordinates(selectedX, selectedY));
            game.turn();
        }
        gui.getControlPanel().getInfoLabel().repaint();
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

    public void changeFirstPlayer() {
        game.changeFirstPlayer(this);
    }

    public void changeSecondPlayer() {
        game.changeSecondPlayer(this);
    }

    public void newGameParty() {
        game.newGameParty();
        gui.newGame();
    }

    public Player getPlayer1() {
        return game.getPlayer1();
    }

    public Player getPlayer2() {
        return game.getPlayer2();
    }

    public Game.GAME_STATE getCurrentState() {
        return game.getCurrentState();
    }

    public Game.TURN getCurrentTurn() {
        return game.getCurrentTurn();
    }

    public int getFirstPlayersVictories() {
        return game.getFirstPlayersVictories();
    }

    public int getSecondPlayersVictories() {
        return game.getSecondPlayersVictories();
    }

    public Coordinate getSelectedCoordinate() {
        return new Coordinate(selectedX, selectedY);
    }

    public void setSelectedDir(ShipConstants.DIRECTION selectedDir) {
        this.selectedDir = selectedDir;
    }

    public void getSelectedCoordinates(Coordinate coordinate) {
        selectedX = coordinate.getX();
        selectedY = coordinate.getY();
    }

    public void refresh() {
//        gui.getControlPanel().getInfoLabel().repaint();
        gui.repaint();
    }
}
