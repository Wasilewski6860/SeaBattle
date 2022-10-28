package graphic;

import console.CLI;
import logic.Battlefield;
import logic.Cell;
import logic.Game;
import logic.TurnProviders.HumanGUITurnProvider;
import logic.players.HumanGUIPlayer;
import logic.players.HumanPlayer;
import logic.players.Player;
import logic.players.ai.NormalAI;
import logic.ship.Ship;
import logic.ship.ShipConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel
        //implements KeyListener
{
    public Game game;
    boolean isWarFog;
    public ShipConstants.DIRECTION dir = ShipConstants.DIRECTION.TOP;
    public int x;
    public int y;
    //public JTextField dirField;
    public Player currentPlayer;



    public DrawPanel(Game game) {
        //canReadXnY = false;
        //canReadDir= false;
        this.game=game;
        setSize(20*DrawUtils.CELL_HORIZONTAL_SIZE,10*DrawUtils.CELL_HORIZONTAL_SIZE);

        isWarFog=false;

        //dirField = new JTextField();
        //dirField.setPreferredSize(new Dimension(100,20));
        //add(dirField);
       // addButton.setSize(100,50);
       // add(addButton);


//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                //  int x = dp.x/ DrawUtils.CELL_HORIZONTAL_SIZE;
//                //  int y = dp.y/ DrawUtils.CELL_VERTICAL_SIZE;
//                x=e.getX();
//                y=e.getY();
//                int xSc = x/DrawUtils.CELL_HORIZONTAL_SIZE;
//               // if (game.currentState== Game.GAME_STATE.SHOOTING){
//                //    System.out.println("Shhoting phase");
//                    game.turn();
//                 //   System.out.println("Shhoting phase");
//               // }
//                System.out.println(xSc);
//                //   System.out.println(x/ DrawUtils.CELL_HORIZONTAL_SIZE+" "+y/ DrawUtils.CELL_VERTICAL_SIZE);
//                repaint();
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                x=e.getX();
//                y=e.getY();
//                game.turn();
//                //   System.out.println(x/ DrawUtils.CELL_HORIZONTAL_SIZE+" "+y/ DrawUtils.CELL_VERTICAL_SIZE);
//                //  repaint();
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                super.mouseExited(e);
//            }
//
//            @Override
//            public void mouseWheelMoved(MouseWheelEvent e) {
//                super.mouseWheelMoved(e);
//            }
//
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                super.mouseDragged(e);
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//            }
//        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i=0;i<currentPlayer.getPlayerBattlefield().getTable().length;i++){
            for (int j=0;j<currentPlayer.getPlayerBattlefield().getTable()[i].length;j++){
                currentPlayer.getPlayerBattlefield().getTable()[i][j].draw((Graphics2D) g,isWarFog);
            }
        }
//        for (Cell[] cellRow : player.getPlayerBattlefield().getTable()){
//            for (Cell cell : cellRow){
//                cell.draw((Graphics2D) g,isWarFog);
//            }
//        }
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println("Pressed ");
//        if ( e.getKeyCode() == KeyEvent.VK_W ){
//            dir = ShipConstants.DIRECTION.TOP;
//            System.out.println("Dir is top");
//        }
//        if (e.getKeyCode()==KeyEvent.VK_S){
//            dir = ShipConstants.DIRECTION.BOTTOM;
//            System.out.println("Dir is bottom");
//        }
//        if (e.getKeyCode()==KeyEvent.VK_D){
//            dir = ShipConstants.DIRECTION.RIGHT;
//            System.out.println("Dir is right");
//        }
//        if (e.getKeyCode()==KeyEvent.VK_A){
//            dir = ShipConstants.DIRECTION.LEFT ;
//            System.out.println("Dir is left");
//        }
//        if (e.getKeyCode()==KeyEvent.VK_ENTER){
//            //if (game.currentState== Game.GAME_STATE.PLACING) {
//                //System.out.println("We are placing");
//                game.turn();
//            //}
//        }
//        repaint();
//    }

//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}
