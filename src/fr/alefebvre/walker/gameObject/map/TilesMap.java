package fr.alefebvre.walker.gameObject.map;

import fr.alefebvre.walker.common.Constants;
import fr.alefebvre.walker.gameObject.BasicGameObject;
import fr.alefebvre.walker.gameObject.GameObjectId;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class TilesMap extends BasicGameObject {

    private BufferedImage image;

    private TileObject[][] tiles;

    public TilesMap(int x, int y, String mapPath) {
        super(x, y, GameObjectId.BackgroundMap);

        this.tiles = getTileObjects(mapPath, Constants.TILE_SIZE);
        image = renderImage();
    }

    private BufferedImage renderImage() {
        int width = Constants.MAX_MAP_COLUMNS * Constants.TILE_SIZE;
        int height = Constants.MAX_MAP_ROWS * Constants.TILE_SIZE;
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                TileObject tile = this.tiles[i][j];
                Graphics g = result.getGraphics();
                tile.render(g);
            }
        }
        return result;
    }

    private TileObject[][] getTileObjects(String mapPath, int tileSize) {
        TileObject[][] tiles = new TileObject[Constants.MAX_MAP_ROWS][Constants.MAX_MAP_COLUMNS];
        ArrayList<ArrayList<TileObject>> mapFromText = TextToMapHelper.GenerateMapFromText(mapPath, x, y, tileSize);
        int iMax = mapFromText.size();
        int jMax = 0;
        for (int i = 0; i < Constants.MAX_MAP_ROWS; i++) {
            if (i < iMax)
                jMax = mapFromText.get(i).size();
            for (int j = 0; j < Constants.MAX_MAP_COLUMNS; j++) {
                if (i < iMax && j < jMax)
                    tiles[i][j] = mapFromText.get(i).get(j);
                else
                    tiles[i][j] = new TileObject(x + i * tileSize, y + j * tileSize, TilesEnum.UNKNOWN);
            }
        }
        return tiles;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }

    public ArrayList<TileObject> getTiles() {
        ArrayList<TileObject> result = new ArrayList<>();
        for (TileObject[] tilesRow : tiles)
            Collections.addAll(result, tilesRow);
        return result;
    }
}
