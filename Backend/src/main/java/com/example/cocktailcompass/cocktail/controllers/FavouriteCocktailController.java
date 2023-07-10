package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.CocktailService;
import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails/favourites")
public class FavouriteCocktailController {

    private final CocktailService service;

    @Autowired
    public FavouriteCocktailController(CocktailService cocktailService) {
        this.service = cocktailService;
    }

    @PostMapping
    public ResponseEntity<FavouriteCocktail> saveFavouriteCocktail(@RequestBody FavouriteCocktail favouriteCocktail) {
        FavouriteCocktail savedCocktail = service.saveFavouriteCocktail(favouriteCocktail);
        if (savedCocktail == null) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(savedCocktail, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FavouriteCocktail>> getAllFavouriteCocktails() {
        List<FavouriteCocktail> favouriteCocktails = service.getAllFavouriteCocktails();
        if (favouriteCocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(favouriteCocktails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavouriteCocktail(@PathVariable Long id) {
        service.deleteFavouriteCocktail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
