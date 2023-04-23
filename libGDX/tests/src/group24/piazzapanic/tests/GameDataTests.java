package group24.piazzapanic.tests;


import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

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
    }







}
