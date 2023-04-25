package group24.piazzapanic.levelElements.stations;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Ingredient;

/**
 * CuttingStations allow users to cut Ingredients.
 * They interact with {@link Ingredient}'s {@link Ingredient#cut()}  and {@link Ingredient#getCuttingProgress()} methods.
 * This class extends {@link Station}.
 */
public class CuttingStation extends Station {
    /**
     * Initialise the CuttingStation and set its texture
     */
    public CuttingStation(Texture t) {
        super(t);
    }

    /**
     * Allows the player to cut the item.
     * Checks that the player is near the station, facing the station, and is pressing the ACT_KEY.
     * Checks if the item has already been cut or can't be cut.
     * If it can be cut increases timeKeyHeld by act until timeKeyHeld greater than 3 seconds. Then cuts the item.
     * n.b. act(float delta) is called every frame.
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
            System.out.println("no item to cut..."); //new
            return;
        }
        if (super.item.getIngredient().getCuttingProgress() == 1) {
            System.out.println("Already cut...");
            return; // The item is already cut, don't go any further.
        }
        if (super.item.getIngredient().getCuttingProgress() == -1) {
            System.out.println("cannot be cut..."); //new
            timeKeyHeld = 0;
            return;
        }
        timeKeyHeld += delta;
        if (timeKeyHeld > 3 && super.item.getIngredient().getCuttingProgress() == 0
                && available == 1) {
            super.item.getIngredient().cut();
            System.out.println("Cutting complete...");
            timeKeyHeld = 0;
        }
    }
}
