package group24.piazzapanic.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import group24.piazzapanic.levelElements.Ingredient;
import group24.piazzapanic.levelElements.IngredientType;
import group24.piazzapanic.ui.StageAnimation;
import group24.piazzapanic.ui.StageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * The GameData class contains globally accessible functions and variables.
 */
public class GameData {
    /** The active {@link GameLoop} */
    public static GameLoop gameLoop;
    /** The game's score */
    public static Integer score = 0;
    /** The player's money */
    public static Integer money = 0;
    /** The player's reputation points */
    public static Integer reputation = 3;
    /** The cost of a new station or chef */
    public static Integer stationCost = 5;
    /** The customers waiting to be served */
    public static ArrayList<Customer> customers;
    /** The in-game timer, updated every frame */
    public static float gameTime;
    /** The time since the last customer was spawned */
    public static float sinceLastSpawn;
    /** The active {@link Level} */
    public static Level level;
    /** The active {@link Player}. Points to either {@link #player1}, {@link #player2} or {@link #player3} */
    public static Player player;
    /** The first player */
    public static Player player1;
    /** The second player */
    public static Player player2;
    /** The third player */
    public static Player player3;
    /** The active {@link Music} */
    public static Music music;
    /** A list of all the possible customer sprites */
    public static List<String> customerSpriteSheets;
    /** Random number generator used while instantiating customers and dishes */
    public static Random rand;
    /** x offset for the camera, in pixels */
    public static int offsetX = 300;
    /** y offset for the camera, in pixels */
    public static int offsetY = 300;

    //ingredients with states to use in recipes
    /** tomato ingredient to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes*/
    public static Ingredient CHOPPED_TOMATO;
    /** chopped lettuce ingredient to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes */
    public static Ingredient CHOPPED_LETTUCE;
    /** chopped onion ingredient to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes */
    public static Ingredient CHOPPED_ONION;
    /** chopped burger bun ingredient to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes */
    public static Ingredient BURGER_BUN;
    /** finished burger to be used in {@link group24.piazzapanic.levelElements.Dish} for serving to customers */
    public static Ingredient BURGER;
    /** pizza dough to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes. */
    public static Ingredient BAKED_DOUGH;
    /** pizza sauce to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes. */
    public static Ingredient PIZZA_SAUCE;
    /** cheese to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes */
    public static Ingredient CHEESE;
    /** potato to be used in {@link group24.piazzapanic.levelElements.Dish} for recipes */
    public static Ingredient BAKED_POTATO;
    /** initial animation for chef 1 */
    public static StageAnimation initialChef1Animation;
    /** initial animation for chef 2 */
    public static StageAnimation initialChef2Animation;
    /** initial animation for chef 3 */
    public static StageAnimation initialChef3Animation;
    /** HashMap of all animations for chef1 */
    public static HashMap<String, Animation<TextureRegion>> chef1Animations;
    /** HashMap of all animations for chef2 */
    public static HashMap<String, Animation<TextureRegion>> chef2Animations;
    /** HashMap of all animations for chef3 */
    public static HashMap<String, Animation<TextureRegion>> chef3Animations;

    /** The texture for the debug square */
    public static Texture debugSquareTexture;
    /** The texture for the floor */
    public static Texture floorTexture;
    /** The texture for the {@link group24.piazzapanic.levelElements.stations.BakingStation} */
    public static Texture bakingStationTexture;
    /** The texture for the locked baking station */
    public static Texture lockedBakingStationTexture;
    /** A texture for the {@link group24.piazzapanic.levelElements.stations.CounterTop} */
    public static Texture counterTopTexture;
    /** A corner texture for the {@link group24.piazzapanic.levelElements.stations.CounterTop} */

    public static Texture counterRightCornerTexture;
    /** A corner texture for the {@link group24.piazzapanic.levelElements.stations.CounterTop} */

    public static Texture counterRightTexture;
    /** An end texture for the {@link group24.piazzapanic.levelElements.stations.CounterTop} */

