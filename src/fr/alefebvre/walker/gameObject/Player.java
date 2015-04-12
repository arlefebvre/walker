package fr.alefebvre.walker.gameObject;

import fr.alefebvre.walker.common.Constants;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y) {
        super(x, y, GameObjectId.Player);
    }

    public Player(int x, int y, int velX, int velY) {
        this(x, y);
        this.velX = velX;
        this.velY = velY;
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Helper.Clamp(x, 0, Constants.WIDTH - 30);
        y = Helper.Clamp(y, 0, Constants.HEIGHT - 30);
    }

    public void render(Graphics g) {
        ImageIcon icon = new ImageIcon(Constants.PLAYER_IMG);
        g.drawImage(icon.getImage(),x, y, null);
    }
}
