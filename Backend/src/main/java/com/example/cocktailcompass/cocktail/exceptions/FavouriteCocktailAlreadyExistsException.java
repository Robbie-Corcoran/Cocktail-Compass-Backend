package com.example.cocktailcompass.cocktail.exceptions;

public class FavouriteCocktailAlreadyExistsException extends RuntimeException {
    public FavouriteCocktailAlreadyExistsException(String message) {
        super(message);
    }
}
