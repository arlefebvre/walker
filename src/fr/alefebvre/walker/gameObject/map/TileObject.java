package fr.alefebvre.walker.gameObject.map;

import fr.alefebvre.walker.common.Constants;

import javax.swing.*;
import java.awt.*;

public class TileObject {

    private Image image;

    public TileObject(TilesEnum type) {
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
    }

    public Image getImage() {
        return image;
    }
}
