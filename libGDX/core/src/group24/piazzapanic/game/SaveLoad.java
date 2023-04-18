package group24.piazzapanic.game;

import group24.piazzapanic.levelElements.Dish;
import group24.piazzapanic.levelElements.Ingredient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
            myWriter.write("order name");
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
        // TODO: Sets score to saved score value
        GameData.setScore(0);

        // TODO: Loads saved customers and their orders

        // The code here right now is just a placeholder test that i made lol
        Customer customer1 = new Customer(0);
        customer1.setX(GameData.customers.size() * (Customer.entityWidth + 30));
        GameData.customers.add(customer1);
        GameData.gameLoop.addActor(customer1);

        Customer customer2 = new Customer(1);
        customer2.setX(GameData.customers.size() * (Customer.entityWidth + 30));
        GameData.customers.add(customer2);
        GameData.gameLoop.addActor(customer2);

        Customer customer3 = new Customer(2);
        customer3.setX(GameData.customers.size() * (Customer.entityWidth + 30));
        GameData.customers.add(customer3);
        GameData.gameLoop.addActor(customer3);

        Customer customer4 = new Customer(3);
        customer4.setX(GameData.customers.size() * (Customer.entityWidth + 30));
        GameData.customers.add(customer4);
        GameData.gameLoop.addActor(customer4);

        Customer customer5 = new Customer(1);
        customer5.setX(GameData.customers.size() * (Customer.entityWidth + 30));
        GameData.customers.add(customer5);
        GameData.gameLoop.addActor(customer5);
    }
}

