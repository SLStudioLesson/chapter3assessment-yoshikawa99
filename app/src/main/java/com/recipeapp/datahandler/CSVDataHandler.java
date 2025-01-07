package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() throws IOException{
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    public void a (String filePath) {
        this.filePath = filePath;
    }

    public String b() {
        return filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] pairs = line.split(",");
                // for loop
                    // Ingredient ingredient = new Ingredient();\
                    // ingredients.add(ingredient);

                // for (String pair : pairs) {
                //     System.out.println(pair);
                // }
                Recipe recipe = new Recipe(pairs[0], ingredients);
                recipes.add(recipe);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) {}

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
