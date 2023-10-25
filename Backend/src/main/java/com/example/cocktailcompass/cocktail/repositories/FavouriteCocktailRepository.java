package com.example.cocktailcompass.cocktail.repositories;

import com.example.cocktailcompass.cocktail.models.FavouriteCocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteCocktailRepository extends JpaRepository<FavouriteCocktail, Long> {
    boolean existsByIdDrink(int idDrink);
}
