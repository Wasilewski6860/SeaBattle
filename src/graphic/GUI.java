package graphic;

import logic.Game;
import logic.players.ai.EasyAI;
import logic.players.ai.NormalAI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    /*
    TODO
    Доработать repaint, а именно момент с туманом войны.
    Доработать GridLayout.
    Разобраться с button.


     */
    private Image backgroundImage;
    public Game game;
    private GraphicGameController gameController;

    public FieldPanel firstFieldPanel;
    public FieldPanel secondFieldPanel;
    public CommandPanel commandPanel;
    public ControlPanel scorePanel;

    public GUI(Game game) throws HeadlessException {
        this.game = game;


       // /*
        this.setSize(1912 ,950);
        //setResizable(false);
        gameController=new GraphicGameController(game,this);
        backgroundImage = new ImageIcon("assets/img/command_panel_background.png").getImage();

        this.addMouseListener(gameController);
        this.addKeyListener(gameController);

        //ip = new ImagePanel(backgroundImage,getWidth(),getHeight());
        //setContentPane(ip);

        firstFieldPanel=new FieldPanel(game.getPlayer1().getPlayerBattlefield(),false);
        secondFieldPanel=new FieldPanel(game.getPlayer2().getPlayerBattlefield(), false);

        //firstFieldPanel.setLayout(null);
        //secondFieldPanel.setLayout(null);

       commandPanel = new CommandPanel();
       scorePanel = new ControlPanel();
       //commandPanel.setSize(1980,1980/10);
       //firstFieldPanel.setSize(getWidth()/2,getWidth()/2);
       //secondFieldPanel.setSize(getWidth()/2,getWidth()/2);
        commandPanel.setFocusable(true);
       commandPanel.setVisible(true);
        scorePanel.setFocusable(true);
        scorePanel.setVisible(true);

        add(commandPanel = new CommandPanel(), BorderLayout.NORTH);
        add(firstFieldPanel=new FieldPanel(game.getPlayer1().getPlayerBattlefield(),false), BorderLayout.WEST);
        add(secondFieldPanel=new FieldPanel(game.getPlayer2().getPlayerBattlefield(), false), BorderLayout.CENTER);
        add(scorePanel,BorderLayout.SOUTH);
        // */


         /*

//        setTitle("Sea Battle, Swing version");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//
//        JPanel p= (JPanel) getContentPane();
//         // В области рисования, конечно же
//
//        p.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//
//        c.weightx = 1;
//
//// The same for rows
//        c.weighty = 1;
//
//// Let the buttons to occupy entire cells
//        c.fill = GridBagConstraints.HORIZONTAL;
//
//        c.gridy = 0; // Starting the first row
//        c.gridwidth = 2;
//        p.add(commandPanel, c);
//        c.fill = GridBagConstraints.BOTH;
//        c.gridwidth = 1;
//        c.gridy++; // Switching to next row
//        p.add(firstFieldPanel,c);
//        p.add(secondFieldPanel, c);

        //setSize(commandPanel.getSize().width,commandPanel.getHeight()+firstFieldPanel.getHeight());

          */

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
        if (game.getCurrentTurn()== Game.TURN.FIRST_PLAYER_TURN){
            if (!(game.getPlayer2() instanceof EasyAI) && !(game.getPlayer2() instanceof NormalAI))firstFieldPanel.isWarFog=false;
            //else firstFieldPanel.isWarFog=true;
           if (!(game.getPlayer1() instanceof EasyAI) && !(game.getPlayer1() instanceof NormalAI))secondFieldPanel.isWarFog=true;
           //else secondFieldPanel.isWarFog=false;
        }
        else {
            if (!(game.getPlayer2() instanceof EasyAI) && !(game.getPlayer2() instanceof NormalAI))firstFieldPanel.isWarFog=true;
            //else firstFieldPanel.isWarFog=false;
            if (!(game.getPlayer1() instanceof EasyAI) && !(game.getPlayer1() instanceof NormalAI))secondFieldPanel.isWarFog=false;
            //else secondFieldPanel.isWarFog=true;
        }
        //commandPanel.setSize(getWidth(),getHeight()/10);
        //ip.setSize(getSize());
        //ip.repaint();
        commandPanel.repaint();
        scorePanel.repaint();
        //firstFieldPanel.setSize(getWidth()/2,getHeight()/2);
        firstFieldPanel.setBattlefield(game.getPlayer1().getPlayerBattlefield());
        firstFieldPanel.repaint();
        //secondFieldPanel.setSize(getWidth()/2,getHeight()/2);
        secondFieldPanel.setBattlefield(game.getPlayer2().getPlayerBattlefield());
        secondFieldPanel.repaint();
        System.out.println(getWidth()+" "+getHeight());
    }


}
