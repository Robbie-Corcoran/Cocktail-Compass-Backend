package com.example.cocktailcompass.cocktail.services;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.CocktailResponse;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FavouriteCocktailServiceTest {

    @Mock
    FavouriteCocktailRepository favouriteCocktailRepository;

    @InjectMocks
    FavouriteCocktailServiceImpl favouriteCocktailService;

    CocktailDTO cocktailDTO;

    @BeforeEach
    void setup() {
        cocktailDTO = new CocktailDTO();
        cocktailDTO.setIdDrink(999);
        cocktailDTO.setStrDrink("Mojito");
        cocktailDTO.setFavourite(false);
        cocktailDTO.setStrIBA("Contemporary Classics");
        cocktailDTO.setStrGlass("Highball glass");
        cocktailDTO.setStrInstructions("Muddle mint leaves with sugar and lime juice. Add a splash of soda water. Fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.");
        cocktailDTO.setStrDrinkThumb("https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg");
        cocktailDTO.setStrIngredient1("White Rum");
        cocktailDTO.setStrIngredient2("Lime Juice");
        cocktailDTO.setStrIngredient3("Sugar");
        cocktailDTO.setStrMeasure1("2-3 oz");
        cocktailDTO.setStrMeasure2("Juice of 1 Lime");
        cocktailDTO.setStrMeasure3("2 tsp Sugar");
    }

    @Test
    @DisplayName("Cocktail created and details correct.")
    void testSaveFavouriteCocktail_whenCocktailDetailsProvided_returnCocktailObjectAndDetails() throws FavouriteCocktailServiceException {
//        Arrange & Act
        CocktailDTO cocktailFromService = favouriteCocktailService.saveFavouriteCocktail(cocktailDTO);

//        Assert
        assertNotNull(cocktailFromService, "returned CocktailDTO should not be null");
        assertEquals(cocktailDTO.getIdDrink(), cocktailFromService.getIdDrink(), "Returned CocktailDTO should have the idDrink: 999.");
        assertEquals(cocktailDTO.getStrDrink(), cocktailFromService.getStrDrink(), "Returned CocktailDTO should have the name: Mocktail.");
        assertTrue(cocktailFromService.isFavourite(), "Returned CocktailDTO should have isFavourite set to true");
        assertEquals(cocktailDTO.getStrIBA(), cocktailFromService.getStrIBA(), "Returned CocktailDTO should have the strIBA: Contemporary Classics");

    }
}
