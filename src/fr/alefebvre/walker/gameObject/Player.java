package fr.alefebvre.walker.gameObject;

import fr.alefebvre.walker.common.Constants;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject {

    private int size;

    public Player(int x, int y) {
        super(x, y, GameObjectId.Player);
        this.size = Constants.TILE_SIZE;
    }

    public Player(int x, int y, int velX, int velY) {
        this(x, y);
        this.velX = velX;
        this.velY = velY;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Helper.Clamp(x, 0, Constants.MAX_MAP_COLUMNS*Constants.TILE_SIZE-size);
        y = Helper.Clamp(y, 0, Constants.MAX_MAP_ROWS*Constants.TILE_SIZE-size);
    }

    public void render(Graphics g) {
        ImageIcon icon = new ImageIcon(Constants.PLAYER_IMG);
        g.drawImage(icon.getImage(),x, y,size,size, null);
    }
}
