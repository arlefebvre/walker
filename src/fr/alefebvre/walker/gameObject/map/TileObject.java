package fr.alefebvre.walker.gameObject.map;

import fr.alefebvre.walker.common.Constants;
import fr.alefebvre.walker.gameObject.GameObject;
import fr.alefebvre.walker.gameObject.GameObjectId;

import javax.swing.*;
import java.awt.*;

public class TileObject extends GameObject {

    private Image image;

    private int size;

    public TileObject(int x, int y, TilesEnum type) {
        super(x, y, GameObjectId.MapElement);
        String path;
        switch (type) {
            case GRASS:
                path = Constants.TILE_GRASS_IMG;
                youShallNotPass = false;
                break;
            case TREE:
                path = Constants.TILE_TREE_IMG;
                youShallNotPass = true;
                break;
            case HOUSE:
                path = Constants.TILE_HOUSE_IMG;
                youShallNotPass = true;
                break;
            default:
                path = Constants.TILE_UNKNOWN_IMG;
                youShallNotPass = true;
                break;
        }
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage();
        this.size = Constants.TILE_SIZE;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, size, size, null);
        if (Constants.SHOW_TILES_BORDER) {
            if (youShallNotPass)
                g.setColor(Color.RED);
            else
                g.setColor(Color.GREEN);
            g.drawRect(x, y, size - 1, size - 1);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
