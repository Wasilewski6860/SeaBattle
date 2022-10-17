package graphic;

import console.CLI;
import logic.Battlefield;
import logic.Cell;
import logic.Game;
import logic.TurnProviders.HumanGUITurnProvider;
import logic.players.HumanPlayer;
import logic.players.Player;
import logic.players.ai.NormalAI;
import logic.ship.Ship;
import logic.ship.ShipConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
   public Game game;
    boolean isWarFog;
  public ShipConstants.DIRECTION dir;
    public int x;
    public int y;
    public boolean canReadXnY;
    public boolean canReadDir;
    public JTextField dirField;
    public JButton addButton = new JButton("place");

    public DrawPanel(Game game) {
        canReadXnY = false;
        canReadDir= false;
        this.game = game;
        Player player = game.getPlayer1();
        player.setProvider(new HumanGUITurnProvider(player,this));
        player.placeShips();
        CLI.printField(player.getPlayerBattlefield(),false);
        isWarFog=false;

        dirField = new JTextField();
        dirField.setPreferredSize(new Dimension(100,20));
        add(dirField);
        addButton.setSize(100,50);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dir = switch (dirField.getText()) {
                    case "left" -> ShipConstants.DIRECTION.LEFT;
                    case "top" -> ShipConstants.DIRECTION.TOP;
                    case "bottom" -> ShipConstants.DIRECTION.BOTTOM;
                    default -> ShipConstants.DIRECTION.RIGHT;
                };

            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_P){

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x=e.getX();
                y=e.getY();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x=e.getX();
                y=e.getY();
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
    }

    public void play(){
        game.nextTurn();
        game.nextTurn();
        while (game.getWinner()==null){
            game.nextTurn();
            repaint();
        }
        if (game.getPlayer1().isWinner()) System.out.println("You lose");
        if (game.getPlayer2().isWinner()) System.out.println("Congratulations! You win!");
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i=0;i<game.getPlayer1().getPlayerBattlefield().getTable().length;i++){
            for (int j=0;j<game.getPlayer1().getPlayerBattlefield().getTable()[i].length;j++){
                game.getPlayer1().getPlayerBattlefield().getTable()[i][j].draw((Graphics2D) g,isWarFog);
            }
        }
//        for (Cell[] cellRow : player.getPlayerBattlefield().getTable()){
//            for (Cell cell : cellRow){
//                cell.draw((Graphics2D) g,isWarFog);
//            }
//        }
    }
}
