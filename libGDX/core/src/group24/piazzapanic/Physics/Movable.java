package group24.piazzapanic.Physics;

import group24.piazzapanic.levelElements.Ingredient;

public interface Movable {

//    void actItem(float delta);
//
//    void drawItem(int x, int y);

    void drawItem(int x, int y, int width, int height);

    void drawItemInventory(int x, int y, int width, int height);

    Ingredient getIngredient();
}
