package group24.piazzapanic.tests;

import com.badlogic.gdx.graphics.Texture;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class DishTests {

    @Test
    public void TestAddIngredient(){

        GameData gameData = Mockito.mock(GameData.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        IngredientType ingredientType1 = new IngredientType("lettuce");
        Ingredient ingredientLettuce = new Ingredient(ingredientType1,0,-1,-1);
        IngredientType ingredientType2 = new IngredientType("tomato");
        Ingredient ingredientTomato= new Ingredient(ingredientType2,0,-1,-1);
        IngredientType ingredientType3 = new IngredientType("onion");
        Ingredient ingredientOnion= new Ingredient(ingredientType3,0,-1,-1);
        IngredientType ingredientType4 = new IngredientType("meat");
        Ingredient ingredientBurger = new Ingredient(ingredientType4,0,-1,0);
        IngredientType ingredientType5 = new IngredientType("bread");
        Ingredient ingredientBread = new Ingredient(ingredientType5,0,0,-1);

        Dish dish = new Dish();
        ingredientLettuce.cut();
        ingredientOnion.cut();
        ingredientTomato.cut();
        ingredientBread.cut();
        ingredientBurger.cut();
        ingredientBurger.fry();
        dish.SALAD_RECIPE.set(0,ingredientOnion);
        dish.SALAD_RECIPE.set(1,ingredientLettuce);
        dish.SALAD_RECIPE.set(2,ingredientTomato);
        dish.BURGER_RECIPE.set(0,ingredientBread);
        dish.BURGER_RECIPE.set(1,ingredientBurger);
        dish.BURGER_RECIPE.set(2,ingredientLettuce);

        assertTrue(dish.addIngredient(ingredientLettuce));
        assertTrue(dish.addIngredient(ingredientTomato));
        assertFalse(dish.addIngredient(ingredientBurger));
        assertFalse(dish.addIngredient(ingredientBread));
        assertTrue(dish.addIngredient(ingredientOnion));

        Dish dish2 = new Dish();
        dish2.SALAD_RECIPE.set(0,ingredientOnion);
        dish2.SALAD_RECIPE.set(1,ingredientLettuce);
        dish2.SALAD_RECIPE.set(2,ingredientTomato);
        dish2.BURGER_RECIPE.set(0,ingredientBread);
        dish2.BURGER_RECIPE.set(1,ingredientBurger);
        dish2.BURGER_RECIPE.set(2,ingredientLettuce);

        assertTrue(dish2.addIngredient(ingredientLettuce));
        assertTrue(dish2.addIngredient(ingredientBurger));
        assertFalse(dish2.addIngredient(ingredientTomato));
        assertFalse(dish2.addIngredient(ingredientOnion));
        assertTrue(dish2.addIngredient(ingredientBread));
    }

    @Test
    public void TestIsComplete(){

        GameData gameData = Mockito.mock(GameData.class);
        Texture texture = Mockito.mock(Texture.class);
        gameData.errorTexture = texture;
        gameData.dishTexture = texture;
        IngredientType ingredientType1 = new IngredientType("lettuce");
        Ingredient ingredientLettuce = new Ingredient(ingredientType1,0,-1,-1);
        IngredientType ingredientType2 = new IngredientType("tomato");
        Ingredient ingredientTomato= new Ingredient(ingredientType2,0,-1,-1);
        IngredientType ingredientType3 = new IngredientType("onion");
        Ingredient ingredientOnion= new Ingredient(ingredientType3,0,-1,-1);
        IngredientType ingredientType4 = new IngredientType("meat");
        Ingredient ingredientBurger = new Ingredient(ingredientType4,0,-1,0);
        IngredientType ingredientType5 = new IngredientType("bread");
        Ingredient ingredientBread = new Ingredient(ingredientType5,0,0,-1);



        Dish dish1 = new Dish();
        dish1.Ingredients = new ArrayList<Ingredient>();
        dish1.SALAD_RECIPE.set(0,ingredientOnion);
        dish1.SALAD_RECIPE.set(1,ingredientLettuce);
        dish1.SALAD_RECIPE.set(2,ingredientTomato);

        dish1.addIngredient(ingredientLettuce);
        dish1.addIngredient(ingredientOnion);
        dish1.addIngredient(ingredientTomato);

        assertTrue(dish1.isComplete());

        Dish dish2 = new Dish();
        dish2.Ingredients = new ArrayList<Ingredient>();
        dish2.BURGER_RECIPE.set(0,ingredientBread);
        dish2.BURGER_RECIPE.set(1,ingredientBurger);
        dish2.BURGER_RECIPE.set(2,ingredientLettuce);

        dish2.addIngredient(ingredientBread);
        dish2.addIngredient(ingredientBurger);
        assertFalse(dish2.isComplete());
        dish2.addIngredient(ingredientLettuce);
        assertTrue(dish2.isComplete());
    }











}
