package fr.alefebvre.walker.gameObject;

import javax.swing.*;
import java.awt.*;

public class BackgroundMap extends GameObject {

    protected Image image;

    public BackgroundMap(int x, int y, String cheminImage) {
        super(x, y, GameObjectId.BackgroundMap, 0, 0);
        ImageIcon icon = new ImageIcon(cheminImage);
        this.image = icon.getImage();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);

    }

}
