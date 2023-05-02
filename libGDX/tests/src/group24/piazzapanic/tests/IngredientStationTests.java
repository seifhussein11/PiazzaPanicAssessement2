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

    @Test
    public void TestPlaceItem(){
        Texture texture = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.errorTexture = texture;
        gameData.rawPotatoTexture = texture;
        gameData.potatoStationTexture = texture;
        gameData.dishStationTexture = texture;
        gameData.dishTexture = texture;
        gameData.cheeseStationTexture = texture;

        IngredientType ingredientType1 = new IngredientType("potato");
        IngredientType ingredientType2 = new IngredientType("dish");
        IngredientType ingredientType3 = new IngredientType("cheese");
        Ingredient ingredient = new Ingredient(ingredientType2);
        Ingredient ingredient2 = new Ingredient(ingredientType3);
        Ingredient ingredient3 = new Ingredient(ingredientType1);
        IngredientStation station1 = new IngredientStation(0,0, ingredientType1);
        IngredientStation station2 = new IngredientStation(0,0, ingredientType2);
        assertFalse(station1.placeItem(ingredient));
        assertFalse(station1.placeItem(ingredient2));
        assertFalse(station2.placeItem(ingredient3));

    }

    @Test
    public void getIngredientStationAsset(){
        Texture texture = Mockito.mock(Texture.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        Texture texture3 = Mockito.mock(Texture.class);
        Texture texture4 = Mockito.mock(Texture.class);
        Texture texture5 = Mockito.mock(Texture.class);
        Texture texture6 = Mockito.mock(Texture.class);
        Texture texture7 = Mockito.mock(Texture.class);
        Texture texture8 = Mockito.mock(Texture.class);
        Texture texture9 = Mockito.mock(Texture.class);
        Texture texture10 = Mockito.mock(Texture.class);
        Texture texture11 = Mockito.mock(Texture.class);

        GameData gameData = Mockito.mock(GameData.class);
        gameData.errorTexture = texture;
        gameData.ingredientStationTexture = texture1;
        gameData.tomatoStationTexture = texture2;
        gameData.onionStationTexture = texture3;
        gameData.lettuceStationTexture = texture4;
        gameData.breadStationTexture = texture5;
        gameData.meatStationTexture = texture6;
        gameData.dishStationTexture = texture7;
        gameData.doughStationTexture = texture8;
        gameData.sauceStationTexture = texture9;
        gameData.cheeseStationTexture = texture10;
        gameData.potatoStationTexture = texture11;
        Texture texture12 = gameData.ingredientStationTexture;

        IngredientType ingredientType1 = new IngredientType("tomato");
        IngredientType ingredientType2 = new IngredientType("onion");
        IngredientType ingredientType3 = new IngredientType("lettuce");
        IngredientType ingredientType4 = new IngredientType("bread");
        IngredientType ingredientType5 = new IngredientType("meat");
        IngredientType ingredientType6 = new IngredientType("dish");
        IngredientType ingredientType7 = new IngredientType("dough");
        IngredientType ingredientType8 = new IngredientType("sauce");
        IngredientType ingredientType9 = new IngredientType("cheese");
        IngredientType ingredientType10 = new IngredientType("potato");
        IngredientType ingredientType11 = new IngredientType("test");

        IngredientStation station = new IngredientStation(1,1,ingredientType7);

        assertEquals(texture2,station.getIngredientStationAsset(ingredientType1));
        assertEquals(texture3,station.getIngredientStationAsset(ingredientType2));
        assertEquals(texture4,station.getIngredientStationAsset(ingredientType3));
        assertEquals(texture5,station.getIngredientStationAsset(ingredientType4));
        assertEquals(texture6,station.getIngredientStationAsset(ingredientType5));
        assertEquals(texture7,station.getIngredientStationAsset(ingredientType6));
        assertEquals(texture8,station.getIngredientStationAsset(ingredientType7));
        assertEquals(texture9,station.getIngredientStationAsset(ingredientType8));
        assertEquals(texture10,station.getIngredientStationAsset(ingredientType9));
        assertEquals(texture11,station.getIngredientStationAsset(ingredientType10));
        assertEquals(texture12,station.getIngredientStationAsset(ingredientType11));







    }
















}
