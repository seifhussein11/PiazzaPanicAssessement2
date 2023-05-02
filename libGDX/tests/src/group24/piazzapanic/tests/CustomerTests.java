package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.ui.StageFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

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
        Customer customer = new Customer(0, 60);
        Customer customer1 = new Customer(1, 60);
        Customer customer2 = new Customer(2, 60);
        Customer customer3 = new Customer(3, 60);
        Customer customer4 = new Customer(3, 60);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        gameData.customers = customers;
        System.out.println("Before fulfillment: \n" + gameData.customers);
        gameData.score = 0;
        gameData.money=0;
        customer.fulfillOrder();
        assertEquals(gameData.score,1,0.0001);
        assertEquals(gameData.money,5,0.0001);
        assertFalse(gameData.customers.contains(customer));
        customer1.fulfillOrder();
        assertEquals(gameData.score,2,0.0001);
        assertEquals(gameData.money,10,0.0001);
        assertFalse(gameData.customers.contains(customer1));
        customer2.fulfillOrder();
        assertEquals(gameData.score,3,0.0001);
        assertEquals(gameData.money,15,0.0001);
        assertFalse(gameData.customers.contains(customer2));
        customer3.fulfillOrder();
        assertEquals(gameData.score,4,0.0001);
        assertEquals(gameData.money,20,0.0001);
        assertFalse(gameData.customers.contains(customer3));
        System.out.println("After fulfillment: \n" + gameData.customers);
        assertFalse(gameData.customers.contains(customer));
        assertFalse(gameData.customers.contains(customer1));
        assertFalse(gameData.customers.contains(customer2));
        assertFalse(gameData.customers.contains(customer3));
        Integer expectedScore = 4;
        assertEquals(expectedScore,gameData.score);
        assertTrue(gameData.customers.contains(customer4));
        assertEquals(1,gameData.customers.size());

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
        Customer customer = new Customer(0, 60);
        Dish dish = new Dish(Dish.BURGER_RECIPE);
        assertEquals(dish,customer.getOrder());

    }

    @Test
    public void TestCustomerConstructer(){
        GameData gameData = Mockito.mock(GameData.class);
        gameData.gameLoop = Mockito.mock(GameLoop.class);
        gameData.customerSpriteSheets = new ArrayList<String>();
        gameData.customerSpriteSheets.add("customers\\customer_1_idle.png");
        gameData.rand = new Random();
        Texture texture = Mockito.mock(Texture.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        Texture texture3 = Mockito.mock(Texture.class);
        Texture texture4 = Mockito.mock(Texture.class);
        gameData.burgerDishTexture = texture1;
        gameData.pizzaDishTexture = texture2;
        gameData.saladDishTexture = texture3;
        gameData.jacketPotatoDishTexture = texture4;
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        StageFactory stageFactory = Mockito.mock(StageFactory.class);
        stageFactory.difficultyVal = 0;
        Customer customer = new Customer();
        assertEquals(100,customer.timeLimit,0.00001);
        if (customer.order.equals(Dish.BURGER)){
            assertEquals(gameData.burgerDishTexture,customer.orderTexture);
        } else if (customer.order.equals(Dish.SALAD)) {
            assertEquals(gameData.saladDishTexture,customer.orderTexture);

        }else if (customer.order.equals(Dish.PIZZA)){
            assertEquals(gameData.pizzaDishTexture,customer.orderTexture);
        }else if (customer.order.equals(Dish.JACKET_POTATO)){
            assertEquals(gameData.jacketPotatoDishTexture,customer.orderTexture);
        }

        stageFactory.difficultyVal = 1;
        Customer customer1 = new Customer();
        assertEquals(80,customer1.timeLimit,0.00001);
        if (customer1.order.equals(Dish.BURGER)){
            assertEquals(gameData.burgerDishTexture,customer1.orderTexture);
        } else if (customer1.order.equals(Dish.SALAD)) {
            assertEquals(gameData.saladDishTexture,customer1.orderTexture);

        }else if (customer1.order.equals(Dish.PIZZA)){
            assertEquals(gameData.pizzaDishTexture,customer1.orderTexture);
        }else if (customer1.order.equals(Dish.JACKET_POTATO)){
            assertEquals(gameData.jacketPotatoDishTexture,customer1.orderTexture);
        }

        stageFactory.difficultyVal = 2;
        Customer customer2 = new Customer();
        assertEquals(60,customer2.timeLimit,0.00001);
        if (customer2.order.equals(Dish.BURGER)){
            assertEquals(gameData.burgerDishTexture,customer2.orderTexture);
        } else if (customer2.order.equals(Dish.SALAD)) {
            assertEquals(gameData.saladDishTexture,customer2.orderTexture);

        }else if (customer2.order.equals(Dish.PIZZA)){
            assertEquals(gameData.pizzaDishTexture,customer2.orderTexture);
        }else if (customer2.order.equals(Dish.JACKET_POTATO)){
            assertEquals(gameData.jacketPotatoDishTexture,customer2.orderTexture);
        }

        stageFactory.difficultyVal = 3;
        Customer customer3 = new Customer();
        assertEquals(80,customer3.timeLimit,0.00001);
        if (customer3.order.equals(Dish.BURGER)){
            assertEquals(gameData.burgerDishTexture,customer3.orderTexture);
        } else if (customer3.order.equals(Dish.SALAD)) {
            assertEquals(gameData.saladDishTexture,customer3.orderTexture);

        }else if (customer3.order.equals(Dish.PIZZA)){
            assertEquals(gameData.pizzaDishTexture,customer3.orderTexture);
        }else if (customer3.order.equals(Dish.JACKET_POTATO)){
            assertEquals(gameData.jacketPotatoDishTexture,customer3.orderTexture);
        }



    }

    @Test
    public void TestFulfillOrder2(){

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

        Customer customer = new Customer();
        Customer customer1 = new Customer();
        gameData.customers = new ArrayList<Customer>();
        gameData.customers.add(customer);
        gameData.customers.add(customer1);
        customer.fulfillOrder2();
        assertFalse(gameData.customers.contains(customer));
        assertTrue(gameData.customers.contains(customer1));

    }

    @Test
    public void TestOutOfTime(){

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
        gameData.reputation = 3;
        gameData.gameLoop.totalCustomers=3;

        Customer customer = new Customer();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        gameData.customers = new ArrayList<Customer>();
        gameData.customers.add(customer);
        gameData.customers.add(customer1);
        gameData.customers.add(customer2);
        customer.outOfTime();
        assertFalse(gameData.customers.contains(customer));
        assertTrue(gameData.customers.contains(customer1));
        assertTrue(gameData.customers.contains(customer2));
        assertEquals(2,gameData.reputation,0.000001);
        assertEquals(2,gameData.gameLoop.totalCustomers);

        customer1.outOfTime();
        assertFalse(gameData.customers.contains(customer));
        assertFalse(gameData.customers.contains(customer1));
        assertTrue(gameData.customers.contains(customer2));
        assertEquals(1,gameData.reputation,0.000001);
        assertEquals(1,gameData.gameLoop.totalCustomers);

        customer2.outOfTime();
        assertFalse(gameData.customers.contains(customer));
        assertFalse(gameData.customers.contains(customer1));
        assertFalse(gameData.customers.contains(customer2));
        assertEquals(0,gameData.reputation,0.000001);
        assertEquals(0,gameData.gameLoop.totalCustomers);

    }

    @Test
    public void TestAct(){
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
        gameData.customers = new ArrayList<Customer>();
        gameData.reputation = 2;

        Customer customer = new Customer();
        gameData.customers.add(customer);
        gameData.gameLoop.totalCustomers=1;


        customer.timeLimit = 2;
        customer.act(1);
        assertEquals(1,customer.timeLimit,0.00001);

        customer.act(1);
        assertEquals(0,customer.timeLimit,0.00001);
        assertEquals(1,gameData.reputation,0.00001);
        assertEquals(0,gameData.gameLoop.totalCustomers);
        assertFalse(gameData.customers.contains(customer));


    }

    @Test
    public void TestSetTimeLimit(){
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
        gameData.customers = new ArrayList<Customer>();
        gameData.reputation = 2;

        Customer customer = new Customer();
        StageFactory stageFactory = Mockito.mock(StageFactory.class);
        stageFactory.difficultyVal=0;

        assertEquals(100,customer.setTimeLimit(),0.00001);
        stageFactory.difficultyVal=1;
        assertEquals(80,customer.setTimeLimit(),0.00001);
        stageFactory.difficultyVal=2;
        assertEquals(60,customer.setTimeLimit(),0.00001);
        stageFactory.difficultyVal=3;
        assertEquals(80,customer.setTimeLimit(),0.00001);

    }

    @Test
    public void TestGetOrderString() {

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
        gameData.customers = new ArrayList<Customer>();
        gameData.reputation = 2;

        Customer customer = new Customer(0, 60);
        Customer customer1 = new Customer(1, 60);
        Customer customer2 = new Customer(2, 60);
        Customer customer3 = new Customer(3, 60);


        assertEquals("Burger",customer.getOrderString());
        assertEquals("Salad",customer1.getOrderString());
        assertEquals("Pizza",customer2.getOrderString());
        assertEquals("Jacket Potato",customer3.getOrderString());


    }

}
