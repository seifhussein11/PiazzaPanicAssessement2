package group24.piazzapanic.game;

/**
 * The Player class encapsulates player data (position, veolocity etc.), but does nothing itself.
 */
public class Player {
    public static final int TEXTURE_WIDTH = 48;
    public static final int TEXTURE_HEIGHT = 96;

    // How wide the player is in grid units. Applies to both "width" and "length"/"height".
    public static final double GRID_WIDTH = 0.8; // Don't set to more than 1.

    public double x;
    public double y;
    public double x_vel = 0;
    public double y_vel = 0;
    public static double acceleration = 5; // Grid units per second squared.
    public static double deacceleration = 10;
    public static double maxSpeed = 4; // Grid units per second.
    public static double minSpeed = 0.1; // The player is deemed still if they are below this.
    public static double movementEpsilon = 0.01; // Just a small number to offset the player from
                                                  //collidable objects.

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the y position of the top of the player's hitbox.
     */
    public double top() {
        return y + GRID_WIDTH / 2;
    }

    /**
     * Returns the y position of the bottom of the player's hitbox.
     */
    public double bottom() {
        return y - GRID_WIDTH / 2;
    }

    /**
     * Returns the x position of the right of the player's hitbox.
     */
    public double right() {
        return x + GRID_WIDTH / 2;
    }

    /**
     * Returns the x position of the left of the player's hitbox.
     */
    public double left() {
        return x - GRID_WIDTH / 2;
    }
}
