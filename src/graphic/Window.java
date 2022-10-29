package graphic;

import logic.Game;
import logic.players.HumanGUIPlayer;
import logic.players.Player;
import logic.ship.ShipConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame    {

    /*TODO:
        Добавить ~ GameController, имеющий доступ к игре и Window. Он будет наследоваться от слушателей мыши/клавиатуры,
         обрабатывать нажатия мыши/клавиш(возможно и двугих кнопок по типу запуска игры, выборе игрока, сложности и т.п.)
         !!! Не совершать саму стрельбу, только получать координаты !!! (?)
         Провайдер хода должен брать координаты из контроллера.
            .
           Всторостепенное - добавить собственно человеческий интерфейс, с возможностью выбора типа игрока и т.п.
           Смена типа игрока, например, должна происходить следующим образом: в !!! GameController !!!  в оверрайде actionPerformed(ActionEvent e)
           обрабрабатывать тип события и в зависимости от него вызывать game.changePlayer() (или game.setTypeOfPlayer1(), например, неважно).
            .
           Конечный GUI будет иметь в качестве полей Game и GameController(а так же две панели-боевых поля и пр.swing элементы,по типу кнопок,вспом.панелей и т.п.).
           Всем кнопкам, по идее, должен передаваться в качестве actionListener'а GameController
            .
           Игровое отрисовываемое поле(сейчас аналог DrawPanel) не должно иметь(опираться на) игрока, его единственное значение - BattleField.
           Задача поля - только отрисовываться
            .
            DrawPanel должен содержать метод, проверяющий, совершен ли по нему тап, или нет(а может и не сам DrawPanel,уточнить).Это должно использоваться в GameController-e
             для проверки,куда была нажата мышь, и,соответственно,будут меняться значения полей GameController, такие как currentX,currentY,currentField(правое или левое).
             .
             Возможен вариант создания класса Button как рисуемого объекта с полями позиции, размера, цвета(может фоновой картинки) и текста(если фоновой картинки нет).
             Тогда GameController будет обрабатывать попадание мыши по кнопке и вызывать соотв.метод в Game.

     */
    public Window() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        //device.setFullScreenWindow(this);
        setSize(1980,900);

        Game game = new Game();
        DrawPanel firstPanel = new DrawPanel(game.player1);
        DrawPanel secondPanel = new DrawPanel(game.player2);
        //game.player1 = new HumanGUIPlayer(game.getPlayer1().getPlayerBattlefield(), game.getPlayer1().getEnemyBattlefield(), firstPanel);

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
                if (game.getWinner()!=null){
                    dispose();
                }
                int x=e.getX()/DrawUtils.CELL_HORIZONTAL_SIZE;
                int y=e.getY()/DrawUtils.CELL_VERTICAL_SIZE;
                if (x>10){
                    x-=10;
                    secondPanel.setCurX(x);
                    secondPanel.setCurX(y);
                    System.out.println("Tap at right panel at x: "+secondPanel.getCurX()+" y: "+secondPanel.getCurY());
                }
                else {
                    firstPanel.setCurX(x);
                    firstPanel.setCurY(y);
                    System.out.println("Tap at left panel at x: "+firstPanel.getCurX()+" y: "+firstPanel.getCurY());
                }
                game.turn();
               // if (firstPanel.currentPlayer==ga)
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
