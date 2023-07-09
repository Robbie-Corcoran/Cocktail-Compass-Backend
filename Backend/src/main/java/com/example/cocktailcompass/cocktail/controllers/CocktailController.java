package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.CocktailService;
import com.example.cocktailcompass.cocktail.models.Cocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Cocktail>> searchCocktails(@PathVariable String searchQuery) {
        List<Cocktail> cocktails = service.searchCocktails(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/ingredients/{searchQuery}")
    public ResponseEntity<List<Cocktail>> searchCocktailsByIngredient(@PathVariable String searchQuery) {
        List<Cocktail> cocktails = service.searchByIngredient(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/random")
    public ResponseEntity<List<Cocktail>> randomCocktail() {
        List<Cocktail> cocktail = service.randomCocktail();
        if (cocktail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cocktail);
    }
}
