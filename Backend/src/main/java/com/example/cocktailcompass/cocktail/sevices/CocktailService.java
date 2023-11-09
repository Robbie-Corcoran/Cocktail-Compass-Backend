package com.example.cocktailcompass.cocktail.sevices;

import com.example.cocktailcompass.cocktail.models.dtos.CocktailListResponseDTO;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        return fetchCocktailList(apiUrl);
    }

    public List<CocktailDTO> searchCocktailsByIngredient(String searchQuery) {
        String apiIngredientUrl = BASE_URL + "filter.php?i=" + searchQuery;
        return fetchCocktailList(apiIngredientUrl);
    }

    public List<CocktailDTO> randomCocktail() {
        String apiRandomUrl = BASE_URL + "random.php";
        return fetchCocktailList(apiRandomUrl);
    }

    private List<CocktailDTO> fetchCocktailList(String apiUrl) {
        CocktailListResponseDTO cocktailListResponseDTO = restTemplate.getForObject(apiUrl, CocktailListResponseDTO.class);
        return Optional.ofNullable(cocktailListResponseDTO)
                .map(CocktailListResponseDTO::getCocktails)
                .orElse(Collections.emptyList());
    }
}