package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.stations.ServingStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class ServingStationTests {
    @Test
    public void TestServingStationServeOrder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Texture texture = Mockito.mock(Texture.class);
        ServingStation servingStation = new ServingStation(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        Dish dish1 = Mockito.mock(Dish.class);
        Dish dish2 = Mockito.mock(Dish.class);
        Customer customer = Mockito.mock(Customer.class);
        gameData.customers = new ArrayList<Customer>();
        gameData.customers.add(customer);
        Mockito.when(customer.getOrder()).thenReturn(dish1);
        Method serveMethod = ServingStation.class.getDeclaredMethod("serveOrder", Movable.class);
        serveMethod.setAccessible(true);
        boolean result = (boolean) serveMethod.invoke(servingStation,dish1);
        assertEquals(true,result);
        Mockito.when(customer.getOrder()).thenReturn(dish2);
        boolean result2 = (boolean) serveMethod.invoke(servingStation,dish1);
        assertFalse(result2);

    }

    @Test
    public void TestServingStationPlaceItem(){
        Texture texture = Mockito.mock(Texture.class);
        ServingStation station = new ServingStation(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        Dish dish = Mockito.mock(Dish.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Customer customer = Mockito.mock(Customer.class);
        Mockito.when(customer.getOrder()).thenReturn(dish);
        gameData.customers = new ArrayList<>();
        gameData.customers.add(customer);
        assertTrue(station.placeItem(dish));
        assertFalse(station.placeItem(ingredient));
    }

    @Test
    public void TestServingStationTakeItem(){
        Texture texture = Mockito.mock(Texture.class);
        ServingStation station = new ServingStation(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        station.item = Mockito.mock(Dish.class);
        station.takeItem();
        assertNull(station.item);
        station.item = null;
        station.takeItem();
        assertNull(station.item);

    }



}
