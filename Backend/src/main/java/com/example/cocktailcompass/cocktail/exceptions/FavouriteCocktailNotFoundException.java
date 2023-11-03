package com.example.cocktailcompass.cocktail.exceptions;

public class FavouriteCocktailNotFoundException extends RuntimeException {
        public FavouriteCocktailNotFoundException(String message){
            super(message);
    }
}
