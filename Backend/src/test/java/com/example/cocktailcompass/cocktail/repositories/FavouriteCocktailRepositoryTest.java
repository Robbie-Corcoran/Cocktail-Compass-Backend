package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import com.example.cocktailcompass.cocktail.models.dtos.CocktailDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FavouriteCocktailRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    FavouriteCocktailRepository favouriteCocktailRepository;

    CocktailDTO cocktailDTO;
    CocktailDTO cocktailDTOTwo;

    CocktailEntity cocktailEntity;
    CocktailEntity cocktailEntityTwo;

    @BeforeEach
    void setup() {
        cocktailDTO = new CocktailDTO();
        cocktailDTO.setIdDrink(12345);
        cocktailDTO.setStrDrink("Mocktail");

        cocktailDTOTwo = new CocktailDTO();
        cocktailDTOTwo.setIdDrink(23456);
        cocktailDTOTwo.setStrDrink("Mocktail 2");

        ModelMapper modelMapper = new ModelMapper();
        cocktailEntity = modelMapper.map(cocktailDTO, CocktailEntity.class);
        cocktailEntityTwo = modelMapper.map(cocktailDTOTwo, CocktailEntity.class);

    }

    @AfterEach
    void cleanup() {
        testEntityManager.clear();
    }

    @Test
    @DisplayName("save() correctly saves a FavouriteCocktail")
    void testFavouriteCocktailRepo_whenCocktailDTOIsProvided_successfullySavesFavouriteCocktail() {
//        Arrange
        testEntityManager.persistAndFlush(cocktailEntity);

//        Act
        CocktailEntity storedFavouriteCocktail = favouriteCocktailRepository.save(cocktailEntity);

//        Assert
        assertEquals(
                storedFavouriteCocktail.getIdDrink(),
                cocktailDTO.getIdDrink(),
                "Saved favouriteCocktail's Id is incorrect.");
    }

    @Test
    @DisplayName("findAll()")
    void testFavouriteCocktailRepo_whenFindAllIsCalled_shouldReturnThreeCocktails() {
//        Arrange
        testEntityManager.persistAndFlush(cocktailEntity);
        testEntityManager.persistAndFlush(cocktailEntityTwo);

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

    @Test
    @DisplayName("deleteById()")
    void testFavouriteCocktailRepo_whenDeleteByIdIsCalled_shouldReturnDeleteCocktail() {
//        Arrange
        testEntityManager.persistAndFlush(cocktailEntity);
        testEntityManager.persistAndFlush(cocktailEntityTwo);

//        Act
        favouriteCocktailRepository.save(cocktailEntity);
        favouriteCocktailRepository.save(cocktailEntityTwo);

        favouriteCocktailRepository.deleteById(cocktailEntity.getIdDrink());
        List<CocktailEntity> savedFavouriteCocktails = favouriteCocktailRepository.findAll();

//        Assert
        assertEquals(
                1,
                savedFavouriteCocktails.size(),
                "Returned list should contain 1 CocktailEntity."
        );

    }
}
