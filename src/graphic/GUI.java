package graphic;

import logic.Game;
import logic.players.ai.AIPlayer;
import logic.players.ai.EasyAI;
import logic.players.ai.NormalAI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    /*TODO
    Доработать repaint, а именно момент с туманом войны.
    Доработать GridLayout.
    Разобраться с button.


     */
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

        //firstFieldPanel.setLayout(null);
        //secondFieldPanel.setLayout(null);

       commandPanel = new CommandPanel();
       commandPanel.setSize(getWidth(),getHeight()/10);
       firstFieldPanel.setSize(getWidth()/2,getWidth()/2);
       secondFieldPanel.setSize(getWidth()/2,getWidth()/2);
       commandPanel.setVisible(true);

        setTitle("Sea Battle, Swing version");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel p= (JPanel) getContentPane();


        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;

// The same for rows
        c.weighty = 1;

// Let the buttons to occupy entire cells
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridy = 0; // Starting the first row
        c.gridwidth = 2;
        p.add(commandPanel, c);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 1;
        c.gridy++; // Switching to next row
        p.add(firstFieldPanel,c);
        p.add(secondFieldPanel, c);

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
            if (!(game.player2 instanceof EasyAI) && !(game.player2 instanceof NormalAI))firstFieldPanel.isWarFog=false;
            //else firstFieldPanel.isWarFog=true;
           if (!(game.player1 instanceof EasyAI) && !(game.player1 instanceof NormalAI))secondFieldPanel.isWarFog=true;
           //else secondFieldPanel.isWarFog=false;
        }
        else {
            if (!(game.player2 instanceof EasyAI) && !(game.player2 instanceof NormalAI))firstFieldPanel.isWarFog=true;
            //else firstFieldPanel.isWarFog=false;
            if (!(game.player1 instanceof EasyAI) && !(game.player1 instanceof NormalAI))secondFieldPanel.isWarFog=false;
            //else secondFieldPanel.isWarFog=true;
        }
        //commandPanel.setSize(getWidth(),getHeight()/10);
        commandPanel.repaint();
        //firstFieldPanel.setSize(getWidth()/2,getHeight()/2);
        firstFieldPanel.repaint();
        //secondFieldPanel.setSize(getWidth()/2,getHeight()/2);
        secondFieldPanel.repaint();
    }
}
