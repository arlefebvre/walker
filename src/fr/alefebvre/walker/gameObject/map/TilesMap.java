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

        TileObject[][] tiles = getTileObjects();
        image = renderImage(tiles);
    }

    private BufferedImage renderImage(TileObject[][] tiles) {
        int width = Constants.MAX_MAP_COLUMNS * Constants.TILE_SIZE;
        int height = Constants.MAX_MAP_ROWS * Constants.TILE_SIZE;
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                TileObject tile = tiles[i][j];
                Image img = tile.getImage();
                int h = i * Constants.TILE_SIZE; //lignes > Height
                int w = j * Constants.TILE_SIZE;
                Graphics g = result.getGraphics();
                g.drawImage(img, w, h, Constants.TILE_SIZE, Constants.TILE_SIZE, null);
                if(Constants.SHOW_TILES_BORDER){
                    g.setColor(Color.RED);
                    g.drawRect(w, h, Constants.TILE_SIZE, Constants.TILE_SIZE);
                }
            }
        }
        return result;
    }

    private TileObject[][] getTileObjects() {
        TileObject[][] tiles = new TileObject[Constants.MAX_MAP_ROWS][Constants.MAX_MAP_COLUMNS];
        ArrayList<ArrayList<TileObject>> mapFromText = TextToMapHelper.GenerateMapFromText(Constants.TEST_MAP_PATH);
        int imax = mapFromText.size();
        int jmax = 0;
        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            if(i<imax)
                jmax = mapFromText.get(i).size();
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                if (i < imax && j < jmax)
                    tiles[i][j] = mapFromText.get(i).get(j);
                else
                    tiles[i][j] = new TileObject(TilesEnum.UNKNOWN);
            }
        }
        return tiles;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.image, 0, 0, null);
    }
}
