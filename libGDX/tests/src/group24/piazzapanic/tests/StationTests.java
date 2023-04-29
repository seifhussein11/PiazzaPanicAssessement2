package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Player;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.stations.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

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
    public void TestStationIsEquals(){
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        Movable item1 = Mockito.mock(Movable.class);
        Movable item2 = Mockito.mock(Movable.class);
        Station station1 = new Station(texture1);
        Station station2 = new Station(texture1);
        Station station3 = new Station(texture2);
        Player player = new Player(0,0,null);
        station3.item=item1;
        station3.available=1;
        station1.item = item1;
        station2.item = item1;
        station1.available=1;
        station2.available=1;
        assertTrue(station1.isEqual(station2));
        station2.item = item2;
        assertFalse(station1.isEqual(station2));
        assertFalse(station1.isEqual(station3));
        station2.available=0;
        station2.item = item1;
        assertFalse((station1.isEqual(station2)));
        assertFalse(station1.isEqual(player));





    }























}
