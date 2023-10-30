package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.CocktailResponse;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CocktailService {

    private final FavouriteCocktailRepository favRepo;
    private final RestTemplate restTemplate;

    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/" ;


    @Autowired
    public CocktailService(RestTemplate restTemplate, FavouriteCocktailRepository favRepo) {
        this.favRepo = favRepo;
        this.restTemplate = restTemplate;
    }

    public List<CocktailEntity> searchCocktailsByName(String searchQuery) {
        String apiUrl = BASE_URL + "search.php?s=" + searchQuery;
        CocktailResponse cocktailResponse = restTemplate.getForObject(apiUrl, CocktailResponse.class);

        if (cocktailResponse != null) {
            return cocktailResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }
    }

    public List<CocktailEntity> searchCocktailsByIngredient(String searchQuery) {
        String apiIngredientUrl = BASE_URL + "filter.php?i=" + searchQuery;
        CocktailResponse cocktailResponse = restTemplate.getForObject(apiIngredientUrl, CocktailResponse.class);

        if (cocktailResponse != null) {
            return cocktailResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }}

    public List<CocktailEntity> randomCocktail(){
        String apiRandomUrl = BASE_URL + "random.php";
        CocktailResponse cocktailResponse = restTemplate.getForObject(apiRandomUrl, CocktailResponse.class);

        if (cocktailResponse != null) {
            return cocktailResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }
    }
}
