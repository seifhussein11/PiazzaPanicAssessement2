package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.FryingStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class FryingStationTests {

    @Test
    public void TestFryingStationInteract(){
        GameData gameData = Mockito.mock(GameData.class);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.gameLoop.fryingStationPrice = Mockito.mock(Label.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.fryingStationTexture = texture;
        gameData.lockedFryingStationTexture = texture;
        gameData.errorTexture = texture;
        gameData.halfFriedMeatTexture = texture;
        gameData.friedMeatTexture = texture;
        FryingStation fryingStation = new FryingStation(gameData.lockedFryingStationTexture);

        // not available and money more than cost
        fryingStation.available = 0;
        gameData.money = 3;
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        fryingStation.interact(1);
        assertEquals(3-fryingStation.cost,gameData.money,0.00001);
        assertEquals(1,fryingStation.available);
        assertNotEquals(0,fryingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output1.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output1.toString());

        // not available and money less than cost
        fryingStation.available=0;
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output2));
        fryingStation.interact(1);
        assertEquals(1,gameData.money,0.00001);
        assertEquals(0,fryingStation.available);
        assertNotEquals(1,fryingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output2.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output2.toString());
        assertNotEquals(1-fryingStation.cost,gameData.money,0.00001);

        // available and money more than cost and no super item
       fryingStation.available = 1;
        gameData.money = 3;
        IngredientType ingredientType = new IngredientType("meat");
        Ingredient ingredient3 = new Ingredient(ingredientType,-1,-1,3);
        fryingStation.interact(1);
        ByteArrayOutputStream output3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output3));
        fryingStation.interact(1);
        assertEquals("no item to fry..."+System.lineSeparator(), output3.toString());
        assertNotEquals("Disabled"+System.lineSeparator(), output3.toString());
        assertEquals(3,gameData.money,0.00001);

        // available and money more than cost and super item frying process is 3
        fryingStation.item = ingredient3;
        ByteArrayOutputStream output4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output4));
        fryingStation.interact(1);
        assertEquals("the item is burnt..."+System.lineSeparator(), output4.toString());
        assertNotEquals("Disabled"+System.lineSeparator(), output4.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output4.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output4.toString());
        assertEquals(3,gameData.money,0.00001);

        // available and money more than cost and super item frying process is 2
        Ingredient ingredient2= new Ingredient(ingredientType,-1,-1,2);
        fryingStation.item = ingredient2;
        ByteArrayOutputStream output5 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output5));
        fryingStation.interact(1);
        assertEquals("the item is already fried..."+System.lineSeparator(), output5.toString());
        assertNotEquals("Disabled"+System.lineSeparator(), output5.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output5.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output5.toString());
        assertEquals(3,gameData.money,0.00001);

        // not available and money more than cost and super item frying process is 3
        fryingStation.item = ingredient3;
        fryingStation.available=0;
        ByteArrayOutputStream output6 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output6));
        fryingStation.timeKeyHeld = 4;
        fryingStation.interact(1);
        assertEquals(3-fryingStation.cost,gameData.money,0.00001);
        assertEquals(1,fryingStation.available);
        assertNotEquals(0,fryingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output6.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output6.toString());
        assertNotEquals("the item already fried..."+System.lineSeparator(), output6.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output6.toString());


        // not available and money more than cost and super item frying process is 2
        fryingStation.item = ingredient2;
        fryingStation.available=0;
        gameData.money = 3;
        ByteArrayOutputStream output7 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output7));
        fryingStation.interact(1);
        assertEquals(3-fryingStation.cost,gameData.money,0.00001);
        assertEquals(1,fryingStation.available);
        assertNotEquals(0,fryingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output7.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output7.toString());
        assertNotEquals("the item already fried..."+System.lineSeparator(), output7.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output7.toString());

        // available and money more and super item frying process is -1
        Ingredient ingredientNeg1 = new Ingredient(ingredientType,-1,-1,-1);
        fryingStation.item = ingredientNeg1;
        fryingStation.available = 1;
        gameData.money =3;
        fryingStation.timeKeyHeld = 3;
        ByteArrayOutputStream output8 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output8));
        fryingStation.interact(1);
        assertEquals(0,fryingStation.timeKeyHeld,0.00001);
        assertEquals("item cannot be fried..."+System.lineSeparator(), output8.toString());
        assertNotEquals("Disabled"+System.lineSeparator(), output8.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output8.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output8.toString());
        assertEquals(3,gameData.money,0.00001);

        // not available and money more and super item frying process is -1
        fryingStation.available = 0;
        ByteArrayOutputStream output9 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output9));
        fryingStation.timeKeyHeld=4;
        fryingStation.interact(1);
        assertEquals(4,fryingStation.timeKeyHeld,0.00001);
        assertEquals(3-fryingStation.cost,gameData.money,0.00001);
        assertEquals(1,fryingStation.available);
        assertNotEquals(0,fryingStation.available);
        assertEquals("Disabled"+System.lineSeparator(), output9.toString());
        assertNotEquals("disabled"+System.lineSeparator(), output9.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output9.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output9.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output9.toString());

        // available and money less and super item frying process is 0 and time held key > 3 and act is pressed and done is false and act is false
        ByteArrayOutputStream output10 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output10));
        fryingStation.available = 1;
        Ingredient ingredient0 = new Ingredient(ingredientType,-1,-1,0);
        fryingStation.item = ingredient0;
        fryingStation.timeKeyHeld = 3;
        fryingStation.BaseActPressed = true;
        fryingStation.done = false;
        fryingStation.interact(1);
        assertTrue(fryingStation.done);
        assertFalse(fryingStation.act);
        assertEquals(0,fryingStation.timeKeyHeld,0.00001);
        assertNotEquals("disabled"+System.lineSeparator(), output10.toString());
        assertNotEquals("frying is done..."+System.lineSeparator(), output10.toString());
        assertNotEquals("item has been burnt whilst frying..."+System.lineSeparator(), output10.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output10.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output10.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output10.toString());
        // available and money less and super item frying process is 0 and time held key < 3 and act is pressed and done is false and act is false
        ByteArrayOutputStream output11 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output11));
        fryingStation.timeKeyHeld = 1;
        fryingStation.BaseActPressed = true;
        fryingStation.done = false;
        fryingStation.interact(1);
        assertEquals(2,fryingStation.timeKeyHeld,0.00001);
        assertTrue(fryingStation.act);
        assertFalse(fryingStation.done);
        assertNotEquals("disabled"+System.lineSeparator(), output11.toString());
        assertNotEquals("frying is done..."+System.lineSeparator(), output11.toString());
        assertNotEquals("item has been burnt whilst frying..."+System.lineSeparator(), output11.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output11.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output11.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output11.toString());
        // available and money less and super item frying process is 0 and time held key > 3 and act is pressed and done is true and act is false
        ByteArrayOutputStream output12 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output12));
        fryingStation.timeKeyHeld=3;
        fryingStation.done = true;
        fryingStation.interact(1);
        assertEquals("frying is done..."+System.lineSeparator(), output12.toString());
        assertEquals(1,ingredient0.getFryingProgress(),0.00001);
        assertEquals(-1,ingredient0.getBakingProgress(),0.00001);
        assertEquals(0,fryingStation.timeKeyHeld,0.00001);
        assertFalse(fryingStation.done);
        assertFalse(fryingStation.act);
        assertNotEquals("item has been burnt whilst frying..."+System.lineSeparator(), output12.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output12.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output12.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output12.toString());
