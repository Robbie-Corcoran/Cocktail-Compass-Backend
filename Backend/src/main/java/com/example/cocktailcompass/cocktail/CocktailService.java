package com.example.cocktailcompass.cocktail;

import com.example.cocktailcompass.cocktail.models.Cocktail;
import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;
import com.example.cocktailcompass.cocktail.repositories.CocktailRepository;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {

    private final FavouriteCocktailRepository favRepo;
    private final CocktailRepository repo;

    @Autowired
    public CocktailService(CocktailRepository repo, FavouriteCocktailRepository favRepo) {
        this.repo = repo;
        this.favRepo = favRepo;
    }

    public List<Cocktail> searchCocktails(String searchQuery) {
        return repo.searchCocktails(searchQuery);
    }

    public List<Cocktail> searchByIngredient(String searchQuery) {
        return repo.searchByIngredient(searchQuery);
    }

    public List<Cocktail> randomCocktail() {
        return repo.randomCocktail();
    }


    public FavouriteCocktail saveFavouriteCocktail(FavouriteCocktail favouriteCocktail) {
        return favRepo.save(favouriteCocktail);
    }

    public List<FavouriteCocktail> getAllFavouriteCocktails() {
        return (List<FavouriteCocktail>) favRepo.findAll();
    }

    public void deleteFavouriteCocktail(Long id) {
        favRepo.deleteById(id);
    }

}
