package group24.piazzapanic.levelElements;

import group24.piazzapanic.Base;
import group24.piazzapanic.Physics.ImageMovable;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.levelElements.stations.Station;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Dishes are used to serve Ingredients.
 * They interact with {@link Ingredient}'s {@link Ingredient#fry()}  and {@link Ingredient#getFryingProgress()} methods.
 * This class extends {@link Station}.
 * Recipes are stored as an ArrayList of Ingredients.
 */
public class Dish extends ImageMovable {
    /** The burger recipe. */
    public static final ArrayList<Ingredient> BURGER_RECIPE = new ArrayList<Ingredient>(
            Arrays.asList(GameData.BURGER_BUN, GameData.BURGER, GameData.CHOPPED_LETTUCE));
    /** The Salad recipe. */
    public static final ArrayList<Ingredient> SALAD_RECIPE = new ArrayList<Ingredient>(
            Arrays.asList(GameData.CHOPPED_ONION, GameData.CHOPPED_LETTUCE, GameData.CHOPPED_TOMATO));
    /** The pizza recipe. */
    public static final ArrayList<Ingredient>  PIZZA_RECIPE = new ArrayList<Ingredient>(
            Arrays.asList(GameData.BAKED_DOUGH,GameData.PIZZA_SAUCE,GameData.CHEESE));
    /** The jacket potato recipe. */
    public static final ArrayList<Ingredient>  JACKET_POTATO_RECIPE = new ArrayList<Ingredient>(
            Arrays.asList(GameData.BAKED_POTATO,GameData.CHEESE));

    /** The list of all dishes. */
    public static Dish BURGER = new Dish(BURGER_RECIPE);
    public static Dish SALAD = new Dish(SALAD_RECIPE);
    public static Dish PIZZA = new Dish(PIZZA_RECIPE);
    public static Dish JACKET_POTATO = new Dish(JACKET_POTATO_RECIPE);
    public static ArrayList<Dish> Dishes = new ArrayList<>(
            Arrays.asList(BURGER, SALAD, PIZZA, JACKET_POTATO));
    public ArrayList<Ingredient> Ingredients = new ArrayList<>();
    /** Stores the dish's recipe. */
    private  ArrayList<Ingredient> recipe;
    /** Stores the dish's current progress towards completion. */
    private boolean complete;

    /**
     * Initialise the Dish. Set its texture, size, completeness, and recipe.
     */
    public Dish() {

        super(GameData.dishTexture);
        super.setWidth(Base.tile_pixel_width);
        super.setHeight(Base.tile_pixel_height);
        this.complete = false;
        this.recipe = new ArrayList<Ingredient>();
    }

    /**
     * Initialise the Dish. Set its texture, size, completeness, and recipe.
     * @param recipe The recipe for the dish, an ArrayList of {@link Ingredient}s.
     */
    public Dish(ArrayList<Ingredient> recipe) {
        super(GameData.dishTexture);
        super.setWidth(Base.tile_pixel_width);
        super.setHeight(Base.tile_pixel_height);
        this.complete = true;
        this.recipe = recipe;
        this.Ingredients = recipe;
    }

    /**
     * Adds an ingredient to the dish.
     * Will only add ingredients if the ingredient is part of a recipe.
     * @param item The {@link Ingredient} to add to the dish.
     * @return True if the ingredient was added, false otherwise.
     */
    public boolean addIngredient(Ingredient item) {
        if (recipe.size() == 0) {
            ArrayList<Ingredient> tmp = new ArrayList<Ingredient>(this.Ingredients);
            tmp.add(item);
            if (setRecipe(tmp)) { //checks if there is a recipe with this combination of ingredients
                this.Ingredients.add(item);
                this.complete = checkComplete();
                System.out.println("added to dish\ncurrent:");
                for (Ingredient i : Ingredients) {
                    System.out.println(i.ingredientType.getName());
                }
                System.out.println("recipe:");
                for (Ingredient i : recipe) {
                    System.out.println(i.ingredientType.getName());
                }
                System.out.println(this.Ingredients.size());
                return true;
            }
        } else if (this.recipe.contains(item) && !this.Ingredients.contains(item)) { //Prevents adding duplicate ingredients to the dish.
            this.Ingredients.add(item);
            this.complete = checkComplete();
            System.out.println("added to dish\ncurrent:");
            System.out.println("recipe:");
            return true;
        }
        return false;
    }

