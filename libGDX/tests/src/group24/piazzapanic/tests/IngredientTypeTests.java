package group24.piazzapanic.tests;

import group24.piazzapanic.game.Player;
import group24.piazzapanic.levelElements.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class IngredientTypeTests {
    @Test
    public void TestGetName(){
        String name = "cheese";
        IngredientType ingredientType = new IngredientType(name);
        assertEquals(name,ingredientType.getName());
        assertNotNull(ingredientType.getName());
    }
    @Test
    public void equals() {

        IngredientType ingredientType1 = new IngredientType("lettuce");
        IngredientType ingredientType2 = new IngredientType("lettuce");
        IngredientType ingredientType3 = new IngredientType("tomato");
        String lettuce = "lettuce";
        String tomato = "tomato";
        Player player = new Player(0,0,null);

        assertTrue(ingredientType1.equals(ingredientType2));
        assertTrue(ingredientType1.equals(lettuce));
        assertFalse(ingredientType1.equals(ingredientType3));
        assertFalse(ingredientType1.equals(tomato));
        assertFalse(ingredientType3.equals(player));

    }










}
