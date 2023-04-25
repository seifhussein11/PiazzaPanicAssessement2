package group24.piazzapanic.game;

import com.badlogic.gdx.Game;

public class Power {
    int x;
    public static void up(int x){
        switch (x){
            case 1:
                GameData.addScore(1);
            case 2:
                GameData.addMoney(5);
            case 3:
                GameData.addReputation(1);
            case 4:
                Player.acceleration = 50;
            case 5:
                if(!GameData.customers.isEmpty()) {
                    Customer c = GameData.customers.get(0);
                    c.fulfillOrder();
                }
        }
    }

}
