package com.example.cocktailcompass.cocktail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CocktailResponse {

    @JsonProperty("drinks")
    private List<OldCocktail> oldCocktails;

    public List<OldCocktail> getCocktails() {
        return oldCocktails;
    }
}
