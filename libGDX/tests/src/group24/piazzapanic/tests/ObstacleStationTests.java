package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.stations.Obstacle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(GdxTestRunner.class)


public class ObstacleStationTests {


    @Test
    public void TestHasItem(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.obstacleTexture = texture;
        Obstacle obstacle = new Obstacle();
        assertFalse(obstacle.hasItem());
    }

    @Test
    public void TestTakeItem(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.obstacleTexture = texture;
        Obstacle obstacle = new Obstacle();
        assertNull(obstacle.takeItem());
    }






}
