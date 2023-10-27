package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.CocktailResponse;
import com.example.cocktailcompass.cocktail.repositories.CocktailRepository;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CocktailService {

    private final FavouriteCocktailRepository favRepo;
    private final CocktailRepository repo;

    private final RestTemplate restTemplate;

    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/" ;


    @Autowired
    public CocktailService(CocktailRepository repo, RestTemplate restTemplate, FavouriteCocktailRepository favRepo) {
        this.repo = repo;
        this.favRepo = favRepo;
        this.restTemplate = restTemplate;
    }

    public List<CocktailEntity> searchCocktails(String searchQuery) {
        String apiUrl = BASE_URL + "search.php?s=" + searchQuery;
        return Collections.singletonList(restTemplate.getForObject(apiUrl, CocktailEntity.class));
    }

    public List<CocktailEntity> searchByIngredient(String searchQuery) {
        return repo.searchByIngredient(searchQuery);
    }

    public List<CocktailEntity> randomCocktail(){
        return repo.randomCocktail();
    }


    public CocktailEntity saveFavouriteCocktail(CocktailEntity favouriteCocktail) {
        return favRepo.save(favouriteCocktail);
    }

    public List<CocktailEntity> getAllFavouriteCocktails() {
        return (List<CocktailEntity>) favRepo.findAll();
    }

    public void deleteFavouriteCocktail(Long id) {
        favRepo.deleteById(id);
    }

}
