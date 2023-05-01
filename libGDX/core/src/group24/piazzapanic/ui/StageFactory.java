package group24.piazzapanic.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import group24.piazzapanic.Base;
import group24.piazzapanic.game.GameData;
import group24.piazzapanic.game.GameLoop;
import group24.piazzapanic.maths.Vector2;
import com.badlogic.gdx.utils.Align;

/**
 * Class responsible for creating stages.
 */

public class StageFactory {

    /**
     * Create the main menu stage. 
     * returns the new stage created.
     */

    public static boolean endlessModeEnabled = true;
    public static int scenarioCustomerAmount;
    public static int difficultyVal;
    public static int test;
    public static Stage createMainMenuStage() {
        // Title
        Stage stage = new Stage();
        GameData.music = Gdx.audio.newMusic(Gdx.files.internal("TITLE-MUSIC.mp3"));
        GameData.music.setLooping(true);
        // GameData.music.play();
        CharSequence TitleText = "Piazza Panic!";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.titleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        // Scenario mode button
        TextButton scenarioModeButton = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.55), "Scenario Mode", Align.center);
        scenarioModeButton.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        scenarioModeButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Configure");
                StageManager.setActiveStage("Configure");
                endlessModeEnabled = false;
            }

        });
        stage.addActor(scenarioModeButton);

        // Endless mode button
        final TextButton endlessModeButton = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.45), "Endless Mode", Align.center);
        endlessModeButton.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        endlessModeButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Difficulty");
                StageManager.setActiveStage("Difficulty");
                endlessModeEnabled = true;
            }

        });
        stage.addActor(endlessModeButton);

