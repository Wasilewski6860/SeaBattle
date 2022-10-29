package graphic;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {
    public Button start;
    public Button changeFirstPlayer;
    public Button changeSecondPlayer;

    public CommandPanel() {
        start=new Button(0,0,100,50, Color.RED,"Start");
        changeFirstPlayer=new Button(150,0,100,50,Color.RED,"ChangeFP");
        changeSecondPlayer=new Button(300,0,100,50,Color.RED,"ChangeSP");
        this.setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        start.draw(g);
        changeFirstPlayer.draw(g);
        changeSecondPlayer.draw(g);
    }
}
