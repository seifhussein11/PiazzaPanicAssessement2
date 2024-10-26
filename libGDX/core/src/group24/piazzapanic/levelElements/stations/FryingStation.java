package group24.piazzapanic.levelElements.stations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import group24.piazzapanic.Base;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Ingredient;

/**
 * FryingStations allow users to fry Ingredients.
 * They interact with {@link Ingredient}'s {@link Ingredient#fry()}  and {@link Ingredient#getFryingProgress()} methods.
 * This class extends {@link Station}.
 */
public class FryingStation extends Station {
    /**
     * Initialise the FryingStation and set its texture
     */
    public FryingStation(Texture t) {
        super(t);
    }

    /**
     * Boolean for if item is ready to be flipped or taken from station
     */
    public boolean done = false;
    public boolean act = false;
    public boolean BaseActPressed;


    /**
     * Allows the player to fry the item.
     * Checks that the player is near the station, facing the station, and is pressing the ACT_KEY.
     * Checks if the item has already been fried or can't be fried.
     * If it can be fried increases timeKeyHeld by act until timeKeyHeld greater than 3 seconds. Then fries the item.
     * n.b. interact(float delta) is called every frame.
     *
     * @param delta Time in seconds since the last frame.
     */
    @Override
    public void interact(float delta) {
        if (available == 0) {
            if (GameData.money >= cost) {
                GameData.addMoney(-cost);
                available = 1;
                this.setDrawable(new SpriteDrawable(new Sprite(GameData.fryingStationTexture)));
                GameData.gameLoop.fryingStationPrice.remove();
            }
            System.out.println("Disabled");

            return;
        }
        if (super.item == null) {
            System.out.println("no item to fry..."); //new
            return;
        }

        if (super.item.getIngredient().getFryingProgress() == 3) { // The item is burnt.
            System.out.println("the item is burnt..."); //new
            return; // The item is already fried, don't go any further.
        }
        if (super.item.getIngredient().getFryingProgress() == 1) { // The item is already fried.
            System.out.println("the item is already fried..."); //new
            return; // The item is already fried, don't go any further.
        }
        if (super.item.getIngredient().getFryingProgress() == -1) { // The item cannot be fried.
            System.out.println("item cannot be fried..."); //new
            timeKeyHeld = 0;
            return;
        }
        timeKeyHeld += delta;
        if (Gdx.input.isKeyPressed(Base.ACT_KEY) || BaseActPressed == true ) {act = true;}  // Needed to be able to set act to true in testing
        if (!done) {
            if (timeKeyHeld < 3) {
                return;
            }
            done = true;
            timeKeyHeld = 0;
            act = false;
        } else if (act) {
            super.item.getIngredient().fry();
            System.out.println("frying is done..."); //new
            timeKeyHeld = 0;
            done = false;
            act = false;
        } else if (timeKeyHeld > 3) {
            super.item.getIngredient().burn();
            timeKeyHeld = 0;
            System.out.println("item has been burnt whilst frying");
            done = false;
        }
    }
}