//        // Options button
//        TextButton button2 = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
//                new Vector2(0.5, 0.38), "Options", Align.center);
//        button2.getStyle().overFontColor = Color.BLUE;
//        //Create onclick function
//        button2.addListener(new ChangeListener() {
//
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                System.out.print("Open Options");
//                StageManager.setActiveStage("Options");
//            }
//
//        });
//        stage.addActor(button2);

        // quit button
        TextButton button3 = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.3), "Quit", Align.center);
        button3.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button3.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Quit");
                Gdx.app.exit();
            }

        });
        stage.addActor(button3);

        // Temporary (?) dancing chef.
        StageAnimation ChefAnimation = new StageAnimation("chef/chef_idle_front_selected.png", 6, 6, 1, 20, 20, 154,
                307);
        StageAnimation ChefAnimation1 = new StageAnimation("chef/chef_1_idle_front_selected.png", 6, 6, 1,
                Base.WINDOW_WIDTH - 180, 20, 154, 307);

        stage.addActor(ChefAnimation);
        stage.addActor(ChefAnimation1);
        return stage;
    }

    /**
     * Create the options menu stage.
     * @return The new stage created.
     */
    public static Stage createOptionsMenuStage() {
        //Title
        Stage stage = new Stage();
        CharSequence TitleText = "Options";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        //Volume bar label
        CharSequence sliderTextString = "Sound";
        Label sliderText = new Label(sliderTextString, new LabelStyle(FontHandler.textButtonFormat, Color.WHITE));
        coords = new Vector2(0.5, 0.55);
        sliderText.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(sliderText);

        //Volume bar

        //NOT WORKING
        Skin skin = new Skin(Gdx.files.internal("testSkin/uiskin.json"));
        Slider scrollPane = new Slider(0, 100, 5, false, skin);
        coords = new Vector2(0.5, 0.5);
        scrollPane.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(scrollPane);
        //I don't know how to set the volume using this
        //it doesn't seem to do anything
        scrollPane.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                GameData.music.setVolume(value);

            }
        });
        //Add return to main button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.textButtonFormat, Color.WHITE,
                new Vector2(0.2, 0.7), "Back", Align.right);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Main");
                StageManager.setActiveStage("MainMenu");
            }

        });
        stage.addActor(button2);

        return stage;
    }

    /**
     * Create the options menu stage.
     * @return The new stage created.
     */
    public static Stage createScenarioAmountSelectionStage() {
        //Title
        Stage stage = new Stage();
        CharSequence TitleText = "Configure scenario";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        //Customer bar label
        CharSequence sliderTextString = "Customers";
        Label sliderText = new Label(sliderTextString, new LabelStyle(FontHandler.textButtonFormat, Color.WHITE));
        coords = new Vector2(0.5, 0.55);
        sliderText.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(sliderText);

        //Customer bar
        Skin skin = new Skin(Gdx.files.internal("testSkin/uiskin.json"));
        Slider customerSlider = new Slider(0, 20, 1, false, skin);
        coords = new Vector2(0.5, 0.5);
        customerSlider.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(customerSlider);
        final Label customersAmount = new Label("Select Customer Amount", new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        coords = new Vector2(0.5,0.44);
        customersAmount.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        customerSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                System.out.println(value);
                scenarioCustomerAmount = (int) value;
                if (value == 0) {
                    customersAmount.setText("Practice Mode");
                    Vector2 coordsNew = new Vector2(0.32,0.42);
                    customersAmount.setPosition(coordsNew.getAbsoluteX(), coordsNew.getAbsoluteY());
                } else {
                    customersAmount.setText(scenarioCustomerAmount);
                    Vector2 coordsNew = new Vector2(0.48,0.42);
                    customersAmount.setPosition(coordsNew.getAbsoluteX(), coordsNew.getAbsoluteY());
                }

            }
        });
        stage.addActor(customersAmount);

        //Add return to main button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.textButtonFormat, Color.WHITE,
                new Vector2(0.2, 0.7), "Back", Align.right);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Main");
                StageManager.setActiveStage("MainMenu");
            }

        });
        stage.addActor(button2);

        //Add go to difficulty stage button
        TextButton beginScenarioButton = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.27), "Select Difficulty", Align.center);
        beginScenarioButton.getStyle().overFontColor = Color.BLUE;
        stage.addActor(beginScenarioButton);
        beginScenarioButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Difficulty");
                StageManager.setActiveStage("Difficulty");
            }

        });

        test = scenarioCustomerAmount;

        return stage;
    }

    /**
     * Create the pause menu stage.
     * @return The new stage created.
     */
    public static Stage createPauseMenuStage() {
        Stage stage = new Stage() {
            @Override
            public void act() {
                if (Gdx.input.isKeyJustPressed(Base.PAUSE_KEY)) {
                    StageManager.setActiveStage("Game");
                }
                super.act();
            }
        };
        //return to game button
        TextButton button = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.6), "Return to game", Align.center);
        button.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Game");
                //  GameData.music.play();
                StageManager.setActiveStage("Game");
            }

        });
        stage.addActor(button);

        //restart game button
        TextButton restart = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.5), "Restart", Align.center);
        restart.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        restart.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Game");
                GameData.gameLoop = new GameLoop();
                StageManager.addStage("Game", GameData.gameLoop);
                StageManager.setActiveStage("Game");
            }

        });
        stage.addActor(restart);

        //exit to menu button
        TextButton exit = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.4), "Exit to Menu", Align.center);
        exit.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        exit.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Quit Game");
                StageManager.setActiveStage("MainMenu");
            }

        });
        stage.addActor(exit);

        //how to play button
        TextButton instructions = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.3), "How to Play", Align.center);
        instructions.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        instructions.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Instructions");
                StageManager.setActiveStage("Instructions");
            }

        });
        stage.addActor(instructions);
        return stage;
    }

    /**
     * Create Instructions stage
     * @return The new stage created
     */
    public static Stage createInstructionsStage() {
        Stage stage = new Stage() {
            @Override
            public void act() {
                if (Gdx.input.isKeyJustPressed(Base.PAUSE_KEY)) {
                    StageManager.setActiveStage("Game");
                }
                super.act();
            }
        };

        CharSequence Controls = "W - up\nA - left\nS - down\nD - right\nQ - swap chef\nE - Pick up/Put down\nF - Interact\n    (cut/fry/bake)";
        CharSequence Recipes = "Burger:\n-cut bread\n-cut meat\n-fry meat\n-cut lettuce\n\nSalad:\n-cut onion\n-cut tomato\n-cut lettuce";
        //Title
        Label title1 = new Label("Controls", new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.05, 0.85);
        title1.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.topLeft);

        //Controls
        Label controls = new Label(Controls, new LabelStyle(FontHandler.contentFormat, Color.WHITE));
        coords = new Vector2(0.05, 0.7);
        controls.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.topLeft);

        //Title 2
        Label title2 = new Label("Recipes", new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        coords = new Vector2(0.5, 0.85);
        title2.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.topLeft);

        //Recipes
        Label recipes = new Label(Recipes, new LabelStyle(FontHandler.contentFormat, Color.WHITE));
        coords = new Vector2(0.5, 0.7);
        recipes.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.topLeft);

        Label dishes = new Label("Place ingredients on top of a plate to combine into a dish",
                new LabelStyle(FontHandler.contentFormat, Color.WHITE));
        coords = new Vector2(0.5, 0.2);
        dishes.setWrap(true);
        dishes.setWidth((float) (Base.WINDOW_WIDTH * 0.75));
        dishes.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        dishes.setAlignment(Align.center, Align.center);

        //ingredient textures
        Image bun = new Image(GameData.cutBreadTexture);
        coords = new Vector2(0.93, 0.75);
        bun.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        bun.setScale((float) 0.15);

        Image cutMeat = new Image(GameData.cutMeatTexture);
        coords = new Vector2(0.7, 0.6);
        cutMeat.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        cutMeat.setScale((float) 1);

        Image cookedMeat = new Image(GameData.friedMeatTexture);
        coords = new Vector2(0.77, 0.64);
        cookedMeat.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        cookedMeat.setScale((float) 0.32);

        Image lettuce = new Image(GameData.cutLettuceTexture);
        coords = new Vector2(0.97, 0.82);
        lettuce.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        lettuce.setScale((float) 0.07);

        Image onion = new Image(GameData.cutOnionTexture);
        coords = new Vector2(0.89, 0.58);
        onion.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        onion.setScale((float) 0.1);

        Image tomato = new Image(GameData.cutTomatoTexture);
        coords = new Vector2(0.77, 0.41);
        tomato.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        tomato.setScale((float) 0.3);

        Image lettuce2 = new Image(GameData.cutLettuceTexture);
        coords = new Vector2(0.97, 0.61);
        lettuce2.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        lettuce2.setScale((float) 0.07);

        //Return to pause menu button
        TextButton backButton = WidgetFactory.createTextButton(FontHandler.textButtonFormat, Color.WHITE,
                new Vector2(0.15, 0.95), "Back", Align.right);
        backButton.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        backButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Main");
                StageManager.setActiveStage("Pause");
            }

        });
        stage.addActor(backButton);
        stage.addActor(dishes);
        stage.addActor(bun);
        stage.addActor(cutMeat);
        stage.addActor(cookedMeat);
        stage.addActor(lettuce);
        stage.addActor(onion);
        stage.addActor(tomato);
        stage.addActor(lettuce2);
        stage.addActor(title1);
        stage.addActor(controls);
        stage.addActor(title2);
        stage.addActor(recipes);
        return stage;
    }

    /**
     * Create Game Win Stage
     * @return The new stage created
     */
    public static Stage createGameWinStage() {
        Stage stage = new Stage();
        GameData.music = Gdx.audio.newMusic(Gdx.files.internal("TITLE-MUSIC.mp3"));
        GameData.music.setLooping(true);
        //GameData.music.play();

        //Title
        CharSequence TitleText = "Level Complete!";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.titleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        // return to menu button
        TextButton button = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.5), "Main Menu", Align.center);
        button.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Main Menu");
                StageManager.setActiveStage("MainMenu");
                GameData.score = 0;
            }

        });
        stage.addActor(button);

        // quit button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.4), "Quit", Align.center);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Quit");
                Gdx.app.exit();
            }

        });
        stage.addActor(button2);

        // Temporary (?) dancing chef.
        StageAnimation ChefAnimation = new StageAnimation("chef/chef_idle_front_selected.png", 6, 6, 1, 20, 20, 154,
                307);
        StageAnimation ChefAnimation1 = new StageAnimation("chef/chef_1_idle_front_selected.png", 6, 6, 1,
                Base.WINDOW_WIDTH - 180, 20, 154, 307);

        stage.addActor(ChefAnimation);
        stage.addActor(ChefAnimation1);
        return stage;
    }

    /**
     * Create Scenario Mode Game Over Stage
     * @return The new stage created
     */
    public static Stage createScenarioGameOverStage() {
        Stage stage = new Stage();
        GameData.music = Gdx.audio.newMusic(Gdx.files.internal("TITLE-MUSIC.mp3"));
        GameData.music.setLooping(true);
        //GameData.music.play();

        //Title
        CharSequence TitleText = "Game Over!";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.titleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        //Subtitle
        CharSequence SubtitleText = "You failed to serve all\nof the customers in time";
        Label Subtitle = new Label(SubtitleText, new LabelStyle(FontHandler.contentFormat, Color.WHITE));
        Vector2 coords2 = new Vector2(0.5, 0.6);
        Subtitle.setPosition(coords2.getAbsoluteX(), coords2.getAbsoluteY(), Align.center);
        stage.addActor(Subtitle);

        // return to menu button
        TextButton button = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.4), "Main Menu", Align.center);
        button.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Main Menu");
                StageManager.setActiveStage("MainMenu");
                GameData.score = 0;
            }

        });
        stage.addActor(button);

        // quit button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.3), "Quit", Align.center);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Quit");
                Gdx.app.exit();
            }

        });
        stage.addActor(button2);

        // Temporary (?) dancing chef.
        StageAnimation ChefAnimation = new StageAnimation("chef/chef_idle_front_selected.png", 6, 6, 1, 20, 20, 154,
                307);
        StageAnimation ChefAnimation1 = new StageAnimation("chef/chef_1_idle_front_selected.png", 6, 6, 1,
                Base.WINDOW_WIDTH - 180, 20, 154, 307);

        stage.addActor(ChefAnimation);
        stage.addActor(ChefAnimation1);
        return stage;
    }

    /**
     * Create Endless Mode Game Over Stage
     * @return The new stage created
     */
    public static Stage createEndlessGameOverStage() {
        Stage stage = new Stage();
        GameData.music = Gdx.audio.newMusic(Gdx.files.internal("TITLE-MUSIC.mp3"));
        GameData.music.setLooping(true);
        //GameData.music.play();

        //Title
        CharSequence TitleText = "Game Over!";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.titleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        //Subtitle
        CharSequence SubtitleText;
        if (GameData.score == 1) {
            SubtitleText = "You served 1 customer";
        } else {
            SubtitleText = "You served " + GameData.score + " customers";
        }
        Label Subtitle = new Label(SubtitleText, new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        Vector2 coords2 = new Vector2(0.5, 0.6);
        Subtitle.setPosition(coords2.getAbsoluteX(), coords2.getAbsoluteY(), Align.center);
        stage.addActor(Subtitle);

        // return to menu button
        TextButton button = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.4), "Main Menu", Align.center);
        button.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Main Menu");
                StageManager.setActiveStage("MainMenu");
                GameData.score = 0;
            }

        });
        stage.addActor(button);

        // quit button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.3), "Quit", Align.center);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Quit");
                Gdx.app.exit();
            }

        });
        stage.addActor(button2);

        // Temporary (?) dancing chef.
        StageAnimation ChefAnimation = new StageAnimation("chef/chef_idle_front_selected.png", 6, 6, 1, 20, 20, 154,
                307);
        StageAnimation ChefAnimation1 = new StageAnimation("chef/chef_1_idle_front_selected.png", 6, 6, 1,
                Base.WINDOW_WIDTH - 180, 20, 154, 307);

        stage.addActor(ChefAnimation);
        stage.addActor(ChefAnimation1);
        return stage;
    }

    public static Stage createDifficultySelectionStage() {
        //Title
        Stage stage = new Stage();
        CharSequence TitleText = "Difficulty level";
        Label Title = new Label(TitleText, new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        Vector2 coords = new Vector2(0.5, 0.7);
        Title.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(Title);

        // Difficulty bar
        Skin skin = new Skin(Gdx.files.internal("testSkin/uiskin.json"));
        Slider difficultySlider = new Slider(0, 2, 1, false, skin);
        coords = new Vector2(0.5, 0.5);
        difficultySlider.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        stage.addActor(difficultySlider);
        final Label difficultyLevel = new Label("Select difficulty level", new LabelStyle(FontHandler.subtitleFormat, Color.WHITE));
        coords = new Vector2(0.5,0.44);
        difficultyLevel.setPosition(coords.getAbsoluteX(), coords.getAbsoluteY(), Align.center);
        difficultySlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = ((Slider) actor).getValue();
                System.out.println(value);
                if (value == 0) {
                    difficultyLevel.setText("Easy");
                    Vector2 coordsNew = new Vector2(0.45, 0.41);
                    difficultyLevel.setPosition(coordsNew.getAbsoluteX(), coordsNew.getAbsoluteY());
                } else if (value == 1) {
                    difficultyLevel.setText("Normal");
                    Vector2 coordsNew = new Vector2(0.43, 0.41);
                    difficultyLevel.setPosition(coordsNew.getAbsoluteX(), coordsNew.getAbsoluteY());
                } else {
                    difficultyLevel.setText("Hard");
                    Vector2 coordsNew = new Vector2(0.45, 0.41);
                    difficultyLevel.setPosition(coordsNew.getAbsoluteX(), coordsNew.getAbsoluteY());
                }
                difficultyVal = (int) value;
            }
        });
        stage.addActor(difficultyLevel);

        //Add return to main menu button
        TextButton button2 = WidgetFactory.createTextButton(FontHandler.textButtonFormat, Color.WHITE,
                new Vector2(0.2, 0.7), "Back", Align.right);
        button2.getStyle().overFontColor = Color.BLUE;
        //Create onclick function
        button2.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Main");
                StageManager.setActiveStage("MainMenu");
            }

        });
        stage.addActor(button2);

        //Add start game button
        TextButton beginScenarioButton = WidgetFactory.createTextButton(FontHandler.subtitleFormat, Color.WHITE,
                new Vector2(0.5, 0.27), "Begin Scenario", Align.center);
        beginScenarioButton.getStyle().overFontColor = Color.BLUE;
        stage.addActor(beginScenarioButton);
        beginScenarioButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Open Game");
                GameData.music.dispose();
                GameData.music = Gdx.audio.newMusic(Gdx.files.internal("MAIN-MUSIC.mp3"));
                GameData.music.setLooping(true);
                //  GameData.music.play();
                GameData.gameLoop = new GameLoop();
                StageManager.addStage("Game", GameData.gameLoop);
                StageManager.setActiveStage("Game");
                GameData.setMoney(0);
                GameData.setScore(0);
                GameData.setReputation(3);

            }

        });

        test = scenarioCustomerAmount;

        return stage;
    }
}