package group24.piazzapanic.tests;

import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(GdxTestRunner.class)
public class CustomerTests {

    @Test
    public void TestCustomerFulfillOrder(){ //i dont know whats wrong with this test why doesn't it work.
        GameData gameData =Mockito.mock(GameData.class);
        Customer customer = Mockito.mock(Customer.class);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer);
        gameData.customers = customers;
        System.out.println(gameData.customers);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.score = 0;
        customer.fulfillOrder();
        System.out.println(gameData.customers);
        assertFalse(gameData.customers.contains(customer));
        Integer expectedScore = 1;
        assertEquals(expectedScore,gameData.score);


    }










}
