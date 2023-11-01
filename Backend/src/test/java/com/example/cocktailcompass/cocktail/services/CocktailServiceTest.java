package com.example.cocktailcompass.cocktail.services;


import com.example.cocktailcompass.cocktail.models.CocktailListResponse;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CocktailServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CocktailService cocktailService;

    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";


    @Test
    @DisplayName("searchCocktailsByName() returns a list of cocktails when API returns a response.")
    void testSearchCocktailsByName_whenApiReturnsResponse_returnCocktailList() {
        // Arrange
        CocktailDTO mojitoDTO = new CocktailDTO();
        mojitoDTO.setIdDrink(11000);
        mojitoDTO.setStrDrink("Mojito");

        CocktailListResponse cocktailListResponse = new CocktailListResponse();
        cocktailListResponse.setCocktails(Collections.singletonList(mojitoDTO));

        when(restTemplate.getForObject(BASE_URL + "search.php?s=" + "mojito", CocktailListResponse.class)).thenReturn(cocktailListResponse);


        // Act
        List<CocktailDTO> cocktails = cocktailService.searchCocktailsByName("mojito");

        // Assert
        assertEquals(1, cocktails.size());
        assertEquals(mojitoDTO.getStrDrink(), cocktails.get(0).getStrDrink());
    }
}

