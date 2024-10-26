package group24.piazzapanic.levelElements.stations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import group24.piazzapanic.Base;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;

/**
 * Stations allow users to interact with the game environment.
 * Each station holds an "item", a Movable object. If the item is an Ingredient,
 * it can only hold one item.
 * If the item is a dish, it can hold the Dish and multiple Ingredients
 * allowing players to assemble their dishes before they are served to customers.
 */
public class Station extends Image {

    /**
     * A counter of how long the player has been holding the BASE.ACT_KEY key for.
     */
    public float timeKeyHeld;
    public int available = 1;
    public int cost = 5;

    public Texture texture;

    /**
     * Initialise the station class
     *
     * @param Texture the station's texture
     */
    public Station(Texture Texture) {
        super(Texture);
        super.setWidth(Base.tile_pixel_width);
        super.setHeight(Base.tile_pixel_height);
        this.texture=Texture;
    }

    //protected Vector2 location;
    //protected Texture sprite;
    /**
     * The {@link Movable} the station holds.
     */
    public Movable item;

    /**
     * The x coordinate of the station in the grid. Do not change this once it is set.
     */
    private int gridX;
    /**
     * The y coordinate of the station in the grid. Do not change this once it is set.
     */
    private int gridY;
    /**
     * The Station's progress bar
     */
    ProgressBar bar;

    /**
     * Creates a new station. Each station knows its own location.
     *
     * @param gridX The x coordinate of the station in the grid.
     * @param gridY The y coordinate of the station in the grid.
     */
    public Station(int gridX, int gridY) {
        super();
        this.gridX = gridX;
        this.gridY = gridY;

    }

    /**
     * Puts an item on the station.
     * Stations can either:
     * hold a single Ingredient (if an ingredient is already on the station, placeItem will return False and not change the existing ingredient).
     * OR
     * hold a Dish and an unlimited number of Ingredients (to combine into a finished meal)
     *
     * @param item The {@link Movable} to be placed on the station. 
     * @return true if the item was placed, false if the item could not be placed
     */
    public boolean placeItem(Movable item) {
        if (canPlaceItem()) {
            if (this.item instanceof Dish && item instanceof Ingredient) {
                return ((Dish) this.item).addIngredient((Ingredient) item);
            }
            this.item = item;
            return true;
        } else return false;
    } 

    /**
     * A private convenience method to check if an item can be placed on the station.
     *
     * @return True if item can be placed, False otherwise.
     */
    private boolean canPlaceItem() {
        if (hasItem()) {
            return this.item instanceof Dish; // If it's a Dish, return True. Otherwise False.
        }
        return true;
    }



    /**
     * Checks if the station has an item on it.
     *
     * @return True if the station has an item(s) on it. False otherwise.
     */
    public boolean hasItem() {
        return this.item != null;
    }

    /**
     * Pick up the item from the station.
     *
     * @return A Movable of the station's current item, null if it doesn't have an item.
     */
    public Movable takeItem() {
        if (hasItem()) {
            Movable tmp = this.item;
            this.item = null;
            return tmp;
        } else return null;
    }

    /**
     * Draw the station graphic to Batch.
     *
     * @param arg0 libGDX batch to draw to
     * @param arg1 The parent alpha, to be multiplied with this actor's alpha, allowing the parent's alpha to affect all
     *             children.
     */
    @Override
    public void draw(Batch arg0, float arg1) {
        super.draw(arg0, arg1);

    }

    /**
     * A method stub which children override to allow the player to interact with the station.
     *
     * @param delta The time in seconds since the last frame.
     */
    public void interact(float delta) {
    }

    public boolean isEqual(Object obj){
        if(!(obj instanceof Station)){
            return false;
        }
        Station station = (Station) obj;
        if(this.item!=station.item){
            return false;
        }
        if(this.texture != station.texture){
            return false;
        }
        if(this.available != station.available){
            return false;
        }
        return true;

    }

    public int getGridX(){
        return this.gridX;
    }

    public int getGridY(){
        return this.gridY;
    }



}
