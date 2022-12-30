package group24.piazzapanic.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

import group24.piazzapanic.maths.Vector2;
import group24.piazzapanic.ui.FontHandler;
import group24.piazzapanic.Base;
import group24.piazzapanic.levelElements.stations.*;

public class GameLoop extends Stage {
    private float gameTime;
    private float sinceLastSpawn;
    private ArrayList<Customer> customers;
    private Label scoreCounter;
    public Integer score;
    public static GameLoop activeGameLoop;
    
    private Level level;
    private Player player;
    private int offsetX = 300; //offsets for the camera, in pixels.
    private int offsetY = 300;

    public GameLoop() {
        this.gameTime = 0f;
        this.sinceLastSpawn = 0f;
        this.score = 0;
        customers = new ArrayList<Customer>();

        //Create score counter
        LabelStyle style = new LabelStyle();
        style.font = FontHandler.subtitleFormat;
        style.fontColor = Color.WHITE;
        CharSequence count = Integer.toString(score);
        scoreCounter = new Label(count, style);
        Vector2 pos = new Vector2(0.95, 0.9);
        scoreCounter.setPosition(pos.getAbsoluteX(), pos.getAbsoluteY(), Align.bottomLeft);
        this.addActor(scoreCounter);
        
        //Gameloop should be static, however stage cannot be static
        //So this kinda works to let functions be called statically
        GameLoop.activeGameLoop = this;
        // ^ This is very hacky! Just creating a gameloop instance (and that gameloop becomes
        // active) means "this" gameloop is no longer active, which can make things very hard to
        // debug if we make a mistake anywhere else. - Joss

        level = new Level("levels/Level 1");
        player = new Player(level.startX + 0.5, level.startY + 0.5);
    }

    public static void addScore(int score) {
        GameLoop.activeGameLoop.score += score;
        CharSequence count = Integer.toString(score);
        GameLoop.activeGameLoop.scoreCounter.setText(count);
    }

    public static void setActiveLoop(GameLoop game) {
        GameLoop.activeGameLoop = game;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.gameTime += delta;
        this.sinceLastSpawn += delta;

        if (this.sinceLastSpawn >= 5 && customers.size() < 5) {
            //Create new customer offset location.
            Customer customer = new Customer();
            customer.setX(customers.size() * (Customer.entityWidth + 30));
            customers.add(customer);
            this.addActor(customer);
            this.sinceLastSpawn = 0;
        }

        // Run player movement and physics, it's quite long so I put it in a separate function.
        playerMovement(player, delta);
    }

    /**
     * Checks if the given coordinates are solid (i.e. a station is there).
     * @param x Decimal x position.
     * @param y Decimal y position.
     * @return Whether there is not a station at grid[floor(x)][floor(y)].
     */
    public boolean isSolid(double x, double y) {
        x = Math.floor(x);
        y = Math.floor(y);

        if (x < 0 || y < 0 || x >= level.getWidth() || y >= level.getHeight()) {
            return true;
        }

        return level.getStation((int) x, (int) y) != null;
    }

