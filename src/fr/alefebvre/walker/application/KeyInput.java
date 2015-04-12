package fr.alefebvre.walker.application;

import fr.alefebvre.walker.gameObject.BasicGameObject;
import fr.alefebvre.walker.gameObject.GameObjectId;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private GameHandler handler;

    public KeyInput(GameHandler gameHandler) {
        this.handler = gameHandler;
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_ESCAPE)
            System.exit(0);

        for (BasicGameObject temp : this.handler.getObjects()) {

            if (temp.getId() == GameObjectId.Player) {
                switch (c) {
                    case KeyEvent.VK_UP:
                        temp.setVelY(-3);
                        break;
                    case KeyEvent.VK_DOWN:
                        temp.setVelY(+3);
                        break;
                    case KeyEvent.VK_LEFT:
                        temp.setVelX(-3);
                        break;
                    case KeyEvent.VK_RIGHT:
                        temp.setVelX(+3);
                        break;
                }
            } else if (temp.getId() == GameObjectId.Menu && c == KeyEvent.VK_ENTER) {
                temp.setVisible(!temp.isVisible());
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
        for (BasicGameObject temp : this.handler.getObjects()) {
            if (temp.getId() == GameObjectId.Player) {
                switch (c) {
                    case KeyEvent.VK_UP:
                        temp.setVelY(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        temp.setVelY(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        temp.setVelX(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        temp.setVelX(0);
                        break;
                }
            }
        }
    }
}
