package group24.piazzapanic.levelElements.stations;

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
    public FryingStation() {
        super(GameData.fryingStationTexture);
    }

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
            }
            System.out.println("Disabled");
            return;
        }
        if (super.item == null) {
            System.out.println("no item to fry..."); //new
            return;
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
        if (timeKeyHeld > 3 && super.item.getIngredient().getFryingProgress() == 0) {

            super.item.getIngredient().fry();
            timeKeyHeld = 0; // Reset to avoid horrible loop!
            System.out.println("frying is done..."); //new
        }
    }
}