    /**
     * Not implemented.
     */
    public void act(float delta) {
    }

    /**
     * Sets the Dish's recipe when an ingredient is first added, as it is initialised without a recipe.
     * @param currentIngredients an ArrayList of {@link Ingredient}s.
     * @return True if there is a recipe that matches the ingredients, false otherwise.
     */
    private boolean setRecipe(ArrayList<Ingredient> currentIngredients) {
        boolean matchSalad = true;
        boolean matchBurger = true;
        boolean matchPizza = true;
        boolean matchJacket = true;
        for (Ingredient i : currentIngredients) {
            System.out.println(i.getCuttingProgress());
            System.out.println(i.getBakingProgress());
            System.out.println(i.getFryingProgress());
            System.out.println(i.ingredientType.getName());
            if (!BURGER_RECIPE.contains(i)) {
                matchBurger = false;
            }
            if (!SALAD_RECIPE.contains(i)) {
                matchSalad = false;
            }
            if (!PIZZA_RECIPE.contains(i)) {
                matchPizza = false;
            }
            if (!JACKET_POTATO_RECIPE.contains(i)) {
                matchJacket = false;
            }
        }
        if (matchSalad && !matchBurger && !matchPizza && !matchJacket)
            recipe = SALAD_RECIPE; //if it only matches salad set recipe to salad
        else if (matchBurger && !matchSalad && !matchPizza && !matchJacket)
            recipe = BURGER_RECIPE; //if it only matches burger set recipe to burger
        else if (!matchBurger && !matchSalad && matchPizza && !matchJacket)
            recipe = PIZZA_RECIPE;
        else if (!matchBurger && !matchSalad && !matchPizza && matchJacket)
            recipe = JACKET_POTATO_RECIPE;
        else
            return matchBurger || matchSalad || matchPizza || matchJacket; //returns false if it matches none of the recipes
        return true; //returns true if there is a recipe that matches

    }

    /**
     * Checks if the recipe is complete (that is, all the ingredients for the recipe have been added to the dish).
     * If it is, set the dish's texture to the appropriate dish texture and clear ingredients to prevent drawing them
     * in players inventory alongside the dish.
     * @return True if the recipe is complete, false otherwise.
     */
    private boolean checkComplete() {
        if (this.Ingredients.size() != 0 && this.recipe.size() != 0) {
            for (Ingredient i : recipe) {
                if (!this.Ingredients.contains(i)) {
                    return false;
                }
            }
            if (recipe == BURGER_RECIPE)
                this.texture = GameData.burgerDishTexture;
            else if (recipe == SALAD_RECIPE)
                this.texture = GameData.saladDishTexture;
            else if (recipe == PIZZA_RECIPE)
                this.texture = GameData.pizzaDishTexture;
            else if (recipe == JACKET_POTATO_RECIPE)
                this.texture = GameData.jacketPotatoDishTexture;
            this.Ingredients.clear();
            return true;
        }
        return false;
    }

    /**
     * Gets the dish's {@link #complete} value.
     * @return true if the dish is complete, false otherwise.
     */
    public boolean isComplete() {
        return complete;
    }


    /**
     * Draws the dish and its ingredients in the inventory.
     * @param x The X coordinate of the dish.
     * @param y The Y coordinate of the dish.
     * @param width The width of the drawing.
     * @param height The height of the drawing.
     */
    @Override
    public void drawItemInventory(int x, int y, int width, int height) {
        super.drawItemInventory(x, y, width, height);

        for (Ingredient ingredient : Ingredients) {
            System.out.println(ingredient);
            y -= 50;
            ingredient.drawItemInventory(x, y, Base.tile_pixel_width / 2,
                    Base.tile_pixel_width / 2);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dish)) {
            return false;
        }
        Dish dish = (Dish) obj;
        if (this.complete != dish.complete) {
            return false;
        }
        if (this.recipe != dish.recipe) {
            return false;
        }
        return true;
    }
}
