package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.CocktailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteCocktailRepository extends JpaRepository<CocktailEntity, Long> {
    boolean existsByIdDrink(int idDrink);
}
