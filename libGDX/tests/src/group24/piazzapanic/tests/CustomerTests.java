package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(GdxTestRunner.class)
public class CustomerTests {

    @Test
    public void TestCustomerFulfillOrder(){
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
        //Mockito.when(GameData.customerSpriteSheets.get(GameData.rand.nextInt(GameData.customerSpriteSheets.size()))).thenReturn(gameData.customerSpriteSheets.get(0));
        Customer customer = new Customer(0);
        Customer customer1 = new Customer(1);
        Customer customer2 = new Customer(2);
        Customer customer3 = new Customer(3);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        gameData.customers = customers;
        System.out.println("Before fulfillment: \n" + gameData.customers);
        gameData.score = 0;
        customer.fulfillOrder();
        customer1.fulfillOrder();
        customer2.fulfillOrder();
        customer3.fulfillOrder();
        System.out.println("After fulfillment: \n" + gameData.customers);
        assertFalse(gameData.customers.contains(customer));
        assertFalse(gameData.customers.contains(customer1));
        assertFalse(gameData.customers.contains(customer2));
        assertFalse(gameData.customers.contains(customer3));
        Integer expectedScore = 4;
        assertEquals(expectedScore,gameData.score);
    }

    @Test
    public void TestCustomerGetOrder(){

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
        Customer customer = new Customer(0);
        Dish dish = new Dish(Dish.BURGER_RECIPE);
        assertEquals(dish,customer.getOrder());

    }










}
