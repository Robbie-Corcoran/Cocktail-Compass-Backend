package com.example.cocktailcompass.cocktail;

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
    public ResponseEntity<List<Cocktail>> searchCocktails(@PathVariable String searchQuery){
       List<Cocktail> cocktails = service.searchCocktails(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
       return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/ingredients/{searchQuery}")
    public ResponseEntity<List<Cocktail>> searchByIngredient(@PathVariable String searchQuery){
        List<Cocktail> cocktails = service.searchCocktails(searchQuery);
        if (cocktails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cocktails);
    }

    @GetMapping("/random")
    public ResponseEntity<List<Cocktail>> randomCocktial(){
        List<Cocktail> cocktail = service.randomCocktail();
        if (cocktail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cocktail);
    }
}
