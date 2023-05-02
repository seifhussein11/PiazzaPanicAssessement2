package group24.piazzapanic.tests;


import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(GdxTestRunner.class)
public class GameDataTests {


    @Test
    public void TestGameDataAddScore(){
        GameData gameData = new GameData();
        GameLoop gameloop = Mockito.mock(GameLoop.class);

        gameData.gameLoop = gameloop;

        gameData.score = 0;

        gameData.addScore(1);
        Integer expectedScore = 1;

        assertEquals(expectedScore,gameData.score);
        for (int i = 1; i < 100; i++){
            gameData.addScore(1);
        }
        expectedScore = 100;

        assertEquals(expectedScore,gameData.score);

        gameData.addScore(-150);
        assertEquals(-50,gameData.score,0.00001);
        assertNotEquals(expectedScore,gameData.score);


    }

    @Test
    public void TestGameDataAddMoney(){
        GameData gameData = new GameData();
        GameLoop gameloop = Mockito.mock(GameLoop.class);

        gameData.gameLoop = gameloop;

        gameData.money = 0;

        gameData.addMoney(1);
        Integer expectedMoney = 1;

        assertEquals(expectedMoney,gameData.money);
        for (int i = 1; i < 100; i++){
            gameData.addMoney(1);
        }
        expectedMoney = 100;

        assertEquals(expectedMoney,gameData.money);
        gameData.addMoney(-150);
        assertEquals(-50,gameData.money,0.00001);
        assertNotEquals(expectedMoney,gameData.money);

    }
    @Test
    public void TestGameDataSetScore(){

        GameData gameData = new GameData();
        GameLoop gameloop = Mockito.mock(GameLoop.class);

        gameData.gameLoop = gameloop;

        gameData.score = 20;

        gameData.setScore(1);
        Integer expectedScore = 1;
        assertEquals(expectedScore,gameData.score);
        gameData.setScore(-1);
        assertEquals(-1,gameData.score,0.00001);
        assertNotEquals(expectedScore,gameData.score);
    }

    @Test
    public void TestGameDataSetMoney(){
        GameData gameData = new GameData();
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;

        gameData.money = 0;
        gameData.setMoney(5);
        assertEquals(5,gameData.money,0.00001);
        gameData.setMoney(-5);
        assertEquals(-5,gameData.money,0.00001);
        assertNotEquals(5,gameData.money,0.00001);
    }

    @Test
    public void TestLoseReputation(){
        GameData gameData = new GameData();
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.reputation = 5;
        gameData.loseReputation(1);

        assertEquals(4,gameData.reputation,0.00001);
        gameData.loseReputation(-1);
        assertEquals(5,gameData.reputation,0.00001);
        assertNotEquals(3,gameData.reputation,0.00001);
        gameData.reputation = 105;
        gameData.loseReputation(100);
        assertEquals(5,gameData.reputation,0.00001);

    }

    @Test
    public void TestAddReputation(){
        GameData gameData = new GameData();
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.reputation = 5;
        gameData.addReputation(1);
        assertEquals(6,gameData.reputation,0.00001);
        gameData.addReputation(-1);
        assertEquals(5,gameData.reputation,0.00001);
        assertNotEquals(7,gameData.reputation,0.00001);
        gameData.addReputation(100);
        assertEquals(105,gameData.reputation,0.00001);
        gameData.addReputation(-105);
        assertEquals(0,gameData.reputation,0.00001);

    }

    @Test
    public void TestSetReputation(){
        GameData gameData = new GameData();
        GameLoop gameLoop = Mockito.mock(GameLoop.class);
        gameData.gameLoop = gameLoop;
        gameData.reputation = 5;
        gameData.setReputation(2);

        assertEquals(2,gameData.reputation,0.00001);
        assertNotEquals(5,gameData.reputation,0.00001);

        gameData.setReputation(-2);
        assertEquals(-2,gameData.reputation,0.00001);
        assertNotEquals(2,gameData.reputation,0.00001);
        gameData.setReputation(100);
        assertEquals(100,gameData.reputation,0.00001);
        assertNotEquals(-2,gameData.reputation,0.00001);



    }







}
