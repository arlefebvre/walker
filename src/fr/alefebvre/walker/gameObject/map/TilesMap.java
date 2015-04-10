package fr.alefebvre.walker.gameObject.map;

import fr.alefebvre.walker.common.Constants;
import fr.alefebvre.walker.gameObject.GameObject;
import fr.alefebvre.walker.gameObject.GameObjectId;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TilesMap extends GameObject {

    private BufferedImage image;

    public TilesMap(int x, int y) {
        super(x, y, GameObjectId.BackgroundMap);

        TileObject[][] tiles = new TileObject[Constants.MAX_MAP_ROWS][Constants.MAX_MAP_COLUMNS];
        ArrayList<ArrayList<TileObject>> mapFromText = TextToMapHelper.GenerateMapFromText(Constants.TEST_MAP_PATH);
        int imax = mapFromText.size();
        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            int jmax = mapFromText.get(i).size();
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                if (i < imax && j < jmax)
                    tiles[i][j] = mapFromText.get(i).get(j);
                else
                    tiles[i][j] = new TileObject(TilesEnum.UNKNOWN);
            }
        }
        //   tiles[0][0] = new TileObject(TilesEnum.TREE);

        int width = Constants.MAX_MAP_COLUMNS * Constants.TILESIZE;
        int height = Constants.MAX_MAP_ROWS * Constants.TILESIZE;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                TileObject tile = tiles[i][j];
                Image img = tile.getImage();
                int h = i * Constants.TILESIZE; //lignes > Height
                int w = j * Constants.TILESIZE;
                Graphics g = image.getGraphics();
                g.drawImage(img, w, h, Constants.TILESIZE, Constants.TILESIZE, null);
                g.setColor(Color.RED);
                g.drawRect(w, h, Constants.TILESIZE, Constants.TILESIZE);
            }
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, 0, 0, null);
    }
}
