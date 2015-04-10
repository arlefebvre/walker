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

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Helper.Clamp(x, 0, Constants.SCALEDWIDTH - 30);
        y = Helper.Clamp(y, 0, Constants.SCALEDHEIGHT - 30);
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillOval(x, y, 25, 25);
        ImageIcon icon = new ImageIcon(Constants.PLAYER_IMG);
        Image myImage = icon.getImage();
        g.drawImage(myImage, x, y, null);
    }


}
