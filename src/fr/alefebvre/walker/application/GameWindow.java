package fr.alefebvre.walker.application;

import fr.alefebvre.walker.common.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    public Game game;

    public GameWindow(Game game) {
        super(Constants.TITLE);
        this.game = game;
        this.setIconImage(new ImageIcon(Constants.FAVICON).getImage());
        this.add(game);
        JMenu menuFile = new JMenu("Fichier");

        JMenuItem menuItemNew = new JMenuItem("Nouvelle partie");
        menuItemNew.addActionListener(new GameListener(this));
        menuFile.add(menuItemNew);

        JMenuItem menuItemQuit = new JMenuItem("Arrêter");
        menuItemQuit.addActionListener(event -> System.exit(0));
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
