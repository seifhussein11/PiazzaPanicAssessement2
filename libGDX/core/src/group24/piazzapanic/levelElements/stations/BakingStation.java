package group24.piazzapanic.levelElements.stations;

public class BakingStation extends Station{

    public BakingStation(Texture sprite, Vector2 location){
        this.sprite = sprite;
        this.location = location;
        this.item = null;
    }
    
    public BakingStation(Texture sprite, Vector2 location, Movable item){
        this.sprite = sprite;
        this.location = location;
        this.item = item;
    }
    
}
