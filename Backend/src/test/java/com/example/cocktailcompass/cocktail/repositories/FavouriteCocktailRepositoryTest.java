package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class FavouriteCocktailRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    FavouriteCocktailRepository favouriteCocktailRepository;

    CocktailDTO cocktailDTO;
    CocktailEntity cocktailEntity;

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
        cocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);
    }

    @Test
    @Order(1)
    @DisplayName("save() correctly saves a FavouriteCocktail")
    void testFavouriteCocktailRepo_whenCocktailDTOIsProvided_successfullySavesFavouriteCocktail(){
//        Arrange & Act
        testEntityManager.persistAndFlush(cocktailEntity);
        CocktailEntity storedFavouriteCocktail = cocktailEntity;

        favouriteCocktailRepository.save(cocktailEntity);

//        Assert
        assertEquals(
                storedFavouriteCocktail.getIdDrink(),
                cocktailDTO.getIdDrink(),
                "Saved favouriteCocktail's Id is incorrect.");
    }

    @Test
    @Order(2)
    @DisplayName("findAll()")
    void testFavouriteCocktailRepo_whenFindAllIsCalled_shouldReturnThreeCocktails() {
//        Arrange
        CocktailDTO cocktailDTOTwo = new CocktailDTO();
        cocktailDTOTwo.setIdDrink(23456);
        cocktailDTOTwo.setStrDrink("Mocktail 2");
        cocktailDTOTwo.setFavourite(true);
        cocktailDTOTwo.setStrIBA("Mock Classics");
        cocktailDTOTwo.setStrGlass("Mocktail glass");
        cocktailDTOTwo.setStrInstructions("Mix all mock ingredients together, serve chilled.");
        cocktailDTOTwo.setStrDrinkThumb("https://mock-url.com/drink.jpg");
        cocktailDTOTwo.setStrIngredient1("Mock Ingredient 1");
        cocktailDTOTwo.setStrIngredient2("Mock Ingredient 2");
        cocktailDTOTwo.setStrIngredient3("Mock Ingredient 3");
        cocktailDTOTwo.setStrMeasure1("1 Mock Unit");
        cocktailDTOTwo.setStrMeasure2("2 Mock Units");
        cocktailDTOTwo.setStrMeasure3("3 Mock Units");

        ModelMapper modelMapper = new ModelMapper();
        CocktailEntity cocktailEntityTwo = modelMapper.map(cocktailDTOTwo, CocktailEntity.class);

//        Act
        favouriteCocktailRepository.save(cocktailEntity);
        favouriteCocktailRepository.save(cocktailEntityTwo);
        List<CocktailEntity> savedFavouriteCocktails = favouriteCocktailRepository.findAll();


//        Assert
        assertEquals(
                2,
                savedFavouriteCocktails.size(),
                "Returned list should contain 2 CocktailEntities."
        );
    }
}
