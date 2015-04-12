package fr.alefebvre.walker.gameObject.map;

import fr.alefebvre.walker.common.Constants;
import fr.alefebvre.walker.gameObject.GameObject;
import fr.alefebvre.walker.gameObject.GameObjectId;

import javax.swing.*;
import java.awt.*;

public class TileObject extends GameObject{

    private Image image;

    private int size;

    public TileObject(int x, int y,TilesEnum type) {
        super(x,y, GameObjectId.MapElement);
        String path;
        switch (type) {
            case GRASS:
                path = Constants.TILE_GRASS_IMG;
                break;
            case TREE:
                path = Constants.TILE_TREE_IMG;
                break;
            default:
                path = Constants.TILE_UNKNOWN_IMG;
                break;
        }
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage();
        this.size = Constants.TILE_SIZE;
    }

    public void tick() {}

    public void render(Graphics g) {
        g.drawImage(image, x, y, size, size, null);
        if(Constants.SHOW_TILES_BORDER){
            g.setColor(Color.RED);
            g.drawRect(x, y, size, size);
        }
    }
}
