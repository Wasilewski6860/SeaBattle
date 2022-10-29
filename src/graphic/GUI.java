package graphic;

import logic.Game;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Game game;
    private GraphicGameController gameController;

    public FieldPanel firstFieldPanel;
    public FieldPanel secondFieldPanel;
    public CommandPanel commandPanel;

    public GUI(Game game) throws HeadlessException {
        this.game = game;
        this.setSize(1980,680);
        gameController=new GraphicGameController(game,this);

        this.addMouseListener(gameController);
        this.addKeyListener(gameController);
        firstFieldPanel=new FieldPanel(game.getPlayer1().getPlayerBattlefield(),false);
        secondFieldPanel=new FieldPanel(game.getPlayer2().getPlayerBattlefield(), false);

        firstFieldPanel.setLayout(null);
        secondFieldPanel.setLayout(null);

       commandPanel = new CommandPanel();
       commandPanel.setVisible(true);

        JPanel p= (JPanel) getContentPane();
        p.setLayout(new GridLayout(1,2));
        //p.add(commandPanel);
        //p.add(new ScorePanel());
        p.add(firstFieldPanel);
        p.add(secondFieldPanel);
        this.setFocusable(true);
        this.setVisible(true);
    }

    public boolean isFirstFieldBounds(int x, int y){
      return   firstFieldPanel.getBounds().contains(x,y);
    }
    public boolean isSecondFieldBounds(int x,int y){
        return   secondFieldPanel.getBounds().contains(x,y);
    }

    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
        if (game.currentTurn== Game.TURN.FIRST_PLAYER_TURN){
            firstFieldPanel.isWarFog=false;
            secondFieldPanel.isWarFog=true;
        }else {
            firstFieldPanel.isWarFog=true;
            secondFieldPanel.isWarFog=false;
        }
        firstFieldPanel.repaint();
        secondFieldPanel.repaint();
    }
}
