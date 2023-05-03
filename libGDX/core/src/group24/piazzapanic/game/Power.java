package group24.piazzapanic.game;

import com.badlogic.gdx.Game;

public class Power {
    int x;
    public static void up(int x){
        if (x == 0) {
            GameData.addScore(1); //adds score
            GameData.gameLoop.activePowerup.setText("Added " + System.lineSeparator() + "1 score");
            GameData.gameLoop.addActor(GameData.gameLoop.activePowerup);
        } else if (x == 1) {
            GameData.addMoney(3); //adds money
            GameData.gameLoop.activePowerup.setText("Added " + System.lineSeparator() + "5 money");
            GameData.gameLoop.addActor(GameData.gameLoop.activePowerup);
        } else if (x == 2) {
            GameData.addReputation(1); //adds reputation
            GameData.gameLoop.activePowerup.setText("Added 1" + System.lineSeparator() + "reputation");
            GameData.gameLoop.addActor(GameData.gameLoop.activePowerup);
        } else if (x == 3) {
            GameData.sinceLastSpawn = 0; // slows down customer spawn
            GameData.gameLoop.activePowerup.setText("Delayed next" + System.lineSeparator() + "customer");
            GameData.gameLoop.addActor(GameData.gameLoop.activePowerup);
        } else if (x == 4) {
            if(!GameData.customers.isEmpty()) {
                Customer c = GameData.customers.get(0);
                c.fulfillOrder(); //fulfills the current order
                GameData.gameLoop.activePowerup.setText("Served a" + System.lineSeparator() + "customer");
                GameData.gameLoop.addActor(GameData.gameLoop.activePowerup);
            }
        }
    }

}
