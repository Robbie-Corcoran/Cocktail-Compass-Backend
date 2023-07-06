package com.example.cocktailcompass.cocktail;

import java.util.Map;

public record CocktailDTO (
        int id,
        String name,
        String iba,
        String glass,
        String instructions,
        String thumbnail,
        Map<String, String>ingredients,
        Map<String, String> measures){
}
