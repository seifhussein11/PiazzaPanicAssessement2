package group24.piazzapanic.tests;


import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class PhysicsTests {

    @Test
    public void TestPhysicsIsSolid(){
        Physics physics = new Physics();
        GameData gameData = new GameData();
        Texture texture = Mockito.mock(Texture.class);
        gameData.counterEndTexture = texture;
        gameData.counterRightTexture = texture;
        gameData.counterRightCornerTexture = texture;
        gameData.counterTopTexture = texture;
        gameData.servingStationTexture = texture;
        gameData.bakingStationTexture = texture;
        gameData.fryingStationTexture = texture;
        gameData.cuttingStationTexture = texture;
        gameData.binTexture = texture;
        gameData.ingredientStationTexture = texture;
        gameData.obstacleTexture =texture;
        gameData.dishStationTexture = texture;
        GameData.tomatoStationTexture = texture;
        GameData.onionStationTexture=texture;
        GameData.lettuceStationTexture=texture;
        GameData.breadStationTexture=texture;
        GameData.meatStationTexture=texture;
        GameData.dishStationTexture=texture;
        GameData.doughStationTexture=texture;
        GameData.sauceStationTexture=texture;
        GameData.cheeseStationTexture=texture;
        GameData.potatoStationTexture=texture;
        Level level = new Level("levels/Level 3");
        gameData.level = level;
        gameData.gameLoop = Mockito.mock(GameLoop.class);
        assertTrue(physics.isSolid(1.2,5.3)); //countertop
        assertFalse(physics.isSolid(2.7,2));  // no station
        assertTrue(physics.isSolid(13.5,5.3)); // more than the game data level width
        assertTrue(physics.isSolid(3.5,7.3));//more than the game data level height
        assertTrue(physics.isSolid(13.5,7.3)); // more than both level height and width
        assertTrue(physics.isSolid(-1,7.3)); // less than height
        assertTrue(physics.isSolid(1,-2.4)); // less than width
        assertTrue(physics.isSolid(-1,-7.3)); // less than height and weight
        assertTrue(physics.isSolid(2.4,3.9)); // ingredient station
        assertFalse(physics.isSolid(10,4));  // no station
//(1,5) (2,1) (2,3) (0,1) (0,3) (0,5) (1,0)
    }
    @Test
    public void TestPhysicsPlayerMovement() {
        Physics physics = new Physics();
        GameData gameData = new GameData();
        Texture texture = Mockito.mock(Texture.class);
        gameData.counterEndTexture = texture;
        gameData.counterRightTexture = texture;
        gameData.counterRightCornerTexture = texture;
        gameData.counterTopTexture = texture;
        gameData.servingStationTexture = texture;
        gameData.bakingStationTexture = texture;
        gameData.fryingStationTexture = texture;
        gameData.cuttingStationTexture = texture;
        gameData.binTexture = texture;
        gameData.ingredientStationTexture = texture;
        gameData.obstacleTexture =texture;
        gameData.dishStationTexture = texture;
        GameData.tomatoStationTexture = texture;
        GameData.onionStationTexture=texture;
        GameData.lettuceStationTexture=texture;
        GameData.breadStationTexture=texture;
        GameData.meatStationTexture=texture;
        GameData.dishStationTexture=texture;
        GameData.doughStationTexture=texture;
        GameData.sauceStationTexture=texture;
        GameData.cheeseStationTexture=texture;
        GameData.potatoStationTexture=texture;
        Level level = new Level("levels/Level 3");
        gameData.level = level;
        gameData.gameLoop = Mockito.mock(GameLoop.class);
        Player player = new Player(10,4,null);
        float delta = (float) 0.1;

        double acc = player.acceleration;
        double deacc = player.deacceleration;
        // test player pressing up
        player.direction = Player.facing.DOWN;
        physics.upPressed = true;
        double expectedVelocityUp = player.y_vel + acc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityUp,player.y_vel,0.000000001);
        assertEquals(Player.facing.UP,player.direction);
        // test player pressing down
        physics.upPressed = false;
        physics.downPressed = true;
        player.direction = Player.facing.UP;
        double expectedVelocityDown = player.y_vel - acc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityDown,player.y_vel,0.000000001);
        assertEquals(Player.facing.DOWN,player.direction);
        // test player not pressing up nor down and y velocity positive
        physics.upPressed = false;
        physics.downPressed = false;
        player.y_vel = 2.5;
        double expectedVelocityNoPressUDPos = player.y_vel - deacc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityNoPressUDPos,player.y_vel,0.000000001);
        // y velocity is negative
        player.y_vel = -2.5;
        double expectedVelocityNoPressUDNeg = player.y_vel + deacc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityNoPressUDNeg,player.y_vel,0.000000001);
        // test player deaccelated beyond a certain point in y
        player.y_vel = 2.2;
        double expectedVelocityDeacclerationY = 0;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityDeacclerationY,player.y_vel,0.000000001);
        // test player pressing left
        physics.downPressed = false;
        physics.leftPressed = true;
        player.direction = Player.facing.UP;
        double expectedVelocityLeft = player.x_vel - acc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityLeft,player.x_vel,0.000000001);
        assertEquals(Player.facing.LEFT,player.direction);
        // test player press  right
        physics.leftPressed = false;
        physics.rightPressed = true;
        player.direction = Player.facing.UP;
        double expectedVelocityRight = player.x_vel + acc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityRight,player.x_vel,0.000000001);
        assertEquals(Player.facing.RIGHT,player.direction);
        // test player not pressing right nor left positive
        physics.leftPressed = false;
        physics.rightPressed = false;
        player.y_vel=0;
        player.x_vel = 2.5;
        double expectedVelocityNoPressLRPos = player.x_vel - deacc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityNoPressLRPos,player.x_vel,0.000000001);
        // x velocity is negative
        player.x_vel = -2.5;
        double expectedVelocityNoPressLRNeg = player.x_vel + deacc * delta;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityNoPressLRNeg,player.x_vel,0.000000001);
        // test player deaccelrated beyond a certain point in x
        player.x_vel = 2.3;
        double expectedVelocityDeacclerationX = 0;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityDeacclerationX,player.x_vel,0.000000001);
        // test player moving with more than max speed in y
        player.direction = Player.facing.DOWN;
        physics.downPressed = false;
        physics.rightPressed = false;
        physics.leftPressed = false;
        physics.upPressed = true;
        player.y_vel=3;
        physics.playerMovement(player,delta);
        double expectedVelocityUpMax = 3;
        assertEquals(expectedVelocityUpMax,player.y_vel,0.000000001);
        assertEquals(Player.facing.UP,player.direction);
        // player moving with less that min speed in y
        physics.upPressed = false;
        physics.downPressed = true;
        player.direction = Player.facing.UP;
        player.y_vel=-3;
        double expectedVelocityDownMin = -3;
        physics.playerMovement(player,delta);
        assertEquals(expectedVelocityDownMin,player.y_vel,0.000000001);
        assertEquals(Player.facing.DOWN,player.direction);
        // player moving with more than max speed in x
        player.direction = Player.facing.DOWN;
        physics.downPressed = false;
        physics.rightPressed = true;
        physics.leftPressed = false;
        physics.upPressed = false;
        player.x_vel=3;
        physics.playerMovement(player,delta);
        double expectedVelocityRightMax = 3;
        assertEquals(expectedVelocityRightMax,player.x_vel,0.000000001);
        assertEquals(Player.facing.RIGHT,player.direction);
        // player moving with less than min speed in x
        player.direction = Player.facing.DOWN;
        physics.rightPressed = false;
        physics.leftPressed = true;
        player.x_vel=-3;
        physics.playerMovement(player,delta);
        double expectedVelocityRightMin = -3;
        assertEquals(expectedVelocityRightMin,player.x_vel,0.000000001);
        assertEquals(Player.facing.LEFT,player.direction);
        // test collision delta_x < 0
        Player player2 = new Player(0.2,1.2,null);
        physics.downPressed = false;
        physics.leftPressed = true;
        player2.direction = Player.facing.UP;
        double realVelocityLeftObstacleXneg = player2.x_vel - acc * delta;
        double expectedVelocityLeftObstacleXneg = 0;
        double delta_xNeg = realVelocityLeftObstacleXneg * delta;
        double expectedDeltaXneg = Math.min(Math.ceil(player.left() + delta_xNeg) - player.left() + Player.movementEpsilon, 0);
        double expectedPlayerXneg= player2.x + expectedDeltaXneg;
        physics.playerMovement(player2,delta);
        assertEquals(expectedVelocityLeftObstacleXneg,player2.x_vel,0.000000001);
        assertEquals(expectedPlayerXneg,player2.x,0.0000001);
        assertEquals(Player.facing.LEFT,player2.direction);
        // test collision delta_x > 0
        physics.downPressed = false;
        physics.leftPressed = false;
        physics.rightPressed = true;
        player2.direction = Player.facing.UP;
        double realVelocityLeftObstacleXpos = player2.x_vel + acc * delta;
        double expectedVelocityLeftObstacleXpos = 0;
        double delta_xPos = realVelocityLeftObstacleXpos * delta;
        double expectedDeltaXpos = Math.max(Math.floor(player.right() + delta_xPos) - player.right() - Player.movementEpsilon, 0);
        double expectedPlayerXpos= player2.x + expectedDeltaXpos;
        physics.playerMovement(player2,delta);
        assertEquals(expectedVelocityLeftObstacleXpos,player2.x_vel,0.000000001);
        assertEquals(expectedPlayerXpos,player2.x,0.0000001);
        assertEquals(Player.facing.RIGHT,player2.direction);
        // test collision delta_y < 0
        physics.downPressed = true;
        physics.leftPressed = false;
        physics.rightPressed = false;
        player2.direction = Player.facing.UP;
        double realVelocityLeftObstacleYneg = player2.y_vel - acc * delta;
        double expectedVelocityLeftObstacleYneg = 0;
        double delta_yNeg = realVelocityLeftObstacleYneg * delta;
        double expectedDeltaYneg = Math.min(Math.ceil(player.bottom() + delta_yNeg) - player.bottom() + Player.movementEpsilon, 0);;
        double expectedPlayerYneg= player2.y + expectedDeltaYneg;
        physics.playerMovement(player2,delta);
        assertEquals(expectedVelocityLeftObstacleYneg,player2.y_vel,0.000000001);
        assertEquals(expectedPlayerYneg,player2.y,0.0000001);
        assertEquals(Player.facing.DOWN,player2.direction);
        // test collision delta_y > 0
        physics.downPressed = false;
        physics.leftPressed = false;
        physics.rightPressed = false;
        physics.upPressed = true;
        player2.direction = Player.facing.DOWN;
        double realVelocityLeftObstacleYpos = player2.y_vel + acc * delta;
        double expectedVelocityLeftObstacleYpos = 0;
        double delta_yPos = realVelocityLeftObstacleYpos * delta;
        double expectedDeltaYpos = Math.min(Math.ceil(player.bottom() + delta_yPos) - player.bottom() + Player.movementEpsilon, 0);;
        double expectedPlayerYpos= player2.y + expectedDeltaYpos;
        physics.playerMovement(player2,delta);
        assertEquals(expectedVelocityLeftObstacleYpos,player2.y_vel,0.000000001);
        assertEquals(expectedPlayerYpos,player2.y,0.0000001);
        assertEquals(Player.facing.UP,player2.direction);

    }







}
