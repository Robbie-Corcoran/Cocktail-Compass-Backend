package com.example.cocktailcompass.cocktail.services;

import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailAlreadyExistsException;
import com.example.cocktailcompass.cocktail.exceptions.FavouriteCocktailNotFoundException;
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
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FavouriteCocktailServiceTest {

    @Mock
    FavouriteCocktailRepository favouriteCocktailRepository;

    @InjectMocks
    FavouriteCocktailServiceImpl favouriteCocktailService;

    CocktailDTO mojitoDTO;
    CocktailEntity mojitoEntity;
    CocktailDTO margaritaDTO;
    CocktailEntity margaritaEntity;

    @BeforeEach
    void setup() {
        mojitoDTO = new CocktailDTO();
        mojitoDTO.setIdDrink(11000);
        mojitoDTO.setStrDrink("Mojito");
        mojitoDTO.setFavourite(false);
        mojitoDTO.setStrIBA("Contemporary Classics");
        mojitoDTO.setStrGlass("Highball glass");
        mojitoDTO.setStrInstructions("Muddle mint leaves with sugar and lime juice. Add a splash of soda water. Fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.");
        mojitoDTO.setStrDrinkThumb("https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg");
        mojitoDTO.setStrIngredient1("White Rum");
        mojitoDTO.setStrIngredient2("Lime Juice");
        mojitoDTO.setStrIngredient3("Sugar");
        mojitoDTO.setStrMeasure1("2-3 oz");
        mojitoDTO.setStrMeasure2("Juice of 1 Lime");
        mojitoDTO.setStrMeasure3("2 tsp Sugar");

        margaritaDTO = new CocktailDTO();
        margaritaDTO.setIdDrink(11007);
        margaritaDTO.setStrDrink("Margarita");
        margaritaDTO.setFavourite(false);
        margaritaDTO.setStrIBA("Contemporary Classics");
        margaritaDTO.setStrGlass("Cocktail glass");
        margaritaDTO.setStrInstructions("Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.");
        margaritaDTO.setStrDrinkThumb("https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg");
        margaritaDTO.setStrIngredient1("Tequila");
        margaritaDTO.setStrIngredient2("Triple sec");
        margaritaDTO.setStrIngredient3("Lime juice");
        margaritaDTO.setStrMeasure1("1 1/2 oz");
        margaritaDTO.setStrMeasure2("1/2 oz");
        margaritaDTO.setStrMeasure3("1 oz");

        ModelMapper modelMapper = new ModelMapper();
        mojitoEntity = modelMapper.map(mojitoDTO, CocktailEntity.class);
        margaritaEntity = modelMapper.map(margaritaDTO, CocktailEntity.class);
    }

    @Test
    @DisplayName("Cocktail created and details correct.")
    void testSaveFavouriteCocktail_whenCocktailDetailsProvided_returnCocktailObjectAndDetails() {
//        Arrange & Act
        CocktailDTO cocktailFromService = favouriteCocktailService.saveFavouriteCocktail(mojitoDTO);

//        Assert
        assertNotNull(cocktailFromService, "returned CocktailDTO should not be null");
        assertEquals(mojitoDTO.getIdDrink(), cocktailFromService.getIdDrink(), "Returned CocktailDTO should have the idDrink: 999.");
        assertEquals(mojitoDTO.getStrDrink(), cocktailFromService.getStrDrink(), "Returned CocktailDTO should have the name: Mocktail.");
        assertTrue(cocktailFromService.isFavourite(), "Returned CocktailDTO should have isFavourite set to true");
        assertEquals(mojitoDTO.getStrIBA(), cocktailFromService.getStrIBA(), "Returned CocktailDTO should have the strIBA: Contemporary Classics");
    }


    @Test
    @DisplayName("saveFavouriteCocktail() throws exception if idDrink exists in repo already.")
    void testSaveFavouriteCocktail_whenExistingCocktailIdProvided_throwException() throws FavouriteCocktailAlreadyExistsException {
//        Arrange
        when(favouriteCocktailRepository.existsByIdDrink(mojitoDTO.getIdDrink())).thenReturn(true);

//        Act & Assert
        assertThrows(FavouriteCocktailAlreadyExistsException.class, () -> favouriteCocktailService.saveFavouriteCocktail(mojitoDTO), "saveFavouriteCocktail should throw exception");
        verify(favouriteCocktailRepository, never()).save(any(CocktailEntity.class));
    }

    @Test
    @DisplayName("Returns a list of favourite cocktails.")
    void testFindAllFavouriteCocktails_whenGivenCocktailList_returnFavouriteCocktailList() {
//        Arrange
        List<CocktailEntity> cocktailEntitiesList = Arrays.asList(mojitoEntity, margaritaEntity);

        when(favouriteCocktailRepository.findAll()).thenReturn(cocktailEntitiesList);

//        Act
        List<CocktailDTO> cocktailsFromService = favouriteCocktailService.findAllFavouriteCocktails();

//        Assert
        assertEquals(2, cocktailsFromService.size(), "cocktailsFromService should have a size of 2.");
        assertEquals(mojitoDTO.getIdDrink(), cocktailsFromService.get(0).getIdDrink(), "cocktailDTO should have the idDrink: 11000");
        assertEquals(mojitoDTO.getStrDrink(), cocktailsFromService.get(0).getStrDrink(), "cocktailDTO should have the strDrink: Mojito");
        assertEquals(margaritaDTO.getIdDrink(), cocktailsFromService.get(1).getIdDrink(), "cocktailDTO1 should have the idDrink: 11007");
        assertEquals(margaritaDTO.getStrDrink(), cocktailsFromService.get(1).getStrDrink(), "cocktailDTO1 should have the strDrink: Margarita");

        verify(favouriteCocktailRepository, never()).save(any(CocktailEntity.class));
    }

    @Test
    @DisplayName("findAllFavouriteCocktails() throws exception if no cocktails exist in repo.")
    void testFindAllFavouriteCocktails_whenListIsEmpty_throwsException() throws FavouriteCocktailNotFoundException {
//        Arrange
        when(favouriteCocktailRepository.findAll()).thenReturn(Collections.emptyList());

//        Act & Assert
        assertThrows(FavouriteCocktailNotFoundException.class, () -> favouriteCocktailService.findAllFavouriteCocktails());
    }

    @Test
    @DisplayName("deleteFavouriteCocktail() successfully deletes cocktail from repo when idDrink exists.")
    void testDeleteFavouriteCocktail_whenIdDrinkExists_thenSuccess() {
        // Arrange
        Integer idDrink = mojitoDTO.getIdDrink();
        when(favouriteCocktailRepository.existsByIdDrink(idDrink)).thenReturn(true);

        // Act
        favouriteCocktailService.deleteFavouriteCocktail(idDrink);

        // Assert
        verify(favouriteCocktailRepository).deleteById(idDrink);
    }

    @Test
    @DisplayName("deleteFavouriteCocktail() throws exception when idDrink does not exist in repo.")
    void testDeleteFavouriteCocktail_whenIdDrinkDoesNotExist_throwsException() throws FavouriteCocktailNotFoundException {
        // Arrange
        int idDrink = mojitoDTO.getIdDrink();
        when(favouriteCocktailRepository.existsByIdDrink(idDrink)).thenReturn(false);

        // Act & Assert
        assertThrows(FavouriteCocktailNotFoundException.class,
                () -> favouriteCocktailService.deleteFavouriteCocktail(idDrink));
    }


}
