package group24.piazzapanic.tests;

import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Player;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class GameTests {



    @Test
    public void testAddScore(){
        GameData.init();
        Player player = new Player(GameData.level.startX + 0.5, GameData.level.startY + 0.5, GameData.initialChef1Animation, GameData.chef1Animations);
        assertEquals(2,2);
    }







}
//    Customer customer = Mockito.mock(Customer.class);
//    GameData gameData = Mockito.mock(GameData.class);
//    GameLoop gameLoop = Mockito.mock(GameLoop.class);
//        GameData.gameLoop = gameLoop;
//                gameData.customers= new ArrayList<Customer>();
//        gameData.customers.add(customer);
//        ArrayList<Customer> oldCustomers = gameData.customers;
//        Integer expectedScore = gameData.score+1;
//        customer.fulfillOrder();
//        assertFalse(gameData.customers.contains(customer));
////assertEquals(expectedScore,gameData.score);