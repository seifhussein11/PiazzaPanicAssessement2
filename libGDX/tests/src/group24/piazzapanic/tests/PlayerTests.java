package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import group24.piazzapanic.Base;
import group24.piazzapanic.Physics.Movable;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Level;
import group24.piazzapanic.game.Player;
import group24.piazzapanic.levelElements.stations.Station;
import group24.piazzapanic.ui.StageAnimation;
import group24.piazzapanic.ui.StageFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.HashMap;

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
        assertTrue(player.putDown());
        player.putDown();
        assertNotEquals(playerHolding,player.holding);
        assertNull(player.holding);
        player.holding = movable;
        Mockito.when(station.placeItem(player.holding)).thenReturn(false);
        assertFalse(player.putDown());
        player.putDown();
        assertEquals(movable,player.holding);
        Mockito.when(player.getFacingStation()).thenReturn(null);
        assertFalse(player.putDown());
        player.putDown();
        assertEquals(movable,player.holding);


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
        Station station = new Station(Mockito.mock(Texture.class));
        Movable movable = Mockito.mock(Movable.class);
        Level level = Mockito.mock(Level.class);
        station.item = movable;
        player.holding=null;
        Movable onStation = station.item;
        GameData gamedata = Mockito.mock(GameData.class);
        gamedata.level = level;
        Mockito.when(player.getFacingStation()).thenReturn(station);
        player.pickUp();
        assertEquals(onStation,player.holding);
        assertEquals(true,player.pickUp());
        assertNull(station.item);
        station.item = movable;
        player.holding=null;
        Mockito.when(player.getFacingStation()).thenReturn(null);
        player.pickUp();
        assertEquals(true,player.pickUp());
        assertEquals(onStation,station.item);
        assertNull(player.holding);

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
        player.direction =Player.facing.SOMEOTHERDIRECTION;
        assertNull(player.getFacingStation());
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

    @Test
    public void TestPlayerAct(){
        HashMap<String, Animation<TextureRegion>> mockedMap = new HashMap<>();

        Animation<TextureRegion> mockAnimation = Mockito.mock(Animation.class);
        mockedMap.put("IdleFrontSelected",mockAnimation);


        GameData gameData = Mockito.mock(GameData.class);
        gameData.level = Mockito.mock(Level.class);
        Player player = new Player(7,2,Mockito.mock(StageAnimation.class),mockedMap);
        gameData.player = player;
        player.direction = Player.facing.DOWN;
        player.BasePickUpKey = true;
        player.BaseActKey=true;
        Station station = new Station(Mockito.mock(Texture.class));
        station.item = Mockito.mock(Movable.class);
        Movable item = station.item;
        Mockito.when(player.getFacingStation()).thenReturn(station);
        station.timeKeyHeld= (float) 0.3;
        player.act((float) 0.1);
        assertEquals("IdleFrontSelected",player.getKey());
        assertEquals("IdleFrontSelected",player.getCurrentKey());
        assertEquals(item,player.holding);
        assertTrue(player.playerInteracting);
        assertEquals(player.x,player.playerInteractX,0.000001);
        assertEquals(player.y,player.playerInteractY,0.000001);
        assertEquals(station,player.interactingStation);
        assertEquals(((player.x - Player.GRID_WIDTH * Player.TEXTURE_SCALE / 2)* Base.TILE_GRID_UNIT),player.getPlayerPosition().x,0.000001);
        assertEquals(((player.y - Player.GRID_WIDTH / 2)* Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT),player.getPlayerPosition().y,0.000001);
        assertEquals((player.getPlayerPosition().getAbsoluteX()+GameData.offsetX),player.getPlayerBar().getX(),0.000001);
        assertEquals((player.getPlayerPosition().getAbsoluteY()+GameData.offsetY+Player.TEXTURE_HEIGHT+5),player.getPlayerBar().getY(),0.000001);
        assertEquals(station.timeKeyHeld,player.getPlayerBar().getValue(),0.000001);
        assertTrue(player.getPlayerDrawBar());
        player.direction= Player.facing.UP;
        player.act((float) 0.1);
        assertEquals("IdleBackSelected",player.getKey());
        assertEquals("IdleBackSelected",player.getCurrentKey());
        player.act((float)0.1);
        assertEquals("IdleBackSelected",player.getCurrentKey());
        player.direction= Player.facing.LEFT;
        player.act((float) 0.1);
        assertEquals("IdleLeftSelected",player.getKey());
        assertEquals("IdleLeftSelected",player.getCurrentKey());
        player.direction= Player.facing.RIGHT;
        player.act((float) 0.1);
        assertEquals("IdleRightSelected",player.getKey());
        assertEquals("IdleRightSelected",player.getCurrentKey());
        player.direction= Player.facing.SOMEOTHERDIRECTION;
        player.act((float)0.1);
        assertEquals("IdleFrontSelected",player.getKey());
        assertEquals("IdleFrontSelected",player.getCurrentKey());
        gameData.player = new Player(3,2,Mockito.mock(StageAnimation.class),mockedMap);
        player.holding=null;
        player.playerInteractX=0;
        player.playerInteractY=0;
        player.direction= Player.facing.SOMEOTHERDIRECTION;
        player.act((float) 0.1);
        assertEquals("IdleFront",player.getKey());
        assertEquals("IdleFront",player.getCurrentKey());
        player.direction= Player.facing.UP;
        Mockito.when(player.getFacingStation()).thenReturn(station);
        player.act((float)0.1);
        assertNull(player.holding);
        assertFalse(player.playerInteracting);
        assertNotEquals(player.x,player.playerInteractX,0.000001);
        assertNotEquals(player.y,player.playerInteractY,0.000001);
        assertNotEquals(station,player.interactingStation);

        gameData.player = player;
        player.direction = Player.facing.LEFT;
        player.x_vel = 2;
        player.y_vel = 1;
        player.act((float)0.1);
        assertEquals("Left",player.getKey());
        assertEquals("Left",player.getCurrentKey());
        player.x_vel=0;
        player.y_vel=0;
        player.holding=item;
        station.item=null;
        Mockito.when(player.getFacingStation()).thenReturn(station);
        player.act((float)0.1);
        assertNull(player.holding);
        assertEquals(item,station.item);
        Mockito.when(player.getFacingStation()).thenReturn(null);
        player.playerInteracting = false;
        player.playerInteractX=0;
        player.playerInteractY=0;
        player.interactingStation=null;
        player.act((float)0.1);
        assertFalse(player.playerInteracting);
        assertNotEquals(player.x,player.playerInteractX,0.000001);
        assertNotEquals(player.y,player.playerInteractY,0.000001);
        assertNotEquals(station,player.interactingStation);
        player.BasePickUpKey = false;
        player.holding=null;
        station.item=item;
        player.act((float)0.1);
        assertNull(player.holding);
        assertNotNull(station.item);
        player.holding = item;
        station.item=null;
        player.act((float)0.1);
        assertNotNull(player.holding);
        assertNull(station.item);
        player.BaseActKey=false;
        player.act((float)0.1);
        assertFalse(player.playerInteracting);
        assertNotEquals(player.x,player.playerInteractX,0.000001);
        assertNotEquals(player.y,player.playerInteractY,0.000001);
        assertNotEquals(station,player.interactingStation);
        assertFalse(player.getPlayerDrawBar());
        Mockito.when(player.getFacingStation()).thenReturn(station);
        player.playerInteracting = true;
        player.interactingStation = station;
        player.act((float)0.1);
        assertFalse(player.playerInteracting);
        assertFalse(player.getPlayerDrawBar());
        assertNull(player.interactingStation);
        player.BaseActKey=true;
        station.timeKeyHeld= (float) 0.08;
        player.getPlayerPosition().x=0;
        player.getPlayerPosition().y=0;
        player.getPlayerBar().setX(0);
        player.getPlayerBar().setY(0);

        player.act((float)0.1);
        assertFalse(player.getPlayerDrawBar());
        assertNotEquals(((player.x - Player.GRID_WIDTH * Player.TEXTURE_SCALE / 2)* Base.TILE_GRID_UNIT),player.getPlayerPosition().x,0.000001);
        assertNotEquals(((player.y - Player.GRID_WIDTH / 2)* Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT),player.getPlayerPosition().y,0.000001);
        assertNotEquals((player.getPlayerPosition().getAbsoluteX()+GameData.offsetX),player.getPlayerBar().getX(),0.000001);
        assertNotEquals((player.getPlayerPosition().getAbsoluteY()+GameData.offsetY+Player.TEXTURE_HEIGHT+5),player.getPlayerBar().getY(),0.000001);
    }


    @Test
    public void TestPlayerSetSpeed(){
        Player player = new Player(0,0,null);
        StageFactory stageFactory = Mockito.mock(StageFactory.class);
        stageFactory.difficultyVal = 0;
        assertEquals(3.6,player.setSpeed(),0.00001);
        assertNotEquals(3,player.setSpeed(),0.00001);
        assertNotEquals(2.5,player.setSpeed(),0.00001);

        stageFactory.difficultyVal = 1;
        assertNotEquals(3.6,player.setSpeed(),0.00001);
        assertEquals(3,player.setSpeed(),0.00001);
        assertNotEquals(2.5,player.setSpeed(),0.00001);

        stageFactory.difficultyVal = 2;
        assertNotEquals(3.6,player.setSpeed(),0.00001);
        assertNotEquals(3,player.setSpeed(),0.00001);
        assertEquals(2.5,player.setSpeed(),0.00001);

        stageFactory.difficultyVal = 4;
        assertNotEquals(3.6,player.setSpeed(),0.00001);
        assertEquals(3,player.setSpeed(),0.00001);
        assertNotEquals(2.5,player.setSpeed(),0.00001);

    }













}









