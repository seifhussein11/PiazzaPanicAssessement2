package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Player;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.IngredientStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class IngredientStationTests {




    @Test
    public void TestTakeItem(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.errorTexture = texture;
        gameData.rawTomatoTexture = texture;
        gameData.tomatoStationTexture = texture;
        gameData.dishStationTexture = texture;
        gameData.dishTexture = texture;
        IngredientType ingredientType1 = new IngredientType("tomato");
        IngredientType ingredientType2 = new IngredientType("dish");
        Ingredient ingredient = new Ingredient(ingredientType1);
        IngredientStation station1 = new IngredientStation(0,0, ingredientType2);
        IngredientStation station2 = new IngredientStation(0,0, ingredientType1);
        Object thing1 = station1.takeItem();
        assertTrue(thing1 instanceof Dish);
        assertNotNull(thing1);
        Object thing2 = station2.takeItem();
        assertTrue(thing2 instanceof Ingredient);
        assertEquals(ingredient,thing2);

    }

    @Test
    public void TestIsEqual(){
        Texture texture = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.errorTexture = texture;
        gameData.rawTomatoTexture = texture;
        gameData.tomatoStationTexture = texture;
        gameData.dishStationTexture = texture;
        gameData.dishTexture = texture;
        IngredientType ingredientType1 = new IngredientType("tomato");
        IngredientType ingredientType2 = new IngredientType("dish");
        Ingredient ingredient = new Ingredient(ingredientType1);
        Dish dish = new Dish();
        IngredientStation station1 = new IngredientStation(0,0, ingredientType2);
        IngredientStation station2 = new IngredientStation(0,0, ingredientType1);
        IngredientStation station3 = new IngredientStation(0,0, ingredientType2);
        gameData.dishStationTexture =texture2;
        gameData.dishTexture = texture2;
        IngredientStation station4 = new IngredientStation(0,0, ingredientType2);
        Player player = new Player(0,0,null);
        station1.item = dish;
        station3.item = dish;
        station1.available = 1;
        station3.available = 1;
        station4.item = dish;

        assertFalse(station1.isEqual(station2));
        assertTrue(station1.isEqual(station3));
        assertFalse(station3.isEqual(player));
        station3.item = ingredient;
        assertFalse(station1.isEqual(station3));
        assertFalse(station1.isEqual(station4));
        gameData.dishStationTexture =texture;
        station3.item=dish;
        station3.available=0;
        assertFalse(station1.isEqual(station3));






    }
















}
