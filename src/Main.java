import console.CLI;
import graphic.Window;
import logic.Game;
import newGraphic.GUI;

public class Main {
    public static void main(String[] args) {
         //CLI cli = new CLI();
         //cli.play();
        GUI mainWindow = new GUI(new Game());
        mainWindow.setVisible(true);
    }
}