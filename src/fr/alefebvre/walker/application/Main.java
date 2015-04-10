package fr.alefebvre.walker.application;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GameWindow frame = new GameWindow(game);
        frame.setVisible(true);
        game.start();
    }

}
