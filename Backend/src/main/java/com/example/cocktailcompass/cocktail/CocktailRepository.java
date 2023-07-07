package com.example.cocktailcompass.cocktail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class CocktailRepository implements ICocktailRepository {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/" ;

    @Autowired
    public CocktailRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Cocktail> searchCocktails(String searchQuery) {
        String apiUrl = BASE_URL + "search.php?s=" + searchQuery;
        CocktailResponse response = restTemplate.getForObject(apiUrl, CocktailResponse.class);
        assert response != null;
        return response.getCocktails();
    }

    public List<Cocktail> searchByIngredient(String searchQuery) {
        String apiIngredientUrl = BASE_URL + "filter.php?i=" + searchQuery;
        CocktailResponse response = restTemplate.getForObject(apiIngredientUrl, CocktailResponse.class);
        assert response != null;
        return response.getCocktails();
    }

    public List<Cocktail> randomCocktail() {
        String apiRandomUrl = BASE_URL + "random.php";
        CocktailResponse response = restTemplate.getForObject(apiRandomUrl, CocktailResponse.class);
        assert response != null;
        return response.getCocktails();
    }
}
