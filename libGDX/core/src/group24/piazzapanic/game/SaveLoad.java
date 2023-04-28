package group24.piazzapanic.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
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

            // TODO: Write chefs' positions to the file (and item they are holding)
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

            // TODO: Write score, time and reputation
            myWriter.write(GameData.reputation + System.lineSeparator());
            myWriter.write(GameData.gameTime + System.lineSeparator());
            myWriter.write(GameData.score + System.lineSeparator());
            myWriter.write(GameData.money + System.lineSeparator());

            myWriter.write(">>>" + System.lineSeparator());

            // TODO: Write customer orders and their time remaining
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

    public static void load() throws FileNotFoundException {
        // Removes current customers to prep for loading saved ones
        while (!GameData.customers.isEmpty()) {
            GameData.customers.get(0).fulfillOrder();
        }
        GameData.gameLoop.resortCustomers();

        File file = new File("piazzaSave.txt");
        Scanner input = new Scanner(file);
        ArrayList<String> saveData = new ArrayList<>();
        while (input.hasNextLine()) {
            saveData.add(input.nextLine());
        }

        // TODO: Load players' positions
        GameData.player1.x = Double.parseDouble(saveData.get(0));
        GameData.player1.y = Double.parseDouble(saveData.get(1));
        GameData.player2.x = Double.parseDouble(saveData.get(2));
        GameData.player2.y = Double.parseDouble(saveData.get(3));
        GameData.player3.x = Double.parseDouble(saveData.get(4));
        GameData.player3.y = Double.parseDouble(saveData.get(5));

        // TODO: Sets score, money, rep to saved values
        GameData.reputation = Integer.parseInt(saveData.get(7));
        GameData.gameTime = Float.parseFloat(saveData.get(8));
        GameData.score = Integer.parseInt(saveData.get(9));
        GameData.money = Integer.parseInt(saveData.get(10));

        // TODO: Loads saved customers and their orders + time remaining
        //ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 12; i <= saveData.size() - 2; i += 2) {
            Customer customer = new Customer(orderInt(saveData.get(i)));
            //customers.add(customer);
            customer.setX(GameData.customers.size() * (Customer.entityWidth + 30));
            GameData.customers.add(customer);
            GameData.gameLoop.addActor(customer);
        }
        //GameData.customers = customers;

        System.out.println(saveData.toString());
    }


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