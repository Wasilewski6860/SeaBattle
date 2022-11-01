package graphic;

import javax.swing.*;
import java.awt.*;

public class CommandPanel extends JPanel {
    public Button start;
    public Button changeFirstPlayer;
    public Button changeSecondPlayer;

    public CommandPanel() {
        start=new Button(0,0,100,50, "assets/buttons/start.png");
        changeFirstPlayer=new Button(150,0,100,50,"assets/buttons/changeFirstPlayer.png");
        changeSecondPlayer=new Button(300,0,100,50,"assets/buttons/changeSecondPlayer.png");
        this.setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        start.draw((Graphics2D) g);
        setBackground(Color.BLUE);
        changeFirstPlayer.draw((Graphics2D)g);
        changeSecondPlayer.draw((Graphics2D)g);
    }
}
