package group24.piazzapanic.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLoad {
    public static void save() {
        // Checks if file exists, if not creates a new save file
        try {
            File myObj = new File("piazzaSave.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // TODO: Writes save data to the file
        // Need to figure out a structure for the data
        try {
            FileWriter myWriter = new FileWriter("piazzaSave.txt");
            // TODO: Write customer orders and their time remaining
            for (Customer customer : GameData.customers) {
                myWriter.write(customer.getOrderString() + System.lineSeparator()
                        + customer.remainingTime() + System.lineSeparator());

            }
            myWriter.write("###" + System.lineSeparator());

            // TODO: Write chefs' positions to the file (and item they are holding)
            myWriter.write(GameData.player1.x + "," + GameData.player1.y + System.lineSeparator());
            //myWriter.write(GameData.player1.holding + System.lineSeparator());
            myWriter.write(GameData.player2.x + "," + GameData.player2.y + System.lineSeparator());
            //myWriter.write(GameData.player2.holding + System.lineSeparator());
            myWriter.write(GameData.player3.x + "," + GameData.player3.y + System.lineSeparator());
            //myWriter.write(GameData.player3.holding + System.lineSeparator());

            myWriter.write("@@@" + System.lineSeparator());

            // TODO: Write score, time and reputation
            myWriter.write(GameData.reputation + System.lineSeparator());
            myWriter.write(GameData.gameTime + System.lineSeparator());
            myWriter.write(GameData.score + System.lineSeparator());
            myWriter.write(GameData.money + System.lineSeparator());

            myWriter.write(">>>" + System.lineSeparator());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void load() {
        // Removes current customers to prep for loading saved ones
        while (!GameData.customers.isEmpty()) {
            GameData.customers.get(0).fulfillOrder();
        }
        // TODO: Sets score, money, rep to saved values
        GameData.setScore(0);
        GameData.setMoney(5);
        GameData.setReputation(3);

        // TODO: Loads saved customers and their orders + time remaining
        Scanner input = new Scanner("piazzaSave.txt");
        ArrayList<String> saveData = new ArrayList<>();

        while (input.hasNextLine()) {
            saveData.add(input.nextLine());
        }

        // TODO: Load players' positions

        System.out.println(saveData);
    }
}

