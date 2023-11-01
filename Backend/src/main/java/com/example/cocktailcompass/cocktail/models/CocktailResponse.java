package com.example.cocktailcompass.cocktail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CocktailResponse {

    @JsonProperty("drinks")
    private List<CocktailEntity> oldCocktails;

    public List<CocktailEntity> getCocktails() {
        return oldCocktails;
    }
}
