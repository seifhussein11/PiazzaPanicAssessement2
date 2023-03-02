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

}
