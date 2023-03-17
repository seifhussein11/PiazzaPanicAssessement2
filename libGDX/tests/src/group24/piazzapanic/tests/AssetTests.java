package group24.piazzapanic.tests;

import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class AssetTests {

    @Test
    public void testFloorAssetExists() {
        assertTrue("This test will only pass if the floor asset exists",
                Gdx.files.internal("stations\\kitchen_floor.png").exists());
    }

    @Test
    public void testCustomersAssetsExists(){
        assertTrue("this test will only pass if the customer1 asset exists",Gdx.files.internal("customers\\customer_1_idle.png").exists());
        assertTrue("this test will only pass if the customer2 asset exists",Gdx.files.internal("customers\\customer_2_idle.png").exists());
        assertTrue("this test will only pass if the customer3 asset exists",Gdx.files.internal("customers\\customer_3_idle.png").exists());


    }

    @Test
    public void testIngredientsAssetsExists(){

        assertTrue("this test will only pass if the assembled burger asset exists",Gdx.files.internal("ingredients\\assembled_burger.png").exists());
        assertTrue("this test will only pass if the bread asset exists",Gdx.files.internal("ingredients\\bread.png").exists());
        assertTrue("this test will only pass if the chopped lettuce asset exists",Gdx.files.internal("ingredients\\chopped_lettuce.png").exists());
        assertTrue("this test will only pass if the chopped onion asset exists",Gdx.files.internal("ingredients\\chopped_onion.png").exists());
        assertTrue("this test will only pass if the chopped tomato asset exists",Gdx.files.internal("ingredients\\chopped_tomato.png").exists());
        assertTrue("this test will only pass if the lettuce asset exists",Gdx.files.internal("ingredients\\lettuce.png").exists());
        assertTrue("this test will only pass if the onion asset exists",Gdx.files.internal("ingredients\\onion.png").exists());
        assertTrue("this test will only pass if the plate asset exists",Gdx.files.internal("ingredients\\plate.png").exists());
        assertTrue("this test will only pass if the raw burger asset exists",Gdx.files.internal("ingredients\\raw_burger.png").exists());
        assertTrue("this test will only pass if the raw meat asset exists",Gdx.files.internal("ingredients\\raw_meat.png").exists());
        assertTrue("this test will only pass if the salad asset exists",Gdx.files.internal("ingredients\\salad.png").exists());
        assertTrue("this test will only pass if the sliced bread asset exists",Gdx.files.internal("ingredients\\sliced_bread.png").exists());
        assertTrue("this test will only pass if the tomato asset exists",Gdx.files.internal("ingredients\\tomato.png").exists());

    }

}
