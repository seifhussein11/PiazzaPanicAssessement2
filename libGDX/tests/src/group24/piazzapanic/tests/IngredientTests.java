package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class IngredientTests {

    @Test
    public void TestIngredientCut(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        gameData.cutTomatoTexture = texture2;
        gameData.errorTexture = texture1;
        IngredientType tomato = new IngredientType("tomato");
        Ingredient tomatoIngr = new Ingredient(tomato,0,-1,-1);
        tomatoIngr.cut();
        assertEquals(1,tomatoIngr.getCuttingProgress(),0.000001);
        assertEquals(texture2,tomatoIngr.texture);

        IngredientType onion = new IngredientType("onion");
        Ingredient onionIngr = new Ingredient(onion,0,-1,-1);
        Texture texture3 = Mockito.mock(Texture.class);
        gameData.cutOnionTexture = texture3;
        onionIngr.cut();
        assertEquals(1,onionIngr.getCuttingProgress(),0.000001);
        assertEquals(texture3,onionIngr.texture);

        IngredientType lettuce = new IngredientType("lettuce");
        Ingredient lettuceIngr = new Ingredient(lettuce,0,-1,-1);
        Texture texture4 = Mockito.mock(Texture.class);
        gameData.cutLettuceTexture = texture4;
        lettuceIngr.cut();
        assertEquals(1,lettuceIngr.getCuttingProgress(),0.000001);
        assertEquals(texture4,lettuceIngr.texture);

        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,0,-1,-1);
        Texture texture5 = Mockito.mock(Texture.class);
        gameData.cutBreadTexture = texture5;
        breadIngr.cut();
        assertEquals(1,breadIngr.getCuttingProgress(),0.000001);
        assertEquals(texture5,breadIngr.texture);

        IngredientType meat = new IngredientType("meat");
        Ingredient meatIngr = new Ingredient(meat,0,-1,-1);
        Texture texture6 = Mockito.mock(Texture.class);
        gameData.cutMeatTexture = texture6;
        meatIngr.cut();
        assertEquals(1,meatIngr.getCuttingProgress(),0.000001);
        assertEquals(texture6,meatIngr.texture);
        assertEquals(0,meatIngr.getFryingProgress(),0.000001);
    }

    @Test
    public void TestIngredientMeatFry(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;


        IngredientType meat = new IngredientType("meat");
        Ingredient meatIngr = new Ingredient(meat,-1,-1,0);
        Texture texture2 = Mockito.mock(Texture.class);
        gameData.halfFriedMeatTexture = texture2;
        meatIngr.fry();
        assertEquals(1,meatIngr.getFryingProgress(),0.000001);
        assertEquals(texture2,meatIngr.texture);

    }

    @Test
    public void TestIngredientBake(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;


        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,-1,0,-1);
        Texture texture2 = Mockito.mock(Texture.class);

        breadIngr.bake();
        assertEquals(1,breadIngr.getBakingProgress(),0.000001);

    }

    @Test
    public void TestIngredientGetCuttingProgress(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;


        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,1,-1,-1);
        assertEquals(1,breadIngr.getCuttingProgress(),0.000001);
    }

    @Test
    public void TestIngredientGetFryingProgress(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;


        IngredientType meat = new IngredientType("meat");
        Ingredient meatIngr = new Ingredient(meat,-1,-1,1);
        assertEquals(1,meatIngr.getFryingProgress(),0.000001);
    }

    @Test
    public void TestIngredientGetBakingProgress(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;

        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,-1,1,-1);
        assertEquals(1,breadIngr.getBakingProgress(),0.000001);
    }

    @Test
    public void TestIngredientIdenticalTo(){

        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;

        IngredientType bread1 = new IngredientType("bread");
        Ingredient bread1Ingr = new Ingredient(bread1,-1,1,-1);

        IngredientType bread2 = new IngredientType("bread");
        Ingredient bread2Ingr = new Ingredient(bread2,-1,1,-1);
        assertTrue(bread1Ingr.identicalTo(bread2Ingr));

        IngredientType bread3 = new IngredientType("bread");
        Ingredient bread3Ingr = new Ingredient(bread2,0,1,-1);
        assertFalse(bread1Ingr.identicalTo(bread3Ingr));

        IngredientType tomato1 = new IngredientType("tomato");
        Ingredient tomato1Ingr = new Ingredient(tomato1,0,1,-1);
        assertFalse(tomato1Ingr.identicalTo(bread3Ingr));
        assertFalse(tomato1Ingr.identicalTo(bread2Ingr));

    }

    @Test
    public void TestIngredientEquals(){

        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);

        gameData.errorTexture = texture1;

        IngredientType bread1 = new IngredientType("bread");
        Ingredient bread1Ingr = new Ingredient(bread1,-1,1,-1);

        IngredientType bread2 = new IngredientType("bread");
        Ingredient bread2Ingr = new Ingredient(bread2,-1,1,-1);

        assertTrue(bread1Ingr.equals(bread2Ingr));

        IngredientType tomato1 = new IngredientType("tomato");
        Ingredient tomato1Ingr = new Ingredient(tomato1,0,1,-1);

        assertFalse(tomato1Ingr.equals(bread2Ingr));

        gameData.dishTexture = texture1;
        Dish dish = new Dish();
        assertFalse(tomato1Ingr.equals(bread2Ingr));









    }








}
