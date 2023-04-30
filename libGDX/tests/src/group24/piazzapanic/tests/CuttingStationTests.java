package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.CuttingStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(GdxTestRunner.class)
public class CuttingStationTests {


    @Test
    public void TestCuttingStationInteract(){

        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.cuttingStationTexture = texture;
        Ingredient item = Mockito.mock(Ingredient.class);
        CuttingStation station = new CuttingStation(GameData.cuttingStationTexture);
        station.item = item;
        Mockito.when(item.getIngredient()).thenReturn(item);
        Mockito.when(item.getCuttingProgress()).thenReturn(1);
        station.interact(1);
        assertEquals("Already cut..."+System.lineSeparator(), output1.toString());
        assertNotEquals("already cut..."+System.lineSeparator(), output1.toString());

        Mockito.when(item.getCuttingProgress()).thenReturn(-1);
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        station.interact(1);
        assertEquals("cannot be cut..."+System.lineSeparator(), output2.toString());
        assertEquals(0,station.timeKeyHeld,0.0000001);
        station.item=null;
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output3));
        station.interact(1);
        assertEquals("no item to cut..."+System.lineSeparator(), output3.toString());
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output4));
        IngredientType tomato = new IngredientType("tomato");
        gameData.errorTexture = texture;
        Ingredient item2 = new Ingredient(tomato,0,-1,-1);
        station.item = item2;
        station.timeKeyHeld = 3;
        station.interact(1);
        assertEquals(1, item2.getCuttingProgress(),0.0000001);
        assertEquals(0,station.timeKeyHeld,0.0000001);
        assertEquals("Cutting complete..."+System.lineSeparator(), output4.toString());
        station.available=0;
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameLoop.cuttingStationPrice = Mockito.mock(Label.class);
        gameData.gameLoop = gameLoop;
        gameData.money = 3;
        Integer expectedMoneyResult = gameData.money - station.cost;
        ByteArrayOutputStream output5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output5));
        station.interact(1);
        assertEquals(expectedMoneyResult,gameData.money);
        assertEquals(1,station.available);
        assertEquals("Disabled"+System.lineSeparator(), output5.toString());
        station.available=0;
        ByteArrayOutputStream output6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output6));
        station.interact(1);
        assertEquals("Disabled"+System.lineSeparator(), output6.toString());
        station.available=1;
        Ingredient item3 = new Ingredient(tomato,3,-1,-1);
        station.item = item3;
        float timeHeld = station.timeKeyHeld;
        station.interact(1);
        assertEquals(3,item3.getCuttingProgress(),0.0000001);
        assertEquals(timeHeld + 1,station.timeKeyHeld,0.0000001);
        station.item = item3;
        station.timeKeyHeld=1;
        station.interact(1);
        assertEquals(2,station.timeKeyHeld,0.0000001);
        station.item=item3;
        station.timeKeyHeld=3;
        station.interact(1);
        assertEquals(4,station.timeKeyHeld,0.0000001);
        Ingredient item4 = new Ingredient(tomato,0,-1,-1);
        station.item = item4;
        station.timeKeyHeld=1;
        station.available=1;
        station.interact(1);
        assertEquals(2,station.timeKeyHeld,0.000001);







    }




}
