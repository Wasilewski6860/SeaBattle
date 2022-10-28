package graphic;

import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.Player;
import logic.ship.ShipConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame    {
    public Window() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        //device.setFullScreenWindow(this);
        setSize(1980,900);

        Game game = new Game();
        DrawPanel firstPanel = new DrawPanel(game);
        DrawPanel secondPanel = new DrawPanel(game);
        game.player1 = new HumanGUIPlayer(game.getPlayer1().getPlayerBattlefield(), game.getPlayer1().getEnemyBattlefield(), firstPanel);
        firstPanel.currentPlayer= game.player1;
        secondPanel.currentPlayer = game.player2;
        //  DrawPanel tempPanel = new DrawPanel(game);
        firstPanel.setFocusable(true);
        //mainPanel.addKeyListener(mainPanel);
        secondPanel.setFocusable(true);
        //tempPanel.addKeyListener(tempPanel);

        JPanel p= (JPanel) getContentPane();
        p.setLayout(new GridLayout(1,2));
        p.add(firstPanel);
        p.add(secondPanel);
        this.setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX()/DrawUtils.CELL_HORIZONTAL_SIZE;
                int y=e.getY()/DrawUtils.CELL_VERTICAL_SIZE;
                if (x>10){
                    x-=10;
                    secondPanel.x= x;
                    secondPanel.y= y;
                    System.out.println("Tap at right panel");
                }
                else {
                    firstPanel.x=x;
                    firstPanel.y= y;
                    System.out.println("Tap at left panel");
                }
                game.turn();
                repaint();
                System.out.println("Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Pressed ");
                ShipConstants.DIRECTION dir;
                if ( e.getKeyCode() == KeyEvent.VK_W ){
                    dir = ShipConstants.DIRECTION.TOP;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is top");
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    dir = ShipConstants.DIRECTION.BOTTOM;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is bottom");
                }
                if (e.getKeyCode()==KeyEvent.VK_D){
                    dir = ShipConstants.DIRECTION.RIGHT;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is right");
                }
                if (e.getKeyCode()==KeyEvent.VK_A){
                    dir = ShipConstants.DIRECTION.LEFT ;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is left");
                }
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    //if (game.currentState== Game.GAME_STATE.PLACING) {
                    //System.out.println("We are placing");

                    //}
                }
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed ");
                ShipConstants.DIRECTION dir;
                if ( e.getKeyCode() == KeyEvent.VK_W ){
                    dir = ShipConstants.DIRECTION.TOP;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is top");
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    dir = ShipConstants.DIRECTION.BOTTOM;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is bottom");
                }
                if (e.getKeyCode()==KeyEvent.VK_D){
                    dir = ShipConstants.DIRECTION.RIGHT;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is right");
                }
                if (e.getKeyCode()==KeyEvent.VK_A){
                    dir = ShipConstants.DIRECTION.LEFT ;
                    firstPanel.dir=dir;
                    secondPanel.dir=dir;
                    System.out.println("Dir is left");
                }
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    //if (game.currentState== Game.GAME_STATE.PLACING) {
                    //System.out.println("We are placing");

                    //}
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }

}
