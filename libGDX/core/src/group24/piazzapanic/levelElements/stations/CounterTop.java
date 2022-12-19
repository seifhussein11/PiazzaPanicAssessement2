package group24.piazzapanic.levelElements.stations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class CounterTop extends Station{
    
    public CounterTop(Texture sprite, Vector2 location){
        this.sprite = sprite;
        this.location = location;
        this.item = null;
    }
    
    public CounterTop(Texture sprite, Vector2 location, Movable item){
        this.sprite = sprite;
        this.location = location;
        this.item = item;
    }
}
