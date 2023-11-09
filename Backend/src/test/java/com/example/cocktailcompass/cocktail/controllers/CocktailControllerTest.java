package com.example.cocktailcompass.cocktail.controllers;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import com.example.cocktailcompass.cocktail.sevices.CocktailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CocktailController.class)
@MockBean({CocktailService.class})
public class CocktailControllerTest {

    private final String REQUEST_BUILDER_URI = "/api/cocktails/";

    @Autowired
    CocktailService cocktailService;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("Mojito can be found when searching.")
    public void testSearchCocktails_whenValidSearchQuery_returnsOk() throws Exception {
//        Arrange
        List<CocktailDTO> cocktails = new ArrayList<>();
        cocktails.add(mojitoDTO);

        when(cocktailService.searchCocktailsByName("Mojito")).thenReturn(cocktails);

        TypeReference<List<CocktailDTO>> typeRef = new TypeReference<>() {};

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_BUILDER_URI + "Mojito")).andReturn();

        List<CocktailDTO> resultCocktails = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), typeRef);

//        Assert
        assertEquals(
                HttpStatus.OK.value(),
                mvcResult.getResponse().getStatus(),
                "Incorrect Response Status"
        );

        assertEquals(
                1,
                resultCocktails.size(),
                "Incorrect list size"
        );

        assertEquals(
                11000,
                resultCocktails.get(0).getIdDrink(),
                "Incorrect idDrink"
        );

        assertEquals(
                "Mojito",
                resultCocktails.get(0).getStrDrink(),
                "Incorrect strDrink"
        );
    }

    @Test
    @DisplayName("404 response when searching invalid name.")
    public void testSearchCocktails_whenInvalidSearchQuery_returnsNotFound() throws Exception {
//        Arrange
        when(cocktailService.searchCocktailsByName("Invalid")).thenReturn(new ArrayList<>());

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_BUILDER_URI + "Invalid")).andReturn();

//        Assert
        assertEquals(
                HttpStatus.NOT_FOUND.value(),
                mvcResult.getResponse().getStatus(),
                "Incorrect Response Status"
        );
    }

    @Test
    @DisplayName("Rum can be found when searching.")
    public void testSearchCocktailsByIngredient_whenValidSearchQuery_returnsOk() throws Exception {
//        Arrange
        List<CocktailDTO> cocktails = new ArrayList<>();
        cocktails.add(mojitoDTO);

        when(cocktailService.searchCocktailsByIngredient("Rum")).thenReturn(cocktails);

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_BUILDER_URI + "ingredients/Rum")).andReturn();
        TypeReference<List<CocktailDTO>> typeRef = new TypeReference<>() {};

        List<CocktailDTO> resultCocktails = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), typeRef);

//        Assert
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus(), "Incorrect Response Status");
        assertEquals(1, resultCocktails.size(), "Incorrect list size");
        assertEquals(11000, resultCocktails.get(0).getIdDrink(), "Incorrect idDrink");
        assertEquals("Mojito", resultCocktails.get(0).getStrDrink(), "Incorrect strDrink");
    }

    @Test
    @DisplayName("404 response when searching invalid ingredient.")
    public void testSearchCocktailsByIngredient_whenInvalidSearchQuery_returnsNotFound() throws Exception {
//        Arrange
        when(cocktailService.searchCocktailsByIngredient("Invalid")).thenReturn(new ArrayList<>());

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_BUILDER_URI + "ingredients/Invalid")).andReturn();

//        Assert
        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus(), "Incorrect Response Status");
    }


    @Test
    @DisplayName("Random cocktail can be found.")
    public void testRandomCocktail_whenCocktailAvailable_returnsOk() throws Exception {
//        Arrange
        List<CocktailDTO> cocktail = new ArrayList<>();
        cocktail.add(mojitoDTO);

        when(cocktailService.randomCocktail()).thenReturn(cocktail);

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_BUILDER_URI + "random")).andReturn();
        TypeReference<List<CocktailDTO>> typeRef = new TypeReference<>() {};
        List<CocktailDTO> resultCocktail = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), typeRef);

//        Assert
        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus(), "Incorrect Response Status");
        assertEquals(1, resultCocktail.size(), "Incorrect list size");
        assertEquals(11000, resultCocktail.get(0).getIdDrink(), "Incorrect idDrink");
        assertEquals("Mojito", resultCocktail.get(0).getStrDrink(), "Incorrect strDrink");
    }

    @Test
    @DisplayName("204 response when random cocktail cant be found.")
    public void testRandomCocktail_whenNoCocktailAvailable_returnsNoContent() throws Exception {
//        Arrange
        when(cocktailService.randomCocktail()).thenReturn(null);

//        Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/cocktails/random")).andReturn();
        String content = mvcResult.getResponse().getContentAsString();

//        Assert
        assertEquals(HttpStatus.NO_CONTENT.value(), mvcResult.getResponse().getStatus(), "Incorrect Response Status");
        assertTrue(content.isEmpty(), "Response body should be empty");
    }

}

