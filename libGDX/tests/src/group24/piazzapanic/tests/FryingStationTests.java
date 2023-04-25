package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.FryingStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class FryingStationTests {

    @Test
    public void TestFryingStationInteract(){
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.fryingStationTexture = texture;
        Ingredient item = Mockito.mock(Ingredient.class);
        FryingStation station = new FryingStation(GameData.fryingStationTexture);
        station.item = item;
        Mockito.when(item.getIngredient()).thenReturn(item);
        Mockito.when(item.getFryingProgress()).thenReturn(1);
        station.interact(1);
        assertEquals("the item is already fried..."+System.lineSeparator(), output1.toString());
        Mockito.when(item.getFryingProgress()).thenReturn(-1);
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        station.interact(1);
        assertEquals("item cannot be fried..."+System.lineSeparator(), output2.toString());
        assertEquals(0,station.timeKeyHeld,0.0000001);
        station.item=null;
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output3));
        station.interact(1);
        assertEquals("no item to fry..."+System.lineSeparator(), output3.toString());
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output4));
        IngredientType tomato = new IngredientType("tomato");
        gameData.errorTexture = texture;
        Ingredient item2 = new Ingredient(tomato,-1,-1,0);
        station.item = item2;
        station.timeKeyHeld = 3;
        station.interact(1);
        assertEquals(1, item2.getFryingProgress(),0.0000001);
        assertEquals(0,station.timeKeyHeld,0.0000001);
        assertEquals("frying is done..."+System.lineSeparator(), output4.toString());

    }













}
