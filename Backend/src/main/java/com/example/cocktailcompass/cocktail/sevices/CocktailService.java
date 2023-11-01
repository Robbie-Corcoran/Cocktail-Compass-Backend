package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.CocktailListResponse;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class CocktailService {

    private final RestTemplate restTemplate;

    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";


    @Autowired
    public CocktailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CocktailDTO> searchCocktailsByName(String searchQuery) {
        String apiUrl = BASE_URL + "search.php?s=" + searchQuery;
        CocktailListResponse cocktailListResponse = restTemplate.getForObject(apiUrl, CocktailListResponse.class);

        if (cocktailListResponse != null) {
            return cocktailListResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }
    }

    public List<CocktailDTO> searchCocktailsByIngredient(String searchQuery) {
        String apiIngredientUrl = BASE_URL + "filter.php?i=" + searchQuery;
        CocktailListResponse cocktailListResponse = restTemplate.getForObject(apiIngredientUrl, CocktailListResponse.class);

        if (cocktailListResponse != null) {
            return cocktailListResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }
    }

    public List<CocktailDTO> randomCocktail() {
        String apiRandomUrl = BASE_URL + "random.php";
        CocktailListResponse cocktailListResponse = restTemplate.getForObject(apiRandomUrl, CocktailListResponse.class);

        if (cocktailListResponse != null) {
            return cocktailListResponse.getCocktails();
        } else {
            return Collections.emptyList();
        }
    }
}
