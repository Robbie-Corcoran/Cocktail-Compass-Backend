package com.example.cocktailcompass.cocktail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {

    private final CocktailRepository repo;

    @Autowired
    public CocktailService(CocktailRepository repo) {
        this.repo = repo;
    }

    public List<Cocktail> searchCocktails(String searchQuery) {
            return repo.searchCocktails(searchQuery);
    }

    public List<Cocktail> randomCocktail(){
        return repo.randomCocktail();
    }

}
