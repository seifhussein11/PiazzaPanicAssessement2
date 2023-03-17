package group24.piazzapanic.tests;

import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Level;
import group24.piazzapanic.game.Player;
import group24.piazzapanic.levelElements.stations.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class PlayerTests {

    @Test
    public void testPlayerPuttingDownItems() {
        Player player = new Player(0,0,null);
        Station station = Mockito.mock(Station.class);
        Movable movable = Mockito.mock(Movable.class);
        GameData gamedata = Mockito.mock(GameData.class);
        Level level = Mockito.mock(Level.class);
        gamedata.level = level;
        gamedata.player = player;
        player.holding = movable;
        Movable playerHolding = player.holding;
        station.item=null;
        Mockito.when(player.getFacingStation()).thenReturn(station);

        Mockito.when(station.placeItem(player.holding)).thenReturn(true);
        player.putDown();
        assertNotEquals(playerHolding,player.holding);
        assertNull(player.holding);
    }


    @Test
    public void testPlayerMovement() {
        // create a player object with some initial position and velocity
        Player player = new Player(0, 0, null);

        // simulate a game loop with a fixed time step and update the player's position
        double dt = 0.1; // time step
        double x0 = player.x; // initial x position
        double y0 = player.y; // initial y position
        double vx0 = player.x_vel; // initial x velocity
        double vy0 = player.y_vel; // initial y velocity
        double ax = Player.acceleration; // acceleration

        player.x_vel += ax * dt;
        player.y_vel += ax * dt;

        player.x += player.x_vel * dt;
        player.y += player.y_vel * dt;

        // check if the player's position has changed
        assertNotEquals(x0, player.x);
        assertNotEquals(y0, player.y);

        // check if the player's velocity has changed
        assertNotEquals(vx0, player.x_vel);
        assertNotEquals(vy0, player.y_vel);
    }

    @Test
    public void TestPlayerPickUp() {
        Player player = new Player(0,0,null);
        Station station = Mockito.mock(Station.class);
        Movable movable = Mockito.mock(Movable.class);
        Level level = Mockito.mock(Level.class);
        station.item = movable;
        player.holding=null;
        Movable onStation = station.item;
        GameData gamedata = Mockito.mock(GameData.class);
        gamedata.level = level;
        Mockito.when(player.getFacingStation()).thenReturn(station);
        Mockito.when(station.takeItem()).thenReturn(movable);
        player.pickUp();

    }

    @Test
    public void TestPlayerFacingStation(){
        Player player = new Player(1.5,1.5,null);  //1,1
        Station station1 = Mockito.mock(Station.class);
        Station station2 = Mockito.mock(Station.class);
        Station station3 = Mockito.mock(Station.class);
        Station station4 = Mockito.mock(Station.class);
        GameData gamedata = Mockito.mock(GameData.class);
        Level level = Mockito.mock(Level.class);
        gamedata.level = level;
        Mockito.when(level.getStation(1, 2)).thenReturn(station1); //UP
        Mockito.when(level.getStation(1, 0)).thenReturn(station2); //DOWN
        Mockito.when(level.getStation(0, 1)).thenReturn(station3); //LEFT
        Mockito.when(level.getStation(2, 1)).thenReturn(station4); //RIGHT
        player.direction = Player.facing.UP;
        assertEquals(station1,player.getFacingStation());
        player.direction = Player.facing.DOWN;
        assertEquals(station2, player.getFacingStation());
        player.direction= Player.facing.LEFT;
        assertEquals(station3, player.getFacingStation());
        player.direction= Player.facing.RIGHT;
        assertEquals(station4, player.getFacingStation());
        player.x=0;
        player.y=0;
        player.direction= Player.facing.LEFT;
        assertNull(player.getFacingStation());
        player.direction= Player.facing.DOWN;
        assertNull(player.getFacingStation());
    }

    @Test
    public void TestPlayerAct(){
//        Player player = new Player(0,0,null);
//        player.key = "falut";

    }

    @Test
    public void TestPlayerTop(){
        Player player = new Player(5,5,null);
        double result = player.y + player.GRID_WIDTH/2;
        double delta = 0.000001;

        assertEquals(result,player.top(),delta);
    }

    @Test
    public void TestPlayerBottom(){
        Player player = new Player(5,5,null);
        double result = player.y - player.GRID_WIDTH/2;
        double delta = 0.000001;

        assertEquals(result,player.bottom(),delta);
    }

    @Test
    public void TestPlayerRight(){
        Player player = new Player(5,5,null);
        double result = player.x + player.GRID_WIDTH/2;
        double delta = 0.000001;

        assertEquals(result,player.right(),delta);
    }

    @Test
    public void TestPlayerLeft(){
        Player player = new Player(5,5,null);
        double result = player.x - player.GRID_WIDTH/2;
        double delta = 0.000001;

        assertEquals(result,player.left(),delta);
    }







}









