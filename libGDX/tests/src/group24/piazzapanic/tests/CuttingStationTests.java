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
        GameData gameData = Mockito.mock(GameData.class);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.gameLoop.cuttingStationPrice = Mockito.mock(Label.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.cuttingStationTexture = texture;
        gameData.lockedCuttingStationTexture = texture;
        gameData.errorTexture = texture;
        CuttingStation cuttingStation = new CuttingStation(gameData.lockedCuttingStationTexture);

        // not available and money more than cost
        cuttingStation.available = 0;
        gameData.money = 6;
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        cuttingStation.interact(1);
        assertEquals(6-cuttingStation.cost,gameData.money,0.00001);
        assertEquals(1,cuttingStation.available);
        assertNotEquals(0,cuttingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output1.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output1.toString());
        // not available and money less than cost
        cuttingStation.available=0;
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        cuttingStation.interact(1);
        assertEquals(1,gameData.money,0.00001);
        assertEquals(0,cuttingStation.available);
        assertNotEquals(1,cuttingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output2.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output2.toString());
        assertNotEquals(1-cuttingStation.cost,gameData.money,0.00001);
        // available and money more than cost and no super item
        cuttingStation.available = 1;
        gameData.money = 6;
        IngredientType ingredientType = new IngredientType("tomato");
        Ingredient ingredient1 = new Ingredient(ingredientType,1,-1,-1);
        cuttingStation.interact(1);
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output3));
        cuttingStation.interact(1);
        assertEquals("no item to cut..."+System.lineSeparator(), output3.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output3.toString());
        assertEquals(6,gameData.money,0.00001);
        // available and money more than cost and super item cutting process is 1
        cuttingStation.item = ingredient1;
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output4));
        cuttingStation.interact(1);
        assertEquals("Already cut..."+System.lineSeparator(), output4.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output4.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output4.toString());
        assertEquals(6,gameData.money,0.00001);
        // not available and money more than cost and super item cutting process is 1
        cuttingStation.available=0;
        ByteArrayOutputStream output5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output5));
        cuttingStation.timeKeyHeld = 4;
        cuttingStation.interact(1);
        assertEquals(6-cuttingStation.cost,gameData.money,0.00001);
        assertEquals(1,cuttingStation.available);
        assertNotEquals(0,cuttingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output5.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output5.toString());
        assertNotEquals("Already cut..."+System.lineSeparator(), output5.toString());
        // available and money more and super item cutting process is -1
        Ingredient ingredientNeg1 = new Ingredient(ingredientType,-1,-1,-1);
        cuttingStation.item = ingredientNeg1;
        cuttingStation.available = 1;
        cuttingStation.timeKeyHeld = 3;
        gameData.money =6;
        ByteArrayOutputStream output6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output6));
        cuttingStation.interact(1);
        assertEquals(0,cuttingStation.timeKeyHeld,0.00001);
        assertEquals("cannot be cut..."+System.lineSeparator(), output6.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output6.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output6.toString());
        assertNotEquals("Already cut..."+System.lineSeparator(), output6.toString());
        assertEquals(6,gameData.money,0.00001);
        // not available and money more and super item cutting process is -1
        cuttingStation.available = 0;
        cuttingStation.timeKeyHeld=4;
        ByteArrayOutputStream output7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output7));
        cuttingStation.interact(1);
        assertEquals(4,cuttingStation.timeKeyHeld,0.00001);
        assertEquals(6-cuttingStation.cost,gameData.money,0.00001);
        assertEquals(1,cuttingStation.available);
        assertNotEquals(0,cuttingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output7.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output7.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output7.toString());
        // available and money less and super item cutting process is 0 and time held key > 3
        ByteArrayOutputStream output8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output8));
        cuttingStation.available = 1;
        Ingredient ingredient0 = new Ingredient(ingredientType,0,-1,-1);
        cuttingStation.item = ingredient0;
        cuttingStation.timeKeyHeld = 3;
        cuttingStation.interact(1);
        assertEquals(1,ingredient0.getCuttingProgress(),0.00001);
        assertEquals(0,cuttingStation.timeKeyHeld,0.00001);
        assertEquals("Cutting complete..."+System.lineSeparator(), output8.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output8.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output8.toString());
        assertNotEquals("Already cut..."+System.lineSeparator(), output8.toString());
        assertNotEquals("cannot be cut..."+System.lineSeparator(), output8.toString());
        // not available and money less and super item cutting process is 0 and time held key < 3;
        cuttingStation.available = 0;
        cuttingStation.timeKeyHeld = 1;
        Ingredient ingredient02 = new Ingredient(ingredientType,0,-1,-1);
        cuttingStation.item = ingredient02;
        gameData.money = 1;
        ByteArrayOutputStream output9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output9));
        cuttingStation.interact(1);
        assertEquals("Disabled"+System.lineSeparator(), output9.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output9.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output9.toString());
        assertNotEquals("Already cut..."+System.lineSeparator(), output9.toString());
        assertNotEquals("cannot be cut..."+System.lineSeparator(), output9.toString());
        assertNotEquals("Cutting complete..."+System.lineSeparator(), output9.toString());
        assertEquals(1,cuttingStation.timeKeyHeld,0.00001);
        assertEquals(1,gameData.money,0.00001);
        assertEquals(0,ingredient02.getCuttingProgress(),0.00001);
        assertEquals(0,cuttingStation.available,0.00001);
        // available and money less and super item cutting process is 0 and time held key < 3;
        cuttingStation.available= 1;
        gameData.money = 3;
        cuttingStation.timeKeyHeld=1;
        ByteArrayOutputStream output10 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output10));
        cuttingStation.interact(1);
        assertEquals(2,cuttingStation.timeKeyHeld,0.00001);
        assertEquals(0,ingredient02.getCuttingProgress(),0.00001);
        assertNotEquals("Cutting complete..."+System.lineSeparator(), output10.toString());
        assertNotEquals("Disabled"+System.lineSeparator(), output10.toString());
        assertNotEquals("no item to cut..."+System.lineSeparator(), output10.toString());
        assertNotEquals("Already cut..."+System.lineSeparator(), output10.toString());
        assertNotEquals("cannot be cut..."+System.lineSeparator(), output10.toString());







    }




}
