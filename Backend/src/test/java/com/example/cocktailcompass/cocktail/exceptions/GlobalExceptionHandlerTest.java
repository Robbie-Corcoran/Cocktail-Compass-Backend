package com.example.cocktailcompass.cocktail.exceptions;

import com.example.cocktailcompass.cocktail.exceptions.cocktail.CocktailNotFoundException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailAlreadyExistsException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    public void testHandleFavouriteCocktailAlreadyExistsException() {
        FavouriteCocktailAlreadyExistsException exception = new FavouriteCocktailAlreadyExistsException("Cocktail already exists");
        ResponseEntity<Object> result = handler.handleFavouriteCocktailAlreadyExistsException(exception);

        assertEquals(HttpStatus.CONFLICT, result.getStatusCode());
        assertEquals(exception.getMessage(), result.getBody());
    }

}
