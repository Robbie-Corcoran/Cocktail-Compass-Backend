package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteCocktailRepository extends JpaRepository<CocktailEntity, Long> {
    boolean existsByIdDrink(int idDrink);

    List<CocktailEntity> findAll();

    CocktailEntity save(CocktailEntity cocktailEntity);
}
