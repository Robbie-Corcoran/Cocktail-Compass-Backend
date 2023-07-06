package com.example.cocktailcompass.cocktail;

import java.util.HashMap;
import java.util.Map;

public class Cocktail {
    private int id;
    private String name;
    private String iba;
    private String glass;
    private String instructions;
    private String thumbnail;
    private Map<String, String> ingredients;
    private Map<String, String> measures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIba() {
        return iba;
    }

    public void setIba(String iba) {
        this.iba = iba;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, String> getMeasures() {
        return measures;
    }

    public void setMeasures(Map<String, String> measures) {
        this.measures = measures;
    }
}
