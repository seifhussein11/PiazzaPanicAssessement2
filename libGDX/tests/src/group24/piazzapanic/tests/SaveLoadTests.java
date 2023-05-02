package group24.piazzapanic.tests;


import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.*;
import group24.piazzapanic.ui.StageFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class SaveLoadTests {

    @Test
    public void TestSave() throws IOException {
        GameData gameData = Mockito.mock(GameData.class);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        StageFactory stageFactory = Mockito.mock(StageFactory.class);
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Player player3 = Mockito.mock(Player.class);
        player1.x = 3;
        player1.y = 4;
        player2.x=1;
        player2.y=0;
        player3.x=9;
        player3.y = 2;
        gameData.player1 = player1;
        gameData.player2 = player2;
        gameData.player3 = player3;
        gameData.reputation = 4;
        gameData.gameTime = 10;
        gameData.score = 3;
        gameData.money = 7;
        gameData.gameLoop.maxCustomers=12;
        gameData.gameLoop.totalCustomers=7;
        stageFactory.endlessModeEnabled = true;
        gameData.customers = new ArrayList<Customer>();
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

        Customer customer = new Customer(0, 60);
        Customer customer1 = new Customer(1, 60);
        Customer customer2 = new Customer(2, 60);
        Customer customer3 = new Customer(3, 60);
        customer.timeLimit = 10;
        customer1.timeLimit = 20;
        customer2.timeLimit = 40;
        customer3.timeLimit = 60;


        gameData.customers.add(customer);
        gameData.customers.add(customer1);
        gameData.customers.add(customer2);
        gameData.customers.add(customer3);

        SaveLoad saveLoad = new SaveLoad();
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        saveLoad.save();
        File file = new File("piazzaSave.txt");
        assertTrue(file.exists());
        assertEquals("File already exists." +System.lineSeparator()+
                "Successfully wrote to the file."+System.lineSeparator(), output1.toString());
        List<String> lines = Files.readAllLines(Paths.get("piazzaSave.txt"));
        assertEquals(lines.get(0),"// Chef data:");
        assertEquals(lines.get(1),Double.toString(player1.x));
        assertNotEquals(lines.get(1),Double.toString(player2.x));
        assertNotEquals(lines.get(1),Double.toString(player3.x));
        assertEquals(lines.get(2),Double.toString(player1.y));
        assertNotEquals(lines.get(2),Double.toString(player2.y));
        assertNotEquals(lines.get(2),Double.toString(player3.y));
        assertEquals(lines.get(3),Double.toString(player2.x));
        assertNotEquals(lines.get(3),Double.toString(player1.x));
        assertNotEquals(lines.get(3),Double.toString(player3.x));
        assertEquals(lines.get(4),Double.toString(player2.y));
        assertNotEquals(lines.get(4),Double.toString(player1.y));
        assertNotEquals(lines.get(4),Double.toString(player3.y));
        assertEquals(lines.get(5),Double.toString(player3.x));
        assertNotEquals(lines.get(5),Double.toString(player2.x));
        assertNotEquals(lines.get(5),Double.toString(player1.x));
        assertEquals(lines.get(6),Double.toString(player3.y));
        assertNotEquals(lines.get(6),Double.toString(player2.y));
        assertNotEquals(lines.get(6),Double.toString(player1.y));
        assertEquals(lines.get(7),"// GameData data:");
        assertEquals(lines.get(8),Integer.toString(gameData.reputation));
        assertEquals(lines.get(9),Double.toString(gameData.gameTime));
        assertEquals(lines.get(10),Integer.toString(gameData.score));
        assertEquals(lines.get(11),Integer.toString(gameData.money));
        assertEquals(lines.get(12),Integer.toString(gameData.gameLoop.maxCustomers));
        assertEquals(lines.get(13),Integer.toString(gameData.gameLoop.totalCustomers));
        assertEquals(lines.get(14),Boolean.toString(stageFactory.endlessModeEnabled));
        assertEquals(lines.get(15),"// Customer data:");
        assertEquals(lines.get(16), customer.getOrderString());
        assertEquals(lines.get(17), Double.toString(customer.timeLimit));
        assertEquals(lines.get(18), customer1.getOrderString());
        assertEquals(lines.get(19), Double.toString(customer1.timeLimit));
        assertEquals(lines.get(20), customer2.getOrderString());
        assertEquals(lines.get(21), Double.toString(customer2.timeLimit));
        assertEquals(lines.get(22), customer3.getOrderString());
        assertEquals(lines.get(23), Double.toString(customer3.timeLimit));
        assertEquals(lines.get(24), "###");



    }


    @Test
    public void TestLoad() throws IOException {
        GameData gameData = Mockito.mock(GameData.class);
        gameData.gameLoop = Mockito.mock(GameLoop.class);
        gameData.customerSpriteSheets = new ArrayList<String>();
        gameData.customerSpriteSheets.add("customers\\customer_1_idle.png");
        gameData.rand = new Random();
        StageFactory stageFactory = Mockito.mock(StageFactory.class);
        stageFactory.endlessModeEnabled = true;
        Texture texture = Mockito.mock(Texture.class);
        gameData.burgerDishTexture = texture;
        gameData.pizzaDishTexture = texture;
        gameData.saladDishTexture = texture;
        gameData.jacketPotatoDishTexture = texture;
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        Player player1 = new Player(1, 1, null);
        Player player2 = new Player(3, 4, null);
        Player player3 = new Player(12, 5, null);
        gameData.player1 = player1;
        gameData.player2 = player2;
        gameData.player3 = player3;
        Customer customer = new Customer(0, 60);
        Customer customer1 = new Customer(1, 60);
        Customer customer2 = new Customer(2, 60);
        Customer customer3 = new Customer(3, 60);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        gameData.customers = customers;
        ByteArrayOutputStream output1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output1));
        SaveLoad saveLoad = new SaveLoad();
        List<String> lines = Files.readAllLines(Paths.get("piazzaSave.txt"));
        saveLoad.load();
        assertFalse(gameData.customers.contains(customer));
        assertFalse(gameData.customers.contains(customer1));
        assertFalse(gameData.customers.contains(customer2));
        assertFalse(gameData.customers.contains(customer3));
        assertEquals(Double.parseDouble(lines.get(1)), gameData.player1.x, 0.00001);
        assertEquals(Double.parseDouble(lines.get(2)), gameData.player1.y, 0.00001);
        assertEquals(Double.parseDouble(lines.get(3)), gameData.player2.x, 0.00001);
        assertEquals(Double.parseDouble(lines.get(4)), gameData.player2.y, 0.00001);
        assertEquals(Double.parseDouble(lines.get(5)), gameData.player3.x, 0.00001);
        assertEquals(Double.parseDouble(lines.get(6)), gameData.player3.y, 0.00001);
        assertEquals(Integer.parseInt(lines.get(8)), gameData.reputation, 0.00001);
        assertEquals(Float.parseFloat(lines.get(9)), gameData.gameTime, 0.00001);
        assertEquals(Integer.parseInt(lines.get(10)), gameData.score, 0.00001);
        assertEquals(Integer.parseInt(lines.get(11)), gameData.money, 0.00001);
        assertEquals(Integer.parseInt(lines.get(12)), gameData.gameLoop.maxCustomers, 0.00001);
        assertEquals(Integer.parseInt(lines.get(13)), gameData.gameLoop.totalCustomers, 0.00001);
        assertEquals(Boolean.parseBoolean(lines.get(14)), stageFactory.endlessModeEnabled);
        assertEquals(saveLoad.orderInt(lines.get(16)), saveLoad.orderInt(gameData.customers.get(0).getOrderString()));
        assertEquals(lines.get(16), gameData.customers.get(0).getOrderString());
        assertEquals(Double.parseDouble(lines.get(17)), gameData.customers.get(0).timeLimit, 0.00001);
        assertEquals(saveLoad.orderInt(lines.get(18)), saveLoad.orderInt(gameData.customers.get(1).getOrderString()));
        assertEquals(lines.get(18), gameData.customers.get(1).getOrderString());
        assertEquals(Double.parseDouble(lines.get(19)), gameData.customers.get(1).timeLimit, 0.00001);
        assertEquals(saveLoad.orderInt(lines.get(20)), saveLoad.orderInt(gameData.customers.get(2).getOrderString()));
        assertEquals(lines.get(20), gameData.customers.get(2).getOrderString());
        assertEquals(Double.parseDouble(lines.get(21)), gameData.customers.get(2).timeLimit, 0.00001);
        assertEquals(saveLoad.orderInt(lines.get(22)), saveLoad.orderInt(gameData.customers.get(3).getOrderString()));
        assertEquals(lines.get(22), gameData.customers.get(3).getOrderString());
        assertEquals(Double.parseDouble(lines.get(23)), gameData.customers.get(3).timeLimit, 0.00001);
        assertEquals(lines.toString() + System.lineSeparator(), output1.toString());
    }

    @Test
    public void TestOrderInt(){
        GameData gameData = Mockito.mock(GameData.class);
        gameData.gameLoop = Mockito.mock(GameLoop.class);
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
        Customer customer = new Customer(0, 60);
        Customer customer1 = new Customer(1, 60);
        Customer customer2 = new Customer(2, 60);
        Customer customer3 = new Customer(3, 60);
        SaveLoad saveLoad = new SaveLoad();
        assertEquals(0,saveLoad.orderInt(customer.getOrderString()));
        assertNotEquals(1,saveLoad.orderInt(customer.getOrderString()));
        assertNotEquals(2,saveLoad.orderInt(customer.getOrderString()));
        assertNotEquals(3,saveLoad.orderInt(customer.getOrderString()));
        assertEquals(1,saveLoad.orderInt(customer1.getOrderString()));
        assertNotEquals(0,saveLoad.orderInt(customer1.getOrderString()));
        assertNotEquals(2,saveLoad.orderInt(customer1.getOrderString()));
        assertNotEquals(3,saveLoad.orderInt(customer1.getOrderString()));
        assertEquals(2,saveLoad.orderInt(customer2.getOrderString()));
        assertNotEquals(1,saveLoad.orderInt(customer2.getOrderString()));
        assertNotEquals(0,saveLoad.orderInt(customer2.getOrderString()));
        assertNotEquals(3,saveLoad.orderInt(customer2.getOrderString()));
        assertEquals(3,saveLoad.orderInt(customer3.getOrderString()));
        assertNotEquals(1,saveLoad.orderInt(customer3.getOrderString()));
        assertNotEquals(2,saveLoad.orderInt(customer3.getOrderString()));
        assertNotEquals(0,saveLoad.orderInt(customer3.getOrderString()));
    }

}
