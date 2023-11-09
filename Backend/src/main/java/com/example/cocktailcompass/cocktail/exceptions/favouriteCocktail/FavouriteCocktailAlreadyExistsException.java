package com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail;

public class FavouriteCocktailAlreadyExistsException extends RuntimeException {
    public FavouriteCocktailAlreadyExistsException(String message) {
        super(message);
    }
}