    public static Texture counterEndTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.stations.CuttingStation} */
    public static Texture cuttingStationTexture;
    /** Texture for the locked cutting station} */
    public static Texture lockedCuttingStationTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.stations.FryingStation} */
    public static Texture fryingStationTexture;
    /** Texture for the locked frying station */
    public static Texture lockedFryingStationTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture ingredientStationTexture;
    /** Texture for the TomatoStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture tomatoStationTexture;
    /** Texture for the OnionStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture onionStationTexture;
    /** Texture for the LettuceStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture lettuceStationTexture;
    /** Texture for the BreadStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture breadStationTexture;
    /** Texture for the MeatStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture meatStationTexture;
    /** Texture for the DoughStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture doughStationTexture;
    /** Texture for the CheeseStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture cheeseStationTexture;
    /** Texture for the SauceStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture sauceStationTexture;
    /** Texture for the PotatoStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture potatoStationTexture;
    /** Texture for the DishStation variant of the {@link group24.piazzapanic.levelElements.stations.IngredientStation} */
    public static Texture dishStationTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.Dish} type */
    public static Texture dishTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.stations.Bin} */
    public static Texture binTexture;
    /** Texture for the {@link group24.piazzapanic.levelElements.stations.ServingStation} */
    public static Texture servingStationTexture;

    /** Texture for the {@link group24.piazzapanic.levelElements.stations.Obstacle} */
    public static Texture obstacleTexture;
    /** Error texture for when a texture is not found */
    public static Texture errorTexture;
    // Ingredient textures
    /** Texture for a raw tomato */
    public static Texture rawTomatoTexture;
    /** Texture for a cut tomato */
    public static Texture cutTomatoTexture;
    /** Texture for a raw onion */
    public static Texture rawOnionTexture;
    /** Texture for a cut onion */
    public static Texture cutOnionTexture;
    /** Texture for a fried onion */
    public static Texture friedOnionTexture;
    /** Texture for a raw lettuce */
    public static Texture rawLettuceTexture;
    /** Texture for a cut lettuce */
    public static Texture cutLettuceTexture;
    /**Texture for raw bread */
    public static Texture rawBreadTexture;
    /**Texture for cut bread */
    public static Texture cutBreadTexture;
    /**Texture for fried bread */
    public static Texture friedBreadTexture; // Do we want to fry/toast the bread?
    /**Texture for raw meat */
    public static Texture rawMeatTexture;
    /**Texture for cut meat */
    public static Texture cutMeatTexture;
    /**Texture for half fried meat */
    public static Texture halfFriedMeatTexture;
    /**Texture for fried meat */
    public static Texture friedMeatTexture;
    /**Texture for burnt meat */
    public static Texture burntMeatTexture;
    /**Texture for raw dough */
    public static Texture rawDoughTexture;
    /**Texture for baked dough */
    public static Texture bakedDoughTexture;
    /**Texture for raw cheese */
    public static Texture rawCheeseTexture;
    /**Texture for raw sauce */
    public static Texture rawSauceTexture;
    /**Texture for raw potato */
    public static Texture rawPotatoTexture;
    /**Texture for baked potato */
    public static Texture bakedPotatoTexture;

    //completed dish textures
    /** Texture for a completed burger {@link group24.piazzapanic.levelElements.Dish } */
    public static Texture burgerDishTexture;
    /** Texture for a Salad {@link group24.piazzapanic.levelElements.Dish} */
    public static Texture saladDishTexture;
    /** Texture for a Pizza {@link group24.piazzapanic.levelElements.Dish} */
    public static Texture pizzaDishTexture;
    /** Texture for a Jacket Potato {@link group24.piazzapanic.levelElements.Dish} */
    public static Texture jacketPotatoDishTexture;

    /**
     * Initializes all the textures and animations
     */
    public static void init() {
        //Chef animations
        /*
        Okay, so why is this done this way? You are probably looking at this and your eyes are bleeding.
        but worry not, this is actually the best way to do it lol.
        This is mostly done to avoid recreating animations that are already present in memory each time the player needs to change animations, so they are all made in advance.
        Otherwise, this would lead to a memory leak. which is not poggers.
         */
        chef1Animations = new HashMap<String, Animation<TextureRegion>>();
        chef1Animations.put("IdleFrontSelected",
                StageAnimation.makeAnimation("chef/chef_idle_front_selected.png", 6, 1, 6));
        chef1Animations.put("IdleBackSelected",
                StageAnimation.makeAnimation("chef/chef_idle_back_selected.png", 6, 1, 6));
        chef1Animations.put("IdleLeftSelected",
                StageAnimation.makeAnimation("chef/chef_idle_left_selected.png", 6, 1, 6));
        chef1Animations.put("IdleRightSelected",
                StageAnimation.makeAnimation("chef/chef_idle_right_selected.png", 6, 1, 6));
        chef1Animations.put("IdleFront", StageAnimation.makeAnimation("chef/chef_idle_front.png", 6, 1, 6));
        chef1Animations.put("IdleBack", StageAnimation.makeAnimation("chef/chef_idle_back.png", 6, 1, 6));
        chef1Animations.put("IdleLeft", StageAnimation.makeAnimation("chef/chef_idle_left.png", 6, 1, 6));
        chef1Animations.put("IdleRight", StageAnimation.makeAnimation("chef/chef_idle_right.png", 6, 1, 6));
        chef1Animations.put("Front", StageAnimation.makeAnimation("chef/chef_walk_front.png", 6, 1, 6));
        chef1Animations.put("Back", StageAnimation.makeAnimation("chef/chef_walk_back.png", 6, 1, 6));
        chef1Animations.put("Left", StageAnimation.makeAnimation("chef/chef_walk_left.png", 6, 1, 6));
        chef1Animations.put("Right", StageAnimation.makeAnimation("chef/chef_walk_right.png", 6, 1, 6));

        chef2Animations = new HashMap<String, Animation<TextureRegion>>();
        chef2Animations.put("IdleFrontSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_front_selected.png", 6, 1, 6));
        chef2Animations.put("IdleBackSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_back_selected.png", 6, 1, 6));
        chef2Animations.put("IdleLeftSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_left_selected.png", 6, 1, 6));
        chef2Animations.put("IdleRightSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_right_selected.png", 6, 1, 6));
        chef2Animations.put("IdleFront", StageAnimation.makeAnimation("chef/chef_1_idle_front.png", 6, 1, 6));
        chef2Animations.put("IdleBack", StageAnimation.makeAnimation("chef/chef_1_idle_back.png", 6, 1, 6));
        chef2Animations.put("IdleLeft", StageAnimation.makeAnimation("chef/chef_1_idle_left.png", 6, 1, 6));
        chef2Animations.put("IdleRight", StageAnimation.makeAnimation("chef/chef_1_idle_right.png", 6, 1, 6));
        chef2Animations.put("Front", StageAnimation.makeAnimation("chef/chef_1_walk_front.png", 6, 1, 6));
        chef2Animations.put("Back", StageAnimation.makeAnimation("chef/chef_1_walk_back.png", 6, 1, 6));
        chef2Animations.put("Left", StageAnimation.makeAnimation("chef/chef_1_walk_left.png", 6, 1, 6));
        chef2Animations.put("Right", StageAnimation.makeAnimation("chef/chef_1_walk_right.png", 6, 1, 6));

        chef3Animations = new HashMap<String, Animation<TextureRegion>>();
        chef3Animations.put("IdleFrontSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_front_selected.png", 6, 1, 6));
        chef3Animations.put("IdleBackSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_back_selected.png", 6, 1, 6));
        chef3Animations.put("IdleLeftSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_left_selected.png", 6, 1, 6));
        chef3Animations.put("IdleRightSelected",
                StageAnimation.makeAnimation("chef/chef_1_idle_right_selected.png", 6, 1, 6));
        chef3Animations.put("IdleFront", StageAnimation.makeAnimation("chef/chef_1_idle_front.png", 6, 1, 6));
        chef3Animations.put("IdleBack", StageAnimation.makeAnimation("chef/chef_1_idle_back.png", 6, 1, 6));
        chef3Animations.put("IdleLeft", StageAnimation.makeAnimation("chef/chef_1_idle_left.png", 6, 1, 6));
        chef3Animations.put("IdleRight", StageAnimation.makeAnimation("chef/chef_1_idle_right.png", 6, 1, 6));
        chef3Animations.put("Front", StageAnimation.makeAnimation("chef/chef_1_walk_front.png", 6, 1, 6));
        chef3Animations.put("Back", StageAnimation.makeAnimation("chef/chef_1_walk_back.png", 6, 1, 6));
        chef3Animations.put("Left", StageAnimation.makeAnimation("chef/chef_1_walk_left.png", 6, 1, 6));
        chef3Animations.put("Right", StageAnimation.makeAnimation("chef/chef_1_walk_right.png", 6, 1, 6));

        initialChef1Animation = new StageAnimation(chef1Animations.get("IdleFrontSelected"), 6, 6, 1, 0, 0,
                Player.TEXTURE_WIDTH, Player.TEXTURE_HEIGHT);
        initialChef2Animation = new StageAnimation(chef2Animations.get("IdleFrontSelected"), 6, 6, 1, 0, 0,
                Player.TEXTURE_WIDTH, Player.TEXTURE_HEIGHT);
        initialChef3Animation = new StageAnimation(chef3Animations.get("IdleFrontSelected"), 6, 6, 1, 0, 0,
                Player.TEXTURE_WIDTH, Player.TEXTURE_HEIGHT);
        debugSquareTexture = new Texture("debugsquare.png");

        // Load station textures.
        floorTexture = new Texture("stations/kitchen_floor_2.png");
        bakingStationTexture = new Texture("stations/baking_station_closed.png");
        lockedBakingStationTexture = new Texture("stations/locked_baking_station.png");
        counterTopTexture = new Texture("stations/countertop.png");
        counterRightCornerTexture = new Texture("stations/countertop_rightcorner.png");
        counterRightTexture = new Texture("stations/counterside.png");
        counterEndTexture = new Texture("stations/counterend.png");
        cuttingStationTexture = new Texture("stations/cutting_station.png");
        lockedCuttingStationTexture = new Texture("stations/locked_cutting_station.png");
        fryingStationTexture = new Texture("stations/frying_station_off.png");
        lockedFryingStationTexture = new Texture("stations/locked_frying_station.png");
        ingredientStationTexture = new Texture("stations/ingredientstation.png");
        tomatoStationTexture = new Texture("stations/tomato_sack.png");
        onionStationTexture = new Texture("stations/onion_sack.png");
        lettuceStationTexture = new Texture("stations/lettuce_sack.png");
        breadStationTexture = new Texture("stations/bread_sack.png");
        sauceStationTexture = new Texture("ingredients/sauce.png");
        cheeseStationTexture = new Texture("stations/cheese_sack.png");
        doughStationTexture = new Texture("stations/dough_sack.png");
        potatoStationTexture = new Texture("stations/potato_sack.png");
        meatStationTexture = new Texture("stations/ingredient_station_meat.png");
        dishStationTexture = new Texture("stations/ingredient_station_plate.png");
        binTexture = new Texture("stations/bin.png");
        servingStationTexture = new Texture("stations/customer_station.png");
        obstacleTexture = new Texture("stations/wall.png");

        // Ingredient Textures
        rawTomatoTexture = new Texture("ingredients/tomato.png");
        cutTomatoTexture = new Texture("ingredients/chopped_tomato.png");
        rawOnionTexture = new Texture("ingredients/onion.png");
        cutOnionTexture = new Texture("ingredients/chopped_onion.png");
        friedOnionTexture = new Texture("stations/sourceerr.png");//remove?
        rawLettuceTexture = new Texture("ingredients/lettuce.png");
        cutLettuceTexture = new Texture("ingredients/chopped_lettuce.png");
        rawBreadTexture = new Texture("ingredients/bread.png");
        cutBreadTexture = new Texture("ingredients/sliced_bread.png");
        friedBreadTexture = new Texture("stations/sourceerr.png"); //remove?
        rawMeatTexture = new Texture("ingredients/raw_meat.png");
        cutMeatTexture = new Texture("ingredients/raw_burger.png");
        halfFriedMeatTexture = new Texture("ingredients/half_cooked_burger.png");
        friedMeatTexture = new Texture("ingredients/cooked_burger.png");
        burntMeatTexture = new Texture("ingredients/burnt_burger.png");
        rawDoughTexture = new Texture("ingredients/dough.png");
        bakedDoughTexture = new Texture("ingredients/baked_dough.png");
        rawCheeseTexture = new Texture("ingredients/cheese.png");
        rawSauceTexture = new Texture("ingredients/sauce.png");
        rawPotatoTexture = new Texture("ingredients/potato.png");
        bakedPotatoTexture = new Texture("ingredients/baked_potato.png");
        dishTexture = new Texture("ingredients/plate.png");

        //dish textures
        burgerDishTexture = new Texture("ingredients/assembled_burger.png");
        saladDishTexture = new Texture("ingredients/salad.png");
        pizzaDishTexture = new Texture("ingredients/pizza.png");
        jacketPotatoDishTexture = new Texture("ingredients/jacket_potato.png");

        errorTexture = new Texture("stations/sourceerr.png");

        CHOPPED_TOMATO = new Ingredient(IngredientType.TOMATO, 1, -1, -1);
        CHOPPED_LETTUCE = new Ingredient(IngredientType.LETTUCE, 1, -1, -1);
        CHOPPED_ONION = new Ingredient(IngredientType.ONION, 1, -1, -1);
        BURGER_BUN = new Ingredient(IngredientType.BREAD, 1, -1, -1);
        BURGER = new Ingredient(IngredientType.MEAT, 1, -1, 1);
        BAKED_DOUGH = new Ingredient(IngredientType.DOUGH,-1,1,-1);
        PIZZA_SAUCE = new Ingredient(IngredientType.SAUCE,-1,-1,-1);
        CHEESE = new Ingredient(IngredientType.CHEESE,-1,-1,-1);
        BAKED_POTATO = new Ingredient(IngredientType.POTATO, -1,1,-1);


    }

    /**
     * an integer to the current score.
     * @param score the integer to add to the score.
     */
    public static void addScore(int score) {
        GameData.score += score;
        gameLoop.addScore(GameData.score);
    }

    public static void setScore(int score) {
        GameData.score = score;
        gameLoop.addScore(GameData.score);
    }

    public static void addMoney(int money) {
        GameData.money += money;
        gameLoop.addMoney(GameData.money);
    }

    public static void setMoney(int money) {
        GameData.money = money;
        gameLoop.addMoney(GameData.money);
    }

    public static void loseReputation(int reputation) {
        GameData.reputation -= reputation;
        gameLoop.loseReputation(GameData.reputation);
    }

    public static void addReputation(int reputation) {
        GameData.reputation += reputation;
        gameLoop.addReputation(GameData.reputation);
    }

    public static void setReputation(int reputation) {
        GameData.reputation = reputation;
        gameLoop.addReputation(GameData.reputation);
    }

    /**
     * Free up memory when the game is closed.
     */
    public static void dispose() {
        debugSquareTexture.dispose();

        floorTexture.dispose();
        bakingStationTexture.dispose();
        counterTopTexture.dispose();
        cuttingStationTexture.dispose();
        fryingStationTexture.dispose();
        ingredientStationTexture.dispose();
        obstacleTexture.dispose();
        dishStationTexture.dispose();

        errorTexture.dispose();
    }
}
