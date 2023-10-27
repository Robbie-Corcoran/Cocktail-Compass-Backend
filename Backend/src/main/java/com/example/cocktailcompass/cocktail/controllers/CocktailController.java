package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import com.example.cocktailcompass.cocktail.models.OldCocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/cocktails")
public class CocktailController {

    private final CocktailService service;

    @Autowired
    public CocktailController(CocktailService cocktailService) {
        this.service = cocktailService;
    }

    @GetMapping("/{searchQuery}")
    public ResponseEntity<List<OldCocktail>> searchCocktails(@PathVariable String searchQuery){
       List<OldCocktail> oldCocktails = service.searchCocktails(searchQuery);
        if (oldCocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(oldCocktails);
    }

    @GetMapping("/ingredients/{searchQuery}")
    public ResponseEntity<List<OldCocktail>> searchCocktailsByIngredient(@PathVariable String searchQuery){
        List<OldCocktail> oldCocktails = service.searchByIngredient(searchQuery);
        if (oldCocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oldCocktails);
    }

    @GetMapping("/random")
    public ResponseEntity<List<OldCocktail>> randomCocktail(){
        List<OldCocktail> oldCocktail = service.randomCocktail();
        if (oldCocktail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(oldCocktail);
    }
}
