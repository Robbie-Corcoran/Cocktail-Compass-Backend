package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails/favourites")
public class FavouriteCocktailController {

    CocktailService cocktailService;
    FavouriteCocktailServiceImpl favouriteCocktailService;

    @Autowired
    public FavouriteCocktailController(CocktailService cocktailService, FavouriteCocktailServiceImpl favouriteCocktailService) {
        this.cocktailService = cocktailService;
        this.favouriteCocktailService = favouriteCocktailService;
    }

    @PostMapping
    public ResponseEntity<CocktailDTO> saveFavouriteCocktail(@RequestBody CocktailDTO favouriteCocktail) throws FavouriteCocktailServiceException {
        return new ResponseEntity<>(favouriteCocktailService.saveFavouriteCocktail(favouriteCocktail), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CocktailDTO>> getAllFavouriteCocktails() {
        List<CocktailDTO> favouriteCocktails = favouriteCocktailService.findAllFavouriteCocktails();

        if (favouriteCocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(favouriteCocktails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavouriteCocktail(@PathVariable Integer idDrink) {
        favouriteCocktailService.deleteFavouriteCocktail(idDrink);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
