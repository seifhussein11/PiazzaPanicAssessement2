package group24.piazzapanic.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import group24.piazzapanic.Base;
import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.ui.FontHandler;
import group24.piazzapanic.ui.StageAnimation;
import group24.piazzapanic.ui.StageFactory;

/**
 * The customer class represents a customer in the game.
 * It extends {@link StageAnimation} and has a {@link Dish} order.
 * It also has a time limit for the order to be fulfilled.
 */
public class Customer extends StageAnimation {
    /**
     * The height of the customer
     */
    public static final int entityHeight = 153;
    /**
     * The width of the customer
     */
    public static final int entityWidth = 77;
    /**
     * The name for the customer
     */
    //    private String name; //Probably pointless
    /**
     * The order for the customer, a {@link Dish}
     */
    public Dish order;
    /**
     * The text for the customer's order
     */
    private CharSequence orderText; //temporary
    /**
     * The texture for the customer's order
     */
    private Texture orderTexture; //temporary

    /**
     * The time limit for the customer's order to be filled.
     */
    public float timeLimit;

    /**
     * The text bubble for the customer
     */
    //private final Label textBubble;

    /**
     * Constructor for the Customer class
     */
    public Customer() {
        super(GameData.customerSpriteSheets.get(GameData.rand.nextInt(GameData.customerSpriteSheets.size())), 6, 6, 1,
                20, 20, entityWidth, entityHeight);
        //        timeLimit = 30f;
        this.timeLimit = setTimeLimit();
        LabelStyle style = new LabelStyle();
        style.font = FontHandler.subtitleFormat;
        style.fontColor = Color.WHITE;

        this.order = Dish.Dishes.get(GameData.rand.nextInt(Dish.Dishes.size()));
        if (order.equals(Dish.BURGER)) {
            //    this.orderText = "Burger";
            this.orderTexture = GameData.burgerDishTexture;
        } else if (order.equals(Dish.SALAD)) {
            //    this.orderText = "Salad";
            this.orderTexture = GameData.saladDishTexture;
        } else if (order.equals(Dish.PIZZA)) {
            //    this.orderText = "Pizza";
            this.orderTexture = GameData.pizzaDishTexture;
        } else if (order.equals(Dish.JACKET_POTATO)) {
            //    this.orderText = "Jacket Potato";
            this.orderTexture = GameData.jacketPotatoDishTexture;
        }

    }


    public Customer(int customerOrder, float timeLimit) {
        super(GameData.customerSpriteSheets.get(GameData.rand.nextInt(GameData.customerSpriteSheets.size())), 6, 6, 1,
                20, 20, entityWidth, entityHeight);
        //        timeLimit = 30f;
        this.timeLimit = timeLimit;
        LabelStyle style = new LabelStyle();
        style.font = FontHandler.subtitleFormat;
        style.fontColor = Color.WHITE;

        // 0 for BURGER, 1 for SALAD, 2 for PIZZA, 3 for JACKET_POTATO
        this.order = Dish.Dishes.get(customerOrder);
        if (order.equals(Dish.BURGER)) {
            //    this.orderText = "Burger";
            this.orderTexture = GameData.burgerDishTexture;
        } else if (order.equals(Dish.SALAD)) {
            //    this.orderText = "Salad";
            this.orderTexture = GameData.saladDishTexture;
        } else if (order.equals(Dish.PIZZA)) {
            //    this.orderText = "Pizza";
            this.orderTexture = GameData.pizzaDishTexture;
        } else if (order.equals(Dish.JACKET_POTATO)) {
            //    this.orderText = "Jacket Potato";
            this.orderTexture = GameData.jacketPotatoDishTexture;
        }
    }


    /** Fulfil the customer's order i.e. they have had their dish served and are happy now :) */
    public void fulfillOrder() {
        //this.textBubble.setText("Done");
        GameData.customers.remove(this);
        this.remove();
        GameData.gameLoop.resortCustomers();
        GameData.addScore(1);
        GameData.addMoney(5);
    }

    public void fulfillOrder2() {
        GameData.customers.remove(this);
        this.remove();
        GameData.gameLoop.resortCustomers();
    }

    public void outOfTime() {
        GameData.customers.remove(this);
        this.remove();
        GameData.gameLoop.resortCustomers();
        GameData.gameLoop.totalCustomers--;
        GameData.loseReputation(1);
    }

    /** Update the customer's order text box location with the customer's location */
    @Override
    public void setX(float x) {
        super.setX(x);
        //if (this.textBubble != null)
        //    this.textBubble.setX(x);
    }

    /**
     * Set the Y position of the customer and their text bubble
     * @param y The new Y position
     */
    @Override
    public void setY(float y) {
        super.setY(y);
        //if (this.textBubble != null)
        //    this.textBubble.setY(y + entityHeight);
    }

    /**
     * Draw the customer and their text bubble
     * @param batch The batch it's being drawn as part of
     * @param parentAlpha The alpha value of the parent
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        //textBubble.draw(batch, parentAlpha);
        Base.batch.draw(orderTexture, this.getX(), this.getY() + entityHeight, entityWidth, entityWidth);
    }

    /**
     * Get the customer's order
     * @return A {@link Dish} representing the customer's order
     */
    public Dish getOrder() {
        return this.order;
    }

    public String getOrderString() { return this.order.getRecipe();}

    public float remainingTime() { return this.timeLimit; }

    protected static float setTimeLimit() {
        float difficulty = StageFactory.difficultyVal;
        switch ((int) difficulty) {
            case 0:
                return 100;
            case 1:
                return 80;
            case 2:
                return 60;
        }
        return 80;
    }

    @Override
    public void act(float delta) {
        timeLimit -= delta;
        //System.out.println(timeLimit);
        if (timeLimit <= 0) {
            outOfTime();
        }
    }

}
