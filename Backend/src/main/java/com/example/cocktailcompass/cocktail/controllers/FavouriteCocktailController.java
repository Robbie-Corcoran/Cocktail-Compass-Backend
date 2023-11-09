package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cocktails/favourites")
public class FavouriteCocktailController {

    FavouriteCocktailServiceImpl favouriteCocktailService;

    @Autowired
    public FavouriteCocktailController(FavouriteCocktailServiceImpl favouriteCocktailService) {
        this.favouriteCocktailService = favouriteCocktailService;
    }

    @PostMapping
    public ResponseEntity<CocktailDTO> saveFavouriteCocktail(@RequestBody CocktailDTO favouriteCocktail){
        return ResponseEntity.ok(favouriteCocktailService.saveFavouriteCocktail(favouriteCocktail));
    }

    @GetMapping
    public ResponseEntity<List<CocktailDTO>> getAllFavouriteCocktails() {
        List<CocktailDTO> favouriteCocktails = favouriteCocktailService.findAllFavouriteCocktails();

        if (favouriteCocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(favouriteCocktails);
    }

    @DeleteMapping("/{idDrink}")
    public ResponseEntity<String> deleteFavouriteCocktail(@PathVariable int idDrink) {
        favouriteCocktailService.deleteFavouriteCocktail(idDrink);
        return ResponseEntity.ok("Favourite successfully deleted");
    }
}
