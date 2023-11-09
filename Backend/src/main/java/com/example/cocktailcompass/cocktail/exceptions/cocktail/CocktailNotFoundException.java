package com.example.cocktailcompass.cocktail.exceptions.cocktail;

public class CocktailNotFoundException extends RuntimeException {
    public CocktailNotFoundException(String message) {
        super(message);
    }
}
