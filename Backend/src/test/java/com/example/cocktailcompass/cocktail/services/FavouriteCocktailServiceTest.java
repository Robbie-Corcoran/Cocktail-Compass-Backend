package com.example.cocktailcompass.cocktail.services;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailServiceException;
import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.repositories.FavouriteCocktailRepository;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        cocktailDTO.setIdDrink(11000);
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


    @Test
    @DisplayName("saveFavouriteCocktail() throws exception if idDrink exists in repo already.")
    void testSaveFavouriteCocktail_whenExistingCocktailIdProvided_throwException() {
//        Arrange
        when(favouriteCocktailRepository.existsByIdDrink(cocktailDTO.getIdDrink())).thenReturn(true);

//        Act & Assert
        assertThrows(FavouriteCocktailServiceException.class, () -> favouriteCocktailService.saveFavouriteCocktail(cocktailDTO), "saveFavouriteCocktail should throw exception");
        verify(favouriteCocktailRepository, never()).save(any(CocktailEntity.class));
    }

    @Test
    @DisplayName("Returns a list of favourite cocktails.")
    void testFindAllFavouriteCocktails_whenGivenCocktailList_returnFavouriteCocktailList() {
//        Arrange
        CocktailDTO cocktailDTO1 = new CocktailDTO();
        cocktailDTO1.setIdDrink(11007);
        cocktailDTO1.setStrDrink("Margarita");
        cocktailDTO1.setFavourite(false);
        cocktailDTO1.setStrIBA("Contemporary Classics");
        cocktailDTO1.setStrGlass("Cocktail glass");
        cocktailDTO1.setStrInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.");
        cocktailDTO1.setStrDrinkThumb("https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg");
        cocktailDTO1.setStrIngredient1("Tequila");
        cocktailDTO1.setStrIngredient2("Triple sec");
        cocktailDTO1.setStrIngredient3("Lime juice");
        cocktailDTO1.setStrMeasure1("1 1/2 oz");
        cocktailDTO1.setStrMeasure2("1/2 oz");
        cocktailDTO1.setStrMeasure3("1 oz");

        ModelMapper modelMapper = new ModelMapper();
        CocktailEntity savedCocktail = modelMapper.map(cocktailDTO, CocktailEntity.class);
        CocktailEntity savedCocktail1 = modelMapper.map(cocktailDTO1, CocktailEntity.class);

        List<CocktailEntity> cocktailEntitiesList = Arrays.asList(savedCocktail, savedCocktail1);

        when(favouriteCocktailRepository.findAll()).thenReturn(cocktailEntitiesList);

//        Act
        List<CocktailDTO> cocktailsFromService = favouriteCocktailService.findAllFavouriteCocktails();

//        Assert
        assertEquals(2, cocktailsFromService.size(), "cocktailsFromService should have a size of 2.");
        assertEquals(cocktailDTO.getIdDrink(), cocktailsFromService.get(0).getIdDrink(), "cocktailDTO should have the idDrink: 11000");
        assertEquals(cocktailDTO.getStrDrink(), cocktailsFromService.get(0).getStrDrink(), "cocktailDTO should have the strDrink: Mojito");
        assertEquals(cocktailDTO1.getIdDrink(), cocktailsFromService.get(1).getIdDrink(), "cocktailDTO1 should have the idDrink: 11007");
        assertEquals(cocktailDTO1.getStrDrink(), cocktailsFromService.get(1).getStrDrink(), "cocktailDTO1 should have the strDrink: Margarita");
    }
}