// available and money less and super item frying process is 0 and time held key > 3 and act is not pressed and done is true and act is true
        ByteArrayOutputStream output13 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output13));
        fryingStation.BaseActPressed=false;
        fryingStation.act = true;
        fryingStation.done=true;
        fryingStation.timeKeyHeld=2;
        fryingStation.interact(1);
        assertEquals("frying is done..."+System.lineSeparator(), output13.toString());
        assertEquals(2,ingredient0.getFryingProgress(),0.00001);
        assertEquals(-1,ingredient0.getBakingProgress(),0.00001);
        assertFalse(fryingStation.done);
        assertFalse(fryingStation.act);
        assertEquals(0,fryingStation.timeKeyHeld,0.00001);
        assertNotEquals("item has been burnt whilst frying..."+System.lineSeparator(), output13.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output13.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output13.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output13.toString());
        // available and money less and super item frying process is 0 and time held key > 3 and act is not pressed and done is true and act is false
        ByteArrayOutputStream output14 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output14));
        fryingStation.BaseActPressed=false;
        fryingStation.act = false;
        fryingStation.done=true;
        fryingStation.timeKeyHeld=3;
        Ingredient ingredient1 = new Ingredient(ingredientType,-1,-1,1);
        fryingStation.item = ingredient1;
        fryingStation.interact(1);
        assertEquals("item has been burnt whilst frying"+System.lineSeparator(), output14.toString());
        assertNotEquals("frying is done..."+System.lineSeparator(), output14.toString());
        assertNotEquals("the item is burnt..."+System.lineSeparator(), output14.toString());
        assertNotEquals("the item is already fried..."+System.lineSeparator(), output14.toString());
        assertNotEquals("no item to fry..."+System.lineSeparator(), output14.toString());
        assertEquals(0,fryingStation.timeKeyHeld,0.00001);
        assertFalse(fryingStation.done);
        assertEquals(3,ingredient1.getFryingProgress(),0.00001);






    }













}
