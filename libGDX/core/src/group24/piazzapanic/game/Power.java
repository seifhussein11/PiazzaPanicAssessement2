package group24.piazzapanic.game;

import com.badlogic.gdx.Game;

public class Power {
    int x;
    public static void up(int x){
        switch (x){
            case 1:
                GameData.addScore(1); //adds score
            case 2:
                GameData.addMoney(5); //adds money
            case 3:
                GameData.addReputation(1); //adds reputation
            case 4:
                GameData.sinceLastSpawn = 0; // slows down customer spawn
            case 5:
                if(!GameData.customers.isEmpty()) {
                    Customer c = GameData.customers.get(0);
                    c.fulfillOrder(); //fulfills the current order
                }
        }
    }

}
