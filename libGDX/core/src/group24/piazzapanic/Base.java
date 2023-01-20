package group24.piazzapanic;

import java.util.Scanner;
import java.io.File;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input.Keys;


import group24.piazzapanic.Physics.AnimatedMovable;
import group24.piazzapanic.game.Player;
import group24.piazzapanic.ui.StageAnimation;

/** Core values like screen size, that will need to access, but nothing will need to modify.
 * THIS CLASS *MUST* HAVE NO DEPENDENCIES ON OTHER CLASSES IN THIS PROJECT.
 */
public class Base {
    public static final boolean DEBUG = true;
    public static String CONFIG_PATH = "config.txt";

    public static int WINDOW_WIDTH = 100;
    public static int WINDOW_HEIGHT = 100;

    // These 2 numbers below work best if they make a nice ratio (eg 1:2).
    public static final int TILE_TEXTURE_WIDTH = 100;
    public static final int TILE_TEXTURE_HEIGHT = 200;
    public static final float TILE_GRID_UNIT = 0.05f; // 20 tiles fit within one screen width.
    public static int tile_pixel_width;
    public static int tile_pixel_height;

    public static SpriteBatch batch;

    public static StageAnimation initialChefAnimation;
    public static Texture debugSquareTexture;

    public static Texture floorTexture;
    public static Texture bakingStationTexture;
    public static Texture counterTopTexture;
    public static Texture cuttingStationTexture;
    public static Texture fryingStationTexture;
    public static Texture ingredientStationTexture;
    public static Texture obstacleTexture;

    public static Texture errorTexture;
    // Don't declare any unused textures otherwise gradle just inexplicably dies permanently.
    public static final int UP_KEY = Keys.W;
    public static final int DOWN_KEY = Keys.S;
    public static final int LEFT_KEY = Keys.A;
    public static final int RIGHT_KEY = Keys.D;
    public static final int ACT_KEY = Keys.F;
    public static final int SELECT_KEY = Keys.ENTER;
    // SELECT_KEY just clicks the "first" option in a given menu. Useful to ignore UI bugs when
    // developing non-UI features.

    /**
     * Read the config file and set the values of the variables in this class.
     * This method should be called before any other code runs.
     */
    public static void init() {
        // Read config file.
        try {
            Scanner scanner = new Scanner(new File(CONFIG_PATH));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.strip().equals("")) {
                    continue;
                }

                String[] split = line.split("=");
                if (split.length != 2) {
                    System.out.println("Invalid line syntax: '" + line + "'.");
                    if (split.length == 1) {
                        throw new Exception("Invalid config file - no argument supplied.");
                    } else if (split.length > 2) {
                        throw new Exception("Invalid config file - too many arguments.");
                    } else {
                        throw new Exception("Invalid config file - bad length array (" + split.length + ").");
                    }
                }
                String left = split[0];
                String right = split[1];

                if (left.equals("resolution")) {
                    String[] resolutionStr = right.split("x");
                    if (resolutionStr.length != 2) {
                        System.out.println("Bad resolution: '" + right + "'.");
                        if (resolutionStr.length == 1) {
                            throw new Exception("Invalid config file - only one dimension supplied.");
                        } else if (resolutionStr.length > 2) {
                            throw new Exception("Invalid config file - too many dimensions supplied.");
                        } else {
                            throw new Exception("Invalid config file - bad dimensions (" + resolutionStr.length
                                    + " parameters given).");
                        }
                    }

                    // Check if the strings are numeric.
                    for (int i = 0; i < resolutionStr[0].length(); i++) {
                        if (!Character.isDigit(resolutionStr[0].charAt(i))) {
                            System.out.println("Bad Dimension: '" + resolutionStr[0] + "'.");
                            throw new Exception("Invalid config file - non-numeric width.");
                        }
                    }
                    for (int i = 0; i < resolutionStr[1].length(); i++) {
                        if (!Character.isDigit(resolutionStr[1].charAt(i))) {
                            System.out.println("Bad Dimension: '" + resolutionStr[1] + "'.");
                            throw new Exception("Invalid config file - non-numeric height.");
                        }
                    }

                    WINDOW_WIDTH = Integer.parseInt(resolutionStr[0]);
                    WINDOW_HEIGHT = Integer.parseInt(resolutionStr[1]);
                } else {
                    System.out.println("Unknown key: '" + left + "=...' .");
                    throw new Exception("Invalid config file - unknown key");
                }
            }
            scanner.close();
        } catch (Exception exception) {
            System.out.println("Error reading config file, Using default settings");
            WINDOW_WIDTH = 1280;
            WINDOW_HEIGHT = 720;
            exception.printStackTrace();
        }

        tile_pixel_width = (int) Math.floor(TILE_GRID_UNIT * WINDOW_WIDTH);
        tile_pixel_height = (int) Math
                .round(tile_pixel_width * ((double) Base.TILE_TEXTURE_HEIGHT) / Base.TILE_TEXTURE_WIDTH);

        batch = new SpriteBatch();

        initialChefAnimation = new AnimatedMovable("chef/chef_idle_front.png", 6, 6, 1, 0, 0, Player.TEXTURE_WIDTH, Player.TEXTURE_HEIGHT);
        debugSquareTexture = new Texture("debugsquare.png");

        // Load station textures.
        floorTexture = new Texture("stations/floor.png");
        bakingStationTexture = new Texture("stations/bakingstation.png");
        counterTopTexture = new Texture("stations/countertop.png");
        cuttingStationTexture = new Texture("stations/notimplemented.png");
        fryingStationTexture = new Texture("stations/notimplemented.png");
        ingredientStationTexture = new Texture("stations/ingredientstation.png");
        obstacleTexture = new Texture("stations/wall.png");

        errorTexture = new Texture("stations/sourceerr.png");
    }

    /**
     * Basically the opposite of init (without the config file reading), this method should be the
     * last thing called before the program exits.
     */
    public static void dispose() {
        batch.dispose();

        debugSquareTexture.dispose();

        floorTexture.dispose();
        bakingStationTexture.dispose();
        counterTopTexture.dispose();
        cuttingStationTexture.dispose();
        fryingStationTexture.dispose();
        ingredientStationTexture.dispose();
        obstacleTexture.dispose();

        errorTexture.dispose();
    }
}
