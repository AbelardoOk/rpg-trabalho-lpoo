import src.main.controller.GameController;

public class Main {
    public static void main(String[] args) throws java.io.IOException{
        System.setProperty("java.awt.headless", "false");
        GameController game = new GameController();
        game.run();
    }
}
