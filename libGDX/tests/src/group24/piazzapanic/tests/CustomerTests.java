package group24.piazzapanic.tests;

import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(GdxTestRunner.class)
public class CustomerTests {

    @Test
    public void TestCustomerFulfillOrder(){
        Customer customer = Mockito.mock(Customer.class);
        GameData gameData = Mockito.mock(GameData.class);
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        GameData.gameLoop = gameLoop;
        ArrayList<Customer> myList = new ArrayList<>();
        gameData.customers=myList;
        gameData.customers.add(customer);
        ArrayList<Customer> oldCustomers = gameData.customers;
        Integer expectedScore = gameData.score+1;
        customer.fulfillOrder();
        assertNotEquals(oldCustomers,gameData.customers);
        assertEquals(expectedScore,gameData.score);

    }










}
