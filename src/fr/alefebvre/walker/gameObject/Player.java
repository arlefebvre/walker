package fr.alefebvre.walker.gameObject;

import fr.alefebvre.walker.application.GameHandler;
import fr.alefebvre.walker.common.Constants;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject {

    private int size;

    private GameHandler handler;

    public Player(int x, int y, int velX, int velY, GameHandler handler) {
        super(x, y, GameObjectId.Player, velX, velY);
        this.size = Constants.TILE_SIZE;
        this.handler = handler;
    }

    public void tick() {
        x += velX;
        y += velY;
        int xMax = Constants.MAX_MAP_COLUMNS * Constants.TILE_SIZE - size;
        int yMax = Constants.MAX_MAP_ROWS * Constants.TILE_SIZE - size;
        x = Helper.Clamp(x, 0, xMax);
        y = Helper.Clamp(y, 0, yMax);
        boolean collision = false;
        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject temp = handler.getObjects().get(i);
            if (temp.getId() == GameObjectId.MapElement
                    && temp.isYouShallNotPass()
                    && this.getBounds().intersects(temp.getBounds())) {

                collision = true;
                break;
            }
        }
        if (collision) {
            x -= velX;
            y -= velY;
        }
    }

    public void render(Graphics g) {
        ImageIcon icon = new ImageIcon(Constants.PLAYER_IMG);
        g.drawImage(icon.getImage(), x, y, size, size, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
