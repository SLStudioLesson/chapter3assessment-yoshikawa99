package com.recipeapp.datahandler;

import java.util.ArrayList;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler{
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() {
        return null;
    }

    @Override
    public void writeData(Recipe recipe) {}

    @Override
    public ArrayList<Recipe> searchData(String keyword) {
        return null;
    }
}
