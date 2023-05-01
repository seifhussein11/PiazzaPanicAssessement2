package group24.piazzapanic.tests;


import group24.piazzapanic.Base;
import group24.piazzapanic.maths.Vector2;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(GdxTestRunner.class)
public class Vector2Tests {

    @Test
    public void TestGetAbsoluteX(){
        Vector2 vector2 = new Vector2(2,3);
        assertEquals(Math.toIntExact(Math.round(vector2.x * Base.WINDOW_WIDTH)),vector2.getAbsoluteX());
        Vector2 vector3 = new Vector2(100,200);
        assertEquals(Math.toIntExact(Math.round(vector3.x * Base.WINDOW_WIDTH)),vector3.getAbsoluteX());
    }

    @Test
    public void TestGetAbsoluteY(){
        Vector2 vector2 = new Vector2(2,3);
        assertEquals(Math.toIntExact(Math.round(vector2.y * Base.WINDOW_HEIGHT)),vector2.getAbsoluteY());
        Vector2 vector3 = new Vector2(100,200);
        assertEquals(Math.toIntExact(Math.round(vector3.y * Base.WINDOW_HEIGHT)),vector3.getAbsoluteY());
    }

    @Test
    public void TestGridUnitTranslate(){
        Vector2 vector2 = new Vector2(2000,1050);
        Vector2 vector3 = new Vector2(1000,950);
        Vector2 newVector = new Vector2(vector2.x * Base.TILE_GRID_UNIT,
                vector2.y * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
        Vector2 wrongVector = new Vector2(vector3.x * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT,
                vector3.y * Base.TILE_GRID_UNIT);

        assertEquals(newVector.x,vector2.gridUnitTranslate(vector2.x,vector2.y).x,0.00000000001);
        assertEquals(newVector.y,vector2.gridUnitTranslate(vector2.x,vector2.y).y,0.00000000001);
        assertNotEquals(wrongVector.x,vector2.gridUnitTranslate(vector2.x,vector2.y).x,0.00000000001);
        assertNotEquals(wrongVector.y,vector2.gridUnitTranslate(vector2.x,vector2.y).y,0.00000000001);
    }

    @Test
    public void TestGridUnitTranslateDouble() {
        Vector2 vector2 = new Vector2(11.7, 5.4);
        Vector2 vector3 = new Vector2(2.9, 0.9);
        Vector2 newVector = new Vector2(vector2.x * Base.TILE_GRID_UNIT,
                vector2.y * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT);
        Vector2 wrongVector = new Vector2(vector3.x * Base.TILE_GRID_UNIT * (double) Base.WINDOW_WIDTH / Base.WINDOW_HEIGHT,
                vector3.y * Base.TILE_GRID_UNIT);

        assertEquals(newVector.x, vector2.gridUnitTranslate(vector2.x, vector2.y).x, 0.00000000001);
        assertEquals(newVector.y, vector2.gridUnitTranslate(vector2.x, vector2.y).y, 0.00000000001);
        assertNotEquals(wrongVector.x, vector2.gridUnitTranslate(vector2.x, vector2.y).x, 0.00000000001);
        assertNotEquals(wrongVector.y, vector2.gridUnitTranslate(vector2.x, vector2.y).y, 0.00000000001);

    }

















}
