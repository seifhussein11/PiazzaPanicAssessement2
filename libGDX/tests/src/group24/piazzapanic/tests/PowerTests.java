package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.game.Power;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class PowerTests {


    @Test
    public void TestPowerUp(){
        GameData gameData = Mockito.mock(GameData.class);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.customerSpriteSheets = new ArrayList<String>();
        gameData.customerSpriteSheets.add("customers\\customer_1_idle.png");
        gameData.rand = new Random();
        Texture texture = Mockito.mock(Texture.class);
        gameData.burgerDishTexture = texture;
        gameData.pizzaDishTexture = texture;
        gameData.saladDishTexture = texture;
        gameData.jacketPotatoDishTexture = texture;
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        GameData.score = 4;
        GameData.money = 10;
        gameData.reputation = 3;
        GameData.sinceLastSpawn = 7;
        gameData.customers = new ArrayList<Customer>();
        Label.LabelStyle style = Mockito.mock(Label.LabelStyle.class);
        style.font = Mockito.mock(BitmapFont.class);
        gameLoop.activePowerup = new Label(Mockito.mock(CharSequence.class),style);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        gameData.customers.add(customer1);
        gameData.customers.add(customer2);
        gameData.customers.add(customer3);

        Power power = new Power();

        power.up(0);
        assertEquals(5,gameData.score,0.00001);
        assertNotEquals(4,gameData.score,0.00001);
        assertEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 reputation",gameLoop.activePowerup.getText().toString());

        power.up(1);
        assertEquals(15,gameData.money,0.00001);
        assertNotEquals(10,gameData.money,0.00001);
        assertEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 reputation",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());

        power.up(2);
        assertEquals(4,gameData.reputation,0.00001);
        assertNotEquals(3,gameData.reputation,0.00001);
        assertEquals("Added 1" + System.lineSeparator() + "reputation",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());

        power.up(3);
        assertEquals(0,gameData.sinceLastSpawn,0.00001);
        assertNotEquals(7,gameData.sinceLastSpawn,0.00001);
        assertEquals("Delayed next" + System.lineSeparator() + "customer",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added 1" + System.lineSeparator() + "reputation",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());

        power.up(4);
        assertFalse(gameData.customers.contains(customer1));
        assertEquals(2,gameData.customers.size(),0.00001);
        assertNotEquals(3,gameData.customers.size(),0.00001);
        assertEquals("Served a" + System.lineSeparator() + "customer",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Delayed next" + System.lineSeparator() + "customer",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added 1" + System.lineSeparator() + "reputation",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());

        gameData.customers = new ArrayList<Customer>();
        power.up(4);
        assertTrue(gameData.customers.size()==0);

        assertNotEquals("Delayed next" + System.lineSeparator() + "customer",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added 1" + System.lineSeparator() + "reputation",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "5 money",gameLoop.activePowerup.getText().toString());
        assertNotEquals("Added " + System.lineSeparator() + "1 score",gameLoop.activePowerup.getText().toString());

    }






}
