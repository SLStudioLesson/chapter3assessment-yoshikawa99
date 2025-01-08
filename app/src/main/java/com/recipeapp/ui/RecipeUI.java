package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        this.displayRecipes();
                        break;
                    case "2":
                        this.addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData();
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("Recipes :");
                for (Recipe recipe : recipes) {
                    System.out.print("Recipe Name: ");
                    System.out.println(recipe.getName());

                    System.out.print("Main Ingredients: ");
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        System.out.print(ingredient.getName());
                        /*
                         * if () {
                         * System.out.print(",");
                         * }
                         */

                    }
                    System.out.println();
                    System.out.println("-----------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewRecipe() throws IOException {
        System.out.println("Adding a new recipe.");
        System.out.print("Enter recipe name: ");
        String recipeName = reader.readLine();
        System.out.println("Enter ingredients (type 'done' when finished):");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        
        while (true) {
            System.out.print("Ingredient: ");
            String ingredientAdd = reader.readLine();
            Ingredient ingredient = new Ingredient(ingredientAdd);
            if (ingredientAdd.equals("done")) {
                break;
            }
            ingredients.add(ingredient);
        }
        
        Recipe recipe = new Recipe(recipeName, ingredients);
        dataHandler.writeData(recipe);
    }
}
