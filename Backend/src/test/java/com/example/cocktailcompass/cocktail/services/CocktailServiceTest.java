package com.example.cocktailcompass.cocktail.services;


import com.example.cocktailcompass.cocktail.models.CocktailListResponse;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CocktailServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CocktailService cocktailService;

    CocktailDTO mojitoDTO;

    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    @BeforeEach
    void setup(){
        mojitoDTO = new CocktailDTO();
        mojitoDTO.setIdDrink(11000);
        mojitoDTO.setStrDrink("Mojito");
    }

    @Test
    @DisplayName("searchCocktailsByName() returns a list of cocktails when API returns a response.")
    void testSearchCocktailsByName_whenApiReturnsResponse_returnCocktailList() {
        // Arrange
        CocktailListResponse cocktailListResponse = new CocktailListResponse();
        cocktailListResponse.setCocktails(Collections.singletonList(mojitoDTO));

        when(restTemplate.getForObject(BASE_URL + "search.php?s=" + "mojito", CocktailListResponse.class)).thenReturn(cocktailListResponse);

        // Act
        List<CocktailDTO> cocktails = cocktailService.searchCocktailsByName("mojito");

        // Assert
        assertEquals(mojitoDTO.getStrDrink(), cocktails.get(0).getStrDrink());
    }

    @Test
    @DisplayName("searchCocktailsByIngredient() returns a list of cocktails when API returns a response.")
    void testSearchCocktailsByIngredient_whenApiReturnsResponse_returnCocktailList() {
//        Arrange
        CocktailListResponse cocktailListResponse = new CocktailListResponse();
        cocktailListResponse.setCocktails(Collections.singletonList(mojitoDTO));

        when(restTemplate.getForObject(BASE_URL + "filter.php?i=" + "dark_rum", CocktailListResponse.class)).thenReturn(cocktailListResponse);

//        Act
        List<CocktailDTO> cocktails = cocktailService.searchCocktailsByIngredient("dark_rum");

//        Assert
        assertEquals(mojitoDTO.getStrDrink(), cocktails.get(0).getStrDrink());
    }

    @Test
    @DisplayName("randomCocktail() returns a list of cocktails when API returns a response.")
    void testRandomCocktail_whenApiReturnsResponse_returnCocktailList() {
//        Arrange
        CocktailListResponse cocktailListResponse = new CocktailListResponse();
        cocktailListResponse.setCocktails(Collections.singletonList(mojitoDTO));

        when(restTemplate.getForObject(BASE_URL + "random.php", CocktailListResponse.class)).thenReturn(cocktailListResponse);

//        Act
        List<CocktailDTO> cocktails = cocktailService.randomCocktail();

//        Assert
        assertNotNull(cocktails, "Returned cocktail should not be null");
        assertEquals(1, cocktails.size(), "Returned cocktailList should have a size of one.");
        assertEquals(mojitoDTO.getStrDrink(), cocktails.get(0).getStrDrink(), "Returned cocktail should be the same as the one set in the test.");
    }
}

