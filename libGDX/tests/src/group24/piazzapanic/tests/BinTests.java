package group24.piazzapanic.tests;


import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.Bin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class BinTests {

    @Test
    public void TestPlaceItem(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.binTexture = texture;
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        IngredientType ingredientType = new IngredientType("tomato");
        Ingredient ingredient = new Ingredient(ingredientType);
        Dish dish = new Dish();
        Bin bin = new Bin();
        assertTrue(bin.placeItem(ingredient));
        assertTrue(bin.placeItem(dish));
        bin.placeItem(ingredient);
        bin.placeItem(dish);
        assertNull(bin.item);

    }
    @Test
    public void TestTakeItem(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.binTexture = texture;
        Bin bin = new Bin();
        assertNull(bin.takeItem());
        bin.takeItem();
        assertNull(bin.item);

    }












}
