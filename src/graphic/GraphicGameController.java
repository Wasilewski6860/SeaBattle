package graphic;

import logic.Game;
import logic.ship.ShipConstants;

import java.awt.event.*;

public class GraphicGameController implements MouseListener, KeyListener {

    public Game game;
    public GUI gui;

    public int selectedX;
    public int selectedY;
    public ShipConstants.DIRECTION selectedDir;

    public GraphicGameController(Game game, GUI gui) {
        this.game = game;
        this.gui = gui;
        selectedX=selectedY=0;
        selectedDir= ShipConstants.DIRECTION.TOP;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed ");
        if ( e.getKeyCode() == KeyEvent.VK_W ){
            selectedDir = ShipConstants.DIRECTION.TOP;
            System.out.println("Dir is top");
        }
        if (e.getKeyCode()==KeyEvent.VK_S){
            selectedDir = ShipConstants.DIRECTION.BOTTOM;
            System.out.println("Dir is bottom");
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            selectedDir = ShipConstants.DIRECTION.RIGHT;
            System.out.println("Dir is right");
        }
        if (e.getKeyCode()==KeyEvent.VK_A){
            selectedDir = ShipConstants.DIRECTION.LEFT ;
            System.out.println("Dir is left");
        }
        if (e.getKeyCode()==KeyEvent.VK_Y){
            System.out.println("trying to change firstplayer");
            game.changeFirstPlayer(this);
            game.turn();
            //}
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed ");
        if ( e.getKeyCode() == KeyEvent.VK_W ){
            selectedDir = ShipConstants.DIRECTION.TOP;
            System.out.println("Dir is top");
        }
        if (e.getKeyCode()==KeyEvent.VK_S){
            selectedDir = ShipConstants.DIRECTION.BOTTOM;
            System.out.println("Dir is bottom");
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            selectedDir = ShipConstants.DIRECTION.RIGHT;
            System.out.println("Dir is right");
        }
        if (e.getKeyCode()==KeyEvent.VK_A){
            selectedDir = ShipConstants.DIRECTION.LEFT ;
            System.out.println("Dir is left");
        }
        if (e.getKeyCode()==KeyEvent.VK_Y){
            System.out.println("trying to change firstplayer");
            game.changeFirstPlayer(this);
            //game.turn();
            //}
        }
        if (e.getKeyCode()==KeyEvent.VK_N){
            System.out.println("NewGame");
            game=new Game();
            //game.turn();
            //}
        }
        gui.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



    @Override
    public void mouseClicked(MouseEvent e) {



        if (gui.commandPanel.start.getBounds().contains(e.getX(),e.getY())) {

            game.newGameParty();

        }
        if (gui.commandPanel.changeFirstPlayer.getBounds().contains(e.getX(),e.getY())) {
            game.changeFirstPlayer(this);
        }
        if (gui.commandPanel.changeSecondPlayer.getBounds().contains(e.getX(),e.getY())) {
            game.changeSecondPlayer(this);
        }
        if (gui.scorePanel.isBounds(gui.scorePanel.up,e.getX(),e.getY())) {
            // System.out.println("TOP"+" gBx "+gui.scorePanel.up.getBounds().x+" gBy "+gui.scorePanel.up.getBounds().y+
            // " width "+gui.scorePanel.up.getBounds().width+" height "+gui.scorePanel.up.getBounds().width+" e.getX,Y "+e.getX()+" "+e.getY());
            selectedDir= ShipConstants.DIRECTION.TOP;
        }
        if (gui.scorePanel.isBounds(gui.scorePanel.down,e.getX(),e.getY())) {
            System.out.println("DOWN");
            selectedDir= ShipConstants.DIRECTION.BOTTOM;
        }
        if (gui.scorePanel.isBounds(gui.scorePanel.left,e.getX(),e.getY())) {
            System.out.println("LEFT");
            selectedDir= ShipConstants.DIRECTION.LEFT;
        }
        if (gui.scorePanel.isBounds(gui.scorePanel.right,e.getX(),e.getY())) {
            System.out.println("RIGHT");
            selectedDir= ShipConstants.DIRECTION.RIGHT;
        }
        selectedX=e.getX();
        selectedY=e.getY();
        if (gui.isFirstFieldBounds(selectedX,selectedY)){
            selectedX=(selectedX-gui.firstFieldPanel.getX())/ gui.firstFieldPanel.getCellWidth();
            selectedY=(selectedY-gui.firstFieldPanel.getY())/gui.firstFieldPanel.getCellHeight();
            game.turn();
            System.out.println("Tap at "+selectedX+" "+selectedY+" at fb");
            System.out.println("e.getX()="+e.getX()+" "+" selectedX-gui.firstFieldPanel.getX()="+
                    (e.getX()-gui.firstFieldPanel.getX())+" gui.firstFieldPanel.getCellWidth()="+gui.firstFieldPanel.getCellWidth()+" (selectedX-gui.firstFieldPanel.getX())/gui.firstFieldPanel.getCellWidth()="+
                    (e.getX()-gui.firstFieldPanel.getX())/gui.firstFieldPanel.getCellWidth());
            System.out.println("Get cell width"+", getSW:"+gui.firstFieldPanel.getSize().width+" table size "+gui.firstFieldPanel.getBattlefield().getTable().length);
            System.out.println("e.getY()="+e.getY()+" "+" selectedY-gui.firstFieldPanel.getY()="+
                    (e.getY()-gui.firstFieldPanel.getY())+" gui.firstFieldPanel.getCellHeight()="+gui.firstFieldPanel.getCellHeight()+" (selectedY-gui.firstFieldPanel.getY())/gui.firstFieldPanel.getCellHeight()="+
                    (e.getY()-gui.firstFieldPanel.getY())/gui.firstFieldPanel.getCellHeight());

        }
        else if (gui.isSecondFieldBounds(selectedX, selectedY)){
            selectedX=(selectedX-gui.secondFieldPanel.getX())/ gui.firstFieldPanel.getCellWidth();
            selectedY=(selectedY-gui.secondFieldPanel.getY())/gui.firstFieldPanel.getCellHeight();
            System.out.println("Tap at "+selectedX+" "+selectedY+" at sb");
            game.turn();
        }
        gui.scorePanel.infoLabel.update(game);

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
}
