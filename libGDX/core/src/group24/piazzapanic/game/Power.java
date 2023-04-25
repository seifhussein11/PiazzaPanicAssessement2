package group24.piazzapanic.game;

public class Power {
    int x;
    public static void up(int x){
        switch (x){
            case 1:
                GameData.addScore(1);
        }
    }

}
