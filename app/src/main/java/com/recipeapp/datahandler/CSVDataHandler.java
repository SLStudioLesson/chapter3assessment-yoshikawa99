package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
                String[] pairs = line.split(",");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (int i = 1; i < pairs.length; i++) {
                    Ingredient ingredient = new Ingredient(pairs[i]);
                    ingredients.add(ingredient);
                }
                Recipe recipe = new Recipe(pairs[0], ingredients);
                recipes.add(recipe);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return recipes;
    }


    @Override
    public void writeData(Recipe recipe)  throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(recipe.getName());
            recipe.getIngredients();
            for (Ingredient a : recipe.getIngredients()) {
                
                writer.write("," + a.getName());
            }
            writer.write("\n");
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
