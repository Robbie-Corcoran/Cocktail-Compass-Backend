package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteCocktailRepository extends JpaRepository<CocktailEntity, Integer> {
    boolean existsByIdDrink(int idDrink);

    CocktailEntity save(CocktailEntity cocktailEntity);

    List<CocktailEntity> findAll();

    void deleteById(Integer idDrink);
}
