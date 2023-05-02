package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.BakingStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class BakingStationTests {
    @Test
    public void TestBakingStationInteract(){

        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.gameLoop = gameLoop;
        Texture texture = Mockito.mock(Texture.class);
        gameData.bakingStationTexture = texture;
        Ingredient item = Mockito.mock(Ingredient.class);
        BakingStation station = new BakingStation(item);
        Mockito.when(item.getIngredient()).thenReturn(item);
        Mockito.when(item.getBakingProgress()).thenReturn(1);
        station.interact(1);
        assertEquals("Already baked......"+System.lineSeparator(), output1.toString());
        Mockito.when(item.getBakingProgress()).thenReturn(-1);
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        station.interact(1);
        assertEquals("cannot be baked......"+System.lineSeparator(), output2.toString());
        station.item=null;
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output3));
        station.interact(1);
        assertEquals("no item to bake......"+System.lineSeparator(), output3.toString());
        IngredientType bread = new IngredientType("bread");
        gameData.errorTexture = texture;
        Ingredient item2 = new Ingredient(bread,-1,0,-1);
        station.item = item2;
        station.timeKeyHeld = 3;
        station.interact(1);
        assertEquals(1, item2.getBakingProgress(),0.0000001);
        assertEquals(0,station.timeKeyHeld,0.0000001);
        station.available=0;
        gameData.money = 3;
        Integer expectedMoneyResult = gameData.money - station.cost;
        gameData.gameLoop.bakingStationPrice = Mockito.mock(Label.class);
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output4));
        station.interact(1);
        assertEquals(expectedMoneyResult,gameData.money);
        assertEquals(1,station.available);
        assertEquals("Disabled"+System.lineSeparator(), output4.toString());
        station.available=0;
        ByteArrayOutputStream output5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output5));
        station.interact(1);
        assertEquals("Disabled"+System.lineSeparator(), output5.toString());
        station.available=1;
        Ingredient item3 = new Ingredient(bread,-1,3,-1);
        station.item = item3;
        float timeHeld = station.timeKeyHeld;
        station.interact(1);
        assertEquals(3,item3.getBakingProgress(),0.0000001);
        assertEquals(timeHeld + 1,station.timeKeyHeld,0.0000001);
        station.item = item3;
        station.timeKeyHeld=1;

        station.interact(1);
        assertEquals(2,station.timeKeyHeld,0.0000001);
        station.item=item3;
        station.timeKeyHeld=3;
        station.interact(1);
        assertEquals(4,station.timeKeyHeld,0.0000001);










    }





















}
