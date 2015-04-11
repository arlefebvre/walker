package fr.alefebvre.walker.gameObject.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class TextToMapHelper {
    private static final String SEPARATOR = ";";

    public static ArrayList<ArrayList<TileObject>> GenerateMapFromText(String filePath) {
        FileReader fileReader;
        ArrayList<ArrayList<TileObject>> tiles = new ArrayList<>();
        try {
            fileReader = new FileReader(filePath);
            BufferedReader bReader = new BufferedReader(fileReader);
            String line;
            while ((line = bReader.readLine()) != null) {
                tiles.add(mapLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    private static ArrayList<TileObject> mapLine(String line) {
        String[] strings = line.split(SEPARATOR);
        ArrayList<TileObject> tiles = new ArrayList<>();
        for (String string : strings) {
            tiles.add(mapTile(string));
        }
        return tiles;
    }

    private static TileObject mapTile(String s) {
        return new TileObject(TextToTilesEnum(s));
    }

    private static TilesEnum TextToTilesEnum(String s) {
        switch (s) {
            case "G":
                return TilesEnum.GRASS;
            case "T":
                return TilesEnum.TREE;
            default:
                return TilesEnum.UNKNOWN;
        }
    }
}
