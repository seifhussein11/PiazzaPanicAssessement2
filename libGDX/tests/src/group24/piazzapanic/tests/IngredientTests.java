package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.maths.Vector2;
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

        Texture texture7 = Mockito.mock(Texture.class);
        Texture texture8 = Mockito.mock(Texture.class);
        Texture texture9 = Mockito.mock(Texture.class);
        Texture texture10 = Mockito.mock(Texture.class);

        IngredientType doughType = new IngredientType("dough");
        IngredientType cheeseType = new IngredientType("cheese");
        IngredientType sauceType = new IngredientType("sauce");
        IngredientType potatoType = new IngredientType("potato");
        gameData.rawDoughTexture = texture7;
        gameData.rawCheeseTexture = texture8;
        gameData.rawSauceTexture = texture9;
        gameData.rawPotatoTexture = texture10;
        Ingredient dough = new Ingredient(doughType,-1,0,-1);
        dough.cut();
        assertEquals(1,dough.getCuttingProgress(),0.000001);
        assertEquals(texture7,dough.texture);
        assertNotEquals(texture6,dough.texture);
        assertEquals(0,dough.getBakingProgress(),0.00001);
        Ingredient cheese = new Ingredient(cheeseType,-1,-1,-1);
        cheese.cut();
        assertEquals(1,cheese.getCuttingProgress(),0.000001);
        assertEquals(texture8,cheese.texture);
        assertNotEquals(texture7,cheese.texture);
        assertEquals(-1,cheese.getFryingProgress(),0.00001);
        Ingredient sauce = new Ingredient(sauceType,-1,-1,-1);
        sauce.cut();
        assertEquals(1,sauce.getCuttingProgress(),0.000001);
        assertEquals(texture9,sauce.texture);
        assertNotEquals(texture8,sauce.texture);
        assertEquals(-1,sauce.getFryingProgress(),0.00001);
        Ingredient potato = new Ingredient(potatoType,-1,0,-1);
        potato.cut();
        assertEquals(1,potato.getCuttingProgress(),0.000001);
        assertEquals(texture10,potato.texture);
        assertNotEquals(texture9,potato.texture);
        assertEquals(0,dough.getBakingProgress(),0.00001);






    }

    @Test
    public void TestIngredientFry(){

        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        gameData.cutTomatoTexture = texture2;
        gameData.errorTexture = texture1;
        IngredientType tomato = new IngredientType("tomato");
        Ingredient tomatoIngr = new Ingredient(tomato,0,-1,-1);
        tomatoIngr.fry();
        assertEquals(0,tomatoIngr.getFryingProgress(),0.000001);
        assertEquals(texture2,tomatoIngr.texture);

        IngredientType onion = new IngredientType("onion");
        Ingredient onionIngr = new Ingredient(onion,0,-1,-1);
        Texture texture3 = Mockito.mock(Texture.class);
        gameData.cutOnionTexture = texture3;
        onionIngr.fry();
        assertEquals(0,onionIngr.getFryingProgress(),0.000001);
        assertEquals(texture3,onionIngr.texture);

        IngredientType lettuce = new IngredientType("lettuce");
        Ingredient lettuceIngr = new Ingredient(lettuce,0,-1,-1);
        Texture texture4 = Mockito.mock(Texture.class);
        gameData.cutLettuceTexture = texture4;
        lettuceIngr.fry();
        assertEquals(0,lettuceIngr.getFryingProgress(),0.000001);
        assertEquals(texture4,lettuceIngr.texture);

        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,0,-1,-1);
        Texture texture5 = Mockito.mock(Texture.class);
        gameData.cutBreadTexture = texture5;
        breadIngr.fry();
        assertEquals(0,breadIngr.getFryingProgress(),0.000001);
        assertEquals(texture5,breadIngr.texture);

        IngredientType meat = new IngredientType("meat");
        Ingredient meatIngr1 = new Ingredient(meat,0,-1,0);
        Ingredient meatIngr2 = new Ingredient(meat,0,-1,1);
        Texture texture6 = Mockito.mock(Texture.class);
        Texture texture62 = Mockito.mock(Texture.class);
        gameData.halfFriedMeatTexture = texture6;
        gameData.friedMeatTexture = texture62;
        meatIngr1.fry();
        meatIngr2.fry();
        assertEquals(1,meatIngr1.getFryingProgress(),0.000001);
        assertEquals(-1,meatIngr1.getBakingProgress(),0.000001);
        assertEquals(gameData.halfFriedMeatTexture,meatIngr1.texture);
        assertEquals(2,meatIngr2.getFryingProgress(),0.000001);
        assertEquals(gameData.friedMeatTexture,meatIngr2.texture);
        assertEquals(-1,meatIngr2.getBakingProgress(),0.000001);


        Texture texture7 = Mockito.mock(Texture.class);
        Texture texture8 = Mockito.mock(Texture.class);
        Texture texture9 = Mockito.mock(Texture.class);
        Texture texture10 = Mockito.mock(Texture.class);

        IngredientType doughType = new IngredientType("dough");
        IngredientType cheeseType = new IngredientType("cheese");
        IngredientType sauceType = new IngredientType("sauce");
        IngredientType potatoType = new IngredientType("potato");
        gameData.rawDoughTexture = texture7;
        gameData.rawCheeseTexture = texture8;
        gameData.rawSauceTexture = texture9;
        gameData.rawPotatoTexture = texture10;
        Ingredient dough = new Ingredient(doughType,-1,0,-1);
        dough.fry();
        assertEquals(0,dough.getFryingProgress(),0.000001);
        assertEquals(texture7,dough.texture);
        assertNotEquals(texture6,dough.texture);
        assertEquals(0,dough.getBakingProgress(),0.00001);
        Ingredient cheese = new Ingredient(cheeseType,-1,-1,-1);
        cheese.fry();
        assertEquals(0,cheese.getFryingProgress(),0.000001);
        assertEquals(texture8,cheese.texture);
        assertNotEquals(texture7,cheese.texture);
        assertEquals(-1,cheese.getBakingProgress(),0.00001);
        Ingredient sauce = new Ingredient(sauceType,-1,-1,-1);
        sauce.fry();
        assertEquals(0,sauce.getFryingProgress(),0.000001);
        assertEquals(texture9,sauce.texture);
        assertNotEquals(texture8,sauce.texture);
        assertEquals(-1,sauce.getCuttingProgress(),0.00001);
        Ingredient potato = new Ingredient(potatoType,-1,0,-1);
        potato.fry();
        assertEquals(0,potato.getFryingProgress(),0.000001);
        assertEquals(texture10,potato.texture);
        assertNotEquals(texture9,potato.texture);
        assertEquals(0,dough.getBakingProgress(),0.00001);


    }

    @Test
    public void TestIngredientBake(){
        GameData gameData = Mockito.mock(GameData.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        gameData.cutTomatoTexture = texture2;
        gameData.errorTexture = texture1;
        IngredientType tomato = new IngredientType("tomato");
        Ingredient tomatoIngr = new Ingredient(tomato,0,-1,-1);
        tomatoIngr.bake();
        assertEquals(1,tomatoIngr.getBakingProgress(),0.000001);
        assertEquals(texture2,tomatoIngr.texture);

        IngredientType onion = new IngredientType("onion");
        Ingredient onionIngr = new Ingredient(onion,0,-1,-1);
        Texture texture3 = Mockito.mock(Texture.class);
        gameData.cutOnionTexture = texture3;
        onionIngr.bake();
        assertEquals(1,onionIngr.getBakingProgress(),0.000001);
        assertEquals(texture3,onionIngr.texture);

        IngredientType lettuce = new IngredientType("lettuce");
        Ingredient lettuceIngr = new Ingredient(lettuce,0,-1,-1);
        Texture texture4 = Mockito.mock(Texture.class);
        gameData.cutLettuceTexture = texture4;
        lettuceIngr.bake();
        assertEquals(1,lettuceIngr.getBakingProgress(),0.000001);
        assertEquals(texture4,lettuceIngr.texture);

        IngredientType bread = new IngredientType("bread");
        Ingredient breadIngr = new Ingredient(bread,0,-1,-1);
        Texture texture5 = Mockito.mock(Texture.class);
        gameData.cutBreadTexture = texture5;
        breadIngr.bake();
        assertEquals(1,breadIngr.getBakingProgress(),0.000001);
        assertEquals(texture5,breadIngr.texture);

        IngredientType meat = new IngredientType("meat");
        Ingredient meatIngr = new Ingredient(meat,0,-1,-1);
        Texture texture6 = Mockito.mock(Texture.class);
        gameData.friedMeatTexture = texture6;
        meatIngr.bake();
        assertEquals(1,meatIngr.getBakingProgress(),0.000001);
        assertEquals(texture6,meatIngr.texture);


        Texture texture7 = Mockito.mock(Texture.class);
        Texture texture8 = Mockito.mock(Texture.class);
        Texture texture9 = Mockito.mock(Texture.class);
        Texture texture10 = Mockito.mock(Texture.class);
        Texture texture11 = Mockito.mock(Texture.class);
        Texture texture12 = Mockito.mock(Texture.class);
        Texture texture13 = Mockito.mock(Texture.class);


        IngredientType doughType = new IngredientType("dough");
        IngredientType cheeseType = new IngredientType("cheese");
        IngredientType sauceType = new IngredientType("sauce");
        IngredientType potatoType = new IngredientType("potato");
        gameData.rawDoughTexture = texture11;
        gameData.bakedDoughTexture = texture7;
        gameData.rawCheeseTexture = texture8;
        gameData.rawSauceTexture = texture9;
        gameData.rawPotatoTexture = texture10;
        gameData.bakedPotatoTexture = texture12;
        Ingredient dough = new Ingredient(doughType,-1,0,-1);
        dough.bake();
        assertEquals(1,dough.getBakingProgress(),0.000001);
        assertEquals(texture7,dough.texture);
        assertNotEquals(texture11,dough.texture);
        assertEquals(-1,dough.getFryingProgress(),0.00001);
        Ingredient cheese = new Ingredient(cheeseType,-1,-1,-1);
        cheese.bake();
        assertEquals(1,cheese.getBakingProgress(),0.000001);
        assertEquals(texture8,cheese.texture);
        assertNotEquals(texture7,cheese.texture);
        assertEquals(-1,cheese.getFryingProgress(),0.00001);
        Ingredient sauce = new Ingredient(sauceType,-1,-1,-1);
        sauce.bake();
        assertEquals(1,sauce.getBakingProgress(),0.000001);
        assertEquals(texture9,sauce.texture);
        assertNotEquals(texture8,sauce.texture);
        assertEquals(-1,sauce.getFryingProgress(),0.00001);
        Ingredient potato = new Ingredient(potatoType,-1,0,-1);
        potato.bake();
        assertEquals(1,potato.getBakingProgress(),0.000001);
        assertEquals(texture12,potato.texture);
        assertNotEquals(texture10,potato.texture);
        assertEquals(-1,dough.getFryingProgress(),0.00001);





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

    @Test
    public void TestIngredientConstructer(){
        Texture texture = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.errorTexture = texture;
        gameData.rawTomatoTexture = texture;
        gameData.rawLettuceTexture = texture;
        gameData.rawOnionTexture = texture;
        gameData.rawBreadTexture = texture;
        gameData.rawMeatTexture = texture;
        gameData.rawDoughTexture = texture;
        gameData.rawCheeseTexture = texture;
        gameData.rawSauceTexture = texture;
        gameData.rawPotatoTexture = texture;
        IngredientType tomatoType = new IngredientType("tomato");
        IngredientType lettuceType = new IngredientType("lettuce");
        IngredientType onionType = new IngredientType("onion");
        IngredientType breadType = new IngredientType("bread");
        IngredientType meatType = new IngredientType("meat");
        IngredientType doughType = new IngredientType("dough");
        IngredientType cheeseType = new IngredientType("cheese");
        IngredientType sauceType = new IngredientType("sauce");
        IngredientType potatoType = new IngredientType("potato");
        Vector2 vector2 = Mockito.mock(Vector2.class);

        Ingredient tomato = new Ingredient(tomatoType,vector2);
        assertEquals(0,tomato.getCuttingProgress(),0.00001);
        assertEquals(-1,tomato.getFryingProgress(),0.00001);
        assertEquals(-1,tomato.getBakingProgress(),0.00001);
        assertEquals(texture,tomato.texture);

        Ingredient lettuce = new Ingredient(lettuceType,vector2);
        assertEquals(0,lettuce.getCuttingProgress(),0.00001);
        assertEquals(-1,lettuce.getFryingProgress(),0.00001);
        assertEquals(-1,lettuce.getBakingProgress(),0.00001);
        assertEquals(texture,lettuce.texture);

        Ingredient onion = new Ingredient(onionType,vector2);
        assertEquals(0,onion.getCuttingProgress(),0.00001);
        assertEquals(-1,onion.getFryingProgress(),0.00001);
        assertEquals(-1,onion.getBakingProgress(),0.00001);
        assertEquals(texture,onion.texture);

        Ingredient bread = new Ingredient(breadType,vector2);
        assertEquals(0,bread.getCuttingProgress(),0.00001);
        assertEquals(-1,bread.getFryingProgress(),0.00001);
        assertEquals(-1,bread.getBakingProgress(),0.00001);
        assertEquals(texture,bread.texture);

        Ingredient meat = new Ingredient(meatType,vector2);
        assertEquals(0,meat.getCuttingProgress(),0.00001);
        assertEquals(-1,meat.getFryingProgress(),0.00001);
        assertEquals(-1,meat.getBakingProgress(),0.00001);
        assertEquals(texture,meat.texture);

        Ingredient dough = new Ingredient(doughType,vector2);
        assertEquals(-1,dough.getCuttingProgress(),0.00001);
        assertEquals(-1,dough.getFryingProgress(),0.00001);
        assertEquals(0,dough.getBakingProgress(),0.00001);
        assertEquals(texture,dough.texture);

        Ingredient cheese = new Ingredient(cheeseType,vector2);
        assertEquals(-1,cheese.getCuttingProgress(),0.00001);
        assertEquals(-1,cheese.getFryingProgress(),0.00001);
        assertEquals(-1,cheese.getBakingProgress(),0.00001);
        assertEquals(texture,cheese.texture);

        Ingredient sauce = new Ingredient(sauceType,vector2);
        assertEquals(-1,sauce.getCuttingProgress(),0.00001);
        assertEquals(-1,sauce.getFryingProgress(),0.00001);
        assertEquals(-1,sauce.getBakingProgress(),0.00001);
        assertEquals(texture,sauce.texture);

        Ingredient potato = new Ingredient(potatoType,vector2);
        assertEquals(-1,potato.getCuttingProgress(),0.00001);
        assertEquals(-1,potato.getFryingProgress(),0.00001);
        assertEquals(0,potato.getBakingProgress(),0.00001);
        assertEquals(texture,potato.texture);

    }

    @Test
    public void TestIngredientBurn(){
        Texture texture = Mockito.mock(Texture.class);
        Texture texture1 = Mockito.mock(Texture.class);
        Texture texture2 = Mockito.mock(Texture.class);
        Texture texture3 = Mockito.mock(Texture.class);
        Texture texture4 = Mockito.mock(Texture.class);
        Texture texture5 = Mockito.mock(Texture.class);
        GameData gameData = Mockito.mock(GameData.class);
        gameData.rawMeatTexture = texture1;
        gameData.halfFriedMeatTexture = texture2;
        gameData.friedMeatTexture = texture3;
        gameData.burntMeatTexture = texture4;
        gameData.errorTexture = texture;
        gameData.rawTomatoTexture=texture5;

        IngredientType meatType = new IngredientType("meat");
        Ingredient meatIngr = new Ingredient(meatType,0,-1,0);
        meatIngr.burn();
        assertEquals(3,meatIngr.getFryingProgress(),0.00001);
        assertEquals(gameData.burntMeatTexture,meatIngr.texture);
        assertNotEquals(gameData.friedMeatTexture,meatIngr.texture);
        assertNotEquals(gameData.halfFriedMeatTexture,meatIngr.texture);
        assertNotEquals(gameData.rawMeatTexture,meatIngr.texture);

        IngredientType tomatoType = new IngredientType("tomato");
        Ingredient tomatoIngr = new Ingredient(tomatoType,0,-1,-1);
        tomatoIngr.texture=texture5;
        tomatoIngr.burn();
        assertEquals(-1,tomatoIngr.getFryingProgress(),0.00001);
        assertEquals(gameData.rawTomatoTexture,tomatoIngr.texture);

    }








}
