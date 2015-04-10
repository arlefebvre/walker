package fr.alefebvre.walker.common;

// TODO a gérer sous une autre forme?
public abstract class Constants {

    public final static String IMAGES_PATH = "resources/images/";
    public final static String MAPS_PATH = "resources/maps/";

    public final static String PLAYER_IMG = IMAGES_PATH + "pokemon.gif";

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static final int SCALEDWIDTH = WIDTH * SCALE;
    public static final int SCALEDHEIGHT = HEIGHT * SCALE;
    public final static int TILESIZE = 32;
    public final static String TITLE = "Walker";

    public static final String TEST_MAP_PATH = MAPS_PATH + "map.txt";

    public final static int MAX_MAP_ROWS = 5;
    public final static int MAX_MAP_COLUMNS = 12;
}
