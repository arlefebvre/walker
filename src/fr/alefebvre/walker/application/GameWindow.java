package fr.alefebvre.walker.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    public Game game;

    public GameWindow(Game game) {
        super(game.TITLE);
        this.game = game;
        this.setIconImage(new ImageIcon("images/icone.png").getImage());
        this.add(game);
        JMenuItem menuItemNew = new JMenuItem("Nouvelle partie");
        menuItemNew.addActionListener(new GameListener(this));

        // TODO A reactiver plus tard.
        // Il faut régler le pb de ConcurrentModificationException lors du clear a l'initialisation d'une nouvelle partie
        menuItemNew.setEnabled(false);

        JMenuItem menuItemQuit = new JMenuItem("Arrêter");
        menuItemQuit.addActionListener(event -> System.exit(0));
        JMenu menuFile = new JMenu("Fichier");
        menuFile.add(menuItemNew);
        menuFile.add(menuItemQuit);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private class GameListener implements ActionListener {

        private GameWindow gameWindow;

        public GameListener(GameWindow gameWindow) {
            super();
            this.gameWindow = gameWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gameWindow.game.initialize();
        }
    }


}
