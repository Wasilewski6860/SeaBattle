package newGraphic;

import logic.Game;
import logic.players.HumanGUIPlayer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

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

}
