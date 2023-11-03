package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailService;
import com.example.cocktailcompass.cocktail.sevices.FavouriteCocktailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = FavouriteCocktailController.class)
@MockBean({FavouriteCocktailServiceImpl.class})
public class FavouriteCocktailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    FavouriteCocktailService favouriteCocktailService;

    private String requestBuilderURI = "/api/cocktails/favourites";

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
    @DisplayName("FavouriteCocktail can be created.")
    void testSaveFavouriteCocktail_whenValidCocktailDetailsProvided_returnsCreatedCocktailDetails() throws Exception {
//        Arrange
        when(favouriteCocktailService.saveFavouriteCocktail(any(CocktailDTO.class))).thenReturn(mojitoDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(requestBuilderURI)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(mojitoDTO));
//        Act
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String responseBodyAsString = mvcResult.getResponse().getContentAsString();

        CocktailDTO createdCocktail = new ObjectMapper().readValue(responseBodyAsString, CocktailDTO.class);

//        Assert
        assertEquals(
                mojitoDTO.getStrDrink(),
                createdCocktail.getStrDrink(),
                "The returned cocktail's name is incorrect."
        );

        assertEquals(
                mojitoDTO.getIdDrink(),
                createdCocktail.getIdDrink(),
                "The returned cocktail's id is incorrect."
        );

        assertNotNull(
                createdCocktail.getIdDrink(),
                "User ID is null."
        );

    }
}
