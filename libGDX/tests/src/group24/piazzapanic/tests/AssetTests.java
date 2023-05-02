package group24.piazzapanic.tests;

import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class AssetTests {

    @Test
    public void testStationAssetsExists() {
        assertTrue("This test will only pass if the floor asset exists",
                Gdx.files.internal("stations\\kitchen_floor.png").exists());
        assertTrue("This test will only pass if the baking station closed asset exists",
                Gdx.files.internal("stations\\baking_station_closed.png").exists());
        assertTrue("This test will only pass if the baking station open asset exists",
                Gdx.files.internal("stations\\baking_station_open.png").exists());
        assertTrue("This test will only pass if the bin asset exists",
                Gdx.files.internal("stations\\bin.png").exists());
        assertTrue("This test will only pass if the bread sack asset exists",
                Gdx.files.internal("stations\\bread_sack.png").exists());
        assertTrue("This test will only pass if the cheese sack asset exists",
                Gdx.files.internal("stations\\cheese_sack.png").exists());
        assertTrue("This test will only pass if the  asset exists",
                Gdx.files.internal("stations\\").exists());
        assertTrue("This test will only pass if the counter end asset exists",
                Gdx.files.internal("stations\\counterend.png").exists());
        assertTrue("This test will only pass if the counter side asset exists",
                Gdx.files.internal("stations\\counterside.png").exists());
        assertTrue("This test will only pass if the counter top asset exists",
                Gdx.files.internal("stations\\countertop.png").exists());
        assertTrue("This test will only pass if the counter top right corner asset exists",
                Gdx.files.internal("stations\\countertop_rightcorner.png").exists());
        assertTrue("This test will only pass if the customer station asset exists",
                Gdx.files.internal("stations\\customer_station.png").exists());
        assertTrue("This test will only pass if the cutting station asset exists",
                Gdx.files.internal("stations\\cutting_station.png").exists());
        assertTrue("This test will only pass if the dough sack asset exists",
                Gdx.files.internal("stations\\dough_sack.png").exists());
        assertTrue("This test will only pass if the empty sack asset exists",
                Gdx.files.internal("stations\\empty_sack.png").exists());
        assertTrue("This test will only pass if the frying station off asset exists",
                Gdx.files.internal("stations\\frying_station_off.png").exists());
        assertTrue("This test will only pass if the frying station on asset exists",
                Gdx.files.internal("stations\\frying_station_on.png").exists());
        assertTrue("This test will only pass if the meat station asset exists",
                Gdx.files.internal("stations\\ingredient_station_meat.png").exists());
        assertTrue("This test will only pass if the plate station asset exists",
                Gdx.files.internal("stations\\ingredient_station_plate.png").exists());
        assertTrue("This test will only pass if the lettuce_sack asset exists",
                Gdx.files.internal("stations\\lettuce_sack.png").exists());
        assertTrue("This test will only pass if the locked baking station asset exists",
                Gdx.files.internal("stations\\locked_baking_station.png").exists());
        assertTrue("This test will only pass if the locked cutting station asset exists",
                Gdx.files.internal("stations\\locked_cutting_station.png").exists());
        assertTrue("This test will only pass if the locked frying station asset exists",
                Gdx.files.internal("stations\\locked_frying_station.png").exists());
        assertTrue("This test will only pass if the onion sack asset exists",
                Gdx.files.internal("stations\\onion_sack.png").exists());
        assertTrue("This test will only pass if the potato sack asset exists",
                Gdx.files.internal("stations\\potato_sack.png").exists());
        assertTrue("This test will only pass if the tomato sack asset exists",
                Gdx.files.internal("stations\\tomato_sack.png").exists());

    }

    @Test
    public void testCustomersAssetsExists(){
        assertTrue("this test will only pass if the customer1 asset exists",
                Gdx.files.internal("customers\\customer_1_idle.png").exists());
        assertTrue("this test will only pass if the customer2 asset exists",
                Gdx.files.internal("customers\\customer_2_idle.png").exists());
        assertTrue("this test will only pass if the customer3 asset exists",
                Gdx.files.internal("customers\\customer_3_idle.png").exists());


    }

    @Test
    public void testIngredientsAssetsExists(){

        assertTrue("this test will only pass if the assembled burger asset exists",
                Gdx.files.internal("ingredients\\assembled_burger.png").exists());
        assertTrue("this test will only pass if the baked dough asset exists",
                Gdx.files.internal("ingredients\\baked_dough.png").exists());
        assertTrue("this test will only pass if the baked potato asset exists",
                Gdx.files.internal("ingredients\\baked_potato.png").exists());
        assertTrue("this test will only pass if the bread asset exists",
                Gdx.files.internal("ingredients\\bread.png").exists());
        assertTrue("this test will only pass if the burnt burger asset exists",
                Gdx.files.internal("ingredients\\burnt_burger.png").exists());
        assertTrue("this test will only pass if the cheese asset exists",
                Gdx.files.internal("ingredients\\cheese.png").exists());
        assertTrue("this test will only pass if the chopped lettuce asset exists",
                Gdx.files.internal("ingredients\\chopped_lettuce.png").exists());
        assertTrue("this test will only pass if the chopped onion asset exists",
                Gdx.files.internal("ingredients\\chopped_onion.png").exists());
        assertTrue("this test will only pass if the chopped tomato asset exists",
                Gdx.files.internal("ingredients\\chopped_tomato.png").exists());
        assertTrue("this test will only pass if the cooked burger asset exists",
                Gdx.files.internal("ingredients\\cooked_burger.png").exists());
        assertTrue("this test will only pass if the dough asset exists",
                Gdx.files.internal("ingredients\\dough.png").exists());
        assertTrue("this test will only pass if the half cooked burger asset exists",
                Gdx.files.internal("ingredients\\half_cooked_burger.png").exists());
        assertTrue("this test will only pass if the jacket potato asset exists",
                Gdx.files.internal("ingredients\\jacket_potato.png").exists());
        assertTrue("this test will only pass if the lettuce asset exists",
                Gdx.files.internal("ingredients\\lettuce.png").exists());
        assertTrue("this test will only pass if the onion asset exists",
                Gdx.files.internal("ingredients\\onion.png").exists());
        assertTrue("this test will only pass if the pizza asset exists",
                Gdx.files.internal("ingredients\\pizza.png").exists());
        assertTrue("this test will only pass if the plate asset exists",
                Gdx.files.internal("ingredients\\plate.png").exists());
        assertTrue("this test will only pass if the potato asset exists",
                Gdx.files.internal("ingredients\\potato.png").exists());
        assertTrue("this test will only pass if the raw burger asset exists",
                Gdx.files.internal("ingredients\\raw_burger.png").exists());
        assertTrue("this test will only pass if the raw meat asset exists",
                Gdx.files.internal("ingredients\\raw_meat.png").exists());
        assertTrue("this test will only pass if the salad asset exists",
                Gdx.files.internal("ingredients\\salad.png").exists());
        assertTrue("this test will only pass if the sauce asset exists",
                Gdx.files.internal("ingredients\\sauce.png").exists());
        assertTrue("this test will only pass if the sliced bread asset exists",
                Gdx.files.internal("ingredients\\sliced_bread.png").exists());
        assertTrue("this test will only pass if the tomato asset exists",
                Gdx.files.internal("ingredients\\tomato.png").exists());

    }

    @Test
    public void testChefAssetsExists(){
        assertTrue("this test will only pass if the chef1 idle back asset exists",
                Gdx.files.internal("chef\\chef_1_idle_back.png").exists());
        assertTrue("this test will only pass if the chef 1 idle back selected asset exists",
                Gdx.files.internal("chef\\chef_1_idle_back_selected.png").exists());
        assertTrue("this test will only pass if the chef 1 idle front asset exists",
                Gdx.files.internal("chef\\chef_1_idle_front.png").exists());
        assertTrue("this test will only pass if the chef 1 idle front selected asset exists",
                Gdx.files.internal("chef\\chef_1_idle_front_selected.png").exists());
        assertTrue("this test will only pass if the chef 1 idle left asset exists",
                Gdx.files.internal("chef\\chef_1_idle_left.png").exists());
        assertTrue("this test will only pass if the chef 1 idle left selected asset exists",
                Gdx.files.internal("chef\\chef_1_idle_left_selected.png").exists());
        assertTrue("this test will only pass if the chef 1 idle right asset exists",
                Gdx.files.internal("chef\\chef_1_idle_right.png").exists());
        assertTrue("this test will only pass if the chef 1 idle right selected asset exists",
                Gdx.files.internal("chef\\chef_1_idle_right_selected.png").exists());

        assertTrue("this test will only pass if the chef idle back asset exists",
                Gdx.files.internal("chef\\chef_idle_back.png").exists());
        assertTrue("this test will only pass if the chef idle back selected asset exists",
                Gdx.files.internal("chef\\chef_idle_back_selected.png").exists());
        assertTrue("this test will only pass if the chef idle front asset exists",
                Gdx.files.internal("chef\\chef_idle_front.png").exists());
        assertTrue("this test will only pass if the chef idle front selected asset exists",
                Gdx.files.internal("chef\\chef_idle_front_selected.png").exists());
        assertTrue("this test will only pass if the chef idle left asset exists",
                Gdx.files.internal("chef\\chef_idle_left.png").exists());
        assertTrue("this test will only pass if the chef idle left selected asset exists",
                Gdx.files.internal("chef\\chef_idle_left_selected.png").exists());
        assertTrue("this test will only pass if the chef idle right asset exists",
                Gdx.files.internal("chef\\chef_idle_right.png").exists());
        assertTrue("this test will only pass if the chef idle right selected asset exists",
                Gdx.files.internal("chef\\chef_idle_right_selected.png").exists());

        assertTrue("this test will only pass if the chef 1 walk back asset exists",
                Gdx.files.internal("chef\\chef_1_walk_back.png").exists());
        assertTrue("this test will only pass if the chef 1 walk front asset exists",
                Gdx.files.internal("chef\\chef_1_walk_front.png").exists());
        assertTrue("this test will only pass if the chef 1 walk left asset exists",
                Gdx.files.internal("chef\\chef_1_walk_left.png").exists());
        assertTrue("this test will only pass if the chef 1 walk right asset exists",
                Gdx.files.internal("chef\\chef_1_walk_right.png").exists());

        assertTrue("this test will only pass if the chef walk back asset exists",
                Gdx.files.internal("chef\\chef_walk_back.png").exists());
        assertTrue("this test will only pass if the chef walk front asset exists",
                Gdx.files.internal("chef\\chef_walk_front.png").exists());
        assertTrue("this test will only pass if the chef walk left asset exists",
                Gdx.files.internal("chef\\chef_walk_left.png").exists());
        assertTrue("this test will only pass if the chef walk right asset exists",
                Gdx.files.internal("chef\\chef_walk_right.png").exists());

    }

}
