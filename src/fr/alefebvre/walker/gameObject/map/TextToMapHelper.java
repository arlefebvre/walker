package fr.alefebvre.walker.gameObject.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class TextToMapHelper {
    private static final String SEPARATOR = ";";

    public static ArrayList<ArrayList<TileObject>> GenerateMapFromText(String filePath, int x, int y, int tileSize) {
        FileReader fileReader;
        ArrayList<ArrayList<TileObject>> tiles = new ArrayList<>();
        try {
            fileReader = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(fileReader);
            String line;
            int row = 0;
            while ((line = bReader.readLine()) != null) {
                tiles.add(mapLine(line, row, x, y, tileSize));
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    private static ArrayList<TileObject> mapLine(String line, int row, int x, int y, int tileSize) {
        String[] strings = line.split(SEPARATOR);
        ArrayList<TileObject> tiles = new ArrayList<>();
        int column = 0;
        for (String string : strings) {
            tiles.add(mapTile(string, row, column, x, y, tileSize));
            column++;
        }
        return tiles;
    }

    private static TileObject mapTile(String s, int row, int column, int mapX, int mapY, int tileSize) {
        int x, y;
        x = mapX + column * tileSize;
        y = mapY + row * tileSize;
        return new TileObject(x, y, TextToTilesEnum(s));
    }

    private static TilesEnum TextToTilesEnum(String s) {
        switch (s) {
            case "G":
                return TilesEnum.GRASS;
            case "T":
                return TilesEnum.TREE;
            case "H":
                return TilesEnum.HOUSE;
            default:
                return TilesEnum.UNKNOWN;
        }
    }
}
