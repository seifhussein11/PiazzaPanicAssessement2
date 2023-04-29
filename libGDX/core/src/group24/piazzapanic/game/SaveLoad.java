package group24.piazzapanic.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The SaveLoad class contains methods to allow the player to save the current
 * game state and load back into it later
 */
public class SaveLoad {
    /**
     * Saves the current game state in a file named piazzaSave.txt
     */
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

        // Writes save data to the file
        try {
            FileWriter myWriter = new FileWriter("piazzaSave.txt");

            // Writes chefs' positions to the file (and item they are holding [NOT IMPLEMENTED])
            myWriter.write(GameData.player1.x + System.lineSeparator());
            myWriter.write(GameData.player1.y + System.lineSeparator());
            //myWriter.write(GameData.player1.holding + System.lineSeparator());
            myWriter.write(GameData.player2.x + System.lineSeparator());
            myWriter.write(GameData.player2.y + System.lineSeparator());
            //myWriter.write(GameData.player2.holding + System.lineSeparator());
            myWriter.write(GameData.player3.x + System.lineSeparator());
            myWriter.write(GameData.player3.y + System.lineSeparator());
            //myWriter.write(GameData.player3.holding + System.lineSeparator());

            myWriter.write("@@@" + System.lineSeparator());

            // Writes other GameData stuff
            myWriter.write(GameData.reputation + System.lineSeparator());
            myWriter.write(GameData.gameTime + System.lineSeparator());
            myWriter.write(GameData.score + System.lineSeparator());
            myWriter.write(GameData.money + System.lineSeparator());
            myWriter.write(GameData.gameLoop.maxCustomers + System.lineSeparator());
            myWriter.write(GameData.gameLoop.totalCustomers + System.lineSeparator());

            myWriter.write(">>>" + System.lineSeparator());

            // Writes customer orders and their time remaining
            for (Customer customer : GameData.customers) {
                myWriter.write(customer.getOrderString() + System.lineSeparator()
                        + customer.remainingTime() + System.lineSeparator());

            }
            myWriter.write("###" + System.lineSeparator());


            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /** Loads the saved data from piazzaSave.txt into the game */
    public static void load() throws FileNotFoundException {
        // Removes current customers to prep for loading saved ones
        while (!GameData.customers.isEmpty()) {
            GameData.customers.get(0).fulfillOrder2();
        }
        GameData.gameLoop.resortCustomers();

        File file = new File("piazzaSave.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> saveData = new ArrayList<>();
        while (input.hasNextLine()) {
            saveData.add(input.nextLine());
        }

        // Loads players' positions
        GameData.player1.x = Double.parseDouble(saveData.get(0));
        GameData.player1.y = Double.parseDouble(saveData.get(1));
        GameData.player2.x = Double.parseDouble(saveData.get(2));
        GameData.player2.y = Double.parseDouble(saveData.get(3));
        GameData.player3.x = Double.parseDouble(saveData.get(4));
        GameData.player3.y = Double.parseDouble(saveData.get(5));

        // Loads other GameData values
        GameData.setReputation(Integer.parseInt(saveData.get(7)));
        GameData.gameTime = Float.parseFloat(saveData.get(8));
        GameData.setScore(Integer.parseInt(saveData.get(9)));
        GameData.setMoney(Integer.parseInt(saveData.get(10)));
        GameData.gameLoop.maxCustomers = Integer.parseInt(saveData.get(11));
        GameData.gameLoop.totalCustomers = Integer.parseInt(saveData.get(12));


        // Loads saved customers and their orders + time remaining
        for (int i = 14; i <= saveData.size() - 2; i += 2) {
            Customer customer = new Customer(orderInt(saveData.get(i)),Float.parseFloat(saveData.get(i+1)));
            customer.setX(GameData.customers.size() * (Customer.entityWidth + 30));
            GameData.customers.add(customer);
            GameData.gameLoop.addActor(customer);
        }

        System.out.println(saveData.toString());
    }


    /**
     * Converts String name of the order into an int used in the
     * {@link Customer} constructor
     */
    protected static int orderInt(String order) {
        switch (order) {
            case "Burger":
                return 0;
            case "Salad":
                return 1;
            case "Pizza":
                return 2;
            case "Jacket Potato":
                return 3;
        }
        return 0;
    }
}