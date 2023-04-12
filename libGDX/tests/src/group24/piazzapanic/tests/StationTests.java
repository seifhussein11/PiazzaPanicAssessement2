package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.Customer;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.stations.ServingStation;
import group24.piazzapanic.levelElements.stations.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class StationTests {

    @Test
    public void TestStationPlaceItem(){
        Texture texture = Mockito.mock(Texture.class);
        Station station = new Station(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        Dish item1 = Mockito.mock(Dish.class);
        station.item = item1;
        Ingredient item2 = Mockito.mock(Ingredient.class);
        Mockito.when(item1.addIngredient(item2)).thenReturn(true);
        assertEquals(true,station.placeItem(item2));
        station.item=null;
        station.placeItem(item2);
        assertEquals(item2,station.item);
        Ingredient item3 = Mockito.mock(Ingredient.class);
        station.item=item2;
        station.placeItem(item3);
        assertEquals(item2,station.item);
        assertFalse(station.placeItem(item3));
    }

    @Test
    public void TestStationHasItem(){
        Texture texture = Mockito.mock(Texture.class);
        Station station = new Station(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        Dish item1 = Mockito.mock(Dish.class);
        station.item = item1;
        assertTrue(station.hasItem());
        Ingredient item2 = Mockito.mock(Ingredient.class);
        station.item = item2;
        assertTrue(station.hasItem());
        station.item=null;
        assertFalse(station.hasItem());
    }

    @Test
    public void TestStationTakeItem(){
        Texture texture = Mockito.mock(Texture.class);
        Station station = new Station(texture);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.dishTexture = texture;
        Dish item1 = Mockito.mock(Dish.class);
        station.item = item1;
        station.takeItem();
        assertNull(station.item);
        station.item=item1;
        assertEquals(item1,station.takeItem());
        Ingredient item2 = Mockito.mock(Ingredient.class);
        station.item = item2;
        assertEquals(item2,station.takeItem());
        station.takeItem();
        assertNull(station.item);
        station.item=null;
        assertNull(station.takeItem());
    }

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





















}
