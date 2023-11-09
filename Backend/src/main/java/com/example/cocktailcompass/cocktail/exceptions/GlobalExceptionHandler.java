package com.example.cocktailcompass.cocktail.exceptions;

import com.example.cocktailcompass.cocktail.exceptions.cocktail.CocktailNotFoundException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailAlreadyExistsException;
import com.example.cocktailcompass.cocktail.exceptions.favouriteCocktail.FavouriteCocktailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({FavouriteCocktailAlreadyExistsException.class})
    public ResponseEntity<Object> handleFavouriteCocktailAlreadyExistsException(FavouriteCocktailAlreadyExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    @ExceptionHandler({FavouriteCocktailNotFoundException.class})
    public ResponseEntity<Object> handleFavouriteCocktailNotFoundException(FavouriteCocktailNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(CocktailNotFoundException.class)
    public ResponseEntity<String> handleCocktailNotFoundException(CocktailNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
