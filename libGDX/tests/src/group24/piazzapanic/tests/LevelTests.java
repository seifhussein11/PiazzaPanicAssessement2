package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.Level;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.levelElements.stations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class LevelTests {


    @Test
    public void TestLevelConstructor(){
        GameData gameData = new GameData();
        Texture texture = new Texture( "stations/sourceerr.png");
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
        gameData.tomatoStationTexture = texture;
        gameData.onionStationTexture=texture;
        gameData.lettuceStationTexture=texture;
        gameData.breadStationTexture=texture;
        gameData.meatStationTexture=texture;
        gameData.dishStationTexture=texture;
        gameData.doughStationTexture=texture;
        gameData.sauceStationTexture=texture;
        gameData.cheeseStationTexture=texture;
        gameData.potatoStationTexture=texture;
        gameData.lockedBakingStationTexture=texture;
        gameData.lockedFryingStationTexture=texture;
        gameData.lockedCuttingStationTexture=texture;
        gameData.errorTexture = texture;
        FryingStation fryingStation = new FryingStation(texture);
        FryingStation lockedFryingStation = new FryingStation(texture);
        lockedFryingStation.available=0;
        BakingStation bakingStation = new BakingStation(texture);
        BakingStation lockedBakingStation = new BakingStation(texture);
        lockedBakingStation.available=0;
        CounterTop counterTop = new CounterTop(texture);
        CuttingStation cuttingStation = new CuttingStation(texture);
        CuttingStation lockedCuttingStation = new CuttingStation(texture);
        lockedCuttingStation.available=0;
        ErrorStation errorStation = new ErrorStation();
        IngredientStation ingredientStation1= new IngredientStation(4,0,new IngredientType("tomato"));

        IngredientStation ingredientStation2= new IngredientStation(4,0,new IngredientType("meat"));
        IngredientStation ingredientStation3= new IngredientStation(4,0,new IngredientType("lettuce"));
        IngredientStation ingredientStation4= new IngredientStation(4,0,new IngredientType("onion"));
        IngredientStation ingredientStation5= new IngredientStation(4,0,new IngredientType("bread"));
        IngredientStation ingredientStation6= new IngredientStation(4,0,new IngredientType("cheese"));
        IngredientStation ingredientStation7= new IngredientStation(4,0,new IngredientType("sauce"));
        IngredientStation ingredientStation8= new IngredientStation(4,0,new IngredientType("dough"));
        IngredientStation ingredientStation9= new IngredientStation(4,0,new IngredientType("potato"));
        IngredientStation ingredientStation10= new IngredientStation(4,0,new IngredientType("dish"));
        Obstacle obstacle = new Obstacle();
        ServingStation servingStation = new ServingStation(texture);
        Bin bin = new Bin();
        String name = "levels/Level 3";
        String[] initial_layout=
                {"c.3.r.sD...1",
                        "..lC.....2..",
                        "x.......b...",
                        "F..oW....d..",
                        ".B....Sg....",
                        "f...th..p..m"};
        Level level = new Level("levels/Level 3",initial_layout);

//
        assertEquals(name,level.getLevelName());
        assertEquals(12,level.getWidth());
        assertEquals(6,level.getHeight());
        for(String line:level.initial_layout){
            assertTrue(line.length() == level.getWidth());
        }

        int y =0;
        for (int j = level.getHeight()-1;j>=0;j--){

            for(int i = 0; i < level.getWidth();i++){

                switch(level.initial_layout[j].charAt(i)){
                    case '.':
                        assertEquals(null,level.grid[i][y]);
                        continue;

                    case 'B':
                        assertTrue(level.grid[i][y].isEqual(bakingStation));
                        break;

                    case 'b':
                        assertTrue(level.grid[i][y].isEqual(lockedBakingStation));
                        assertEquals(0,level.grid[i][y].available);
                        break;

                    case '1':
                    case '2':
                    case '3':
                    case '4':
                        assertTrue(level.grid[i][y].isEqual(counterTop));
                        break;

                    case 'C':
                        assertTrue(level.grid[i][y].isEqual((cuttingStation)));
                        break;

                    case 'c':
                        assertTrue(level.grid[i][y].isEqual(lockedCuttingStation));
                        assertEquals(0,level.grid[i][y].available);
                        break;

                    case 'F':
                        assertTrue(level.grid[i][y].isEqual(fryingStation));
                        break;

                    case 'f':
                        assertTrue(level.grid[i][y].isEqual(lockedFryingStation));
                        assertEquals(0,level.grid[i][y].available);
                        break;

                    case 't':
                        assertTrue(level.grid[i][y].isEqual(ingredientStation1));
                        break;
                    case 'o':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation4));
                        break;
                    case 'l':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation3));
                        break;
                    case 'r':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation5));
                        break;
                    case 'm':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation2));
                        break;
                    case 'h':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation6));
                        break;
                    case 'S':
                        assertTrue(level.grid[i][y].isEqual(ingredientStation7 ));
                        break;
                    case 'D':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation8));
                        break;
                    case 'p':
                        assertTrue(level.grid[i][y].isEqual(ingredientStation9 ));
                        break;
                    case 'd':
                        assertTrue( level.grid[i][y].isEqual(ingredientStation10));
                        break;

                    case 'W':
                        assertTrue(level.grid[i][y].isEqual(obstacle ));
                        break;

                    case 'g':
                        assertTrue(level.grid[i][y].isEqual(bin ));
                        break;

                    case 's':
                        assertTrue(level.grid[i][y].isEqual(servingStation ));
                        break;

                    default:
                        assertTrue( level.grid[i][y].isEqual(errorStation));

                }
                System.out.println(level.initial_layout[j].charAt(i));
                System.out.println(level.grid[i][y]);

            }
            y++;
        }






    }

    @Test
    public void TestGetLevelName(){
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
        gameData.tomatoStationTexture = texture;
        gameData.onionStationTexture=texture;
        gameData.lettuceStationTexture=texture;
        gameData.breadStationTexture=texture;
        gameData.meatStationTexture=texture;
        gameData.dishStationTexture=texture;
        gameData.doughStationTexture=texture;
        gameData.sauceStationTexture=texture;
        gameData.cheeseStationTexture=texture;
        gameData.potatoStationTexture=texture;
        gameData.lockedBakingStationTexture=texture;
        gameData.lockedFryingStationTexture=texture;
        gameData.lockedCuttingStationTexture=texture;
        String name = "levels/Level 3";
        Level level = new Level("levels/Level 3");
        Level level2 = new Level("levels/Level 3");
        Level level3 = new Level("levels/Level 4");
        assertEquals(name,level.getLevelName());
        assertTrue(level.getLevelName()==level2.getLevelName());
        assertFalse(level2.getLevelName()==level3.getLevelName());
    }

    @Test
    public void TestGetStation(){
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
        gameData.tomatoStationTexture = texture;
        gameData.onionStationTexture=texture;
        gameData.lettuceStationTexture=texture;
        gameData.breadStationTexture=texture;
        gameData.meatStationTexture=texture;
        gameData.dishStationTexture=texture;
        gameData.doughStationTexture=texture;
        gameData.sauceStationTexture=texture;
        gameData.cheeseStationTexture=texture;
        gameData.potatoStationTexture=texture;
        gameData.lockedBakingStationTexture=texture;
        gameData.lockedFryingStationTexture=texture;
        gameData.lockedCuttingStationTexture=texture;
        gameData.errorTexture=texture;
        String[] initial_layout=
                {"c.3.r.sD...1",
                        "..lC.....2..",
                        "........b...",
                        "F..oW....d..",
                        ".B....Sg....",
                        "f...th..p..m"};
        Level level = new Level("levels/Level 3",initial_layout);
        gameData.level = level;
        FryingStation fryingStation = new FryingStation(texture);
        FryingStation lockedFryingStation = new FryingStation(texture);
        lockedFryingStation.available=0;
        BakingStation bakingStation = new BakingStation(texture);
        BakingStation lockedBakingStation = new BakingStation(texture);
        lockedBakingStation.available=0;
        CounterTop counterTop = new CounterTop(texture);
        CuttingStation cuttingStation = new CuttingStation(texture);
        CuttingStation lockedCuttingStation = new CuttingStation(texture);
        lockedCuttingStation.available=0;
        ErrorStation errorStation = new ErrorStation();
        IngredientStation ingredientStation1= new IngredientStation(4,0,new IngredientType("tomato"));
        IngredientStation ingredientStation2= new IngredientStation(4,0,new IngredientType("meat"));
        IngredientStation ingredientStation3= new IngredientStation(4,0,new IngredientType("lettuce"));
        IngredientStation ingredientStation4= new IngredientStation(4,0,new IngredientType("onion"));
        IngredientStation ingredientStation5= new IngredientStation(4,0,new IngredientType("bread"));
        IngredientStation ingredientStation6= new IngredientStation(4,0,new IngredientType("cheese"));
        IngredientStation ingredientStation7= new IngredientStation(4,0,new IngredientType("sauce"));
        IngredientStation ingredientStation8= new IngredientStation(4,0,new IngredientType("dough"));
        IngredientStation ingredientStation9= new IngredientStation(4,0,new IngredientType("potato"));
        IngredientStation ingredientStation10= new IngredientStation(4,0,new IngredientType("dish"));
        Obstacle obstacle = new Obstacle();
        ServingStation servingStation = new ServingStation(texture);
        Bin bin = new Bin();
        assertTrue(level.getStation(0,2).isEqual(fryingStation));
        assertTrue(level.getStation(1,1).isEqual(fryingStation));
        assertTrue(level.getStation(2,5).isEqual(counterTop));
        assertTrue(level.getStation(3,4).isEqual(cuttingStation));
        assertTrue(level.getStation(4,0).isEqual(ingredientStation1));
        assertFalse(level.getStation(4,0).isEqual(ingredientStation2));
        assertTrue(level.getStation(4,2).isEqual(obstacle));
        assertTrue(level.getStation(6,5).isEqual(servingStation));
        assertTrue(level.getStation(7,1).isEqual(bin));
        assertTrue(level.getStation(2,4).isEqual(ingredientStation3));
        assertTrue(level.getStation(8,3).isEqual(lockedBakingStation));
        assertTrue(level.getStation(3,2).isEqual(ingredientStation4));
        assertTrue(level.getStation(4,5).isEqual(ingredientStation5));
        assertTrue(level.getStation(5,0).isEqual(ingredientStation6));
        assertTrue(level.getStation(6,1).isEqual(ingredientStation7));
        assertTrue(level.getStation(7,5).isEqual(ingredientStation8));
        assertTrue(level.getStation(8,0).isEqual(ingredientStation9));
        assertTrue(level.getStation(9,2).isEqual(ingredientStation10));
        assertTrue(level.getStation(9,4).isEqual(counterTop));
        assertTrue(level.getStation(11,0).isEqual(ingredientStation2));
        assertFalse(level.getStation(11,0).isEqual(ingredientStation1));

        assertTrue(level.getStation(11,5).isEqual(counterTop));
        assertTrue(level.getStation(0,5).isEqual(lockedCuttingStation));
       
        assertNull(level.getStation(12,6));
        assertNull(level.getStation(12,5));
        assertNull(level.getStation(5,6));
        assertNull(level.getStation(-1,-4));
        assertNull(level.getStation(2,-4));
        assertNull(level.getStation(-1,4));
        assertNull(level.getStation(14,-4));

    }














}
