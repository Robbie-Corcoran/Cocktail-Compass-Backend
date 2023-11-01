package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
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
    public ResponseEntity<List<CocktailDTO>> searchCocktails(@PathVariable String searchQuery) {
        List<CocktailDTO> cocktails = service.searchCocktailsByName(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/ingredients/{searchQuery}")
    public ResponseEntity<List<CocktailDTO>> searchCocktailsByIngredient(@PathVariable String searchQuery) {
        List<CocktailDTO> cocktails = service.searchCocktailsByIngredient(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/random")
    public ResponseEntity<List<CocktailDTO>> randomCocktail() {
        List<CocktailDTO> cocktail = service.randomCocktail();
        if (cocktail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cocktail);
    }
}
