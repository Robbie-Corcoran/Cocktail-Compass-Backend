package com.example.cocktailcompass.cocktail.exceptions;

import com.example.cocktailcompass.GlobalExceptionHandler;
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

    @Test
    public void testHandleFavouriteCocktailNotFoundException() {
        FavouriteCocktailNotFoundException exception = new FavouriteCocktailNotFoundException("Cocktail not found");
        ResponseEntity<Object> result = handler.handleFavouriteCocktailNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(exception.getMessage(), result.getBody());
    }

    @Test
    public void testHandleRuntimeException() {
        RuntimeException exception = new RuntimeException("Internal server error");
        ResponseEntity<Object> result = handler.handleRuntimeException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals(exception.getMessage(), result.getBody());
    }

    @Test
    public void testHandleCocktailNotFoundException() {
        CocktailNotFoundException exception = new CocktailNotFoundException("Cocktail not found");
        ResponseEntity<String> result = handler.handleCocktailNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(exception.getMessage(), result.getBody());
    }
}
