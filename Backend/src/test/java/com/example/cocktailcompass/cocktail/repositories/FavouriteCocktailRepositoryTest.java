package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FavouriteCocktailRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    FavouriteCocktailRepository favouriteCocktailRepository;

    CocktailDTO cocktailDTO;
    CocktailEntity storedFavouriteCocktail;

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

        ModelMapper modelMapper = new ModelMapper();
        CocktailEntity cocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);

        storedFavouriteCocktail = favouriteCocktailRepository.save(cocktailEntity);
    }

    @Test
    @Order(1)
    @DisplayName("save()")
    void testFavouriteCocktailRepo_whenCocktailDTOIsProvided_successfullySavesFavouriteCocktail(){
//        Act & Assert
        assertEquals(
                storedFavouriteCocktail.getIdDrink(),
                cocktailDTO.getIdDrink(),
                "Saved favouriteCocktail's Id is incorrect.");
    }



}
