package com.example.cocktailcompass.cocktail.models;


import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CocktailEntityTest {

    CocktailDTO cocktailDTO;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setup() {
        cocktailDTO = new CocktailDTO();
        cocktailDTO.setIdDrink(12345);
        cocktailDTO.setStrDrink("Mocktail");
        cocktailDTO.setFavourite(true);
        cocktailDTO.setStrIBA("Mock Classics");
        cocktailDTO.setStrGlass("Mocktail glass");
        cocktailDTO.setStrInstructions("Mix all mock ingredients together, serve chilled.");
        cocktailDTO.setStrDrinkThumb("https://mock-url.com/drink.jpg");
        cocktailDTO.setStrIngredient1("Mock Ingredient 1");
        cocktailDTO.setStrIngredient2("Mock Ingredient 2");
        cocktailDTO.setStrIngredient3("Mock Ingredient 3");
        cocktailDTO.setStrMeasure1("1 Mock Unit");
        cocktailDTO.setStrMeasure2("2 Mock Units");
        cocktailDTO.setStrMeasure3("3 Mock Units");
    }

    @Test
    @DisplayName("CocktailEntity is created when mapped from CocktailDTO")
    void testCocktailEntity_whenValidCocktailDTOIsConverted_shouldReturnStoredCocktailDetails() {
//        Arrange & Act
        ModelMapper modelMapper = new ModelMapper();
        CocktailEntity cocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);

//        Assert
        assertEquals(
                cocktailDTO.getIdDrink(),
                cocktailEntity.getIdDrink(),
                "Returned idDrink is incorrect");

        assertEquals(
                cocktailDTO.getStrDrink(),
                cocktailEntity.getStrDrink(),
                "Returned strDrink is incorrect");

        assertEquals(
                cocktailDTO.getStrDrinkThumb(),
                cocktailEntity.getStrDrinkThumb(),
                "Returned strDrinkThumb is incorrect");

        assertEquals(
                cocktailDTO.getStrInstructions(),
                cocktailEntity.getStrInstructions(),
                "Returned strInstructions are incorrect");

        assertNotNull(
                cocktailEntity.getIdDrink(),
                "idDrink should not be null");

        assertNotNull(
                cocktailEntity.getStrDrink(),
                "strDrink should not be null");
    }

    @Test
    @DisplayName("Two Entities cannot have the same id.")
    void testCocktailEntity_whenIdIsNotUnique_shouldThrowException() {
//        Arrange
        ModelMapper modelMapper = new ModelMapper();
        CocktailEntity cocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);
        CocktailEntity duplicateCocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);

        testEntityManager.persistAndFlush(cocktailEntity);

//        Act & Assert
        assertThrows(
                PersistenceException.class,
                () -> testEntityManager.persistAndFlush(duplicateCocktailEntity),
                "Should have thrown Exception");
    }
}
