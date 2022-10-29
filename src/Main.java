
import logic.Game;
import graphic.GUI;

public class Main {
    public static void main(String[] args) {
         //CLI cli = new CLI();
         //cli.play();
        GUI mainWindow = new GUI(new Game());
        mainWindow.setVisible(true);
    }
}