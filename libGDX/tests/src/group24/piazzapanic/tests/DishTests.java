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

import static org.junit.Assert.*;

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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);


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
        dish2.addIngredient(ingredientBread);
        assertFalse(dish2.addIngredient(ingredientBread));






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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

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

        Dish dish3 = new Dish();
        dish3.Ingredients = new ArrayList<Ingredient>();
        dish3.PIZZA_RECIPE.set(0,ingredientDough);
        dish3.PIZZA_RECIPE.set(1,ingredientSauce);
        dish3.PIZZA_RECIPE.set(2,ingredientCheese);

        dish3.addIngredient(ingredientCheese);
        dish3.addIngredient(ingredientDough);
        assertFalse(dish3.isComplete());
        dish3.addIngredient(ingredientSauce);
        assertTrue(dish3.isComplete());

        Dish dish4 = new Dish();
        dish4.Ingredients = new ArrayList<Ingredient>();
        dish4.JACKET_POTATO_RECIPE.set(0,ingredientPotato);
        dish4.JACKET_POTATO_RECIPE.set(1,ingredientCheese);


        dish4.addIngredient(ingredientCheese);

        assertFalse(dish4.isComplete());
        dish4.addIngredient(ingredientPotato);
        assertTrue(dish4.isComplete());




    }

    @Test
    public void TestIsEquals(){
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);



        ArrayList<Ingredient> currentIngredients1 = new ArrayList<Ingredient>();
        currentIngredients1.add(ingredientCheese);
        currentIngredients1.add(ingredientSauce);
        currentIngredients1.add(ingredientDough);

        ArrayList<Ingredient> currentIngredients2 = new ArrayList<Ingredient>();
        currentIngredients2.add(ingredientPotato);
        currentIngredients2.add(ingredientCheese);

        ArrayList<Ingredient> currentIngredients3 = new ArrayList<Ingredient>();
        currentIngredients3.add(ingredientLettuce);
        currentIngredients3.add(ingredientBread);
        currentIngredients3.add(ingredientBurger);




        Dish dish1 = new Dish(currentIngredients1);
        dish1.complete = true;

        Dish dish2 = new Dish(currentIngredients1);
        dish2.complete = true;
        assertTrue(dish1.equals(dish2));
        Dish dish3 = new Dish(currentIngredients2);
        dish3.complete = true;
        assertFalse(dish2.equals(dish3));
        Dish dish4 = new Dish(currentIngredients1);
        dish4.complete=false;
        assertFalse(dish1.equals(dish4));
        Dish dish5 = new Dish(currentIngredients3);
        dish2.complete = false;
        assertFalse(dish3.equals(dish5));

        assertFalse(dish1.equals(ingredientCheese));

    }

    @Test
    public void TestGetRecipe(){
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);



        ArrayList<Ingredient> currentIngredients1 = new ArrayList<Ingredient>();
        currentIngredients1.add(ingredientCheese);
        currentIngredients1.add(ingredientSauce);





        Dish dish1 = Dish.BURGER;
        Dish dish2 = Dish.SALAD;
        Dish dish3 = Dish.PIZZA;
        Dish dish4 = Dish.JACKET_POTATO;
        Dish dish5 = new Dish(currentIngredients1);

        assertEquals("Burger",dish1.getRecipe());
        assertEquals("Salad",dish2.getRecipe());
        assertEquals("Pizza",dish3.getRecipe());
        assertEquals("Jacket Potato",dish4.getRecipe());



        assertEquals("Error",dish5.getRecipe());

    }

    @Test
    public void TestCheckComplete(){
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        Dish dish1 = new Dish();
        dish1.Ingredients = new ArrayList<Ingredient>();
        dish1.SALAD_RECIPE.set(0,ingredientOnion);
        dish1.SALAD_RECIPE.set(1,ingredientLettuce);
        dish1.SALAD_RECIPE.set(2,ingredientTomato);

        dish1.Ingredients.add(ingredientLettuce);
        dish1.Ingredients.add(ingredientOnion);
        dish1.Ingredients.add(ingredientTomato);
        dish1.recipe = new ArrayList<Ingredient>();
        dish1.recipe.add(ingredientLettuce);
        dish1.recipe.add(ingredientOnion);
        dish1.recipe.add(ingredientTomato);
        assertTrue(dish1.checkComplete());
        assertTrue(dish1.Ingredients.size()==0);

        Dish dish2 = new Dish();
        dish2.Ingredients = new ArrayList<Ingredient>();
        dish2.BURGER_RECIPE.set(0,ingredientBread);
        dish2.BURGER_RECIPE.set(1,ingredientBurger);
        dish2.BURGER_RECIPE.set(2,ingredientLettuce);

        dish2.Ingredients.add(ingredientBread);
        dish2.Ingredients.add(ingredientBurger);
        dish2.Ingredients.add(ingredientLettuce);
        dish2.recipe = new ArrayList<Ingredient>();
        assertFalse(dish2.checkComplete());
        dish2.recipe.add(ingredientLettuce);
        dish2.recipe.add(ingredientBread);
        dish2.recipe.add(ingredientBurger);
        assertTrue(dish2.checkComplete());
        assertTrue(dish2.Ingredients.size()==0);

        Dish dish3 = new Dish();
        dish3.Ingredients = new ArrayList<Ingredient>();
        dish3.PIZZA_RECIPE.set(0,ingredientDough);
        dish3.PIZZA_RECIPE.set(1,ingredientSauce);
        dish3.PIZZA_RECIPE.set(2,ingredientCheese);

        dish3.recipe = new ArrayList<Ingredient>();
        dish3.recipe.add(ingredientDough);
        dish3.recipe.add(ingredientSauce);
        dish3.recipe.add(ingredientCheese);
        assertFalse(dish3.checkComplete());
        dish3.Ingredients.add(ingredientDough);
        dish3.Ingredients.add(ingredientSauce);
        dish3.Ingredients.add(ingredientCheese);



        assertTrue(dish3.checkComplete());
        assertTrue(dish3.Ingredients.size()==0);

        Dish dish4 = new Dish();
        dish4.Ingredients = new ArrayList<Ingredient>();
        dish4.JACKET_POTATO_RECIPE.set(0,ingredientPotato);
        dish4.JACKET_POTATO_RECIPE.set(1,ingredientCheese);


        dish4.Ingredients.add(ingredientPotato);
        dish4.Ingredients.add(ingredientCheese);

        dish4.recipe = new ArrayList<Ingredient>();
        dish4.recipe.add(ingredientCheese);
        dish4.recipe.add(ingredientPotato);
        assertTrue(dish4.checkComplete());
        assertTrue(dish4.Ingredients.size()==0);



    }


    @Test
    public void TestSetRecipeBurger(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;


        ArrayList<Ingredient> currentIngredientsB = new ArrayList<Ingredient>();
        currentIngredientsB.add(gameData1.CHOPPED_LETTUCE);
        currentIngredientsB.add(gameData1.BURGER_BUN);
        currentIngredientsB.add(gameData1.BURGER);



        Dish dish8 = new Dish();
        assertTrue(dish8.setRecipe(currentIngredientsB));
        dish8.setRecipe(currentIngredientsB);
        assertEquals(dish8.BURGER_RECIPE,dish8.recipe);


    }

    @Test
    public void TestSetRecipeSalad(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;



        ArrayList<Ingredient> currentIngredientsS = new ArrayList<Ingredient>();
        currentIngredientsS.add(gameData1.CHOPPED_LETTUCE);
        currentIngredientsS.add(gameData1.CHOPPED_TOMATO);
        currentIngredientsS.add(gameData1.CHOPPED_ONION);


        Dish dish9 = new Dish();
        assertTrue(dish9.setRecipe(currentIngredientsS));
        dish9.setRecipe(currentIngredientsS);
        assertEquals(dish9.SALAD_RECIPE,dish9.recipe);

    }

    @Test
    public void TestSetRecipePizza(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;



        ArrayList<Ingredient> currentIngredientsP = new ArrayList<Ingredient>();
        currentIngredientsP.add(gameData1.PIZZA_SAUCE);
        currentIngredientsP.add(gameData1.CHEESE);
        currentIngredientsP.add(gameData1.BAKED_DOUGH);

        Dish dish10 = new Dish();
        assertTrue(dish10.setRecipe(currentIngredientsP));
        dish10.setRecipe(currentIngredientsP);
        assertEquals(dish10.PIZZA_RECIPE,dish10.recipe);




    }

    @Test
    public void TestSetRecipeJacket(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;


        ArrayList<Ingredient> currentIngredientsJ = new ArrayList<Ingredient>();
        currentIngredientsJ.add(gameData1.BAKED_POTATO);
        currentIngredientsJ.add(gameData1.CHEESE);

        Dish dish11 = new Dish();
        assertTrue(dish11.setRecipe(currentIngredientsJ));
        dish11.setRecipe(currentIngredientsJ);
        assertEquals(dish11.JACKET_POTATO_RECIPE,dish11.recipe);


    }

    @Test
    public void TestSetRecipeCheese(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;



        ArrayList<Ingredient> currentIngredientsPJ = new ArrayList<Ingredient>();
        currentIngredientsPJ.add(gameData1.CHEESE);

        Dish dish14 = new Dish();
        dish14.recipe=null;
        assertTrue(dish14.setRecipe(currentIngredientsPJ));
        dish14.setRecipe(currentIngredientsPJ);
        assertEquals(null,dish14.recipe);


    }


    @Test
    public void TestSetRecipeError(){
        GameData gameData1 = Mockito.mock(GameData.class);
        Texture texture11 = Mockito.mock(Texture.class);
        gameData1.errorTexture = texture11;
        gameData1.dishTexture = texture11;
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
        IngredientType ingredientType6 = new IngredientType("dough");
        Ingredient ingredientDough = new Ingredient(ingredientType6,-1,0,-1);
        IngredientType ingredientType7 = new IngredientType("cheese");
        Ingredient ingredientCheese = new Ingredient(ingredientType7,-1,-1,-1);
        IngredientType ingredientType8 = new IngredientType("sauce");
        Ingredient ingredientSauce = new Ingredient(ingredientType8,-1,-1,-1);
        IngredientType ingredientType9 = new IngredientType("potato");
        Ingredient ingredientPotato = new Ingredient(ingredientType9,-1,0,-1);

        gameData1.BURGER_BUN=ingredientBread;
        gameData1.BURGER=ingredientBurger;
        gameData1.CHOPPED_LETTUCE=ingredientLettuce;
        gameData1.CHOPPED_ONION=ingredientOnion;
        gameData1.CHOPPED_TOMATO=ingredientTomato;
        gameData1.BAKED_DOUGH=ingredientDough;
        gameData1.PIZZA_SAUCE=ingredientSauce;
        gameData1.CHEESE = ingredientCheese;
        gameData1.BAKED_POTATO=ingredientPotato;



        ArrayList<Ingredient> currentIngredientsErr = new ArrayList<Ingredient>();
        currentIngredientsErr.add(gameData1.PIZZA_SAUCE);
        currentIngredientsErr.add(gameData1.CHEESE);
        currentIngredientsErr.add(gameData1.BAKED_POTATO);


        Dish dish12 = new Dish();
        assertFalse(dish12.setRecipe(currentIngredientsErr));

    }















}
