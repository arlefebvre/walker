package fr.alefebvre.walker.gameObject.map;

import javax.swing.*;
import java.awt.*;

public class TileObject {

    private Image image;

    public TileObject(TilesEnum type) {
        String path;
        switch (type) {
            case GRASS:
                path = "resources/images/grass.png";
                break;
            case TREE:
                path = "resources/images/tree.png";
                break;
            default:
                path = "resources/images/pokemon.gif";
                break;
        }
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage();
    }

    public Image getImage() {
        return image;
    }
}