    public void playerMovement(Player player, float delta) {
        /*
        We know:
        U (player's current velocity)
        A (acceleration, this is a constant)
        T (time since last frame)
        
        We don't know S and we're trying to find V.
        
        V = U + AT.
        
        (new vel)    (old vel)
        player_vel = player_vel + acceleration * delta;
        */
        if (Gdx.input.isKeyPressed(Base.UP_KEY)) {
            // This is just the implementation of the formula above.
            player.y_vel += Player.acceleration * delta;
        } else if (Gdx.input.isKeyPressed(Base.DOWN_KEY)) {
            player.y_vel -= Player.acceleration * delta;
        } else {
            // If the player is not pressing up or down, we need to deaccelerate in that direction.
            if (player.y_vel > 0) {
                player.y_vel -= Player.deacceleration * delta;
            } else if (player.y_vel < 0) {
                player.y_vel += Player.deacceleration * delta;
            }
        }

        if (Gdx.input.isKeyPressed(Base.LEFT_KEY)) {
            player.x_vel -= Player.acceleration * delta;
        } else if (Gdx.input.isKeyPressed(Base.RIGHT_KEY)) {
            player.x_vel += Player.acceleration * delta;
        } else {
            // If the player is not pressing left or right, we need to deaccelerate in that direction.
            if (player.x_vel > 0) {
                player.x_vel -= Player.deacceleration * delta;
            } else if (player.x_vel < 0) {
                player.x_vel += Player.deacceleration * delta;
            }
        }

        // Prevent the player from moving faster than the maximum speed.
        if (player.x_vel > Player.maxSpeed) {
            player.x_vel = Player.maxSpeed;
        } else if (player.x_vel < -Player.maxSpeed) {
            player.x_vel = -Player.maxSpeed;
        }
        if (player.y_vel > Player.maxSpeed) {
            player.y_vel = Player.maxSpeed;
        } else if (player.y_vel < -Player.maxSpeed) {
            player.y_vel = -Player.maxSpeed;
        }

        // If the player is going ***really slow***, just set their speed to 0.
        if (Math.abs(player.x_vel) < 0.01) {
            player.x_vel = 0;
        }
        if (Math.abs(player.y_vel) < 0.01) {
            player.y_vel = 0;
        }

        // How far the player will move in this frame.
        double delta_x = player.x_vel * delta;
        double delta_y = player.y_vel * delta;

        // Work out collisions with stations in the level.
        if (delta_x > 0 &&
                ( isSolid(player.right() + delta_x, player.top() + delta_x) || isSolid(player.right() + delta_x, player.bottom() + delta_x) )) {
                    // If you are moving right, *and* there is something obstructing any of the two
                    // points on the right most edge, then decrease delta_x and set x_vel to 0 so
                    // that you stop just at the edge of the object.

            player.x_vel = 0;
            delta_x = Math.floor(player.right() + delta_x) - player.right() - Player.movementEpsilon;
            //         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            // This is the x position of the object's edge.
        }
        if (delta_x < 0 && ( isSolid(player.left() + delta_x, player.top() + delta_x) || isSolid(player.left() + delta_x, player.bottom() + delta_x) )) {   
            player.x_vel = 0;
            delta_x = Math.ceil(player.left() + delta_x) - player.left() + Player.movementEpsilon;
        }
        if (delta_y > 0 && ( isSolid(player.right() + delta_y, player.top() + delta_y) || isSolid(player.left() + delta_y, player.top() + delta_y) )) {
            player.y_vel = 0;
            delta_y = Math.floor(player.top() + delta_y) - player.top() - Player.movementEpsilon;
        }
        if (delta_y < 0 && ( isSolid(player.right() + delta_y, player.bottom() + delta_y) || isSolid(player.left() + delta_y, player.bottom() + delta_y) )) {   
            player.y_vel = 0;
            delta_y = Math.ceil(player.bottom() + delta_y) - player.bottom() + Player.movementEpsilon;
        }

        // Move the player.
        player.x += delta_x;
        player.y += delta_y;
    }

    /**
     * Draws all level elements, floor tiles, players and (yet to be implemented) customers.
     */
    @Override
    public void draw() {
        ScreenUtils.clear(0.8f, 0.8f, 0.8f, 1);
        super.draw();

        // Iterate through level array and draw tiles.
        Vector2 curPosition;
        Texture curTexture = Base.errorTexture;
        Station curStation;
        // Make sure the tiles are drawn first higher up the screen.
        for (int y = level.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < level.getWidth(); x++) {
                curPosition = Vector2.gridUnitTranslate(x, y);
                Base.batch.draw(Base.floorTexture, curPosition.getAbsoluteX() + offsetX, curPosition.getAbsoluteY() + offsetY, Base.tile_pixel_width, Base.tile_pixel_height);

                curStation = level.getStation(x, y);
                
                if (curStation == null) {
                    // In this case you only need to draw the floor, which has already been done.
                    continue;
                } else if (curStation instanceof BakingStation) {
                    curTexture = Base.bakingStationTexture;
                } else if (curStation instanceof CounterTop) {
                    curTexture = Base.counterTopTexture;
                } else if (curStation instanceof CuttingStation) {
                    curTexture = Base.cuttingStationTexture;
                } else if (curStation instanceof FryingStation) {
                    curTexture = Base.fryingStationTexture;
                } else if (curStation instanceof IngredientStation) {
                    curTexture = Base.ingredientStationTexture;
                } else if (curStation instanceof Obstacle) {
                    curTexture = Base.obstacleTexture;
                } else {
                    System.out.println("Unknown station type: " + curStation + ", defaulting to floor.");
                    curTexture = Base.errorTexture;
                }

                Base.batch.draw(curTexture, curPosition.getAbsoluteX() + offsetX, curPosition.getAbsoluteY() + offsetY, Base.tile_pixel_width, Base.tile_pixel_height);
            }
        }
        
        Vector2 playerPosition = Vector2.gridUnitTranslate((float) player.x, (float) player.y);
        Base.batch.draw(Base.tempChefTexture, playerPosition.getAbsoluteX() + offsetX, playerPosition.getAbsoluteY() + offsetY, (float) Player.GRID_WIDTH * Base.tile_pixel_width, (float) Player.GRID_WIDTH * Base.tile_pixel_width * Player.TEXTURE_HEIGHT / Player.TEXTURE_WIDTH);
    }
}
